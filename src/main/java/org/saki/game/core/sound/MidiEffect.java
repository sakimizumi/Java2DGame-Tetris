package org.saki.game.core.sound;

import com.sun.tools.javac.Main;

import javax.sound.midi.*;
import java.io.IOException;
import java.io.InputStream;

public class MidiEffect {
    private Sequencer sequencer;

    public MidiEffect(String name) {
        try {
            InputStream stream = Main.class.getResourceAsStream(name);
            Sequence song = MidiSystem.getSequence(stream);
            sequencer = MidiSystem.getSequencer();
            sequencer.setSequence(song);
        } catch (InvalidMidiDataException | IOException | MidiUnavailableException e) {
            throw new RuntimeException(e);
        }
    }

    public void start(boolean isLoop) {
        if (sequencer != null) {
            if (isLoop)
                sequencer.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
            sequencer.start();
        }

    }

    public void stop() {
        sequencer.stop();
    }

    public void init() {
        try {
            sequencer.open();
        } catch (MidiUnavailableException e) {
            throw new RuntimeException(e);
        }
    }

    public void release() {
        sequencer.close();
    }
}
