package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        while (true) {
            게임종료_후_재시작();
            // 게임을 새로 시작하려면 1, 종료하려면 2를 입력
            if(종료확인()) break;
        }
    }

    public static Boolean 종료확인() {
        String sel = readLine();
        if (sel.equals("2")) {
            System.out.println("게임 종료");
            return true;
        }
        return false;
    }

    public static void 게임종료_후_재시작() {
        // 숫자 야구 게임 시작
        입력();
    }

    public static void 입력() {
        String comp = randomValue();
        Game game = new Game(comp);

        while (true) {
            String input = 예외_테스트();
            System.out.println(input);
            String output = game.카운트확인(input);
            if(checkOutput(output)) break;
        }
        game.clear();
    }

    public static boolean checkOutput(String output) {
        if (output.equals("3스트라이크")) {
            System.out.println("3스트라이크");
            // 3개의 숫자를 모두 맞춤
            return true;
        }
        System.out.println(output);
        return false;
    }

    public static String randomValue() {
        String result = "";
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
                result += randomNumber;
            }
        }
        return result;
    }

    public static String 예외_테스트() {
        String s = readLine();
        if (s.length() != 3) {
            throw new IllegalArgumentException();
        }
        return s;
    }
}
