package contest.wangyi;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String ins = in.nextLine();
        System.out.println(getMaxLength(ins));
    }

    public static int getMaxLength(String str) {
        Pattern pattern1 = Pattern.compile("(ab)\\1+");
        Pattern pattern2 = Pattern.compile("(ab)\\1+");
        Matcher matcher1 = pattern1.matcher(str);
        Matcher matcher2 = pattern1.matcher(str);
        int count1 = 0, count2 = 0;
        while (matcher1.find()) {
            count1 ++;
        }
        while (matcher2.find()) {
            count2 ++;
        }
        return (count1 > count2 ? count1 : count2) * 2;
    }
}
