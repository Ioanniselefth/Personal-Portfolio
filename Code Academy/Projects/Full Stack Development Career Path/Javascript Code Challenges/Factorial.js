// Write function below
function factorial(number){
    if(number == 1 || number ==0){
      return 1;
    }
    return number*factorial(number-1);
  }
  
console.log(factorial(5));
/*Write a function factorial() that takes a number as an argument and returns the factorial of the number.

Example:

factorial(6); 
// returns `720` because 6 * 5 * 4 * 3 * 2 * 1 = 720 
Assume only positive numbers will be given as an argument for the factorial() function.
*/