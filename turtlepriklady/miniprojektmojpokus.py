import turtle
from polkruhy import arc

bob=turtle.Turtle()
bob.speed(1000)


def kvet1(t):
    for i in range(0,7):
        for i in range(2):
            arc(bob,75,60)
            t.lt(120)
        t.lt(360/7)
        
def kvet2(t):
    for i in range(0,10):
        for i in range(2):
            arc(bob,55,85)
            t.lt(95)
        t.lt(360/10)

def kvet3(t):
    for i in range(0,20):
        for i in range(2):
            arc(bob,190,20)
            t.lt(160)
        t.lt(360/20)
        
def pozicia():
    kvet2(bob)
    bob.pu()
    bob.goto(210,0)
    bob.pd()
    kvet3(bob)
    bob.pu()
    bob.goto(-210,0)
    bob.pd()
    kvet1(bob)
    
pozicia()
