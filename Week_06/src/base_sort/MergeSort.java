package base_sort;

public class MergeSort {

    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) >> 1;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int p = 0;
        int[] helper = new int[right - left + 1];
        while (i <= mid && j <= right) {
            helper[p++] = nums[i] < nums[j] ? nums[i++] : nums[j++];
        }
        while (i <= mid) {
            helper[p++] = nums[i++];
        }
        while (j <= right) {
            helper[p++] = nums[j++];
        }
        for (int k = 0; k < helper.length; k++) {
            nums[left++] = helper[k];
        }
    }

}
