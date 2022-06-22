import random


def computerguess(x):
    Low = 1
    High = x
    Feedback = ""
    #Loop checking if the guess equals correct
    while(Feedback != "C"):
        if Low == High :
            Guess = random.randint(Low,High)
        Guess = random.randint(Low,High)
        Feedback = input('Is '+str(Guess)+' too high(H), too low(L) or correct(C) ')
        if Feedback=='H':
            print('Sorry my man/woman you suck. Too big(I guess you are used to this expression) .')
            High = Guess-1
        elif Feedback=="L":
            print('Sorry my man/woman you suck. Too small(I guess you not are used to this expression) .')
            Low = Guess + 1
        print('Did not think you would find it. I guess you won?')


Maximum = int(input('Choose the maximum number: '))
computerguess(Maximum)
