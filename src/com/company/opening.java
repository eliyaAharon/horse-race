package com.company;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class opening extends JPanel {

    private ImageIcon startView;
    private int counter = 0;

    public opening(int x, int y, int width, int height) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        auduo auduo = new auduo();
        this.setLayout(null);
        this.setBounds(x, y, width, height);
        this.startView = new ImageIcon("Open Image1.png");

        // start button setting  button setting
        JButton startButton = new JButton();
        startButton.setText("click here to start :)");
        startButton.setBackground(Color.YELLOW);
        startButton.setBounds(420, 100, 150, 30);
        this.add(startButton);

        // label setting
        JLabel label = new JLabel();
        label.setBounds(420, 140, 150, 30);
        Font myDeafaultFont = new Font("Arial", Font.BOLD, 30);
        label.setFont(myDeafaultFont);
         label.setText("welcome:)");
        this.add(label);
        label.setForeground(Color.BLACK);
        label.setBackground(Color.ORANGE.darker());
        label.setOpaque(true);

        // button of mute sound
        Button soundButton = new Button("Audio on/of");
        soundButton.setBounds(880, 0, 120, 50);
        soundButton.setBackground(Color.YELLOW);
        this.add(soundButton);

        // action of start button

        startButton.addActionListener((e -> {
            startButton.setVisible(false);
            Thread t = new Thread(() -> {
                int timer = 3;
                while (true) {
                    try {
                        Thread.sleep(1000);
                        if (timer == 0) {
                            label.setText("GO!!!!!!!");
                            Thread.sleep(1000);
                            gameSence game = new gameSence(0, 0, 1000, 500);
                            this.add(game);
                            startButton.setVisible(false);
                            soundButton.setVisible(false);
                            break;
                        }
                        label.setText(String.valueOf(timer));
                        timer--;

                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    } catch (UnsupportedAudioFileException ex) {
                        ex.printStackTrace();
                    } catch (LineUnavailableException ex) {
                        ex.printStackTrace();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            });
            t.start();


        }));

        // action of soundButton

        soundButton.addActionListener((e -> {


            if (this.counter % 2 == 0)
                auduo.stopAudio();

            else {
                auduo.StartAudio();
            }
            this.counter++;


        }));


    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.startView.paintIcon(this, g, 0, 0);


    }

}





