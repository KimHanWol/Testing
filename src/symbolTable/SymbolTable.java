package symbolTable;

public interface SymbolTable<Key extends Comparable<Key>, Value> {
	public void put(Key key, Value val);
	public Value get(Key key);
	public void delete(Key key);
	
	public boolean contains(Key key);
	public boolean isEmpty();
	public Key min();
	public Key max();
	public Key floor(Key key);
	public Key ceiling(Key key);
	public int rank(Key key);
	public Key select(int k);
	public int size(Key lo, Key hi);
	public int size();
	
	public Iterable<Key> keys(Key lo, Key hi);
	public Iterable<Key> Keys();
}
