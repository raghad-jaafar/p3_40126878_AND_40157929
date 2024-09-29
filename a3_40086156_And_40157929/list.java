import java.util.Arrays;

public class list implements Structure{
	private Node first;
	private Node last;
	private int size; 
	private int[] keysToSort; // used for the merge sort
	private int[] temp; // used for the merge sort
	/**
	 * Default constructor.
	 */
	public list() {
		this.first = null;
		this.last = null; 
		this.size = 0; 
	}
	public boolean isEmpty() {
		if(first==null) {
		return true;	
		}
		return false;
	}
	@Override
	public void add(String key, String value) {
		Node n=new Node(key,value);
		if(isEmpty()) {
			first=n;
			last=n;
		}else {
		last.next=n;
		n.prev=last;
		n.next=null;
		last=n;
		}
		size++;
	}

	@Override
	public void remove(String key) {
		Node n=this.first;
		if(key.equals(first.getKey())) {
			n.next.prev=null;
			first=n.getNext();
			return;
		}
		for(int i=0;i<size;i++) {
			if(n.key.equals(key)) {
				n.prev.next=n.next;
				n.next.prev=n.prev;
				return;
			}
			n=n.next;
		}
	size--;	
	System.out.print("key not found");
	}

	@Override
	public String getValues(String key) {
		Node n=this.first;
		for(int i=0;i<size;i++) {
			if(n.key.equals(key)) {
				return n.value;
			}
			n=n.next;
		}
		//System.out.print("key not found");
		return null;
	}

	@Override
	public String getFirstKey() {
		if (this.first == null)
			return null;
		else
			return this.first.getKey();
	}

	@Override
	public String nextKey(String key) {
		Node n=this.first;
		for(int i=0;i<size;i++) {
			if(n.key.equals(key)) {
				return n.getNext().key;
			}
			n=n.next;
		}
		System.out.print(" Next key not found");
		return null;
	}

	@Override
	public String prevKey(String key) {
        Node n= this.last;	
		
		while(n.getPrev() != null) {		
			if (n.getKey().equals(key))
				return n.getPrev().getKey();		
			n = n.getPrev();
		}
		return null;
	}

	@Override
	public int[] allKeys() {
			Node n = this.first;
		keysToSort = new int[size];
	
	// filling keysToSort with the unordered keys
		for(int i = 0; i<size; i++){
			if(n != null){
				keysToSort[i] = Integer.parseInt(n.getKey());
				n = n.next;
			}
		}
		this.temp = new int[size];
		
	// ordering the keys
		mergesort(0, size - 1);
		return keysToSort; 
	}

	/**
	 * Merge sorts a sequence according to the keys of its entries.
	 * @param low the lowest key in the range
	 * @param high the highest key in the range
	 */
	private void mergesort(int low, int high){
		if(low < high){
			int mid = low + (high - low)/2; // average of the low and high
			mergesort(low, mid); 			// merge sort the lower-half
			mergesort(mid + 1, high); 		// merge sort the upper-half
			merge(low, mid, high); 			// merge the combined two halves
		}
	}
	/**
	 * Merges the merge sorted halves of a sequence
	 * @param low lowest key in the sequence
	 * @param mid mid value key in the sequence
	 * @param high highest key in the sequence
	 */
	private void merge(int low, int mid, int high){
		for(int i = low; i <=high; i++){
			temp[i] = keysToSort[i];
		}
		int i = low; 
		int j = mid + 1;
		int k = low; 
		
		while(i <= mid && j <= high){
			if(temp[i] <= temp[j]){
				keysToSort[k] = temp[i];
				i++;
			}
			else{
				keysToSort[k] = temp[j];
				j++;
			}
			k++;
		}
	}
	@Override
	public int rangeKey(String key1, String key2) {
		 Node n= this.first;	
			int num=0;
			while(n!= null) {		
				if (n.getKey().equals(key1)) {
					while(!(n.getKey().equals(key2))) {
						num++;
						n=n.getNext();
					}
					num--;}
		n = n.getNext();
			}
		return num;
	}
	public void print() {
	        Node current = first;
	        while(current != null){
	           System.out.println( current.getValue());
	            current= current.getNext();
	        }

	    }

	  
	class Node{
		protected Node next;
		protected Node prev;
		protected String key;
		protected String value;
		
		public Node(){
			this.next = null;
			this.prev = null;
			this.key = null;
			this.value = null; 
		}
		public Node(String key, String value){
			this.key = key;
			this.value = value; 
		}
		
		@Override
		public String toString() {
			return "Node [key=" + key + ", value=" + value + "]";
		}
		public Node getNext() {
			return next;
		}
		public Node getPrev() {
			return prev;
		}
		public String getKey() {
			return key;
		}
		public String getValue() {
			return value;
		}
	
	
	
	}

}