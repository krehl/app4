package exercise.adt;
import algebra.number.*;

public class BinarySearchTree<T extends Comparable<T>> {
	
	protected BinarySearchTree<T> p;
	protected BinarySearchTree<T> left,right;
	protected T key;
	
	public BinarySearchTree() {
		p = null; left = null; right = null; key = null;
	}
	
	public void set(BinarySearchTree<T> z){
		this.p = z.p;
		this.left = z.left;
		this.right = z.right;
		this.key = z.key;
	}
	
	public BinarySearchTree(T comp) {
		this();
		key = comp;
	}
	
	public BinarySearchTree<T> getChild(int i) {
		if (i==0) return left;
		if (i==1) return right;
		throw new IndexOutOfBoundsException("0 = left, 1 = right.");
	}
	
	public BinarySearchTree<T> getP() {
		return this.p;
	}
	
	public BinarySearchTree<T> getLeft(){
		return left;
	}
	
	public BinarySearchTree<T> getRight(){
		return right;
	}
	
	public Comparable<T> getKey() {
		return this.key;
	}
	
	//toString und find funktionieren nicht ganz
	@Override
	public String toString() {
		if (this == null) {
			return "";
		} else {
			String s = "(";
			if (this.left != null) s += this.left.toString();
			if (this.key != null) s += this.key.toString();
			if (this.right != null) s += this.right.toString();
			return s + ")";
		}
	}
	
	public BinarySearchTree<T> find(T k) {
		BinarySearchTree<T> x = this;
		while ((x != null) && (x.key.compareTo(k) != 0)) {
			if (k.compareTo(x.key) == -1) {
				x = x.left;
			} else {
				x = x.right;
			}
		}
		if (x == null) {
			return null;
		} else {
			return x;
		}
	}
	
	public BinarySearchTree<T> search(T comp) {
		int compare_result = this.key.compareTo(comp);
		if ( compare_result > 0) return this.left.search(comp);
		if ( compare_result < 0) return this.right.search(comp);
		if ( compare_result == 0) return this;
		return null;
	}
	
	public BinarySearchTree<T> recursive_parent(){
		if(this.p!=null) {return this.p.recursive_parent();};
		return this;
	}
	
	public BinarySearchTree<T> recursive_left(){
		if(this.left!=null) {return this.left.recursive_left();};
		return this;
	}
	
	public BinarySearchTree<T> recursive_right(){
		if(this.right!=null) {return this.right.recursive_right();};
		return this;
	}
	
	/* Iterative Suche nach T */
	public void insert(T comp) {
		BinarySearchTree<T> z = new BinarySearchTree<T>(comp);
		BinarySearchTree<T> x = this;
		BinarySearchTree<T> y = null;
		if (x.key == null) {
			this.set(z);
			return;
		}
		while (x != null) {
			y = x;
			if (z.key.compareTo(x.key) == 0) { //Abfangen, falls der Wert schon vorhanden ist
				throw new IllegalArgumentException("Schon vorhanden");
				}
			if (z.key.compareTo(x.key) == -1) {
				x = x.left;
			} else {
				x = x.right;
			}
		}
		z.p = y;
		if (y==null) {
			this.set(z);
		} else {
			if (z.key.compareTo(y.key) == -1) {
				y.left = z;
			} else {
				y.right = z;
			}
		}
	}
	
	public void remove(BinarySearchTree<T> tree) {
		BinarySearchTree<T> deletenode = tree;
		if (deletenode == null) {
			throw new IllegalArgumentException("Wert nicht im Baum vorhanden");
			//return this; //Wird nicht mehr erreicht
		}
		if (deletenode.left == null && deletenode.right == null) {
			if (deletenode.p.left == deletenode) {
				deletenode.p.left = null;
				return;
			} else {
				deletenode.p.right = null;
				return;
			}
		}
		if (deletenode.right != null && deletenode.left == null) {
			//Search smallest
			deletenode.right.p = deletenode.p;
			if (deletenode.p.left == deletenode) {
				deletenode.p.left = deletenode.right;
				return;
			} else {
				deletenode.p.right = deletenode.left;
				return;
			}
			
		} else if(deletenode.left != null && deletenode.left == null){
			//Search largest
			deletenode.left.p = deletenode.p;
			if (deletenode.p.left == deletenode) {
				deletenode.p.left = deletenode.right;
				return;
			} else {
				deletenode.p.right = deletenode.left;
				return;
			}
		}
		//Der zu entfernende Knoten hat also zwei Kinder
		BinarySearchTree<T> change = deletenode.right.recursive_left();
		//T tmp = change.key;
		deletenode.key = change.key;
		this.remove(change);
		//deletenode.key = tmp;
		return;
		//return this;
	}
	
	
	public void remove(T comp) {
		BinarySearchTree<T> deletenode = this.find(comp);
		this.remove(deletenode);
		return;
	}	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinarySearchTree<CompRational> bst = new BinarySearchTree<CompRational>();
		System.out.println(bst.toString());
		bst.insert(new CompRational(5));System.out.println(bst.toString());
		bst.insert(new CompRational(1));System.out.println(bst.toString());
		bst.insert(new CompRational(3));System.out.println(bst.toString());
		bst.insert(new CompRational(8));System.out.println(bst.toString());
		bst.insert(new CompRational(6));System.out.println(bst.toString());
		bst.insert(new CompRational(4));System.out.println(bst.toString());
		bst.insert(new CompRational(7));System.out.println(bst.toString());
		bst.insert(new CompRational(2));System.out.println(bst.toString());
		bst.insert(new CompRational(9));
		System.out.println(bst.toString());
		System.out.println(bst.find(new CompRational(3)));
		bst.remove(new CompRational(3));System.out.println(bst.toString());
		bst.remove(new CompRational(5));System.out.println(bst.toString());
		bst.remove(new CompRational(8));System.out.println(bst.toString());
		//BinarySearchTree<CompRational> x = bst.find(new CompRational(3));
		//System.out.println(x.toString());
	}

}
