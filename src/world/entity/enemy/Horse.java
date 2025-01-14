package world.entity.enemy;

import resources.Images;
import world.enemyMoveset.PlannedMoveSet;
import world.enemyMoveset.moves.Move;
import world.enemyMoveset.moves.godzillaMoves.*;
import world.enemyMoveset.moves.horseMoves.HoofStomp;
import world.enemyMoveset.moves.horseMoves.ManeDash;
import world.enemyMoveset.moves.horseMoves.NeighQuake;

import java.util.ArrayList;

public class Horse extends EnemyUnit{
    public Horse(int x, int y) {
        super(x, y);
        image = Images.ENEMY2;
        width = image.getWidth();
        height = image.getHeight();
    }

    @Override
    protected void addMoves() {
        ArrayList<Move> moves = new ArrayList<>() {{
            add(new HoofStomp());
            add(new ManeDash());
            add(new NeighQuake());
        }};
        moveSet = new PlannedMoveSet();
        moveSet.addMove(moves);
    }
}
