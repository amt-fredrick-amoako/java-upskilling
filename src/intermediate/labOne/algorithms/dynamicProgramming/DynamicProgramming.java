package intermediate.labOne.algorithms.dynamicProgramming;

public class DynamicProgramming {
    // Method to find the length and the LCS
    public static String lcs(String X, String Y) {
        int m = X.length();
        int n = Y.length();

        // Create the dp array to store lengths of longest common subsequence.
        int[][] dp = new int[m+1][n+1];

        // Fill the dp array
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X.charAt(i-1) == Y.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        // Constructing the LCS from dp array
        StringBuilder lcs = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (X.charAt(i-1) == Y.charAt(j-1)) {
                lcs.append(X.charAt(i-1));
                i--;
                j--;
            } else if (dp[i-1][j] > dp[i][j-1]) {
                i--;
            } else {
                j--;
            }
        }

        // Since we've built lcs from the end start to beginning, we need to reverse it before returning
        return lcs.reverse().toString();
    }

    public static void main(String[] args) {
        String X = "AGGTAB";
        String Y = "GXTXAYB";
        System.out.println("LCS of " + X + " and " + Y + " is " + lcs(X, Y));
    }
}
