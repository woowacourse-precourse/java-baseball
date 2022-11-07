package baseball;

public class ThreeNumber {

    private String role;
    private Integer number1;
    private Integer number2;
    private Integer number3;

    public ThreeNumber() {
    }

    public ThreeNumber(String role, Integer number1, Integer number2, Integer number3) {
        this.role = role;
        this.number1 = number1;
        this.number2 = number2;
        this.number3 = number3;
    }

    public Integer getNumber1() {
        return number1;
    }

    public Integer getNumber2() {
        return number2;
    }

    public Integer getNumber3() {
        return number3;
    }
}
