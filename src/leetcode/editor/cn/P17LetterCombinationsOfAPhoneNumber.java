//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法 
// 👍 916 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：电话号码的字母组合
public class P17LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new P17LetterCombinationsOfAPhoneNumber().new Solution();
        // TO TEST

    }

    //leetcode submit region begin(Prohibit modification and deletion)
//       class Solution {
//           //一个映射表，第二个位置是"abc“,第三个位置是"def"。。。
//           //这里也可以用map，用数组可以更节省点内存
//           String[] letter_map = {" ","*","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
//           public List<String> letterCombinations(String digits) {
//               //注意边界条件
//               if(digits==null || digits.length()==0) {
//                   return new ArrayList<>();
//               }
//               iterStr(digits, new StringBuilder(), 0);
//               return res;
//           }
//           //最终输出结果的list
//           List<String> res = new ArrayList<>();
//
//           //递归函数
//           void iterStr(String str, StringBuilder letter, int index) {
//               //递归的终止条件，当index等于字符串的长度，就说明已经到了叶子节点的下一个节点，
//               // 因为字符串charAt是从0开始的，“2345”当index为4的时候，charAt（4）将取不到值
//               if(index == str.length()) {
//                   res.add(letter.toString());
//                   return;
//               }
//               //获取index位置的字符，假设输入的字符是"234"
//               //第一次递归时index为0所以c=2，第二次index为1所以c=3，第三次c=4
//               //subString每次都会生成新的字符串，而index则是取当前的一个字符，所以效率更高一点
//               char c = str.charAt(index);
//               //map_string的下表是从0开始一直到9， c-'0'就可以取到相对的数组下标位置
//               //比如c=2时候，2-'0'，获取下标为2,letter_map[2]就是"abc"
//               int pos = c - '0';
//               String map_string = letter_map[pos];
//               //遍历字符串，比如第一次得到的是2，页就是遍历"abc"
//               for(int i=0;i<map_string.length();i++) {
//                   //调用下一层递归，用文字很难描述，请配合动态图理解
//                   letter.append(map_string.charAt(i));
//                   //如果是String类型做拼接效率会比较低
//                   //iterStr(str, letter+map_string.charAt(i), index+1);
//                   iterStr(str, letter, index+1);
//                   letter.deleteCharAt(letter.length()-1);
//               }
//           }
//       }
    class Solution {
        String[] letterMap = {" ", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();
        public List<String> letterCombinations(String digits) {
            //首先对输入的digits进行判断
            if (digits == null || digits.length() == 0){
                return new ArrayList<>();
            }
            iterStr(digits, new StringBuilder(), 0);
            return res;


        }

        private void iterStr(String str, StringBuilder letter, int index) {
            //递归的终止条件，当index等于字符串的长度，就说明已经到了叶子节点的下一个节点，
            // 因为字符串charAt是从0开始的，“2345”当index为4的时候，charAt（4）将取不到值
            if (str.length() == index){
                res.add(letter.toString());
                return;
            }
            //首先传进来str为2345，letter 为空，index 为 0 ，首先要获得2对应的字母
            char c = str.charAt(index);
            //如果传进来的是2，那么‘2’ - ‘0’ = 2
             int pos = c - '0';
            String mapString = letterMap[pos];
            //mapString为abc,首先letter取到a，
            for (int i = 0; i < mapString.length(); i++){
                letter.append(mapString.charAt(i));
                //进入下一次递归，获得mapString为def，index加1是为了在下一层取到第二个数字，3
                iterStr(str, letter, index + 1);
                //当递归返回时，必定是到达叶节点后，为了到达下一个叶节点，需要先删除，例如 adgj，下一个取到的元素即删除j，取k，即为adgk
                letter.deleteCharAt(letter.length() - 1);
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}