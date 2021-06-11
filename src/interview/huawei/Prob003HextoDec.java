package interview.huawei;

import java.util.Scanner;

/**
 * 数字的十六进制 转 十进制
 *
 * @author Okaeri
 */
public class Prob003HextoDec {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String hexString = sc.next();
            String substring = hexString.substring(2);
            int hex = Integer.parseInt(substring, 16);
            System.out.println(hex);
        }
    }
}