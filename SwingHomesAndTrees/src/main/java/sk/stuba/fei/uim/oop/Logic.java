package sk.stuba.fei.uim.oop;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

public class Logic extends UniversalAdapter{
    private final JPanel menu;
    private Color c;
    private int cCounter;
    @Getter
    private final JButton treeButton = new JButton("Tree");
    @Getter
    private final JButton move = new JButton("Move");
    @Getter
    private final JButton nextColor = new JButton("Color");
    @Getter
    private final JButton houseButton = new JButton("House");
    @Getter
    private final JLabel label = new JLabel("Tree");
    @Getter
    private final JButton roadButton = new JButton("Road");
    @Getter
    private final Rend can;
    Logic(JPanel menu){
        this.can = new Rend();
        this.menu = menu;

        this.cCounter = 0;
        this.c = Color.ORANGE;

        this.can.addMouseListener(this);
        this.can.addMouseMotionListener(this);

        menu.setBackground(c);
        menu.add(this.treeButton);
        menu.add(this.houseButton);
        menu.add(this.roadButton);
        menu.add(this.move);
        menu.add(this.nextColor);
        menu.add(this.label);

        this.treeButton.addActionListener(this);
        this.houseButton.addActionListener(this);
        this.roadButton.addActionListener(this);
        this.move.addActionListener(this);
        this.nextColor.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.treeButton){
            this.label.setText("Tree");
        }else if(e.getSource() == this.houseButton){
            this.label.setText("House");
        } else if(e.getSource() == this.move){
            this.label.setText("Moving");
        }else if(e.getSource() == this.roadButton){
            this.label.setText("Road");
        } else if(e.getSource() == this.nextColor){
            this.cCounter++;

            if (this.cCounter > 4){
                this.cCounter = 1;
            }
            switch(this.cCounter){
                case(1):
                    this.c = Color.BLUE;
                    break;
                case(2):
                    this.c = Color.RED;
                    break;
                case(3):
                    this.c = Color.GREEN;
                    break;
                case(4):
                    this.c = Color.ORANGE;
            }

            this.menu.setBackground(c);
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {
        if(this.label.getText().equals("Tree")){
            this.can.startDrawTree(e,this.c);
        }
        else if (this.label.getText().equals("House")){
            this.can.startDrawHouse(e, this.c);
        }
        else if (this.label.getText().equals("Road")){
            this.can.startDrawRoad(e);
        }
        else if(this.label.getText().equals("Moving")){
            this.can.startDrag(e);
        }
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        if(this.label.getText().equals("Tree") || this.label.getText().equals("Moving")||this.label.getText().equals("House")){
            this.can.stopDrawAndDrag();
        }
        else if(this.label.getText().equals("Road")){
            this.can.endRoad(e);
        }

    }
    @Override
    public void mouseDragged(MouseEvent e) {
        if(this.label.getText().equals("Tree")){
            this.can.drawTree(e);
        }
        else if(this.label.getText().equals("House")){
            this.can.drawHouse(e);
        }
        else if(this.label.getText().equals("Road")){
            this.can.drawRoad(e);
        }
        else if(this.label.getText().equals("Moving")){
            this.can.drag(e);
        }
    }

}
