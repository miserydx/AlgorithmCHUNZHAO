# 学习笔记

## 广度优先遍历模板
```java
    public List<List<Integer>> bsf(TreeNode root) {
        if (root == null) {
            return null;
        }

        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if (curNode == null) {
                    continue;
                }
                level.add(curNode.val);
                queue.add(curNode.left);
                queue.add(curNode.right);
            }

            if (!level.isEmpty()) {
                result.add(level);
            }

        }
        return result;
    }

```

## 二分查找模板
```java
    public int binarySearch(int[] array, int target) {
        int left = 0, right = array.length - 1, mid;
        while (left <= right) {
            mid = (right - left) / 2 + left;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
```

## 简单题目
* [多数元素 （亚马逊、字节跳动、Facebook 在半年内面试中考过）](src/devide_backtracking/L_169_多数元素.java)
* [柠檬水找零（亚马逊在半年内面试中考过）](src/greedy/L_860_柠檬水找零.java)
* [买卖股票的最佳时机 II （亚马逊、字节跳动、微软在半年内面试中考过）TODO]()
* [分发饼干（亚马逊在半年内面试中考过））TODO]()
* [模拟行走机器人TODO]()

## 中等题目
* [Pow(x, n) （Facebook 在半年内面试常考）](src/devide_backtracking/L_50_Pow.java)
* [子集（Facebook、字节跳动、亚马逊在半年内面试中考过）](src/devide_backtracking/L_78_子集.java)
* [电话号码的字母组合（亚马逊在半年内面试常考）](src/devide_backtracking/L_17_电话号码的数字组合.java)
* [单词接龙（亚马逊在半年内面试常考）](src/bfs_dfs/L_127_单词接龙.java)
* [岛屿数量（近半年内，亚马逊在面试中考查此题达到 350 次）](src/bfs_dfs/L_200_岛屿数量.java)
* [扫雷游戏（亚马逊、Facebook 在半年内面试中考过）](src/bfs_dfs/L_529_扫雷.java)
* [跳跃游戏 （亚马逊、华为、Facebook 在半年内面试中考过）TODO]()
* [搜索旋转排序数组（Facebook、字节跳动、亚马逊在半年内面试常考）TODO]()
* [搜索二维矩阵（亚马逊、微软、Facebook 在半年内面试中考过）](src/binary_search/L_74_搜索二维矩阵.java)
* [寻找旋转排序数组中的最小值（亚马逊、微软、字节跳动在半年内面试中考过）TODO]()

## 困难题目
* [N 皇后（字节跳动、苹果、谷歌在半年内面试中考过）](src/devide_backtracking/L_51_N皇后.java)
* [单词接龙 II （微软、亚马逊、Facebook 在半年内面试中考过）TODO]()
* [跳跃游戏 II （亚马逊、华为、字节跳动在半年内面试中考过）TODO]()