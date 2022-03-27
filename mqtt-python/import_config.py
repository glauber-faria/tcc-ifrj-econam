import json
import model.Broker as modelBroker
import model.Database as modelDatabase

def readConfig():
    f = open('./config/config.json')
    global data 
    data = json.load(f)
    f.close()


def getTopics():
    return data['topics']


def getBrokerConfig():
    broker_config_json = data['broker_config'] 
    broker = modelBroker.Broker(broker_config_json['host'], broker_config_json['client_id'], broker_config_json['port'] )
    return broker

def getDatabaseConfig():
    database_config_json = data['database_config'] 
    database = modelDatabase.Database(database_config_json['host'], database_config_json['database'], database_config_json['username'], database_config_json['password'], database_config_json['port'] )
    return database

readConfig()
