import turtle
import math

t=turtle.Turtle()
t.speed(10)
def polygon(lenght,n):
    for i in range(n):
        t.lt(360/n)
        t.fd(lenght)

def circle(r):
    obvod=2*math.pi*r
    n=int(obvod/3)+3
    lenght=obvod/n
    polygon(lenght,n)

circle(50)
