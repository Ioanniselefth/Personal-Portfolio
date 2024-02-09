function repeatStringNumTimes(str, num) {
    let temp="";
    for(let i=0; i<num; i++){
      temp += str;
    }
    return temp;
  }
  
repeatStringNumTimes("abc", 3);