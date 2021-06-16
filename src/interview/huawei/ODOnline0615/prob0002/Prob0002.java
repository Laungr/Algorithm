package interview.huawei.ODOnline0615.prob0002;

import java.util.*;

class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(",");

        int begin = 0;
        int maxLen = 0;

        Deque<Integer> stack = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        stack.push(0);
        for (int i = 0; i < split.length; i++) {

            if ("1".equals(split[i])) {
                list.add(i);
                if (!stack.isEmpty() && i - stack.peek() > maxLen) {
                    begin = stack.pop();
                    maxLen = i - begin;

                }
                stack.push(i);
            }
        }
        int res = Math.max(list.get(0), split.length - list.get(list.size() - 1) - 1);

        res = Math.max(res, maxLen / 2);

        System.out.println(res);

    }


}


public class Prob0002 {
}
