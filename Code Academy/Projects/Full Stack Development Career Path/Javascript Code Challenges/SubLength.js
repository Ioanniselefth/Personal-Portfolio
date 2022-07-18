// Write function below
function subLength(str,char){
    let counter = 0;
    for(let i = 0; i<str.length; i++){
      if(str[i]===char){
        counter += 1;
      }
    }
    if (counter === 2){
      for(let i = 0; i<str.length; i++){
        if(str[i]===char){
          let temp = 1;
          for(let j=i+1; j<str.length; j++){
            if(str[j]===char){
              return temp+1;
            }
            temp +=1 ;
          }
        }
      }
    }
    return 0;
}
/*
Write a function subLength() that takes 2 parameters, a string and a single character. 
The function should search the string for the two occurrences of the character and return the length between them including the 2 characters. 
If there are less than 2 or more than 2 occurrences of the character the function should return 0.

Examples:
*/
subLength('Saturday', 'a'); // returns 6
subLength('summer', 'm'); // returns 2
subLength('digitize', 'i'); // returns 0
subLength('cheesecake', 'k'); // returns 0
console.log(subLength('Saturday', 'a'));