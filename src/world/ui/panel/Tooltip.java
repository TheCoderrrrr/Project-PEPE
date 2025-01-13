package world.ui.panel;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import resources.Fonts;
import world.ui.panel.Panel;

public class Tooltip extends Panel {
    public Tooltip(int x, int y) {
        super(x, y);
    }

    public void render(Graphics g, String description){
        g.setColor(Color.blue);
        g.fillRect(x, y, width, Fonts.COFFEEHEALINGITALIC.getHeight(g, description, width - 10, 20));
        g.setColor(Color.white);
        Fonts.COFFEEHEALINGITALIC.wrap(g, description, x, y, width, 20);
    }
}
