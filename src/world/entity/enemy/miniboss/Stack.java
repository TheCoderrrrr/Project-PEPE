package world.entity.enemy.miniboss;

import resources.Images;
import world.enemyMoveset.PlannedMoveSet;
import world.enemyMoveset.RandomMoveSet;
import world.enemyMoveset.moves.Move;
import world.enemyMoveset.moves.godzillaMoves.*;
import world.enemyMoveset.moves.soldierMoves.SniperShot;
import world.enemyMoveset.moves.soldierMoves.Strike;
import world.enemyMoveset.moves.soldierMoves.VolleyFire;
import world.enemyMoveset.moves.stackMoves.RingBlaster;
import world.enemyMoveset.moves.stackMoves.StackSlam;
import world.enemyMoveset.moves.stackMoves.TotemSpin;
import world.enemyMoveset.moves.stackMoves.TowerBlock;
import world.entity.enemy.EnemyUnit;

import java.util.ArrayList;

public class Stack extends EnemyUnit {
    public Stack(int x, int y) {
        super(x, y);
        image = Images.STACKENEMY;
        width = image.getWidth();
        height = image.getHeight();
        maxHealth *= 2;
        curHealth = maxHealth;
    }

    @Override
    protected void addMoves() {
        ArrayList<Move> moves = new ArrayList<>() {{
            add(new RingBlaster());
            add(new StackSlam());
            add(new TotemSpin());
            add(new TowerBlock());
        }};
        moveSet = new RandomMoveSet();
        moveSet.addMove(moves);
    }
}
