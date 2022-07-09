def add_greetings(names):
  greetings = []
  for i in range(0, len(names)):
    greetings.append("Hello, "+names[i])
  return greetings


print(add_greetings(["Owen", "Max", "Sophie"]))
#Create a function named add_greetings() which takes a list of strings named names as a parameter.
#In the function, create an empty list that will contain each greeting. Add the string 'Hello, ' in front of each name in names and append the greeting to the list.
#Return the new list containing the greetings.
