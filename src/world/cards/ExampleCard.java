package world.cards;

public class ExampleCard extends Card{

    public ExampleCard(int x, int y, int rotation){
        super(x, y, rotation);
        cost = 1;
        rarity = 2;
    }
    @Override
    public void action() {

    }
}
