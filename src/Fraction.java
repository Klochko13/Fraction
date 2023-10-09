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
        int new_denominator = this.denominator;
        int new_numerator = 0;
        this.numerator = this.integer * this.denominator + this.numerator;
        fraction.numerator = fraction.integer * fraction.denominator + fraction.numerator;

        if (this.denominator != fraction.denominator) {
            new_denominator = this.denominator * fraction.denominator;
            new_numerator = (this.numerator * fraction.denominator) + (fraction.numerator*this.denominator);
        }
        new_integer = new_numerator / new_denominator;
        new_numerator %= new_denominator;

        return new Fraction(new_integer, new_numerator, new_denominator);
    }
    public Fraction sub(Fraction fraction) {

        int new_integer;
        int new_denominator = this.denominator;
        int new_numerator = 0;
        this.numerator = this.integer * this.denominator + this.numerator;
        fraction.numerator = fraction.integer * fraction.denominator + fraction.numerator;

        if (this.denominator != fraction.denominator) {
            new_denominator = this.denominator * fraction.denominator;
            new_numerator = this.numerator * fraction.denominator - fraction.numerator*this.denominator;
        }
        new_integer = new_numerator / new_denominator;
        new_numerator %= new_denominator;

        return new Fraction(new_integer, new_numerator, new_denominator);
    }
}

