import random

print('Welcome Idiot to your Password Generator')

chars = "abcdefghijklmnoprstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ;'!@#$%^&*()_+.,?0123456789"

number= int(input('Maximum Amount characters to generate for the password: '))
length = int(input('Input your password length: '))
print('\nhere are your passwords: ')
for i in range(number):
    passwords =''
    for j in range(length):
        passwords += random.choice(chars)
    print(passwords)