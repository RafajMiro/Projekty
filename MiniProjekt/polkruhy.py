import turtle
import math

bob=turtle.Turtle()
bob.speed(100)

def polyline(t,n,lenght,angle):
    ''' vykresli n line
        t=turtle
        n=pocet segmentov
        lenght= dlzka kazdeho segmentu
        angle= stupne medzi segmentami'''
    for i in range(n):
        t.lt(angle)
        t.fd(lenght)
        
def polygon(t,n,lenght):
    ''' kresli polygon s n stranami
        t=turtle
        lenght=dlzka kazdej strany'''
    angle=360/n
    polyline(t,n,lenght,angle)

def arc(t,r,angle):
    '''kresli cast kruznice(arc) s danym polomerom a uhlom
        t=turtle
        r=polomer
        angle= uhol'''
    arc_lenght= 2*math.pi*r*angle/360
    n= int(arc_lenght/3)+1
    step_lenght= arc_lenght/n
    step_angle= float(angle)/n
    polyline(t,n,step_lenght,step_angle)

bob.hideturtle()

