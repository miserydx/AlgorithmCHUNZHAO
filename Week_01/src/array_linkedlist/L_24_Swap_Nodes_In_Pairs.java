package array_linkedlist;

import utils.ListNode;

//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
//
//
// 示例 2：
//
//
//输入：head = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：head = [1]
//输出：[1]
//
//
//
//
// 提示：
//
//
// 链表中节点的数目在范围 [0, 100] 内
// 0 <= Node.val <= 100
//
//
//
//
// 进阶：你能在不修改链表节点值的情况下解决这个问题吗?（也就是说，仅修改节点本身。）
// Related Topics 递归 链表
public class L_24_Swap_Nodes_In_Pairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode cur = head;
        ListNode result = head.next;
        while (cur != null && cur.next != null) {
            ListNode temp = cur;
            if (prev != null) {
                prev.next = cur.next;
            }
            prev = cur.next;
            cur = cur.next.next;
            temp.next = cur;
            prev.next = temp;
            prev = temp;
        }
        return result;
    }

}
