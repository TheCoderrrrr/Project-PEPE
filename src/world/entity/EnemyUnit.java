package world.entity;

import world.Player;
import world.effects.Effect;
import world.effects.buff.Shield;
import world.effects.debuff.Mark;
import world.effects.debuff.Vulnerable;
import world.enemyMoveset.BABA;
import world.enemyMoveset.BasicAttack;
import world.enemyMoveset.MoveSet;
import world.managers.EntityManager;

import java.util.ArrayList;

public class EnemyUnit extends Entity{
    private MoveSet moveSet;
    public EnemyUnit(int x, int y) {
        super(x, y);
        moveSet = new MoveSet();
        moveSet.addMove(new BasicAttack());
        moveSet.addMove(new BABA());
    }
    public void action(Entity e)
    {
        e.takeDamage(10);
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
}
