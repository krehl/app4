/**
 * 
 */
package exercise.adt;

import java.util.*;

/**
 * Programmieren Sie eine typisierte Klasse RedBlackTree die von
 * java.util.AbstractCollection<E> erbt und einen Rot-Schwarz-Baum reali-siert, f ur Referenzen auf Objekte von Klassen die java.lang.Comparable<T>
 * implementieren.
 * RedBlackTree soll ein ver anderbarer Datenspeicher (modiable collection) sein. Le-gen Sie die die Methoden und Iteratoren so an, wie in der Java Platform, Standard
 * Edition 6 API Specication f ur java.util.AbstractCollection<E> gefordert.
 * a) Ueberschreiben Sie die von java.util.AbstractCollection<E> geerbten Me-thoden add und size. Sehen Sie eine Methode vor, die die Schwarztiefe des
 * Rot-Schwarz-Baums zur uckliefert.
 * (50 Punkte)
 * b) Sehen Sie zwei Methoden vor, die unterschiedliche Iteratoren zur uckliefern und
 * schreiben Sie die dazu geh origen Iterator-Klassen.
 * Ein Iterator durchl auft den Baum in in-order Reihenfolge, d.h. die Elemente
 * werden in aufsteigender Ordnung zur uckgeliefert.
 * Ein Iterator durchl auft den Baum in reverse in-order Reihenfolge, d.h. die
 * Elemente werden in absteigender Ordnung zur uckgeliefert.
 * 
 * Uberschreiben Sie die von java.util.AbstractCollection<E> geerbte Metho-de iterator so, dass der in-order -Iterator zur  uckgeliefert wird.
 * Die Iteratoren implementieren die Schnittstelle Iterator vollständig, d.h. es
 * werden die Methoden hasNext, next und remove exportiert. Erweitern Sie die
 * Klasse RedBlackTree entsprechend.
 * (50 Punkte)
 * 
 * @author Konstantin Krehl
 */
public class RedBlackTree<T extends Comparable<T>, Value> extends AbstractCollection<T> {
	
	private static final boolean RED   = true;
    private static final boolean BLACK = false;
	
    private Node root; //root Element
    
    //Hilfsdatenspeicher
	public class Node {
		private T key;
		private Value val;
		private boolean color; 				//true = RED, false = BLACK 
		private Node left,right,parent;
		private int N; 						//subtree count
		public Node(T key, Node left, Node right, Node parent) {
			this.key = key;
			this.left = left;
			this.right = right;
			this.parent = parent;
		}
	}
	
	//Hilfsfunktionen
    // is node x red; false if x is null ?
    private boolean isRed(Node x) {
        if (x == null) return false;
        return (x.color == RED);
    }

    // number of node in subtree rooted at x; 0 if x is null
    private int size(Node x) {
        if (x == null) return 0;
        return x.N;
    }
    
    
    // return number of key-value pairs in this symbol table
    public int size() { return size(root); }

    // is this symbol table empty?
    public boolean isEmpty() {
        return root == null;
    }
	
    // value associated with the given key; null if no such key
    public Value get(T key) { return get(root, key); }

    // value associated with the given key in subtree rooted at x; null if no such key
    private Value get(Node x, T key) {
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if      (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else              return x.val;
        }
        return null;
    }
    
    // is there a key-value pair with the given key?
    public boolean contains(Key key) {
        return (get(key) != null);
    }
    
    // is there a key-value pair with the given key in the subtree rooted at x?
    private boolean contains(Node x, Key key) {
        return (get(x, key) != null);
    }
    
	public class rbtIterator implements Iterator<Node> {

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Node next() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	/**
	 * 
	 */
	public RedBlackTree() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
