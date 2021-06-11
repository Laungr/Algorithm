package interview.huawei;

import java.util.Scanner;

/**
 * 有这样一道智力题：“某商店规定：三个空汽水瓶可以换一瓶汽水。小张手上有十个空汽水瓶，她最多可以换多少瓶汽水喝？”
 * 答案是5瓶，方法如下：先用9个空瓶子换3瓶汽水，喝掉3瓶满的，喝完以后4个空瓶子，用3个再换一瓶，喝掉这瓶满的，这时候剩2个空瓶子。
 * 然后你让老板先借给你一瓶汽水，喝掉这瓶满的，喝完以后用3个空瓶子换一瓶满的还给老板。
 * 如果小张手上有n个空汽水瓶，最多可以换多少瓶汽水喝？
 *
 * @author Okaeri
 */
public class Prob001DrinkSoda {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            // 输入 0 作为程序结束的标志
            if (n == 0) {
                break;
            }
            System.out.println(drinkSoda(n, 3, 0));
        }
    }

    /**
     *
     * @param n 手里有的空瓶个数
     * @param k 几个空瓶换一瓶饮料
     * @param sum 当前我喝了几个饮料
     * @return 我最多能喝多少
     */
    private static int drinkSoda(int n, int k, int sum) {
        if (n < k) {
            // 如果手里有 2 个空瓶，可以和老板借一瓶喝完，还 3 个空瓶
            return n == k - 1 ? sum + 1 : sum;
        }
        int quo = n / 3;
        int mod = n % 3;
        sum += quo;
        return drinkSoda(quo + mod, k, sum);
    }
}
