package world.ui.panel;

import org.newdawn.slick.Graphics;
import world.effects.Effect;

import java.util.ArrayList;

public class StatusEffectPanel extends Panel{
    private ArrayList<Effect> activeEffects;

    public StatusEffectPanel(int x, int y, int width, int height) {
        super(x, y, width, height);
        activeEffects = new ArrayList<>();
    }
    public void updateStatusEffects(ArrayList<Effect> updatedEffects){
        activeEffects = updatedEffects;
    }

    public void render(Graphics g){
        int width = activeEffects.size() % 3;

        if(width == 0) {
            return;
        }
        int height = (activeEffects.size() / width) + 1;

        for(int i = 0; i < height; i++)
        {
            for(int j = 0; j < width; j++){
                Effect effect = activeEffects.get(i);
                g.drawImage(effect.getSymbol(), x + i * effect.getSymbol().getWidth(), y + j * effect.getSymbol().getHeight());
            }
        }
    }
}
