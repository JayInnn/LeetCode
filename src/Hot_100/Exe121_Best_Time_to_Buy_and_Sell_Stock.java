package Hot_100;

/**
 * @author : YCKJ2794
 * @since : 2020-05-06
 */
public class Exe121_Best_Time_to_Buy_and_Sell_Stock {

    public int maxProfit(int[] prices) {
        if(prices.length <= 1){
            return 0;
        }
        int min = prices[0], max = 0;
        for(int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }

    public static void main(String[] args){
        int[] a = {7,1,5,3,6,4};
        System.out.println(new Exe121_Best_Time_to_Buy_and_Sell_Stock().maxProfit(a));
    }
}
