package sk.stuba.fei.uim.oop;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;

public class Route66 {
    @Getter
    @Setter
    private int startX;
    @Getter
    @Setter
    private int startY;
    @Getter
    @Setter
    private int entX;
    @Getter
    @Setter
    private int endY;
    @Setter
    @Getter
    private  int startObj;
    public Route66(int xStart, int yStart, int xEnd, int yEnd){
        this.startX = xStart;
        this.startY = yStart;
        this.entX = xEnd;
        this.endY = yEnd;
    }
    public void drawRoad(Graphics g){
        g.setColor(Color.BLACK);
        g.drawLine(this.startX,this.startY,this.entX,this.endY);
    }
}
