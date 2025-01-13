package world.ui;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class Button {
    private final Image image;
    private final int x;
    private final int y;
    private final int width;
    private final int height;

    public Button(Image image, int x, int y, int width, int height) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void render(Graphics g) {
        g.drawImage(image, x, y, x+width, y+height, x, y, x+width, y+height);
    }

    public void mousePressed(int button, int x, int y) {
        if(this.x <= x && this.x + width >= x && this.y <= y && this.y + height >= y) {
            action();
        }
    }

    public void action() {

    }
}
