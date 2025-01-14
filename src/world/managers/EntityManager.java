package world.managers;

import core.Main;
import org.newdawn.slick.Graphics;
import resources.Images;
import world.World;
import world.entity.enemy.EnemyUnit;
import world.entity.Entity;
import world.entity.PlayerUnit;
import world.entity.enemy.Horse;
import world.entity.enemy.Soldier;
import world.entity.enemy.boss.Godzilla;
import world.entity.enemy.miniboss.Stack;
import world.entity.enemy.miniboss.Truck;

import java.util.ArrayList;

public class EntityManager {
    private final ArrayList<EnemyUnit> animationOrder;
    private final ArrayList<Entity> entities;
    private boolean animating;
    private static int round = 0;

    public EntityManager()
    {
        entities = new ArrayList<>();
        animationOrder = new ArrayList<>();
        entities.add(new PlayerUnit((int) (Main.getScreenWidth() * 0.15), (int) (Main.getScreenHeight() * 0.6) - Images.BEAR_HERO.getHeight()));
        newRound();
    }

    public boolean isAnimating() {return animating;}

    public void newRound() {
        round++;
        if(round % 10 == 0){
            entities.add(new Godzilla((int) (Main.getScreenWidth() * 0.65), (int) (Main.getScreenHeight() * 0.6 - Images.GODZILLA.getHeight())));
        }
        else if(round % 5 == 0){
            if(Math.random() <= .5){
                entities.add(new Stack((int) (Main.getScreenWidth() * 0.65), (int) (Main.getScreenHeight() * 0.6) - Images.STACKENEMY.getHeight()));
            }else{
                entities.add(new Truck((int) (Main.getScreenWidth() * 0.65), (int) (Main.getScreenHeight() * 0.6) - Images.TRUCKENEMY.getHeight()));
            }

        }else {
            entities.add(new Soldier((int) (Main.getScreenWidth() * 0.65), (int) (Main.getScreenHeight() * 0.6) - Images.ENEMY1.getHeight()));
            entities.add(new Horse((int) (Main.getScreenWidth()* 0.78), (int) (Main.getScreenHeight() * 0.6) - Images.ENEMY2.getHeight()));
        }
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
    public int getRound(){
        return round;
    }
}
