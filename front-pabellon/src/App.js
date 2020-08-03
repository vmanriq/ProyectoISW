import React from 'react';
import './App.css';
import { Router, Switch, Route } from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap/dist/js/bootstrap.bundle.min';
import Table from './views/Tables';
import history from './helpers/history'

function App() {
	  return (
	    <Router 
	      history={history}>
	      <div className='container'>
	        <Switch>
	          <Route
	            path='/tab'
	            component={Table}
	          />
	        </Switch>
	      </div>
	    </Router>
	  );
	}

export default App;
