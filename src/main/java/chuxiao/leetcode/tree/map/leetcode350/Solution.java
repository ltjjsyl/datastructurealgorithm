package chuxiao.leetcode.tree.map.leetcode350;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map = new TreeMap<>();//HashMap 也可以或者说更好
        for (int num : nums1) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if(map.containsKey(num)){
                list.add(num);
                map.put(num, map.get(num) - 1);
                if (map.get(num) == 0) {
                    map.remove(num);
                }
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
