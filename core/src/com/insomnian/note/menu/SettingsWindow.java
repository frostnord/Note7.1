package com.insomnian.note.menu;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Value;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.insomnian.note.game.Assets;
import com.insomnian.note.screens.DirectedGame;
import com.insomnian.note.utils.GamePreferences;

public class SettingsWindow extends Window {

//    DirectedGame game;

    private Button musicCheckBox ;
    private Button soundCheckBox ;
    private Button languageCheckBox;
    private Label languageLabel;

    public SettingsWindow(String title, Skin skin, DirectedGame directedGame,Stage stage) {
        super(title, skin);

//        this.game = directedGame;
//        setFillParent(true);
        center();
        setMovable(false);
//        setHeight(stage.getHeight()/1.5f);
        pad(60);
//        optDialog.text(new Label("Setings", new Label.LabelStyle(Assets.instance.fonts.levelComplete, Color.WHITE)));
        this.musicCheckBox = new CheckBox("", directedGame.uiSkin, "music");
//        Image plusImage = new Image(directedGame.uiSkin, "sound_on_checkbox");
//        musicCheckBox.addActor(plusImage);
//        this.musicCheckBox.setSize(500,500);

//        musicCheckBox.setTransform(true);
//        musicCheckBox.getStyle().down.setMinWidth(2.0f);
//        musicCheckBox.getStyle().up.setMinWidth(2.0f);
        musicCheckBox.setChecked(GamePreferences.instance.isMusicEnabled());///вроде задает состояние
        musicCheckBox.addListener(new ChangeListener() {
            public void changed(ChangeEvent event, Actor actor) {
                boolean isMusicOn = musicCheckBox.isChecked();
                GamePreferences.instance.setMusicEnabled(isMusicOn);
//                musicManager.setEnabled(isMusicOn);
                Assets.instance.music.menuMusic.stop();
                statusMusic();
            }
        });
        soundCheckBox = new CheckBox("", directedGame.uiSkin, "sound");
        soundCheckBox.setChecked(GamePreferences.instance.isSoundEnabled());
        soundCheckBox.addListener(new ChangeListener() {
            public void changed(ChangeEvent event, Actor actor) {
                boolean isSoundOn = soundCheckBox.isChecked();
                GamePreferences.instance.setSoundEnabled(isSoundOn);
//                Assets.instance.music.menuMusic.stop();
            }
        });
        String languageRu ;
        if (GamePreferences.instance.languageRu()){
            languageRu =" Re Mi Fa";
        }else{
            languageRu=" D E F";
        }
        languageCheckBox = new CheckBox("",directedGame.uiSkin,"language");/// доделатьc языки
        languageLabel = new Label(languageRu, new Label.LabelStyle(Assets.instance.fonts.levelCompleted,Color.WHITE));
        languageCheckBox.setChecked(GamePreferences.instance.languageRu());
        languageCheckBox.addListener(new ChangeListener() {
            public void changed(ChangeEvent event, Actor actor) {
                boolean languageRuTrue = languageCheckBox.isChecked();
                GamePreferences.instance.setLanguage(languageRuTrue);
                if (languageRuTrue){
                    languageLabel.setText(" Re Mi Fa");
                }else{
                    languageLabel.setText(" D E F");
//                    languageLabel.setAlignment(Align.center);
                }
//                musicManager.setEnabled(isMusicOn);
//                Assets.instance.music.menuMusic.stop();
//                statusMusic();
            }
        });

        Label musicLabel = new Label(" Music", new Label.LabelStyle(Assets.instance.fonts.levelCompleted,Color.WHITE));
        Label soundLabel = new Label("Sound", new Label.LabelStyle(Assets.instance.fonts.levelCompleted,Color.WHITE));

//        debugAll();
        add(new Label("Settings", new Label.LabelStyle(Assets.instance.fonts.levelCompleted, Color.WHITE))).colspan(2);
        row().padBottom(30).fill().expand();
//        add(musicCheckBox).width(400).height(Value.percentHeight(.5f)).fill();
//        musicCheckBox.setScale(4);
        add(musicCheckBox);

        add(musicLabel).padLeft(10);
        row().padBottom(30).fill().expand();
        add( soundCheckBox);
        add(soundLabel).padLeft(30);
        row().padBottom(30).fill().expand();
        add(languageCheckBox);
        add(languageLabel).width(450).padLeft(10);
        row().padBottom(30).fill().expand();
        final TextButton okButton = new TextButton("Ok",Assets.instance.skin.optionDiologTextButtonStyle);
        okButton.addListener(new ChangeListener() {
            public void changed(ChangeEvent event, Actor actor) {
                GamePreferences.instance.flush();
                remove();
            }
        });
        add(okButton).colspan(2).size(120,120);
        pack();
//        isModal();
        setPosition(stage.getWidth()/2- getWidth()/2,stage.getHeight()/2-getHeight()/2);

    }
    private void statusMusic(){
        if (GamePreferences.instance.isMusicEnabled()){
            Assets.instance.music.menuMusic.play();
        }
    }
}
