package baseball.domain.number;

import baseball.util.GameNumberConst;
import java.util.Objects;

public class GameNumber {

    private static final char MIN_GAME_NUMBER_CHAR_VALUE = '1';
    private static final char MAX_GAME_NUMBER_CHAR_VALUE = '9';
    private static final char DEFAULT_NUMBER_CHAR_VALUE = '0';
    private static final String WRONG_SIZE = "허용되지 않는 정답 길이입니다.";
    private static final String WRONG_NUMBER = "허용되지 않는 숫자입니다.";

    private final int number;
    private final int index;

    public GameNumber(int number, int index) {
        validateIndex(index);
        validateNumber(number);

        this.number = number;
        this.index = index;
    }

    public GameNumber(char numberCharacter, int index) {
        validateIndex(index);
        validateCharacterNumber(numberCharacter);

        this.number = numberCharacter - DEFAULT_NUMBER_CHAR_VALUE;
        this.index = index;
    }

    private void validateIndex(int index) {
        if (index >= GameNumberConst.MAX_GAME_NUMBER_SIZE) {
            throw new IllegalArgumentException(WRONG_SIZE);
        }
    }

    private void validateNumber(int number) {
        if (!validateNumberRange(number)) {
            throw new IllegalArgumentException(WRONG_NUMBER);
        }
    }

    private boolean validateNumberRange(int number) {
        return GameNumberConst.MIN_GAME_NUMBER_VALUE <= number && number <= GameNumberConst.MAX_GAME_NUMBER_VALUE;
    }

    private void validateCharacterNumber(char numberCharacter) {
        if (!validateCharacterNumberRange(numberCharacter)) {
            throw new IllegalArgumentException(WRONG_NUMBER);
        }
    }

    private boolean validateCharacterNumberRange(char numberCharacter) {
        return MIN_GAME_NUMBER_CHAR_VALUE <= numberCharacter && numberCharacter <= MAX_GAME_NUMBER_CHAR_VALUE;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        GameNumber otherGameNumber = (GameNumber) object;
        return this.number == otherGameNumber.number && this.index == otherGameNumber.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, index);
    }

    public boolean equalsWithoutIndex(GameNumber gameNumber) {
        return this.number == gameNumber.number && this.index != gameNumber.index;
    }
}
