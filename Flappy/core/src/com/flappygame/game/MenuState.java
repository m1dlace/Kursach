package com.flappygame.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class MenuState extends State {

    private Texture background;
    private Texture playBtn;

    public MenuState(GameState gsm) {
        super(gsm);
        background = new Texture("back3.png");
        playBtn = new Texture("Play2.png");
    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()) {
            gsm.set(new PlayState(gsm));
        }

    }

    @Override
    public void update(float dt) {
        handleInput();

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background, 0, 0, FlappyGame.WIDTH, FlappyGame.HEIGHT);
        sb.draw(playBtn, (FlappyGame.WIDTH / 2) - (playBtn.getWidth() / 2), FlappyGame.HEIGHT / 2);
        sb.end();

    }

    @Override
    public void dispose() {
        background.dispose();
        playBtn.dispose();

        System.out.println("MenuState Disposed");
    }
}