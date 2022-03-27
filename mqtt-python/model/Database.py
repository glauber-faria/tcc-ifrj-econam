class Database:
    def __init__(self, host, database, username, password, port):
        self.host = host
        self.database = database
        self.username = username
        self.password = password
        self.port = port