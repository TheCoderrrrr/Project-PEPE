package world.entity.enemy.miniboss;

import resources.Images;
import world.enemyMoveset.PlannedMoveSet;
import world.enemyMoveset.RandomMoveSet;
import world.enemyMoveset.moves.Move;
import world.enemyMoveset.moves.godzillaMoves.*;
import world.enemyMoveset.moves.truckMoves.CargoCover;
import world.enemyMoveset.moves.truckMoves.Crush;
import world.enemyMoveset.moves.truckMoves.RamSlam;
import world.enemyMoveset.moves.truckMoves.TurboTakedown;
import world.entity.enemy.EnemyUnit;

import java.util.ArrayList;

public class Truck extends EnemyUnit {
    public Truck(int x, int y) {
        super(x, y);
        image = Images.TRUCKENEMY;
        width = image.getWidth();
        height = image.getHeight();
        maxHealth *= 2;
        curHealth = maxHealth;
    }

    @Override
    protected void addMoves() {
        ArrayList<Move> moves = new ArrayList<>() {{
            add(new CargoCover());
            add(new Crush());
            add(new RamSlam());
            add(new TurboTakedown());
        }};
        moveSet = new RandomMoveSet();
        moveSet.addMove(moves);
    }
}
