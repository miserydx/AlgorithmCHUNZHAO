package homework;

import java.util.PriorityQueue;
import java.util.Queue;

//我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
//
//
//
// 示例:
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
//
// 说明:
//
//
// 1 是丑数。
// n 不超过1690。
//
//
// 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/
// Related Topics 数学
public class L_剑指Offer_丑数 {

    /**
     * 小根堆
     */
    public int nthUglyNumber(int n) {
        int[] uglyNumber = {2, 3, 5};
        //小根堆
        Queue<Long> heap = new PriorityQueue<>();
        heap.offer(1L);
        int count = 0;
        while (true) {
            long min = heap.poll();
            if (++count >= n) {
                return (int) min;
            }
            for (int num : uglyNumber) {
                if (!heap.contains(min * num)) {
                    heap.offer(min * num);
                }
            }
        }
    }

}
