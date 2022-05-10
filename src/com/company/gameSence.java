package com.company;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Random;

public class gameSence extends JPanel {

    //fields

    private playerMovement playerMovement;
    private int x = 30, y = 82, width = 116, height = 50;
    private int y2 = 335;

    private Horse player1;
    private Horse player2;
    private ImageIcon horse;
    private ImageIcon horse1;
    private horseImage imageOfPlayer1;
    private horseImage imageOfPlayer2;
    Main m = new Main() ;


    private JLabel player1Label;
    private JLabel player2Label;
    private JLabel finishField;


    // private winScreen winScreen;

    private Horse[] horseObstacles;
    private ImageIcon enemyImageIcon;
    private horseImage[] horseEnemy;

    private Horse[] squares;


    private int[] indexOfObstacles = new int[4];

    private ImageIcon winOfPlayer1;
    private ImageIcon winOfPlayer2;
    private JLabel winOfPlayer1Label;
    private JLabel winOfPlayer2Label;


    // constractor
    public gameSence(int x, int y, int width, int height) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        System.out.println(loginWindow.name1);
        this.setLayout(null);
        this.setBounds(x, y, width, height);
        this.setBackground(Color.orange.darker().darker().darker());


        horse = new ImageIcon("animated-equestrian-and-horseb-unscreen.gif");
        horse1 = new ImageIcon("animated-equestrian-and-horseb-unscreen.gif");
        enemyImageIcon = new ImageIcon("gifHorseEnemy.gif");


        this.imageOfPlayer1 = new horseImage(horse, this.x, this.y);
        this.imageOfPlayer2 = new horseImage(horse, this.x, this.y2);

        this.player1 = new Horse(this.x, this.y, this.width, this.height, Color.orange.darker().darker().darker());
        this.player2 = new Horse(this.x, this.y2, this.width, this.height, Color.orange.darker().darker().darker());

        // obstacles setting
        this.horseObstacles = new Horse[1000];
        this.horseEnemy = new horseImage[1000];
        Random ran = new Random();


        for (int i = 0; i < horseObstacles.length; i++) {
            int randomIndex = ran.nextInt(0, 500);
            horseImage enemy = new horseImage(enemyImageIcon, 1110, randomIndex);
            this.horseEnemy[i] = enemy;
            Horse obstacle = new Horse(1100, randomIndex, 30, 30, Color.orange.darker().darker().darker());
            this.horseObstacles[i] = obstacle;

        }
        //player1 Label
        player1Label = new JLabel();
        this.player1Label.setBounds(50, 0, 80, 25);
        Font myDeafaultFont = new Font("Arial", Font.BOLD, 15);
        player1Label.setFont(myDeafaultFont);
        player1Label.setText(loginWindow.name1);
        this.add(player1Label);
        player1Label.setBackground(Color.WHITE);
        player1Label.setForeground(Color.orange.darker().darker().darker());
        player1Label.setOpaque(true);

        //player 2 Label
        this.player2Label = new JLabel();
        player2Label.setBounds(50, 235, 80, 25);
        player2Label.setFont(myDeafaultFont);
        player2Label.setText(loginWindow.name2);
        this.add(player2Label);
        player2Label.setBackground(Color.WHITE);
        player2Label.setForeground(Color.orange.darker().darker().darker());
        player2Label.setOpaque(true);
        // finish field
        finishField = new JLabel();
        finishField.setBounds(900, 212, 85, 40);
        Font finishFont = new Font("Arial", Font.BOLD, 40);
        finishField.setFont(finishFont);
        finishField.setText("END");
        this.add(finishField);
        finishField.setBackground(null);
        finishField.setForeground(Color.WHITE);
        finishField.setOpaque(true);

        // win lab player1


        this.winOfPlayer1Label = new JLabel();
        this.winOfPlayer1Label.setBounds(0, 0, 1000, 500);
        this.winOfPlayer1 = new ImageIcon("player1Won.png");
        this.winOfPlayer1Label.setIcon(winOfPlayer1);
        this.winOfPlayer1Label.setVisible(false);
        this.add(winOfPlayer1Label);


        // win lab player2
        this.winOfPlayer2Label = new JLabel();
        this.winOfPlayer2Label.setBounds(0, 0, 1000, 500);
        this.winOfPlayer2 = new ImageIcon("Player 2 win2.png");
        this.winOfPlayer2Label.setIcon(winOfPlayer2);
        this.winOfPlayer2Label.setVisible(false);
        this.add(winOfPlayer2Label);

        this.mainGameLoop();


    }

    // paint method
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // middle line
        g.setColor(Color.white);
        g.fillRect(0, 232, 1000, 3);
        // players
        this.player1.paint(g);
        this.player2.paint(g);

        // start field
        squares = new Horse[20];
        int x = 0;
        int y = 0;
        int width = 25;
        int height = 25;
        for (int i = 0; i < squares.length; i += 2) {
            g.setColor(Color.WHITE);
            g.fillRect(x, y, width, height);
            y += 50;
        }
        y = 25;
        for (int i = 1; i < squares.length; i += 2) {
            g.setColor(Color.BLACK);
            g.fillRect(x, y, width, height);
            y += 50;
        }
        x = 25;
        y = 0;
        for (int i = 0; i < squares.length; i += 2) {
            g.setColor(Color.BLACK);
            g.fillRect(x, y, width, height);
            y += 50;
        }
        y = 25;
        for (int i = 1; i < squares.length; i += 2) {
            g.setColor(Color.WHITE);
            g.fillRect(x, y, width, height);
            y += 50;
        }
        this.imageOfPlayer1.paint(g);
        this.imageOfPlayer2.paint(g);
        for (int i = 0; i < this.horseObstacles.length; i++) {
            this.horseEnemy[i].paint(g);
            this.horseObstacles[i].paint(g);
        }


    }

    public boolean Win() {
        if (this.player1.getX() > 883 || this.player2.getX() > 883) {
            return true;
        }
        return false;
    }

    public void mainGameLoop() {
        Thread t = new Thread(() -> {

            playerMovement = new playerMovement(player1, player2, imageOfPlayer1, imageOfPlayer2);
            this.setFocusable(true);
            this.requestFocus();
            this.addKeyListener(playerMovement);
            first:
            while (true) {
                try {
                    repaint();
                    Thread.sleep(1);
                    if (Win()) {
                        if (this.player1.getX() > 883) {
                            this.player1Label.setVisible(false);
                            this.player2Label.setVisible(false);
                            this.finishField.setVisible(false);

                            this.winOfPlayer1Label.setVisible(true);
                            break;
                        }
                        if (this.player2.getX() > 883) {
                            this.player1Label.setVisible(false);
                            this.player2Label.setVisible(false);
                            this.finishField.setVisible(false);
                            this.winOfPlayer2Label.setVisible(true);
                            break;
                        }
                    }
                    for (int i = 0; i < horseObstacles.length; i++) {
                        if (this.player1.checkColision(horseObstacles[i])) {
                            this.player1.setX(30);
                            this.imageOfPlayer1.setX(30);
                        }
                        if (this.player2.checkColision(horseObstacles[i])) {
                            this.player2.setX(30);
                            this.imageOfPlayer2.setX(30);
                        }

                    }
                    this.moveTheObstacles();
                    this.limits();


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();

    }

    public void limits() {
        if (this.player1.getY() < 0) {
            player1.moveDown();
            imageOfPlayer1.moveDown();
        }

        if (this.player1.getY() > 227 - player1.getHeight()) {
            player1.moveUpp();
            imageOfPlayer1.moveUpp();
        }

        if (this.player1.getX() < 0) {
            player1.moveRight();
            imageOfPlayer1.moveRight();
        }

        if (this.player2.getY() < 232) {
            player2.moveDown();
            imageOfPlayer2.moveDown();
        }

        if (this.player2.getY() > 455 - player2.getHeight()) {
            player2.moveUpp();
            imageOfPlayer2.moveUpp();
        }


    }


    public void moveTheObstacles() {
        Thread t = new Thread(() -> {
            while (true) {
                for (int i = 0; i < horseObstacles.length; i++) {
                    try {
                        horseObstacles[i].moveLeft();
                        horseEnemy[i].moveLeft();
                        Thread.sleep(2000);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        });
        t.start();
    }


}
