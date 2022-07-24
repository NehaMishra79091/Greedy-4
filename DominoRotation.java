// Time Complexity :O(n)
// Space Complexity :constant
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int candidate = 0;
        // finding suitable candidate for maximum
        for (int i = 0; i < n; i++) {
            int top = tops[i];
            map.put(top, map.getOrDefault(top, 0) + 1);
            int topCount = map.get(top);
            if (max < topCount) {
                max = topCount;
                candidate = top;
            }
            int bottom = bottoms[i];
            map.put(bottom, map.getOrDefault(bottom, 0) + 1);
            int bottomCount = map.get(bottom);
            if (max < bottomCount) {
                max = bottomCount;
                candidate = bottom;
            }

        }
        int topRes = 0;
        int bottomRes = 0;
        // traversing on both arrays
        for (int i = 0; i < n; i++) {
            // if both dont contain candidate at i index,we cannot form result
            if (tops[i] != candidate && bottoms[i] != candidate) {
                return -1;
            }
            // if top does not contain that means we need to rotate it hence add in topRes
            if (tops[i] != candidate) {
                topRes++;
            }
            // if bottom does not contain that means we need to rotate it hence add in
            // bootomRes
            if (bottoms[i] != candidate) {
                bottomRes++;
            }
        }
        // return minimum of both
        return Math.min(topRes, bottomRes);
    }
}

// ----------------WITHOUT USING HASHMAP----------------------
// Time Complexity :O(n)
// Space Complexity :constant
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        // suitable candidate is either tops[0] or bottoms[0], if both are not then we
        // cannot make array of same elements ever
        int result = findRotation(tops[0], tops, bottoms);
        if (result != -1)
            return result;
        return findRotation(bottoms[0], tops, bottoms);

    }

    public int findRotation(int candidate, int[] tops, int[] bottoms) {
        int n = tops.length;
        int topRes = 0;
        int bottomRes = 0;
        // finding min no of rotations
        for (int i = 0; i < n; i++) {
            if (tops[i] != candidate && bottoms[i] != candidate) {
                return -1;
            }
            if (tops[i] != candidate) {
                topRes++;
            }
            if (bottoms[i] != candidate) {
                bottomRes++;
            }
        }
        return Math.min(topRes, bottomRes);
    }
}