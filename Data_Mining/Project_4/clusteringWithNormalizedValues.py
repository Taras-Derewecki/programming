
# coding: utf-8

# In[33]:
print ('\nimporting libraries required')
import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
plt.style.use('ggplot')
from sklearn.cluster import MiniBatchKMeans


# In[20]:
print ('\nreading the dataset')

df_main = pd.read_csv('kddcup.txt')


# In[21]:

# df_main = df_main.head(500)


# In[22]:
print ('\ngetting dummies')
df_main=pd.get_dummies(df_main)


# In[24]:
print ('\ngetting normalized dataset')
df_main_normalized = (df_main - df_main.min())/(df_main.max() - df_main.min())


# In[30]:
print ('\nfilling na values with 0, which can happen if a column is filled with 0 throughout, like in our case num_outbound_cmds.')
print('we are doing this because we know our dataset has no missing values, but while transforming it to normalized form, we might end up with nans.so to avoid them we fill them with 0')
df_main_normalized=df_main_normalized.fillna(0)


# In[34]:
print ('\n\napplying kmeans for k = 1 to 20, to get elbow plot')
cluster_range = range( 1, 21 )
cluster_errors_list = []

for num_clusters in cluster_range:
	
	kmeans = MiniBatchKMeans(init='k-means++', n_clusters=num_clusters,reassignment_ratio=0,batch_size=5000)
	kmeans.fit(df_main_normalized)
	cluster_errors_list.append( kmeans.inertia_ )
	print ('applying for k = ' + str(num_clusters))


# In[35]:

clusters_df = pd.DataFrame( { "num_clusters":cluster_range, "cluster_errors": cluster_errors_list } )


# In[42]:
print ('\n\nplotting elbow plot, showing as well as saving it in the directory as elblow plot.png')
plt.figure(figsize=(12,6))
plt.plot( clusters_df.num_clusters, clusters_df.cluster_errors, marker = "o" )
plt.savefig('elbow plot.png',dpi=1200)
plt.show()
plt.close()


# In[61]:

while True:
	clustersbyuser=int(input('\nEnter the number of clusters required based on the elbow plot :'))
	if clustersbyuser<15 and clustersbyuser>2:
		kmeans = MiniBatchKMeans(init='k-means++', n_clusters=clustersbyuser,reassignment_ratio=0,batch_size=5000)
		kmeans.fit(df_main_normalized)
		break
	else:
		print('invalid input, enter number between 2 and 15 (excluded)')


# In[75]:
print ('\n\nfinding attributes with means > 0.9 for each cluster and saving it in a csv file in same directory as cluster [i].csv')
for i in range(clustersbyuser):
	
	df_temp = pd.DataFrame({'columns':df_main_normalized.columns,'means':kmeans.cluster_centers_[i]}).sort_values('means',ascending=False)
	df_temp = df_temp[df_temp['means']>0.9]
	df_temp.to_csv('cluster ' + str(i) + '.csv',index=False)
	print ('finding for cluster ', i)