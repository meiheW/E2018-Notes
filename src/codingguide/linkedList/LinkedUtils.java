package codingguide.linkedList;

import java.util.*;

public class LinkedUtils {
	
	//2.1��ӡ������������Ĺ�������
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
	
	//2.2.1��������ɾ��������K���ڵ�
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
			while(++lastKth != 0)//-2,-1,0,0��ָ����һ����Ҫɾ���Ľڵ�
				cur = cur.next;
			cur.next = cur.next.next;
		}
		
		return head;
	}
	
	//2.2.2˫������ɾ��������K���ڵ�
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
	
	//2.3.1ɾ��������м�ڵ�
	public static Node removeMidNode(Node head)
	{
		if(head == null || head.next == null)
			return head;
		
		if(head.next.next == null)
			return  head.next;
		
		Node pre = head;//preΪ��ɾ���ڵ��ǰһ���ڵ�
		Node cur = head.next.next;
		while(cur.next!=null && cur.next.next!=null)
		{
			pre = pre.next;
			cur = cur.next.next;
		}
		pre.next = pre.next.next;
		return head;
	}
	
	//2.3.2ɾ����a/b���ڵ�
	public static Node removeByRatio(Node head, int a, int b)
	{
		if(a<1 || a>b)
			return head;
		int n=0;
		Node cur = head;
		while(cur!=null)//���������нڵ�ĸ���
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
	
	//2.2.3ɾ����K���ڵ�
	public static Node deleteK(Node head, int K)
	{
		if(head == null || K < 1)
			return head;
		//����һ���ж��ٸ��ڵ�
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
			while(--K!=1)//ѭ��������Ҫע�⣡����
				cur = cur.next;
			
			cur.next = cur.next.next;
		}
		return head;
	}

	//2.2.4ɾ����K���ڵ�
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
	
	//2.4.1��ת��������
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
	
	//2.4.2��ת˫������
	public static DoubleNode reverseList(DoubleNode head)
	{
		DoubleNode pre = null;
		DoubleNode next = null;
		while(head!=null)
		{
			next = head.next;
			head.next = pre;
			head.last = next;//�ȵ�����ת���һ��ǰ�ڵ������
			pre = head;
			head = next;
		}
		return pre;
	}
	
	//2.5��ת���ֵ�������
	public static Node reservePart(Node head, int from, int to)
	{
		int len = 0;//������
		Node node1 = head;
		Node fPre = null;
		Node tPos = null;
		while(node1 != null)
		{
			len++;
			fPre = (len == from-1) ? node1 : fPre;//�ṩ��һ��Ѱ�ҽڵ��˼·
			tPos = (len == to+1)   ? node1 : tPos;
			node1 = node1.next;
		}
		//����������ֱ�ӷ�����ǰ��ͷ�ڵ�
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
		if(fPre!=null)//fPre��Ϊ�գ���from��Ϊ1����fPreָ��node1
		{
			fPre.next = node1;
			return head;
		}
		
		return node1;//fPreΪ�գ���fromΪ1������node1����
	}
	
	//2.6.1Լɪ������
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
			head = last.next;//�����Ƿ�ɾ���ڵ㣬head����last����һ�ڵ�
		}
		return head;
		
	}
	
	//2.6.2Լɪ������
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
		
		while(--count!=0)//ע����ɾ����K���ڵ�ѭ��������������
		{
			head = head.next;
		}
		head.next = head;	
		return head;
	}
	
	//2.7.1�ж�һ�������Ƿ�Ϊ���Ľṹ
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
	
	//2.7.2�ж�һ�������Ƿ�Ϊ���Ľṹ
	public static boolean isPalindrome_2(Node head)
	{
		if(head == null || head.next == null)
			return true;
		Node right = head.next;//�Ұ벿�ֵ���ʼ�ڵ�
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
	
	//2.7.3�ж�һ�������Ƿ�Ϊ���Ľṹ
	public static boolean isPalindrome_3(Node head)
	{
		if(head == null || head.next == null)
			return true;
		Node n1 = head;
		Node n2 = head;
		while(n2.next!=null && n2.next.next!=null)
		{
			n1 = n1.next;//�����м�ڵ�
			n2 = n2.next.next;
		}
		n2 = n1.next;
		n1.next = null;
		Node n3 = null;
		while(n2!=null)//�Ұ벿�ַ���
		{
			n3 = n2.next;
			n2.next = n1;
		    n1 = n2;
		    n2 = n3;
		}
		n2 = head;	//n2Ϊ���ĩ�˽ڵ�
		n3 = n1;	//n1Ϊ�ұ�ĩ�˽ڵ�
		boolean res = true;
		while(n2!=null && n3!=null)
		{
			if(n2.value!=n3.value)
			{
				res = false;
				break;
			}
		}
		//���Ұ벿������ת����
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
		
	//2.8.1����������ĳֵ���ֳ����С���м���ȣ��ұߴ�
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
		Node[] arr = new Node[len];//�ڵ��������
		cur= head;
		for(int i=0; i<arr.length; i++)
		{
			arr[i] = cur;
			cur = cur.next;
		}
		arrPartition(arr, pivot);
		for(int i=0; i<arr.length-1; i++)//���ڵ���������
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
	
	//2.8.2����������ĳֵ���ֳ����С���м���ȣ��ұߴ�
	public static Node listPartition_2(Node head, int pivot)
	{
		Node sH = null;
		Node sL = null;
		Node eH = null;
		Node eL = null;
		Node bH = null;
		Node bL = null;//�ֱ���С�ڵ��ڴ���pivot��ͷ��β
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
					sL.next = head;//���ӽڵ㣬������ĩ�ڵ�λ��
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
			head = next;//�¸��ڵ�
		}
		//����������������	
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
	
	//2.9.1���ƺ������ָ��ڵ������
	public static RandNode copyListWithRand_1(RandNode head)
	{
		HashMap<RandNode, RandNode> map = new HashMap<RandNode, RandNode>();
		RandNode cur = head;
		while(cur!=null)
		{
			map.put(cur, new RandNode(cur.value));//HashMapͬһ��һ��
			cur = cur.next;
		}
		cur = head;
		while(cur!=null)
		{
			map.get(cur).next = cur.next;//����next��randָ��
			map.get(cur).rand = cur.rand;
			cur = cur.next;
		}
		
		return map.get(head);
	}

	//2.9.2���ƺ������ָ��ڵ������
	public static RandNode copyListWithRand_2(RandNode head)
	{
		if(head == null)
			return head;
		RandNode cur = head;
		RandNode next = null;
		while(cur != null)
		{
			next = cur.next;
			cur.next = new RandNode(cur.value);//����ڵ�
			cur.next.next = next;
			cur = next;
		}
		cur = head;
		RandNode curCopy = null;//����randָ��
		while(cur!=null)
		{
			next = cur.next.next;
			curCopy = cur.next;
			curCopy.rand = cur.rand!=null ? cur.rand.next : null;//cur.rand�ĺ�һ���ڵ�
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
	
	//2.10���������������������(���ַ��������⣺����������ӿ������)
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
	
	//����ת��Ϊ����
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

	//����ת��Ϊ����
	public static Node intToList(int num, Node head)
	{
		int rest = 0;
		Stack<Node> stack = new Stack<Node>();
		while(num!=0)
		{
			rest = num % 10;
			num /= 10;
			//�����ڵ㲢������
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
	
	//2.10.1���������������������(ջ)
	public static Node addList1(Node head1, Node head2)
	{
		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();
		//�����������������ջ
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
		while(!s1.isEmpty()||!s2.isEmpty())//ջ��������������ѭ�� 
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
	
	//2.10.2���������������������(��ת����)
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
			n = n1 + n2 + ca; //��©��ca��λ
			pre = cur;
			cur = new Node(n%10);
			cur.next = pre;
			ca = n / 10;
			c1 = c1==null ? null : c1.next;//��ĳ������Ϊ�գ���һֱ��null
			c2 = c2==null ? null : c2.next;//ͨ��ָ�봫��������ѭ������
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
	
	//2.11�����������ཻ��һϵ������                                                                                                                                           
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
	
	//�ж������Ƿ��л�,�з��ص�һ�����뻷�Ľڵ㣬û�з���null
	public static Node getLoopNode(Node head) 
	{
		if(head==null||head.next==null||head.next.next==null)
			return null;
		Node slow = head.next;
		Node fast = head.next.next;
		while(slow!=fast) {//��ָ���ƶ���������ָ���ƶ�һ��
			if(fast.next==null || fast.next.next==null)
				return null;
			
			slow = slow.next;
			fast = fast.next.next;
		}
		fast = head;//��ָ���ͷ��ʼ��
		while(slow!=fast){
			slow = slow.next;
			fast = fast.next;
		}
		return fast;
	}
	
	//�ж��޻������Ƿ��ཻ,�ཻ�򷵻ص�һ���ཻ�ڵ㣬���򷵻�null
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
		if(cur1!=cur2)//ĩ�ڵ㲻��ȣ������޻������ཻ
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
	
	//�ж��л������Ƿ��ཻ���ཻ�򷵻ص�һ���ཻ�ڵ㣬���򷵻�null
	public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2)
	{
		Node cur1 = head1;
		Node cur2 = head2;
		if(loop1 == loop2)//���뻷���׽ڵ���ͬ�����޻�������ͬ��ĩ�ڵ�Ϊloop1(loop2)
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
		else//���뻷���׽ڵ㲻ͬ���ж�loop1ѭ��һ���Ƿ���loop2��ͬ 
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
	
	//2.12.1���������ÿK���ڵ�����
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
	
	//2.12.2���������ÿK���ڵ�����
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
			left.next = pre;//left���������Ҷ�
		
		start.next = right;//�����������right
		
	}
	
	//2.13.1ɾ�������������ظ����ֵĽڵ�
	public static void removeRep1(Node head)
	{
		if(head == null)
			return;
		HashSet<Integer> hs = new HashSet<Integer>();//��ϣ��ʱ��O(N),�ռ�O(N)
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
	
	//2.13.2ɾ�������������ظ����ֵĽڵ�
	public static void removeRep2(Node head)
	{
		if(head==null||head.next == null)
			return;
		
		Node cur = head;
		Node next = null;
		Node pre = null;
		while(cur!=null)//ʱ�临�Ӷ�O(N^2), �ռ临�Ӷ�O(1)
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
	
	//2.14.1�ڵ�������ɾ��ָ��ֵ�Ľڵ�(��ջ�ռ����������ӣ�O(N),O(N))
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
	
	//2.14.2�ڵ�������ɾ��ָ��ֵ�Ľڵ�(��������ֱ��ɾ����O(N)��O(1))
	public static Node removeValue2(Node head, int num)
	{
		while(head!=null && head.value == num)
		{
			head = head.next;
		}
		
		Node pre = head;
		Node cur = head;//cur = head.nextҲ�ǿ��Ե�
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

	//2.15.1������������ת��Ϊ˫������(���д洢��O(N),O(N))
	public static TreeNode convert1(TreeNode head)
	{
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		inOrderToQueue(head, queue);
		
		if(head == null)
			return head;
		
		head = queue.poll();
		TreeNode pre = head;
		pre.left = null;//�׽ڵ����Ϊ��
		TreeNode cur = null;
		while(!queue.isEmpty())
		{
			cur = queue.poll();
			pre.right = cur;
			cur.left = pre;
			
			pre = cur;
		}
		pre.right = null;//ĩ�ڵ��ұ�Ϊ��
		
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
	
	//2.15.2������������ת��Ϊ˫������(�ݹ飬O(N),O(h))
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
		
		TreeNode leftE = process(head.left);//���ĩ�ڵ�
		TreeNode rightE = process(head.right);//�ұ�ĩ�ڵ�
		TreeNode leftS  = (leftE==null)  ? null : leftE.right;//�����ڵ� 
		TreeNode rightS = (rightE==null) ? null : leftE.right;//�ұ���ڵ�
		
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
	
	//2.16�������ѡ������
	public static Node selectionSort(Node head)
	{
		if(head == null)
			return null;
		Node tail = null;//�����򲿷�ĩβ
		Node cur = head;//δ���򲿷ֿ�ͷ
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
			cur = cur==small ? cur.next : cur;//��Сֵ�Ƿ�Ϊ��һ���ڵ�
			
			if(tail == null)
				head = small;
			else
				tail.next = small;//����С�ڵ�����tail��
			
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
	
	//2.17һ�ֹ����ɾ���ڵ�ķ�ʽ
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
	
	//2.18�������������м����½ڵ�
	public static Node insertNum(Node head, int num)
	{
		Node node = new Node(num);//�����½ڵ�
		if(head==null)
		{
			node.next = node;
			return node;
		}
		Node pre = head;
		Node cur = head.next;//��һ�ڶ���ʼ�жϣ�ͬ���ƶ�	
		while(cur!=head)
		{
			if(pre.value<=num && cur.value>=num)
				break;//Ѱ�Ҳ����
			
			pre = cur;
			cur = cur.next;
		}
		pre.next = node;//������ĩ�ڵ�󣬱����нڵ�С���
		node.next = cur;
		
		return head.value<num ? head : node;
	}
	
	//2.19�ϲ���������ĵ�����
	public static Node merge(Node head1, Node head2)
	{
		
		if(head1==null||head2==null)
			return (head1!=null) ? head1 : head2;
		
		Node cur1 = head1;
		Node cur2 = head2;//ȷ���׽ڵ�
		Node head = head1.value > head2.value ? head2 : head1;
		if(head1 == head)	cur1 = cur1.next;
		if(head2 == head)	cur2 = cur2.next;
		Node pre = head;
		Node cur = head;
		while(cur1!=null && cur2!=null)//���нڵ�ʱ�Ƚϵ�һ���ڵ��С
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
		if(cur1!=null&&cur2==null)//ĳ������Ϊ��ʱ������һ�����ӵ�cur�ڵ�
			cur.next = cur1;
		if(cur1==null&&cur2!=null)
			cur.next = cur2;
			
		return head;
	}
	
	//2.20�������Ұ����ķ�ʽ������ϵ�����
	public static void relocate(Node head)
	{
		if(head==null||head.next==null)
			return;
		//���е�������󳤶ȣ������е㣻����һ����������ָ��ͬʱ����
		Node cur = head;
		int len = 0;//������
		while(cur!=null){
			len++;
			cur = cur.next;
		}
		int K = len/2;//�Ұ����±�ΪK
		cur = head;
		while(--K!=0){
			cur = cur.next;
		}
		Node startL = head;
		Node startR = cur.next;
		cur.next = null;//���ҶϿ�
		
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
		// TODO �Զ����ɵķ������
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
		//ɾ��������Ԫ��
		//head1 = deleteK_2(head1, 1);
		//2.2ɾ������������Ԫ��
		//head1 = removeLastKthNode(head1,3);
		//2.3ɾ���м�ڵ�
		//head1 = removeMidNode(head1);
		//2.4��ת����
		//head1 = reverseList(head1);
		//2.5��ת��������
		//head1 = reservePart(head1, 3, 6);
		//printNode(head1);
		//2.6Լɪ������
		//Node head = null;
		//head = createList(head);
		//head = josephusKill(head,4);
		//head = josephusKill_2(head,4);
		
		//2.7�ж������Ƿ����
		//boolean res = isPalindrome_3(head1);
		//System.out.println(res);
		
		//2.8����������ĳֵ���ֳ����С���м���ȣ��ұߴ�
		//listPartition_1(head1, 3);
		//listPartition_2(head1, 3);
		
		//2.10����������ӳ�����
		//head1 = addList(head1,head2);
		//head1 = addList1(head1,head2);
		//head1 = addList2(head1,head2);
		
		//2.11
		//�ж������Ƿ��л���������һ�����뻷�Ľڵ�
		//head1 = getLoopNode(head1);
		
		//�ж��޻������Ƿ��ཻ
		//head1 = noLoop(head1, head2);
		
		//�ж��л������Ƿ��ཻ
		//Node cur1 = getLoopNode(head1);
		//Node cur2 = getLoopNode(head2);
		//System.out.println(cur1.value);
		//System.out.println(cur2.value);
		//head1 = bothLoop(head1, cur1, head2, cur2);
		//System.out.println(head1.value);
	
		
		//2.12���������ÿK���ڵ�֮������
		//head1 = reverseKNodes1(head1,3);
		//head1 = reverseKNodes2(head1,3);
		
		//2.13ɾ�������������ظ����ֵĽڵ�
		//removeRep1(head1);
		//removeRep2(head1);
		
		//2.14�ڵ�������ɾ��ָ��ֵ�Ľڵ�
		//head1 = removeValue1(head1, 1);
		//head1 = removeValue2(head1, 1);
		
		//2.18�������������м����½ڵ�
		//head1 = insertNum(head1,0);
		
		//2.19�ϲ���������ĵ�����
		//Node head = merge(head1, head2);
		
		//2.20�������Ұ����ķ�ʽ������ϵ�����
		//Node head3 = null;
		//relocate(head1);
		printNode(head1);
	}

}
