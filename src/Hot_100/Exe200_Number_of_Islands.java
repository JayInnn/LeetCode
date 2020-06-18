package Hot_100;

/**
 * @author: yinwenjie
 * @email: 475660997@qq.com
 * @date: 2020/6/18
 * @description:
 * @result:
 */
public class Exe200_Number_of_Islands {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int row = grid.length;
        int column = grid[0].length;
        int ans = 0;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < column; j++){
                if (grid[i][j] == '1'){
                    ans++;
                    dfsCheck(grid, i, j);
                }
            }
        }
        return ans;
    }

    private void dfsCheck(char[][] grid, int i, int j){
        int row = grid.length;
        int column = grid[0].length;
        if (i < 0 || i >= row || j < 0 || j >= column || grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        dfsCheck(grid, i - 1, j);
        dfsCheck(grid, i + 1, j);
        dfsCheck(grid, i, j - 1);
        dfsCheck(grid, i, j + 1);
    }

}
