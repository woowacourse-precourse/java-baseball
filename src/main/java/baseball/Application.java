package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {

        while (true) {
            startBaseball();
            if (endBaseball()) {
                break;
            }
        }
    }

    /**
     * 내 숫자 세개 입력하기
     * 
     * @return
     */
    public static List<Integer> myThreeNum() {
        List<Integer> myThreeNum = new ArrayList<Integer>();
        System.out.print("숫자를 입력해주세요 : ");

        String myPickNum = Console.readLine();

        for (int i = 0; i < myPickNum.length(); i++) {
            String temp = myPickNum.substring(i, i + 1);
            int myNum = Integer.parseInt(temp);
            myThreeNum.add(myNum);
        }
        return myThreeNum;
    }

    /**
     * 상대 컴퓨터의 3자리수 랜덤숫자뽑기 메서드
     * 
     * @return
     */
    public static List<Integer> computerThreeNum() {
        List<Integer> computerThreeNum = new ArrayList<Integer>();
        while (computerThreeNum.size() < 3) {
            int computerNum = Randoms.pickNumberInRange(1, 9);

            if (!computerThreeNum.contains(computerNum)) {
                computerThreeNum.add(computerNum);
            }

        }

        return computerThreeNum;
    }

    /**
     * 게임진행 메서드
     * 
     * @return
     */
    public static void startBaseball() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> computerThreeNum = computerThreeNum();
        while (true) {
            List<Integer> myThreeNum = myThreeNum();
            checkValidation(myThreeNum);
            boolean equalList = equalList(computerThreeNum, myThreeNum);
            if (equalList == false) {
                int strike = strike(computerThreeNum, myThreeNum);
                int ball = ball(computerThreeNum, myThreeNum);
                printResult(strike, ball);
                continue;
            }
            break;
        }
    }

    /**
     * List값 비교하기 3개 모두 맞으면 3스트라이크!
     * 
     * @param computerThreeNum
     * @param myThreeNum
     * @return
     */
    public static boolean equalList(List<Integer> computerThreeNum, List<Integer> myThreeNum) {

        boolean equalList = false;

        if (myThreeNum.equals(computerThreeNum)) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");

            return true;
        }
        return equalList;
    }

    /**
     * 게임종료 여부확인
     * 
     * @return
     */
    public static boolean endBaseball() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String endGame = Console.readLine();

        if (endGame.equals("1")) {
            System.out.println("게임을 다시 시작합니다.");
            return false;
        }
        if (endGame.equals("2")) {
            System.out.println("게임 종료");
            return true;
        } else {
            return endBaseball();
        }

    }

    /**
     * strike count 확인
     * 
     * @param computerThreeNum
     * @param myThreeNum
     * @return
     */
    public static int strike(List<Integer> computerThreeNum, List<Integer> myThreeNum) {

        int strikeCount = 0;

        for (int i = 0; i < computerThreeNum.size(); i++) {
            if (computerThreeNum.get(i) == myThreeNum.get(i)) {
                strikeCount++;
            }
        }

        return strikeCount;
    }

    /**
     * ball count 확인
     * 
     * @param computerThreeNum
     * @param myThreeNum
     * @return
     */
    public static int ball(List<Integer> computerThreeNum, List<Integer> myThreeNum) {

        int ballCount = 0;

        for (int i = 0; i < computerThreeNum.size(); i++) {
            int computerNum = computerThreeNum.get(i);
            int index = myThreeNum.indexOf(computerNum);
            if (index == -1 || computerThreeNum.get(i) == myThreeNum.get(i)) {
                continue;
            }
            if (index <= 2) {
                ballCount++;
            }
        }

        return ballCount;
    }

    /**
     * 예외처리
     * 
     * @param myThreeNum
     */
    public static void checkValidation(List<Integer> myThreeNum) {

        if (myThreeNum.size() != 3) {
            throw new IllegalArgumentException("입력오류. 게임을 종료합니다.");
        }

        Set<Integer> numList = new HashSet<>(myThreeNum);
        if (numList.size() != myThreeNum.size()) {
            throw new IllegalArgumentException("중복입력. 게임을 종료합니다.");

        }
    }

    /**
     * 조건 충족 시 strike count, ball count, 낫싱 출력
     * 
     * @param strike
     * @param ball
     */
    public static void printResult(int strike, int ball) {
        String messege = "";

        if (ball > 0) {
            messege = messege + ball + "볼 ";
        }
        if (strike > 0) {
            messege = messege + strike + "스트라이크";
        }
        if (strike == 0 && ball == 0) {
            messege = messege + "낫싱";
        }
        System.out.println(messege.trim());
    }
}
