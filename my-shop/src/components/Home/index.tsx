
import axios from 'axios';
import * as React from 'react'; 
const HomePage : React.FC = () => {
    
    React.useEffect(() => {
        console.log("Begin");
        axios.post("http://localhost:8083/create", {name: "Сало"},
            {
                headers: {
                    "Content-type": "application/json"
                  }
            })
            .then((res)=> console.log("res", res));
        // axios.get("http://localhost:8083/").then((res)=>{
        //     console.log("res = ", res);
        // });
    });
    return (
    <>
        <h1>Головна сторінка</h1>
    </>
    );
}

export default HomePage;