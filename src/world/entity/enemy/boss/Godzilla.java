package world.entity.enemy.boss;

import resources.Images;
import world.enemyMoveset.PlannedMoveSet;
import world.enemyMoveset.moves.*;
import world.enemyMoveset.moves.godzillaMoves.*;
import world.entity.enemy.EnemyUnit;

import java.util.ArrayList;

public class Godzilla extends EnemyUnit {
    public Godzilla(int x, int y) {
        super(x, y);
        image = Images.GODZILLA;
        width = image.getWidth();
        height = image.getHeight();
        maxHealth *= 4;
        curHealth = maxHealth;
    }
    protected void addMoves(){
        ArrayList<Move> moves = new ArrayList<>() {{
            add(new Bite());
            add(new Rapture());
            add(new LazerBeam());
            add(new Slash());
            add(new PlasmaRay());
            add(new PoisonousBreath());
            add(new Tailwhip());
        }};
        moveSet = new PlannedMoveSet();
        moveSet.addMove(moves);
    }
}
