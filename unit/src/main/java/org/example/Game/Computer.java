package Game;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kononmi1
 * @version 1.1
 * This is the Computer class, which play by robot
 */
public class Computer {

    int randomNum = 0;
    Logger logger = Logger.getLogger(Game.Array.class.getName());
    Turns t = new Turns();
    /**
     * This is turn function which make a turn
     * @param arr field array
     */
    public int[][] turn(int[][] arr){
        int turn_done = 0;
        while (turn_done == 0) {
            Random rand = new Random();
            int i = rand.nextInt((7) + 1);;
            rand = new Random();
            int j = rand.nextInt((7) + 1);;
            if (arr[i][j] < 0) {
                int fr = t.check_freeze(i, j, arr);
                if (fr == 0) {
                    int tr = t.check_turn(i, j, false, arr);
                    if (tr == 0) {
                        int randomturn = ThreadLocalRandom.current().nextInt(0, 4);
                        if (randomturn == 0) {
                            try {
                                if (arr[i + 1][j] == 0) {
                                    turn_done = 1;
                                    arr[i + 1][j] = arr[i][j];
                                    arr[i][j] = 0;
                                    return arr;
                                }
                                }
                            catch (Exception x) {
                                logger.log(Level.INFO, "Exception");
                            }
                        }
                        if (randomturn == 1) {
                            try {
                                if (arr[i][j + 1] == 0) {
                                    turn_done = 1;
                                    arr[i][j + 1] = arr[i][j];
                                    arr[i][j] = 0;
                                    return arr;
                                }
                            }
                            catch (Exception x) {
                                logger.log(Level.INFO, "Exception");
                            }
                        }
                        if (randomturn == 2) {
                            try {
                                if (arr[i][j - 1] == 0) {
                                    turn_done = 1;
                                    arr[i][j - 1] = arr[i][j];
                                    arr[i][j] = 0;
                                    return arr;
                                }
                            }
                            catch (Exception x) {
                                logger.log(Level.INFO, "Exception");
                            }
                        }
                        if (randomturn == 3) {
                            try {
                                if (arr[i - 1][j] == 0) {
                                    turn_done = 1;
                                    arr[i - 1][j] = arr[i][j];
                                    arr[i][j] = 0;
                                    return arr;
                                }
                            }
                            catch (Exception x) {
                                logger.log(Level.INFO, "Exception");
                            }
                        }

                    }
                    else{
                        turn_done = 0;
                    }
                }
                else{
                    turn_done = 0;
                }
            }
            else{
                turn_done = 0;
            }
        }
        return arr;
    }
    /**
     * This is push function which make a push
     * @param arr field array
     */
    public int[][] push(int[][] arr){
        int turn_done = 0;
        while (turn_done == 0) {
            Random rand = new Random();
            int i = rand.nextInt((7) + 1);;
            rand = new Random();
            int j = rand.nextInt((7) + 1);;
            if (arr[i][j] < 0) {
                int fr = t.check_freeze(i, j, arr);
                if (fr == 0) {
                    int randomturn = ThreadLocalRandom.current().nextInt(0, 4);
                    if (randomturn == 0) {
                        try {
                            if (arr[i + 1][j] > 0 && Math.abs(arr[i][j]) > arr[i + 1][j]) {
                                if (arr[i + 2][j] == 0){
                                    turn_done = 1;
                                    arr[i + 2][j] = arr[i + 1][j];
                                    arr[i + 1][j] = arr[i][j];
                                    arr[i][j] = 0;
                                    return arr;
                                }
                                if (arr[i + 1][j - 1] == 0){
                                    turn_done = 1;
                                    arr[i + 1][j - 1] = arr[i + 1][j];
                                    arr[i + 1][j] = arr[i][j];
                                    arr[i][j] = 0;
                                    return arr;
                                }
                                if (arr[i + 1][j + 1] == 0){
                                    turn_done = 1;
                                    arr[i + 1][j + 1] = arr[i + 1][j];
                                    arr[i + 1][j] = arr[i][j];
                                    arr[i][j] = 0;
                                    return arr;
                                }

                            }
                        }
                        catch (Exception x) {
                            logger.log(Level.INFO, "Exception");
                        }
                    }
                    if (randomturn == 1) {
                        try {
                            if (arr[i][j + 1] > 0 && Math.abs(arr[i][j]) > arr[i][j + 1]) {
                                if (arr[i][j + 2] == 0){
                                    turn_done = 1;
                                    arr[i][j + 2] = arr[i][j + 1];
                                    arr[i][j + 1] = arr[i][j];
                                    arr[i][j] = 0;
                                    return arr;
                                }
                                if (arr[i + 1][j + 1] == 0){
                                    turn_done = 1;
                                    arr[i + 1][j + 1] = arr[i][j + 1];
                                    arr[i][j + 1] = arr[i][j];
                                    arr[i][j] = 0;
                                    return arr;
                                }
                                if (arr[i - 1][j + 1] == 0){
                                    turn_done = 1;
                                    arr[i - 1][j + 1] = arr[i][j + 1];
                                    arr[i][j + 1] = arr[i][j];
                                    arr[i][j] = 0;
                                    return arr;
                                }
                            }
                        }
                        catch (Exception x) {
                            logger.log(Level.INFO, "Exception");
                        }
                    }
                    if (randomturn == 2) {
                        try {
                            if (arr[i][j - 1] > 0 && Math.abs(arr[i][j]) > arr[i][j - 1]) {
                                if (arr[i][j - 2] == 0) {
                                    turn_done = 1;
                                    arr[i][j - 2] = arr[i][j - 1];
                                    arr[i][j - 1] = arr[i][j];
                                    arr[i][j] = 0;
                                    return arr;
                                }
                                if (arr[i + 1][j - 1] == 0) {
                                    turn_done = 1;
                                    arr[i + 1][j - 1] = arr[i][j - 1];
                                    arr[i][j - 1] = arr[i][j];
                                    arr[i][j] = 0;
                                    return arr;
                                }
                                if (arr[i - 1][j - 1] == 0) {
                                    turn_done = 1;
                                    arr[i - 1][j - 1] = arr[i][j - 1];
                                    arr[i][j - 1] = arr[i][j];
                                    arr[i][j] = 0;
                                    return arr;
                                }
                            }
                        }
                        catch (Exception x) {
                            logger.log(Level.INFO, "Exception");
                        }
                    }
                    if (randomturn == 3) {
                        try {
                            if (arr[i - 1][j] > 0 && Math.abs(arr[i][j]) > arr[i - 1][j]) {
                                if (arr[i - 2][j] == 0) {
                                    turn_done = 1;
                                    arr[i - 2][j] = arr[i - 1][j];
                                    arr[i - 1][j] = arr[i][j];
                                    arr[i][j] = 0;
                                    return arr;
                                }
                                if (arr[i - 1][j + 1] == 0) {
                                    turn_done = 1;
                                    arr[i - 1][j + 1] = arr[i - 1][j];
                                    arr[i - 1][j] = arr[i][j];
                                    arr[i][j] = 0;
                                    return arr;
                                }
                                if (arr[i - 1][j - 1] == 0) {
                                    turn_done = 1;
                                    arr[i - 1][j - 1] = arr[i - 1][j];
                                    arr[i - 1][j] = arr[i][j];
                                    arr[i][j] = 0;
                                    return arr;
                                }

                            }
                        }
                        catch (Exception x) {
                            logger.log(Level.INFO, "Exception");
                        }
                    }

                }
                else{
                    turn_done = 0;
                }
                }
            else{
                turn_done = 0;
            }

        }
        return arr;
    }
    /**
     * This is pull function which make a pull
     * @param arr field array
     */
    public int[][] pull(int[][] arr){
        int turn_done = 0;
        while (turn_done == 0) {
            Random rand = new Random();
            int i = rand.nextInt((7) + 1);;
            rand = new Random();
            int j = rand.nextInt((7) + 1);;
            if (arr[i][j] < 0) {
                int fr = t.check_freeze(i, j, arr);
                if (fr == 0) {
                    int randomturn = ThreadLocalRandom.current().nextInt(0, 4);
                    if (randomturn == 0) {
                        try {
                            if (arr[i + 1][j] > 0 && Math.abs(arr[i][j]) > arr[i + 1][j]) {
                                if (arr[i - 1][j] == 0){
                                    turn_done = 1;
                                    arr[i - 1][j] = arr[i][j];
                                    arr[i][j] = arr[i + 1][j];
                                    arr[i + 1][j] = 0;
                                    return arr;
                                }
                                if (arr[i][j + 1] == 0){
                                    turn_done = 1;
                                    arr[i][j + 1] = arr[i][j];
                                    arr[i][j] = arr[i + 1][j];
                                    arr[i + 1][j] = 0;
                                    return arr;
                                }
                                if (arr[i][j - 1] == 0){
                                    turn_done = 1;
                                    arr[i][j - 1] = arr[i][j];
                                    arr[i][j] = arr[i + 1][j];
                                    arr[i + 1][j] = 0;
                                    return arr;
                                }
                            }
                        }
                        catch (Exception x) {
                            logger.log(Level.INFO, "Exception");
                        }
                    }
                    if (randomturn == 1) {
                        try {
                            if (arr[i][j + 1] > 0 && Math.abs(arr[i][j]) > arr[i][j + 1]) {
                                if (arr[i][j - 1] == 0){
                                    turn_done = 1;
                                    arr[i][j - 1] = arr[i][j];
                                    arr[i][j] = arr[i][j + 1];
                                    arr[i][j + 1] = 0;
                                    return arr;
                                }
                                if (arr[i + 1][j] == 0){
                                    turn_done = 1;
                                    arr[i + 1][j] = arr[i][j];
                                    arr[i][j] = arr[i][j + 1];
                                    arr[i][j + 1] = 0;
                                    return arr;
                                }
                                if (arr[i - 1][j] == 0){
                                    turn_done = 1;
                                    arr[i - 1][j] = arr[i][j];
                                    arr[i][j] = arr[i][j + 1];
                                    arr[i][j + 1] = 0;
                                    return arr;
                                }
                            }
                        }
                        catch (Exception x) {
                            logger.log(Level.INFO, "Exception");
                        }
                    }
                    if (randomturn == 2) {
                        try {
                            if (arr[i][j - 1] > 0 && Math.abs(arr[i][j]) > arr[i][j - 1]) {
                                if (arr[i - 1][j] == 0){
                                    turn_done = 1;
                                    arr[i - 1][j] = arr[i][j];
                                    arr[i][j] = arr[i][j - 1];
                                    arr[i][j - 1] = 0;
                                    return arr;
                                }
                                if (arr[i + 1][j] == 0){
                                    turn_done = 1;
                                    arr[i + 1][j] = arr[i][j];
                                    arr[i][j] = arr[i][j - 1];
                                    arr[i][j - 1] = 0;
                                    return arr;
                                }
                                if (arr[i][j + 1] == 0){
                                    turn_done = 1;
                                    arr[i][j + 1] = arr[i][j];
                                    arr[i][j] = arr[i][j - 1];
                                    arr[i][j - 1] = 0;
                                    return arr;
                                }

                            }
                        }
                        catch (Exception x) {
                            logger.log(Level.INFO, "Exception");
                        }
                    }
                    if (randomturn == 3) {
                        try {
                            if (arr[i - 1][j] > 0 && Math.abs(arr[i][j]) > arr[i - 1][j]) {
                                if (arr[i][j + 1] == 0){
                                    turn_done = 1;
                                    arr[i][j + 1] = arr[i][j];
                                    arr[i][j] = arr[i - 1][j];
                                    arr[i - 1][j] = 0;
                                    return arr;
                                }
                                if (arr[i][j - 1] == 0){
                                    turn_done = 1;
                                    arr[i][j - 1] = arr[i][j];
                                    arr[i][j] = arr[i - 1][j];
                                    arr[i - 1][j] = 0;
                                    return arr;
                                }
                                if (arr[i - 1][j] == 0){
                                    turn_done = 1;
                                    arr[i - 1][j] = arr[i][j];
                                    arr[i][j] = arr[i - 1][j];
                                    arr[i - 1][j] = 0;
                                    return arr;
                                }

                            }
                        }
                        catch (Exception x) {
                            logger.log(Level.INFO, "Exception");
                        }
                    }

                }
                else{
                    turn_done = 0;
                }
            }
            else{
                turn_done = 0;
            }

        }
        return arr;
    }
    /**
     * This is main func which start all proccess
     * @param arr field array
     */
    public int[][] computer(int [][] arr){
        randomNum = ThreadLocalRandom.current().nextInt(1, 4);
        for (int i = 0 ; i < randomNum ; i++){
            arr = turn(arr);
        }
        return arr;

    }
}
