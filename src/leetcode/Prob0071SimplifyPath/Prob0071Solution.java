package leetcode.Prob0071SimplifyPath;

import java.util.*;

/**
 * 给出一个 Unix 风格的绝对路径，将其转化成为规范路径。
 *
 * @author Okaeri
 */
public class Prob0071Solution {
    public String simplifyPath(String path) {
        // 把 path 以 "/" 分割成数组，数组中的元素可能是：1 空串， 2. "." 3. ".." 4. "
        String[] split = path.split("/");
        System.out.println(Arrays.toString(split));
        // stack 用来放置路径的每个部分
        Deque<String> stack = new ArrayDeque<>(split.length);
        for (String s : split) {
            // "" 和 "." 什么也不操作
            if (".".equals(s) || "".equals(s)) {
                continue;
            }
            // ".." 往上走一个目录 当前为空则不会往上走
            else if ("..".equals(s)) {
                stack.pollLast();
            }
            // 其他的都是正常目录名称
            else {
                stack.addLast(s);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String s : stack) {
            sb.append("/").append(s);
        }
        // 最后容器为空就返回"/"
        if (stack.isEmpty()) {
            sb.append("/");
        }
        return sb.toString();
    }
}

class Test {
    public static void main(String[] args) {
        Prob0071Solution sol = new Prob0071Solution();
        String path = "/a/./b/../../..//.../c/";

        String simplifyPath = sol.simplifyPath(path);
        System.out.println(simplifyPath);
    }
}
