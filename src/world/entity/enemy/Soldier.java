package world.entity.enemy;

import resources.Images;
import world.enemyMoveset.RandomMoveSet;
import world.enemyMoveset.moves.*;

import java.util.ArrayList;

public class Soldier extends EnemyUnit{
    public Soldier(int x, int y) {
        super(x, y);
        image = Images.ENEMY2;
        width = image.getWidth();
        height = image.getHeight();
    }
    protected void addMoves(){
        ArrayList<Move> moves = new ArrayList<>() {{
            add(new BasicAttack());
            add(new BABA());
            add(new RAA());
            add(new IDEK());
        }};
        moveSet = new RandomMoveSet();
        moveSet.addMove(moves);
    }
}
