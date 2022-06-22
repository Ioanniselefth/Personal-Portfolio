import time 

def ItsTheFinalCountdown(Time):
    while Time:
        #why the fuck should i use regular expressions
        Mins,Secs = divmod(Time,60)
        Timer = '{:02d}:{:02d}'.format(Mins,Secs)
        print(Timer, end = "\r")
        time.sleep(1)
        Time -= 1

    print('Timer completed!')

#Plans for this project is to not take the time in seconds but in real time 
Time = int(input('Enter the time in seconds: '))
ItsTheFinalCountdown(Time)