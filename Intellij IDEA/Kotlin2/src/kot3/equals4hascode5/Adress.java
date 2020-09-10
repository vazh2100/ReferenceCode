package kot3.equals4hascode5;

import java.util.Objects;

public class Adress {
    private String city;
    private String street;
    private int number;

    public Adress(String city, String street, int number) {
        this.city = city;
        this.street = street;
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

//    @Override
//    public boolean equals(Object obj) {
//
//        if(this == obj){
//            return true;
//        }
//        if(hashCode()!=obj.hashCode()){
//            return false;
//        }
//        if (obj instanceof Adress) {
//            Adress adress = (Adress) obj;
//            return this.city.equals(adress.city) && this.street.equals(adress.street) && this.number == adress.number;
//        }
//        return false;
//    }
//
//    @Override
//    public int hashCode() {
//        return city.hashCode()+street.hashCode()+number;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Adress adress = (Adress) o;
        return number == adress.number &&
                Objects.equals(city, adress.city) &&
                Objects.equals(street, adress.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, number);
    }
}

