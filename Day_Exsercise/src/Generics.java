import java.util.ArrayList;
import java.util.List;

public class Generics {

    static class Parent {

    }

    static class Child extends Parent {

    }

    static class CustomList extends ArrayList<Parent> {

    }

    public static void main(String[] args) {
        List list = new ArrayList();
        List<String> listString = new ArrayList<String>();

        List listInteger = new ArrayList<Integer>();
        try {
            list.getClass().getMethod("add", Object.class).invoke(list, 1);
            listString.getClass().getMethod("add", Object.class).invoke(listString, 1);
            // 给不服气的读者们的测试之处，你可以改成字符串来尝试。
            listInteger.getClass().getMethod("add", Object.class).invoke(listInteger, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("list size:" + list.size());
        System.out.println("listString size:" + listString.size());
        System.out.println("listInteger size:" + listInteger.size());
        List customList = new CustomList();
        customList.add(1);
        try {
            customList.getClass().getMethod("add", Object.class).invoke(customList, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("customList size:" + customList.size());
    }

}
