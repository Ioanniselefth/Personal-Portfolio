import random

def play(DoYouWantToPlayAgain):
    while DoYouWantToPlayAgain == True:
        user = input("Choose: 'R' for Rock, 'P' for Paper, 'S' for Scissors ")
        computer = random.choice(['R','P','S'])

        print(computer)

        if user == computer :
            print( 'It is a tie GOD DAMN IT')

        if win(user,computer)==True:
            print('I WON MOTHER F*ER F* YEAH YOU STUPID B')
        else:
            print('FML I LOST TO A COMPUTER')
        
        temp = input('Do you want to play again(Y-Yes,N-No): ')
        if(temp == "N"):
            print('See you SUCKER')
            DoYouWantToPlayAgain = False

def win(player,computer):
    if(player =="R" and computer=="S") or (player =="S" and computer=="P") or (player =="P" and computer=="R"):
        return True

DoYouWantToPlayAgain = True
play(DoYouWantToPlayAgain)
