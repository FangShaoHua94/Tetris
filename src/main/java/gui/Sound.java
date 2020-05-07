package gui;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;

public enum Sound {
    CLEAR("clear.wav"),
    FALL("fall.wav"),
    GAME_OVER("gameOver.wav"),
    START("start.wav"),
    THEME("theme.wav");

    public static enum Volume {
        MUTE, LOW, MEDIUM, HIGH;
    }

    public static Volume volume = Volume.MEDIUM;

    private Clip clip;

    Sound(String soundFileName) {
        try {
            File file = new File(getClass().getClassLoader().getResource("sound/" + soundFileName).getFile());
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void play() {
        if (volume != Volume.MUTE) {
            if (clip.isRunning()) {
                clip.stop();
            }
            clip.setFramePosition(0);
            clip.start();
        }
    }

    public void stop() {
        if (clip.isRunning()) {
            clip.stop();
        }
    }

    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

}
