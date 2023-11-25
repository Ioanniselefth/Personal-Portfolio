// 1.) Declaring variables for different slides
// note: make sure to use backticks -> ``, not quotes -> '' 
// when making your own slides, they are don't work the same way

var slide1 = `
    <div>
        <h2>1. It is the only language used for:</h2>

        <ul>
            <li>Making websites interactive</li>
            <li>Building applications people can run in the browser</li>
        </ul>
        <p>
            Since it's the only language that can do these things, most companies use JavaScript. That makes it a good language if you're looking to land your first development job.
        </p>            
    </div>
`

var slide2 = `
    <div>
        <h2>2. But it can also be used for:</h2>
        
        <ul>
            <li>Programming servers</li>
            <li>Creating mobile apps</li>
            <li>Building Desktop apps</li>
            <li>Processing data</li>
            <li>Making games</li>
            <li>Automating things</li>
            <li>Much much more...</li>
        </ul>
        <p>
            Which means you keep your options open in terms of what you want to be able to do!
        </p>
    </div>
`

var slide3 = `
    <div>
        <h2>3. Other reasons</h2>
        
        <ul>
            <li>Fun way to learn programming</li>
            <li>Easy to start! Just use the browser</li>
            <li>JavaScript allows you to program in multiple "styles"</li>
            <li>Lots of interesing libraries you can use</li>
        </ul>
    </div>
`

// 2.) Declaring function to display each slide

function displaySlide1(){
    document.getElementById('slides').innerHTML = slide1
}

function displaySlide2(){
    document.getElementById('slides').innerHTML = slide2
}

function displaySlide3(){
    document.getElementById('slides').innerHTML = slide3
}

// 3.) Adding the event listeners to the buttons and
// Adding the displaySlide functions as event handlers

document.getElementById('reason1').addEventListener('click', displaySlide1)
document.getElementById('reason2').addEventListener('click', displaySlide2)
document.getElementById('reason3').addEventListener('click', displaySlide3)