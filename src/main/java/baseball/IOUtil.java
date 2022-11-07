package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static org.assertj.core.api.Assertions.assertThat;

public class IOUtil {

    public static List<Integer> getNumbersFromPlayer() {
        String str = Console.readLine();
        List<Integer> playerNumbers = new ArrayList<>();
        for ( int i=0 ; i<str.length() ; i++) {
            char digit = str.charAt(i);
            if (!Character.isDigit(digit)) throw new IllegalArgumentException("숫자가 아닙니다.");
            playerNumbers.add(Character.getNumericValue(digit));
        }
        validateNumbers(playerNumbers);

        return playerNumbers;
    }

    private static void validateNumbers(List<Integer> numbers) {
        if (numbers.size() == 0 || numbers.size() > 3) throw new IllegalArgumentException("잘못된 크기입니다.");
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != numbers.size()) throw new IllegalArgumentException("중복된 값이 존재합니다.");
    }

}
