package sk.stuba.fei.uim.oop;

import java.awt.*;

public class House extends Objectities{
    public House(Color c, int x, int y, int houseWidth, int houseHeight){
        this.color = c;
        this.x = x;
        this.y = y;
        this.objWidth = houseWidth;
        this.objHeight = houseHeight;
        this.name = 2;
    }
    @Override
    public void draw(Graphics g){
        g.setColor(this.color);
        g.fillPolygon(new int[]{this.x + this.objWidth/4, this.x + this.objWidth/2, this.x + (3 * this.objWidth)/4}, new int[]{this.y + this.objHeight/2, this.y, this.y + this.objHeight/2}, 3);
        g.fillRect(this.x + this.objWidth/4, this.y + this.objHeight/2,this.objWidth/2,this.objHeight/2);
    }
    @Override
    public boolean clicked(int cx, int cy){
        Rectangle rect = new Rectangle(this.x + this.objWidth/4, this.y + this.objHeight/2,this.objWidth/2,this.objHeight/2);
        Polygon pol = new Polygon(new int[]{this.x + this.objWidth/4, this.x + this.objWidth/2, this.x + (3 * this.objWidth)/4}, new int[]{this.y + this.objHeight/2, this.y, this.y + this.objHeight/2}, 3);
        return rect.contains(cx,cy)||pol.contains(cx,cy);
    }
}
