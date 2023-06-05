package Game;
import javax.swing.*;
import java.awt.*;
import java.util.logging.Logger;

/**
 *
 * @author kononmi1
 * @version 0.1
 * This is the Main class, which start my application
 */
public class Main  {
    Logger logger = Logger.getLogger(Game.Array.class.getName());
    /**
     * This is Window class which extends JFrame and create a GUI
     */
    public static class Window extends JFrame{
        /**
         * This is Window function which start my application
         * @param WinSizeX size of window by X
         * @param WinSizeY size of window by Y
         */
        public Window(int WinSizeX, int WinSizeY){
            /**
             * Set name of my game
             */
            setName("Arimaa");
            Game.TestArimaa test = new Game.TestArimaa();
            test.testIt();
            test.testgold();
            test.testTurn();
            test.testsilver();
            test.testsetRobot();
            test.testsetPlayer();
            test.testfreeze();
            /**
             * Add size X and Y
             */
            setSize(WinSizeX, WinSizeY);
            Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
            /**
             * Set place
             */
            setLocation(dimension.width / 2 - (WinSizeX / 2), dimension.height / 2 - (WinSizeY / 2));
            setResizable(false);
            setUndecorated(true);
            /**
             * Start new game
             */
            add(new GameField(WinSizeX, WinSizeY));
            setVisible(true);
        }
    }
    public static void main(String[] args) {
            Window RUN = new Window(800, 600);
    }
}
