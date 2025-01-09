package world.enemyMoveset;

import java.util.ArrayList;

public class MoveSet {
    protected ArrayList<Move> moveSet;
    protected int curMove;
    public MoveSet()
    {
        moveSet = new ArrayList<>();
        curMove = 0;
    }
    public ArrayList<Move> getMoveSet()
    {
        return moveSet;
    }
    public void addMove(Move m)
    {
        moveSet.add(m);
    }
    public void useMove(){
        moveSet.get(curMove).action();
    }
}
