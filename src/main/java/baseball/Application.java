package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.*;


public class Application {
    static final int GAME_RESTART = 1;
    static final int GAME_END = 2;
    static final int COUNT_INITALIZE = 0;
    static final int GAME_END_STRIKE_COUNT = 3;
    static final int MAX_NUMBER_COUNT = 3;
    static final int RANDOM_NUMBER_RANGE_START = 1;
    static final int RANDOM_NUMBER_RANGE_END = 9;


    public static List<Integer> createRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < MAX_NUMBER_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(RANDOM_NUMBER_RANGE_START, RANDOM_NUMBER_RANGE_END);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static List<Integer> inputUserNumber() throws IllegalArgumentException{
        List<Integer> userInputNumber = new ArrayList<>();
        String inputNumber = readLine();
        if(inputNumber.length() != MAX_NUMBER_COUNT) {
            throw new IllegalArgumentException();
        }

        String[] inputNumberSplitArray = inputNumber.split("");
        for (int i = 0; i < inputNumberSplitArray.length; i++) {
            if (!userInputNumber.contains(Integer.parseInt(inputNumberSplitArray[i]))) {
                userInputNumber.add(Integer.parseInt(inputNumberSplitArray[i]));
            } else {
                throw new IllegalArgumentException();
            }
        }

        return userInputNumber;
    }

    public static int numberBaseballGame(List<Integer> computerNumber, List<Integer> userNumber) {
        String playResult = "";
        int strike = COUNT_INITALIZE;
        int ball = COUNT_INITALIZE;
        for(int i = 0; i < computerNumber.size(); i++)
        {
            if(computerNumber.get(i).equals(userNumber.get(i))) {
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
        int gameContinue = GAME_RESTART;
        while(gameContinue != GAME_END) {
            List<Integer> computerCreateNumber = createRandomNumber();
            List<Integer> userInputNumber = new ArrayList<>();
            int strikeCount = COUNT_INITALIZE;

            try {
                while(strikeCount != GAME_END_STRIKE_COUNT) {
                    userInputNumber = inputUserNumber();
                    strikeCount = numberBaseballGame(computerCreateNumber,userInputNumber);
                }
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException();
            }

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
            gameContinue = Integer.parseInt(readLine());
        }
    }
}

