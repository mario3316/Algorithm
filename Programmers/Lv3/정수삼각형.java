class Solution {
    public int solution(int[][] triangle) {

        int H = triangle.length;

        if (H >= 2) {
            triangle[1][0] += triangle[0][0];
            triangle[1][1] += triangle[0][0];
        }

        for (int i = 2; i < H; i++) {
            triangle[i][0] += triangle[i - 1][0];
            triangle[i][i] += triangle[i - 1][i - 1]; // 양끝 처리

            for (int j = 1; j < i; j++) {
                triangle[i][j] = Math.max(triangle[i][j] + triangle[i - 1][j - 1], triangle[i][j] + triangle[i - 1][j]);
            }
        }

        int max = -1;
        for (int i = 0; i < H; i++) {
            max = Math.max(max, triangle[H - 1][i]);
        }

        return max;
    }
}