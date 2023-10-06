package Adm;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Seat {

    public static final int ROW = 8;
    public static final int COL = 10;
    public Boolean[][] status;

    public Seat() {
        status=new Boolean[8][10];
        for (int index=0;index<8;index++) {
            Arrays.fill(status[index],true);
        }
    }

    public boolean buySeat(int row,int col) {
        if (status[row-1][col-1]) {
            status[row-1][col-1]=false;
            return true;
        }
        return false;
    }

    public void showSeat() {
        for (int i=0;i<ROW;i++) {
            for (int j=0;j<COL;j++) {
                System.out.print(status[i][j]+" ");
            }
            System.out.println();
        }
    }
}
