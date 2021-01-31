import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day2_989_add_to_array_form_of_integer {

    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> result = new ArrayList<>();
        for (int i = A.length - 1; i >= 0; i--) {
            int addNum = K % 10;
            int curNum = A[i] + addNum;
            K /= 10;
            if (curNum >= 10) {
                curNum -= 10;
                K++;
            }
            result.add(curNum);
        }
        while (K > 0) {
            result.add(K % 10);
            K /= 10;
        }
        Collections.reverse(result);
        return result;
    }

}
