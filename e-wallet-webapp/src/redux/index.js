import { combineReducers } from 'redux'
import { routerReducer } from 'react-router-redux'
import homeReducer from "./home/home";


export default combineReducers({
    routing: routerReducer,
    home: homeReducer
})