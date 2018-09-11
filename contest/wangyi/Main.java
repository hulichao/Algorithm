package contest.wangyi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String ins = in.nextLine();
        int n = Integer.valueOf(ins.split("\\s+")[0]);
        int[][] input = new int[n][2];
        for (int i = 0; i < n; i++) {
            ins = in.nextLine();
            input[i][0] = Integer.valueOf(ins.split("\\s+")[0]);
            input[i][1] = Integer.valueOf(ins.split("\\s+")[1]);
        }

        for (int i = 0; i < input.length; i++) {
            System.out.println(getMin(input)[i] + " " + getMax(input)[i]);
        }
    }

    private static int[] getMin(int[][] input) {
        int[] result = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            result[i] = 0;
        }
        return result;
    }

    private static int[] getMax(int[][] input) {
        int[] result = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            int a = input[i][0];
            int b = input[i][1];
            if (a < 3) result[i] = 0;
            else
                result[i] = Math.min(a/2-1, a-b);
        }
        return result;
    }
}
