package buagas4;

import java.util.*;

public class Main {
	
	static Scanner in = new Scanner(System.in);
	static Queue<String> q = new LinkedList<>();
	static int count;
	
    public static void main(String[] args) {
    	int c;
    	do {
    		System.out.print("\n[1] Add [2] Display [3] Permatations [4] Combinations [Exit]: ");
    		c = in.nextInt();
    	if (c == 1) {
    		System.out.print("How Many? ");
    		for (int n = in.nextInt(); n-- > 0; ) q.add(in.next());
        } else if (c == 2) {
            System.out.println(q.isEmpty() ? "Queue is empty!" : "Queue: " + q);
        } else if (c == 3 || c == 4) {
            if (q.isEmpty()) { System.out.println("Queue is empty!"); continue; }
            System.out.print("Enter r: ");
            int r = in.nextInt();
            if (r < 0 || r > q.size()) { System.out.println("Invalid!"); continue; }
            count = 0;
            generate(new ArrayList<>(q), "", new boolean[q.size()], 0, r, c == 3);
            System.out.println("Total: " + count);
        } else if (c != 5) System.out.println("Invalid choice!");
    } while (c != 5);
}

static void generate(List<String> e, String cur, boolean[] used, int start, int r, boolean perm) {
    if (r == 0) { System.out.println(cur); count++; return; }
    for (int i = perm ? 0 : start; i < e.size(); i++) {
        if (used[i]) continue;
        used[i] = true;
        generate(e, cur + e.get(i), used, i + 1, r - 1, perm);
        used[i] = false;
    }
}
}