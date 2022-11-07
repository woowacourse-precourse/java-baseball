package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {

    private static final int NUM_SIZE = 3;

    private static List<Integer> makeComNum() {
        List<Integer> comNum = new ArrayList<>();
        for(int i = 0; i < NUM_SIZE; i++) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!comNum.contains(randomNumber)) {
                comNum.add(randomNumber);
            }
        }
        return comNum;
    }

    private static List<Integer> makeMyNum() {
        List<Integer> myNum = new ArrayList<>();
        int num = Integer.parseInt(Console.readLine());
        if(num < Math.pow(10, NUM_SIZE - 1) || Math.pow(10, NUM_SIZE) <= num) {
            throw new IllegalArgumentException();
        }
        for(int i = 0; i < NUM_SIZE; i++) {
            myNum.add(num%10);
            num /= 10;
        }
        Collections.reverse(myNum);
        return myNum;
    }

    private static int checkBall(List<Integer> comNum, List<Integer> myNum) {
        int result = 0;
        for(int i = 0; i < NUM_SIZE; i++) {
            if(comNum.contains(myNum.get(i)) && (comNum.get(i) != myNum.get(i))) {
                result++;
            }
        }
        return result;
    }

    private static int checkStrike(List<Integer> comNum, List<Integer> myNum) {
        int result = 0;
        for(int i = 0; i < NUM_SIZE; i++) {
            if(comNum.get(i) == myNum.get(i)) {
                result++;
            }
        }
        return result;
    }

    private static boolean checkNothing(int ballCount, int strikeCount) {
        boolean check = false;
        if(ballCount == 0 && strikeCount == 0) {
            check = true;
        }
        return check;
    }

    private static void printResult(int ballCount, int strikeCount) {
        String result = "";
        if(checkNothing(ballCount, strikeCount)) {
            result = "낫싱";
        } else {
            if(ballCount != 0) {
                result += ballCount + "볼";
            }
            if(ballCount != 0 && strikeCount != 0) {
                result += " ";
            }
            if(strikeCount != 0) {
                result += strikeCount + "스트라이크";
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {

    }
}
