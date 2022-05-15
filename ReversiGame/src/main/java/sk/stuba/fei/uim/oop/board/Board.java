package sk.stuba.fei.uim.oop.board;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.game.Node;

import java.awt.*;

public class Board {
    @Getter
    @Setter
    private int sizeOfBoard;
    private Node[][] board;
    @Getter
    @Setter
    private int startPoint;
    public void boardInitialization(){
        if(this.sizeOfBoard == 0){
            this.sizeOfBoard = 6;
        }else{
            this.sizeOfBoard = this.getSizeOfBoard();
        }
        switch(this.sizeOfBoard){
            case(12):
                this.startPoint = 10;
                break;
            case(10):
                this.startPoint = 50;
                break;
            case(8):
                this.startPoint = 90;
                break;
            case(6):
                this.startPoint = 130;
                break;
        }
        this.board = new Node[this.sizeOfBoard][this.sizeOfBoard];
        for(int i = 0; i < this.sizeOfBoard; i++){
            for(int j = 0; j < this.sizeOfBoard; j++){
                this.board[i][j] = new Node(j,i,this.startPoint);
                this.board[i][j].setStone(false);
            }
        }
    }
    public void draw(Graphics g){
        boardInitialization();
        for(int i = 0; i < this.sizeOfBoard; i++){
            for(int j = 0; j < this.sizeOfBoard; j++){
                if((i%2==0 && j%2==0)||(i%2!=0 &&j%2!=0)) {
                    g.setColor(new Color(175, 120, 150));
                }else{
                    g.setColor(new Color(185, 130, 160));
                }
                this.board[i][j].draw(g);
            }
        }
        g.drawRect(Node.OFFSET,Node.OFFSET,484,484);
    }
}
