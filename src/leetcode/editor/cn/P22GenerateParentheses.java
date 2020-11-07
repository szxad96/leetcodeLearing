//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法 
// 👍 1304 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * Java：括号生成
 */
public class P22GenerateParentheses {
    public static void main(String[] args) {
        // TO TEST   
    }



    static class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            dfs("", n, n, res);
            return res;
        }

        private void dfs(String curStr, int left, int right, List<String> res) {
            if (right < left){
                return;
            }
            if (left == 0 && right == 0){
                res.add(curStr);
            }
            if (left > 0){
                dfs(curStr + "(",left - 1, right, res);
            }
            if (right > 0){
                dfs(curStr + ")", left, right - 1, res);
            }
        }
    }

    static class Solution2 {
        class Node {
            private String str;
            private int left;
            private int right;

            public Node(String str, int left, int right) {
                this.str = str;
                this.left = left;
                this.right = right;
            }
        }
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            if (n == 0){
                return res;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.offer(new Node("",n,n));

            while (!queue.isEmpty()){
                Node curNode = queue.poll();
                if (curNode.left == 0 && curNode.right == 0){
                    res.add(curNode.str);
                }
                if (curNode.left > 0){
                    queue.offer(new Node(curNode.str + "(",curNode.left - 1,curNode.right));
                }
                //这里必须是小于号
                if (curNode.right > 0 && curNode.left < curNode.right){
                    queue.offer(new Node(curNode.str + ")", curNode.left,curNode.right - 1));
                }
            }
            return res;
        }
    }


}