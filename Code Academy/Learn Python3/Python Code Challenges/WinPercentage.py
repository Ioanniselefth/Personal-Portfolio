def win_percentage(wins, loses):
  totalmatches = wins+loses  # 10
  winper = wins / totalmatches  # 2/10
  return winper*100


print(win_percentage(5, 5))
# should print 50
print(win_percentage(10, 0))
# should print 100
#Create a function called win_percentage() that takes two parameters named wins and losses.
#This function should return out the total percentage of games won by a team based on these two numbers.
