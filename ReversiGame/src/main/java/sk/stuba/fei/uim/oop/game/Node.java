package sk.stuba.fei.uim.oop.game;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.stones.Direction;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;


public class Node {
    @Getter
    @Setter
    private Color color;
    public static int NODE_SIZE = 40;
    public static int OFFSET = 10;
    @Getter
    private final int indexX;
    @Getter
    private final int indexY;
    @Getter
    private final int line;
    @Getter
    private final int column;
    @Setter
    private boolean isStone;
    @Setter
    @Getter
    private boolean isOnBoard;
    @Setter
    @Getter
    private boolean possibleMovement;
    @Getter
    @Setter
    private Direction direction;
    @Getter
    private final List<Node> neighbours;
    @Getter
    private final List<Node> possibleStone;
    @Getter
    @Setter
    private Node startStone;

    public Node(int x, int y, int startPoint){
        this.line = x * NODE_SIZE + OFFSET / 5 + startPoint;
        this.column = y * NODE_SIZE + OFFSET / 5 + startPoint;
        this.neighbours = new ArrayList<>();
        this.possibleStone = new ArrayList<>();
        this.indexY = y;
        this.indexX = x;
    }

    public void addNeighbour(Direction direction, Node node) {
        node.direction = direction;
        this.neighbours.add(node);
    }

    public void clearNeighbour(){
        this.neighbours.clear();
    }

    public void addPossibleStone(Direction direction, Node node){
        node.direction = direction;
        this.possibleStone.add(node);
    }

    public void clearPossibleStone(){
        this.possibleStone.clear();
    }

    public void draw(Graphics g){
        if(!this.isStone) {
            g.fillRect(this.line, this.column, NODE_SIZE, NODE_SIZE);
            g.setColor(new Color(100, 45, 75));
            g.drawRect(this.line, this.column, NODE_SIZE, NODE_SIZE);
        }else{
            if(this.isOnBoard) {
                this.setColor(this.color);
                g.fillOval(this.line + 2, this.column + 2, NODE_SIZE - 4, NODE_SIZE - 4);
                g.setColor(new Color(127,127,127));
                g.drawOval(this.line + 2, this.column + 2, NODE_SIZE - 4, NODE_SIZE - 4);

            }else if(this.possibleMovement){
                g.setColor(Color.ORANGE);
                g.drawOval(this.line + 4,this.column + 4, NODE_SIZE - 8, NODE_SIZE - 8);
                g.drawOval(this.line + 6,this.column + 6, NODE_SIZE - 12, NODE_SIZE - 12);
            }
        }
    }
}
