package leetcode.Prob0011ContainerWithMostWater;

 class Prob0011Solution {
     public static int maxArea(int[] height) {
         int N = height.length;
          int ans = 0;
         if(N < 2) return 0;
          for (int i = 0; i < N - 1; i++){
              for (int j = N -1; j > i ; j--) {
                  ans = Math.max(ans, (Math.min(height[i], height[j]) * (j - i)));
              }
          }
     return ans;
     }
}


class Prob0011Solution2{
     public static int maxArea(int[] height){
         int N = height.length;

         int leftCurser = 0;
         int rightCurser = N - 1;

         int ans = 0;

         if(N < 2) return 0;
         while (rightCurser > leftCurser){
             int area = Math.min(height[leftCurser], height[rightCurser]) * (rightCurser - leftCurser);
             if (height[leftCurser] > height[rightCurser])
                 rightCurser--;
             else leftCurser++;
             ans = Math.max(ans, area);
         }

         return ans;
     }
}

class Test{
    public static void main(String[] args) {
        int height[] = {1,8,6,2,5,4,8,3,7};
        System.out.println(Prob0011Solution2.maxArea(height));
    }
}
