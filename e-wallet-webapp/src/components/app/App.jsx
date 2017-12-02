import React from 'react';
import { Route } from 'react-router-dom'
import Home from '../../containers/home/HomeContainer.jsx'
import About from '../about/About.jsx'

const App = () => (
    <div style={{height: '100%'}}>
        <main style={{height: '100%'}}>
            <Route exact path="/" component={Home} />
            <Route exact path="/about-us" component={About} />
        </main>
    </div>
);
export default App