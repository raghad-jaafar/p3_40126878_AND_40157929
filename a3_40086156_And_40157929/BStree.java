public class BStree implements Structure{
	private NodeEntry root;
	@Override
	public void add(String key, String value) {
			if(root == null){ // if there's no root
				root = new NodeEntry(key, value);
			}
			else{
				root.add(key, value);
			}
		
	}

	@Override
	public void remove(String key) {
		NodeEntry removingEntry = getNodeEntry(key);
		remove2(key, removingEntry);
		
	}
public void remove2(String key,NodeEntry entry)
{if(entry == null){
	return;
}
if(key.compareTo(entry.key) < 0){
	remove2(key, entry.left); // left child
}
else if(key.compareTo(entry.key)>0){
	remove2(key,entry.right); // right child
}
else{
	if(entry.left != null && entry.right != null){ // no child
		NodeEntry leftMax = maxElem(entry.left);
		entry.key = leftMax.key;
		remove2(leftMax.key, entry.left); // removes the leftmost entry in the tree
	}
	else if(entry.left != null){
		entry = entry.left;
	}
	else if(entry.right != null){
		entry = entry.right;
	}
	else{
		entry = null;
	}
}}
private NodeEntry getNodeEntry(String key){
	NodeEntry cur=root;
	int id = Integer.parseInt(key);
	while(cur != null) {
		if(Integer.parseInt(cur.key)==id) {
			return cur;
		}else if(Integer.parseInt(cur.key)>id) {
			cur=cur.left;
		}else {
			cur=cur.right;
		}
	}
	return null;
	
	
}

	private NodeEntry maxElem(NodeEntry entry){//return right most leaf
		if(entry.right == null){
			return entry;
		}
		else{
			return maxElem(entry.right);
		}
	}



	@Override
	public String getValues(String key) {
		NodeEntry entry = getNodeEntry(key);
		if(entry != null){
			return entry.value;
}
	else{
		return null;
	}
	}

	@Override
	public String getFirstKey() {
		if (this.root == null)
			return null;
		else
			return root.key;
	}

	@Override
	public String nextKey(String key) {
		NodeEntry curr = getNodeEntry(key);
		if(curr != null){
			NodeEntry next = getNext(curr);
			if(next != null){
				return next.key;
			}
			else{
				return "No next key found";
			}
		}
		else{
			return "Key not found";
		}
	}
	private NodeEntry getNext(NodeEntry first) {
		NodeEntry next = null; 
		NodeEntry parentNext = null; 
		NodeEntry curr = first.right;
		
		while(curr!=null){
			parentNext = next;
			next = curr; 
			curr = curr.left;
		}
		if(next != first.right){
			parentNext.left = next.right;
			next.right = first.right;
		}
		return next;
	}

	@Override
	public String prevKey(String key) {
NodeEntry entry = getNodeEntry(key);
		
		if(entry != null){
			NodeEntry prev = getPrev(root, entry);
			if(prev != null){
				return prev.key;
			}
			else{
				return null;
			}
		}
		else{
			return null;
		}
	}

	private NodeEntry getPrev(NodeEntry root, NodeEntry first) {
		if(first.left != null){
			return maxElem(first.left);
		}
		NodeEntry prev = null;
		while(root != null){
			if(Integer.parseInt(first.key) == Integer.parseInt(root.key)){
				break;
			}
			else if(Integer.parseInt(first.key) < Integer.parseInt(root.key)){
				root = root.left;
			}
			else if(Integer.parseInt(first.key) > Integer.parseInt(root.key)){
				prev = root;
				root = root.right;
			}
		}
		return prev; 
	}

	@Override
	public int[] allKeys() {
		return null;
	}

	@Override
	public int rangeKey(String key1, String key2) {
		int numbOfKeys = 0;
		String key = this.getFirstKey();
		
		while (key != null) {
			if( key.compareTo(key1) > 0 && key.compareTo(key2) < 0)
				numbOfKeys++;
			key = this.nextKey(key);
		}
		
		return numbOfKeys;
	}
	
	class NodeEntry{
		protected String key;
		protected String value; 
		protected NodeEntry left, right; 
		
		/**
		 * Constructor
		 * @param key
		 * @param value
		 *///Creates a parentNode
			public NodeEntry(String key,NodeEntry left, NodeEntry right, String value){
				this.key = key; 
				this.value = value;
				this.left = left;
				this.right = right;
			}
		public NodeEntry(String key, String value){
			this.key = key; 
			this.value = value; }
			public void add(String key2, String value2) {
				if(key.compareTo(this.key) < 0){
					if(left!=null){
						left.add(key, value);
					}
					else{
						left = new NodeEntry(key, value);
					}
				}
				else if(key.compareTo(this.key) > 0){
					if(right != null){
						right.add(key, value);
					}
					else{
						right = new NodeEntry(key, value);
					}
				}
				
			
		}
			
		
	}



}