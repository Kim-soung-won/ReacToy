import React, {useState, useEffect} from "react";
import axios from "axios";

const ArticleList = () => {
    const [articles, setArticles] = useState([]);

    useEffect(() => {
        axios.get('/api/ArticlePage')
            .then(response => {
                //setArticles(response.data.article); //배열로 반환하기 때문에 분리할 필요없다.
                setArticles(response.data);
            })
            .catch(error => {
                console.error('There was an error!', error);
            });
    }, []);

    return (
        <div>
            {articles.map((article, index) => (
                <div key={index}>
                    <div>{article.id}</div>
                </div>
            ))}
        </div>
    );
}

export default ArticleList;