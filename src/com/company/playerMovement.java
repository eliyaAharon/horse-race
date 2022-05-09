package com.company;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class playerMovement implements KeyListener {

    private Horse horse;
    private Horse horse1;
    private horseImage horsePlayer;
    private horseImage horsePlayer1;

    public playerMovement(Horse horse, Horse horse1, horseImage horsePlayer, horseImage horsePlayer1) {
        this.horse = horse;
        this.horse1 = horse1;
        this.horsePlayer = horsePlayer;
        this.horsePlayer1 = horsePlayer1;
    }

    public void keyTyped(KeyEvent e) {

    }


    public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_UP:
                    this.horse.moveUpp();
                    this.horsePlayer.moveUpp();
                    break;
                case KeyEvent.VK_DOWN:
                    this.horse.moveDown();
                    this.horsePlayer.moveDown();
                    break;
            case KeyEvent.VK_RIGHT:
                this.horse.moveRight();
                this.horsePlayer.moveRight();
                break;
            case KeyEvent.VK_W:
                this.horse1.moveUpp();
                this.horsePlayer1.moveUpp();
                break;
            case KeyEvent.VK_D:
                this.horse1.moveRight();
                this.horsePlayer1.moveRight();
                break;
            case KeyEvent.VK_S:
                this.horse1.moveDown();
                this.horsePlayer1.moveDown();
                break;

        }
    }


    public void keyReleased(KeyEvent e) {

    }
}






