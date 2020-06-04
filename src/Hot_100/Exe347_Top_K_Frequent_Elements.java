package Hot_100;

import java.util.*;

/**
 * @author : YCKJ2794
 * @since : 2020-06-04
 */
public class Exe347_Top_K_Frequent_Elements {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Queue<Integer> heap = new PriorityQueue<>((n1, n2) -> map.get(n1) - map.get(n2));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            heap.offer(entry.getKey());
            if (heap.size() > k){
                heap.poll();
            }
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++){
            ans[i] = heap.poll();
        }
        return ans;
    }

}
