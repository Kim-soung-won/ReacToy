import React, {useState, useEffect,useRef} from "react";
import axios from "axios";

const ArticleList = () => {
    console.log("rendering");
    const [articles, setArticles] = useState([]);
    const [pages, setPages] = useState(1);
    const [countArticle, setCount] = useState(-1);
    const [len,setLen] = useState([1,2,3,4,5]);
    const MAXLEN = 10;
    useEffect(() =>{
        console.log("null array");
        axios.get('/api/startPage')
            .then(response =>{
                setCount(Math.ceil(response.data/MAXLEN));
                console.log(response.data);
                console.log(Math.ceil(response.data/MAXLEN));
            })
            .catch(error=>{
                console.error('Count error',error);
            });
    },[])


    useEffect(() => {
        console.log("useEffect pages");
        axios.get('/api/ArticlePage/' +String(pages-1))
            .then(response => {
                //setArticles(response.data.article); //배열로 반환하기 때문에 분리할 필요 없다.
                setArticles(response.data);
            })
            .catch(error => {
                console.error('Page Load error!', error);
            });
    }, [pages]);
    const onClickPageBtn = (e)=> () =>{
        if(pages === e){
            return;
        }
        if(e>=countArticle){
            setPages(countArticle);
            setLen([countArticle-2,countArticle-1,countArticle]);
            return;
        }
        if(e===countArticle-1){
            setPages(countArticle-1 );
            setLen([countArticle-3,countArticle-2,countArticle-1,countArticle]);
            return;
        }
        if(e===1){
            setPages(e);
            setLen([e,e+1,e+2,e+3,e+4]);
            return;
        }
        if(e===2){
            setPages(e);
            setLen([e-1,e,e+1,e+2,e+3]);
            return;
        }
        setPages(e);
        setLen([e-2,e-1,e,e+1,e+2]);
    }


    return (
        <>
        <div>
            {articles.map((article, index) => (
                <div key={index}>
                    <div>--------------</div>
                    <div><span>번호 : </span>{article.id}</div>
                    <div><span>제목 : </span>{article.title}</div>
                </div>
            ))}
        </div>
            <div>Page No. {pages}</div>
            <span>
            {len.map((v,i)=>(
                <button key={i} onClick={onClickPageBtn(v)}>{v}</button>
            ))}
            </span>
        </>
    );
}
export default ArticleList;