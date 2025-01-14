package world.entity.enemy.boss;

import resources.Images;
import world.enemyMoveset.PlannedMoveSet;
import world.enemyMoveset.RandomMoveSet;
import world.enemyMoveset.moves.*;
import world.entity.enemy.EnemyUnit;

import java.util.ArrayList;

public class Godzilla extends EnemyUnit {
    public Godzilla(int x, int y) {
        super(x, y);
        image = Images.GODZILLA;
        width = image.getWidth();
        height = image.getHeight();
        maxHealth *= 4;
    }
    protected void addMoves(){
        ArrayList<Move> moves = new ArrayList<>() {{
            add(new BasicAttack());
            add(new BABA());
            add(new RAA());
            add(new IDEK());
        }};
        moveSet = new PlannedMoveSet();
        moveSet.addMove(moves);
    }
}
