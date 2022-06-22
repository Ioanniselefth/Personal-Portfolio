import turtle

wn = turtle.Screen()
wn.title('Pong tutorial by @TokyoEdTech')
wn.bigcolor('black')
wn.setup(width=800, height=600)
wn.tracer(0)


#Paddle A
PaddleA = turtle.Turtle()
PaddleA.speed(0)
PaddleA.shape('square')
PaddleA.color('white')
PaddleA.shapesize(stretch_wid=5, stretch_len=1)
PaddleA.penup()
PaddleA.goto(-350,0)