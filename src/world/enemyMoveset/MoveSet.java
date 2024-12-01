package world.enemyMoveset;

import world.effects.Mark;
import world.entity.EnemyUnit;

import java.util.ArrayList;

public class MoveSet {
    private ArrayList<Move> moveSet;
    public MoveSet()
    {
        moveSet = new ArrayList<>();
    }
    public ArrayList<Move> getMoveSet()
    {
        return moveSet;
    }
    public void addMove(Move m)
    {
        moveSet.add(m);
    }
}
