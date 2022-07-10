const scoreDisplay = document.getElementById("score-display");
const questionsDisplay = document.getElementById("questions");
const questions = [
    {
        quiz: ['value','estimate','evaluate'],
        options: ['jury','asses'],
        correct:2
    },
    {
        quiz: ['close', 'near','next'],
        options: ['trace', 'adjacent'],
        correct:2
    },
    {
        quiz: ["foreign",'national','ethnic'],
        options: ['exotic','mad'],
        correct:1
    }
];

let score = 0;
let clicked = [];

scoreDisplay.textContent = score;

function populateQuestions(){
    questions.forEach(question =>{

        const questionBox = document.createElement("div");
        questionBox.classList.add("question-box");
        /*
        const logoDisplay = document.createElement("h1");
        logoDisplay.textContent ="-*-";
        questionBox.append(logoDisplay);
        */
        question.quiz.forEach(tip =>{
            //Print the number of the question to the box;
            const tipText = document.createElement("p");
            tipText.textContent = tip;
            questionBox.append(tipText);
        });

        const questionButtons = document.createElement('div');
        questionButtons.classList.add('question-buttons');
        questionBox.append(questionButtons);

        question.options.forEach((option,optionIndex) =>{
            const questionButton = document.createElement('button');
            questionButton.classList.add('question-button');
            questionButton.textContent = option;

            questionButton.addEventListener('click',() => 
                checkAnswer(questionBox,questionButton,option,optionIndex+1,question.correct))

            questionButtons.append(questionButton);
        });

        const answerDisplay = document.createElement('div');
        answerDisplay.classList.add('answer-display');
        
        questionBox.append(answerDisplay);
        questionsDisplay.append(questionBox);
    });
};

populateQuestions();

function checkAnswer(questionBox,questionButton, option, optionIndex, correctAnswer){
    console.log()
    if (optionIndex === correctAnswer){
        score++;
        scoreDisplay.textContent = score;
        addResults(questionBox,"Correct!",'correct');
    }
    else {
        score --;
        scoreDisplay.textContent = score;
        addResults(questionBox,"Wrong!",'wrong');
    }
    clicked.push(option);
    questionButton.disabled = clicked.includes(option);
}

function addResults(questionBox,answer,className){
    const answerDisplay = questionBox.querySelector('.answer-display')
    answerDisplay.classList.remove('wrong');
    answerDisplay.classList.remove('correct');
    answerDisplay.classList.add(className);
    answerDisplay.textContent=answer;
};