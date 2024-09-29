import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class CleverSIDC  {
	private final static int THRESHOLD = 1000; 
	boolean isBST = false;
	boolean isSequence = false;
	Structure s;
	
	
//	public static void main(String[] args) throws IOException{
//		String stringSize;
//		Scanner sc = new Scanner(System.in);
//		boolean inputIsInt = false;
//		
//	// Testing with test files
//		try{
//			Scanner in = new Scanner(new File("src/file1.txt"));
//			CleverSIDC sidc = new CleverSIDC(999);
//			System.out.println("CleverSIDC created");
//			
//			String randomVal = null; 
//			
//			System.out.println("Inserting entries to the CleverSIDC");
//			String newKey;
//			while(in.hasNextInt()){
//				try{
//					newKey = String.format("%08d", in.nextInt());
//					sidc.add(newKey, randomVal);
//					System.out.println(newKey);
//				}
//				catch(InputMismatchException e){
//					System.out.println("Key format is wrong");
//				}
//			}
//			System.out.println("Entries added to CleverSIDC");
//			System.out.println();	
//			in.close();
//		}catch(IOException e){
//			System.out.println("File not found");
//		}
//		
//		try{
//			Scanner in = new Scanner(new File("src/file2.txt"));
//			CleverSIDC sidc = new CleverSIDC(999);
//			System.out.println("CleverSIDC created");
//			
//			String randomVal = null; 
//			
//			System.out.println("Adding entries to the CleverSIDC");
//			String newKey;
//			while(in.hasNextInt()){
//				try{
//					newKey = String.format("%08d", in.nextInt());
//					sidc.add(newKey, randomVal);
//					
//				}
//				catch(InputMismatchException e){
//					System.out.println("Key format is wrong");
//				}
//			}
//			System.out.println("Entries added to CleverSIDC");
//			System.out.println();
//			in.close();
//		}catch(IOException e){
//			System.out.println("File not found");
//		}
//		
//		try{
//			Scanner in = new Scanner(new File("src/file3.txt"));
//			CleverSIDC sidc = new CleverSIDC(999);
//			System.out.println("CleverSIDC created");
//			
//			String randomVal = null; 
//			
//			System.out.println("Adding entries to the CleverSIDC");
//			String newKey;
//			while(in.hasNextInt()){
//				try{
//					newKey = String.format("%08d", in.nextInt());
//					sidc.add(newKey, randomVal);
//					
//				}
//				catch(InputMismatchException e){
//					System.out.println("Key format is wrong");
//				}
//			}
//			System.out.println("Entries added to CleverSIDC");
//			System.out.println();
//			in.close();
//		}catch(IOException e){
//			System.out.println("File not found");
//		}
//		
//	//Testing with user input
//		do{
//			System.out.println("Enter the deisred size of the CleverSIDC");
//			stringSize = sc.next();
//			if(isNum(stringSize)){
//				inputIsInt = true; 
//			}
//		}while(inputIsInt == false);
//		
//		
//		
//		
//	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
       System.out.println("Enter the desired size of the CleverSIDC");
		int size = sc.nextInt();
       CleverSIDC sd=new CleverSIDC(size);
       for(int i=0;i<size;i++) {
    	   String key=sd.generate();
    	   String val=sd.generatev();
    	   sd.add(key,val ); 
   System.out.println(key);
 
       }
      
       CleverSIDC sd2=new CleverSIDC(1001);
       for(int i=00000000;i<size;i++) {
    	   String key=Integer.toString(i);
    	   String val=sd.generatev();
    	   sd2.add(key,val ); 
   System.out.println(key);
 
       }
//       sd2.add("00000001",sd2.generatev() ); 
//       sd2.add("00000002",sd2.generatev() ); 
//       sd2.add("00000003",sd2.generatev()); 
//       sd2.add("00000004",sd2.generatev() ); 
//       sd2.add("00000005",sd2.generatev() ); 
//       sd2.add("00000006",sd2.generatev() ); 
//       sd2.add("00000007",sd2.generatev() ); 
//       sd2.add("00000008",sd2.generatev()); 
//       sd2.add("00000010",sd2.generatev() ); 
//       sd2.remove("00000010");
       
   //   System.out.println(sd2.rangeKey("00000002", "00000005"));
     System.out.println(sd2.prevKey("9998"));
         System.out.println(sd2.getValues("1"));
	
      
       
       
       

	}
	public CleverSIDC(int size){
		setSmartThresholdULS(size);
		if(isBST){
			s = new BStree();
			System.out.println("The data structure used is Binary Search Tree");
		}
		else if(isSequence){
			s = new list();
			System.out.println("The data structure used is List");
		}
	}
	
	/**
	 * Sets the type of data structure that will be used by the CleverSIDC
	 * @param size number of expected entries of the CleverSIDC
	 */
	public void setSmartThresholdULS(int size){
		if(size >= THRESHOLD){
			isBST = true;
		}
		else{
			isSequence = true; 
		}
	}
	public static boolean isNum(String str){
		try{
			int i = Integer.parseInt(str);
		}
		catch(NumberFormatException e){
			return false;
		}
		return true;
	}
	public void add(String key, String value){
          s.add(key, value);
	}
	
	/**
	 * Removes an entry in the CleverSIDC object.
	 * @param key key of the entry to be removed
	 */
	public void remove(String key){
		s.remove(key);
	}
	
	/**
	 * Finds the value of a given entry in the CleverSIDC object.
	 * @param key key of the given entry
	 * @return value of the given entry
	 */
	public String getValues(String key){
		return s.getValues(key);
		
	}
	public int[] allKeys(){
		int[] sortedKeys = s.allKeys();
		return sortedKeys;
	}
	
	/**
	 * Finds the key succeeding a given entry in the CleverSIDC object.
	 * @param key key of the given entry
	 * @return key of the entry succeeding the given entry
	 */
	public String nextKey(String key){
		
		
		return s.nextKey(key);
	}
	public String prevKey(String key){
		
		
		return s.prevKey(key);
	}
	public String generate(){
		Random r = new Random();
		int randomKey;
		String strVal;
		do{
			randomKey = 1000000 + r.nextInt(90000000);
			strVal = Integer.toString(randomKey);
			
		}while(this.getValues(strVal) != null);
		String key=Integer.toString(randomKey);
		return key;
	}
	int num=0;
	public String generatev() {
		num++;
		String v="testuser"+num;
		return v;
		
	}
public int rangeKey(String key1, String key2) {
	return s.rangeKey(key1,key2);
//		int numbOfKeys = 0;
//		String key = this.s.getFirstKey();
//		
//		while (key != null) {
//			if( key.compareTo(key1) > 0 && key.compareTo(key2) < 0)
//				numbOfKeys++;
//			key = this.s.nextKey(key);
//		}
//		
//		return numbOfKeys;
	}
}