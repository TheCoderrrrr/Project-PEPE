package world.enemyMoveset;

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
    public void addMove(Move m)
    {
        moveSet.add(m);
    }
    public abstract void useMove();
    public abstract Move getNextMove();
}
