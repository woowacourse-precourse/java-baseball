package baseball.game.exception;

import static baseball.game.Game.userNumbers;
import static baseball.game.Option.*;

public class ExceptionCase {
    private static void throwException(String text){
        throw new IllegalArgumentException(text);
    }

    public static void catchSizeException(String input){
        if(input.length()!=COUNT_BALL){
            throwException(COUNT_BALL + "개의 숫자를 입력하시오.");
        }
    }
}
