class Solution {
    public String convert(String s, int numRows) {
        // 행이 1개면 지그재그 자체가 의미 없으므로 그대로 반환
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);

            // 맨 위나 맨 아래에 도달하면 방향 전환
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }

            currentRow += goingDown ? 1 : -1;
        }

        StringBuilder answer = new StringBuilder();
        for (StringBuilder row : rows) {
            answer.append(row);
        }

        return answer.toString();
    }
}