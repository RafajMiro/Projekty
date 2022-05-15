import turtle
from polkruhy import arc

turtle.speed(100)

def lupen(strany,angle):
    for i in range(2):
        arc(turtle,strany,angle)
        turtle.left(180-angle)

def kvet(pocet,strany,angle):
    for i in range(pocet):
        lupen(strany,angle)
        turtle.left(360/pocet)

def stonka(stonkaradius,stonkauhol):
    turtle.seth(270)
    turtle.right(stonkauhol/2)
    arc(turtle, stonkaradius,stonkauhol)

def list(stranylist,uholist,uholistzem):
    turtle.seth(0)
    turtle.left(uholistzem-uholist/2)
    for i in range(2):
        arc(turtle,stranylist,uholist)
        turtle.left(180-uholist)
    turtle.seth(180)
    turtle.right(uholistzem+uholist/2)
    for i in range(2):
        arc(turtle,stranylist,uholist)
        turtle.left(180-uholist)

def flower(pocet,strany,angle,stonkaradius,stonkauhol,stranylist,uholist,uholistzem):
    kvet(pocet,strany,angle)
    stonka(stonkaradius,stonkauhol)
    list(stranylist,uholist,uholistzem)

turtle.up()
turtle.setx(-150)
turtle.sety(110)
turtle.down()
flower(7,60,60,250,50,100,60,45)

turtle.up()
turtle.home()
turtle.sety(110)
turtle.down()
flower(10,40,80,250,60,300,25,65)

turtle.up()
turtle.setx(150)
turtle.sety(110)
turtle.down()
flower(20,140,20,200,70,100,80,50)

turtle.hideturtle()
turtle.mainloop()
