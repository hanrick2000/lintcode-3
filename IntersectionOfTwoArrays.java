public class IntersectionOfTwoArrays {
    /**
     * Time: O(N)
     * Space: O(N)
     *
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        
        Set<Integer> set1 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        
        Set<Integer> set2 = new HashSet<>();
        for (int i : nums2) {
            set2.add(i);
        }
        
        set1.retainAll(set2);
        
        int[] result = new int[set1.size()];
        int i = 0;
        for (Integer num : set1) {
            result[i++] = num;
        }
        return result;
    }
}
