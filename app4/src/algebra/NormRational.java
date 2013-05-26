package algebra;

public class NormRational extends Rational{

	public NormRational() {
		super();
	}
	
	public NormRational(long z) {
		super(z);
		this.kuerzen();
	}
	
	public NormRational(long z, long n) {
		super(z,n);
		this.kuerzen();
	}
	
	public NormRational(Rational r) {
		super(r);
		this.kuerzen();
	}
	
	public NormRational set(Rational r) {
		super.set(r);
		return this;
	}
	
	public NormRational (NormRational r) {
		this.setZaehler(r.getZaehler());
		this.setNenner(r.getNenner());
	}
	
	public NormRational add(NormRational r) {
		super.add(r).kuerzen();
		return this;
	}
	
	public NormRational mult(NormRational r) {
		super.mult(r).kuerzen();
		return this;
	}
	
	public NormRational sub(NormRational r) {
		super.sub(r).kuerzen();
		return this;
	}
	
	public NormRational div(NormRational r) {
		super.div(r).kuerzen();
		return this;
	}
	
	public static NormRational add(NormRational a, NormRational b) {
		return new NormRational(Rational.add(a,b).kuerzen());
	}
	
	public static NormRational mult(NormRational a, NormRational b) {
		return new NormRational(Rational.mult(a,b).kuerzen());
	}
	
	public static NormRational sub(NormRational a, NormRational b) {
		return new NormRational(Rational.sub(a,b).kuerzen());
	}
	
	public static NormRational div(NormRational a, NormRational b) {
		return new NormRational(Rational.div(a,b).kuerzen());
	}
	
	//Testmethode
	public static void print(Object Obj) {
		System.out.println(Obj.toString());
	}
	public static void main(String[] args) { //Testklasse aus Rational, hier nur mir NormRational
        NormRational x,y,z;
        x = new NormRational(-1);
        print(x);
        y = new NormRational(1,-2);
        print(y);
        z = new NormRational(-1,-2);
        print(z);
        z = x.sub(y);
        print(z);
		
		/*NormRational x, y, z;

        // 1/2 + 1/3 = 5/6
        x = new NormRational(1, 2);
        y = new NormRational(1, 3);
        z = x.add(y);
        System.out.println(z);

        // 8/9 + 1/9 = 1
        x = new NormRational(8, 9);
        y = new NormRational(1, 9);
        z = x.add(y);
        System.out.println(z);

        // 1/200000000 + 1/300000000 = 1/120000000
        x = new NormRational(1, 200000000);
        y = new NormRational(1, 300000000);
        z = x.add(y);
        System.out.println(z);

        // 1073741789/20 + 1073741789/30 = 1073741789/12
        x = new NormRational(1073741789, 20);
        y = new NormRational(1073741789, 30);
        z = x.add(y);
        System.out.println(z);

        //  4/17 * 17/4 = 1
        x = new NormRational(4, 17);
        y = new NormRational(17, 4);
        z = x.mult(y);
        System.out.println(z);

        // 3037141/3247033 * 3037547/3246599 = 841/961 
        x = new NormRational(3037141, 3247033);
        y = new NormRational(3037547, 3246599);
        z = x.mult(y);
        System.out.println(z);

        x = new NormRational( 841, 961);
        y = new NormRational( 3037547, 3246599);
        z = NormRational.div(x,y);
        System.out.println(z);
        
        
        // 1/6 - -4/-8 = -1/3
        x = new NormRational( 1,  6);
        y = new NormRational(-4, -8);
        z = x.sub(y);
        System.out.println(z);
        
        //1/4
        x = new NormRational( 1, 2);
        y = new NormRational( 2, 1);
        z = x.div(y);
        System.out.println(z);
        //1/4
        x = new NormRational( 1, 2);
        y = new NormRational( 2, 1);
        z = NormRational.div(x,y);
        System.out.println(z);
        //4
        x = new NormRational( 2, 1);
        y = new NormRational( 1, 2);
        z = x.div(y);
        System.out.println(z);
        //4
        x = new NormRational( 2, 1);
        y = new NormRational( 1, 2);
        z = NormRational.div(x,y);
        System.out.println(z);
        
        x = new NormRational(-1, 2);
        y = new NormRational(-1, -3);
        z = x.add(y);
        System.out.println(z.equals(new NormRational(-1,6)));*/
	}
}
