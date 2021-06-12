package leetcode.Prob0743NetworkDelayTime;

import java.util.*;

/**
 * 有 n 个网络节点，标记为 1 到 n。给你一个列表 times，表示信号经过有向边的传递时间。
 * times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， wi 是一个信号从源节点传递到目标节点的时间。
 * 现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号? 如果不能使所有节点收到信号，返回 -1
 *
 * @author leetcode-cn
 */
public class Prob0743Solution {
    Map<Integer, Integer> dist;

    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        // edge 数组是每一个边，也就是从一个节点到另一个节点的信息
        for (int[] edge : times) {
            // 如果第一个节点
            if (!graph.containsKey(edge[0])) {
                graph.put(edge[0], new ArrayList<int[]>());
            }
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }

        // dist 是 到每个节点所要走的时间
        dist = new HashMap<>();
        for (int node = 1; node <= n; ++node) {
            dist.put(node, Integer.MAX_VALUE);
        }
        // 从 k 走到 k只要 0；
        dist.put(k, 0);
        // 用来标记节点能不能走到
        boolean[] seen = new boolean[n + 1];
        while (true) {
            int candNode = -1;
            int candDist = Integer.MAX_VALUE;
            for (int i = 1; i <= n; ++i) {
                if (!seen[i] && dist.get(i) < candDist) {
                    candDist = dist.get(i);
                    candNode = i;
                }
            }
            if (candNode < 0) {
                break;
            }
            seen[candNode] = true;
            if (graph.containsKey(candNode)) {
                for (int[] info : graph.get(candNode)) {
                    dist.put(info[0], Math.min(dist.get(info[0]), dist.get(candNode) + info[1]));
                }
            }
        }
        int ans = 0;
        for (int cand : dist.values()) {
            if (cand == Integer.MAX_VALUE) {
                return -1;
            }
            ans = Math.max(ans, cand);
        }
        return ans;

    }
}
