package world.ui.panel;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import world.effects.Effect;

import java.util.ArrayList;

public class StatusEffectPanel extends Panel{
    private ArrayList<Effect> activeEffects;
    public StatusEffectPanel(int x, int y, int width, int height) {
        super(x, y, width, height);
        activeEffects = new ArrayList<>();
        tooltip = new Tooltip(x + width, y);
    }
    public void updateStatusEffects(ArrayList<Effect> updatedEffects){
        activeEffects = updatedEffects;
    }
    public void render(Graphics g) {
        int width = 3;
        int size = activeEffects.size();

        if (size == 0) {
            return;
        }
        System.out.println(x + " : " + y);

        int height = (int) Math.ceil((double) size / width);
        this.height = height * activeEffects.getFirst().getSymbol().getHeight();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int index = i * width + j;
                if (index >= size) {
                    return;
                }

                Effect effect = activeEffects.get(index);
                g.drawImage(
                        effect.getSymbol(),
                        x + j * effect.getSymbol().getWidth(),
                        y + i * effect.getSymbol().getHeight()
                );
                int effectX = x + j * effect.getSymbol().getWidth();
                int effectY = y + i * effect.getSymbol().getHeight();
                int effectWidth = effect.getSymbol().getWidth();
                int effectHeight = effect.getSymbol().getHeight();

                // Draw the effect symbol
                g.drawImage(effect.getSymbol(), effectX, effectY);

                // Check if the mouse is hovering over this effect
                if (gc.getInput().getMouseX() >= effectX && gc.getInput().getMouseX() <= effectX + effectWidth &&
                        gc.getInput().getMouseY() >= effectY && gc.getInput().getMouseY() <= effectY + effectHeight) {

                    // Draw a tooltip near the effect
                    tooltip.render(g,effect.getName());
                }
            }
        }
    }

}
