import java.util.Map;

import jdk.internal.vm.compiler.collections.Pair;

/*
 * @lc app=leetcode.cn id=165 lang=java
 *
 * [165] 比较版本号
 */

// @lc code=start
class Solution {
    public int compareVersion(String version1, String version2) {
        int n1 = version1.length();
        int n2 = version2.length();
        int p1 = 0, p2 = 0;
        int i1, i2;
        Pair<Integer, Integer> pair;
        while(p1 < n1 || p2 < n2) {//某一个version后续如果还有，就全都给0 because 1 = 1.0.0.0
            pair = getNextChunk(version1, n1, p1);
            p1 = pair.getKey();
            i1 = pair.getValue();
            pair = getNextChunk(version2, n2, p2);
            p2 = pair.getKey();
            i2 = pair.getValue();
            if(i1 != i2) {
                return i1 > i2 ? 1 : -1;
            }
        }
        return 0;
    }
    private Pair<Integer, Integer> getNextChunk(String version, int n, int p) {
        if(p > n - 1){
            return new Pair(p, 0);
        }//p已经挪到最后的结果
        int i, pEnd = p;
        while(pEnd < n && version.charAt(pEnd) != '.') {
            pEnd ++;
        }
        i = Integer.parseInt(version.substring(p, pEnd));
        return new Pair(pEnd + 1, i);
    } 
}
// @lc code=end

