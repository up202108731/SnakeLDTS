import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import javax.swing.*;
import java.io.IOException;

public class Game {

    private Screen screen;
    private Arena arena;

    public Game() {
        try {
            TerminalSize terminalSize = new TerminalSize(80, 40);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);

            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();
        } catch (IOException e) {
            e.printStackTrace();
        }
        arena = new Arena(80, 40);
    }

    private void draw() throws IOException {
        screen.clear();
        arena.draw(screen.newTextGraphics());
        screen.refresh();
    }

    private void processKey(com.googlecode.lanterna.input.KeyStroke key){
        switch (key.getKeyType()) {
            case ArrowUp    -> arena.changeSnakeDirection("Up");
            case ArrowDown  -> arena.changeSnakeDirection("Down");
            case ArrowLeft  -> arena.changeSnakeDirection("Left");
            case ArrowRight -> arena.changeSnakeDirection("Right");
        }
    }

    public void run() throws IOException {
        try {
            while (true) {
                long startTime = System.currentTimeMillis();
                com.googlecode.lanterna.input.KeyStroke key = screen.pollInput();
                while (System.currentTimeMillis() - startTime <= 3) {
                    if (screen.pollInput() != null) {
                        break;
                    }

                    try {
                        Thread.sleep(40);
                        draw();
                    }
                    catch(InterruptedException ignore) {
                        break;
                    }

                }
                if (key != null) {
                    processKey(key);
                }
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
