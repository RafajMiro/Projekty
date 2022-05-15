package sk.stuba.fei.uim.oop.stones;

import lombok.Getter;

public enum Direction {
    UP(0,-1),
    DOWN(0,1),
    RIGHT(1,0),
    LEFT(-1,0),
    UPRIGHT(1,-1),
    UPLEFT(-1,-1),
    DOWNRIGHT(1,1),
    DOWNLEFT(-1,1);

    @Getter
    private final int x1;
    @Getter
    private final int y1;

    Direction(int x1, int y1){
        this.x1 = x1;
        this.y1 = y1;
    }

}
