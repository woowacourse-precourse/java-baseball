package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    static int playerAnswer = 0;

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        do {
            System.out.println("숫자 야구 게임을 시작합니다.");
            List<Integer> computer = computer();
            //System.out.println(computer);

            int[] gameResult = new int[2];
            gameResult[1] = 0;
            while (gameResult[1] != 3) {
                List<Integer> playerNumber = playerNumber();

                gameResult = gameResult(computer, playerNumber);

                gameResultPrint(gameResult);
            }

            if(!(playerAnswer == 1 || playerAnswer == 2)) {
                throw new IllegalArgumentException("Wrong Number");
            }

        } while (playerAnswer != 2);


    }

    // 컴퓨터의 숫자 생성
    public static List<Integer> computer() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    // 플레이어의 숫자 입력
    public static List<Integer> playerNumber() {
        List<Integer> playerNumber = new ArrayList<>();
        int[] playerNumArr = new int[3];

        System.out.print("숫자를 입력해주세요 : ");
        String numberStr = Console.readLine();

        // 3개의 숫자가 아닐 때
        if(numberStr.length() != 3) {
            throw new IllegalArgumentException("Not Three Number");
        }

        for(int i = 0; i < 3; i++) {
            playerNumArr[i] = Integer.parseInt(numberStr.substring(i, i + 1));

            // 1에서 9까지가 아닐 때
            if(!(playerNumArr[i] >= 1 && playerNumArr[i] <= 9)) {
                throw new IllegalArgumentException("Wrong Number");
            }

            // 서로 다른 임의의 수가 아닐 때
            if(i != 0 && (playerNumArr[i] == playerNumArr[i - 1])) {
                throw new IllegalArgumentException("Same Number");
            }

            playerNumber.add(playerNumArr[i]);
        }

        return playerNumber;
    }

    // 플레이어 숫자의 게임 결과 생성
    public static int[] gameResult(List<Integer> computer, List<Integer> playerNumber) {
        int[] gameResult = new int[2];
        
        for(int i = 0; i < playerNumber.size(); i++) {

            // 볼
            if(computer.contains(playerNumber.get(i)) && (computer.get(i) != playerNumber.get(i))) {
                gameResult[0]++;
            }
            
            // 스트라이크 
            if(computer.get(i) == playerNumber.get(i)) {
                gameResult[1]++;
            }

        }

        return gameResult;
    }

    // 플레이어 숫자의 게임 결과 출력
    public static void gameResultPrint(int[] gameResult) {
        if(gameResult[0] != 0 && gameResult[1] != 0) {
            System.out.println(gameResult[0] + "볼 " + gameResult[1] + "스트라이크");
        } else if (gameResult[0] == 0 && gameResult[1] != 0 && gameResult[1] != 3) {
            System.out.println(gameResult[1] + "스트라이크");
        } else if (gameResult[0] != 0 && gameResult[1] == 0) {
            System.out.println(gameResult[0] + "볼");
        } else if (gameResult[1] == 3) {
            threeStrike();
        } else if (gameResult[0] == 0 && gameResult[1] == 0) {
            System.out.println("낫싱");
        }
    }

    // 3스트라이크일 때
    public static int threeStrike() {
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        playerAnswer = Integer.parseInt(Console.readLine());

        return playerAnswer;
    }

}
