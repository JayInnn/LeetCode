package Hot_100;

/**
 * @author : YCKJ2794
 * @since : 2020-05-16
 */
public class Exe48_Rotate_Image {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] tmp = new int[n][n];
        for (int i = 0; i < n; i++){
            System.arraycopy(matrix[i], 0, tmp[i], 0, n);
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                matrix[j][n - i - 1] = tmp[i][j];
            }
        }
    }

    public static void main(String[] args){
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        new Exe48_Rotate_Image().rotate(matrix);
    }
}
