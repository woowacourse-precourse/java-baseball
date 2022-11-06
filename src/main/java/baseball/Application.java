package baseball;

import java.util.ArrayList;
import java.util.List;

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
        System.out.println("숫자를 입력해주세요 :  ");

        String myPickNum = Console.readLine();

        for (int i = 0; i < myPickNum.length(); i++) {
            String temp = myPickNum.substring(i, i + 1);
            int myNum = Integer.parseInt(temp);
            myThreeNum.add(myNum);
        }
        return myThreeNum;
    }

    // <상대 컴퓨터의 3자리수 랜덤숫자뽑기 메서드>
    public static List<Integer> computerThreeNum() {
        // 1~9로 이루어진 서로 다른 3자리 수 List<Integer> [0,0,0]
        // 1~9까지 수의 랜덤숫자 뽑기로 자리 하나씩 채우기
        // Random값 추출 -> camp.nextstep.edu.missionutile.Randoms의 pickNumberInRange() 활용
        // 랜덤숫자 1~9

        List<Integer> computerThreeNum = new ArrayList<Integer>();
        while (computerThreeNum.size() < 3) {
            int computerNum = Randoms.pickNumberInRange(1, 9);

            if (!computerThreeNum.contains(computerNum)) {
                computerThreeNum.add(computerNum);
            }

        }
        return computerThreeNum;
    }

    // <게임진행 메서드>
    public static void startBaseball() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        // myThreeNum 호출
        // checkValidation 호출
        // computerThreeNum 호출
        List<Integer> myThreeNum = myThreeNum();
        checkValidation(myThreeNum);
        List<Integer> computerThreeNum = computerThreeNum();
        boolean equalList = equalList(computerThreeNum, myThreeNum);
        int strike = strike(computerThreeNum, myThreeNum);
        int ball = ball(computerThreeNum, myThreeNum);

    }

    public static boolean equalList(List<Integer> computerThreeNum, List<Integer> myThreeNum) {
        // list A.containsAll(list B) 리스트 내용 비교
        boolean equalList = true;
        // index, 내용 같으면 true ------> 3스트라이크!
        if (myThreeNum.containsAll(computerThreeNum)) {
            System.out.println("3 스트라이크!");
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다!");
        System.out.println("게임종료");
        return equalList;
    }

    public static boolean endBaseball() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String endGame = Console.readLine();

        // 게임종료 or 재시작 여부
        if (endGame.equals("1")) {
            System.out.println("게임을 다시 시작합니다.");
            return false;
        }
        if (endGame.equals("2")) {
            System.out.println("게임을 종료합니다.");
            return true;
        } else {
            return endBaseball();
        }

    }

    public static int strike(List<Integer> computerThreeNum, List<Integer> myThreeNum) {
        // FALSE ------------>
        // 반복------>숫자 3개 맞을때까지!!!
        // strike count ++
        return 0;
    }

    public static int ball(List<Integer> computerThreeNum, List<Integer> myThreeNum) {
        // FALSE ------------>
        // 반복------>숫자 3개 맞을때까지!!!
        // ball count ++
        return 0;
    }

    public static void checkValidation(List<Integer> myThreeNum) {
        // myThreeNum 4자리 이상 입력되면 "예외처리" 후 게임 종료
        if (myThreeNum.size() != 3) {
            throw new IllegalArgumentException("입력오류. 게임을 종료합니다.");
        }
    }
}

// 같은 인덱스번호 == 같은 내용 -----> 1스트라이크 카운트++
// 다른 인덱스번호, list내에 같은 내용 -------> 1볼 카운트 ++
// 전혀 다른 내용 --------> 낫싱
