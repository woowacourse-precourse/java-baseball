package domain;

public class BaseballNumber {
    private final int number;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;

    private BaseballNumber(int number){
        this.number = number;
        validateRange();
    }

    public static BaseballNumber valueOf(int number){
        return new BaseballNumber(number);
    }

    public static BaseballNumber valueOf(String number){
        try{
            Integer.parseInt(number);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
        return new BaseballNumber(Integer.parseInt(number));
    }

    void validateRange(){
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
