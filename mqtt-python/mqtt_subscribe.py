import paho.mqtt.client as mqtt
import datetime
import json
import import_config as config
import connect_database as database

# received on message
def on_message(client, userdata, message):
    payload_json = (json.loads(message.payload.decode('utf-8')))
    print(payload_json)
    topic_id = database.findByTopic(message.topic)
    database.insertReadDevice(topic_id, str(payload_json['variable']), str(payload_json['value']), str(payload_json['unit']), datetime.datetime.now())
    #topic_json = (str("{"+message.topic+":"+payload_json+"}"))
    #x = ("{'"+message.topic+"':'"+str(message.payload.decode('utf-8'))+"'}")
    #print("{'"+str(datetime.datetime.now())+"': "+x+"}")
    # x = (json.loads(str(message.payload.decode("utf-8"))))

# import config (all topics and broker)
broker = config.getBrokerConfig()
topics = database.getAllTopics()

# connect broker
client = mqtt.Client(broker.client_id)
client.connect(broker.host)
client.loop_start()

# loop and subscribe in all topics
for i in topics:
    client.subscribe(i)

# monitoring all topics 
while True:
    client.on_message = on_message
client.loop_end()
