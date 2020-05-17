package Hot_100;

/**
 * @author : YCKJ2794
 * @since : 2020-05-17
 */
public class Exe96_Unique_Binary_Search_Trees {

    public int numTrees(int n) {
        int[] G = new int[n+1];
        G[0] = 1;

        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= i; j++){
                G[i] = G[i] + G[j-1] * G[i-j];
            }
        }

        return G[n];
    }

    public static void main(String[] args){

    }
}
