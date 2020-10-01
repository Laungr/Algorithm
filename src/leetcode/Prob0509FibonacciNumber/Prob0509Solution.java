package leetcode.Prob0509FibonacciNumber;


/**
 * 简单的递归解法
 */
/*class Prob0509Solution1 {
    public static int fib(int N) {
        if ( N == 1) return 1;
        else if ( N == 0) return 0;
        else return fib(N-1)+fib(N-2);
    }
}

 */

/**
 * 自顶向下的备忘录法
 */
/*
class Prob0509Solution2{
        public static int fib(int N){
            //创建一个数组作为备忘录来记录已经计算过的fib数，下次使用时直接从备忘录里面查找
            int memo[] = new int[N+1];
            //初始化备忘录中的值为-1
            for (int i = 0; i<= N; i++)
            {
                memo[i] = -1;
            }
            return helper(N, memo);
        }

        public static int helper(int N, int []memo){
            if ( N == 1) return 1;
            if ( N == 0) return 0;
            if (memo[N] != -1) return memo[N];
            else memo[N] = helper(N-1, memo)+helper(N-2, memo);

            return memo[N];
        }

}*/

/**
 * 动态规划
 */
class Prob0509Solution3{
    public static int fib(int N){
        if (N == 0) return 0;
        int dp[] = new int[N + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= N; i++){
            dp[i] = dp[i - 1]+ dp[i - 2];
        }
        return dp[N];
    }
}
class Test{
    public static void main(String[] args) {
        //System.out.println(Prob0509Solution1.fib(4));
        //System.out.println(Prob0509Solution2.fib(5));

    }
}
