package Chapter1;

/**
 * @author: yinwenjie
 * @email: 475660997@qq.com
 * @date: 2019/10/17
 * @description:
 * @result:
 */
public class Exe11_MaxArea {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int max = 0, area = 0;
        while (i < j){
            area = (j - i) * Math.min(height[i], height[j]);
            max = max > area ? max : area;
            if (height[i] < height[j])
                i++;
            else if (height[i] >= height[j])
                j--;
        }
        return max;
    }

    public static void main(String[] args){
         int[] height = {1,18,6,20,5,4,19,3,7};
         System.out.println(new Exe11_MaxArea().maxArea(height));
    }
}
