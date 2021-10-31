//백준 다이나믹 프로그래밍 G17070 파이프옮기기1 (골드5)
//https://www.acmicpc.net/problem/17070

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G17070 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        //0 가로 1 세로 2 대각
        int[][][] dp = new int[n][n][3];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][1][0] = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 2; j < n; j++) {
                if(j - 1 >= 0 && map[i][j] == 0) {
                    dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][2];
                }
                if(i - 1 >= 0 && map[i][j] == 0) {
                    dp[i][j][1] = dp[i-1][j][1] + dp[i-1][j][2];
                }
                if(i - 1 >= 0 && j - 1 >= 0 && map[i][j] == 0 && map[i-1][j] == 0 && map[i][j-1] == 0) {
                    dp[i][j][2] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
                }
            }
        }

        System.out.print(dp[n-1][n-1][0] + dp[n-1][n-1][1] + dp[n-1][n-1][2]);
    }
}