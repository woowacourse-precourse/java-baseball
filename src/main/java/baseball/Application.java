package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.Map;

public class Application {
    static final int FIXED_NUMBERS_LENGTH = 3;
    static final int RESTART = 1;
    static final int FINISH = 2;
    
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Integer answer = 1;


        while(answer == 1){

            Computer computer = new Computer();
            computer.init();
            System.out.println("computer = " + computer);

            Player player = new Player();

            while(true) {
                String s = Console.readLine();
                System.out.println(computer +  ", " +s);
                player.input(s);

                Map<String, Integer> scoreMap = computer.calcScore(player);

                if (scoreMap.containsKey("낫싱")) {
                    System.out.println("낫싱");
                } else {
                    String result = "";
                    if (scoreMap.containsKey("볼")) {
                        result += scoreMap.get("볼") + "볼";
                    }

                    if (scoreMap.containsKey("스트라이크")) {
                        if (result.length() == 0) {
                            result += scoreMap.get("스트라이크") + "스트라이크";
                        } else {
                            result += " " + scoreMap.get("스트라이크") + "스트라이크";
                        }

                        if (scoreMap.get("스트라이크") == 3) {
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
}
