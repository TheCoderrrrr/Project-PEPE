package world.managers;

import core.Main;
import org.newdawn.slick.Graphics;
import world.Player;
import world.World;
import world.entity.EnemyUnit;
import world.entity.Entity;
import world.entity.PlayerUnit;

import java.util.ArrayList;

public class EntityManager {
    private final ArrayList<EnemyUnit> animationOrder;
    private final ArrayList<Entity> entities;
    private boolean animating;

    public EntityManager()
    {
        entities = new ArrayList<>();
        animationOrder = new ArrayList<>();
        entities.add(new PlayerUnit((int) (Main.getScreenWidth() * 0.15), (int) (Main.getScreenHeight() * 0.6)));
        newRound();
    }

    public boolean isAnimating() {return animating;}

    public void newRound() {
        entities.add(new EnemyUnit((int) (Main.getScreenWidth() * 0.65), (int) (Main.getScreenHeight() * 0.6)));
        entities.add(new EnemyUnit((int) (Main.getScreenWidth()* 0.78), (int) (Main.getScreenHeight() * 0.6)));
    }

    public boolean enemiesKilled() {
        return entities.size() == 1;
    }

    public void render(Graphics g){
        for(Entity e : entities)
        {
            e.render(g);
        }
    }
    public void update(){

        if(World.isPlayerTurn()) {

            //regular update loop, kill enemies if 0 hp
            for(int i = 0; i < entities.size(); i++)
            {
                if(entities.get(i) instanceof EnemyUnit)
                {
                    if(entities.get(i).getCurHealth() <= 0)
                    {
                        entities.remove(i);
                        i--;
                    }
                }
            }



        } else {

            //enemy is attacking, perform animations

            if(animationOrder.isEmpty()) {
                endTurn();
                World.setPlayerTurn(true);
                animating = false;
                World.nextTurn();
            } else {
                animationOrder.getFirst().continueAnimation();
                if(animationOrder.getFirst().completedAnimation()) {
                    animationOrder.getFirst().resetAnimation();

                    animationOrder.getFirst().action(entities.getFirst());
                    //attack the player once animation is complete

                    animationOrder.removeFirst();

//                    System.out.println(animationOrder);
                    //remove this from the animation queue
                }
            }
        }


    }

    public void endTurn() {
        for(Entity e : entities) {
            e.endTurn();
        }
    }
    public void enemyTurn()
    {
        animating = true;
        animationOrder.clear();
        for(Entity e : entities)
        {
            if(e instanceof EnemyUnit)
            {
                animationOrder.add((EnemyUnit) e);
            }
        }

//        System.out.println(animationOrder);
    }
    public ArrayList<Entity> getEntities()
    {
        return entities;
    }
}
