package jav;

import java.util.Scanner;

public class Vvod {
//АПример ввода информации на java
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        System.out.print("Введите имя: ");
        String name = in.nextLine();
        System.out.print("Введите возраст: ");
        int age = in.nextInt();
        System.out.printf("Имя: %s\nВозраст: %d", name, age);
        in.close();
        int a = 5;
        System.out.println(a);
    }
}
