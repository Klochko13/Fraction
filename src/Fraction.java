import org.jetbrains.annotations.NotNull;
public class Fraction {
    private int integer; //  целая часть
    private int numerator; // числитель
    private int denominator; // знаменатель

    public int getInteger() {
        return integer;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setInteger(int integer) {
        this.integer = integer;
    }

    public void setDenominator(int denominator) {
        if (denominator == 0)
            denominator = 1;
        this.denominator = denominator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    //                Constructors
    public Fraction() {
        setDenominator(1);
        System.out.println("DefaultConstructor:" + this.hashCode());
    }

    public Fraction(int integer) {
        setInteger(integer);
        setNumerator(0);
        setDenominator(1);
        System.out.println("1ArgConstructor:\t" + this.hashCode());
    }

    public Fraction(int numerator, int denominator) {
        setInteger(0);
        setNumerator(numerator);
        setDenominator(denominator);
        System.out.println("Constructor:" + this.hashCode());
    }

    public Fraction(int integer, int numerator, int denominator) {
        setInteger(integer);
        setNumerator(numerator);
        setDenominator(denominator);
    }

    public Fraction(Fraction other) {
        this.integer = other.integer;
        this.numerator = other.numerator;
        this.denominator = other.denominator;
        System.out.println("CopyConstructor:\t" + this.hashCode());
    }


    //                Methods

    void print() {
        if (integer != 0)
            System.out.print(integer);
        if (numerator != 0) {
            if (integer != 0) System.out.print("(");
            System.out.print(numerator + "/" + denominator);
            if (integer != 0) System.out.println(")");
        } else if (integer == 0) {
            System.out.print(0);
        }
        System.out.println();


    }

    public Fraction add(Fraction fraction) {
        int new_integer;
        int new_denominator=this.denominator;
        int new_numerator;
        int new_numerator1 = this.integer * this.denominator + this.numerator;
        int new_numerator2 = fraction.integer * fraction.denominator + fraction.numerator;

        if (this.denominator != fraction.denominator) {
            new_denominator = this.denominator * fraction.denominator;
        }
        new_numerator = (new_numerator1 * fraction.denominator) + (new_numerator2*this.denominator);
        new_integer = new_numerator / new_denominator;
        new_numerator %= new_denominator;

        return new Fraction(new_integer, new_numerator/euclidsAlgorithm(new_numerator, new_denominator),
                new_denominator/euclidsAlgorithm(new_numerator, new_denominator));
    }
    public Fraction add1(Fraction left, Fraction right) {
        int new_integer;
        int new_denominator=left.denominator;
        int new_numerator;
        int new_numerator1 = left.integer * left.denominator + left.numerator;
        int new_numerator2 = right.integer * right.denominator + right.numerator;

        if (left.denominator != right.denominator) {
            new_denominator = left.denominator * right.denominator;
        }
        new_numerator = (new_numerator1 * right.denominator) + (new_numerator2*left.denominator);
        new_integer = new_numerator / new_denominator;
        new_numerator %= new_denominator;

    Fraction new_fraction = new Fraction(new_integer, new_numerator/euclidsAlgorithm(new_numerator, new_denominator),
            new_denominator/euclidsAlgorithm(new_numerator, new_denominator));
        return new_fraction.add(right);

    }

    public Fraction sub(Fraction fraction) {

        int new_integer;
        int new_denominator = this.denominator;
        int new_numerator;
        int new_numerator1 = this.integer * this.denominator + this.numerator;
        int new_numerator2 = fraction.integer * fraction.denominator + fraction.numerator;

        if (this.denominator != fraction.denominator) {
            new_denominator = this.denominator * fraction.denominator;
        }
        new_numerator = new_numerator1 * fraction.denominator - new_numerator2*this.denominator;
        new_integer = new_numerator / new_denominator;
        new_numerator %= new_denominator;

        return new Fraction(new_integer, new_numerator/euclidsAlgorithm(new_numerator, new_denominator),
                new_denominator/euclidsAlgorithm(new_numerator, new_denominator));
    }
    public Fraction sub1(Fraction fraction) {

        int new_integer;
        int new_denominator = this.denominator;
        int new_numerator;
        int new_numerator1 = this.integer * this.denominator + this.numerator;
        int new_numerator2 = fraction.integer * fraction.denominator + fraction.numerator;

        if (this.denominator != fraction.denominator) {
            new_denominator = this.denominator * fraction.denominator;
        }
        new_numerator = new_numerator1 * fraction.denominator - new_numerator2*this.denominator;
        new_integer = new_numerator / new_denominator;
        new_numerator %= new_denominator;

        Fraction new_fraction = new Fraction(new_integer, new_numerator/euclidsAlgorithm(new_numerator, new_denominator),
                new_denominator/euclidsAlgorithm(new_numerator, new_denominator));

        return new_fraction.sub(fraction);
    }

    public Fraction mul (Fraction fraction) {

        int new_denominator = this.denominator * fraction.denominator;
        int new_numerator = (this.integer * this.denominator + this.numerator) * (fraction.integer * fraction.denominator + fraction.numerator);
        int new_integer= new_numerator / new_denominator;
        new_numerator %= new_denominator;

        return new Fraction(new_integer, new_numerator/euclidsAlgorithm(new_numerator, new_denominator),
                new_denominator/euclidsAlgorithm(new_numerator, new_denominator));
    }
    public Fraction mul1 (Fraction fraction) {
        //Fraction n_fraction = new Fraction();

        int new_denominator = this.denominator * fraction.denominator;
        int new_numerator = (this.integer * this.denominator + this.numerator) * (fraction.integer * fraction.denominator + fraction.numerator);
        int new_integer= new_numerator / new_denominator;
        new_numerator %= new_denominator;

        Fraction new_fraction = new Fraction(new_integer, new_numerator/euclidsAlgorithm(new_numerator, new_denominator),
                new_denominator/euclidsAlgorithm(new_numerator, new_denominator));

        return new_fraction.mul(fraction);

    }
    public Fraction div (Fraction fraction) {

        int new_numerator1 = this.integer * this.denominator + this.numerator;
        int new_numerator2 = fraction.integer * fraction.denominator + fraction.numerator;
        int new_numerator = new_numerator1 * fraction.denominator;
        int new_denominator = this.denominator * new_numerator2;
        int new_integer= new_numerator / new_denominator;
        new_numerator %= new_denominator;

        return new Fraction(new_integer, new_numerator/euclidsAlgorithm(new_numerator, new_denominator),
                new_denominator/euclidsAlgorithm(new_numerator, new_denominator));
    }
    public Fraction div1 (Fraction fraction) {

        int new_numerator1 = this.integer * this.denominator + this.numerator;
        int new_numerator2 = fraction.integer * fraction.denominator + fraction.numerator;
        int new_numerator = new_numerator1 * fraction.denominator;
        int new_denominator = this.denominator * new_numerator2;
        int new_integer= new_numerator / new_denominator;
        new_numerator %= new_denominator;

        Fraction new_fraction = new Fraction(new_integer, new_numerator/euclidsAlgorithm(new_numerator, new_denominator),
                new_denominator/euclidsAlgorithm(new_numerator, new_denominator));

        return new_fraction.div(fraction);
    }
    Fraction increment (){
        this.integer ++;
        return new Fraction();
    }
    Fraction decrement (){
        this.integer --;
        return new Fraction();
    }

    Fraction compareTo (Fraction fraction){

        int new_numerator1 = (this.integer * this.denominator + this.numerator) * fraction.denominator;
        int new_numerator2 = (fraction.integer * fraction.denominator + fraction.numerator) * this.denominator;


        if (new_numerator1 != new_numerator2)
            return new Fraction(1,1,1);
        else
            return new Fraction(2,2,2);
    }
    void printCompare() {
        if (this.integer == 1 && this.numerator == 1 && this.denominator == 1)
            System.out.println("Дроби не равны");
        else
            System.out.println("Дроби равны");
    }
    int euclidsAlgorithm(int n1, int n2) {

        if (n2 == 0) {
            return n1;
        }
        return euclidsAlgorithm(n2, n1 % n2);
    }
}