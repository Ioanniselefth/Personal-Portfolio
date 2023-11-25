console.log("Script Loaded...");

function paint(color){
    console.log(color);
    const circle = document.getElementById('circleID');
    if(color == "random"){
        const temporaryColor = getRandomColor();
        circle.style = `background-color:${temporaryColor}`;
    }
    else {
        circle.style = `background-color:${color}`;
    }
    console.log(circle);
}

function getRandomColor() {
    var letters = '0123456789ABCDEF';
    var color = '#';
    for (var i = 0; i < 6; i++) {
      color += letters[Math.floor(Math.random() * 16)];
    }
    return color;
  }
  
  
  
function setRandomColor() {
    $("#colorpad").css("background-color", getRandomColor());
}