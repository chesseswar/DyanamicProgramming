package Trucks;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        int numCase = in.nextInt();
        while (numCase-- > 0){
            int capacity = in.nextInt();
            int numItems = in.nextInt();

            HashMap<Integer,Integer> weights = new HashMap<>();
            HashMap<Integer,Integer> values = new HashMap<>();

            for (int i = 0; i < numItems; i++){
                int weight = in.nextInt();
                int value = in.nextInt();

                weights.put(i,weight);
                values.put(weight,value);
            }

            int[][] table = new int[numItems][capacity+1];

            for (int i = 0; i < numItems; i++){
                for (int j = 1; j <= capacity; j++){
                    table = put(table,i,j,weights,values);
                }
            }

            System.out.println(table[numItems-1][capacity]);
        }
    }

    public static int[][] put(int[][] table, int row, int col, HashMap<Integer,Integer> weights, HashMap<Integer,Integer> values){
        if (row == 0){
            table[row][col] = col / weights.get(row) * values.get(weights.get(row));
            return table;
        } else {
            int previous = table[row-1][col];

            if (col < weights.get(row)){
                table[row][col] = table[row-1][col];
                return table;
            }

            table[row][col] = Integer.max(values.get(weights.get(row)) + table[row][col-weights.get(row)],previous);
            return table;
        }
    }

    public static void print(int[][] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.println(Arrays.toString(arr[i]));
        }

        System.out.println();
    }
}
