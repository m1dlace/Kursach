package com.flappygame.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;


public class BedBird {

    private Vector3 positionB;
    private Vector3 velosityB;
    private Rectangle boundsB;
    private Animation BbirdAnimation;
    private Texture textureB;

    public BedBird(int x, int y){
        positionB = new Vector3(x, y, 0);
        velosityB = new Vector3(-150, 0, -150);
        textureB = new Texture("BedBird3.png");
        BbirdAnimation = new Animation(new TextureRegion(textureB), 3, 0.5f);
        boundsB = new Rectangle(x, y, textureB.getWidth() /3, textureB.getHeight());
    }

    public Vector3 getPositionB() {
        return positionB;
    }

    public TextureRegion getBedBird() {
        return BbirdAnimation.getFrame();
    }

    public void update(float dt){
        BbirdAnimation.update(dt);
        velosityB.scl(1 / dt);
        boundsB.setPosition(positionB.x, positionB.y);
    }


    public Rectangle getBounds(){
        return boundsB;
    }


    public void dispose() {
        textureB.dispose();
    }
}