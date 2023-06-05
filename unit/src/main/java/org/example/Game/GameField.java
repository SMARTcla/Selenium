package Game;


import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.html.ImageView;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Calendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author kononmi1
 * @version 0.1
 * This is the GameField class, here you can see all project functions
 */
public class GameField extends JPanel {
    Logger logger = Logger.getLogger(Game.Array.class.getName());
    /**
     * SizeX of GUI
     */
    private int SizeX;
    Array a = new Array();
    Computer c = new Computer();
    Turns t = new Turns();
    long startTime = System.currentTimeMillis();
    /**
     * int count of shoving(3 to 0) and we need to save count of shove figure
     */
    int val_shove = 0;
    /**
     * int count of shoving(3 to 0) and we need to save count of shoved figure
     */
    int val_shoved = 0;
    /**
     * int count of shoving(3 to 0) person can pull a figure and we need to take 3 coordinates
     */
    int pull = 0;
    /**
     * int[] array to set robot field
     */
    int [] vs_robot =  new int[16];
    /**
     * int check this is the game vs robot or no
     */
    int count_vs_robot = 0;
    /**
     * int[] array to set vs_player field
     */
    int [] vs_player =  new int[32];
    /**
     * int check this is the game vs player or no
     */
    int count_vs_player = 0;
    /**
     * int each person have 4 turns
     */
    int turn = 3;
    /**
     * Color set gold
     */
    Color gold = new Color(255, 215, 0);
    /**
     * Color set silver
     */
    Color silver = new Color(192,192,192);
    /**
     * int set value of figure which place will be changed
     */
    int last_val = 0;
    /**
     * int control count of figure place will be changed by player 1
     */
    int count_one = 16;
    /**
     * int coordinate X which was last to change by turn to 0
     */
    int old_x = 0;
    /**
     * int coordinate Y which was last to change by trun to 0
     */
    int old_y = 0;
    /**
     * int coordinate X which shove another figure
     */
    int shove_x = 0;
    /**
     * int coordinate Y which shove another figure
     */
    int shove_y = 0;
    /**
     * int coordinate X which will be shoved
     */
    int shoved_x = 0;
    int minutes_gold = 0;
    int sec_gold = 0;
    int minutes_silver = 0;
    int sec_silver = 0;
    /**
     * int coordinate Y which will be shoved
     */
    int shoved_y = 0;
    /**
     * int count of shoving(3 to 0) person can shove a figure, and we need to take 3 coordinates
     */
    int shove = 0;
    /**
     * int control count of figure place will be changed by player 2
     */
    int count_two = 16;
    /**
     * int type of game vs_robot or player
     */
    int game_type = 0;
    /**
     * SizeYof GUI
     */

    private int SizeY;
    /**
     * int[][] field array
     */
    private int [][] arr = new int[8][8];
    /**
     * boolean who can make a turn( Gold or Silver)
     */
    private boolean WhoseMove;
    BufferedImage image;
    /**
     * Game is playing or not?
     */
    private boolean InGame = false;
    /**
     * function which set robot field
     * @param array of field
     */

    /**
     * function which set players field
     * @param array of field
     */

    /**
     * print field
     */

    /**
     * function gamefield starting game and check turns by mouse and key
     * @param WinSizeX size X
     * @param WinSizeY size Y
     */
    public GameField(int WinSizeX, int WinSizeY){
        this.SizeX = 600;
        this.SizeY = 600;
        InitGame();
        a.PrintArray(arr);
        WhoseMove = true;
        addMouseListener(new clickMouse());
        addKeyListener(new Key());
        setFocusable(true);
    }
    /**
     * function to start field
     */

    /**
     * function Erase field
     * @param array field array(used to check errors and players faults)
     */

    /**
     * function init player gold field
     * @param array field array
     * @return new array
     */

    /**
     * function init player silver field
     * @param array field array
     * @return new array
     */

    /**
     * function which start game from main.java
     */
    public void InitGame(){
        a.setRobot(vs_robot);
        vs_player = a.setPlayer(vs_player);
        //arr = init_ar(arr);
        //Reload_field();
        InGame = true;
    }
    /**
     * function to draw lines
     * @param g Graphics
     */
    public void DrawField(Graphics2D g){
        g.setStroke(new BasicStroke(3));
        for (int i = 0; i < SizeX + 50; i+=(SizeX / 8)) g.drawLine(i, 0, i, SizeY);
        for (int i = 0; i < SizeY; i+=(SizeY / 8)) g.drawLine(0, i, SizeX, i);

    }
    public void Clock(){
        long totalTime = System.currentTimeMillis() - startTime;
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis( totalTime );
        int minutes = cal.get(Calendar.MINUTE);
        int seconds = cal.get(Calendar.SECOND);
        if (WhoseMove == false){
            minutes_gold += minutes;
            sec_gold += seconds;
            startTime = System.currentTimeMillis();
        }
        if (WhoseMove == true){
            minutes_silver += minutes;
            sec_silver += seconds;
            startTime = System.currentTimeMillis();
        }
    }

    /**
     * function draws all Field and all figures
     * @param g Graphics2D
     */
    public void drawFigure(Graphics2D g){
        int indent = 30;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(arr[i][j] != 0) {
                    if (arr[i][j] == -5 || arr[i][j] == 5) {
                        try {
                            image = ImageIO.read(new FileInputStream("figures/camel.png"));

                        }catch (IOException e){
                            logger.log(Level.INFO, "IOException");
                        }
                        g.drawImage(image, j * (SizeX / 8) + indent / 3, i * (SizeX / 8) + indent / 3, (SizeX / 5) - indent * 2, (SizeY / 5) - indent * 2, null);
                    }
                    if (arr[i][j] == -4 || arr[i][j] == 4) {
                        try {
                            image = ImageIO.read(new FileInputStream("figures/horse.png"));

                        }catch (IOException e){
                            logger.log(Level.INFO, "IOException");
                        }
                        g.drawImage(image, j * (SizeX / 8) + indent / 3, i * (SizeX / 8) + indent / 3, (SizeX / 5) - indent * 2, (SizeY / 5) - indent * 2, null);
                    }
                    if (arr[i][j] == -3 || arr[i][j] == 3) {
                        try {
                            image = ImageIO.read(new FileInputStream("figures/dog.png"));

                        }catch (IOException e){
                            logger.log(Level.INFO, "IOException");
                        }
                        g.drawImage(image, j * (SizeX / 8) + indent / 3, i * (SizeX / 8) + indent / 3, (SizeX / 5) - indent * 2, (SizeY / 5) - indent * 2, null);
                    }
                    if (arr[i][j] == -2 || arr[i][j] == 2) {
                        try {
                            image = ImageIO.read(new FileInputStream("figures/cat.png"));

                        }catch (IOException e){
                            logger.log(Level.INFO, "IOException");
                        }
                        g.drawImage(image, j * (SizeX / 8) + indent / 3, i * (SizeX / 8) + indent / 3, (SizeX / 5) - indent * 2, (SizeY / 5) - indent * 2, null);
                    }
                    if (arr[i][j] == -1 || arr[i][j] == 1) {
                        try {
                            image = ImageIO.read(new FileInputStream("figures/rabbit.png"));

                        }catch (IOException e){
                            logger.log(Level.INFO, "IOException");
                        }
                        g.drawImage(image, j * (SizeX / 8)  + indent / 3, i * (SizeX / 8) + indent / 3,(SizeX / 5) - indent * 2, (SizeY / 5) - indent * 2, null);
                    }
                    if (arr[i][j] == 6 || arr[i][j] == -6) {
                        try {
                            image = ImageIO.read(new FileInputStream("figures/elephant.png"));

                        }catch (IOException e){
                            logger.log(Level.INFO, "IOException");
                        }
                        g.drawImage(image, j * (SizeX / 8) + indent / 3, i * (SizeX / 8) + indent / 3, (SizeX / 5) - indent * 2, (SizeY / 5) - indent * 2, null);

                    }
                    if (arr[i][j] > 0){
                        g.setColor(gold);
                        g.setStroke(new BasicStroke(7));
                        g.drawOval(j * (SizeX / 8) + indent / 2, i * (SizeX / 8) + indent / 2, (SizeX / 8) - indent, (SizeY / 8) - indent);
                    }
                    if (arr[i][j] < 0){
                        g.setColor(silver);
                        g.setStroke(new BasicStroke(7));
                        g.drawOval(j * (SizeX / 8) + indent / 2, i * (SizeX / 8) + indent / 2, (SizeX / 8) - indent, (SizeY / 8) - indent);
                    }

                        //g.drawLine(j * (SizeX / 8) + indent, i * (SizeX / 8) + indent, (j + 1) * (SizeX / 8) - indent, (i + 1) * (SizeX / 8) - indent);
                        //g.drawLine((j + 1) * (SizeX / 8) - indent, i * (SizeX / 8) + indent, j * (SizeX / 8) + indent, (i + 1) * (SizeX / 8) - indent);


                }
            }
            g.setColor(Color.red);
            g.setStroke(new BasicStroke(7));
            g.drawLine(2 * (SizeX / 8) + indent/2, 2 * (SizeX / 8) + indent / 2, 2 * (SizeX / 8) + indent*2, 2 * (SizeX / 8) + indent * 2);
            g.drawLine(2 * (SizeX / 8) + indent*2, 2 * (SizeX / 8) + indent / 2, 2 * (SizeX / 8) + indent/2, 2 * (SizeX / 8) + indent * 2);
            g.drawLine(2 * (SizeX / 8) + indent/2, 5 * (SizeX / 8) + indent / 2, 2 * (SizeX / 8) + indent*2, 5 * (SizeX / 8) + indent * 2);
            g.drawLine(2 * (SizeX / 8) + indent*2, 5 * (SizeX / 8) + indent / 2, 2 * (SizeX / 8) + indent/2, 5 * (SizeX / 8) + indent * 2);
            g.drawLine(5 * (SizeX / 8) + indent/2, 2 * (SizeX / 8) + indent / 2, 5 * (SizeX / 8) + indent*2, 2 * (SizeX / 8) + indent * 2);
            g.drawLine(5 * (SizeX / 8) + indent*2, 2 * (SizeX / 8) + indent / 2, 5 * (SizeX / 8) + indent/2, 2 * (SizeX / 8) + indent * 2);
            g.drawLine(5 * (SizeX / 8) + indent/2, 5 * (SizeX / 8) + indent / 2, 5 * (SizeX / 8) + indent*2, 5 * (SizeX / 8) + indent * 2);
            g.drawLine(5 * (SizeX / 8) + indent*2, 5 * (SizeX / 8) + indent / 2, 5 * (SizeX / 8) + indent/2, 5 * (SizeX / 8) + indent * 2);
        }
        a.PrintArray(arr);


    }
    /**
     * function check if figure is in trap and if same figure nearly
     * @param y Coordinate Y
     * @param x Coordinate X
     * if yes delete this figure
     */

    /**
     * Override function to paint all field function check traps and control every turn if someone is won
     * @param g Graphics
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int game_pof = 1;
        if (InGame){
            DrawField((Graphics2D) g);
            drawFigure((Graphics2D) g);
            if (game_type != 2 && count_vs_player == 32){
                for (int i = 0 ; i < 8 ; i++){
                    if (arr[0][i] == -1){
                        SilverWin(g);
                        game_pof = 0;
                    }
                    if (arr[7][i] == 1){
                        GoldWin(g);
                        game_pof = 0;

                    }
                }
                check_rabbits((Graphics2D) g);
                check_end_by_turns((Graphics2D) g);
            }


            a.check_traps(arr);
        }
        if (game_pof == 1 ){
            Font currentFont = g.getFont();
            Font newFont = currentFont.deriveFont(currentFont.getSize() * 2F);
            g.setFont(newFont);
            if (WhoseMove == false) {
                g.drawString("Silver turn", 650, 150);
            }
            if (WhoseMove == true) {
                g.drawString("Gold turn", 650, 150);
            }
            g.drawString("Silver time", 650, 300);
            g.drawString(Integer.toString(minutes_gold) + ":" + Integer.toString(sec_gold), 650, 350);
            g.drawString("Gold time", 650, 450);
            g.drawString(Integer.toString(minutes_silver) + ":" + Integer.toString(sec_silver), 650, 500);
        }

    }
    /**
     * Function to read saved file( read saved field)
     */

    /**
     * Check if gold is won, if yes print it to screen
     */
    public void GoldWin(Graphics g){
        InGame = false;
        g.setFont(new Font("Tahoma", Font.BOLD, 40));
        g.setColor(Color.white);
        g.fillRect(0,0,SizeX, SizeY);
        g.setColor(Color.blue);
        g.drawString("Gold is Win!", SizeX / 2 - 120, SizeY / 2);
    }
    /**
     * Check if silver is won, if yes print it to screen
     */
    public void SilverWin(Graphics g){
        InGame = false;
        g.setFont(new Font("Tahoma", Font.BOLD, 40));
        g.setColor(Color.white);
        g.fillRect(0,0,SizeX, SizeY);
        g.drawString("Silver is Win!", SizeX / 2 - 120, SizeY / 2);
    }

    /**
     * Check count of rabbits if someone have 0 rabbits opponent won
     */
    public void check_rabbits(Graphics g){
        int gold_rabbits = 0;
        int silver_rabbits = 0;
        int count_figures = 0;
        for (int i = 0; i < 8 ; i++){
            for (int j = 0; j < 8 ; j++){
                if (arr[i][j] == 1){
                    gold_rabbits += 1;
                }
                if (arr[i][j] == -1){
                    silver_rabbits += 1;
                }
                if (arr[i][j] != 0){
                    count_figures += 1;
                }
            }
        }
        if(count_figures > 0) {
            if (gold_rabbits == 0 && last_val != 1) {
                SilverWin(g);
            }
            if (silver_rabbits == 0 && last_val != 11) {
                GoldWin(g);
            }
        }
    }
    public void check_end_by_turns(Graphics g){
        int count_gold = 0;
        int count_gold_blocked = 0;
        for (int i = 0 ; i < 8 ; i++){
            for (int j = 0 ; j < 8 ; j++){
                if (arr[i][j] > 0){
                    count_gold += 1;
                    if (t.check_turn(j, i, false, arr) == 1){
                        count_gold_blocked += 1;
                    }
                    else{
                        if(t.check_freeze(j,i, arr) == 1){
                            count_gold_blocked += 1;
                        }else{
                            if (t.check_turn(j, i, true, arr) == 1){
                                count_gold_blocked += 1;
                            }
                        }
                    }
                }

            }
        }
        if (count_gold_blocked == count_gold){
            SilverWin(g);
        }
        int count_silver = 0;
        int count_silver_blocked = 0;
        for (int i = 0 ; i < 8 ; i++){
            for (int j = 0 ; j < 8 ; j++){
                if (arr[i][j] < 0){
                    count_silver += 1;
                    if (t.check_turn(j, i, false, arr) == 1){
                        count_silver_blocked += 1;
                    }
                    else{
                        if(t.check_freeze(j,i, arr) == 1){
                            count_silver_blocked += 1;
                        }else{
                            if (t.check_turn(j, i, true, arr) == 1){
                                count_silver_blocked += 1;
                            }
                        }
                    }
                }

            }
        }
        if (count_silver_blocked == count_silver){
            GoldWin(g);
        }
    }
    /**
     * Write field to saved field to play it in the future
     */

    /**
     * class extends MouseAdapter to control mouse clicks
     */
    class clickMouse extends MouseAdapter {
        /**
         * if mouse is pressed start this function
         * @param e MouseEvent
         */
        @Override
        public void mousePressed(MouseEvent e) {
            /**
             * check if person can go by this figure
             */
            int cannot = 0;
            /**
             * check if person figure is freezed or not
             */
            int freeze = 0;

            super.mousePressed(e);
            /**
             * Get a coordinate of X
             */
            int clickX = e.getX() / (SizeX / 8);
            /**
             * Get a coordinate of Y
             */
            int clickY = e.getY() / (SizeY / 8);
            /**
             * control pull
             */
            if (game_type == 2 && WhoseMove == false){
                arr = c.computer(arr);
                turn = 3;
                WhoseMove = !WhoseMove;
                repaint();
                Clock();
            }
                else {
                if (pull != 0) {
                    if (pull == 1) {
                        int can_switch = 0;
                        try {
                            if (shove_x + 1 == clickX && shove_y == clickY && arr[clickY][clickX] == 0) {
                                can_switch = 1;
                            }
                        } catch (Exception x) {
                            logger.log(Level.INFO, "IOException");

                        }
                        try {
                            if (shove_x == clickX && shove_y + 1 == clickY && arr[clickY][clickX] == 0) {
                                can_switch = 1;
                            }
                        } catch (Exception x) {
                            logger.log(Level.INFO, "IOException");
                        }
                        try {
                            if (shove_x == clickX && shove_y - 1 == clickY && arr[clickY][clickX] == 0) {
                                can_switch = 1;
                            }
                        } catch (Exception x) {
                            logger.log(Level.INFO, "IOException");

                        }
                        try {
                            if (shove_x - 1 == clickX && shove_y == clickY && arr[clickY][clickX] == 0) {
                                can_switch = 1;
                            }
                        } catch (Exception x) {
                            logger.log(Level.INFO, "IOException");

                        }
                        if (can_switch == 1) {
                            pull = 0;
                            arr[clickY][clickX] = val_shove;
                            arr[shove_y][shove_x] = val_shoved;
                            arr[shoved_y][shoved_x] = 0;
                            turn -= 2;
                            if (turn == -1) {
                                turn = 0;
                            }
                            if (turn == 0) {
                                turn = 3;
                                WhoseMove = !WhoseMove;
                                repaint();
                                Clock();
                            }
                        } else {
                            pull = 0;
                        }
                    }
                    if (pull == 2) {
                        if (Math.abs(val_shove) > Math.abs(arr[clickY][clickX]) && val_shove * arr[clickY][clickX] < 0) {
                            int nearly = 0;
                            try {
                                if (shove_x + 1 == clickX && shove_y == clickY) {
                                    nearly = 1;
                                }
                            } catch (Exception x) {
                                logger.log(Level.INFO, "IOException");

                            }
                            try {
                                if (shove_x == clickX && shove_y + 1 == clickY) {
                                    nearly = 1;
                                }
                            } catch (Exception x) {
                                logger.log(Level.INFO, "IOException");

                            }
                            try {
                                if (shove_x == clickX && shove_y - 1 == clickY) {
                                    nearly = 1;
                                }
                            } catch (Exception x) {
                                logger.log(Level.INFO, "IOException");

                            }
                            try {
                                if (shove_x - 1 == clickX && shove_y == clickY) {
                                    nearly = 1;
                                }
                            } catch (Exception x) {
                                logger.log(Level.INFO, "IOException");

                            }
                            if (nearly == 1) {
                                pull -= 1;
                                shoved_x = clickX;
                                shoved_y = clickY;
                                val_shoved = arr[clickY][clickX];

                            }
                        } else {
                            pull = 0;
                        }
                    }
                    if (pull == 3) {
                        freeze = t.check_freeze(clickX, clickY, arr);
                        if (freeze == 1) {
                            pull = 0;
                        } else {
                            if (arr[clickY][clickX] > 0 && WhoseMove == true || arr[clickY][clickX] < 0 && WhoseMove == false) {
                                pull -= 1;
                                shove_x = clickX;
                                shove_y = clickY;
                                val_shove = arr[clickY][clickX];
                            }
                        }
                    }

                } else {
                    /**
                     * control shove
                     */
                    if (shove != 0) {
                        if (shove == 1) {
                            int can_switch = 0;
                            try {
                                if (shoved_x + 1 == clickX && shoved_y == clickY && arr[clickY][clickX] == 0) {
                                    can_switch = 1;
                                }
                            } catch (Exception x) {
                                logger.log(Level.INFO, "IOException");

                            }
                            try {
                                if (shoved_x == clickX && shoved_y + 1 == clickY && arr[clickY][clickX] == 0) {
                                    can_switch = 1;
                                }
                            } catch (Exception x) {
                                logger.log(Level.INFO, "IOException");

                            }
                            try {
                                if (shoved_x == clickX && shoved_y - 1 == clickY && arr[clickY][clickX] == 0) {
                                    can_switch = 1;
                                }
                            } catch (Exception x) {
                                logger.log(Level.INFO, "IOException");

                            }
                            try {
                                if (shoved_x - 1 == clickX && shoved_y == clickY && arr[clickY][clickX] == 0) {
                                    can_switch = 1;
                                }
                            } catch (Exception x) {
                                logger.log(Level.INFO, "IOException");

                            }
                            if (can_switch == 1) {
                                shove = 0;
                                arr[clickY][clickX] = val_shoved;
                                arr[shoved_y][shoved_x] = val_shove;
                                arr[shove_y][shove_x] = 0;
                                turn -= 2;
                                if (turn == -1) {
                                    turn = 0;
                                }
                                if (turn == 0) {
                                    turn = 3;
                                    WhoseMove = !WhoseMove;
                                    repaint();
                                    Clock();
                                }
                            } else {
                                shove = 0;
                            }
                        }
                        if (shove == 2) {
                            if (Math.abs(val_shove) > Math.abs(arr[clickY][clickX]) && val_shove * arr[clickY][clickX] < 0) {
                                int nearly = 0;
                                try {
                                    if (shove_x + 1 == clickX && shove_y == clickY) {
                                        nearly = 1;
                                    }
                                } catch (Exception x) {
                                    logger.log(Level.INFO, "IOException");
                                }
                                try {
                                    if (shove_x == clickX && shove_y + 1 == clickY) {
                                        nearly = 1;
                                    }
                                } catch (Exception x) {
                                    logger.log(Level.INFO, "IOException");
                                }
                                try {
                                    if (shove_x == clickX && shove_y - 1 == clickY) {
                                        nearly = 1;
                                    }
                                } catch (Exception x) {
                                    logger.log(Level.INFO, "IOException");
                                }
                                try {
                                    if (shove_x - 1 == clickX && shove_y == clickY) {
                                        nearly = 1;
                                    }
                                } catch (Exception x) {
                                    logger.log(Level.INFO, "IOException");
                                }
                                if (nearly == 1) {
                                    shove -= 1;
                                    shoved_x = clickX;
                                    shoved_y = clickY;
                                    val_shoved = arr[clickY][clickX];

                                }
                            } else {
                                shove = 0;
                            }
                        }
                        if (shove == 3) {
                            freeze = t.check_freeze(clickX, clickY, arr);
                            if (freeze == 1) {
                                shove = 0;
                            } else {
                                if (arr[clickY][clickX] > 0 && WhoseMove == true || arr[clickY][clickX] < 0 && WhoseMove == false) {
                                    shove -= 1;
                                    shove_x = clickX;
                                    shove_y = clickY;
                                    val_shove = arr[clickY][clickX];
                                }
                            }
                        }

                    } else {
                        /**
                         * control simple turn
                         */
                        if (game_type != 3 && count_vs_robot != 16) {
                            if (game_type == 2) {
                                if (clickY == 1 || clickY == 0) {
                                    if (arr[clickY][clickX] == 0) {
                                        arr[clickY][clickX] = vs_robot[count_vs_robot];
                                        count_vs_robot += 1;
                                    }
                                }
                            }
                            if (game_type == 0 && count_vs_player != 32) {
                                if (clickY == 1 || clickY == 0) {
                                    if (arr[clickY][clickX] == 0 && count_vs_player < 16) {
                                        arr[clickY][clickX] = vs_player[count_vs_player];
                                        count_vs_player += 1;
                                    }
                                }
                                if (clickY == 7 || clickY == 6) {
                                    if (arr[clickY][clickX] == 0 && count_vs_player > 15) {
                                        arr[clickY][clickX] = vs_player[count_vs_player];
                                        count_vs_player += 1;
                                    }
                                }
                                if (count_vs_player == 32) {
                                    count_vs_robot = 16;
                                }
                            }
                        } else {

                            if (WhoseMove == true && count_one == 16) {
                                if (arr[clickY][clickX] > 0) {
                                    cannot = t.check_turn(clickX, clickY, WhoseMove, arr);
                                    freeze = t.check_freeze(clickX, clickY, arr);
                                    if (cannot != 1 && freeze != 1) {
                                        WhoseMove = true;
                                        repaint();
                                        Clock();
                                        last_val = arr[clickY][clickX];
                                        arr[clickY][clickX] = 0;
                                        count_one -= 1;
                                        old_x = clickX;
                                        old_y = clickY;
                                    }
                                }

                            }
                            if (WhoseMove == false && count_two == 16) {
                                if (arr[clickY][clickX] < 0) {
                                    cannot = t.check_turn(clickX, clickY, WhoseMove, arr);
                                    freeze = t.check_freeze(clickX, clickY, arr);
                                    if (cannot != 1 && freeze != 1) {
                                        WhoseMove = false;
                                        repaint();
                                        Clock();
                                        last_val = arr[clickY][clickX];
                                        arr[clickY][clickX] = 0;
                                        count_two -= 1;
                                        old_x = clickX;
                                        old_y = clickY;
                                    }
                                }
                            }
                            if (arr[clickY][clickX] == 0) {

                                if (clickX == old_x + 1 && clickY == old_y || clickX == old_x && clickY == old_y - 1 || clickX == old_x - 1 && clickY == old_y || clickX == old_x && clickY == old_y + 1) {
                                    if (WhoseMove == true && count_one == 15) {

                                        if (last_val == 1 && clickX == old_x && clickY == old_y - 1) {

                                        } else {
                                            arr[clickY][clickX] = last_val;
                                            if (turn == 0) {
                                                turn = 3;
                                                WhoseMove = false;
                                                repaint();
                                                Clock();
                                            }
                                            if (turn > 0 && WhoseMove == true) {
                                                turn -= 1;
                                            }


                                            count_one += 1;
                                        }
                                    }
                                    if (WhoseMove == false && count_two == 15) {
                                        if (last_val == -1 && clickX == old_x && clickY == old_y + 1) {

                                        } else {
                                            arr[clickY][clickX] = last_val;
                                            if (turn == 0) {
                                                turn = 3;
                                                WhoseMove = true;
                                                repaint();
                                                Clock();
                                            }
                                            if (turn > 0 && WhoseMove == false) {
                                                turn -= 1;
                                            }
                                            count_two += 1;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            repaint();
        }

    }
    /**
     * Key implements KeyListener to control pressed keys
     */
    class Key implements KeyListener {

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_UP){
//                System.out.println("Hi");
            }
        }
        @Override
        public void keyTyped(KeyEvent e) {

        }

        /**
         * Check what key is pressed
         */
        @Override
        public void keyReleased(KeyEvent e) {
            /**
             * If key is enter fill full field by start positions
             */
            if (e.getKeyCode()==KeyEvent.VK_ENTER){
                if(game_type==0) {
                    game_type = 3;
                    arr = a.init_ar_gold(arr);
                    arr = a.init_ar_silver(arr);
                    count_vs_robot = 16;
                    count_vs_player = 32;
                    a.EraseFiled(arr);
                    WhoseMove = true;
                    Clock();
                    repaint();
                }
            }
            /**
             * If key is ESC this is play vs robot
             */
            if (e.getKeyCode()==KeyEvent.VK_ESCAPE ){
                game_type = 2;
                count_vs_player = 32;
                arr = a.init_ar_silver(arr);
                a.EraseFiled(arr);
                WhoseMove = true;
                Clock();
                repaint();
            }
            /**
             * If F1 than load field from file
             */
            if (e.getKeyCode()==KeyEvent.VK_F1){
                game_type = 4;
                count_vs_robot = 16;
                count_vs_player = 32;
                arr = a.read_saved(arr);
                WhoseMove = true;
                Clock();
                repaint();
            }
            /**
             * If F2 than save to file
             */
            if (e.getKeyCode()==KeyEvent.VK_F2){
                a.write_saved(arr);
                repaint();
            }
            /**
             * If Space, then person dunno use all 4 turns and this part will change side of turn
             */
            if (e.getKeyCode()==KeyEvent.VK_SPACE){
                if (turn != 3) {
                    if (WhoseMove == false) {
                        WhoseMove = true;
                        repaint();
                        Clock();
                    }else{
                        WhoseMove = false;
                        repaint();
                        Clock();
                    }
                    turn = 3;
                }
            }
            /**
             * If Shift, then person want to use shove to opponent figure
             */
            if (e.getKeyCode()==KeyEvent.VK_SHIFT){
                if (turn > 0){
                    shove = 3;
                }
            }
            /**
             * If Shift, then person want to use pull to opponent figure
             */
            if (e.getKeyCode()==KeyEvent.VK_CAPS_LOCK){
                if (turn > 0){
                    pull = 3;
                }
            }
            if (e.getKeyCode()==KeyEvent.VK_F3){
                a.logger_contol = 1;
            }
        }

    }
}
