import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

//写一个程序，输出从 1 到 n 数字的字符串表示。
//
// 1. 如果 n 是3的倍数，输出“Fizz”；
//
// 2. 如果 n 是5的倍数，输出“Buzz”；
//
// 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
//
// 示例：
//
// n = 15,
//
//返回:
//[
//    "1",
//    "2",
//    "Fizz",
//    "4",
//    "Buzz",
//    "Fizz",
//    "7",
//    "8",
//    "Fizz",
//    "Buzz",
//    "11",
//    "Fizz",
//    "13",
//    "14",
//    "FizzBuzz"
//]
//
//
public class Day3_412_Fizz_Buzz {

    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String str = "";
            if (i % 3 == 0) {
                str += "Fizz";
            }
            if (i % 5 == 0) {
                str += "Buzz";
            }
            if (str.isEmpty()) {
                str = String.valueOf(i);
            }
            result.add(str);
        }
        return result;
    }

    public List<String> fizzBuzz2(int n) {
        return new AbstractList<String>() {
            @Override
            public String get(int index) {
                ++index;
                String str = "";
                switch ((n % 3 == 0 ? 1 : 0) + (n % 5 == 0 ? 2 : 0)) {
                    case 0:
                        str = String.valueOf(index);
                        break;
                    case 1:
                        str = "Fizz";
                        break;
                    case 2:
                        str = "Buzz";
                        break;
                    case 3:
                        str = "FizzBuzz";
                        break;
                }
                return str;
            }

            @Override
            public int size() {
                return n;
            }
        };
    }

}
