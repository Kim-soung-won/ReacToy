import React,  {useEffect, createContext, useReducer, useMemo} from "react";
import axios from "axios";
import PageButton from "./MainChilds/pageButton";
import ArticleList from "./MainChilds/ArticleList";
export const ArticleStates = createContext({
    len : [1,2,3,4,5],
    pages : 1,
    dispatch : () =>{},
})

const initialState = { //초기값을 객체로 넣어준다.
    articles : [],
    pages : 1,
    countArticle : -1,
    len : [1,2,3,4,5],
    dispatch : () =>{},
}
const getLenArray = (e,countArticle) =>{
    if(e>=countArticle){
        return [countArticle - 2, countArticle - 1, countArticle];
    }
    if(e === countArticle -1){
        return [countArticle -3,countArticle -2, countArticle -1, countArticle];
    }
    if(e===1){
        return [e,e+1,e+2,e+3,e+4];
    }
    if(e===2){
        return [e-1,e,e+1,e+2,e+3];
    }
    return [e-2, e-1, e, e+1, e+2];
}
export const ClickBtn = 'ClickBtn';
export const GetArticles = 'GetArticles';
export const CountList = 'CountList';
const reducer = (state,action) => {
    const {countArticle, articles} = state;
    switch(action.type){ //action의 type: 이 어떤 값인지 확인
        case ClickBtn :
            const e = parseInt(action.btnVal,10);
            console.log("action.e : ",action.btnVal);
            return{
                ...state,
                pages : e,
                len : getLenArray(e,countArticle),
            }
        case GetArticles:
            return{
                ...state,
                articles : action.articles
            }
        case CountList:
            return{
                ...state,
                countArticle : action.countArticle
            }
        default:
            return;
    }
}


const Main = () => {
    console.log("rendering");
    const [state, dispatch] = useReducer(reducer, initialState); //3번째 인자는 Lazy기능을 하는데 보통 사용하지 않음
    const {articles, pages, countArticle, len} = state;
    const value = useMemo(()=>({dispatch, pages : pages, len : len, articles: articles}),[pages]);
    const MaxLen = 10;
    useEffect(() =>{
        axios.get('/api/startPage')
            .then(response =>{
                dispatch({type : CountList, countArticle : Math.ceil(response.data/MaxLen)});
                console.log("useEffect /api/startPage COUNT : ", countArticle);
            })
            .catch(error=>{
                console.error('Count error',error);
            });
    },[]);
    useEffect(() =>{
        axios.get('/api/ArticlePage/' +String(pages-1)) 
                .then(response => { 
                    dispatch({type : GetArticles, articles : response.data});
                }) 
                .catch(error => { 
                    console.error('Page Load error!', error); 
            });
    } ,[pages]);
        
    return (
        <ArticleStates.Provider value={value}>
        <ArticleList/>
        <div>Page No. {state.pages}</div>
        <PageButton />
        </ArticleStates.Provider>
    );
}
export default Main;