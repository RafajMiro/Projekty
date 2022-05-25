package sk.stuba.fei.uim.oop;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class MyTree extends Objectities {
    public MyTree(Color c, int x, int y, int treeWidth, int treeHeight){
        this.color = c;
        this.x = x;
        this.y = y;
        this.objHeight = treeHeight;
        this.objWidth = treeWidth;
        this.name = 1;
    }
    @Override
    public void draw(Graphics g){
        g.setColor(this.color);
        g.fillOval(x, y, objWidth,objHeight / 3 * 2 );
        g.fillRect(x + objWidth / 3 , y + objHeight / 2, objWidth / 3, objHeight / 2);
    }
    @Override
    public boolean clicked(int cx, int cy){
        Rectangle rect = new Rectangle(x + objWidth / 3 , y + objHeight / 2, objWidth / 3, objHeight / 2);
        Ellipse2D ellipse = new Ellipse2D.Double(x, y, objWidth,(double) objHeight / 3 * 2 );
        return rect.contains(cx,cy)||ellipse.contains(cx,cy);
    }
}