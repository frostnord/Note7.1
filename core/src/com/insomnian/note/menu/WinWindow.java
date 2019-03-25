package com.insomnian.note.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.insomnian.note.game.Assets;
import com.insomnian.note.screens.DirectedGame;
import com.insomnian.note.screens.ScripPackScreen;
import com.insomnian.note.screens.ScripPracticeScreen;
import com.insomnian.note.utils.GamePreferences;

public class WinWindow extends Window {

    private final Stage stage;
    private final int score;
    private DirectedGame directedGame;
    private int number;
    private int star;

    public WinWindow(String title, Skin skin, Stage stage, int score, final DirectedGame directedGame, final int number, int star) {
        super(title, skin);
        Gdx.app.log("Winscreen", "Create ");

        this.stage = stage;
        this.score = score;
        this.directedGame = directedGame;
        this.number = number;
        this.star = star;
        Table table = new Table();
        //        table.debug();
        Table table2 = new Table();
//        table2.debug();
        setBackground("pauseBg");
//
        setSize(stage.getViewport().getWorldWidth() / 2, stage.getViewport().getWorldWidth() / 3);
        setPosition(stage.getViewport().getWorldWidth() / 4, stage.getViewport().getWorldHeight() / 3);

        if (score <= 50) {
            table.add(new Image(Assets.instance.decoration.star)).center().colspan(3).padBottom(50).size(150, 150);
        } else if (score > 50 && score < 90) {
            table.debug();
            table.add(new Image(Assets.instance.decoration.star)).padBottom(50).size(150, 150).padRight(100);
            table.add(new Image(Assets.instance.decoration.star)).padBottom(50).size(150, 150);
            table.center();
            star = 2;
        } else if (score >= 90) {
            table.add(new Image(Assets.instance.decoration.star)).center().padBottom(50).size(150, 150).padRight(100);
            table.add(new Image(Assets.instance.decoration.star)).center().padBottom(50).size(150, 150).padRight(100);
            table.add(new Image(Assets.instance.decoration.star)).center().padBottom(50).size(150, 150);
            star = 3;
        }
        int currentStar = GamePreferences.instance.getNumberOfStar(1, number);
        if (currentStar < star) {
            GamePreferences.instance.saveLastLevelStar(1, number, star);
        }

        Button btnWindowPack = new Button(Assets.instance.skin.buttonStyle);
        Image imgWindowPrew = new Image(this.directedGame.gameSkin, "prew");
        imgWindowPrew.setOrigin(imgWindowPrew.getWidth() / 2.0f, imgWindowPrew.getHeight() / 2.0f);
        btnWindowPack.add((Actor) imgWindowPrew);
        btnWindowPack.setOrigin(btnWindowPack.getWidth() / 2.0f, btnWindowPack.getHeight() / 2.0f);
        btnWindowPack.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeListener.ChangeEvent changeEvent, Actor actor) {
                directedGame.setScreen( new ScripPackScreen(directedGame));
            }
        });
        table2.add(btnWindowPack).size(200, 200).padRight(50);

//        TextButton homeButton = new TextButton("<", Assets.instance.skin.textButtonStyle);
//        homeButton.addListener(new ClickListener() {
//            @Override
//            public void clicked(InputEvent event, float x, float y) {
//
////                window.remove();
//                ScripPracticeScreen.this.directedGame.setScreen( new ScripPackScreen(directedGame));
//            }
//        });
//        table2.add(homeButton).size(200, 200).padRight(50);
//        TextButton packButton = new TextButton("[=]", Assets.instance.skin.textButtonStyle);
//        packButton.addListener(new ClickListener() {
//            @Override
//            public void clicked(InputEvent event, float x, float y) {
//                window.remove();
//            }
//        });
//        table2.add(packButton).size(200, 200);


        Button btnWindowRestart = new Button(Assets.instance.skin.buttonStyle);
        Image imgWindowRestart = new Image(this.directedGame.gameSkin, "restart");
        imgWindowRestart.setOrigin(imgWindowRestart.getWidth() / 2.0f, imgWindowRestart.getHeight() / 2.0f);
        btnWindowRestart.add((Actor) imgWindowRestart);
        btnWindowRestart.setOrigin(btnWindowRestart.getWidth() / 2.0f, btnWindowRestart.getHeight() / 2.0f);
        btnWindowRestart.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeListener.ChangeEvent changeEvent, Actor actor) {
                directedGame.setScreen(new ScripPracticeScreen(directedGame, number));
            }
        });
        table2.add(btnWindowRestart).size(200, 200).center();
////////////////////////////

//        table2.add(new MyTextButton("R", Assets.instance.skin.textButtonStyle, new ChangeListener() {
//            @Override
//            public void changed(ChangeEvent event, Actor actor) {
//                ScripPracticeScreen.this.directedGame.setScreen(new ScripPracticeScreen(directedGame, number));
////                System.out.println(number+"pack number");
//            }
//        })).size(200, 200).center();

        if (number!= 11) {
            Button btnWindowPlay = new Button(Assets.instance.skin.buttonStyle);
            Image imgWindowNext = new Image(this.directedGame.gameSkin, "play");
            imgWindowNext.setOrigin(imgWindowNext.getWidth() / 2.0f, imgWindowNext.getHeight() / 2.0f);
            btnWindowPlay.add((Actor) imgWindowNext);
            btnWindowPlay.setOrigin(btnWindowRestart.getWidth() / 2.0f, btnWindowRestart.getHeight() / 2.0f);
            btnWindowPlay.addListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent changeEvent, Actor actor) {
//                    directedGame.gameStatus = "action";
                    directedGame.setScreen(new ScripPracticeScreen(directedGame, number + 1));
//                    remove();
//                status("action");
                }
            });
            table2.add(btnWindowPlay).size(200, 200).padLeft(50);

//            table2.add(new MyTextButton(">>", Assets.instance.skin.textButtonStyle, new ChangeListener() {
//                @Override
//                public void changed(ChangeEvent event, Actor actor) {
//                    ScripPracticeScreen.this.directedGame.setScreen(new ScripPracticeScreen(directedGame, number + 1));
//                }
//            })) .size(200, 200).padLeft(50);
        }
//       window.add(musicCheckBox).left().fill();
        row().pad(5);
        add(table);
        row().pad(5);
        add(table2);
    }
}
