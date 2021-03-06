package homework;

import java.util.*;

//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
//
// 示例:
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//]
//
// 说明：
//
//
// 所有输入均为小写字母。
// 不考虑答案输出的顺序。
//
// Related Topics 哈希表 字符串
public class L_49_Group_Anagrams {

    /**
     * 哈希表记录<key:排序后值, value:字符串数组>
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] charArr = s.toCharArray();
            Arrays.sort(charArr);
            String sortString = Arrays.toString(charArr);
            if (!map.containsKey(sortString)) {
                map.put(sortString, new ArrayList<>());
            }
            map.get(sortString).add(s);
        }
        return new ArrayList<>(map.values());
    }

}
