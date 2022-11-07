package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static baseball.SystemMessage.*;

public class Player {
    public static List<Integer> splitAnswer(String number){
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < number.length(); i++){
            list.add((int)number.charAt(i)-'0');
        }
        return list;
    }
    public static List<Integer> getAnswer(){
        System.out.print(SystemMessage.REQUEST_INPUT_NUMBER);
        String inputNumber = Console.readLine();
        validateNumber(inputNumber);

        return splitAnswer(inputNumber);
    }

    private static void validateNumber( String inputNumber ) {
        HashSet<Character> duplicateNumber = new HashSet<>();

        if ( inputNumber.length() != 3 ) {
            throw new IllegalArgumentException( INVALID_LENGTH );
        }

        for( int idx = 0; idx < 3; idx++) {
            char number = inputNumber.charAt(idx);
            if ( number < (char) ( 1 + '0' ) || number > ( 9 + '0' ) ) {
                throw new IllegalArgumentException( INVALID_NUMBER );
            }

            if ( !duplicateNumber.add(number) ) {
                throw new IllegalArgumentException( DUPLICATE_NUMBER );
            }
        }
    }
}
