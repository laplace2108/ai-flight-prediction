import pandas as pd
from pymongo import MongoClient
from datetime import datetime
import os
import json
from MyProject.tokens import tokens

class getMongoDB(object):
	def __init__(self, MAX=3):
		self.dt = str(datetime.now()).split(' ')[0]
		self.pathToDump = 'temp-' + self.dt
		client = MongoClient(f'mongodb+srv://{tokens["username"]}:{tokens["pwd"]}@fligth-data-store.q1tow.mongodb.net/fligth-data-store?retryWrites=true&w=majority')
		db = client['fligth-data-store']
		col = db["stations-weather-conditions"]
		agent_ids = col.find().distinct('_id')
		self.weather = []
		for ag in agent_ids:
			# print(ag)
			# self.weather = self.weather + next(iter(col.find({'_id': ag})))
			self.weather.append(next(iter(col.find({'_id': ag}))))


class ObsDF(getMongoDB):
	def __init__(self, MAX=3):
		super(ObsDF, self).__init__(MAX=MAX)

		# self.getDates()
		# self.getCGM()
		# self.sortData()
		self.Obs = self.weather
		self.createDataFrame(MAX=10)
		self.createDataFrame()
		self.createDataFrame()
		self.createDataFrame()
		# self.numOfMeas()
		self.saveJSON([self.Obs[i]['features'] for i in range(len(self.Obs))], f'weather.json')
		self.saveDataFrame(filename='weather.csv')


	def createDataFrame(self, MAX=0):
		if MAX > 0 and MAX <= len(self.Obs):
			limit = MAX
		else:
			limit = len(self.Obs)

		self.temp = self.JSONToDFRow(self.Obs[0])
		self.df = pd.DataFrame(index=range(limit), columns=self.temp.keys())
		print(self.df.shape)
		for i in range(limit):
			self.temp = self.JSONToDFRow(self.Obs[i])
			for key in self.temp:
				self.df.iloc[i][key] = self.temp[key]

	def isList(self, d, keyword):
		if type(d.get(keyword)) == list:
			keywordUP = keyword.upper()
			d[keywordUP] = d[keyword]
			d[keyword] = {}
			for i, el in enumerate(d[keywordUP]):
				d[keyword][f'{keyword}_{i}'] = d[keywordUP][i]
			d.pop(keywordUP, None)

	def recursive_items(self, dictionary, prepend = ['root']):
		'''
		https://stackoverflow.com/questions/39233973/get-all-keys-of-a-nested-dictionary
		'''
		for key, value in dictionary.items():
			# print(type(value))
			if type(value) is list:
				# print(key)
				self.isList(dictionary, key)
			elif type(value) is dict:
				yield (key, value, type(value))
				# prepend.append(key)
				yield from self.recursive_items(value, prepend + [key])
			else:
				string = self.listToString(prepend)
				yield (f'{string}{key}', value, type(value))

	def listToString(self, l):
		# string =
		string = ''
		for i in l:
			string = string + i + '-'
		return string

	def getStrings(self, array):
		l = dict()
		for i in range(len(array)):
			if array[i][2] != dict:
				# l.append({arr[i][0] : arr[i][1]})
				l[array[i][0]] = array[i][1]
		return l

	def JSONToDFRow(self, obj, getColumnNames=False):
		tripleArray = list(self.recursive_items(obj))
		rowToDataFrame = self.getStrings(tripleArray)
		# if getColumnNames:
		#     return rowToDataFrame.keys()
		# else:
		#     return list(rowToDataFrame.values())
		return rowToDataFrame

	def saveDataFrame(self, filename='Observations.csv'):
		self.df.to_csv(os.path.join(os.getcwd(), "MyProject", self.pathToDump, filename), index=False)

	def saveJSON(self, obj, filename='FHIRdata.json'):
		dictJSON = json.dumps(obj)
		os.path.isdir(os.path.join(os.getcwd(), "MyProject", self.pathToDump)) or os.mkdir(os.path.join(os.getcwd(), "MyProject", self.pathToDump))
		f = open(os.path.join(os.getcwd(), "MyProject", self.pathToDump, filename),"w")
		f.write(dictJSON)
		f.close()


# os.getcwd()

a = ObsDF()


if __name__ == '__main__':
	print(f'Main - Current directory: {os.getcwd()}')
	# parser = argparse.ArgumentParser("Add date in yyyy-mm-dd format")
	# parser.add_argument('--date', dest="date", type=str, default="2021-06-01",
	# 					help='Specify date since tag for FHIR bulk export. \n Default set to 2021-06-01')
	# args = parser.parse_args()
	# print(f'Main - Data transfer since {args.date} starting...')
	# print(type(args.date))
	r = ObsDF()
