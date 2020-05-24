package com.flappygame.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;



public class FlappyGame extends ApplicationAdapter {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    public static final String TITLE = "Flappy Game";

    private GameState gsm;
    private SpriteBatch batch;
    private Music music;
    private BitmapFont FontBlack1;


    @Override
    public void create () {
        batch = new SpriteBatch();
        gsm = new GameState();
        music = Gdx.audio.newMusic(Gdx.files.internal("music2.mp3"));
        music.setLooping(true);
        music.setVolume(0.6f);
        music.play();
        Gdx.gl.glClearColor(1, 0, 0, 1);
        gsm.push(new MenuState(gsm));

        FontBlack1 = new BitmapFont();
        FontBlack1.setColor(Color.BLACK);

    }


    @Override
    public void render () {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gsm.update(Gdx.graphics.getDeltaTime());
        gsm.render(batch);
        batch.begin();
        FontBlack1.draw(batch, "Avtor: Zadoroznii Vladislav", 10, 20);
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        music.dispose();
    }
}