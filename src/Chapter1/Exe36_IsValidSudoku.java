package Chapter1;

import java.util.HashSet;

/**
 * @author: yinwenjie
 * @email: 475660997@qq.com
 * @date: 2019/10/31
 * @description:
 * @result:
 */
public class Exe36_IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Integer>[] rows = new HashSet[9];
        HashSet<Integer>[] columns = new HashSet[9];
        HashSet<Integer>[] boxes = new HashSet[9];
        for (int i = 0; i < 9; i++){
            rows[i] = new HashSet<Integer>();
            columns[i] = new HashSet<Integer>();
            boxes[i] = new HashSet<Integer>();
        }

        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                char ch = board[i][j];
                int box_index = (i / 3) * 3 + j / 3;
                if (ch != '.'){
                    int num = (int)ch;
                    if ((!rows[i].contains(num)) && (!columns[j].contains(num)) && (!boxes[box_index].contains(num))){
                        rows[i].add(num);
                        columns[j].add(num);
                        boxes[box_index].add(num);
                    }else{
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args){

    }
}
