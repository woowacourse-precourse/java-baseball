package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.Map;

public class Application {

    public static final String BALL = "볼";
    public static final String STRIKE = "스트라이크";
    public static final String NOTHING = "낫싱";

    public static final int RESTART = 1;
    public static final int FINISH = 2;

    public static final int LENGTH = 3;

    public static void main(String[] args) {

        Computer computer = new Computer();

        while(true){
            computer.selectUniqueNumbers();
            Player player = new Player();

            int isContinue = StartGame(computer, player);
            if(isContinue == RESTART){
                continue;
            }

            if(isContinue == FINISH){
                break;
            }
        }
    }

    public static Integer StartGame(Computer computer, Player player) {
        while (true) {
            String s = Console.readLine();
            player.input(s);

            Map<String, Integer> scoreMap = Controller.calcScore(computer, player);

            printScore(scoreMap);

            if (scoreMap.containsKey(STRIKE) && scoreMap.get(STRIKE) == LENGTH) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                int answer = Integer.parseInt(Console.readLine());
                // 이후 검증 추가할 것

                return answer;
            }
        }
    }

    public static void printScore(Map<String, Integer> scoreMap){
        String result = "";

        if (scoreMap.containsKey(NOTHING)) {
            System.out.println(NOTHING);
            return;
        }

        if (scoreMap.containsKey(BALL)) {
            result += scoreMap.get(BALL) + "볼";
        }

        if (scoreMap.containsKey(STRIKE)) {
            if (result.length() == 0) {
                result += scoreMap.get(STRIKE) + "스트라이크";
            } else {
                result += " " + scoreMap.get(STRIKE) + "스트라이크";
            }
        }

        System.out.println(result);
    }
}
