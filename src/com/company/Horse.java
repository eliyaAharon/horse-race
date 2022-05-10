package com.company;

import java.awt.*;
import java.util.Random;

public class Horse {

    private double x;
    private int y;
    private int width;
    private int height;
    private Color color;

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Color getColor() {
        return color;
    }

    public Horse(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public double getX() {
        return x;
    }

    public void paint(Graphics g) {
        g.setColor(this.color);
        g.drawRect((int) this.x, this.y, this.width, this.height);

    }

    public void moveUpp() {
        this.y -= 7;
    }

    public void moveDown() {
        this.y += 7;
    }

    public void moveRight() {
        this.x += 5;
    }

    public void moveLeft() {
        this.x-= 0.10;
    }

    public void setX(double x) {
        this.x = x;
    }

    public boolean checkColision(Horse other) {
        boolean colision = false;
        Rectangle thisRect = new Rectangle((int) this.x, this.y, this.width, this.height);
        Rectangle otherRect = new Rectangle((int) other.x, other.y, other.width, other.height);
        if (thisRect.intersects(otherRect)) {
            colision = true;
        }
        return colision;
    }

}



