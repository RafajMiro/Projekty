package sk.stuba.fei.uim.oop.controls;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.game.Render;
import sk.stuba.fei.uim.oop.board.Board;
import sk.stuba.fei.uim.oop.stones.Stones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Logic extends UniversalAdapter {
    @Getter
    private final Board board;
    @Getter
    private final Stones stones;
    @Getter
    private final Render render;
    @Getter
    private final JLabel lable;
    @Getter
    private final JLabel winner;
    @Getter
    @Setter
    private int playedStones;
    public static Color MYWHITE = new Color(200,200,200);
    public static Color MYGREY = new Color(55,55,55);
    public Logic(){
        this.board = new Board();
        this.stones = new Stones();
        this.render = new Render(this.board,this.stones);
        this.render.addMouseListener(this);
        this.render.addMouseMotionListener(this);
        this.lable = new JLabel();
        this.winner = new JLabel();
        this.stoneFirstInitialization(6);
        this.updateCurrentLable();
    }
    public void stoneFirstInitialization(int sizeOfBoard){
        this.stones.createStones(sizeOfBoard/2 -1,sizeOfBoard/2 -1, MYGREY);
        this.stones.createStones(sizeOfBoard/2 ,sizeOfBoard/2 , MYGREY);
        this.stones.createStones(sizeOfBoard/2 ,sizeOfBoard/2 -1, MYWHITE);
        this.stones.createStones(sizeOfBoard/2 -1,sizeOfBoard/2 , MYWHITE);
        this.stones.possibleMove();
    }
    public void repaint(){
        this.render.repaint();
    }

    public void updateCurrentLable(){
        this.lable.setText("  Size: "+this.stones.getSizeOfBoard()+"x"+this.stones.getSizeOfBoard());
    }
    public void gameOver(){
        updateWinner("Player");

    }
    public void updateWinner(String winner){
        this.winner.setText("winer is "+winner);
    }
    public void gameReset(){
        this.stones.stoneInitialization();
    }

    @Override
    public void actionPerformed(ActionEvent e){
        System.out.println("Press");
        this.board.setSizeOfBoard(this.board.getSizeOfBoard());
        this.stones.setSizeOfBoard(this.stones.getSizeOfBoard());
        gameReset();
        this.stoneFirstInitialization(this.board.getSizeOfBoard());
        this.updateCurrentLable();
        this.repaint();

    }

    @Override
    public void mousePressed(MouseEvent e) {
        for(int i = 0; i < this.board.getSizeOfBoard(); i++){
            for (int j = 0; j < this.board.getSizeOfBoard(); j++){
                if(e.getX() > this.stones.getStones()[i][j].getLine() && e.getX() < this.stones.getStones()[i][j].getLine() +40 && e. getY() > this.stones.getStones()[i][j].getColumn() && e.getY() < this.stones.getStones()[i][j].getColumn()+40){
                    if(this.stones.getStones()[i][j].isPossibleMovement()) {
                        this.playedStones++;
                        System.out.println("Click");
                        this.stones.playTurn(this.stones.getStones()[i][j],1);
                        this.repaint();

                        if (this.playedStones == this.stones.getSizeOfBoard() * this.stones.getSizeOfBoard()) {
                            gameOver();
                        }
                    }
                }
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) System.exit(0);

        if (e.getKeyCode() == KeyEvent.VK_R){
            this.board.setSizeOfBoard(this.board.getSizeOfBoard());
            this.stones.setSizeOfBoard(this.stones.getSizeOfBoard());
            gameReset();
            this.stoneFirstInitialization(this.board.getSizeOfBoard());
            this.updateCurrentLable();
            this.repaint();
        }
    }
}