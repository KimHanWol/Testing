package symbolTable;

import java.util.ArrayList;
import java.util.List;

public class OrderedST<Key extends Comparable<Key>, Value> implements SymbolTable<Key, Value>{

	private int N;
	
	private Key[] keys;
	private Value[] values;
	
	@SuppressWarnings("unchecked")
	public OrderedST() {
		// TODO Auto-generated constructor stub
		keys = (Key[]) new Comparable[10];
		values = (Value[]) new Comparable[10];
		N = 0;
	}
	
	@Override
	public void put(Key key, Value val) {
		// TODO Auto-generated method stub
		int i = rank(key);
		//이미 존재하면 값 교체
		if(i < N && keys[i].compareTo(key) == 0) {
			values[i] = val;
			return;
		}
		//없으면 새로 만들어 테이블을 키운다.
		for(int j = i; j < N; j++) {
			keys[i + 1] = keys[i];
			values[i + 1] = values[i];
		}
		keys[i] = key;
		values[i] = val;
		N++;
	}

	@Override
	public Value get(Key key) {
		// TODO Auto-generated method stub
		if(isEmpty()) return null;
		int i = rank(key);
		System.out.println(key + "/" + keys[i]);
		if(i < N && keys[i].compareTo(key) == 0) return values[i];
		else return null;
	}

	@Override
	public void delete(Key key) {
		// TODO Auto-generated method stub
		if(isEmpty()) return;
		int rank = rank(key);
		
		for(int i = rank; i < N; i++) {
			keys[i] = keys[i + 1];
			values[i] = values[i + 1];
		}
		N--;
	}

	@Override
	public boolean contains(Key key) {
		// TODO Auto-generated method stub
		for(Key e : keys) {
			if(e == null) break;
			if(e.equals(key)) return true;
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return N == 0;
	}

	@Override
	public Key min() {
		// TODO Auto-generated method stub
		return keys[0];
	}

	@Override
	public Key max() {
		// TODO Auto-generated method stub
		return keys[N-1];
	}

	@Override
	public Key floor(Key key) {
		// TODO Auto-generated method stub
		int i = rank(key);
		if(contains(key)) return keys[i];
		else return keys[i - 1];
	}

	@Override
	public Key ceiling(Key key) {
		// TODO Auto-generated method stub
		int i = rank(key);
		return keys[i];
	}

	@Override
	public int rank(Key key) {
		// TODO Auto-generated method stub
		int lo = 0, hi = N - 1;
		while(lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			
			int cmp = key.compareTo(keys[mid]);
			if		(cmp  < 0) hi = mid - 1;
			else if (cmp  > 0) lo = mid + 1;
			else if (cmp == 0) return mid;
		}
		return lo;
	}

	@Override
	public Key select(int k) {
		// TODO Auto-generated method stub
		return keys[k];
	}

	@Override
	public int size(Key lo, Key hi) {
		// TODO Auto-generated method stub
		return rank(hi) - rank(lo);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return N;
	}

	@Override
	public Iterable<Key> keys(Key lo, Key hi) {
		// TODO Auto-generated method stub
		List<Key> list = new ArrayList<Key>();
		for (int i = rank(lo); i < rank(hi); i++) {
			list.add(keys[i]);
		}
		if(contains(hi)) list.add(keys[rank(hi)]);
		return list;
	}

	@Override
	public Iterable<Key> Keys() {
		// TODO Auto-generated method stub
		return keys(keys[0], keys[N-1]);
	}
	
}
