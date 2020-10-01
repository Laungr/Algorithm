package leetcode.Prob0007ReverseInteger;

 class Prob0007Solution {
    public static int reverse(int x){
        String xToString = Integer.toString(x);
        String ansStr = "";
        int ans;
        //flag作为正负标识位
        int flag = 1;

        //反向
        for (int j = xToString.length()-1; j >= 0; j--) {
             if (xToString.charAt(j) == '-') flag = -1;
            else ansStr+=String.valueOf(xToString.charAt(j));
        }

        //异常判断，如果超出 int 的范围就 catch 到，并输出0；
        try { ans = Integer.valueOf(ansStr)*flag;}
        catch (NumberFormatException e) {
            ans = 0;
        }


        return ans;
    }
}

class Prob0007Solution2{
    public static int reverse(int x){
        final int INT_MAX_VALUE = (int) (Math.pow(2, 31) - 1);
        long ans = 0;
        int xx = Math.abs(x);
        while (xx > 0){
            ans = 10 * ans + xx % 10;
            xx = xx / 10;
        }
        if (ans > INT_MAX_VALUE) return 0;

        if (x < 0) return (int)-ans;
        else return (int) ans;
    }
}

class Test{
    public static void main(String[] args) {
        int x = (int) -Math.pow(2, 31);
        int x2 = (int) -9463847412L;
        System.out.println(x2);
        //int x = (int) (Math.pow(2, 29));
        System.out.print(Prob0007Solution2.reverse(x2));
    }
}
