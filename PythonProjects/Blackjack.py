#BlackJjack or 21 game
import random

def dealer_cards():
    #Dealer Cards
    deal = []
    while len(deal) != 2:
        deal.append(random.randint(1,11))
        if len(deal) == 2:
            print('Dealer has X and:',deal[1])
    return deal

def player_cards():
    #Player cards 
    play = []
    while len(play) != 2:
        play.append(random.randint(1,11))
        if len(play) == 2:
            #print('Player has:',' '.join(player_cards))
            print('Player has,',play)
    return play

player_wants_to_play = True
while(player_wants_to_play==True):
    print('Welcome to Blackjack, Let the games begin')
    dealer = dealer_cards()
    player = player_cards()
    #Sum of the dealer and player cards
    if sum(dealer) ==21:
        print('Game over , Dealer has 21 :(')
    elif sum(dealer) > 21:
        print('Dealer has busted!')
    while sum(player) < 21:
        action = str(input('Do you want to stay or hit? '))
        if action == 'hit':
            player.append(random.randint(1,11))
            print('Your total is',str(sum(player)))
        else:
            print('The dealer has a total of',str(sum(dealer)))
            print('Your total is',str(sum(player)))
            if sum(dealer) > sum(player):
                print('Dealer wins')
            else:
                print('Player wins')
                break
    if sum(player) > 21:
        print('You busted, Dealer wins')
    elif sum(player) == 21:
        print('Player has blackjack, Player wins')
    print('Do you want to play again: ')
    str = input('yes or no: ')
    if str == 'yes':     
        player_wants_to_play = True
    else:
        player_wants_to_play = False