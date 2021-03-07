package home_work;

public class L_541_反转字符串II {

    /**
     * 时间复杂度O（N）
     * 空间复杂度O（N）
     */
    public String reverseStr(String s, int k) {
        char[] array = s.toCharArray();
        for (int start = 0; start < array.length; start += 2 * k) {
            int i = start, j = Math.min(start + k - 1, array.length - 1);
            while (i < j) {
                char temp = array[i];
                array[i++] = array[j];
                array[j--] = temp;
            }
        }
        return new String(array);
    }

}
