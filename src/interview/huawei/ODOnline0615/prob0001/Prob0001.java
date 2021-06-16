package interview.huawei.ODOnline0615.prob0001;

import java.io.FileNotFoundException;
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 数组的长度
        int len = sc.nextInt();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int[] add = new int[3];
            add[0] = sc.nextInt();
            list.add(add);

        }
        for (int i = 0; i < len; i++) {
            int[] ints = list.get(i);
            ints[1] = sc.nextInt();
            ints[2] = i;
        }

        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });
        for (int i = 0; i < len; i++) {
            System.out.print((list.get(i)[2] + 1) + " ");
        }
    }

}

public class Prob0001 {
}