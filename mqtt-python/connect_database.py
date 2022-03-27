from pydoc_data.topics import topics
import psycopg2
import import_config

database = import_config.getDatabaseConfig()
conn = psycopg2.connect(database=database.database, user=database.username,
                        password=database.password, host=database.host,
                        port=database.port)

print("Connection Successful to PostgreSQL")


def getAllTopics():
    select_all = "SELECT * FROM sch_econam.device"
    cursor = conn.cursor()
    cursor.execute(select_all)
    x = cursor.fetchall()
    topics = []
    for i in x:
        topics.append(i[2])
    return topics


def insertReadDevice(device, variable, value, unit, datetime):
    insertDevice = (
        "INSERT INTO sch_econam.read (device, variable, value, unit, datetime) VALUES(%s, %s, %s, %s, %s)")
    cursor = conn.cursor()
    cursor.execute(insertDevice, (str(device), str(
        variable), str(value), str(unit), datetime))
    conn.commit()
    cursor.close()


def findByTopic(topic):
     select_all = "SELECT id FROM sch_econam.device WHERE device.topic = '"+topic+"'"
     cursor = conn.cursor()
     cursor.execute(select_all)
     id = cursor.fetchone()
     return(id[0])

def closeConnection():
    conn.close()
