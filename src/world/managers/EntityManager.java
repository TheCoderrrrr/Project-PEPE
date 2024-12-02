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
    private ArrayList<Entity> entities;
    public EntityManager()
    {
        entities = new ArrayList<>();
        entities.add(new PlayerUnit((int) (Main.getScreenWidth() * 0.15), (int) (Main.getScreenHeight() * 0.6)));
        newRound();
    }

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
    }

    public void endTurn() {
        for(Entity e : entities) {
            e.endTurn();
        }
    }
    public void enemyTurn()
    {

        for(Entity e : entities)
        {
            if(e instanceof EnemyUnit)
            {
                ((EnemyUnit) e).action(entities.getFirst());
            }
        }
        World.setPlayerTurn(true);
    }
    public ArrayList<Entity> getEntities()
    {
        return entities;
    }
}
