import logo from './logo.svg';
import './App.css';
import { useState } from 'react';
import Websocket from './components/Websocket';


function App() {
  const [content, SetContent] = useState();
  const [client, SetClient] = useState();
  const [url, setUrl] = useState("http://localhost:8081/hu/stomp");
  const [topic, setTopic] = useState("/topic/monitoring");

  let ws = null;
  const handleMessage = (msg) => {
    console.log(msg);
    SetContent(msg);
  };
  const handleClient = (client) => {
    SetClient(client);
  }

  return (
    // url='http://localhost:8080/hu/stomp'
    // /topic/monitoring
    <div className="App">
      <Websocket
        url= {url}
        topics={[topic]}
        handleMessage={handleMessage}
        client={handleClient}
      />
      <header className="App-header">
        <div style={{ display: 'flex', width: '1200px', justifyContent:"space-between", alignItems:'center', marginBottom: 200 }}>
          <div>
            <h3>URL</h3>
            <input pĺaceholder="url" value={url} onChange={(e) => setUrl(e.target.value)}/>
          </div>
          <div>
            <h3>Tópic</h3>
            <input pĺaceholder="topic" value={topic} onChange={(e) => setTopic(e.target.value)}/>
          </div>
        </div>
        <textarea style={{ width: '1200px', height:500 }} value={content}>
        </textarea>
        <div>
          <button onClick={() => client.sendMessage({topic}, "Teste123456")}>Teste send ws</button>
        </div>

      </header>
    </div>
  );
}

export default App;
