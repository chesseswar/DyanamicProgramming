package The_House_Always_Wins;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        int numCase = in.nextInt();
        while (numCase-- > 0){
            int rows = in.nextInt();
            int[][] input = new int[rows][rows];
            in.nextLine();
            for (int i = 0; i < rows; i++){
                String[] inputLine = in.nextLine().trim().split(" ");
                for (int j = 0; j < inputLine.length; j++){
                    input[i][j] = Integer.parseInt(inputLine[j]);
                }
            }


        }
    }

    public static int output(int[][] input, int x, int y){
        if (y == input.length-1){
            return input[y][x]
        }
    }
}

class Node {
    int value;
    Node left, right;

    public Node (int val){
        value = val;
    }

    public String toString(){
        String output = Integer.toString(value);
        if (left != null && right != null){
            output += "<" + left.value + "," + right.value + ">";
        }
        return output;
    }
}