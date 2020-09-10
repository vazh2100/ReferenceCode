package jav;

public class Perechisleniya {

    enum Color {

        RED("0001023"), BLUE("fdfdfdf");

        private String code;

        Color(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }

}
