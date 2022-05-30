package mainPackage;

import symbolTable.OrderedST;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		OrderedST<Character, Integer> st = new OrderedST<>(); 
		st.put('A', 8);
		st.put('C', 4);
		st.put('E', 12);
		st.put('H', 5);
		st.put('L', 11);
		st.put('M', 9);
		st.put('P', 10);
		st.put('R', 3);
		st.put('S', 0);
		st.put('X', 7);
		
		System.out.println(st.Keys());
		
		System.out.println("B ceiling : " + st.ceiling('B'));
		System.out.println("B floor : " + st.floor('B'));
		System.out.println("E rank : " + st.rank('E'));
	}
}