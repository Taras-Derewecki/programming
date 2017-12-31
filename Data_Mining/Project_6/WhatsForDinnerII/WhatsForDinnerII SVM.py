# Support Vector Machine Classification
# Made by: Khalid Qubbaj, Taras Derewecki, Raj Zaveri

# Import Libraries
import pandas as pd
import numpy as np
from sklearn.feature_extraction.text import CountVectorizer
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.model_selection import cross_val_score

# Load Data Set
df2 = pd.read_csv("train.csv", index_col="RecipeId")
df2.target = df2.Target.astype('category')

# Load Training Set
dfTrain = pd.read_csv("train.csv", index_col="RecipeId")
trainY = dfTrain.Target.astype('category')
dfTrain = dfTrain.drop(["Target"],axis=1)
df = pd.concat([dfTrain, pd.read_csv("test.csv", index_col="RecipeId")])

# Stemming - Imports punkt
import nltk
from nltk.stem.porter import PorterStemmer
nltk.download('punkt')

def tokenize(text):
    tokens = nltk.word_tokenize(text)
    stems = []
    for item in tokens:
        stems.append(PorterStemmer().stem(item))
    return stems

# Fit Classifier the training data
v = TfidfVectorizer(max_features=1000, tokenizer=tokenize)
df_x = v.fit_transform(dfTrain.Ingredients.values.astype('U')).todense()

#print(v.get_feature_names())

            # INDIAN
# ndx=v.get_feature_names().index("indian")
# df_x[:,ndx] = df_x[:,ndx] * 20
ndx=v.get_feature_names().index("ghee")
df_x[:,ndx] = df_x[:,ndx] * 20
# ndx=v.get_feature_names().index("chutney")
# df_x[:,ndx] = df_x[:,ndx] * 20
# ndx=v.get_feature_names().index('masala')
# df_x[:,ndx] = df_x[:,ndx] * 20
# ndx=v.get_feature_names().index('turmer')
# df_x[:,ndx] = df_x[:,ndx] * 20
# ndx=v.get_feature_names().index("masa")
# df_x[:,ndx] = df_x[:,ndx] * 20

            # FRENCH
ndx=v.get_feature_names().index('french')
df_x[:,ndx] = df_x[:,ndx] * 20
# ndx=v.get_feature_names().index('baguett')
# df_x[:,ndx] = df_x[:,ndx] * 20

            # CHINESE
ndx=v.get_feature_names().index('chines')
df_x[:,ndx] = df_x[:,ndx] * 20
#ndx=v.get_feature_names().index("szechwan")
#df_x[:,ndx] = df_x[:,ndx] * 20

            # GREEK
# ndx=v.get_feature_names().index('greek')
# df_x[:,ndx] = df_x[:,ndx] * 20
ndx=v.get_feature_names().index('feta')
df_x[:,ndx] = df_x[:,ndx] * 20
# ndx=v.get_feature_names().index("yoghurt")
# df_x[:,ndx] = df_x[:,ndx] * 20

            # ITALIAN
ndx=v.get_feature_names().index('italian')
df_x[:,ndx] = df_x[:,ndx] * 20
# ndx=v.get_feature_names().index("bertolli")
# df_x[:,ndx] = df_x[:,ndx] * 20

            # MEXICAN
ndx=v.get_feature_names().index('mexican')
df_x[:,ndx] = df_x[:,ndx] * 20
# ndx=v.get_feature_names().index('salsa')
# df_x[:,ndx] = df_x[:,ndx] * 20
# ndx=v.get_feature_names().index("burrito")
# df_x[:,ndx] = df_x[:,ndx] * 20
#ndx=v.get_feature_names().index("tequila")
#df_x[:,ndx] = df_x[:,ndx] * 20

            # THAI
ndx=v.get_feature_names().index('thai')
df_x[:,ndx] = df_x[:,ndx] * 20

    # OTHERS THAT SEEM TO IMPROVE
# ndx=v.get_feature_names().index("epazot")
# df_x[:,ndx] = df_x[:,ndx] * 20
# ndx=v.get_feature_names().index("haricot")
# df_x[:,ndx] = df_x[:,ndx] * 20


# Import Support Vector Machine
from sklearn.svm import LinearSVC

# Get the Parameter Value
bestParam = None
for param in ["l1", "l2"]:
    svc = LinearSVC(penalty=param, dual=False, C=1.5)
    scores = cross_val_score(svc, df_x, trainY, cv=10)

    print("For param =", param, " mean accuracy accross folds =", scores.mean(), " standard deviation across folds =",
          scores.std())
    if bestParam == None or scores.mean() > bestParamMeanAcc:
        bestParam = param
        bestParamMeanAcc = scores.mean()

print("Best k =", bestParam, "with estimated accuracy of", bestParamMeanAcc)

# Fit data into SVM
svc = LinearSVC(penalty=bestParam, dual=False, C=1.5)
df_x = v.fit_transform(df.Ingredients.values.astype('U')).todense()
trainX = df_x[:len(dfTrain)]
testX = df_x[len(dfTrain):]
svc.fit(trainX,trainY)

# Generate Submission file
predictions = svc.predict(testX)
submissions = pd.read_csv("sampleSubmission.csv", index_col="RecipeId")
submissions.Target = predictions
submissions.to_csv("submission.csv")
