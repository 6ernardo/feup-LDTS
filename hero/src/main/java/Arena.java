import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Arena {
    private int width;
    private int height;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    private Hero hero = new Hero(10, 10);

    private List<Wall> walls;

    private List<Wall> createWalls(){
        List<Wall> walls = new ArrayList<>();

        for(int c=0; c < width; c++){
            walls.add(new Wall(c,0));
            walls.add(new Wall(c, height-1));
        }

        for(int r = 1; r<height-1; r++){
            walls.add(new Wall(0,r));
            walls.add(new Wall(width-1, r));
        }

        //parede de teste
        walls.add(new Wall(11, 11));

        return walls;
    }

    private List<Coin> coins;

    private List<Coin> createCoins(){
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        for(int i=0; i<5; i++){
            int w = random.nextInt(width - 2) + 1;
            int h = random.nextInt(height - 2) + 1;
            boolean flag=true;

            for(Coin coin : coins){
                if(w==coin.getPosition().getX() && h==coin.getPosition().getY()) {
                    flag = false;
                }
            }

            if(flag){
                coins.add(new Coin(w,h));
            }
            else{
                i--;
            }
        }

        return coins;
    }

    public void retrieveCoins(){
        for(Coin coin : coins){
            if(hero.getPosition().equals(coin.getPosition())){
                coins.remove(coin);
                break;
            }
        }
    }

    private List<Monster> monsters;

    private List<Monster> createMonsters(){
        Random random = new Random();
        ArrayList<Monster> monsters = new ArrayList<>();
        for(int i=0; i<3; i++){
            int w = random.nextInt(width - 2) + 1;
            int h = random.nextInt(height - 2) + 1;
            boolean flag=true;

            for(Monster monster : monsters){
                if(w==monster.getPosition().getX() && h==monster.getPosition().getY()) {
                    flag = false;
                }
            }

            for(Coin coin : coins){
                if(w==coin.getPosition().getX() && h==coin.getPosition().getY()) {
                    flag = false;
                }
            }

            if(flag){
                monsters.add(new Monster(w,h));
            }
            else{
                i--;
            }
        }

        return monsters;
    }

    public void moveMonsters(){
        for(Monster monster : monsters){
            monster.setPosition(monster.move(this));
        }
    }

    public boolean verifyMonsterCollisions(){
        for(Monster monster : monsters){
            if(monster.getPosition().equals(hero.getPosition())) return true;
        }

        return false;
    }

    public Arena(int width, int height){
        this.width=width;
        this.height=height;
        this.walls=createWalls();
        this.coins=createCoins();
        this.monsters=createMonsters();
    }

    private boolean canHeroMove(Position position){
        boolean flag=true;

        for(Wall wall : walls){
            if(wall.getPosition().equals(position)) flag=false;
        }

        return (position.getX()>=0 && position.getX()<width && position.getY()>=0 && position.getY()<height && flag);

    }

    private void moveHero(Position position) {
        if(canHeroMove(position)){
            hero.setPosition(position);
        }

        retrieveCoins();
    }

    public void processKey(KeyStroke key){
        if (key.getKeyType() == KeyType.ArrowDown) {
            moveHero(hero.moveDown());
        } else if (key.getKeyType() == KeyType.ArrowUp) {
            moveHero(hero.moveUp());
        } else if (key.getKeyType() == KeyType.ArrowLeft) {
            moveHero(hero.moveLeft());
        } else if (key.getKeyType() == KeyType.ArrowRight) {
            moveHero(hero.moveRight());
        }
    }

    public void draw(TextGraphics screen){
        screen.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        screen.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        hero.draw(screen);

        for(Wall wall: walls){
            wall.draw(screen);
        }

        for(Coin coin : coins){
            coin.draw(screen);
        }

        for(Monster monster : monsters){
            monster.draw(screen);
        }
    }
}
