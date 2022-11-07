package game;

import java.util.List;

import computer.Judgment;
import computer.Random;

import camp.nextstep.edu.missionutils.Console;


public class GameProgress {
    public void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다");
        List<Integer> randomNumber = Random.getRandomNumber();
        playGame(randomNumber);
    }

    public void playGame(List<Integer> randomNumber) {
        System.out.print("숫자를 입력해주세요 : ");
        List<Integer> userNumber = getUserNumber();
        List<Integer> resultList = getResultList(randomNumber, userNumber);
        int strike = resultList.get(0);
        while (strike != 3) {
            String resultMessage = checkResult(resultList);
            System.out.println(resultMessage);
        }

    }

    private List<Integer> getUserNumber() {
        String userInput = Console.readLine();
        Converter converter = new Converter();
        List<Integer> userNumber = converter.convertToList(userInput, 3);
        return userNumber;
    }

    private List<Integer> getResultList(List<Integer> randomNumber, List<Integer> userNumber) {
        Judgment judgment = new Judgment();
        List<Integer> resultList = judgment.judgeResult(randomNumber, userNumber);
        return resultList;
    }

    private String checkResult(List<Integer> resultList) {
        int strike = resultList.get(0);
        int ball = resultList.get(1);
        if ((strike > 0) && (ball > 0)) {
            return ball + "볼 " + strike + "스트라이크";
        }
        if (strike > 0) {
            return strike + "스트라이크";
        }
        if (ball > 0) {
            return ball + "볼";
        }
        return "낫싱";
    }
}
