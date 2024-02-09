function factorialize(num) {
    let temp = 1;
    for(let i=1; i<=num; i++){
      temp *= i;
      console.log(temp);
    }
    return temp;
}
  
factorialize(5);