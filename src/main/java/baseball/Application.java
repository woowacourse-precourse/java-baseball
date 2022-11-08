package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ArrayList<Integer> computerNumbers = getRandomNumbers();

        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            checkInput(input);
            String resultString = getResult(computerNumbers, input);
            System.out.println(resultString);

            if (resultString.equals("3스트라이크")) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String newGame = Console.readLine();
                if (newGame.equals("2")) break;
                computerNumbers = getRandomNumbers();
            }
        }
    }

    public static String getResult(ArrayList<Integer> computerNumbers, String input) {
        int ball = 0;
        int strike = 0;
        for (int index = 0; index < 3; index++) {
            int inputNumAtIndex = input.charAt(index) - '0';
            if (computerNumbers.get(index) == inputNumAtIndex) strike++;
            else if (computerNumbers.contains(inputNumAtIndex)) ball++;
        }
        String result = makeResultString(ball, strike);
        return result;
    }

    public static String makeResultString(int ball, int strike) {
        if (ball == 0 && strike == 0) return "낫싱";

        String result = "";
        if (ball != 0) result += ball + "볼 ";
        if (strike != 0) result += strike + "스트라이크";
        return result;
    }

    public static void checkInput(String input) {
        int num = Integer.parseInt(input);
        if (num < 123 || num > 987) throw new IllegalArgumentException();
        HashSet<Character> eachNums = new HashSet<>();

        // 각 자리 수에 0이 있는지 확인.
        if (eachNums.contains('0')) throw new IllegalArgumentException();

        // 각 자리 수에 중복이 있는지 확인.
        for (int i = 0; i < input.length(); i++) {
            eachNums.add(input.charAt(i));
        }
        if (eachNums.size() != 3) throw new IllegalArgumentException();
    }

    public static ArrayList<Integer> getRandomNumbers() {
        ArrayList<Integer> threeRandomNumbers = new ArrayList<>(3);
        while (threeRandomNumbers.size() < 3) {
            int num = Randoms.pickNumberInRange(1, 9);
            insertNumber(threeRandomNumbers, num);
        }
        return threeRandomNumbers;
    }

    private static void insertNumber(ArrayList<Integer> threeRandomNumbers, int num) {
        if (!threeRandomNumbers.contains(num))
            threeRandomNumbers.add(num);
    }
}
