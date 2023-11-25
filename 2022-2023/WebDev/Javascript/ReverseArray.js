// Write your code here:
function reverseArray(arr){
    let newArr = [];
    for(let i=arr.length-1; i>=0; i--){
      newArr.push(arr[i]);
    }
    return newArr;
  }
  
  // When you're ready to test your code, uncomment the below and run:
  const sentence = ['sense.','make', 'all', 'will', 'This'];
  console.log(reverseArray(sentence)) 
  // Should print ['This', 'will', 'all', 'make', 'sense.'];