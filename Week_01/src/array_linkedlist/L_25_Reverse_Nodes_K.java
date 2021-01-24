package array_linkedlist;

import utils.ListNode;

//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
//
// k 是一个正整数，它的值小于或等于链表的长度。
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
//
//
//
// 示例：
//
// 给你这个链表：1->2->3->4->5
//
// 当 k = 2 时，应当返回: 2->1->4->3->5
//
// 当 k = 3 时，应当返回: 3->2->1->4->5
//
//
//
// 说明：
//
//
// 你的算法只能使用常数的额外空间。
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
//
// Related Topics 链表
public class L_25_Reverse_Nodes_K {

    /**
     * @param head 链表中一段的头节点
     * @param k    k个成一段
     * @return 反转后的头节点
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode end = head;
        //检查当前这段够不够k个数字，不够的话直接返回原头节点
        for (int i = 0; i < k; i++) {
            if (end == null) return head;
            end = end.next;
        }
        ListNode newHead = reverse(head, end);
        //反转过后的head已经成为这一段的尾节点，将下一段的头节点连接当前这段的尾节点
        head.next = reverseKGroup(end, k);
        return newHead;
    }

    /**
     * 反转一段链表
     *
     * @param head 当前这段的头节点
     * @param tail 下一段的头结点
     * @return 反转后的头节点
     */
    private ListNode reverse(ListNode head, ListNode tail) {
        ListNode prev = null;
        while (head != tail) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }

}
