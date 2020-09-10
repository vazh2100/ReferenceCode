package jav;

public class Sesons {

    private static String month;
    private static String season;

    public static void main(String[] args) {
        month = "Апрель";
        switch (month) {
            case "Декабрь":
            case "Январь":
            case "Февраль": season = "Зима"; break;
            case "Март":
            case "Апрель":
            case "Май": season = "Весна"; break;
            case "Июнь":
            case "Июль":
            case "Август": season = "Лето"; break;
            case "Сентябрь":
            case "Октябрь":
            case "Ноябрь": season = "Осень"; break;
            default: season = "Некоректный месяц";
        }
        System.out.println(season);
    }
}
