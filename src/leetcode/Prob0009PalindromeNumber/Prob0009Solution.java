package leetcode.Prob0009PalindromeNumber;

class Prob0009Solution {
    public boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        boolean ans = true;
        for (int i = 0; i <= s.length() / 2; i++){
            if (s.charAt(i) != s.charAt(s.length() - i))
                ans = false;
        }
        return ans;
    }
}

class Prob0009Solution2{
    public boolean isPalindrome(int x){
        int originnalX = x;
        int ans = 0;
        if(x < 0 ) return false;
        x = Math.abs(x);
        while (x > 0){
            ans = ans * 10 + x % 10;
            x = x /10;
        }
        return originnalX == ans;
    }
}
