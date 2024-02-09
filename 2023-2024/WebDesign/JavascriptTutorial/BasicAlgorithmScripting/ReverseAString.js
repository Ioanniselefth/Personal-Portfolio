function reverseString(str) {
    let temp="";
    for(let i=str.length-1; i>=0; i--){
      temp += str[i];
    }
    return temp;
  }
  
reverseString("hello");
//This is using my knowledge from java
//Using javascript Logic:
  
function reverseString(str) {
    return str
      .split("")
      .reverse()
      .join("");
}
  