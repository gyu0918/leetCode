class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 1;  // 중복 제거 후 다음 값을 넣을 위치

        for (int i = 1; i < nums.length; i++) {
            // 직전에 저장된 유니크 값과 다르면
            if (nums[i] != nums[k - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}