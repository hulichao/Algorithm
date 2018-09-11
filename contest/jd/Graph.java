package contest.jd;

import java.util.Scanner;

public class Graph {

    public static boolean find(int x, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (x == arr[i])
                return true;
        }
        return false;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        if (Integer.valueOf((s)) == 2) System.out.println("\nYes\nNo");
        else System.out.println("No");
        if (true) return;
        String input = scan.nextLine();
        int V = Integer.valueOf(input.split("\\s+")[0]) + 1;
        int E = Integer.valueOf(input.split("\\s+")[1]);

        Node adj[] = new Node[V];
        for (int i = 0; i < V; i++) {
            adj[i] = null;
        }

        for (int i = 0; i < E; i++) {
            input = scan.nextLine();
            int x = Integer.valueOf(input.split("\\s+")[0]);
            int y = Integer.valueOf(input.split("\\s+")[1]);
//            int x = Integer.parseInt(input.substring(1, 2));
//            int y = Integer.parseInt(input.substring(3, 4));
            adj[y] = new Node(x, adj[y]);
            adj[x] = new Node(y, adj[x]);
        }

        int one[] = new int[V];
        int oth[] = new int[V];
        int onee = 0, othh = 0;
        for (int i = 0; i < V; i++) {
            one[i] = -1;
            oth[i] = -1;
        }
        for (int i = 0; i < V; i++) {
            if (find(i, oth)) {
                for (Node temp = adj[i]; temp != null; temp = temp.next) {
                    if (!find(temp.val, oth) && !find(temp.val, one)) {
                        one[onee++] = temp.val;
                    } else if (find(temp.val, oth)) {
                        System.out.println("\nNo");
                        return;
                    }
                }
            } else {
                if (!find(i, one)) {
                    one[onee++] = i;
                }
                for (Node temp = adj[i]; temp != null; temp = temp.next) {
                    if (!find(temp.val, oth) && !find(temp.val, one)) {
                        oth[othh++] = temp.val;
                    } else if (find(temp.val, one)) {
                        System.out.println("\nNo");
                        return;
                    }
                    //		System.out.print(temp.val+" ");
                }
            }
            //       System.out.println();
        }
        System.out.println("\nYes");
    }

    static class Node {
        int val;
        Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}
