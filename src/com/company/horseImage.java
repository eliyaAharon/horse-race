package com.company;
import javax.swing.*;
import java.awt.*;

public class horseImage {

    private double x;
    private int y;
    private ImageIcon horse;

    public void setX(double x) {
        this.x = x;
    }

    public double getX() {
        return x;
    }

    public horseImage(ImageIcon horse , int x, int y){
        this.horse = horse;
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void paint(Graphics g) {
    horse.paintIcon((Component) null,g, (int) this.x,this.y);
    }

    public void moveUpp() {
        this.y -= 5;
    }

    public void moveDown() {
        this.y += 5;
    }

    public void moveRight() {
        this.x += 5;
    }

    public void moveLeft() {
        this.x -= 0.10;
    }

}
