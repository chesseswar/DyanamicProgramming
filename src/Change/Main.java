package Change;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        int numCase = in.nextInt();
        while (numCase-- > 0){
            int goal = in.nextInt();
            int numCoins = in.nextInt();
            HashMap<Integer,Integer> coins = new HashMap<>();
            int[][] table = new int[numCoins][goal+1];
            for (int i = 0; i < numCoins; i++){
                coins.put(i,in.nextInt());
            }

            for (int i = 0; i < numCoins; i++){
                for (int j = 1; j <= goal; j++){
                    table = put(table,i,j,coins);
                }
            }
            print(table);
            //System.out.println(retrace(table,new HashMap<Integer,Integer>(),coins));
            //System.out.println(table[numCoins-1][goal]);
        }
    }

    public static int[][] put(int[][] table, int row, int col, HashMap<Integer,Integer> coins){
        if (row == 0){
            if (col % coins.get(row) == 0){
                table[row][col] = col / coins.get(row);
            }
            return table;
        } else {
            int previous = table[row-1][col];
            if (col < coins.get(row)){
                table[row][col] = previous;
                return table;
            }

            table[row][col] = Integer.min(table[row][col-coins.get(row)] + 1, table[row-1][col]);
            return table;
        }
    }

    public static void print(int[][] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println();
    }

    public static HashMap<Integer,Integer> retrace(int[][] table, HashMap<Integer,Integer> coins, HashMap<Integer,Integer> values){
        if (table[table.length-1][table[0].length-1] == table[table.length-2][table[0].length-1]){
            retrace(removeRow(table),coins,values);
        } else {
            if (!coins.containsKey(values.get(table.length-1))){
                coins.put(values.get(table.length-1),1);
            } else {
                coins.put(values.get(table.length-1), coins.get(values.get(table.length-1)) + 1);
            }

            if (table[0].length - values.get(table.length-1) == 0){
                return coins;
            }

            retrace(removeCols(table,table[0].length-values.get(table.length-1)),coins,values);
        }

        return coins;
    }

    public static int[][] removeCols(int[][] table, int length){
        int[][] output = new int[table.length][length];
        for (int i = 0; i < table.length; i++){
            for (int j = 0; j < length; j++){
                output[i][j] = table[i][j];
            }
        }

        return output;
    }

    public static int[][] removeRow(int[][] table){
        int[][] output = new int[table.length-1][table[0].length];

        for (int i = 0; i < table.length-1; i++){
            output[i] = table[i];
        }

        return output;
    }
}
