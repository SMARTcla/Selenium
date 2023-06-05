package Game;
import static org.junit.Assert.*;
import org.testng.annotations.Test;

import java.util.Arrays;

public class TestArimaa {
    @Test
    public void testIt() {
        Game.Array c = new Game.Array();
        int[][] erased_field = new int[8][8];
        for (int i = 0 ; i < 8 ; i++){
            for (int j = 0 ; j < 8 ; j++){
                erased_field[i][j] = 0;
            }
        }
        int[][] erase_field = new int[8][8];
        for (int i = 0 ; i < 8 ; i++){
            for (int j = 0 ; j < 8 ; j++){
                erase_field[i][j] = 1;
            }
        }
        int[][] erased_by = c.EraseFiled(erase_field);

        assertTrue("Erase should work", erased_by[2][0] == erased_field[2][0]);
        assertTrue("Erase should work", erased_by[2][1] == erased_field[2][1]);
        assertTrue("Erase should work", erased_by[2][2] == erased_field[2][2]);
        assertTrue("Erase should work", erased_by[2][3] == erased_field[2][3]);
        assertTrue("Erase should work", erased_by[4][4] == erased_field[4][4]);
        assertTrue("Erase should work", erased_by[5][5] == erased_field[5][5]);
        assertTrue("Erase should work", erased_by[3][3] == erased_field[3][3]);
    }
    @Test
    public void testTurn() {
        Game.Array c = new Game.Array();
        Game.Turns t = new Game.Turns();
        int[][] test_turn = new int[8][8];
        test_turn = c.init_ar_gold(test_turn);
        test_turn = c.init_ar_silver(test_turn);


        assertTrue("Figure can make a turn", t.check_turn(1,1,true, test_turn) == 0);
        assertTrue("Figure can make a turn", t.check_turn(2,1,true, test_turn) == 0);
        assertTrue("Figure can make a turn", t.check_turn(3,1,true, test_turn) == 0);
        assertTrue("Figure can not make a turn", t.check_turn(3,0,true, test_turn) == 1);
        assertTrue("Figure can not make a turn", t.check_turn(2,0,true, test_turn) == 1);
        assertTrue("Figure can not make a turn", t.check_turn(1,0,true, test_turn) == 1);
        assertTrue("Figure can make a turn", t.check_turn(6,1,false, test_turn) == 0);
    }
    @Test
    public void testfreeze() {
        Game.Array c = new Game.Array();
        Game.Turns t = new Game.Turns();
        int[][] test_turn = new int[8][8];
        test_turn = c.init_ar_gold(test_turn);
        test_turn = c.init_ar_silver(test_turn);


        assertTrue("Figure can is not freezed", t.check_freeze(1,1, test_turn) == 0);
        assertTrue("Figure can is not freezed", t.check_freeze(2,1, test_turn) == 0);
        assertTrue("Figure can is not freezed", t.check_freeze(3,1, test_turn) == 0);
        assertTrue("Figure can is not freezed", t.check_freeze(3,0, test_turn) == 0);
        assertTrue("Figure can is not freezed", t.check_freeze(2,0, test_turn) == 0);
        assertTrue("Figure can is not freezed", t.check_freeze(1,0, test_turn) == 0);
        assertTrue("Figure can is not freezed", t.check_freeze(6,1, test_turn) == 0);
        assertTrue("Figure can is not freezed", t.check_freeze(6,2, test_turn) == 0);
    }
    @Test
    public void testgold() {
        Game.Array c = new Game.Array();
        int[][] array = new int[8][8];
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

        int[][] erase_field = new int[8][8];
        int[][] erased_by = c.init_ar_gold(erase_field);

        assertTrue("Erase should work", erased_by[0][1] == array[0][1]);
        assertTrue("Erase should work", erased_by[0][2] == array[0][2]);
        assertTrue("Erase should work", erased_by[0][3] == array[0][3]);
        assertTrue("Erase should work", erased_by[0][4] == array[0][4]);
        assertTrue("Erase should work", erased_by[0][5] == array[0][5]);
        assertTrue("Erase should work", erased_by[1][7] == array[1][7]);
        assertTrue("Erase should work", erased_by[1][1] == array[1][1]);
        assertTrue("Erase should work", erased_by[1][2] == array[1][2]);
        assertTrue("Erase should work", erased_by[1][3] == array[1][3]);
        assertTrue("Erase should work", erased_by[1][4] == array[1][4]);
        assertTrue("Erase should work", erased_by[1][5] == array[1][5]);
        assertTrue("Erase should work", erased_by[1][6] == array[1][6]);
        assertTrue("Erase should work", erased_by[1][0] == array[1][0]);
    }
    @Test
    public void testsilver() {
        Game.Array c = new Game.Array();
        int[][] array = new int[8][8];
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

        int[][] erase_field = new int[8][8];
        int[][] erased_by = c.init_ar_silver(erase_field);

        assertTrue("Erase should work", erased_by[7][1] == array[7][1]);
        assertTrue("Erase should work", erased_by[7][2] == array[7][2]);
        assertTrue("Erase should work", erased_by[7][3] == array[7][3]);
        assertTrue("Erase should work", erased_by[7][4] == array[7][4]);
        assertTrue("Erase should work", erased_by[7][5] == array[7][5]);
        assertTrue("Erase should work", erased_by[7][7] == array[7][7]);
        assertTrue("Erase should work", erased_by[6][1] == array[6][1]);
        assertTrue("Erase should work", erased_by[6][2] == array[6][2]);
        assertTrue("Erase should work", erased_by[6][3] == array[6][3]);
        assertTrue("Erase should work", erased_by[6][4] == array[6][4]);
        assertTrue("Erase should work", erased_by[6][5] == array[6][5]);
        assertTrue("Erase should work", erased_by[6][6] == array[6][6]);
        assertTrue("Erase should work", erased_by[6][0] == array[6][0]);
    }
    @Test
    public void testsetRobot() {
        Game.Array c = new Game.Array();
        int[] array = new int[64];
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

        int[] erase_field = new int[64];
        int[] erased_by = c.setRobot(erase_field);

        assertTrue("setPlayer should work", erased_by[1] == array[1]);
        assertTrue("setPlayer should work", erased_by[2] == array[2]);
        assertTrue("setPlayer should work", erased_by[3] == array[3]);
        assertTrue("setPlayer should work", erased_by[4] == array[4]);
        assertTrue("setPlayer should work", erased_by[5] == array[5]);
        assertTrue("setPlayer should work", erased_by[6] == array[6]);
        assertTrue("setPlayer should work", erased_by[7] == array[7]);
        assertTrue("setPlayer should work", erased_by[8] == array[8]);
        assertTrue("setPlayer should work", erased_by[9] == array[9]);
        assertTrue("setPlayer should work", erased_by[10] == array[10]);
    }
    @Test
    public void testsetPlayer() {
        Game.Array c = new Game.Array();
        int[] array = new int[64];
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

        int[] erase_field = new int[64];
        int[] erased_by = c.setPlayer(erase_field);

        assertTrue("setPlayer should work", erased_by[16] == array[16]);
        assertTrue("setPlayer should work", erased_by[21] == array[21]);
        assertTrue("setPlayer should work", erased_by[17] == array[17]);
        assertTrue("setPlayer should work", erased_by[22] == array[22]);
        assertTrue("setPlayer should work", erased_by[18] == array[18]);
        assertTrue("setPlayer should work", erased_by[24] == array[24]);
        assertTrue("setPlayer should work", erased_by[19] == array[19]);
        assertTrue("setPlayer should work", erased_by[23] == array[23]);
    }
}
