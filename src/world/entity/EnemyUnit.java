package world.entity;

import resources.Images;
import world.Player;
import world.cards.StatusEffect;
import world.effects.Effect;
import world.effects.buff.Shield;
import world.effects.debuff.Mark;
import world.effects.debuff.Vulnerable;
import world.enemyMoveset.RandomMoveSet;
import world.enemyMoveset.moves.*;
import world.enemyMoveset.MoveSet;
import world.enemyMoveset.PlannedMoveSet;
import world.ui.panel.NextMovePanel;

import java.util.ArrayList;

public class EnemyUnit extends Entity{
    private MoveSet moveSet;
    private NextMovePanel nextMovePanel;

    public EnemyUnit(int x, int y) {
        super(x, y);
        if (Math.random() < 0.5) {
            image = Images.ENEMY1;
        } else {
            image = Images.ENEMY2;
        }
        ArrayList<Move> moves = new ArrayList<>() {{
            add(new BasicAttack());
            add(new BABA());
            add(new RAA());
            add(new IDEK());
        }};
        moveSet = new RandomMoveSet();
        moveSet.addMove(moves);
        nextMovePanel = new NextMovePanel(x + width, y + height, 100, 200);
        nextMovePanel.updateNextMove(moveSet.getNextMove());
    }
    public void action(Entity e)
    {
        if(moveSet.getCurMove() instanceof BuffMove){
            moveSet.useMove(this);
            if(moveSet.getCurMove() instanceof StatusEffect){
                ((StatusEffect) moveSet.getCurMove()).applyEffect(this);
            }
        }else{
            moveSet.useMove(e);
            if(moveSet.getCurMove() instanceof StatusEffect){
                ((StatusEffect) moveSet.getCurMove()).applyEffect(e);
            }
        }
        nextMovePanel.updateNextMove(moveSet.getNextMove());
//        float damageMultiplier = 1;
//        for(Effect effect : activeEffects)
//        {
//            if(effect instanceof Weaken)
//            {
//                damageMultiplier -= ((Weaken) effect).getMultiplier();
//            }
//        }
//        e.takeDamage((int) (10 * damageMultiplier));
    }
    public void takeDamage(int damage)
    {
        float multiplier = 1;
        multiplier += Player.getAttackMultiplier();
        for(Effect e : activeEffects) {
            if(e instanceof Mark) {
                multiplier += ((Mark) e).getMultiplier();
            }
            if(e instanceof Vulnerable)
            {
                multiplier +=((Vulnerable) e).getMultiplier();
            }
            if(e instanceof Shield)
            {
                multiplier *= ((Shield) e).getMultiplier();
            }
        }
        if(Math.random() < Player.getCritRate())
        {
            multiplier *= Player.getCritMultiplier();
        }

        curHealth = Math.max(0, curHealth - Math.round(damage * multiplier));
    }
    public NextMovePanel getNextMovePanel(){
        return nextMovePanel;
    }
}
