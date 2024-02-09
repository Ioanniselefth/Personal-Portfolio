function truncateString(str, num) {
    if(num>=str.length){
      return str;
    }
    else{
      let temp ="";
      for(let i=0; i<num; i++){
        temp += str[i];
      }
      temp += "...";
      console.log(temp);
      return temp;
    }
  }
  
  truncateString("A-tisket a-tasket A green and yellow basket", 8);
  truncateString("A-tisket a-tasket A green and yellow basket", "A-tisket a-tasket A green and yellow basket".length)
  truncateString("A-", 1)