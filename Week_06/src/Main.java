import home_work.L_146_LRU;

public class Main {

    public static void main(String[] args) {
        L_146_LRU.LRUCache lru = new L_146_LRU.LRUCache(2);
        lru.put(1,1);
        lru.put(2,2);
        int g1 = lru.get(1);
        lru.put(3,3);
        int g2 = lru.get(2);
        lru.put(4,4);
        int g3 = lru.get(1);
        int g4 = lru.get(3);
        int g5 = lru.get(4);
        System.out.println("g1 = "+g1);
        System.out.println("g2 = "+g2);
        System.out.println("g3 = "+g3);
        System.out.println("g4 = "+g4);
        System.out.println("g5 = "+g5);
    }

}
