# 学习笔记

## [选择排序](src/base_sort/SelectionSort.java)

* 遍历数组，每次找最小值放到起始位置

## [插入排序](src/base_sort/InsertSort.java)

* 对于已经排好序的数组，把新来的数从排好序数组的末尾依次比较交换，结果等于插入到排序树组中

## [冒泡排序](src/base_sort/BubbleSort.java)

* 嵌套，两两比较，逆序则交换

## [快速排序](src/base_sort/QuickSort.java)

* 分治，将当前数组左右分，参照点左右递归，关键在于以某一段最后一个数作为基准点，然后将这段塑造成被基准点分割的状态
* 时间复杂度：
    1. 这里先说明logn的时间复杂度是以多少为底，二分法就是以2为底，三分以3以此类推
    2. 最优情况下，partition分的很均匀，排序n个数字，递归树深度就为log2n+1，即需要递归log2n次。
    3. 接上，partition第一次要做n次比较，然后二分每边都做n/2次，所以可得时间复杂度等于log2n * n 即O(nlogn)
    4. 最坏情况下O(n2)，比如是逆序的队列，pivot每次都在最右边，相当于嵌套循环

## [归并排序](src/base_sort/MergeSort.java)

* 二分，递归，最后合并两边的排序数组

## [堆排序](src/base_sort/HeapSort.java)

[不错的讲解视频](https://www.bilibili.com/video/BV1Eb41147dK?from=search&seid=12997296966848263367)

* 堆的定义：完全二叉树，并且parent > child
* 把数组看成一个待排序的堆
* parent = (i - 1) / 2
* left_child = 2i + 1 right_child = 2i + 2

步骤：

0. 堆化方法
1. 从最后一个有子节点的下标开始往前遍历，堆化（length / 2 - 1）
2. 然后从后往前遍历堆，交换当前节点和头节点（堆中的最大数），然后堆化剩下的未排序的树
3. 注意堆化方法需要接受长度，以免破坏已经排序的尾部