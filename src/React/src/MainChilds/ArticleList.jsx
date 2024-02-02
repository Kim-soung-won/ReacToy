import React, {memo, useContext, useEffect, useState} from "react";
import {ArticleStates, GetArticles} from "../Main";
import axios from "axios";

const ArticleList = memo(() =>{
    const {articles, dispatch, pages} = useContext(ArticleStates);
    
    useEffect(()=>{
        const fetchArticles = async () => {
            try {
                const response = await axios.get('/api/ArticlePage/' + String(pages - 1));
                console.log("page : ", pages);
                dispatch({ type: GetArticles, articles: response.data }); // articles 키를 사용하여 dispatch 호출
                console.log("response.data : ", response.data);
                console.log("ArticleList : ", articles);
            } catch (error) {
                console.error('Page Load error!', error);
            }
        };
    
        fetchArticles();
    },[pages]);
    return (
        <div>
            {articles.map((article, index) => (
                <div>
                    <div>--------------</div>
                    <div><span>번호 : </span>{article.id}</div>
                    <div><span>제목 : </span>{article.title}</div>
                </div>
            ))}
        </div>
    );
});
export default ArticleList;