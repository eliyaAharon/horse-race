package com.company;

import com.company.Main;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class loginWindow extends JFrame {
    public static final int WINDOW_WIDTH = 500;
    public static final int WINDOW_HEIGHT = 600;
    private int x = 200, y1 = 150, y2 = 250, width = 200, height = 50;
    public static String name1 = "", name2 = "";


    public loginWindow() {

        // window setting
        this.getContentPane().setBackground(Color.BLACK);
        this.setTitle("login");
        this.setResizable(false);
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);


        // font
        Font myFont = new Font("Arial", Font.BOLD, 22);


        // button setting
        Button button1 = new Button("sign in");
        button1.setFont(myFont);
        button1.setBackground(Color.orange.darker());
        button1.setBounds(90, 400, 300, 70);
        this.add(button1);

        // player1's name
        JTextField namePlayer1 = new JTextField();
        namePlayer1.setBounds(this.x, this.y1, this.width, this.height);
        namePlayer1.setBackground(Color.WHITE);
        namePlayer1.setBackground(Color.orange.darker());
        namePlayer1.setFont(myFont);

        // player2's name
        JTextField namePlayer2 = new JTextField();
        namePlayer2.setBounds(this.x, this.y2, this.width, this.height);
        namePlayer2.setBackground(Color.orange.darker());
        namePlayer2.setFont(myFont);
        this.add(namePlayer2);
        this.add(namePlayer1);
        this.setVisible(true);

        // label of title
        JLabel title = new JLabel("ENTER YOUR NAME TO START GAME");
        title.setBounds(40, 20, 420, 80);
        title.setForeground(Color.orange.darker());
        title.setBackground(Color.BLACK);
        title.setOpaque(true);
        title.setFont(myFont);
        this.add(title);

        // font player Labels
        Font labelsFont = new Font("Arial", Font.BOLD, 15);

        // player 1's label
        JLabel player1Lab = new JLabel("PLAYER 1");
        player1Lab.setBounds(100, this.y1, 170, this.height);
        player1Lab.setForeground(Color.orange.darker());
        player1Lab.setBackground(Color.BLACK);
        player1Lab.setOpaque(true);
        player1Lab.setFont(labelsFont);
        this.add(player1Lab);

        // player 2 's label
        JLabel player2Lab = new JLabel("PLAYER 2");
        player2Lab.setBounds(100, this.y2, 170, this.height);
        player2Lab.setForeground(Color.orange.darker());
        player2Lab.setBackground(Color.BLACK);
        player2Lab.setOpaque(true);
        player2Lab.setFont(labelsFont);
        this.add(player2Lab);

        // error label setting
        JLabel errorLabel = new JLabel("YOU MUST ENTER NAMES");
        errorLabel.setBounds(90, 350, 300, 50);
        errorLabel.setBackground(Color.BLACK.darker());
        errorLabel.setForeground(Color.RED);
        errorLabel.setBackground(Color.BLACK);
        errorLabel.setOpaque(true);
        errorLabel.setFont(myFont);
        errorLabel.setVisible(false);
        this.add(errorLabel);

        // action listener
        button1.addActionListener((e -> {
            this.name1 = namePlayer1.getText();
            this.name2 = namePlayer2.getText();
            if (this.name1.equals("") || this.name2.equals("")) {
                errorLabel.setVisible(true);
            } else {
                try {
                   Main main = new Main();
                   main.run();
                    this.dispose();
                } catch (UnsupportedAudioFileException ex) {
                    ex.printStackTrace();
                } catch (LineUnavailableException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

        }));

    }

    @Override
    public int getX() {
        return x;
    }

}

