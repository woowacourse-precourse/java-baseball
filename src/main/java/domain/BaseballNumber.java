package domain;

public class BaseballNumber {
    private int number;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;

    private BaseballNumber(int number){
        this.number = number;
        validateNumber();
    }

    public static BaseballNumber valueOf(int number){
        return new BaseballNumber(number);
    }

    void validateNumber(){
        if(number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("1부터 9사이의 숫자를 입력해야합니다.");
        }
    }

    @Override
    public boolean equals(Object object) {
        if(object instanceof BaseballNumber){
            return this.number == ((BaseballNumber) object).number;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.number;
    }
}
