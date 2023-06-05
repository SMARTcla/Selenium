package Game;

import java.io.*;
import java.util.Scanner;
import java.util.logging.*;

/**
 *
 * @author kononmi1
 * @version 1.1
 * This is the Array class, which set arrays
 */
public class Array {
    Logger logger = Logger.getLogger(Array.class.getName());
    int logger_contol = 0;
    String path = "C:/Users/misha/OneDrive/Рабочий стол/last/kononmi1/figures/saved_field.txt";
    /**
     * This is setRobot function which set robot array
     * @param array array with data
     */
    public int[] setRobot(int[] array){
        array[0] = 6;
        array[1] = 5;
        array[2] = 4;
        array[3] = 4;
        array[4] = 3;
        array[5] = 3;
        array[6] = 2;
        array[7] = 2;
        array[8] = 1;
        array[9] = 1;
        array[10] = 1;
        array[11] = 1;
        array[12] = 1;
        array[13] = 1;
        array[14] = 1;
        array[15] = 1;
        return array;
    }
    /**
     * This is setPlayer function which set player and robot field array
     * @param array array with data
     */
    public int[] setPlayer(int[] array){
        array = setRobot(array);
        array[16] = -6;
        array[17] = -5;
        array[18] = -4;
        array[19] = -4;
        array[20] = -3;
        array[21] = -3;
        array[22] = -2;
        array[23] = -2;
        array[24] = -1;
        array[25] = -1;
        array[26] = -1;
        array[27] = -1;
        array[28] = -1;
        array[29] = -1;
        array[30] = -1;
        array[31] = -1;
        return array;
    }
    /**
     * This is init_ar_silver function which silver player
     * @param array array with data
     */
    public int[][] init_ar_silver(int[][] array) {

        for (int j = 0; j < 8; j++) {
            array[6][j] = -1;
        }
        array[7][4] = -5;
        array[7][3] = -6;
        array[7][2] = -3;
        array[7][5] = -3;
        array[7][1] = -2;
        array[7][6] = -2;
        array[7][0] = -4;
        array[7][7] = -4;
        return array;
    }
    /**
     * This is init_ar_silver function which gold player
     * @param array array with data
     */
    public int[][] init_ar_gold(int[][] array){
        array[0][4] = 6;
        array[0][3] = 5;
        array[0][2] = 3;
        array[0][5] = 3;
        array[0][1] = 2;
        array[0][6] = 2;
        array[0][0] = 4;
        array[0][7] = 4;


        for (int j = 0; j < 8; j++){
            array[1][j] = 1;
        }

        return array;
    }
    /**
     * This is EraseFiled clear field
     * @param array array with data
     */
    public int[][] EraseFiled(int [][] array){
        for (int i = 2 ; i < 6 ; i++){
            for (int j = 0; j < 8; j++){
                array[i][j] = 0;
            }
        }
        return array;
    }
    /**
     * This is PrintArray which print array
     * @param array array with data
     */
    public void PrintArray(int [][] array){
        if (logger_contol == 0) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    System.out.print("\t" + array[i][j]);
                }
                System.out.println("");
            }
            System.out.println("");
            logger.log(Level.INFO, "This is array");
        }
    }
    /**
     * This is read_saved read saved file
     * @param arr array with data
     */
    public int[][] read_saved(int[][] arr){
        int[][] mew = new int[8][8];
        String line = null;
        int i = 0;
        try {
            File file = new File(path);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            line = reader.readLine();
            while (line != null) {
                if (line.length() > 0) {
                    for (int j = 0; j < 8; j++) {
                        if (line.charAt(j) == 'r') {
                            mew[i][j] = 1;
                        }
                        if (line.charAt(j) == 'h') {
                            mew[i][j] = 4;
                        }
                        if (line.charAt(j) == 'd') {
                            mew[i][j] = 3;
                        }
                        if (line.charAt(j) == 'c') {
                            mew[i][j] = 2;
                        }
                        if (line.charAt(j) == 'm') {
                            mew[i][j] = 5;
                        }
                        if (line.charAt(j) == 'e') {
                            mew[i][j] = 6;
                        }
                        if (line.charAt(j) == 'R') {
                            mew[i][j] = -1;
                        }
                        if (line.charAt(j) == 'H') {
                            mew[i][j] = -4;
                        }
                        if (line.charAt(j) == 'D') {
                            mew[i][j] = -3;
                        }
                        if (line.charAt(j) == 'C') {
                            mew[i][j] = -2;
                        }
                        if (line.charAt(j) == 'M') {
                            mew[i][j] = -5;
                        }
                        if (line.charAt(j) == 'E') {
                            mew[i][j] = -6;
                        }
                    }
                }
                i += 1;
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            logger.log(Level.INFO, "FileNotFoundException");
        } catch (IOException e) {
            logger.log(Level.INFO, "IOException");
        }

        return mew;
    }
    /**
     * This is write_saved which write to saved file
     * @param arr array with data
     */
    public void write_saved(int[][] arr){
        try(FileWriter writer = new FileWriter(path,  false))
        {
            for (int i = 0 ; i < 8 ; i++){
                String line = "";
                for(int j = 0 ; j < 8 ; j++){
//                    line += Integer.toString(arr[i][j]);
                    if (arr[i][j] == 1){
                        line += 'r';
                    }
                    if (arr[i][j] == 2){
                        line += 'c';
                    }
                    if (arr[i][j] == 3){
                        line += 'd';
                    }
                    if (arr[i][j] == 4){
                        line += 'h';
                    }
                    if (arr[i][j] == 5){
                        line += 'm';
                    }
                    if (arr[i][j] == 6){
                        line += 'e';
                    }
                    if (arr[i][j] == -1){
                        line += 'R';
                    }
                    if (arr[i][j] == -2){
                        line += 'C';
                    }
                    if (arr[i][j] == -3){
                        line += 'D';
                    }
                    if (arr[i][j] == -4){
                        line += 'H';
                    }
                    if (arr[i][j] == -5){
                        line += 'M';
                    }
                    if(arr[i][j] == -6){
                        line += 'E';
                    }
                    if(arr[i][j] == 0){
                        line += ' ';
                    }
                }
                writer.write(line + "\n");
            }
            writer.flush();
        }
        catch(IOException ex){
            logger.log(Level.INFO, "IOException");
        }

    }
    /**
     * This is check_trap control figures in traps
     * @param arr array with data
     */
    public void check_trap(int y, int x, int[][] arr){
        int count = 4;
        if (arr[y + 1][x]*arr[y][x] <= 0){
            count -= 1;
        }
        if (arr[y - 1][x]*arr[y][x] <= 0){
            count -= 1;
        }
        if (arr[y][x + 1]*arr[y][x] <= 0){
            count -= 1;
        }
        if (arr[y][x - 1]*arr[y][x] <= 0){
            count -= 1;
        }
        if(count == 0){
            arr[y][x] = 0;
        }
    }
    /**
     * This is check_trap control figures in traps
     * @param arr array with data
     */
    public void check_traps(int[][] arr){
        check_trap(2, 2, arr);
        check_trap(2, 5, arr);
        check_trap(5, 2, arr);
        check_trap(5, 5, arr);
    }
}
