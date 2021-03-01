package base_sort;

public class HeapSort {

    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 1) return nums;
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            heapify(nums, nums.length, i);
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            int temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;
            heapify(nums, i,0);
        }
        return nums;
    }

    /**
     *
     * @param tree 数组（树）
     * @param length 作为方法参数很重要，在第一次堆化后，做遍历把堆顶下沉到队尾时，用来告诉heapify方法操作数组的长度，避免已经下沉到堆尾的元素参与操作
     * @param i 当前节点下标
     */
    private void heapify(int[] tree, int length, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int maxIndex = i;
        if (left < length && tree[left] > tree[maxIndex]) {
            maxIndex = left;
        }
        if (right < length && tree[right] > tree[maxIndex]) {
            maxIndex = right;
        }
        if (maxIndex != i) {
            int temp = tree[i];
            tree[i] = tree[maxIndex];
            tree[maxIndex] = temp;
            //这时maxIndex就是变换后的节点，需要堆化新的树结构（以maxIndex为顶）
            heapify(tree, length, maxIndex);
        }
    }

}
