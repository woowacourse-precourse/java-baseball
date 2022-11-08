package baseball;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.lang.IllegalArgumentException;

public class Application {
    static List<Integer> createAnswer(){
        List<Integer> answerList = new ArrayList<>(3); //allocate exact capacity to list
        int randomNum = 0;
        while (answerList.size() < 3){
            randomNum = Randoms.pickNumberInRange(1, 9);
            if (!answerList.contains(randomNum)) {
                answerList.add(randomNum);
            }
        }

        return answerList;
    }

    static void checkInputLength(String input){
        int len = input.length();
        if (len != 3){
            throw new IllegalArgumentException("Invalid input");
        }
    }

    static void checkInputRange(String input){
        char check;
        int len = input.length();
        for (int i = 0; i < len; i++) {
            check = input.charAt(i);
            if (check < '1' || check > '9') {
                throw new IllegalArgumentException("Invalid input");
            }
        }
    }

    static void checkRedundancy(String input){
        char first = input.charAt(0);
        char second = input.charAt(1);
        char third = input.charAt(2);
        if (first == second) {
            throw new IllegalArgumentException("Same number cannot be input");
        } else if (first == third) {
            throw new IllegalArgumentException("Same number cannot be input");
        } else if (second == third) {
            throw new IllegalArgumentException("Same number cannot be input");
        }
    }

    static void checkValidInput(String input){
        checkInputLength(input);
        checkInputRange(input);
        checkRedundancy(input);
    }

    static String inputAnswer(){
        System.out.print("숫자를 입력해주세요 : ");
        String inputString = Console.readLine();

        try {
            checkValidInput(inputString);
        } catch(Exception e){
            e.printStackTrace();
        }

        return inputString;
    }

    static List<Integer> castToInteger(String str){
        List<Integer> inputList = new ArrayList<>(3);
        int len = str.length();
        for (int i = 0; i < len; i++) {
            inputList.add(Character.getNumericValue(str.charAt(i)));
        }
        return inputList;
    }

    static boolean compareStrikes(List<Integer> input, List<Integer> answer){
        int size = input.size();
        int thrown = 0, answerIdx = 0;
        List<Integer> BallStrike = Arrays.asList(0, 0);

        for (int i = 0; i < size; i++) {
            thrown = input.get(i);
            if ((answerIdx = answer.indexOf(thrown)) != -1) {
                BallStrike = judgeBallStrike(i, answerIdx, BallStrike);
            }
        }

        if (BallStrike.get(0) != 0) {
            System.out.print(BallStrike.get(0) + "볼");
        }
        if (BallStrike.get(1) != 0) {
            if (BallStrike.get(0) != 0) {
                System.out.print(" ");
            }
            System.out.print(BallStrike.get(1) + "스트라이크");
        }
        if (BallStrike.get(0) == 0 && BallStrike.get(1) == 0) {
            System.out.print("낫싱");
        }
        System.out.println();

        if (BallStrike.get(1) == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        } else
            return false;
    }

    static List<Integer> judgeBallStrike(int thrownIdx, int answerIdx, List<Integer> BallStrike){
        if (thrownIdx == answerIdx) {
            BallStrike.set(1, BallStrike.get(1) + 1);
        } else {
            BallStrike.set(0, BallStrike.get(0) + 1);
        }
        return BallStrike;
    }

    public static void main(String[] args) {

        String inputString = inputAnswer();
        List<Integer> thrownBalls = castToInteger(inputString);
        List<Integer> Answer = createAnswer();
        boolean isThreeStrikes = false;
        System.out.println("숫자 야구 게임을 시작합니다");

        while (!isThreeStrikes){
            inputString = inputAnswer();
            thrownBalls = castToInteger(inputString);
            isThreeStrikes = compareStrikes(thrownBalls, Answer);
        }

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    }
}
