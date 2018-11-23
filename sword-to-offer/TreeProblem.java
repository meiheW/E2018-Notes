import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(int val){
		this.val = val;
	}
	
}

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}


class TreeTest {
	
	//��������
	public void Mirror(TreeNode node){
		if(node==null)	return;
		TreeNode tmp = node.left;
		node.left = node.right;
		node.right = tmp;
		
		Mirror(node.left);
		Mirror(node.right);
	}
	
	//�������
	public void FirstTraverse(TreeNode root){
		if(root==null)
			return;
		
		System.out.print(root.val+" ");
		FirstTraverse(root.left);
		FirstTraverse(root.right);
	}
	
	//�������
	public void LastTraverse(TreeNode root){
		if(root==null)
			return;
		
		LastTraverse(root.left);
		LastTraverse(root.right);
		System.out.print(root.val+" ");
	}
	
	//�������
	public void MidTraverse(TreeNode root){
		if(root==null)
			return;
		
		LastTraverse(root.left);
		System.out.print(root.val+" ");
		LastTraverse(root.right);
	}
	
	//�������
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        if(root==null)	return null;
        
        Deque<TreeNode> dq = new LinkedList<TreeNode>();
        dq.add(root);
        while(!dq.isEmpty()){
        	TreeNode cur = dq.pop();
        	al.add(cur.val);
        	
        	if(cur.left!=null)		
        		dq.add(cur.left);
        	if(cur.right!=null)  	
        		dq.add(cur.right);
        }
        
        return al;
    }
	
	//�������ؽ�
	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode node = reConstructBinaryTree(pre, 0, pre.length-1, in, 0, in.length-1);
        return node;
    }
	
	private TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
		
		if(startPre>endPre||startIn>endIn)
			return null;
		TreeNode root = new TreeNode(pre[startPre]);
		
		for(int i=startIn; i<=endIn; i++){
			if(in[i]==pre[startPre]){
				root.left  = reConstructBinaryTree(pre, startPre+1, startPre+i-startIn, in, startIn, i-1);
				root.right = reConstructBinaryTree(pre, startPre+i-startIn+1, endPre, in, i+1, endIn);
			}
			
		}
		
		return root;
	}
	
	
	//����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ����
	//����������Yes,�������No���������������������������ֶ�������ͬ��
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence==null||sequence.length==0)
        	return false;
        
        return IsTreeBST(sequence, 0, sequence.length-1);	
    }
	
	private boolean IsTreeBST(int[] sequence, int start, int end) {
		if(end<=start)	return true;
		
		int i = start;
		for(;i<end; i++){
			if(sequence[i] > sequence[end])
				break;
		}
		
		for(int j=i; j<end; j++){
			if(sequence[j] < sequence[end])
				return false;
		}
		
		return IsTreeBST(sequence, start, i-1) && IsTreeBST(sequence, i, end-1);
	}
	
	
	
	//����һ�Ŷ������ĸ��ڵ��һ����������ӡ���������н��ֵ�ĺ�Ϊ��������������·����
	//·������Ϊ�����ĸ���㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·����
	//*** *** DFS *** ***
	private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
	private ArrayList<Integer> list = new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
    	if(root==null)	return listAll;
    	list.add(root.val);
    	target -= root.val;
    	if(target==0&&root.left==null&&root.right==null)
    		listAll.add(new ArrayList<Integer>(list));
    	FindPath(root.left, target);
    	FindPath(root.right, target);
    	list.remove(list.size()-1);
    	
    	return listAll;
    	
    }
	
    //����һ�ö��������������ö���������ת����һ�������˫������
    //Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ��
    //*************�Լ��ķ���******************
    //*************�������********************
    public TreeNode Convert(TreeNode pRootOfTree) {
    	if(pRootOfTree==null||(pRootOfTree.left==null&&pRootOfTree.right==null))
    		return pRootOfTree;
    	ArrayList<TreeNode> al = new ArrayList<TreeNode>();
    	alStore(al, pRootOfTree);
    	
    	al.get(0).right = al.get(1);
    	al.get(al.size()-1).left = al.get(al.size()-2);
    	for(int i=1; i<al.size()-1; i++){
    		al.get(i).left  = al.get(i-1);
    		al.get(i).right = al.get(i+1);
    	}
    	
    	return al.get(0);
    }
    
	private void alStore(ArrayList<TreeNode> al, TreeNode pRootOfTree) {
		if(pRootOfTree!=null){
			alStore(al, pRootOfTree.left);
			al.add(pRootOfTree);
			alStore(al, pRootOfTree.right);
		}
		
	}

	
	//����һ�ö����������������ȡ�
	//�ݹ飺������Ƚϴ�ֵ+1
    public int TreeDepth(TreeNode root) {
        if(root==null)	return 0;
    	return Math.max(TreeDepth(root.left), TreeDepth(root.right))+1;
    }
	
    
    //����һ�ö��������жϸö������Ƿ���ƽ���������
    //******��Ŀ�����ˣ�����������������******
    public boolean IsSearch_Solution(TreeNode root) {
    	ArrayList<TreeNode> al = new ArrayList<TreeNode>();
    	saveToList(al, root);
    	for(int i=0; i<al.size()-1; i++){
    		if(al.get(i).val > al.get(i+1).val)
    			return false;
    	}
    	return true;
    }
	
	private void saveToList(ArrayList<TreeNode> al, TreeNode root) {
		if(root!=null){
			saveToList(al, root.left);
			al.add(root);
			saveToList(al, root.right);
		}
	}
	
	//����һ�ö��������жϸö������Ƿ���ƽ���������
	//***********�����������*************
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root==null)
            return true;
        if(root.left==null&&root.right==null)
    		return true;
        int diff = Math.abs(TreeDepth(root.left) - TreeDepth(root.right));
    	if(diff>1)	return false;
    	
    	return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    	
    }
	
    
    //����һ�������������е�һ����㣬���ҳ��������˳�����һ����㲢�ҷ��ء�
    //ע�⣬���еĽ�㲻�����������ӽ�㣬ͬʱ����ָ�򸸽���ָ�롣
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
    	if(pNode==null)	return null;
    	//�ҽڵ㲻Ϊ�գ������ҽڵ�������ӽڵ�
    	if(pNode.right!=null){
    		TreeLinkNode node = pNode.right;
    		while(node.left!=null){
    			node = node.left;
    		}
    		return node;
    	}
        //�ҽڵ�Ϊ�գ������Ҹ��ڵ㣬ֱ������Ϊ���ڵ�����ӽڵ�
    	while(pNode.next!=null){
    		if(pNode.next.left==pNode)	return pNode.next;    		
    		pNode = pNode.next;
    	}
    	return null;
    	
    }
    
    
    //��ʵ��һ�������������ж�һ�Ŷ������ǲ��ǶԳƵġ�
    //ע�⣬���һ��������ͬ�˶������ľ�����ͬ���ģ�������Ϊ�ԳƵġ�
    boolean isSymmetrical(TreeNode pRoot)
    {
        TreeNode pNewRoot = getMirror(pRoot);
        return isSymmetrical(pRoot, pNewRoot); 
    }
    
	
	private boolean isSymmetrical(TreeNode pRoot, TreeNode pNewRoot) {
		if(pRoot==null && pNewRoot==null)
			return true;
		else if(pRoot==null||pNewRoot==null)
			return false;
		
		if(pRoot.val==pNewRoot.val)
			return isSymmetrical(pRoot.left, pNewRoot.left) && isSymmetrical(pRoot.right, pNewRoot.right);
		
		return false;
	}

	private TreeNode getMirror(TreeNode pRoot) {
		if(pRoot==null)
			return null;
		
		TreeNode node = new TreeNode(pRoot.val);
		node.right = getMirror(pRoot.left);
		node.left = getMirror(pRoot.right);
				
		return node;
	}

	//����һ����
	public TreeNode genTree(){
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		
		n1.left = n2;	n1.right = n3;
		n2.left = n4;	n2.right = n5;
		n3.left = n6;
		
		return n1;
	}
	

	
	
}

public class TreeProblem{
	
	public static void main(String[] args) {
		TreeTest tt = new TreeTest(); 
		TreeNode root = tt.genTree();
		//ǰ�к����
		tt.FirstTraverse(root);System.out.println();
		tt.LastTraverse(root);System.out.println();
		tt.MidTraverse(root);System.out.println();
		//�������
		ArrayList<Integer> pfttb = tt.PrintFromTopToBottom(root);
		for(int i : pfttb)
			System.out.print(i+" ");
		
		System.out.println("****************");
		//�������ؽ�
		int[] pre = {1,2,4,7,3,5,6,8};
		int[] in  = {4,7,2,1,5,3,8,6};
		System.out.println(pre.length);
		TreeNode reconNode = tt.reConstructBinaryTree(pre, in);
		tt.FirstTraverse(reconNode);
		tt.MidTraverse(reconNode);
		System.out.println("****************");
		
	}
		
}
