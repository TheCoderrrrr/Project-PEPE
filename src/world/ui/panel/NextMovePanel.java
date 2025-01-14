package world.ui.panel;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import world.enemyMoveset.moves.Move;

import java.awt.*;

public class NextMovePanel extends Panel{
    private Move nextMove;
    public NextMovePanel(int x, int y, int width, int height) {
        super(x, y, width, height);
    }
    public void updateNextMove(Move move) {
        nextMove = move;
    }
    public void render(Graphics g){
        super.render(g);
        g.setColor(Color.white);
        if(nextMove != null){
            g.drawString(nextMove.getClass().getSimpleName(), x, y);
        }
    }
}
