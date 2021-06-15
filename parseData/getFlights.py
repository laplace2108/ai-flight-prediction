from FlightRadar24.api import FlightRadar24API

fr_api = FlightRadar24API()

airports = fr_api.get_airports()

airports

airlines = fr_api.get_airlines()

flights = fr_api.get_flights()
len(flights)
flight = flights[1250]

type(flight)
details = fr_api.get_flight_details(flight.id)

flight.set_flight_details(details)

flight.destination_airport_name

details




from noaa_sdk import NOAA
n = NOAA()
observations = n.get_observations('11365','US')
obsList = []
for observation in observations:
	# print(observation)
	obsList.append(observation)


iter(observations)
type(observation)
type(observations)
[obsList[i]["timestamp"] for i in range(272)]
len(obsList)
obsList[0]

######################################
import pandas as pd
from pymongo import MongoClient
import dns

client = MongoClient('mongodb+srv://jtoledo:Javier123@fligth-data-store.q1tow.mongodb.net/fligth-data-store?retryWrites=true&w=majority')
db = client['fligth-data-store']
col = db["stations-weather-conditions"]#client.database_names()

agent_ids = col.find().distinct('_id')


agent_ids


a = next(iter(col.find({'_id': agent_ids[0]})))

weatherObj = []
for ag in agent_ids:
	print(ag)
	weatherObj.append(next(iter(col.find({'_id': ag}))))

class getMongoDB(object):
	def __init__(self, MAX=3):
		client = MongoClient('mongodb+srv://jtoledo:Javier123@fligth-data-store.q1tow.mongodb.net/fligth-data-store?retryWrites=true&w=majority')
		db = client['fligth-data-store']
		col = db["stations-weather-conditions"]
		agent_ids = col.find().distinct('_id')
		self.weather = []
		for ag in agent_ids:
			# print(ag)
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

		# self.saveDataFrame()

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
		self.df.to_csv(os.path.join(os.getcwd(), self.pathToDump, filename), index=False)


len(weatherObj)
aa = ObsDF()
aa.df
