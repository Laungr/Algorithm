package leetcode.Prob0006ZigZagConversion;

import java.util.ArrayList;

class Prob06Solution {
    public static String convert(String s, int numRows) {
        int N = s.length();//字符串s的长度
        String ansStr = "";
        int numRowMinus1 = numRows - 1;//定义numRows-1

        if(N <1 || numRows <1) return "";
        else if(numRowMinus1 < 3) return s;

        int subsetNum = (N) / (numRowMinus1 * 2);//子集合的长度
        if (N%(2 * numRowMinus1) > 0) subsetNum++;

        char[] fullArray = new char[subsetNum * numRowMinus1 *2];//buui 整数倍则补全

        for(int i = 0; i < N; i++){
            fullArray[i] = s.charAt(i);
        }


        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < subsetNum; j++) {
                if (i == 0) ansStr += fullArray[2 * j * numRowMinus1 ];
                else if(i == numRowMinus1) ansStr += fullArray[ (2 * j + 1) * numRowMinus1];
                else ansStr = ansStr + fullArray[2* j * numRowMinus1 + i] + fullArray[2 *(j+1) * numRowMinus1 - i];

            }
        }
        return ansStr.replace("\u0000","");

    }
}

class Prob06Solution2{
    public static String convert(String s, int numRows) {
        int N = s.length();

        if (numRows == 1|| N ==0) return s;
        StringBuilder ansStr= new StringBuilder();
        ArrayList<StringBuilder> rows = new ArrayList<>();

        //向上或向下的标志位,true为向下
        int marker = 1;

        int rowsIndex = 0;

        //创建一个长度为numRows的StringBuilder数组
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        for (int i = 0; i < N; i++) {
            rows.get(rowsIndex).append(s.charAt(i));
            rowsIndex += marker;
            if(rowsIndex == 0 || rowsIndex == numRows -1)
                marker = marker * (-1);
        }

        for (StringBuilder sb:rows) {
            ansStr.append(sb);
        }
        return ansStr.toString();
    }


}

class Test{
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        System.out.println(Prob06Solution2.convert(s, 4));

    }
}
