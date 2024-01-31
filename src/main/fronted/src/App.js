import logo from './logo.svg';
import './App.css';
import React,{useState,useEffect} from "react";
import ArticleList from "./ArticleList";
import axios from "axios";
function App() {
    return (
        <div className="App">
            <h1>Article List</h1>
            <ArticleList />
        </div>
    );
}

export default App;
