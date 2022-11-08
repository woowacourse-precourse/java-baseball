package baseball;

import camp.nextstep.edu.missionutils.*;

import java.util.ArrayList;
import java.util.List;

public class Application {
    // 컴퓨터의 랜덤한 숫자를 생성해서 반환
    private static List<Integer> getComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        int randomNumber = 0;
        while (computer.size() < 3) {
            randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    // ball, strike 판단해서 개수 증가한 정보 반환
    private static GameInfo getGameInfo(List<Integer> computer, String numStr) {
        GameInfo gameInfo = new GameInfo();
        for (int i = 0; i < 3; i++) {
            int num = numStr.charAt(i) - '0';
            if (computer.contains(num) && computer.get(i) == num)
                gameInfo.increaseStrike();
            else if (computer.contains(num))
                gameInfo.increaseBall();
        }
        return gameInfo;
    }

    // 입력받은 것의 길이가 3인지 확인
    private static boolean isLen3(String num) {
        if (num.length() == 3)
            return true;
        return false;
    }

    // 숫자를 입력했는지 확인
    private static boolean isNum(String num) {
        for (int i = 0; i < 3; i++) {
            if (num.charAt(i) < '0' || num.charAt(i) > '9')
                return false;
        }
        return true;
    }

    // 중복된 값을 입력했는지 확인
    private static boolean isDuplicated(String num) {
        for (int i = 0; i < 3; i++) {
            if (num.length() - num.replace(num.valueOf(i), "").length() != 2)
                return true;
        }
        return false;
    }

    // 입력받은 값이 유효한지 확인
    private static boolean isValid(String num) {
        if (isLen3(num) && isNum(num) && !isDuplicated(num))
            return true;
        return false;
    }

    private static void playGame() {
        List<Integer> computer = getComputerNumber();
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String num = Console.readLine();
            if (!isValid(num))
                throw new IllegalArgumentException();

            GameInfo gameInfo = getGameInfo(computer, num);
            String result = gameInfo.getResult();
            System.out.println(result);
            if (result.equals("3스트라이크")) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            playGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            if (Console.readLine().equals("2"))
                break;
        }
    }
}