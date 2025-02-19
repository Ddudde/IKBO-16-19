package com.mirea.prakt.prakt1.service;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import com.mirea.prakt.prakt1.model.PlayField;

public class SoundPlayer extends PlayField {
    private final String FLIP_CARD_SOUND = "/sounds/flipCard.mp3";
    private final String SUCCESS_SOUND = "/sounds/success.mp3";
    private final String FAIL_SOUND = "/sounds/fail.mp3";

    private MediaPlayer flip;
    private MediaPlayer success;
    private MediaPlayer fail;

    public SoundPlayer() {
        flip = new MediaPlayer(new Media(getClass().getResource(FLIP_CARD_SOUND).toString()));
        success = new MediaPlayer(new Media(getClass().getResource(SUCCESS_SOUND).toString()));
        fail = new MediaPlayer(new Media(getClass().getResource(FAIL_SOUND).toString()));

        success.setVolume(0.5);
        fail.setVolume(0.3);
    }

    public void playFlipCard() {
        flip.stop();
        flip.play();
    }

    public void playSuccess() {
        success.stop();
        success.play();
    }

    public void playFail() {
        fail.stop();
        fail.play();
    }

}
