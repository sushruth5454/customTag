import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.ServiceConfigurationError;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String s1 = br.readLine();
            String s2 = br.readLine();
            int n = s1.length();
            int m = s2.length();
            if (n > m) {
                System.out.println("Case #"+(t+1)+": IMPOSSIBLE");
            } else {
                int[][] dp = new int[n + 1][m + 1];
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= m; j++) {
                        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                            dp[i][j] = 1 + dp[i - 1][j - 1];
                        } else {
                            dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                        }
                    }
                }
                int LCS = dp[n][m];
                if (n > LCS) {
                    System.out.println("Case #"+(t+1)+": IMPOSSIBLE");
                } else {
                    System.out.println("Case #"+(t+1)+": "+(m - LCS));
                }
            }

        }
    }
}
