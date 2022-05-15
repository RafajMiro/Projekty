import turtle
from polkruhy import arc

bob=turtle.Turtle()
bob.speed(10)

def lupen(t,r,angle):
    '''kreli lupen kvetu ako 2 arc
        t=turtle
        r=polomer
        angle=uhol medzi arcami'''
    for i in range(0,2):
        arc(t,r,angle)
        t.lt(180-angle)

def kvet(t,n,r,angle):
    '''kresli kvet s n lupenmi
        t=turtle
        n=pocet lupenov
        r=polomer
        angle=uhol medzi arc'''
    for i in range(0,n):
            lupen(t,r,angle)
            t.lt(360/n)

def stonka(t,r,angle):
    '''vykreslenie stonky kolmo dolu od kvetu
        t=turtle
        r=polomer arc,cize nasa dlzka
        angle= uhol zakrivenia'''
    t.seth(270)
    t.rt(angle/2)
    arc(t,r,angle)

def listok(t,r,angle,angle_leaf):
    '''vykreslenie 2 listkov pomocou funkcie arc
        t=turtle
        r=polomer
        angle= uhol zakrivenia arc v listoch
        angle_leaf=uhol mezi listom a zemou'''
    t.seth(0)
    t.lt(angle_leaf-angle/2)
    for i in range(0,2):
        arc(t,r,angle)
        t.lt(180-angle)
    t.seth(180)
    t.rt(angle_leaf+angle/2)
    for i in range(0,2):
        arc(t,r,angle)
        t.lt(180-angle)
    
def pozicia(t,x,y):
    '''pozicia na ktoru sa posuva turtle bez pisania
        (pozicia daneho kvetu)'''
    t.pu()
    t.goto(x,y)
    t.pd()

##Kresli 3 kvety so stonkami a listami
pozicia(bob,-150,110)
kvet(bob,7,70,60)
stonka(bob,250,50)
listok(bob,100,60,45)

pozicia(bob,0,110)
kvet(bob,10,140/3,80)
stonka(bob,250,60)
listok(bob,300,25,65)

pozicia(bob,150,110)
kvet(bob,20,490/3,20)
stonka(bob,200,70)
listok(bob,100,80,50)


bob.hideturtle()
turtle.mainloop()
