import React, {useCallback, useContext, memo} from "react";
import {ArticleStates, ClickBtn} from "../Main";

const PageButton = memo(() =>{
    console.log("PageButton rendering...");
    const {dispatch ,len} = useContext(ArticleStates);
    const onClickPageBtn = useCallback((e)=> ()=>{
        console.log("clickBtn");
        console.log("e.target.value : ",e);
        dispatch({type : ClickBtn, btnVal:e});
    },[]);
    return (
        <span>
        {len.map((v, i) => (
            <button key={i} onClick={onClickPageBtn(v)}>{v}</button>
        ))}
        </span>
    );
});
export default PageButton;