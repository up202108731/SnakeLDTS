import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    private int height;
    private int width;

    private Snake snake = new Snake();


    public Arena(int width, int height){
        this.height = height;
        this.width = width;
    }

    public void draw(TextGraphics screen) {
        screen.setBackgroundColor(TextColor.Factory.fromString("#959780"));
        screen.fillRectangle(new TerminalPosition(0,0), new TerminalSize(width, height), ' ');
        snake.draw(screen);

    }

    public void changeSnakeDirection(String direction) {
        snake.changeDirection(direction);
    }

/*
    public Position moveUp() {
        return new Position(hero.getPosition().getX(), hero.getPosition().getY() - 1);
    }

    public Position moveDown() {
        return new Position(hero.getPosition().getX(), hero.getPosition().getY() + 1);
    }

    public Position moveLeft() {
        return new Position(hero.getPosition().getX()-1, hero.getPosition().getY());
    }

    public Position moveRight() {
        return new Position(hero.getPosition().getX()+1, hero.getPosition().getY());
    }

    public void moveHero(Position position){
        if(canHeroMove(position))
            hero.setPosition(position);

        retrieveCoins();
    }

    private boolean canHeroMove(Position pos){
        return (pos.getX() >= 0 && pos.getX() < width) &&
                (pos.getY() >= 0 && pos.getY() < height) &&
                !walls.contains(new Wall(pos.getX(), pos.getY()));
    }

*/
    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }


}

