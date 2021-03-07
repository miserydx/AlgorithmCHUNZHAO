package proxy;

public class RealService implements Service{

    @Override
    public void jumpToPage() {
        System.out.println("RealService jumpToPage");
    }

    @Override
    public String getData(int key) {
        return "RealService" + key;
    }

    @Override
    public int getNum() {
        return 121220;
    }
}
