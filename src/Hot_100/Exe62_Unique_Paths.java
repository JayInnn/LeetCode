package Hot_100;

/**
 * @author : YCKJ2794
 * @since : 2020-06-08
 */
public class Exe62_Unique_Paths {

    public int uniquePaths(int m, int n) {
        if (m == 1 && n == 1){
            return 1;
        }
        int[][] path = new int[n][m];
        path[n-1][m-1] = 1;

        for (int i = n-1; i >= 0; i--){
            for (int j = m-1; j >= 0; j--){
                if (i == n-1 && j == m-1){
                    continue;
                }
                if (i + 1 >= n){
                    path[i][j] = path[i][j+1];
                }else if (j + 1 >= m){
                    path[i][j] = path[i+1][j];
                }else {
                    path[i][j] = path[i+1][j] + path[i][j+1];
                }
            }
        }
        return path[0][0];
    }

}
