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

    private static void playBaseball(List<Integer> comNum) {
        int strikeCount = -1;
        while(strikeCount != NUM_SIZE) {
            System.out.print("숫자를 입력해주세요 : ");
            List<Integer> myNum = makeMyNum();

            int ballCount = checkBall(comNum, myNum);
            strikeCount = checkStrike(comNum, myNum);

            printResult(ballCount, strikeCount);
        }
    }

    public static void gameStart() {
        int end = 0;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(end != 2) {
            List<Integer> comNum = makeComNum();

            playBaseball(comNum);

            System.out.println(NUM_SIZE + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            end = Integer.parseInt(Console.readLine());
            if(end != 1 && end != 2) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void main(String[] args) {
        gameStart();
    }
}
