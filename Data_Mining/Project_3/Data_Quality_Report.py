# In[164]:

import numpy as np
import pandas as pd
import matplotlib.pyplot as plt

plt.style.use('ggplot')

# In[165]:
print
'reading kddcup dataset'
df_main = pd.read_csv('kddcup.txt')

# In[166]: this gives us the total number of rows

df_main.shape[0]

# In[169]:
print
'getting numeric data as separate dataframe'
df_numeric = df_main._get_numeric_data()

# In[170]:

df_numeric.head()

# In[171]:
print
'getting categorical data as separate dataframe'
df_categorical = df_main.select_dtypes(include = ['object'])

# In[173]:
print
'computing count,unique values/cardinality,mode,mode frequency, missing for categorical variables'
df_cat_results = df_categorical.describe()

# In[174]:

df_cat_results = df_cat_results.transpose()

# In[175]:

df_cat_results['% missing'] = df_main.shape[0] - df_cat_results['count']
df_cat_results.columns = ['count', 'unique values/cardinality', 'mode', 'mode frequency', '% missing']

# In[176]: this gives us the table with categorical variables as rows and their count etc as columns
print
'\nRESULTS FOR CATEGORICAL VARIABLES are being stored in csv file Table for categorical variables.csv'

df_cat_results.to_csv('Table for categorical variables.csv')

# In[58]:
print
'\nplotting bar graphs for categorical variables and saving the plots as bar_chart_categoricalvariablename '
for col in df_categorical.columns:
    df_categorical[col].value_counts().plot(kind = 'bar')
    plt.savefig('bar_chart_' + col + '.png', dpi = 1000)
    plt.close()
    print
    '\n plotted for column:', col

print
'\nHence these are final results for categorical variables above'
# In[178]:
print
'\n now computing results table for numerical variables with count, mean etc'
df_num_results = df_numeric.describe().transpose()

# pd.set_option('display.precision',10)
# df_numeric.head()


# In[181]:

df_num_results['% missing'] = df_main.shape[0] - df_num_results['count']
# print df_numeric['duration'].unique().size

# In[182]:

df_num_results.columns = ['count', 'mean', 'standard deviation', 'minimum', '1st quartile', 'median', '3rd quartile',
                          'maximum', '% missing']


def get_cardinality(attribute):
    return df_numeric[attribute].unique().size


df_num_results['cardinality'] = df_num_results.index
df_num_results['cardinality'] = df_num_results['cardinality'].apply(get_cardinality)

print
'\n RESULT TABLE FOR NUMERIC VARIABLES is being saved as Table for numeric variables.csv'
df_num_results.to_csv('Table for numeric variables.csv')

# In[102]:
print
'\n computing numeric variables which have nonzero IQR to plot boxplots'
df_num_quantiles = df_numeric.quantile([0.25, 0.75])

# In[105]:

df_num_quantiles_trans = df_num_quantiles.transpose()

# In[109]:

df_num_quantiles_trans['IQR'] = df_num_quantiles_trans[0.75] - df_num_quantiles_trans[0.25]

# In[139]:

df_num_quantiles_trans[df_num_quantiles_trans['IQR'] != 0]

# In[120]:

list_of_non_zero_IQR = df_num_quantiles_trans[df_num_quantiles_trans['IQR'] != 0].index.tolist()
print
'\n these variables have nonzero IQR :', list_of_non_zero_IQR
df_num_quantiles_trans.to_csv('Variables with nonzero IQR.csv')
print
'\n list of variables with nonzero IQR is being saved as variables with nonzero IQR.csv'
# In[141]:

print
'\n creating a boxplot of these variables and saving it as boxplotfornonzeroIQR.png'
df_box_plot = df_numeric[list_of_non_zero_IQR]
ax = df_box_plot.boxplot()
plt.setp(ax.get_xticklabels(), rotation = 30, horizontalalignment = 'right')
plt.tight_layout()
plt.savefig('boxplotfornonzeroIQR' + '.png', dpi = 1200)
plt.close()

# In[168]: this gives us the correlation matrix for numerical variables
print
'\n computing correlation matrix'
correlation_df = df_main.corr()

print
'\n\n This is the correlation matrix and it is being saved as Correlation table.csv'
correlation_df.to_csv('Correlation table.csv')

# In[121]:
print
'\n plotting histograms as histogram_variablename.png ... this may take a while, please wait'
for col in df_numeric.columns:
    df_numeric[col].plot.hist(bins = 10)
    plt.savefig('histogram_' + col + '.png', dpi = 500)
    plt.close()
    print
    '\n plotted for column : ', col