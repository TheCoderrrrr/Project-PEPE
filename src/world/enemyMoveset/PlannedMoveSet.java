package world.enemyMoveset;

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
        return moveSet.get(curMove++);
    }

    @Override
    public Move getCurMove() {
        return moveSet.get(curMove);
    }
}
