package utils;

public class ListNode {

    public int val;

    public ListNode next;

    public ListNode(){

    }

    public ListNode(int val) {
        this.val = val;
    }

    public String toString(boolean isHead) {
        if (next != null) {
            return isHead ? "[" + val + "," + next.toString(false)
                    : val + "," + next.toString(false);
        } else {
            return val + "]";
        }
    }
}
