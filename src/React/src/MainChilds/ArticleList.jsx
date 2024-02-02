// import React, {memo, useContext, useEffect, useState} from "react";
// import {ArticleStates, GetArticles} from "../Main";
// import axios from "axios";

// const ArticleList = () =>{
//     const [articleList, setArticleList] = useState([]); 
//     const {articles, dispatch, pages} = useContext(ArticleStates);
//     useEffect(()=>{ 
//     axios.get('/api/ArticlePage/' +String(pages-1)) 
//         .then(response => { 
//             setArticleList(response.data);
//             dispatch({type : GetArticles, articles : response.data});
//         }) 
//         .catch(error => { 
//             console.error('Page Load error!', error); 
//     }); },[articles]);
//     return (
//         <div>
//             {articleList.map((article, index) => (
//                 <div>
//                     <div>--------------</div>
//                     <div><span>번호 : </span>{article.id}</div>
//                     <div><span>제목 : </span>{article.title}</div>
//                 </div>
//             ))}
//         </div>
//     );
// };
// export default ArticleList;