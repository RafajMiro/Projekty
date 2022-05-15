package sk.stuba.fei.uim.oop.stones;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.game.Node;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class Stones {
    public static Color MYWHITE = new Color(200,200,200);
    public static Color MYGREY = new Color(55,55,55);
    @Getter
    @Setter
    private int sizeOfBoard;
    @Getter
    @Setter
    private int startPoint;
    @Getter
    private Node[][] stones;
    private final List<Node> startStones;

    public Stones(){
        this.startStones = new ArrayList<>();
        stoneInitialization();
    }

    public void stoneInitialization(){
        if(this.sizeOfBoard > 0 ){
            this.sizeOfBoard = this.getSizeOfBoard();
        }else{
            this.sizeOfBoard = 6;
        }
        switch (this.sizeOfBoard){
            case(6):
                this.startPoint = 130;
                break;
            case(8):
                this.startPoint = 90;
                break;
            case(10):
                this.startPoint = 50;
                break;
            case (12):
                this.startPoint = 10;
                break;
        }
        this.stones = new Node[this.sizeOfBoard][this.sizeOfBoard];
        for(int i = 0; i < this.sizeOfBoard; i++){
            for (int j = 0; j < this.sizeOfBoard; j++){
                this.stones[i][j] = new Node(j,i,this.startPoint);
                this.stones[i][j].setStone(true);
            }
        }

    }

    public void createStones(int i, int j, Color color){
        this.stones[i][j].setOnBoard(true);
        this.stones[i][j].setColor(color);
    }

    public void findNeighbours(int i, int j){
        if(i != 0){
            if(this.stones[i + Direction.UP.getX1()][j + Direction.UP.getY1()].isOnBoard()){
                this.stones[i][j].addNeighbour(Direction.UP,this.stones[i + Direction.UP.getX1()][j + Direction.UP.getY1()]);
            }
        }if (j != 0){
            if(this.stones[i + Direction.LEFT.getX1()][j + Direction.LEFT.getY1()].isOnBoard()){
                this.stones[i][j].addNeighbour(Direction.LEFT,this.stones[i + Direction.LEFT.getX1()][j + Direction.LEFT.getY1()]);
            }
        }if (i != this.sizeOfBoard - 1){
            if(this.stones[i + Direction.DOWN.getX1()][j + Direction.DOWN.getY1()].isOnBoard()){
                this.stones[i][j].addNeighbour(Direction.DOWN,this.stones[i + Direction.DOWN.getX1()][j + Direction.DOWN.getY1()]);
            }
        }if (j != this.sizeOfBoard - 1){
            if(this.stones[i + Direction.RIGHT.getX1()][j + Direction.RIGHT.getY1()].isOnBoard()){
                this.stones[i][j].addNeighbour(Direction.RIGHT,this.stones[i + Direction.RIGHT.getX1()][j + Direction.RIGHT.getY1()]);
            }
        }

        if (i != 0 || j != 0){
            if(this.stones[i + Direction.UPLEFT.getX1()][j + Direction.UPLEFT.getY1()].isOnBoard()){
                this.stones[i][j].addNeighbour(Direction.UPLEFT,this.stones[i + Direction.UPLEFT.getX1()][j + Direction.UPLEFT.getY1()]);
            }
        }if (i != this.sizeOfBoard - 1 || j != this.sizeOfBoard -1 ){
            if(this.stones[i + Direction.DOWNRIGHT.getX1()][j + Direction.DOWNRIGHT.getY1()].isOnBoard()) {
                this.stones[i][j].addNeighbour(Direction.DOWNRIGHT, this.stones[i + Direction.DOWNRIGHT.getX1()][j + Direction.DOWNRIGHT.getY1()]);
            }
        }if (i != 0 || j != this.sizeOfBoard -1 ){
            if(this.stones[i + Direction.UPRIGHT.getX1()][j + Direction.UPRIGHT.getY1()].isOnBoard()) {
                this.stones[i][j].addNeighbour(Direction.UPRIGHT, this.stones[i + Direction.UPRIGHT.getX1()][j + Direction.UPRIGHT.getY1()]);
            }
        }if (i != this.sizeOfBoard -1 || j != 0){
            if(this.stones[i + Direction.DOWNLEFT.getX1()][j + Direction.DOWNLEFT.getY1()].isOnBoard()) {
                this.stones[i][j].addNeighbour(Direction.DOWNLEFT, this.stones[i + Direction.DOWNLEFT.getX1()][j + Direction.DOWNLEFT.getY1()]);
            }
        }
    }

    public void possibleMove(){
        int sameColor;
        for(int i = 0; i < this.sizeOfBoard; i++){
            for(int j = 0; j < this.sizeOfBoard; j++){
                if(this.stones[i][j].isOnBoard()){
                    findNeighbours(i,j);
                    ArrayList<Node> allMYNeighbours = new ArrayList<>(this.stones[i][j].getNeighbours());
                    Node help;
                    for (Node allNeighbour : allMYNeighbours) {
                        if(!this.stones[i][j].getColor().equals(allNeighbour.getColor())) {
                            sameColor = 1;
                            help = allNeighbour;
                            this.stones[i][j].addPossibleStone(allNeighbour.getDirection(),this.stones[allNeighbour.getIndexY() + allNeighbour.getDirection().getX1() * sameColor][allNeighbour.getIndexX() + allNeighbour.getDirection().getY1() * sameColor]);
                            this.stones[allNeighbour.getIndexY() + allNeighbour.getDirection().getX1() * sameColor][allNeighbour.getIndexX() + allNeighbour.getDirection().getY1() * sameColor].setStartStone(this.stones[i][j]);
                            this.startStones.add(this.stones[i][j]);
                            if(this.stones[i][j].getColor().equals(MYWHITE)){
                                this.stones[allNeighbour.getIndexY() + allNeighbour.getDirection().getX1() * sameColor][allNeighbour.getIndexX() + allNeighbour.getDirection().getY1() * sameColor].setPossibleMovement(true);
                                System.out.println(i+" x "+j+" + "+allNeighbour.getDirection().getX1()+" x "+allNeighbour.getDirection().getY1()+" = "+allNeighbour.getIndexY()+" x "+allNeighbour.getIndexX());
                            }
                        }
                    }
                    System.out.println("=========================");
                }
                this.stones[i][j].clearNeighbour();
            }
        }
    }

    public void stoneSwap(Node node, Color color){
        int division = 0;

        if(node.getDirection() == Direction.RIGHT || node.getDirection() == Direction.UPRIGHT || node.getDirection() == Direction.DOWNRIGHT){
            division = node.getIndexY() - node.getStartStone().getIndexY() - 1;
        }else if(node.getDirection() == Direction.LEFT || node.getDirection() == Direction.UPLEFT || node.getDirection() == Direction.DOWNLEFT) {
            division = node.getStartStone().getIndexY() - node.getIndexY() - 1;
        }else if(node.getDirection() == Direction.UP){
            division = node.getStartStone().getIndexX() - node.getIndexX() - 1;
        }else if(node.getDirection() == Direction.DOWN){
            division = node.getIndexX() - node.getStartStone().getIndexX() - 1;
        }

        for(int i = 0; i < division; i++){
            this.stones[node.getStartStone().getIndexY() + node.getDirection().getX1()][node.getStartStone().getIndexX() + node.getDirection().getY1()].setColor(color);
        }
        node.setPossibleMovement(false);
        node.clearPossibleStone();

        createStones(node.getIndexY(), node.getIndexX(), color);

        for (Node startStone : this.startStones) {
            for (int j = 0; j < startStone.getPossibleStone().size(); j++) {
                startStone.getPossibleStone().get(j).setPossibleMovement(false);
            }
            startStone.clearPossibleStone();
        }
        this.startStones.clear();
        possibleMove();
    }

    public void playTurn(Node node, int play){
        Color color;
        if(play == 1){
            color = MYWHITE;
        }else{
            color = MYGREY;
        }
        stoneSwap(node,color);
        Node nextMove = node;
        for (Node startStone : this.startStones) {
            if (startStone.getColor().equals(MYGREY)) {
                nextMove = startStone.getPossibleStone().get(0);
                break;
            }
        }
        if(nextMove == node){
            play = 0;
        }

        if(play == 1){
            playTurn(nextMove,0);
        }
    }

    public void draw(Graphics g){
        for(int i = 0; i < this.sizeOfBoard; i++){
            for(int j = 0; j < this.sizeOfBoard; j++){
                g.setColor(this.stones[i][j].getColor());
                this.stones[i][j].draw(g);
            }
        }
    }
}
