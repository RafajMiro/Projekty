package sk.stuba.fei.uim.oop.game;

import sk.stuba.fei.uim.oop.board.ResizeButtom;
import sk.stuba.fei.uim.oop.controls.Logic;
import sk.stuba.fei.uim.oop.board.Resize;


import javax.swing.*;
import java.awt.*;

public class Game {

    public Game(){
        JFrame window = new JFrame("Reversi");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(515,610);
        window.setResizable(false);

        Logic logic = new Logic();
        window.addKeyListener(logic);
        window.add(logic.getRender());

        JPanel menu = new JPanel();
        menu.setBackground(new Color(185, 130, 160));
        menu.setBorder(BorderFactory.createLineBorder(new Color(100,45,75)));

        JButton reset = new JButton("reset");
        reset.addActionListener(logic);
        reset.setFocusable(false);

        menu.add(reset);
        menu.add(new ResizeButtom(logic, Resize.B6x6));
        menu.add(new ResizeButtom(logic, Resize.B8x8));
        menu.add(new ResizeButtom(logic, Resize.B10x10));
        menu.add(new ResizeButtom(logic, Resize.B12x12));
        menu.add(logic.getLable());
        menu.add(logic.getWinner());

        window.add(menu, BorderLayout.SOUTH);

        window.setVisible(true);
    }


}