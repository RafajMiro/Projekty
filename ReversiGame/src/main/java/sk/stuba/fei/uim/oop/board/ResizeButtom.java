package sk.stuba.fei.uim.oop.board;

import sk.stuba.fei.uim.oop.controls.Logic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResizeButtom extends JButton implements ActionListener{
    private final Logic logic;
    private final Resize resize;

    public ResizeButtom(Logic logic, Resize resize) {
        super(resize.getLabel());
        this.logic = logic;
        this.resize = resize;
        this.setFocusable(false);
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Press");
        this.logic.getBoard().setSizeOfBoard(this.resize.getSize());
        this.logic.getStones().setSizeOfBoard(this.resize.getSize());
        this.logic.gameReset();
        this.logic.stoneFirstInitialization(this.logic.getStones().getSizeOfBoard());
        this.logic.updateCurrentLable();
        this.logic.repaint();
    }
}
