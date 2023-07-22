/**
 * 
 */
package lab1;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;


/**
 * @author saifb
 *
 */
public class huffman {
	private static Map<Character,Integer> freq = new HashMap<>();
	private static PriorityQueue<minHeapNode> minHeap = new PriorityQueue<>();
	private static Map<Character,String> codes = new HashMap<>();
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s  = "geeksforgeeks";
		calcFreq(s);
		System.out.println(freq.toString());
		huffman();
		System.out.println(codes.toString());
		
		String encoded = encoding(s);
		System.out.println(encoded);
		String decoded = decoding(encoded,minHeap.peek());
		System.out.println(decoded);
	}
	private static String decoding(String str,minHeapNode root) {
		String ans = "";
		minHeapNode curr = root;
		for(char c: str.toCharArray()) {
			if(c == '0') {
				curr = curr.left;
			}
			else {
				curr = curr.right;
			}
			if(curr.left == null && curr.right == null) {
				ans += curr.data;
				curr = root;
			}
		}
		return ans;
	}
	private static String encoding(String str) {
		String ans = "";
		for(char c:str.toCharArray()) {
			ans += codes.get(c);
		}
		return ans;
	}
	
	
	private static void huffman() {
		for(Entry<Character,Integer> entry : freq.entrySet()) {
			minHeap.add(new minHeapNode(entry.getKey(),entry.getValue()));
		}
		while(minHeap.size() != 1) {
			minHeapNode left = minHeap.poll();
			minHeapNode right = minHeap.poll();
			minHeapNode top = new minHeapNode('$',left.freq + right.freq);
			top.left = left;
			top.right = right;
			minHeap.add(top);
		}
		
		
		storesCode(minHeap.peek(),"");
	}
	private static void storesCode(minHeapNode root, String str) {
		if(root == null) {
			return;
		}
		if(root.data != '$') {
			codes.put(root.data, str);
		}
		storesCode(root.left,str+"0");
		storesCode(root.right, str + "1");
		
	}
	private static void calcFreq(String s) {
		for(char c: s.toCharArray()) {
			freq.put(c,freq.getOrDefault(c,0)+1);
		}
	}
}

class minHeapNode implements Comparable<minHeapNode>{
	char data;
	int freq;
	minHeapNode left , right;
	minHeapNode(char data, int freq){
		this.data = data;
		this.freq = freq;
	}
	public int compareTo(minHeapNode others) {
		return this.freq - others.freq;
	}
}
