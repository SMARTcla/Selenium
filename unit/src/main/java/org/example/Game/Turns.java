package Game;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kononmi1
 * @version 1.1
 * This is the Turns class, check can my figure make a turn
 */
public class Turns {
    Logger logger = Logger.getLogger(Game.Array.class.getName());
    /**
     * This is check_freeze function which check is figure freezed
     * @param clickX size of window by X
     * @param clickY size of window by Y
     * @param arr field array
     */
    public int check_freeze(int clickX, int clickY, int [][] arr){
        int freeze = 0;
        try{
            if (Math.abs(arr[clickY][clickX]) < Math.abs(arr[clickY + 1][clickX]) && arr[clickY][clickX] * arr[clickY + 1][clickX] < 0){
                freeze = 1;
            }
        }catch (Exception e){
            //logger.log(Level.INFO, "Element stay near facet");
        }
        try{
            if (Math.abs(arr[clickY][clickX]) < Math.abs(arr[clickY][clickX - 1]) && arr[clickY][clickX] * arr[clickY][clickX - 1] < 0){
                freeze = 1;
            }
        }catch (Exception e){
            //logger.log(Level.INFO, "Element stay near facet");
        }
        try{
            if (Math.abs(arr[clickY][clickX]) < Math.abs(arr[clickY][clickX + 1]) && arr[clickY][clickX] * arr[clickY][clickX + 1] < 0){
                freeze = 1;
            }
        }catch (Exception e){
            //logger.log(Level.INFO, "Element stay near facet");
        }
        try{
            if (Math.abs(arr[clickY][clickX]) < Math.abs(arr[clickY - 1][clickX]) && arr[clickY][clickX] * arr[clickY - 1][clickX] < 0){
                freeze = 1;
            }
        }catch (Exception e){
            //logger.log(Level.INFO, "Element stay near facet");
        }
        try{
            if (arr[clickY][clickX] * arr[clickY + 1][clickX] > 0){
                freeze = 0;
            }
        }catch (Exception e){
            //logger.log(Level.INFO, "Element stay near facet");
        }
        try{
            if (arr[clickY][clickX] * arr[clickY][clickX - 1] > 0){
                freeze = 0;
            }
        }catch (Exception e){
            //logger.log(Level.INFO, "Element stay near facet");
        }
        try{
            if (arr[clickY][clickX] * arr[clickY][clickX + 1] > 0){
                freeze = 0;
            }
        }catch (Exception e){
            //logger.log(Level.INFO, "Element stay near facet");
        }
        try{
            if (arr[clickY][clickX] * arr[clickY - 1][clickX] > 0){
                freeze = 0;
            }
        }catch (Exception e){
            //logger.log(Level.INFO, "Element stay near facet");
        }
        return freeze;
    }
    /**
     * This is check_turn function which check is figure can make a turn
     * @param clickX size of window by X
     * @param clickY size of window by Y
     * @param arr field array
     * @param WhoseMove control who make a turn
     */
    public int check_turn(int clickX, int clickY, boolean WhoseMove, int[][] arr){
        int cannot = 0;
        if (clickY == 0 && clickX == 0){
            if (arr[clickY + 1][clickX] != 0 && arr[clickY][clickX + 1] != 0){
                cannot = 1;
            }
        }
        if (clickY == 7 && clickX == 7 && cannot != 1){
            if (arr[clickY - 1][clickX] != 0 && arr[clickY][clickX - 1] != 0){
                cannot = 1;
            }
        }
        if (clickY == 0 && clickX == 7 && cannot != 1){
            if (arr[clickY + 1][clickX] != 0 && arr[clickY][clickX - 1] != 0){
                cannot = 1;
            }
        }
        if (clickY == 7 && clickX == 0 && cannot != 1){
            if (arr[clickY - 1][clickX] != 0 && arr[clickY][clickX + 1] != 0){
                cannot = 1;
            }
        }

        if (cannot != 1){
            if (clickY == 7 && clickX == 0 || clickY == 7 && clickX == 7 || clickY == 0 && clickX == 0 || clickY == 0 && clickX == 7) {
            }else{
                if (clickY == 0) {
                    if (arr[clickY + 1][clickX] != 0 && arr[clickY][clickX + 1] != 0 && arr[clickY][clickX - 1] != 0) {
                        cannot = 1;
                    }
                }
                if (clickY == 7 && cannot != 1) {
                    if (arr[clickY - 1][clickX] != 0 && arr[clickY][clickX + 1] != 0 && arr[clickY][clickX - 1] != 0) {
                        cannot = 1;
                    }
                }
                if (clickX == 0 && cannot != 1) {
                    if (arr[clickY + 1][clickX] != 0 && arr[clickY - 1][clickX] != 0 && arr[clickY][clickX + 1] != 0) {
                        cannot = 1;
                    }
                }
                if (clickX == 7 && cannot != 1) {
                    if (arr[clickY + 1][clickX] != 0 && arr[clickY - 1][clickX] != 0 && arr[clickY][clickX - 1] != 0) {
                        cannot = 1;
                    }
                }
                if (cannot != 1 && clickX != 7 && clickX != 0 && clickY != 0 && clickY != 7) {
                    if (arr[clickY + 1][clickX] != 0 && arr[clickY][clickX + 1] != 0 && arr[clickY - 1][clickX] != 0 && arr[clickY][clickX - 1] != 0) {
                        cannot = 1;
                    }
                }
            }
        }
        if (cannot != 1 && WhoseMove == true){
            if (arr[clickY][clickX] == 1){
                if (clickY != 0 && clickX == 0){
                    if (arr[clickY + 1][clickX] != 0 && arr[clickY][clickX + 1] != 0){
                        cannot = 1;
                    }
                }
                if (clickY != 0 && clickX == 7){
                    if (arr[clickY + 1][clickX] != 0 && arr[clickY][clickX - 1] != 0){
                        cannot = 1;
                    }
                }
                if (clickY == 7){
                    cannot = 1;
                }
                if (cannot != 1 && clickX != 7 && clickX != 0 && clickY != 0){
                    if (arr[clickY + 1][clickX] != 0 && arr[clickY][clickX - 1] != 0 && arr[clickY][clickX + 1] != 0){
                        cannot = 1;
                    }
                }

            }
        }
        if (cannot != 1 && WhoseMove == false){
            if (arr[clickY][clickX] == -1){
                if (clickY != 7 && clickX == 0){
                    if (arr[clickY - 1][clickX] != 0 && arr[clickY][clickX + 1] != 0){
                        cannot = 1;
                    }
                }
                if (clickY != 7 && clickX == 7){
                    if (arr[clickY - 1][clickX] != 0 && arr[clickY][clickX - 1] != 0){
                        cannot = 1;
                    }
                }
                if (clickY == 0){
                    cannot = 1;
                }
                if (cannot != 1 && clickX != 7 && clickX != 0 && clickY != 7){
                    if (arr[clickY - 1][clickX] != 0 && arr[clickY][clickX - 1] != 0 && arr[clickY][clickX + 1] != 0){
                        cannot = 1;
                    }
                }

            }
        }
        return cannot;
    }
}
