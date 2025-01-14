package world.enemyMoveset;

import world.enemyMoveset.moves.Move;
import world.entity.Entity;

import java.util.ArrayList;

public abstract class MoveSet {
    protected ArrayList<Move> moveSet;
    protected int curMove;
    protected int nextMove;
    public MoveSet()
    {
        moveSet = new ArrayList<>();
        curMove = 0;
        nextMove = 0;
    }
    public ArrayList<Move> getMoveSet()
    {
        return moveSet;
    }
    public void addMove(ArrayList<Move> m)
    {
        moveSet = m;
    }
    public abstract void useMove(Entity entity);
    public abstract Move getNextMove();
    public abstract Move getCurMove();
}
