package org.saki.game.core.sound;

import org.saki.game.Main;

import javax.sound.sampled.*;
import java.io.IOException;
import java.io.InputStream;

public class SoundEffect {
    Clip clip;
    public SoundEffect(String name){
        try {
            InputStream stream = Main.class.getResourceAsStream(name);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(stream);
            clip = AudioSystem.getClip();
            clip.open(audioIn);
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void startFromHead(){
        if(!clip.isRunning()){
            clip.setFramePosition(0);
        }
        clip.start();
    }
    public void start(int start,int end){
        clip.setFramePosition(start);
        clip.addLineListener(new LineListener() {
            @Override
            public void update(LineEvent event) {
                if(end == event.getFramePosition())
                    clip.stop();
            }
        });
        clip.start();
    }
}
