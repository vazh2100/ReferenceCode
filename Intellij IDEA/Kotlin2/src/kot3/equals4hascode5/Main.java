package kot3.equals4hascode5;

public class Main {
    public static void main(String[] args) {
        Adress adress1 = new Adress("A","B", 1);
        Adress adress2 = new Adress("A","B", 1);
        System.out.println(adress1.equals(adress2));
        System.out.println(adress1.hashCode());
        System.out.println(adress2.hashCode());
    }
}
