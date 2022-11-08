package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Application {
    final static int NUMBER_MIN = 1;
    final static int NUMBER_MAX = 9;

    final static int GAME_PROGRESS = 0;
    final static int GAME_RESTART = 1;
    final static int GAME_END = 2;

    final static int STRIKE_MAX = 3;

    final static String STRING_STRIKE = "스트라이크";
    final static String STRING_BALL = "볼";
    final static String STRING_NOTHING = "낫싱";

    public static ArrayList<Integer> SelectNumbers() {
        ArrayList<Integer> numbers = new ArrayList<>();  // numbers chosen by computer

        while ( numbers.size() < 3 ) {
            Integer number = Randoms.pickNumberInRange(NUMBER_MIN, NUMBER_MAX);

            if ( !numbers.contains(number) ) {
                numbers.add(number);
            }
        }

        return numbers;
    }

    public static void CheckExceptionInputNumber(String numbers) {
        if (numbers.length() != 3) {
            throw new IllegalArgumentException("[Invalid] size of the number");
        }

        for(int i = 0; i < (numbers.length() ); ++i) {
            if ( -1 != numbers.indexOf(numbers.charAt(i), i+1) ) {
                throw new IllegalArgumentException("[Invalid] the same value");
            }
            if ( Integer.valueOf(numbers.charAt(i)) == '0' ) {
                throw new IllegalArgumentException("[Invalid] the zero value");
            }
        }
    }

    public static ArrayList<Integer> ConvertStringToIntegerArray(String stringNumbers) {
        CheckExceptionInputNumber(stringNumbers);
        Integer integerNumber = Integer.valueOf(stringNumbers);  // occur argument exception if have non-number

        ArrayList<Integer> numbers = new ArrayList<>();  // numbers chosen by user

        while ( integerNumber > 0 ) {
            numbers.add(0, integerNumber % 10);
            integerNumber /= 10;
        }

        return numbers;
    }

    public static HashMap<String, Integer> JudgeNumber(ArrayList<Integer> computerNumbers
            , ArrayList<Integer> inputNumbers) {
        HashMap<String, Integer> resultMap = new HashMap<>();  // Map included the information about strike, ball, out

        for(int i = 0; i < inputNumbers.size(); ++i) {
            int indexComputerNumber = computerNumbers.indexOf( inputNumbers.get(i) );
            if ( i == indexComputerNumber ) {
                resultMap.put(STRING_STRIKE, resultMap.getOrDefault(STRING_STRIKE, 0) + 1);
            }
            else if ( -1 != indexComputerNumber ) {
                resultMap.put(STRING_BALL, resultMap.getOrDefault(STRING_BALL, 0) + 1);
            }
        }

        return resultMap;
    }

    public static void DropHintToUser(HashMap<String, Integer> resultMap) {
        if (resultMap.isEmpty()) {
            System.out.println(STRING_NOTHING);
        }
        else {
            List<String> keyList = new ArrayList<>(resultMap.keySet());
            keyList.sort(String::compareTo);  // sort by key before printing hints
            for (String key : keyList) {
                System.out.print( resultMap.get(key) + key + " " );
            }
            System.out.println(" ");
        }
    }

    public static int ProvideGameResultToUser(HashMap<String, Integer> resultMap) {
        int gameStatus = GAME_PROGRESS;

        DropHintToUser(resultMap);

        if( resultMap.containsKey(STRING_STRIKE) ) {
            if (STRIKE_MAX == resultMap.get(STRING_STRIKE)) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                gameStatus = Integer.valueOf(Console.readLine());
            }
        }

        return gameStatus;
    }

    public static void BaseballGame() {
        int gameStatus = GAME_PROGRESS;

        ArrayList<Integer> computerNumbers = SelectNumbers();

        while ( GAME_END != gameStatus ) {
            System.out.print("숫자를 입력해주세요 : ");
            String stringNumbers = Console.readLine();
            ArrayList<Integer> inputNumbers = ConvertStringToIntegerArray( stringNumbers );

            HashMap<String, Integer> resultMap = JudgeNumber( computerNumbers, inputNumbers );

            gameStatus = ProvideGameResultToUser(resultMap);
            if( GAME_RESTART == gameStatus ) {
                computerNumbers = SelectNumbers();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("숫자 아구 게임을 시작합니다.");

        BaseballGame();

        System.out.println("게임 종료");
    }
}
