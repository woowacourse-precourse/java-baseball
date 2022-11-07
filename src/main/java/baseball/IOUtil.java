package baseball;

import static baseball.State.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class IOUtil {

    public static List<Integer> getNumbersFromPlayer() {
        // TODO : console try catch
        System.out.print("숫자를 입력해주세요 : ");
        String str = Console.readLine();
        List<Integer> playerNumbers = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char digit = str.charAt(i);
            if (!Character.isDigit(digit)) {
                throw new IllegalArgumentException("숫자가 아닙니다.");
            }
            playerNumbers.add(Character.getNumericValue(digit));
        }
        validateNumbers(playerNumbers);

        return playerNumbers;
    }

    public static int getMenuSelectOption() {
        try {
            String str = Console.readLine();
            int option = Integer.parseInt(str);
            if (option != 1 && option != 2) {
                throw new IllegalArgumentException();
            }
            return option;
        } catch (Exception e) {
            throw new IllegalArgumentException("올바르지 않은 입력입니다.");
        }
    }

    private static void validateNumbers(List<Integer> numbers) {
        if (numbers.size() == 0 || numbers.size() > 3) {
            throw new IllegalArgumentException("잘못된 크기입니다.");
        }
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != numbers.size()) {
            throw new IllegalArgumentException("중복된 값이 존재합니다.");
        }
    }

    public static void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printExitMenuMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void printMapToConsole(Map<State, Integer> resultMap) {
        if (resultMap.containsKey(NOTHING) && resultMap.get(NOTHING) == 3) {
            System.out.println(NOTHING);
            return;
        }
        StringBuilder sb = new StringBuilder();
        printState(resultMap, BALL, sb);
        printState(resultMap, STRIKE, sb);
        System.out.println(sb);
    }

    private static void printState(Map<State, Integer> resultMap, State state, StringBuilder sb) {
        if (sb.length() != 0) sb.append(" ");
        if (resultMap.containsKey(state)) {
            sb.append(resultMap.get(state)).append(state);
        }
    }

}
