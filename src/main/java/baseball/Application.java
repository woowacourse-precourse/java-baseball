package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.Map;

public class Application {

    public static final String BALL = "볼";
    public static final String STRIKE = "스트라이크";
    public static final String NOTHING = "낫싱";

    public static Integer answer;
    public static String result;

    public static void main(String[] args) {

        Computer computer = new Computer();
        answer = 1;

        while(answer != 2){
            computer.selectUniqueNumbers();
            Player player = new Player();

            StartGame(computer, player);
        }
    }

    public static void StartGame(Computer computer, Player player){
        result = "";
        while(true) {
            String s = Console.readLine();
            player.input(s);

            Map<String, Integer> scoreMap = Controller.calcScore(computer, player);

            if (scoreMap.containsKey(NOTHING)) {
                System.out.println(NOTHING);
            } else {

                if (scoreMap.containsKey(BALL)) {
                    result += scoreMap.get(BALL) + "볼";
                }

                if (scoreMap.containsKey(STRIKE)) {
                    if (result.length() == 0) {
                        result += scoreMap.get(STRIKE) + "스트라이크";
                    } else {
                        result += " " + scoreMap.get(STRIKE) + "스트라이크";
                    }

                    if (scoreMap.get(STRIKE) == 3) {
                        System.out.println(result);
                        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                        answer = Integer.valueOf(Console.readLine());
                        break;
                    }
                }

                System.out.println(result);
            }
        }
    }
}
