/*
 * @lc app=leetcode.cn id=605 lang=java
 *
 * [605] 种花问题
 */

// @lc code=start
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(flowerbed.length == 1) {
            if(flowerbed[0] == 0){
                return 1 >= n;
            }else {
                return 0 >= n;
            }
        }
        int left = 0;
        int right = 0;
        for(int i = 0; i < flowerbed.length; i ++){
            if(flowerbed[i] == 0){
            if(i == 0){
                if(flowerbed[i + 1] == 0){
                    flowerbed[i] = 1;
                    left ++;
                }
            }else if(i == flowerbed.length - 1){
                if(flowerbed[i - 1] == 0){
                    flowerbed[i] = 1;
                    left ++;
                }
            }else{
                if(flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0){
                    flowerbed[i] = 1;
                    left ++;
                }
            }
        }
        }
        for(int i = flowerbed.length - 1; i >= 0 ; i --){
            if(flowerbed[i] == 0){
                if(i == 0){
                    if(flowerbed[i + 1] == 0){
                        flowerbed[i] = 1;
                        right ++;
                    }
                }else if(i == flowerbed.length - 1){
                    if(flowerbed[i - 1] == 0){
                        flowerbed[i] = 1;
                        right ++;
                    }
                }else{
                    if(flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0){
                        flowerbed[i] = 1;
                        right ++;
                    }
                }
            }
        
        }
        return left >= n || right >= n;
    }
}
// @lc code=end

