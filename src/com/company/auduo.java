package com.company;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class auduo {

    private Clip clip;

    public auduo() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File file = new File("Tiesto - The Business (Official Lyric Video).wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();


    }

    public void stopAudio() {
        this.clip.stop();
    }
    public void StartAudio() {
        this.clip.start();
    }
}
