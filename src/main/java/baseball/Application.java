package baseball;

import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final int NUM_SIZE = 3;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameStart();
    }

    private static List<Integer> ComputerGenerate() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < NUM_SIZE) {
            AddComputerValue(computer);
        }
        return computer;
    }

    private static List<Integer> AddComputerValue(List<Integer> computer) {
        int randomNumber = Randoms.pickNumberInRange(1,9);
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber);
        }
        return computer;
    }

    private static List<Integer> UserGenerate() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        if (CheckInput(input)) {
            List<Integer> user = StringToList(input);
            return user;
        }
        throw new IllegalArgumentException("잘못된 입력");
    }

    private static List<Integer> StringToList(String input) {
        List<Integer> user = new ArrayList<>();
        for(int i=0; i<input.length(); i++)
            user.add(input.charAt(i) - '0');
        return user;
    }

    private static boolean CheckInput(String input) {
        if (isSize3(input) && isNotDuplicate(input) && isNumber(input) && isNotContain0(input)) {
            return true;
        }
        return false;
    }

    private static boolean isSize3(String input) {
        if (input.length() == 3){
            return true;
        }
        return false;
    }

    private static boolean isNotDuplicate(String input) {
        String checkinput = "";
        for (char charinput : input.toCharArray()) {
            if (checkinput.contains(String.valueOf(charinput))) {
                return false;
            }
            checkinput += String.valueOf(charinput);
        }
        return true;
    }

    private static boolean isNumber(String input) {
        for (char charinput : input.toCharArray()) {
            if (Character.isDigit(charinput) == false) {
                return false;
            }
        }
        return true;
    }

    private static boolean isNotContain0(String input) {
        if (input.contains("0")) {
            return false;
        }
        return true;
    }

    private static String Hint(List<Integer> computer, List<Integer> user) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i<NUM_SIZE; i++) {
            if (computer.get(i) == user.get(i)) {
                strike += 1;
                continue;
            }
            if (computer.contains(user.get(i))) {
                ball += 1;
            }
        }
        return (HintResult(strike,ball));
    }

    private static String HintResult(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            return ("낫싱");
        }
        if (strike == 3) {
            return ("3스트라이크");
        }
        if (strike == 0) {
            return (ball+"볼");
        }
        if (ball == 0) {
            return (strike+"스트라이크");
        }
        return (ball+"볼 "+strike+"스트라이크");
    }

    private static void GameRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int input = Integer.valueOf(Console.readLine());
        if (input == 1) {
            GameStart();
        }
    }

    private static void GameStart() {
        List<Integer> computer = ComputerGenerate();
        List<Integer> user = UserGenerate();
        System.out.println(computer);
        System.out.println(Hint(computer,user));

    }
}
