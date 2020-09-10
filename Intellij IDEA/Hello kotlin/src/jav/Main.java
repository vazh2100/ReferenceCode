package jav;

public class Main {
    private static String name = null;

    private static int money =600;
    private static String food;

    public static void main(String[] args) {
        if (money>500){
            food = "Пицца";
        } else if (money>200) {
            food = "Shaurma";
        }else{food = "Doshirak";}

        System.out.println("Vi mozhete pozvolit' sebe "+ food);
    }
}
