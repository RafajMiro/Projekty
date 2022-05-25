package sk.stuba.fei.uim.oop;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;

public class Objectities {
    @Setter
    @Getter
    protected Color color;
    @Setter
    @Getter
    protected int x;
    @Setter
    @Getter
    protected int y;
    @Setter
    @Getter
    protected int objHeight;
    @Setter
    @Getter
    protected int objWidth;
    @Getter
    protected int name;
    public boolean clicked(int cx, int cy){
        return false;
    }
    public void draw(Graphics g){

    }
}
