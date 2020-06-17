/**
 * @author : YCKJ2794
 * @since : 2020-06-17
 */
public class QuickSort {

    private void quickSort(int[] array, int p, int q){
        if (p < q){
            int r = partition(array, p, q);
            quickSort(array, p, r - 1);
            quickSort(array, r + 1, q);
        }
    }

    private int partition(int[] array, int p, int q){
        int key = array[q];
        int j = p - 1;
        for (int i = p; i < q; i++){
            if (array[i] < key){
                j++;
                swap(array, i, j);
            }
        }
        swap(array, j+1, q);
        return j+1;
    }

    private void swap(int[] array, int p, int q){
        int tmp = array[p];
        array[p] = array[q];
        array[q] = tmp;
    }

    public static void main(String[] args){
        int[] a = {2,3,5,8,6,11,1,4};
        new QuickSort().quickSort(a, 0, a.length - 1);
        System.out.println(a);
    }
}
