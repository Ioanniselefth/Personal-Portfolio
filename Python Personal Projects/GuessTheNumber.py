import random

def guess(x):
    RandomNumber = random.randint(1,x)
    Guess = 0
    #Loop checking if the guess equals to the number
    while(Guess != RandomNumber):
        Guess = int(input('Guess a number between 1 and '+str(x)+':'))
        if Guess < RandomNumber:
            print('Sorry my man/woman you suck. Too small .')
        elif Guess > RandomNumber:
            print('Sorry my man/woman you suck. Too big .')
        print('Did not think you would find it. I guess you won?')


Maximum = int(input('Choose the maximum number: '))
guess(Maximum)
