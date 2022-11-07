package baseball.model.number;

import static baseball.model.Constant.END_NUMBER_RANGE;
import static baseball.model.Constant.INPUT_IS_NOT_NUMBER_EXCEPTION;
import static baseball.model.Constant.OUT_OF_RANGE_NUMBER_EXCEPTION;
import static baseball.model.Constant.START_NUMBER_RANGE;

public class BaseballNumber {
    Integer ballNumber;

    BaseballNumber(char ballNumber) {
        validateNumberCharacter(ballNumber);
        validateNumberRange(ballNumber);
        this.ballNumber = convertCharToInteger(ballNumber);
    }

    BaseballNumber(Integer ballNumber) {
        this.ballNumber = ballNumber;
    }

    private void validateNumberCharacter(char uncheckNumber) {
        if (!Character.isDigit(uncheckNumber)) {
            throw new IllegalArgumentException(INPUT_IS_NOT_NUMBER_EXCEPTION);
        }
    }

    private void validateNumberRange(char uncheckNumber) {
        int uncheckInteger = Character.getNumericValue(uncheckNumber);
        if(uncheckInteger < START_NUMBER_RANGE || uncheckInteger > END_NUMBER_RANGE) {
            throw new IllegalArgumentException(OUT_OF_RANGE_NUMBER_EXCEPTION);
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
