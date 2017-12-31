from __future__ import print_function
import sys

from itertools import chain, combinations
from collections import defaultdict

inputFile = open("freqMovies.txt", "r")

counter = 0;
num_of_customers = 0
minimum_support_threshold = 0.3
minimum_confidence_level = 0.85
num_of_movies_array = []

# sample the dataset

totalSet = dict()
totalDict = {}
totalArray = list()

for line in inputFile.readlines():
    if counter % 20 == 0:
        num_of_customers += 1.0
        transaction = frozenset(line.split())
        totalArray.append(transaction)
        for token in transaction:
            if token not in totalDict:
                totalDict[token] = 0
            totalDict[token] += 1.0
    counter += 1

print('Total number of transactions :- ', num_of_customers)
print('Total number of elements :- ', len(totalDict))

for item in totalDict:
    if float(totalDict[item] / num_of_customers) >= minimum_support_threshold:
        totalSet[frozenset([item])] = float(totalDict[item]) / num_of_customers


# find frequent itemsets
def joinSet(items, sz):
    joinedSet = set()
    for i in items:
        for j in items:
            x = i.union(j)
            if (len(x) == sz):
                joinedSet.add(x)
    return joinedSet


def subsets(itemset):
    return chain(*[combinations(itemset, i + 1) for i, a in enumerate(itemset)])


def ItemsWithMinSupport(items):
    _itemSet = dict()
    countSet = defaultdict(int)

    for i in items:
        for t in totalArray:
            if i.issubset(t):
                countSet[i] += 1

    for item, count in countSet.items():
        supp = float(count) / num_of_customers

        if supp >= minimum_support_threshold:
            _itemSet[item] = supp

    return _itemSet


def findMaximalFrequent(Lsets, sz):
    count = 0
    for i in Lsets.keys():
        if len(i)==(sz+1):
            flag = True
            for j in Lsets.keys():
                if len(j)==(sz+2):
                    if (i.issubset(j)):
                        flag = False
            if flag:
                count += 1
    print(count, ' Maximal frequent itemsets found of size ', sz + 1)


def apriori():
    Lsets = dict()

    currLSet = totalSet
    Lsets.update(currLSet)
    print(len(currLSet), ' frequent itemsets found of size ', 1)
    k = 2
    while (k != 4):
        currLSet = joinSet(currLSet, k)
        currCSet = ItemsWithMinSupport(currLSet)
        currLSet = currCSet
        Lsets.update(currLSet)
        print(len(currLSet), ' frequent itemsets found of size ', k)
        findMaximalFrequent(Lsets, k-2) # potentially comment out
        k += 1

    # import pickle
    # print('Saving Itemsets as Pickle')
    # with open('itemsets.pkl', 'wb') as f:
    # 	pickle.dump(Lsets, f)

    # count = 1
    # for itemsets in Lsets.keys():
    # 	print('Size:- ',count,' Count:- ',len(itemsets))
    # 	count += 1

    # Association rules
    rules = list()
    for item, support in Lsets.items():
        if len(item) > 1:
            for A in subsets(item):
                B = item.difference(A)
                if B:
                    A = frozenset(A)
                    AB = A | B
                    confidence = float(Lsets[AB]) / Lsets[A]
                    if confidence >= minimum_confidence_level:
                        if len(A) == 1 and len(B) == 1:
                            rules.append((A, B, confidence))

    movie_dict = {}
    with open("movies.txt") as f:
        for line in f:
            (key, year, val) = line.split()
            movie_dict[key] = val
    count = 1
    for rule in rules:
        print('Rule {}: {} ==> {} : Confidence:{}'.format(count, movie_dict[list(rule[0])[0]], movie_dict[list(rule[1])[0]],
                                                       rule[2]))
        count = count + 1


apriori()