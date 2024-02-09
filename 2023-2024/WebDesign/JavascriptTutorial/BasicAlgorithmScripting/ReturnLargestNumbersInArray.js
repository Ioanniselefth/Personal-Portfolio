function largestOfFour(arr) {
    let tempArray=[];
    for(let i=0; i<arr.length; i++){
      let largest = arr[i][0]
      for(let j=1; j<arr[i].length; j++){
        if(arr[i][j] > largest){
          largest = arr[i][j];
        }
      }
      tempArray[i] =largest;
    }
    console.log(tempArray);
    return arr;
  }
  
  largestOfFour([[13, 27, 18, 26], [4, 5, 1, 3],  [32, 35, 37, 39], [1000, 1001, 857, 1]]);
  largestOfFour([[17, 23, 25, 12], [25, 7, 34, 48], [4, -10, 18, 21], [-72, -3, -17, -10]])