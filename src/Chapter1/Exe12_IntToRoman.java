package Chapter1;

/**
 * @author: yinwenjie
 * @email: 475660997@qq.com
 * @date: 2019/10/18
 * @description:
 * @result:
 */
public class Exe12_IntToRoman {
    public String intToRoman(int num) {
        int[] values={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romans={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 13; i++){
            while (num >= values[i]){
                num = num - values[i];
                result.append(romans[i]);
            }
        }
        return result.toString();
    }
}
