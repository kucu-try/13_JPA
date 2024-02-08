import React, {useEffect, useState} from 'react';
import axios from 'axios';

function App() {
  const [hello, setHello] = useState("")

  useEffect(() => {
    // axios.get('/api/hello')
    //     .then(response => setHello(response.data))
    //     .catch(error => console.log(error))
    const fetchData = async () => {
        try {
            const response = await fetch('/api/hello');
            if (!response.ok){
                throw new Error("에러다 뭉청한 눔");
            }
            const data =  await response.text();
            setHello(data);
        }catch (error){
            console.log('에러다 이 놈아');
        }
    };
    fetchData();
  }, []);



  return (
      <div>
        백엔드 데이터 : {hello}
      </div>
  );
}

export default App;