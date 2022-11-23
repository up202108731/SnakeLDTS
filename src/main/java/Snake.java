import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<Position> positions_ = new ArrayList<Position>() {{
        add(new Position(40, 20));
        add(new Position(41, 20));
        add(new Position(42, 20));
        add(new Position(43, 20));
        add(new Position(44, 20));
        add(new Position(45, 20));
    }};
    private int snakeSize = 6;

    private String direction_ = "Left";
    private Direction dir_ = new Direction("Left");


    public void draw(TextGraphics screen){
        for (int i = 0; i < snakeSize; i++) {
            Position pos = positions_.get(i);
            if (i == 0) {
                //head
                screen.setForegroundColor(TextColor.Factory.fromString("#000000"));
                screen.putString(new TerminalPosition(pos.getX(), pos.getY()), "X");
            }
            else {
                //body
                screen.setForegroundColor(TextColor.Factory.fromString("#06A511"));
                //screen.enableModifiers(SGR.BOLD);
                screen.putString(new TerminalPosition(pos.getX(), pos.getY()), "O");
            }
        }
        move();
    }
    public void move() {
        List<Position> auxiliar = new ArrayList<Position>();
        if (direction_.equals("Right")) {
            //Modify Head
            Position head = new Position(positions_.get(0).getX() + 2, positions_.get(0).getY());
            auxiliar.add(head);

            //Body
            for (int i = 0; i < snakeSize - 1; i++) {
                auxiliar.add(positions_.get(i));
            }
            positions_ = auxiliar;
        }
        else if (direction_.equals("Left")) {
            //Modify Head
            Position head = new Position(positions_.get(0).getX() - 2, positions_.get(0).getY());
            auxiliar.add(head);

            //Body
            for (int i = 0; i < snakeSize - 1; i++) {
                auxiliar.add(positions_.get(i));
            }
            positions_ = auxiliar;
        }
        else if (direction_.equals("Down")) {
            //Modify Head
            Position head = new Position(positions_.get(0).getX(), positions_.get(0).getY() + 1);
            auxiliar.add(head);

            //Body
            for (int i = 0; i < snakeSize - 1; i++) {
                auxiliar.add(positions_.get(i));
            }
            positions_ = auxiliar;
        }
        else if (direction_.equals("Up")) {
            //Modify Head
            Position head = new Position(positions_.get(0).getX(), positions_.get(0).getY() - 1);
            auxiliar.add(head);

            //Body
            for (int i = 0; i < snakeSize - 1; i++) {
                auxiliar.add(positions_.get(i));
            }
            positions_ = auxiliar;
        }

    }
    public void changeDirection(String direction) {
        if (dir_.inverse(direction_, direction))
            direction_ = direction;
    }

}
