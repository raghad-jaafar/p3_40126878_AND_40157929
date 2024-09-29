public interface Structure {
	
		/**
		 * Places an entry inside the data structure.
		 * @param key Key of the new entry
		 * @param value value of the new entry
		 */
		public  void add(String key, String value);
		
		/**
		 * Removes an entry inside the data structure.
		 * @param key key of the entry to be removed
		 */
		public  void remove(String key);
		
		/**
		 * Finds the value of the entry with a specific key.
		 * @param key key of the entry whose value is desired
		 * @return value of the entry
		 */
		public  String getValues(String key);
		
		/**
		 * Finds the key of the first entry stored in the data structure.
		 * @return key of the first entry
		 */
		public String getFirstKey();
		
		/**
		 * Finds the key of the element succeeding a given element in the data structure.
		 */
		public String nextKey(String key);
		
		/**
		 * Finds the key of the element preceding a given element in the data structure.
		 */
		public String prevKey(String key);
		
		/**
		 * Sorts the keys of the elements in the data structure.
		 * @return Array with the sorted key
		 */
		public int[] allKeys();
		/**
		 * @return returns the number of keys that are within the specified range of keys
		 */
	public int rangeKey(String key1,String key2);

	
}