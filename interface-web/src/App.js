import logo from './logo.svg';
import './App.css';
import { useState } from 'react';
import Websocket from './components/Websocket';


function App() {
  const [content, SetContent] = useState('asdasdasd');
  const [client, SetClient] = useState();

  let ws = null;
  const handleMessage = (msg) => {
    console.log(msg);
    SetContent(msg);
  };
  const handleClient = (client) => {
    SetClient(client);
  }

  return (
    <div className="App">
      <Websocket
        url='http://localhost:8080/hu/stomp'
        topics={['/topic/monitoring']}
        handleMessage={handleMessage}
        client={handleClient}
      />
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
        <div>
          <button onClick={() => client.sendMessage("/topic/monitoring", "Teste123456")}>Teste send ws</button>
        </div>

      </header>
    </div>
  );
}

export default App;
