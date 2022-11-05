package baseball.model.number;

public class BaseballNumber {
    private static final String INPUT_IS_NOT_NUMBER = "입력은 숫자로 주어져야 합니다";
    Integer ballNumber;

    BaseballNumber(char ballNumber) {
        validateNumberCharacter(ballNumber);
        this.ballNumber = convertCharToInteger(ballNumber);
    }

    private void validateNumberCharacter(char uncheckNumber) {
        if (!Character.isDigit(uncheckNumber)) {
            throw new IllegalArgumentException(INPUT_IS_NOT_NUMBER);
        }
    }

    private Integer convertCharToInteger(char ballNumber) {
        Integer ballInteger = Character.getNumericValue(ballNumber);
        return ballInteger;
    }

    @Override
    public boolean equals(Object object) {
        if(!(object instanceof BaseballNumber)) {
            return false;
        }

        BaseballNumber otherBaseballNumber = (BaseballNumber) object;
        Integer otherBaseballValue = otherBaseballNumber.ballNumber;
        if(otherBaseballValue.equals(this.ballNumber)) {
            return true;
        }
        return false;
    }
}
