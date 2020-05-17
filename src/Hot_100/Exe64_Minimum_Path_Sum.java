package Hot_100;

/**
 * @author : YCKJ2794
 * @since : 2020-05-16
 */
public class Exe64_Minimum_Path_Sum {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] path = new int[m][n];
        for (int i = m-1; i >= 0; i--){
            for (int j = n-1; j >= 0; j--){
                if ((i == m-1) && (j == n-1)){
                    path[i][j] = grid[m-1][n-1];
                }else if (i + 1 >= m){
                    path[i][j] = path[i][j+1] + grid[i][j];
                }else if (j + 1 >= n){
                    path[i][j] = path[i+1][j] + grid[i][j];
                }else {
                    path[i][j] = Math.min(path[i][j+1], path[i+1][j]) + grid[i][j];
                }
            }
        }
        return path[0][0];
    }

    public static void main(String[] args){
//        int[][] matrix = {{1,3,1},{1,5,1},{4,2,1}};
        int[][] matrix = {{1,2,5},{3,2,1}};
        new Exe64_Minimum_Path_Sum().minPathSum(matrix);
    }

}
