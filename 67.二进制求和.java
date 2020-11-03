import java.util.BitSet;

/*
 * @lc app=leetcode.cn id=67 lang=java
 *
 * [67] 二进制求和
 */

// @lc code=start
class Solution {
    public String addBinary(String a, String b) {
        //bitSet容器二进制运算+lambda用法
        BitSet bitsetA = new BitSet(a.length());
        for (int i = 0; i < a.length(); i++) {
            bitsetA.set(i, a.charAt(a.length() - i - 1) == '1');
        }

        BitSet bitsetB = new BitSet(b.length());
        for (int i = 0; i < b.length(); i++) {
            bitsetB.set(i, b.charAt(b.length() - i - 1) == '1');
        }
        while(!bitsetA.isEmpty()){
            BitSet tempB = BitSet.valueOf(bitsetB.toLongArray());
            bitsetB.xor(bitsetA);
            bitsetA.and(tempB);

            BitSet newA = new BitSet(bitsetA.length()+1);
            bitsetA.stream().forEach(i -> newA.set(i+1, true));
            bitsetA = newA;
        }
        StringBuilder ret = new StringBuilder();
        IntStream.range(0, bitsetB.length())
            .mapToObj(i -> bitsetB.get(i) ? '1' : '0')
            .forEach(ret::append);

        return ret.length() == 0 ? "0" : ret.reverse().toString();
    }
}
// @lc code=end

