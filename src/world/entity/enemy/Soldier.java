package world.entity.enemy;

import resources.Images;
import world.enemyMoveset.RandomMoveSet;
import world.enemyMoveset.moves.*;
import world.enemyMoveset.moves.soldierMoves.BombSurprise;
import world.enemyMoveset.moves.soldierMoves.SniperShot;
import world.enemyMoveset.moves.soldierMoves.Strike;
import world.enemyMoveset.moves.soldierMoves.VolleyFire;

import java.util.ArrayList;

public class Soldier extends EnemyUnit{
    public Soldier(int x, int y) {
        super(x, y);
        image = Images.ENEMY1;
        width = image.getWidth();
        height = image.getHeight();
    }
    protected void addMoves(){
        ArrayList<Move> moves = new ArrayList<>() {{
            add(new BombSurprise());
            add(new SniperShot());
            add(new Strike());
            add(new VolleyFire());
        }};
        moveSet = new RandomMoveSet();
        moveSet.addMove(moves);
    }
}
