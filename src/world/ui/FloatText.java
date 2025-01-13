package world.ui;

import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.Graphics;

public class FloatText {
    private String s;
    private int x;
    private int y;
    private int size;
    private Font f;
    private int timer;
    public FloatText(int x, int y, int size, String s, Font f) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.s = s;
        this.f = f;
    }

    public void update() {
        y--;
        timer++;
    }

    public boolean expired() {
        return timer >= 100;
    }
    public void render(Graphics g) {
        g.setFont(f);
        g.drawString(s, x - (float) f.getWidth(s) /2, y);
    }
}
