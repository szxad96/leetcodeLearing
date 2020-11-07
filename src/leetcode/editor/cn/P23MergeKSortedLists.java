//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
// Related Topics 堆 链表 分治算法 
// 👍 909 👎 0

package leetcode.editor.cn;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

//Java：合并K个升序链表
public class P23MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new P23MergeKSortedLists().new Solution();

    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }
            PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
                @Override
                public int compare(ListNode o1, ListNode o2) {
                    return o1.val - o2.val;
                }
            });
            for (ListNode list : lists) {
                while (list != null) {
                    queue.add(list);
                    list = list.next;
                }
            }
            ListNode dummy = new ListNode(-1);
            ListNode head = dummy;
            while (!queue.isEmpty()) {
                dummy.next = queue.poll();
                dummy = dummy.next;
            }
            dummy.next = null;
            return head.next;
        }
    }
    class Solution2 {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }
            ListNode res = lists[0];
            for (int i = 1; i< lists.length; i++){
                res = merge(res,lists[i]);
            }
            return res;
        }

        private ListNode merge(ListNode a, ListNode b) {
            if (a == null || b == null){
                a = a == null ? b: a;
                return a;

            }
            if (a.val <= b.val){
                a.next = merge(a.next,b);
                return a;
            } else {
                b.next = merge(a,b.next);
                return b;
            }
        }
    }
    class Solution3 {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }
            return helper(lists, 0, lists.length - 1);

        }

        private ListNode helper(ListNode[] lists, int begin, int end) {
            if (begin == end){
                return lists[begin];
            }
            int mid = begin  + (end - begin) / 2;
            ListNode left = helper(lists, begin, mid);
            ListNode right = helper(lists,mid + 1, end);
            //当都分为一个节点时，begin == end，return开始合并，两两合并为一个最终的结果
            return merge(left, right);
        }

        private ListNode merge(ListNode a, ListNode b) {
            if (a == null || b == null){
                a = a == null ? b: a;
                return a;
            }
            if (a.val <= b.val){
                a.next = merge(a.next,b);
                return a;
            } else {
                b.next = merge(a,b.next);
                return b;
            }
        }
    }
}