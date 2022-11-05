package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        boolean goOrStop = true;

        while(goOrStop){
            goOrStop = playGame();
        }

    }

    public static boolean playGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> targetNum = makeRandomTargetNum();
        System.out.println(targetNum);
        boolean go = true;
        boolean restartOrEnd = true;
        while(go){
            int notFinishOrFinishOrException = baseballGame(targetNum);

            if(notFinishOrFinishOrException == 1){
                continue;
            } else if(notFinishOrFinishOrException == 2){
               go = false;
                restartOrEnd = gameRestartOrEnd();
            } else{
                go = false;
                makeException();
                restartOrEnd = false;
            }
        }

        return restartOrEnd;
    }

    public static int baseballGame(List<Integer> targetNum) {
        List<Integer> userNum = new ArrayList<>();
        String inputUserNum = inputUserNum();
        String[] separatedUserNum = inputUserNum.split("");
        boolean lengthException = true;
        boolean duplicateException = true;

        lengthException = checkInputLengthCorrect(inputUserNum);

        for (String num : separatedUserNum) {
            duplicateException = userNumToIntegerListAndCheckDuplicatedNum(userNum, num);

            if (!duplicateException)
                break;
        }

        if(!lengthException || !duplicateException){
            return 3;
        }

        int strikeNum = countStrikeNum(targetNum, userNum);
        int ballNum = countBallNum(targetNum, userNum);

        if(ballNum != 0){
            System.out.print(ballNum +"볼 ");
        }
        if(strikeNum != 0){
            System.out.println(strikeNum+"스트라이크");
        } else{
            System.out.println();
        }

        if(!checkNothing(strikeNum, ballNum)){
            System.out.println("낫싱");
        }

        if (isThreeStrike(strikeNum)) {
             return 2;

        } else{
            return 1;
        }

    }
    public static List<Integer> makeRandomTargetNum() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    public static String inputUserNum() {
        System.out.print("숫자를 입력하세요: ");
        String userNum = Console.readLine();

        return userNum;
    }

    static boolean checkInputLengthCorrect(String inputNum) {
        try {
            if (inputNum.length() != 3){
                throw new IllegalArgumentException();
            }

            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    static boolean userNumToIntegerListAndCheckDuplicatedNum(List<Integer> userNum, String inputNum) {

        try{
            int inputNumToInt = Integer.parseInt(inputNum);

            if (inputNumToInt == 0) {
                throw new IllegalArgumentException();
            }

            if (!userNum.contains(inputNumToInt)) {
                userNum.add(inputNumToInt);
            } else{
                throw new IllegalArgumentException();
            }

            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }

    }

    static int countStrikeNum(List<Integer> targetNum, List<Integer> userNum) {
        int strikeNum = 0;

        for (int listIndex = 0; listIndex < targetNum.size(); listIndex++) {
            if (targetNum.get(listIndex).equals(userNum.get(listIndex))) {
                strikeNum++;
            }
        }

        return strikeNum;
    }

    static int countBallNum(List<Integer> targetNum, List<Integer> userNum) {
        int ballNum = 0;

        for (int listIndex = 0; listIndex < userNum.size(); listIndex++) {
            if(!userNum.get(listIndex).equals(targetNum.get(listIndex)) && targetNum.contains(userNum.get(listIndex))){
                ballNum++;
            }
        }

        return ballNum;
    }

    static boolean checkNothing(int strikeNum, int ballNum) {
        return ballNum != 0 || strikeNum != 0;
    }

    static boolean isThreeStrike(int strikeNum) {
        return strikeNum == 3;
    }

    static boolean gameRestartOrEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String selectState = Console.readLine();

        if (selectState.equals("1")) {
            return true;
        } else if (selectState.equals("2")) {
            return false;
        } else{
            return false;
        }
    }

    static void makeException(){
        try {
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e){
            return;
        }
    }

}
