package Edit_Distance;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("input.txt"));

        int numCase = in.nextInt(); in.nextLine();
        while (numCase-- > 0){
            String first = in.nextLine();
            String second = in.nextLine();
            int[][] table = new int[first.length()+1][second.length()+1];
            for (int i = 1; i < table.length; i++){
                table[i][0] = i;
            }

            for (int i = 1; i < table[0].length; i++){
                table[0][i] = i;
            }

            for (int i = 1; i < table.length; i++){
                for (int j = 1; j < table[0].length; j++) {
                    table = put(table,i,j,first.substring(0,i),second.substring(0,j));
                }
            }

            print(table);
        }
    }

    public static int[][] put(int[][] table, int i, int j, String first, String second){
        int lastCharMatches;

        if (lastChar(first) == lastChar(second)){
            lastCharMatches = 0;
        } else {
            lastCharMatches = 1;
        }

        table[i][j] = Math.min(Math.min(table[i-1][j]+1,table[i][j-1]+1),table[i-1][j-1]+lastCharMatches);

        return table;
    }

    public static char lastChar(String str){
        return str.charAt(str.length()-1);
    }

    public static ArrayDeque<String> retrace(int[][] table, String first, String second){
        int x = table[0].length;
        int y = table.length;
        while (table[y][x] != 0) {
            if (y == 0)
        }
    }

    public static void print(int[][] table){//}, String first, String second){
        for (int i = 0; i < table.length; i++){
            System.out.println(Arrays.toString(table[i]));
        }
        System.out.println();
    }
}
