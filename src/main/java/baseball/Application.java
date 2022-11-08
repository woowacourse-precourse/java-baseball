package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

class Game {
    public Map<String, Integer> result;

    public Game() {
        result = new HashMap<>();
        result.put("strike", 0);
        result.put("ball", 0);
    }

    public void startGame() throws IllegalArgumentException{
        // 컴퓨터 객체
        Computer computer = new Computer();

        // 플레이어 객체 생성
        Player player = new Player();

        // 컴퓨터 랜덤 숫자 생성 ->
        computer.makeRandomNumber();
        System.out.println("컴퓨터 랜덤숫자 : " + computer.myNumberList);

        while (true) {
            // result 초기화
            resetResult();

            // 사용자로부터 숫자 입력받기
            try {
                player.inputNumber();
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException();
            }
            //System.out.println("사용자 랜덤숫자 : " + player.myInputNumber);

            // 숫자 비교하기
            compareNumbers(computer.myNumberList, player.myInputNumber);
            //System.out.println("숫자 비교" + result);

            // 출력하기
            String printResult = printCompareResult();

            // 출력 결과값이 다 맞췄다면 break;
            if (printResult.equals("3스트라이크")) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }

        }
    }

    public void resetResult() {
        result.replace("strike", 0);
        result.replace("ball", 0);
    }

    public void compareNumbers(List<Integer> comNum, List<Integer> userNum) {
        //System.out.println("비교 : " + comNum + " " + userNum);
        for (int i = 0; i < 3; i++) {
            int eachUserNum = userNum.get(i);
            int eachComNum = comNum.get(i);

            if (eachComNum == eachUserNum) {
                //System.out.println("스트라이크");
                result.replace("strike", result.get("strike") + 1);
                continue;
            }

            if (comNum.contains(eachUserNum)) {
                //System.out.println("볼");
                result.replace("ball", result.get("ball") + 1);
                continue;
            }

            //System.out.println("낫싱");
        }
    }

    public String printCompareResult() {
        if (result.get("strike") == 0 && result.get("ball") == 0) {
            System.out.println("낫싱");
            return "낫싱";
        }

        if (result.get("strike") == 0 && result.get("ball") == 1) {
            System.out.println("1볼");
            return "1볼";
        }

        if (result.get("strike") == 0 && result.get("ball") == 2) {
            System.out.println("2볼");
            return "2볼";
        }

        if (result.get("strike") == 0 && result.get("ball") == 3) {
            System.out.println("3볼");
            return "3볼";
        }

        if (result.get("strike") == 1 && result.get("ball") == 0) {
            System.out.println("1스트라이크");
            return "1스트라이크";
        }

        if (result.get("strike") == 1 && result.get("ball") == 1) {
            System.out.println("1볼 1스트라이크");
            return "1볼 1스트라이크";
        }

        if (result.get("strike") == 1 && result.get("ball") == 2) {
            System.out.println("2볼 1스트라이크");
            return "2볼 1스트라이크";
        }

        if (result.get("strike") == 2 && result.get("ball") == 0) {
            System.out.println("2스트라이크");
            return "2스트라이크";
        }

        if (result.get("strike") == 2 && result.get("ball") == 1) {
            System.out.println("1볼 2스트라이크");
            return "1볼 2스트라이크";
        }

        if (result.get("strike") == 3 && result.get("ball") == 0) {
            System.out.println("3스트라이크");
            return "3스트라이크";
        }

        return "";
    }
}

class Computer {
    public List<Integer> myNumberList = new ArrayList<>();

    public void makeRandomNumber() {
        while (myNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!myNumberList.contains(randomNumber)) {
                myNumberList.add(randomNumber);
            }
        }
    }
}

class Player {
    List<Integer> myInputNumber = new ArrayList<>();

    public void inputNumber() throws IllegalArgumentException {
        myInputNumber.clear();

        System.out.print("숫자를 입력해주세요 : ");
        String inputNum = Console.readLine();
        System.out.println(inputNum);

        // 3자리 숫자가 아닌경우 예외
        if (inputNum.length() != 3) {
            throw new IllegalArgumentException();
        }


        for (int i = 0; i < 3; i++) {
            int num = Character.getNumericValue(inputNum.charAt(i));
            myInputNumber.add(num);
        }
    }

}


public class Application {
    public static boolean isSystemOn = true;

    public static void main(String[] args) {
        boolean checkPlayGame = true;

        Game game = new Game();
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (checkPlayGame) {
            // 게임 시작
            try {
                game.startGame();
            }
            catch (IllegalArgumentException e) {
               throw new IllegalArgumentException();
            }

            // 게임 종료 조건 확인
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String restartCheckNum = Console.readLine();
            if (restartCheckNum.equals("2")) {
                checkPlayGame = false;
            }
            if (restartCheckNum.equals("1")) {
                continue;
            }

            // 그 외의 숫자를 입력했을 때
            break;
        }
    }
}
