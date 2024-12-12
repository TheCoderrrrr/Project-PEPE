package world.cards;

import resources.Images;
import core.Main;
import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import world.effects.Effect;
import world.entity.Entity;

import java.util.ArrayList;

public abstract class Card {
    protected int cost;
    protected int rarity;
    protected final static int width = 200;
    protected final static int height = 300;
    protected int x;
    protected int y;
    protected int originalX;
    protected int originalY;
    protected int centerX;
    protected int centerY;
    protected int translationalX;
    protected int translationalY;
    protected float rotation;
    protected boolean selected;
    protected int target;
    protected String cardType;
    protected static GameContainer gc;
    protected Image image;
    protected int energyCost;
    protected Effect effect;
    protected boolean outlined;
    protected String name;
    protected String description;

    public Card() {
        centerX = x + width / 2;
        centerY = y + height / 2;
        selected = false;
        energyCost = 2;
        image = Images.PLACEHOLDERCARD;
    }

    public static void setgc(GameContainer gc) {
        Card.gc = gc;
    }
    //only for single target cards
    public void action(Entity e) {

    }
    //only for multi targeted/global cards
    public void action(ArrayList<Entity> entities) {

    }

    public void render(Graphics g) {
        if (!selected) {
            g.drawImage(image, x, y);
            g.setColor(Color.black);
            g.drawString(getName(), (float) (x + width * 0.05), (float) (y + height * 0.02));
            renderDescrption(g, x, y);

        } else {
            g.drawImage(image, gc.getInput().getMouseX() - translationalX, gc.getInput().getMouseY() - translationalY);
            g.setColor(Color.black);
            g.drawString(getName(), (float) (gc.getInput().getMouseX() - translationalX + (width * 0.05)), (float) (gc.getInput().getMouseY() - translationalY + height * 0.02));
            renderDescrption(g, gc.getInput().getMouseX() - translationalX, gc.getInput().getMouseY() - translationalY);
        }
        g.setColor(Color.white);
        if(outlined) {
            g.drawRect(x - 5, y - 5, width + 10, height + 10);
        }

    }
    public void renderDescrption(Graphics g, int x , int y){
        g.drawString("Energy Cost: " + energyCost + "\n" + description, (float) (x + width * 0.05), (float) (y + height * 0.7));
    }
    public String getName()
    {
        return name;
    }

    public static int getWidth() {
        return width;
    }

    public String getCardType() {
        return cardType;
    }

    public boolean isOutlined() {
        return outlined;
    }

    public void select(int x, int y) {
        selected = true;
        originalX = this.x;
        originalY = this.y;
        translationalX = x - this.x;
        translationalY = y - this.y;

    }

    public void unselect(int x, int y) {
        selected = false;
        this.x = x - translationalX;
        this.y = y - translationalY;
    }

    public void outline() {
        outlined = true;
    }

    public void unoutline() {
        outlined = false;
    }

    public Vector2f originalPos() {
        return new Vector2f(originalX, originalY);
    }

    public boolean selected() {
        return selected;
    }

    public static int getHeight() {
        return height;
    }

    public int getCost() {
        return cost;
    }

    public int getRarity() {
        return rarity;
    }

    public void moveCard(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void hoveredPos(){
        y = Main.getScreenHeight() - height;
    }
    public void defaultPos(){
        y = (int) (Main.getScreenHeight() - height * 0.6);
    }

    public boolean isOver(int mX, int mY) {
        return x <= mX && x + width > mX && y <= mY && y + height >= mY;
    }

    public void setRotation(float degree) {
        rotation = degree;
    }

    public int getCenterX() {
        return centerX;
    }

    public int getCenterY() {
        return centerY;
    }
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public int getEnergyCost()
    {
        return energyCost;
    }
}
