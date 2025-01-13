package world.enemyMoveset;

import world.enemyMoveset.moves.Move;
import world.entity.Entity;

public class PlannedMoveSet extends MoveSet{

    public PlannedMoveSet(){

    }
    @Override
    public void useMove(Entity entity) {
        if(moveSet.size() - 1 > curMove)
        {
            curMove++;
        }else{
            curMove = 0;
        }
        moveSet.get(curMove).action(entity);
    }

    @Override
    public Move getNextMove() {
        if(moveSet.size() - 1 > curMove)
        {
            return moveSet.get(curMove++);
        }else{
            return moveSet.getFirst();
        }
    }

    @Override
    public Move getCurMove() {
        return moveSet.get(curMove);
    }
}
