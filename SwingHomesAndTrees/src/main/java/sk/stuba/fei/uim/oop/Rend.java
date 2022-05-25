package sk.stuba.fei.uim.oop;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class Rend extends JPanel {
    private MyTree tree;
    private House house;
    @Getter
    private final List<Objectities> all;
    private Objectities obj;
    @Getter
    private final List<Route66> roads;
    private Route66 road;
    private int x;
    private int y;
    public Rend() {
        this.setBackground(new Color(185, 130, 160));
        this.all = new ArrayList<>();
        this.roads = new ArrayList<>();
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        this.all.forEach(listAll -> listAll.draw(g));
        this.roads.forEach(listRoad -> listRoad.drawRoad(g));
    }
    public void startDrawRoad(MouseEvent e){
        for(int i = this.all.size() - 1; i >= 0; i--){
            Objectities listAll = this.all.get(i);
            if(listAll.clicked(e.getX(),e.getY())){
                this.x = listAll.getX() + listAll.getObjWidth()/2;
                this.y = listAll.getY() + listAll.getObjHeight()/2;
                this.road = new Route66(this.x,this.y,this.x,this.y);
                this.road.setStartObj(listAll.name);
                this.roads.add(this.road);
            }
        }
        this.repaint();
    }
    public void startDrawTree(MouseEvent e, Color c){
        this.x = e.getX();
        this.y = e.getY();
        this.tree = new MyTree(c,this.x,this.y,0,0);
        this.obj = new MyTree(c,this.x,this.y,0,0);
        this.all.add(this.tree);
        this.repaint();
    }
    public void startDrawHouse(MouseEvent e, Color c){
        this.x = e.getX();
        this.y = e.getY();
        this.house = new House(c,this.x,this.y,0,0);
        this.obj = new House(c,this.x,this.y,0,0);
        this.all.add(this.house);
        this.repaint();
    }
    public void drawTree(MouseEvent e){
        if (e.getX() >= this.x){
            this.tree.setObjWidth(e.getX() - this.x);
            this.tree.setX(this.x);
        }else{
            this.tree.setObjWidth(this.x - e.getX());
            this.tree.setX(e.getX());
        }
        if(e.getY() >= this.y){
            this.tree.setObjHeight(e.getY() - this.y);
            this.tree.setY(this.y);
        }else{
            this.tree.setObjHeight(this.y - e.getY());
            this.tree.setY(e.getY());
        }
        this.repaint();
    }
    public void drawHouse(MouseEvent e){
        if (e.getX() >= this.x){
            this.house.setObjWidth(e.getX() - this.x);
            this.house.setX(this.x);
        }else{
            this.house.setObjWidth(this.x - e.getX());
            this.house.setX(e.getX());
        }
        if(e.getY() >= this.y){
            this.house.setObjHeight(e.getY() - this.y);
            this.house.setY(this.y);
        }else{
            this.house.setObjHeight(this.y - e.getY());
            this.house.setY(e.getY());
        }
        this.repaint();
    }
    public void drawRoad(MouseEvent e){
        if (this.road != null){
            this.road.setEntX(e.getX());
            this.road.setEndY(e.getY());
        }
        this.repaint();
    }
    public void startDrag(MouseEvent e){
        for(int i = this.all.size() - 1; i >= 0; i--){
            Objectities listAll = this.all.get(i);
            if(listAll.clicked(e.getX(),e.getY())){
                this.obj = listAll;
                this.x = e.getX() - listAll.getX();
                this.y = e.getY() - listAll.getY();
                break;
            }
        }
    }

    public void drag(MouseEvent e){
        if(this.obj != null){
            this.obj.setX(e.getX() - this.x);
            this.obj.setY(e.getY() - this.y);
        }
        this.repaint();
    }
    public void endRoad(MouseEvent e){
        if(this.road != null) {
            int startedX = this.road.getStartX();
            int startedY = this.road.getStartY();
            int startedObj = this.road.getStartObj();

            this.roads.remove(this.road);
            this.road = null;

            for (int i = this.all.size() - 1; i >= 0; i--) {
                Objectities listAll = this.all.get(i);
                if (listAll.clicked(e.getX(), e.getY()) && listAll.getName() != startedObj) {
                    this.x = listAll.getX() + listAll.getObjWidth() / 2;
                    this.y = listAll.getY() + listAll.getObjHeight() / 2;
                    this.road = new Route66(startedX, startedY, this.x, this.y);
                    this.roads.add(this.road);

                }
            }
            this.x = 0;
            this.y = 0;
        }
        this.repaint();
    }
    public void stopDrawAndDrag(){
        this.x = 0;
        this.y = 0;
        this.tree = null;
        this.house = null;
        this.obj = null;

    }
}
