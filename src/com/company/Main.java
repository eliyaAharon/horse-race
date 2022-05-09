package com.company;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.IOException;

public class Main  {
    public static final int WINDOW_WIDTH = 1000;
    public static final int WINDOW_HEIGHT = 500;
   private static JFrame frame = new JFrame();

    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException {

        loginWindow loginWindow = new loginWindow();


    }

    public void run () throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        opening b = new opening(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.add(b);

       //JFrame frame = new JFrame();
        frame.setTitle("my game");
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
    public static void  close (){
        frame.dispose();
    }
}
