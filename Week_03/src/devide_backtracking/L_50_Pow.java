package devide_backtracking;

//实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
//
//
//
// 示例 1：
//
//
//输入：x = 2.00000, n = 10
//输出：1024.00000
//
//
// 示例 2：
//
//
//输入：x = 2.10000, n = 3
//输出：9.26100
//
//
// 示例 3：
//
//
//输入：x = 2.00000, n = -2
//输出：0.25000
//解释：2-2 = 1/22 = 1/4 = 0.25
//
//
//
//
// 提示：
//
//
// -100.0 < x < 100.0
// -231 <= n <= 231-1
// -104 <= xn <= 104
//
// Related Topics 数学 二分查找
public class L_50_Pow {

    /**
     * 分治
     * 要点1: n/2 直到等于0，等于0时返回1
     * 2: n为奇数时返回 half * half * x
     */
    public double myPow(double x, int n) {
        int N = n;
        if (n < 0) {
            x = 1 / x;
            N = -n;
        }
        return fastPow(x, N);
    }

    private double fastPow(double x, int n) {
        if (n == 0) return 1;
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

}
