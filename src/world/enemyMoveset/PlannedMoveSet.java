package world.enemyMoveset;

public class PlannedMoveSet extends MoveSet{

    public PlannedMoveSet(){

    }
    @Override
    public void useMove() {
//        moveSet.get(curMove).action();
        if(moveSet.size() > curMove - 1)
        {
            curMove++;
        }else{
            curMove = 0;
        }
    }

    @Override
    public Move getNextMove() {
        return moveSet.get(curMove++);
    }
}
