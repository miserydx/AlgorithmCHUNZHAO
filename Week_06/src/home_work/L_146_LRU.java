package home_work;

public class L_146_LRU {

    public static class LRUCache {

        private HashMap<Integer, Node> map;

        private int capacity;

        private Node head, tail;

        private int size = 0;

        public LRUCache(int capacity) {
            map = new HashMap<>();
            this.capacity = capacity;
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            Node node = map.get(key);
            if (node == null) {
                return -1;
            }
            moveToHead(node);
            return node.val;
        }

        public void put(int key, int value) {
            Node node = map.get(key);
            if (node == null) {//当前没有
                //创建
                node = new Node(key, value);
                //添加至队头和hashmap
                map.put(key, node);
                addToHead(node);
                size++;
                //检查容量，超过最大值删除队尾
                if (size > capacity) {
                    map.remove(tail.prev.key);
                    deleteNode(tail.prev);
                    size--;
                }
            } else {//当前有
                //修改值，移动到队头
                node.val = value;
                moveToHead(node);
            }
        }

        private void moveToHead(Node node) {
            //断开连接
            deleteNode(node);
            //插队到头
            addToHead(node);
        }

        private void deleteNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void addToHead(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        class Node {
            private Node prev, next;
            private int key;
            private int val;

            public Node() {
            }

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }
    }

}
