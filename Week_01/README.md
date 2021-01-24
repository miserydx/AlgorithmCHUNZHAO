# 学习笔记

## 简单题目
* [删除排序数组中的重复项（Facebook、字节跳动、微软在半年内面试中考过）](src/homework/L_26_Remove_Duplicates_From_Sort_Array.java)
* [旋转数组（微软、亚马逊、PayPal 在半年内面试中考过）TODO]()
* [合并两个有序链表（亚马逊、字节跳动在半年内面试常考）TODO]()
* [合并两个有序数组（Facebook 在半年内面试常考）TODO]()
* [两数之和（亚马逊、字节跳动、谷歌、Facebook、苹果、微软在半年内面试中高频常考）](src/homework/L_1_Two_Sum.java)
* [移动零（Facebook、亚马逊、苹果在半年内面试中考过）](src/homework/L_283_Move_Zeros.java)
* [加一（谷歌、字节跳动、Facebook 在半年内面试中考过）](src/homework/L_66_Plus_One.java)
* [有效的字母异位词（亚马逊、Facebook、谷歌在半年内面试中考过）TODO]()

## 中等题目
* [设计循环双端队列（Facebook 在 1 年内面试中考过）TODO]()
* [字母异位词分组（亚马逊在半年内面试中常考）TODO]()

## 困难题目
* [接雨水（亚马逊、字节跳动、高盛集团、Facebook 在半年内面试常考）](src/homework/L_42_Trapping_Rain_Water.java)

## 学习总结主题

### 一、用 add first 或 add last 这套新的 API 改写 Deque 的代码。
```java
        Deque<String> deque = new LinkedList<>();
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        System.out.println(deque);

        String str = deque.peekFirst();
        System.out.println(str);
        System.out.println(deque);

        while (deque.size() > 0) {
            System.out.println(deque.pollFirst());
        }
        System.out.println(deque);
```

### 二、分析 Queue 和 Priority Queue 的源码。

#### 实现
优先队列在java中的实现是一个用数组描述的堆（完全二叉树），用数组描述的堆不会浪费多余的空间
##### 关于用数组描述的堆：
* 每个结点的左孩子为下标i的2倍：```left child(i) = i * 2```
* 每个结点的右孩子为下标i的2倍加1：```right child(i) = i * 2 + 1```
* 每个结点的父亲结点为下标的二分之一：```parent(i) = i / 2```，注意这里是整数除，2和3除以2都为1

#### 构造方法
```java
    public PriorityQueue(int initialCapacity,
                         Comparator<? super E> comparator) {
        if (initialCapacity < 1)
            throw new IllegalArgumentException();
        //初始容量
        this.queue = new Object[initialCapacity];
        //比较器，用来定义结构中元素的优先级
        this.comparator = comparator;
    }
```
#### 元素的添加
```java
    public boolean add(E e) {
        return offer(e);
    }
    
    public boolean offer(E e) {
        if (e == null)
            throw new NullPointerException();
        modCount++;
        int i = size;
        //容量不够需要扩容
        if (i >= queue.length)
            grow(i + 1);
        //更新当前记录的元素数量size
        size = i + 1;
        if (i == 0)
        	//第一个元素直接添加
            queue[0] = e;
        else
        	//添加元素时，执行上移操作
            siftUp(i, e);
        return true;
    }
    
    private void siftUp(int k, E x) {
        if (comparator != null)
        	//传入比较器则使用
            siftUpUsingComparator(k, x);
        else
        	//没传入比较器则使用元素实现的Comparable接口
            siftUpComparable(k, x);
    }
    
    private void siftUpUsingComparator(int k, E x) {
        while (k > 0) {
        	//父节点下标
            int parent = (k - 1) >>> 1;
            //交换上浮
            Object e = queue[parent];
            if (comparator.compare(x, (E) e) >= 0)
                break;
            queue[k] = e;
            k = parent;
        }
        queue[k] = x;
    }  
```
#### 元素的弹出
```java
    public E poll() {
        if (size == 0)
            return null;
        int s = --size;
        modCount++;
        //取出优先级最高的元素
        E result = (E) queue[0];
        //尾部元素置空
        E x = (E) queue[s];
        queue[s] = null;
        if (s != 0)
        	//下沉操作
            siftDown(0, x);
        return result;
    }
    
    private void siftDown(int k, E x) {
    	//比较器的判断，同上移
        if (comparator != null)
            siftDownUsingComparator(k, x);
        else
            siftDownComparable(k, x);
    }
    
    private void siftDownUsingComparator(int k, E x) {
        int half = size >>> 1;
        while (k < half) {
        	//左孩子下标
            int child = (k << 1) + 1;
            Object c = queue[child];
            //右孩子下标
            int right = child + 1;
            if (right < size &&
                comparator.compare((E) c, (E) queue[right]) > 0)
                //取优先级较高的孩子
                c = queue[child = right];
            if (comparator.compare(x, (E) c) <= 0)
            	//如果发现已经父节点小于两个孩子，跳出循环
                break;
            //交换
            queue[k] = c;
            k = child;
        }
        queue[k] = x;
    }
```
#### 优先队列源码分析体会
由于缺乏对树和堆结构的认知和使用，第一遍看源码时对上移和下沉操作非常困惑，于是搜了一下网上的文章，对数组描述的堆有了认识，再看源码才能读通。希望接下几周能继续补充自己对数据结构的知识盲点。
>参考[https://blog.csdn.net/weixin_37373020/article/details/93577529](https://blog.csdn.net/weixin_37373020/article/details/93577529)