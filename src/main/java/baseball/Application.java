package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void gameStartMessage(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static String makeComputerNumber() {
        String computerNumber = "";
        while (computerNumber.length() < 3) {
            int randomComputerDigit = Randoms.pickNumberInRange(1,9);
            if (!computerNumber.contains(Integer.toString(randomComputerDigit))) {
                computerNumber += Integer.toString(randomComputerDigit);
            }
        }
        return computerNumber;
    }

    public static String inputNumberMessage(){
        System.out.printf("숫자를 입력해주세요 : ");
        String inputNumber = Console.readLine();
        return inputNumber;
    }

    public static void inputNumberError(String inputNumber, String[] inputNumberList) {

        for (int inputNumberDigitValue = 0; inputNumberDigitValue < 3; inputNumberDigitValue++) {
            String availableNumber = "123456789";
            if (!availableNumber.contains(Character.toString(inputNumber.charAt(inputNumberDigitValue)))) {
                throw new IllegalArgumentException();
            }
        }

        if (inputNumberList.length != 3) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < inputNumberList.length; i++) {
            if (Collections.frequency(Arrays.asList(inputNumberList), inputNumberList[i]) > 1) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static int threeStrikeJudgement(List<Integer> strikeBallNothingList) {
        int strikeCount = Collections.frequency(strikeBallNothingList, 2);
        if (strikeCount == 3) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void threeStrikeMessage(int threeStrikeJudge){
        if (threeStrikeJudge == 1){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }
    }

    public static void addBallIndex(
            String[] inputNumberList, String[] computerNumberList, List<Integer> strikeBallNothingList
    ){
        for (int i = 0; i < inputNumberList.length; i++) {
            if (Arrays.asList(computerNumberList).contains(inputNumberList[i])) {
                strikeBallNothingList.set(i, 1);
            }
        }
    }

    public static void addStrikeIndex(
            String[] inputNumberList, String[] computerNumberList, List<Integer> strikeBallNothingList
    ){
        for (int i = 0; i < inputNumberList.length; i++) {
            if (inputNumberList[i].equals(computerNumberList[i])) {
                strikeBallNothingList.set(i, 2);
            }
        }
    }

    public static void resultMessage(List<Integer> strikeBallNothingList) {
        int strikeCount = Collections.frequency(strikeBallNothingList, 2);
        int ballCount = Collections.frequency(strikeBallNothingList, 1);
        int nothingCount = Collections.frequency(strikeBallNothingList, 0);
        String strikeCountMessage = "";
        String ballCountMessage = "";
        if (strikeCount != 0) {
            strikeCountMessage = " %d스트라이크";
        }

        if (ballCount != 0) {
            ballCountMessage = "%d볼";
        }

        if (nothingCount == 3) {
            System.out.println("낫싱");
        } else if (ballCount == 0){
            System.out.printf(strikeCountMessage.trim() + "\n", strikeCount);
        } else {
            System.out.printf(ballCountMessage + strikeCountMessage + "\n", ballCount, strikeCount);
        }
    }

    public static String decideNewgameEndgame() {
        String playmoreStopNumber = Console.readLine();
        return playmoreStopNumber;
    }

    public static void decideNewgameEndgameNumberError(String playmoreStopNumber) {
        String availableNumber = "12";
        if (!availableNumber.contains(playmoreStopNumber)) {
            throw new IllegalArgumentException();
        }
        if (playmoreStopNumber.length() != 1) {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        gameStartMessage();
        String playmoreStopNumber = "1";
        do {
            String computerNumber = makeComputerNumber();
            String[] computerNumberList = computerNumber.split("");
            List<Integer> strikeBallNothingList = Arrays.asList(0, 0, 0);
            int threeStrikeJudge = 0;

            do {
                String inputNumber = inputNumberMessage();
                String[] inputNumberList = inputNumber.split("");
                inputNumberError(inputNumber, inputNumberList);
                strikeBallNothingList = Arrays.asList(0, 0, 0);
                addBallIndex(inputNumberList, computerNumberList, strikeBallNothingList);
                addStrikeIndex(inputNumberList, computerNumberList, strikeBallNothingList);
                resultMessage(strikeBallNothingList);
                threeStrikeJudge = threeStrikeJudgement(strikeBallNothingList);
                threeStrikeMessage(threeStrikeJudge);
            } while (threeStrikeJudge == 0);

            playmoreStopNumber = decideNewgameEndgame();
            decideNewgameEndgameNumberError(playmoreStopNumber);
        } while (playmoreStopNumber.equals("1"));
    }
}
