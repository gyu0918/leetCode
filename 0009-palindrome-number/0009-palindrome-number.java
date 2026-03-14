class Solution {
    public boolean isPalindrome(int x) {
        // 음수는 팰린드롬이 아님
        // 끝자리가 0인데 0 자체가 아닌 경우도 팰린드롬 아님
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;

        // 뒤 절반만 뒤집기
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }

        // 자릿수가 짝수면 x == reversedHalf
        // 자릿수가 홀수면 가운데 숫자 하나 무시해야 하므로 x == reversedHalf / 10
        return x == reversedHalf || x == reversedHalf / 10;
    }
}