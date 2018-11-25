package codingguide.linkedList;

import java.util.*;

public class LinkedUtils {
	
	//2.1打印两个有序链表的公共部分
	public static void printCommonPart(Node head1, Node head2)
	{
		while(head1!=null && head2!=null)
		{
			if(head1.value < head2.value)
				head1 = head1.next;
			else if(head1.value > head2.value)
				head2 = head2.next;
			else{
				System.out.println(head1.value);
				head1 = head1.next;
				head2 = head2.next;
			}
		}
	}
	
	//2.2.1单链表中删除倒数第K个节点
	public static Node removeLastKthNode(Node head, int lastKth)
	{
		if(head == null || lastKth <1)
			return head;
		Node cur = head;
		while(cur!=null)//3,2,1,0,-1,-2,-3
		{
			lastKth--;
			cur = cur.next;
		}
		
		if(lastKth == 0)
			head = head.next;
		if(lastKth <0)
		{
			cur = head;
			while(++lastKth != 0)//-2,-1,0,0所指后面一个即要删除的节点
				cur = cur.next;
			cur.next = cur.next.next;
		}
		
		return head;
	}
	
	//2.2.2双链表中删除倒数第K个节点
	public static DoubleNode removeLastKthNode(DoubleNode head, int lastKth)
	{
		if(head == null || lastKth < 1)
			return head;
		
		DoubleNode cur = head;
		while(cur!=null)
		{
			lastKth--;
			cur = cur.next;
		}
		if(lastKth == 0){
			head = head.next;
			head.last = null;
		}
		if(lastKth < 0){
			cur = head;
			while(++lastKth != 0)
				cur = cur.next;
			
			DoubleNode newNext = cur.next.next;
			cur.next = newNext;
			if(newNext != null)
				newNext.last = cur;
		}
		
		return head;
	}
	
	//2.3.1删除链表的中间节点
	public static Node removeMidNode(Node head)
	{
		if(head == null || head.next == null)
			return head;
		
		if(head.next.next == null)
			return  head.next;
		
		Node pre = head;//pre为待删除节点的前一个节点
		Node cur = head.next.next;
		while(cur.next!=null && cur.next.next!=null)
		{
			pre = pre.next;
			cur = cur.next.next;
		}
		pre.next = pre.next.next;
		return head;
	}
	
	//2.3.2删除第a/b个节点
	public static Node removeByRatio(Node head, int a, int b)
	{
		if(a<1 || a>b)
			return head;
		int n=0;
		Node cur = head;
		while(cur!=null)//计算链表中节点的个数
		{
			n++;
			cur = cur.next;
		}
		n = (int)Math.ceil((double)(n*a)/(double)b);
		if(n == 1)
			return head = head.next;
		if(n > 1)
		{
			cur = head;
			while(--n!=1)
			{
				cur = cur.next;
			}
			cur.next = cur.next.next;
		}
		
		return head;
	}
	
	//2.2.3删除第K个节点
	public static Node deleteK(Node head, int K)
	{
		if(head == null || K < 1)
			return head;
		//计算一共有多少个节点
		int n = 0;
		Node cur = head;
		while(cur!=null){
			n++;
			cur = cur.next;
		}
		if(K > n)
			return head;
		
		if(K == 1)
			head = head.next;
		if(K > 1)
		{
			cur = head;
			while(--K!=1)//循环条件需要注意！！！
				cur = cur.next;
			
			cur.next = cur.next.next;
		}
		return head;
	}

	//2.2.4删除第K个节点
	public static Node deleteK_2(Node head, int K)
	{
		
		int len = 0;
		Node node = head;
		Node Kpre = null;
		while(node != null) {
			len++;
			Kpre = (len == K-1) ? node : Kpre;
			node = node.next;
		}
		if(len < 0)
			return null;
		if(K == 1)
			return head.next;
		if(K < 1 && K<=len)
			Kpre.next = Kpre.next.next;
		
		return head;
	}
	
	//2.4.1反转单向链表
	public static Node reverseList(Node head)
	{
		Node pre = null;
		Node next = null;
		while(head!=null)
		{
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}
	
	//2.4.2反转双向链表
	public static DoubleNode reverseList(DoubleNode head)
	{
		DoubleNode pre = null;
		DoubleNode next = null;
		while(head!=null)
		{
			next = head.next;
			head.next = pre;
			head.last = next;//比单链表反转多加一个前节点的链接
			pre = head;
			head = next;
		}
		return pre;
	}
	
	//2.5反转部分单向链表
	public static Node reservePart(Node head, int from, int to)
	{
		int len = 0;//链表长度
		Node node1 = head;
		Node fPre = null;
		Node tPos = null;
		while(node1 != null)
		{
			len++;
			fPre = (len == from-1) ? node1 : fPre;//提供了一种寻找节点的思路
			tPos = (len == to+1)   ? node1 : tPos;
			node1 = node1.next;
		}
		//不满足条件直接返回以前的头节点
		if(from>to || from<1 || to>len)
			return head;
		node1 = (fPre == null) ? head : fPre.next;
		Node node2 = node1.next;
		node1.next = tPos;
		Node next = null;
		while(node2!=tPos)
		{
			next = node2.next;
			node2.next = node1;
			node1 = node2;
			node2 = next;
		}
		if(fPre!=null)//fPre不为空，即from不为1，将fPre指向node1
		{
			fPre.next = node1;
			return head;
		}
		
		return node1;//fPre为空，即from为1，返回node1即可
	}
	
	//2.6.1约瑟夫问题
	public static Node josephusKill(Node head, int m)
	{
		if(head == null || head.next == null || m<1)
			return head;
		int count = 0;
		Node last = head;
		while(last.next!=head)
		{
			last = last.next;
		}
		while(head!=last)
		{
			if(++count == m){
				last.next = head.next;
				count = 0;
				//head = last.next;
			}else {
				last = last.next;
				//head = last.next;
			}
			head = last.next;//无论是否删除节点，head都是last的下一节点
		}
		return head;
		
	}
	
	//2.6.2约瑟夫问题
	public static int getLive(int i, int m)
	{
		if(i == 1)
			return i;
		return (getLive(i-1,m)+m-1)%i+1;
	}
	
	public static Node josephusKill_2(Node head, int m)
	{
		if(head == null || head.next == head || m<1)
			return head;
		
		Node cur = head.next;
		int count = 1;
		while(cur!=head)
		{
			count++;
			cur = cur.next;
		}
		count = getLive(count,m);
		
		while(--count!=0)//注意与删除第K个节点循环跳出条件区别
		{
			head = head.next;
		}
		head.next = head;	
		return head;
	}
	
	//2.7.1判断一个链表是否为回文结构
	public static boolean isPalindrome_1(Node head)
	{
		Stack<Node> stack = new Stack<Node>();
		Node cur = head;
		while(cur!=null)
		{
			stack.push(cur);
			cur = cur.next;
		}
		cur = head;
		boolean res = true;
		while(cur!=null)
		{
			if(cur.value != stack.pop().value)
			{
				res = false;
				break;
			}
			cur = cur.next;
		}
		return res;
		
	}
	
	//2.7.2判断一个链表是否为回文结构
	public static boolean isPalindrome_2(Node head)
	{
		if(head == null || head.next == null)
			return true;
		Node right = head.next;//右半部分的起始节点
		Node cur = head;
		while(cur.next!=null && cur.next.next!=null)
		{
			cur = cur.next.next;
			right = right.next;
		}
		
		Stack<Node> stack = new Stack<Node>();
		while(right!=null)
		{
			stack.push(right);
			right = right.next;
		}
		boolean res = true;
		cur = head;
		while(!stack.isEmpty()) {
			if(stack.pop().value != cur.value){
				res = false;
				break;
			}
			cur = cur.next;
		}
		
		return res;
	}
	
	//2.7.3判断一个链表是否为回文结构
	public static boolean isPalindrome_3(Node head)
	{
		if(head == null || head.next == null)
			return true;
		Node n1 = head;
		Node n2 = head;
		while(n2.next!=null && n2.next.next!=null)
		{
			n1 = n1.next;//查找中间节点
			n2 = n2.next.next;
		}
		n2 = n1.next;
		n1.next = null;
		Node n3 = null;
		while(n2!=null)//右半部分反序
		{
			n3 = n2.next;
			n2.next = n1;
		    n1 = n2;
		    n2 = n3;
		}
		n2 = head;	//n2为左边末端节点
		n3 = n1;	//n1为右边末端节点
		boolean res = true;
		while(n2!=null && n3!=null)
		{
			if(n2.value!=n3.value)
			{
				res = false;
				break;
			}
		}
		//将右半部分链表反转回来
		n2 = n1.next;
		n1.next = null;
		while(n2!=null)
		{
			n3 = n2.next;
			n2.next = n1;
			n2 = n3;
			n1 = n2;
		}
		return res;
		
	}
		
	//2.8.1将单向链表按某值划分成左边小，中间相等，右边大
	public static void arrPartition(Node[] arr, int pivot)
	{
		int small = -1;
		int big = arr.length;
		int index = 0;
		
		while(index!=big)
		{
			if(arr[index].value < pivot){
				swap(arr, ++small, index++);//
			}else if(arr[index].value == pivot) {
				index++;
			}else {
				swap(arr, index, --big);
			}
			
		}
	}
	
	public static Node listPartition_1(Node head, int pivot)
	{
		if(head == null)
			return head;
		Node cur = head;
		int len = 0;
		while(cur!=null)
		{
			len++;
			cur = cur.next;
		}
		Node[] arr = new Node[len];//节点存入数组
		cur= head;
		for(int i=0; i<arr.length; i++)
		{
			arr[i] = cur;
			cur = cur.next;
		}
		arrPartition(arr, pivot);
		for(int i=0; i<arr.length-1; i++)//将节点依次链接
		{
			arr[i].next = arr[i+1];
		}
		arr[arr.length-1].next = null;
		return arr[0];
		
	}

	public static void swap(Node[] arr, int a, int b)
	{
		Node tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
	
	//2.8.2将单向链表按某值划分成左边小，中间相等，右边大
	public static Node listPartition_2(Node head, int pivot)
	{
		Node sH = null;
		Node sL = null;
		Node eH = null;
		Node eL = null;
		Node bH = null;
		Node bL = null;//分别是小于等于大于pivot的头和尾
		Node next = null;
		while(head!=null)
		{
			next = head.next;
			head.next = null;
			if(head.value < pivot)
			{
				if(sH==null){
					sH = head;
					sL = head;
				}else {
					sL.next = head;//链接节点，并更新末节点位置
					sL = head;
				}
			}else if(head.value == pivot)
			{
				if(eH==null){
					eH = head;
					eL = head;
				}else {
					eL.next = head;
					eL = head;
				}
			}else if(head.value > pivot)
			{
				if(bH==null){
					bH = head;
					bL = head;
				}else {
					bL.next = head;
					bL = head;
				}
			}
			head = next;//下个节点
		}
		//将这三段连接起来	
		if(sL!=null)
		{
			sL.next = eH;
			eL = (eL==null) ? sL : eL;
		}
		if(eL!=null)
		{
			eL.next = bH;
		}		
		return (sH!=null) ? sH : ((eH!=null) ? eH : bH); 

	}
	
	//2.9.1复制含有随机指针节点的链表
	public static RandNode copyListWithRand_1(RandNode head)
	{
		HashMap<RandNode, RandNode> map = new HashMap<RandNode, RandNode>();
		RandNode cur = head;
		while(cur!=null)
		{
			map.put(cur, new RandNode(cur.value));//HashMap同一点一对
			cur = cur.next;
		}
		cur = head;
		while(cur!=null)
		{
			map.get(cur).next = cur.next;//设置next与rand指针
			map.get(cur).rand = cur.rand;
			cur = cur.next;
		}
		
		return map.get(head);
	}

	//2.9.2复制含有随机指针节点的链表
	public static RandNode copyListWithRand_2(RandNode head)
	{
		if(head == null)
			return head;
		RandNode cur = head;
		RandNode next = null;
		while(cur != null)
		{
			next = cur.next;
			cur.next = new RandNode(cur.value);//插入节点
			cur.next.next = next;
			cur = next;
		}
		cur = head;
		RandNode curCopy = null;//复制rand指针
		while(cur!=null)
		{
			next = cur.next.next;
			curCopy = cur.next;
			curCopy.rand = cur.rand!=null ? cur.rand.next : null;//cur.rand的后一个节点
			cur = next;
		}
		
		RandNode res = head.next;
		cur = head;
		while(cur!=null)
		{
			next = cur.next.next;
			curCopy = cur.next;
			cur.next = next;
			curCopy.next = next==null ? null : next.next;
			cur = next;
		}
		return res;
	}
	
	//2.10两个单链表生成相加链表(这种方法的问题：两个整形相加可能溢出)
	public static Node addList(Node head1, Node head2)
	{
		if(head1 == null && head2 == null)
			return null;
		else if(head1!=null&& head2 == null)
			return head1;
		else if(head1 == null && head2!=null)
			return head2;
		
		int num1 = listToInteger(head1);
		int num2 = listToInteger(head2);
		
		int num = num1 + num2;
		Node head = null;
		head = intToList(num, head);
		
		return head;
	}
	
	//链表转换为整数
	public static int listToInteger(Node head)
	{
		if(head == null)
			return 0;
		Stack<Node> stack = new Stack<Node>();
		Node cur = head;
		while(cur!=null)
		{
			stack.push(cur);
			cur = cur.next; 
		}
		int num = 0;
		int p = 0;
		while(!stack.isEmpty())
		{
			int n = stack.pop().value;
			num += n * Math.pow(10, p++);
		}		
		return num;
	}

	//整数转换为链表
	public static Node intToList(int num, Node head)
	{
		int rest = 0;
		Stack<Node> stack = new Stack<Node>();
		while(num!=0)
		{
			rest = num % 10;
			num /= 10;
			//创建节点并且链接
			stack.push(new Node(rest));
		}
		Node cur = null;
		while(!stack.isEmpty())
		{
			if(head == null){
				head = stack.pop();
				cur = head;
			}
			else{
				cur.next = stack.pop();
				cur = cur.next;
			}
		}
		return head;
		
	}
	
	//2.10.1两个单链表生成相加链表(栈)
	public static Node addList1(Node head1, Node head2)
	{
		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();
		//生成两个链表的逆序栈
		while(head1!=null)
		{
			s1.push(head1.value);
			head1 = head1.next;
		}
		while(head2!=null)
		{
			s2.push(head2.value);
			head2 = head2.next;
		}
		int ca = 0;
		int n1 = 0;
		int n2 = 0;
		int n = 0;
		Node pre = null;
		Node cur = null;
		while(!s1.isEmpty()||!s2.isEmpty())//栈弹出数据来控制循环 
		{
			n1 = s1.isEmpty() ? 0 : s1.pop();
			n2 = s2.isEmpty() ? 0 : s2.pop();
			n = n1 + n2 + ca;
			pre = cur;
			cur = new Node(n%10);
			cur.next = pre;
			ca = n / 10;	
		}
		
		if(1 == ca)
		{
			pre = cur;
			cur = new Node(ca);
			cur.next = pre;
		}
		
		return cur;
	}
	
	//2.10.2两个单链表生成相加链表(反转链表)
	public static Node addList2(Node head1, Node head2)
	{
		head1 = reverseList(head1);
		head2 = reverseList(head2);
		
		Node c1 = head1;
		Node c2 = head2;
		Node cur = null;
		Node pre = null;
		int n1 = 0;
		int n2 = 0;
		int n = 0;
		int ca = 0;
		
		while(c1!=null || c2!=null)
		{
			n1 = c1==null ? 0 : c1.value;
			n2 = c2==null ? 0 : c2.value;
			n = n1 + n2 + ca; //别漏了ca进位
			pre = cur;
			cur = new Node(n%10);
			cur.next = pre;
			ca = n / 10;
			c1 = c1==null ? null : c1.next;//若某个链表为空，则一直传null
			c2 = c2==null ? null : c2.next;//通过指针传递来控制循环条件
		}
		if(1 == ca)
		{
			pre = cur;
			cur = new Node(ca);
			cur.next = pre;
		}
		
		head1 = reverseList(head1);
		head2 = reverseList(head2);
		return cur;
		
	}
	
	//2.11两个单链表相交的一系列问题                                                                                                                                           
	public static Node getIntersectNode(Node head1, Node head2)
	{
		if(head1==null || head2==null)
			return null;
		
		Node loop1 = getLoopNode(head1);
		Node loop2 = getLoopNode(head2);
		if(loop1 == null && loop2 == null)
			return noLoop(head1, head2);
		if(loop1!=null && loop2!=null)
			return bothLoop(head1, loop1, head2, loop2);
		
		return null;
	}
	
	//判断链表是否有环,有返回第一个进入环的节点，没有返回null
	public static Node getLoopNode(Node head) 
	{
		if(head==null||head.next==null||head.next.next==null)
			return null;
		Node slow = head.next;
		Node fast = head.next.next;
		while(slow!=fast) {//快指针移动两步，慢指针移动一步
			if(fast.next==null || fast.next.next==null)
				return null;
			
			slow = slow.next;
			fast = fast.next.next;
		}
		fast = head;//快指针从头开始走
		while(slow!=fast){
			slow = slow.next;
			fast = fast.next;
		}
		return fast;
	}
	
	//判断无环链表是否相交,相交则返回第一个相交节点，否则返回null
	public static Node noLoop(Node head1, Node head2)
	{
		if(head1==null || head2==null)
			return null;
		Node cur1 = head1;
		Node cur2 = head2;
		int n = 0;
		while(cur1.next!=null){
			cur1 = cur1.next;
			n++;
		}
		while(cur2.next!=null){
			cur2 = cur2.next;
			n--;
		}
		if(cur1!=cur2)//末节点不相等，则两无环链表不相交
			return null;
		
		cur1 = n>0 ? head1: head2;
		cur2 = cur1==head1 ? head2 : head1;
		n = Math.abs(n);
		while(n!=0)
		{
			n--;
			cur1 = cur1.next;
		}
		while(cur1!=cur2){
			cur1 = cur1.next;
			cur2 = cur2.next;						
		}
		return cur1;
	}	
	
	//判断有环链表是否相交，相交则返回第一个相交节点，否则返回null
	public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2)
	{
		Node cur1 = head1;
		Node cur2 = head2;
		if(loop1 == loop2)//进入环的首节点相同，与无环链表相同，末节点为loop1(loop2)
		{
			int n1 = 0;
			int n2 = 0;
			while(cur1!=loop1){
				n1++;
				cur1 = cur1.next;
			}
			while(cur2!=loop2){
				n2++;
				cur2 = cur2.next;
			}
			cur1 = head1;
			cur2 = head2;
			if(n1>n2){
				for(int i=0; i<n1-n2; i++)
					cur1 = cur1.next;
			}
			if(n1<n2){
				for(int i=0; i<n2-n1; i++)
					cur2 = cur2.next;
			}
			while(cur1!=cur2)
			{
				cur1 = cur1.next;
				cur2 = cur2.next;
			}
			return cur1;
			
		}
		else//进入环的首节点不同，判断loop1循环一周是否与loop2相同 
		{
			cur1 = loop1.next;
			while(cur1!=loop1){
				if(cur1 == loop2)
					return loop1;
				
				cur1 = cur1.next;
			}
			return null;
		}
	
	}
	
	//2.12.1将单链表的每K个节点逆序
	public static Node reverseKNodes1(Node head, int K)
	{
		if(K<2)
			return head;
		
		Stack<Node> stack = new Stack<Node>();
		Node newHead = head;
		Node cur = head;
		Node pre = null;
		Node next = null;
		while(cur!=null)
		{
			next = cur.next;
			stack.push(cur);
			if(stack.size() == K) {
				pre = resign1(stack, pre, next);//pre->left,next->right
				newHead = (newHead==head) ? cur : newHead; 
			}
			cur = next;
		}
		return newHead;
	}
	
	public static Node resign1(Stack<Node> stack, Node left, Node right)
	{
		Node cur = stack.pop();
		
		if(left!=null)
			left.next = cur;
		Node next = null;
		while(!stack.isEmpty())
		{
			next = stack.pop();
			cur.next = next;
			cur = next;
		}
		cur.next = right;

		return cur;
	}
	
	//2.12.2将单链表的每K个节点逆序
	public static Node reverseKNodes2(Node head, int K) 
	{
		if(K<2)
			return head;
		
		Node cur = head;
		Node next = null;
		Node pre = null;
		Node start = null;
		int count = 1;
		while(cur!=null)
		{
			next = cur.next;
			if(count == K)
			{
				start = (pre==null) ? head : pre.next;
				head = (pre==null) ? cur : head;
				resign2(pre, start, cur, next);
				pre = start;
				count = 0;
			}
			count++;
			cur = next;
		}
		
		return head;
	}
	
	public static void resign2(Node left, Node start, Node end, Node right)
	{
		Node pre = start;
		Node cur = start.next;
		Node next = null;
		
		while(cur!=right){
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		
		if(left!=null)
			left.next = pre;//left链接区间右端
		
		start.next = right;//区间左端链接right
		
	}
	
	//2.13.1删除无序单链表中重复出现的节点
	public static void removeRep1(Node head)
	{
		if(head == null)
			return;
		HashSet<Integer> hs = new HashSet<Integer>();//哈希表，时间O(N),空间O(N)
		Node pre = null;
		Node cur = head;
		while(cur!=null)
		{
			if(hs.contains(cur.value))
				pre.next = cur.next;
			else
			{
				hs.add(cur.value);
				pre =cur;
			}
			cur = cur.next;
		}
		
	}
	
	//2.13.2删除无序单链表中重复出现的节点
	public static void removeRep2(Node head)
	{
		if(head==null||head.next == null)
			return;
		
		Node cur = head;
		Node next = null;
		Node pre = null;
		while(cur!=null)//时间复杂度O(N^2), 空间复杂度O(1)
		{
			pre = cur;
			next = cur.next;
			while(next!=null)
			{
				if(next.value==cur.value)
					pre.next = next.next;
				else
					pre = next;
				next = next.next;
			}
			cur = cur.next;
		}
		
	}
	
	//2.14.1在单链表中删除指定值的节点(用栈收集，重新连接，O(N),O(N))
	public static Node removeValue1(Node head, int num)
	{
		Stack<Node> stack = new Stack<Node>();
		while(head!=null)
		{
			if(head.value != num)
				stack.push(head);
			head = head.next;
		}
		
		while(!stack.isEmpty())
		{
			stack.peek().next = head;
			head = stack.pop();
		}
		return head;
	}
	
	//2.14.2在单链表中删除指定值的节点(遍历链表，直接删除，O(N)，O(1))
	public static Node removeValue2(Node head, int num)
	{
		while(head!=null && head.value == num)
		{
			head = head.next;
		}
		
		Node pre = head;
		Node cur = head;//cur = head.next也是可以的
		while(cur != null)
		{
			if(cur.value == num)
				pre.next = cur.next;
			else
				pre = cur;
				
			cur = cur.next;
		}
		
		return head;
	}

	//2.15.1将搜索二叉树转换为双向链表(队列存储，O(N),O(N))
	public static TreeNode convert1(TreeNode head)
	{
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		inOrderToQueue(head, queue);
		
		if(head == null)
			return head;
		
		head = queue.poll();
		TreeNode pre = head;
		pre.left = null;//首节点左边为空
		TreeNode cur = null;
		while(!queue.isEmpty())
		{
			cur = queue.poll();
			pre.right = cur;
			cur.left = pre;
			
			pre = cur;
		}
		pre.right = null;//末节点右边为空
		
		return head;
	}
	
	public static void inOrderToQueue(TreeNode head, Queue<TreeNode> queue)
	{
		if(head == null)
			return;
		
		while(head!=null)
		{
			inOrderToQueue(head.left, queue);
			queue.offer(head);
			inOrderToQueue(head.right, queue);
		}
		
	}
	
	//2.15.2将搜索二叉树转换为双向链表(递归，O(N),O(h))
	public static TreeNode convert2(TreeNode head)
	{
		if(head == null)
			return null;
		
		TreeNode last = process(head);
		head = last.right;
		last.right = null;
		
		return head;
	}
	
	public static TreeNode process(TreeNode head)
	{
		if(head == null)
			return null;
		
		TreeNode leftE = process(head.left);//左边末节点
		TreeNode rightE = process(head.right);//右边末节点
		TreeNode leftS  = (leftE==null)  ? null : leftE.right;//左边起节点 
		TreeNode rightS = (rightE==null) ? null : leftE.right;//右边起节点
		
		if(leftE!=null && rightE!=null)
		{
			leftE.right = head;
			head.left = leftE;
			head.right = rightS;
			rightS.left = head;
			rightS.right = leftS;
			return rightE;
		}else if(leftE!=null)
		{
			leftE.right = head;
			head.left = leftE;
			head.right = leftS;
			return head;
		}else if(rightE!=null)
		{
			head.right = rightS;
			rightS.left = head;
			rightE.right = head;
			return rightE;
		}else
		{
			head.right = head;
			return head;
		}
		
	}
	
	//2.16单链表的选择排序
	public static Node selectionSort(Node head)
	{
		if(head == null)
			return null;
		Node tail = null;//已排序部分末尾
		Node cur = head;//未排序部分开头
		Node smallPre = null;
		Node small = null;
		while(cur!=null)
		{
			small = cur;
			smallPre = getSmallestPreNode(cur);
			if(smallPre != null)
			{
				small = smallPre.next;
				smallPre.next = small.next;
			}
			cur = cur==small ? cur.next : cur;//最小值是否为第一个节点
			
			if(tail == null)
				head = small;
			else
				tail.next = small;//将最小节点置于tail后
			
			tail = small;
			
		}
		
		return head;
	}
	
	public static Node getSmallestPreNode(Node head)
	{
		Node smallPre = null;
		Node small = head;
		Node pre = head;
		Node cur = head.next;
		
		while(cur!=null)
		{
			if(cur.value < small.value)
			{
				small = cur;
				smallPre = pre;
			}
			
			pre = cur;
			cur = cur.next;
		}
		
		return smallPre;
	}
	
	//2.17一种怪异的删除节点的方式
	public static void removeNodeWired(Node node)
	{
		if(node==null)
			return;
		
		Node next = node.next;
		if(next == null)
			throw new RuntimeException("can not remove last node.");
		
		node.value = next.value;
		node.next = next.next;
	}
	
	//2.18向有序环形链表中加入新节点
	public static Node insertNum(Node head, int num)
	{
		Node node = new Node(num);//生成新节点
		if(head==null)
		{
			node.next = node;
			return node;
		}
		Node pre = head;
		Node cur = head.next;//第一第二开始判断，同步移动	
		while(cur!=head)
		{
			if(pre.value<=num && cur.value>=num)
				break;//寻找插入点
			
			pre = cur;
			cur = cur.next;
		}
		pre.next = node;//若插在末节点后，比所有节点小或大
		node.next = cur;
		
		return head.value<num ? head : node;
	}
	
	//2.19合并两个有序的单链表
	public static Node merge(Node head1, Node head2)
	{
		
		if(head1==null||head2==null)
			return (head1!=null) ? head1 : head2;
		
		Node cur1 = head1;
		Node cur2 = head2;//确定首节点
		Node head = head1.value > head2.value ? head2 : head1;
		if(head1 == head)	cur1 = cur1.next;
		if(head2 == head)	cur2 = cur2.next;
		Node pre = head;
		Node cur = head;
		while(cur1!=null && cur2!=null)//都有节点时比较第一个节点大小
		{
			if(cur1.value<cur2.value){
				cur = cur1;
				cur1 = cur1.next;
			}else {
				cur = cur2;
				cur2 = cur2.next;
			}

			pre.next = cur;				
			//cur.next = null;
			pre = cur;
		}	
		if(cur1!=null&&cur2==null)//某个链表为空时，将另一条链接到cur节点
			cur.next = cur1;
		if(cur1==null&&cur2!=null)
			cur.next = cur2;
			
		return head;
	}
	
	//2.20按照左右半区的方式重新组合单链表
	public static void relocate(Node head)
	{
		if(head==null||head.next==null)
			return;
		//找中点可以先求长度，在找中点；或以一步两步两个指针同时遍历
		Node cur = head;
		int len = 0;//链表长度
		while(cur!=null){
			len++;
			cur = cur.next;
		}
		int K = len/2;//右半区下标为K
		cur = head;
		while(--K!=0){
			cur = cur.next;
		}
		Node startL = head;
		Node startR = cur.next;
		cur.next = null;//左右断开
		
		Node curL = startL;
		Node nextL = startL.next;
		Node curR = startR;
		Node nextR = startR.next;
		while(nextL!=null)
		{
			curL.next = curR;
			curR.next = nextL;
			
			curL = nextL; 	nextL = nextL.next;
			curR = nextR; 	nextR = nextR.next;
		}
		curL.next = curR;
	}
		
	public static Node createList(Node head)
	{
		
		Node n1 = new Node(1);
		Node n2 = new Node(2); n1.next = n2;
		Node n3 = new Node(3); n2.next = n3;
		Node n4 = new Node(4); n3.next = n4;
		Node n5 = new Node(5); n4.next = n5;
		Node n6 = new Node(6); n5.next = n6; n6.next = n1;
		
		return n1;
	}

	public static void printNode(Node head)
	{
		if(head==null)
			return;
		System.out.print(head.value+" ");
		Node cur = head.next;
		while(cur != null && cur!=head)
		{
			System.out.print(cur.value+" ");
			cur = cur.next;
		}
		System.out.println();
	}
	
	public static void main1(String[] args) {
		// TODO 自动生成的方法存根
		//test2.1
		Node head1 = new Node(1);
		Node n1 = new Node(3); head1.next = n1;
		Node n2 = new Node(5); n1.next = n2;
		Node n3 = new Node(7); n2.next = n3;
		Node n4 = new Node(9); n3.next = n4;
		Node n5 = new Node(10); n4.next = n5;
		Node n6 = new Node(13); n5.next = n6;
		
		Node head2 = new Node(6);
		Node p1 = new Node(7); head2.next = p1;
		Node p2 = new Node(11); p1.next = p2;
		Node p3 = new Node(23); p2.next = p3;
		Node p4 = new Node(56); p3.next = p4;
		printNode(head1);
		printNode(head2);
		
		//Node n5 = new Node(6); n4.next = n5;
		//Node n6 = new Node(8); n5.next = n6;
		//printCommonPart(head1, head2);
		
		/*Node head1 = new Node(3);
		Node n1 = new Node(5); head1.next = n1;
		Node n2 = new Node(7); n1.next = n2;
		Node n3 = new Node(9); n2.next = n3;
		Node n4 = new Node(10); n3.next = n4;
		Node n5 = new Node(12); n4.next = n5;
		Node n6 = new Node(17); n5.next = n6; n6.next = head1;
		printNode(head1);*/
		
		//printNode(head2);
		//删除第三个元素
		//head1 = deleteK_2(head1, 1);
		//2.2删除倒数第三个元素
		//head1 = removeLastKthNode(head1,3);
		//2.3删除中间节点
		//head1 = removeMidNode(head1);
		//2.4反转链表
		//head1 = reverseList(head1);
		//2.5反转部分链表
		//head1 = reservePart(head1, 3, 6);
		//printNode(head1);
		//2.6约瑟夫问题
		//Node head = null;
		//head = createList(head);
		//head = josephusKill(head,4);
		//head = josephusKill_2(head,4);
		
		//2.7判断链表是否回文
		//boolean res = isPalindrome_3(head1);
		//System.out.println(res);
		
		//2.8将单向链表按某值划分成左边小，中间相等，右边大
		//listPartition_1(head1, 3);
		//listPartition_2(head1, 3);
		
		//2.10两个链表相加成链表
		//head1 = addList(head1,head2);
		//head1 = addList1(head1,head2);
		//head1 = addList2(head1,head2);
		
		//2.11
		//判断链表是否有环，返还第一个进入环的节点
		//head1 = getLoopNode(head1);
		
		//判断无环链表是否相交
		//head1 = noLoop(head1, head2);
		
		//判断有环链表是否相交
		//Node cur1 = getLoopNode(head1);
		//Node cur2 = getLoopNode(head2);
		//System.out.println(cur1.value);
		//System.out.println(cur2.value);
		//head1 = bothLoop(head1, cur1, head2, cur2);
		//System.out.println(head1.value);
	
		
		//2.12将单链表的每K个节点之间逆序
		//head1 = reverseKNodes1(head1,3);
		//head1 = reverseKNodes2(head1,3);
		
		//2.13删除无序单链表中重复出现的节点
		//removeRep1(head1);
		//removeRep2(head1);
		
		//2.14在单链表中删除指定值的节点
		//head1 = removeValue1(head1, 1);
		//head1 = removeValue2(head1, 1);
		
		//2.18向有序环形链表中加入新节点
		//head1 = insertNum(head1,0);
		
		//2.19合并两个有序的单链表
		//Node head = merge(head1, head2);
		
		//2.20按照左右半区的方式重新组合单链表
		//Node head3 = null;
		//relocate(head1);
		printNode(head1);
	}

}
