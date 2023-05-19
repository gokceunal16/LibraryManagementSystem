import './App.css';
import Tabs from "./components/Tabs";


function App() {

    return (
        <div className="App" style={{backgroundColor: '#F3F4F6', height:'100vh', padding: '3rem'}}>
            <div style={{border: '1px solid #D1D5DB',
                padding: '1rem', backgroundColor: 'white'}}>
                <Tabs style={{padding: '1rem'}}/>
            </div>

        </div>


    );
}

export default App;
