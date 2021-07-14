from FlightRadar24.api import FlightRadar24API
from pymongo import MongoClient
from MyProject.tokens import tokens

fr_api = FlightRadar24API()
flights = fr_api.get_flights()

from noaa_sdk import NOAA
n = NOAA()

airports = {'LaGuardia': 'lga',
	'Texas H Int Airport': 'iah',
	'LAX': 'lax',
	'Atlanta':'atl',
	'NY JFK':'jfk',
	'San Francisco':'sfo',
	'Chicago':'ord',
	'Dallas':'dfw',
	'Denver':'den'}

airportsPC = {'LaGuardia': '11371',
	'Texas H Int Airport': '77032',
	'LAX': '90045',
	'Atlanta':'30320',
	'NY JFK':'11430',
	'San Francisco':'94128',
	'Chicago':'60666',
	'Dallas':'75261',
	'Denver':'80249'}


# getJson(flight.id)

class getFlights(object):
	def __init__(self):
		flightDetails = self.getFlightDetails([flights[i].id for i in range(len(flights))])
		newFlightDetails = self.flightDestination(flightDetails, airports)

		self.pushFlights(newFlightDetails)

	def getFlightDetails(self, flightIDList, TOL = 10):
		flightDetails = []
		flightIDList = list(set([flightID for flightID in flightIDList]) - set([flight["identification"]["id"] for flight in flightDetails]))
		counter = 0

		while len(flightIDList) > 0 and counter < TOL:
			print("counter: ", counter)
			for (i,flightid) in enumerate(flightIDList):
				try:
					# flight = flights[i]
					details = fr_api.get_flight_details(flightid)
					if next(iter(details.keys())) == 'identification':
						flightDetails.append(details)
						print("Got flight", i)
					else:
						print("Flight", i)
				except:
					print("No flight", i)

			counter += 1
			flightIDList = list(set([flightID for flightID in flightIDList]) - set([flight["identification"]["id"] for flight in flightDetails]))

		return flightDetails

	def flightDestination(self, flightDetails, airports):
		newFlightDetails = []
		for flightDetail in flightDetails:
			try:
				dest = flightDetail["airport"]["destination"]["code"]["iata"]
				if dest in [airport.upper() for airport in airports.values()]:
					newFlightDetails.append(flightDetail)
			except:
				pass
		return newFlightDetails

	def pushFlights(self, newFlightDetails):
		db = client['fligth-data-store']
		col = db["flight-data"]
		for newFlightDetail in newFlightDetails:
			try:
				col.insert_one(newFlightDetail)
			except:
				pass


class getWeather(object):
	def __init__(self):
		self.obsList = []
		self.getWeather()
		self.pushFlights()

	def getWeather(self):
		for (i,postalCode) in enumerate(airportsPC.values()):
			observations = n.get_observations(postalCode,'US')
			for observation in observations:
				self.obsList.append(observation)
			if i > 3:
				break

	def pushFlights(self):
		db = client['fligth-data-store']
		col = db["weather-data"]
		for obs in self.obsList:
			try:
				col.insert_one(obs)
			except:
				pass

# getFlights()
# getWeather()

if __name__ == '__main__':
	getFlights()
	getWeather()

# flightDetails = getFlightDetails([flights[i].id for i in range(len(flights))])

# len(flightDetails)
# newFlightDetails = flightDestination(flightDetails, airports)
# len(newFlightDetails)
#
#
#
# db = client['fligth-data-store']
# col = db["flight-data"]
# col.insert_many(newFlightDetails[1:])
# col.insert_one(newFlightDetails[1])
#


################################################################################
# flightDetails[0]["firstTimestamp"]
# flightDetails[5]["time"]["scheduled"]["departure"]
# from datetime import datetime, timedelta
# import datetime
# datetime.strptime(1626017301)
# datetime.fromtimestamp(flightDetails[5]["time"]["scheduled"]["departure"])
#
# datetime.fromtimestamp(flightDetails[5]["time"]["scheduled"]["arrival"])
# str(timedelta(seconds=int(flightDetails[5]["time"]["historical"]["flighttime"])))
# flightDetails[5]["time"]["scheduled"]["arrival"]
# a = str(datetime.fromtimestamp(flightDetails[5]["time"]["scheduled"]["arrival"]) - datetime.fromtimestamp(flightDetails[5]["time"]["scheduled"]["departure"]))
# a

# import requests
# import json
# a = requests.get('https://data-live.flightradar24.com/clickhandler/?flight=285e463f')
# json.loads(a.content)
#
#
# def getJson(flightID):
# 	a = requests.get('https://data-live.flightradar24.com/clickhandler/?flight=' + flightID)
# 	return json.loads(a.content)
#
# getJson("285e463f")
#
# bb = requests.get('https://data-live.flightradar24.com/zones/fcgi/feed.js')
# bb
################################
# 11365
# airportsPC

# observations = n.get_observations(airportsPC["Denver"],'US')
# obsList = []
# for observation in observations:
# 	# print(observation)
# 	obsList.append(observation)



# class getWeather(object):
# 	def __init__(self):
# 		self.obsList = []
# 		self.getWeather()
# 		self.pushFlights()
#
# 	def getWeather(self):
# 		for postalCode in airportsPC.values():
# 			observations = n.get_observations(postalCode,'US')
# 			for observation in observations:
# 				self.obsList.append(observation)
#
# 	def pushFlights(self):
# 		db = client['fligth-data-store']
# 		col = db["weather-data"]
# 		for obs in obsList:
# 			try:
# 				col.insert_one(obs)
# 			except:
# 				pass



# type(observations)
# [obsList[i]["timestamp"] for i in range(606)]

#
# ######################################
# import pandas as pd
# from pymongo import MongoClient
# import dns
#
# client = MongoClient('mongodb+srv://<user>:<pwd>@fligth-data-store.q1tow.mongodb.net/fligth-data-store?retryWrites=true&w=majority')
# db = client['fligth-data-store']
# col = db["stations-weather-conditions"]#client.database_names()
#
# agent_ids = col.find().distinct('_id')
#
#
# agent_ids
#
#
# a = next(iter(col.find({'_id': agent_ids[0]})))
#
# weatherObj = []
# for ag in agent_ids:
# 	print(ag)
# 	weatherObj.append(next(iter(col.find({'_id': ag}))))
#
# class getMongoDB(object):
# 	def __init__(self, MAX=3):
# 		client = MongoClient('mongodb+srv://jtoledo:Javier123@fligth-data-store.q1tow.mongodb.net/fligth-data-store?retryWrites=true&w=majority')
# 		db = client['fligth-data-store']
# 		col = db["stations-weather-conditions"]
# 		agent_ids = col.find().distinct('_id')
# 		self.weather = []
# 		for ag in agent_ids:
# 			# print(ag)
# 			self.weather.append(next(iter(col.find({'_id': ag}))))
#
#
# class ObsDF(getMongoDB):
# 	def __init__(self, MAX=3):
# 		super(ObsDF, self).__init__(MAX=MAX)
#
# 		# self.getDates()
# 		# self.getCGM()
# 		# self.sortData()
# 		self.Obs = self.weather
# 		self.createDataFrame(MAX=10)
# 		self.createDataFrame()
# 		self.createDataFrame()
# 		self.createDataFrame()
# 		# self.numOfMeas()
#
# 	def createDataFrame(self, MAX=0):
# 		if MAX > 0 and MAX <= len(self.Obs):
# 			limit = MAX
# 		else:
# 			limit = len(self.Obs)
#
# 		self.temp = self.JSONToDFRow(self.Obs[0])
# 		self.df = pd.DataFrame(index=range(limit), columns=self.temp.keys())
# 		print(self.df.shape)
# 		for i in range(limit):
# 			self.temp = self.JSONToDFRow(self.Obs[i])
# 			for key in self.temp:
# 				self.df.iloc[i][key] = self.temp[key]
#
# 		# self.saveDataFrame()
#
# 	def isList(self, d, keyword):
# 		if type(d.get(keyword)) == list:
# 			keywordUP = keyword.upper()
# 			d[keywordUP] = d[keyword]
# 			d[keyword] = {}
# 			for i, el in enumerate(d[keywordUP]):
# 				d[keyword][f'{keyword}_{i}'] = d[keywordUP][i]
# 			d.pop(keywordUP, None)
#
# 	def recursive_items(self, dictionary, prepend = ['root']):
# 		'''
# 		https://stackoverflow.com/questions/39233973/get-all-keys-of-a-nested-dictionary
# 		'''
# 		for key, value in dictionary.items():
# 			# print(type(value))
# 			if type(value) is list:
# 				# print(key)
# 				self.isList(dictionary, key)
# 			elif type(value) is dict:
# 				yield (key, value, type(value))
# 				# prepend.append(key)
# 				yield from self.recursive_items(value, prepend + [key])
# 			else:
# 				string = self.listToString(prepend)
# 				yield (f'{string}{key}', value, type(value))
#
# 	def listToString(self, l):
# 		# string =
# 		string = ''
# 		for i in l:
# 			string = string + i + '-'
# 		return string
#
# 	def getStrings(self, array):
# 		l = dict()
# 		for i in range(len(array)):
# 			if array[i][2] != dict:
# 				# l.append({arr[i][0] : arr[i][1]})
# 				l[array[i][0]] = array[i][1]
# 		return l
#
# 	def JSONToDFRow(self, obj, getColumnNames=False):
# 		tripleArray = list(self.recursive_items(obj))
# 		rowToDataFrame = self.getStrings(tripleArray)
# 		# if getColumnNames:
# 		#     return rowToDataFrame.keys()
# 		# else:
# 		#     return list(rowToDataFrame.values())
# 		return rowToDataFrame
#
# 	def saveDataFrame(self, filename='Observations.csv'):
# 		self.df.to_csv(os.path.join(os.getcwd(), self.pathToDump, filename), index=False)
#
#
# len(weatherObj)
# aa = ObsDF()
# aa.df
