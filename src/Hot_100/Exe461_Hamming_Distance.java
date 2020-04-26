package Hot_100;

/**
 * @author : YCKJ2794
 * @since : 2020-04-26
 */
public class Exe461_Hamming_Distance {

    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public static void main(String[] args){
        int result = new Exe461_Hamming_Distance().hammingDistance(1, 4);
        System.out.println(result);
    }
}
