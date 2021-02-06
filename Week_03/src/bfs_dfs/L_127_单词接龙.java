package bfs_dfs;

import java.util.*;

//字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列：
//
//
// 序列中第一个单词是 beginWord 。
// 序列中最后一个单词是 endWord 。
// 每次转换只能改变一个字母。
// 转换过程中的中间单词必须是字典 wordList 中的单词。
//
//
// 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，找到从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0。
//
//
// 示例 1：
//
//
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
//输出：5
//解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
//
//
// 示例 2：
//
//
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
//输出：0
//解释：endWord "cog" 不在字典中，所以无法进行转换。
//
//
//
// 提示：
//
//
// 1 <= beginWord.length <= 10
// endWord.length == beginWord.length
// 1 <= wordList.length <= 5000
// wordList[i].length == beginWord.length
// beginWord、endWord 和 wordList[i] 由小写英文字母组成
// beginWord != endWord
// wordList 中的所有字符串 互不相同
//
// Related Topics 广度优先搜索
public class L_127_单词接龙 {

    /**
     * 思路：
     * 1.广度优先遍历
     * 1.5.wordList放入哈希表，否则会出错
     * 2.queue辅助广度优先遍历
     * 3.visited set 用来记录已经访问过的单词
     * 4.单词接龙即修改一个字符便相等，从'a'遍历到'z'
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        //用于广度优先遍历
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        //访问过的单词
        Set<String> visitsSet = new HashSet<>();
        visitsSet.add(beginWord);
        //广度优先遍历
        int step = 1;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                //当前层的单词出队，去做比较
                String currentWord = queue.poll();
                if (helper(currentWord, endWord, wordSet, queue, visitsSet)) {
                    return step + 1;
                }
            }
            step++;
        }
        return 0;
    }

    /**
     * 查找是否可以和endWord接龙，不可以则寻找能接龙的单词加入到
     *
     * @return true 匹配到
     */
    private boolean helper(String currentWord,
                           String endWord,
                           Set<String> wordList,
                           Queue<String> queue,
                           Set<String> visitsSet) {
        char[] wordArr = currentWord.toCharArray();
        for (int i = 0; i < wordArr.length; i++) {
            char originC = wordArr[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == originC) continue;
                wordArr[i] = c;
                String newStr = String.valueOf(wordArr);
                //如果匹配到没访问过的单词，将单词入队，并添加到已访问set
                if (wordList.contains(newStr)) {
                    //如果匹配到endWord直接返回
                    if (newStr.equals(endWord)) return true;
                    if (!visitsSet.contains(newStr)) {
                        queue.offer(newStr);
                        visitsSet.add(newStr);
                    }
                }
            }
            wordArr[i] = originC;
        }
        return false;
    }

}
