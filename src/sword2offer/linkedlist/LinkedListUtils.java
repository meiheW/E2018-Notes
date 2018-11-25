package sword2offer.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class LinkedListUtils {

	//输入两个链表，找出它们的第一个公共结点
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		ListNode cur1 = pHead1;
		ListNode cur2 = pHead2;
		
		while(cur1!=cur2){
			cur1 = (cur1==null) ? pHead2 : cur1.next;
			cur2 = (cur2==null) ? pHead1 : cur2.next;
		}
		
		return cur1;
    }
	
	//输出链表环的入口节点
	public ListNode EntryNodeOfLoop(ListNode pHead)
    {
		if(pHead==null||pHead.next==null||pHead.next.next==null)
			return null;
		ListNode slow = pHead.next;
		ListNode fast = pHead.next.next;
		while(slow!=fast){
			if(fast.next==null||fast.next.next==null)
				return null;
			slow = slow.next;
			fast = fast.next.next;
		}
		fast = pHead;
		while(slow!=fast){
			slow = slow.next;
			fast = fast.next;
		}
		
		return fast;
    }
	
	//删除链表的重复节点
	public ListNode deleteDuplication(ListNode pHead)
    {
		ListNode node = pHead;
		Map<Integer, Integer> map = new HashMap<>();
		while(node!=null){
			int val = node.val;
			int count = map.get(val);
			if(count==0){
				map.put(val, 1);			
			}else{
				map.put(val, count+1);
			}
		}
		
		return null;
		
    }
	
}
