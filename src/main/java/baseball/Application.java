package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> targetNum = makeRandomTargetNum();
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
            System.out.println("잘못된 입력 값을 입력했습니다.");
            return;
        }

        int strikeNum = countStrikeNum(targetNum, userNum);
        int ballNum = countBallNum(targetNum, userNum);




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

    static boolean checkIllegalArgumentException(String inputNum){

        try{
            Integer.parseInt(inputNum);

            return true;
        } catch (IllegalArgumentException e){
            return false;
        }
    }

    static boolean userNumToIntegerListAndCheckDuplicatedNum(List<Integer> userNum, String inputNum) {

        try{
            int inputNumToInt = Integer.parseInt(inputNum);

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

}
