package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.*;


public class Application {
    static final int gameRestart = 1;
    static final int gameEnd = 2;
    static final int COUNT_INITALIZE = 0;
    static final int GAME_END_STRIKE_COUNT = 3;

    public static List<Integer> createRandomNumber(List<Integer> computer) {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static List<Integer> inputUserNumber() {
        List<Integer> userInputNumber = new ArrayList<>();
        String inputNumber = readLine();
        String[] inputNumberSplitArray = inputNumber.split("");
        for (int i = 0; i < inputNumberSplitArray.length; i++)
        {
            userInputNumber.add(Integer.parseInt(inputNumberSplitArray[i]));
        }

        return userInputNumber;
    }

    public static int numberBaseballGame(List<Integer> computerNumber, List<Integer> userNumber) {
        String playResult = "";
        int strike = COUNT_INITALIZE;
        int ball = COUNT_INITALIZE;
        for(int i = 0; i < computerNumber.size(); i++)
        {
            if(computerNumber.get(i) == userNumber.get(i)) {
                strike++;
            }
            else if(userNumber.contains(computerNumber.get(i)))
            {
                ball++;
            }
        }

        if (strike == COUNT_INITALIZE && ball == COUNT_INITALIZE)
        {
            playResult = playResult + "낫싱\n";
        }
        else if (strike != COUNT_INITALIZE && ball == COUNT_INITALIZE)
        {
            playResult = playResult + strike + "스트라이크\n";
        }
        else if (strike == COUNT_INITALIZE && ball != COUNT_INITALIZE)
        {
            playResult = playResult + ball + "볼\n";
        }
        else if (strike != COUNT_INITALIZE && ball != COUNT_INITALIZE)
        {
            playResult = playResult + ball + "볼" + " " + strike + "스트라이크\n";
        }
        System.out.println(playResult);

        return strike;
    }


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> computerCreateNumber = new ArrayList<>();
        List<Integer> userInputNumber = new ArrayList<>();
        int gameContinue = gameRestart;
        while(gameContinue != gameEnd) {
            int strikeCount = COUNT_INITALIZE;
            while(strikeCount != GAME_END_STRIKE_COUNT)
            {
                strikeCount = numberBaseballGame(computerCreateNumber,userInputNumber);
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
            gameContinue = Integer.parseInt(readLine());
        }
    }
}

