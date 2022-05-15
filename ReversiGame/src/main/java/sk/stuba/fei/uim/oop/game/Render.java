package sk.stuba.fei.uim.oop.game;

import sk.stuba.fei.uim.oop.board.Board;
import sk.stuba.fei.uim.oop.stones.Stones;

import javax.swing.*;
import java.awt.*;

public class Render extends JPanel {
    private final Board board;
    private final Stones stones;
    public Render(Board board, Stones stones){
        this.board = board;
        this.stones = stones;
        this.setBackground(new Color(175, 120, 150));
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        this.board.draw(g);
        this.stones.draw(g);
    }
}
