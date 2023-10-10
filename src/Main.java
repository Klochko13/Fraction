public class Main {
    public static void main(String[] args) {

        Fraction D = new Fraction(2,3,4);

        Fraction C = new Fraction(2,4,6);

        Fraction F = new Fraction(D.add(C));
        System.out.print("Рузультат сложения дробей: ");
        F.print();

        F = new Fraction(D.sub(C));
        System.out.print("Результат вычетание дробей: ");
        F.print();

        F = new Fraction(D.mul(C));
        System.out.print("Результат умножения дробей: ");
        F.print();

        F = new Fraction(D.div(C));
        System.out.print("Результат деления дробей: ");
        F.print();


        Fraction Q = new Fraction(D.compareTo(C));
        System.out.print("Результат сравнения дробей: ");
        Q.printCompare();

        D.increment();
        System.out.print("Результат увеличения целой части дроби: ");
        D.print();

        C.decrement();
        System.out.print("Результат уменьшения целой части дроби: ");
        C.print();
    }
}




