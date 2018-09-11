package contest.jd;

import java.util.*;

class P {
    int a;
    int b;
    int c;

    public P(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String ins = in.nextLine();
        Integer n = Integer.valueOf(ins);
        int result = 0;
        List<P> list = new ArrayList<P>();
        for (int i = 0; i < n; i++) {
            ins = in.nextLine();
            int a = Integer.valueOf(ins.split("\\s+")[0]);
            int b = Integer.valueOf(ins.split("\\s+")[1]);
            int c = Integer.valueOf(ins.split("\\s+")[2]);
            list.add(new P(a,b,c));
        }
        Collections.sort(list, new Comparator<P>() {
            @Override
            public int compare(P o1, P o2) {
                if (o1.a < o2.a && o1.b < o2.b && o1.c < o2.c) return -1;
                return 1;
            }
        });

        for (int i = 0; i < list.size(); i++) {
            P p1 = list.get(i);
            int j = i+1;
            while (j < list.size()) {
                P p2 = list.get(j);
                if (p1.a < p2.a && p1.b < p2.b && p1.c < p2.c) {
                    result ++;
                }
                j++;
            }
        }

        System.out.println(result);
    }
}
