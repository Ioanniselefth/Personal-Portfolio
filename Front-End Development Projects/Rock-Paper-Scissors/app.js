const ComputerChoiceDisplay = document.getElementById('computer-choice');
const UserChoiceDisplay = document.getElementById('user-choice');
const resultDisplay = document.getElementById('result');
const possibleChoices = document.querySelectorAll('button');
let UserChoice;
let ComputerChoice;
let Result;

possibleChoices.forEach(possibleChoice => possibleChoice.addEventListener('click', (e) => {
    UserChoice = e.target.id;
    UserChoiceDisplay.innerHTML = UserChoice;
    generateComputerChoice();
    getResult();

}))

function generateComputerChoice() {
    const randomNumber = Math.floor(Math.random() * 3) + 1; // or you can use possibleChoice.length

    if (randomNumber === 1) {
        ComputerChoice = "Rock";
    } else if (randomNumber === 2) {
        ComputerChoice = "Scissors";
    } else {
        ComputerChoice = "Paper";
    }
    ComputerChoiceDisplay.innerHTML = ComputerChoice;
}

function getResult() {
    if (ComputerChoice === UserChoice) {
        Result = "It's a draw";
    } else if (ComputerChoice === "Rock" && UserChoice === "Paper") {
        Result = "You win!";
    } else if (ComputerChoice === "Rock" && UserChoice === "Scissors") {
        Result = "You lost!";
    } else if (ComputerChoice === "Paper" && UserChoice === "Scissors") {
        Result = "You win!";
    } else if (ComputerChoice === "Paper" && UserChoice === "Rock") {
        Result = "You lose!";
    } else if (ComputerChoice === "Scissors" && UserChoice === "Rock") {
        Result = "You win!";
    } else if (ComputerChoice === "Scissors" && UserChoice === "Paper") {
        Result = "You lose!";
    }
    resultDisplay.innerHTML = Result;
}