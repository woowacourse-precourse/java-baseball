package baseball;

import java.util.ArrayList;
import java.util.List;

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

    // <내가 생각하는 숫자 3자리 파라미터입력>
    // Player 다시 서로다른 숫자 3개 입력
    private static void myThreeNum() {
        System.out.println("숫자를 입력해주세요");
        String input = ",,";
        String[] result = input.split(",,");

    }

    // <상대 컴퓨터의 3자리수 랜덤숫자뽑기 메서드>
    private static List<Integer> computerThreeNum() {
        // 1~9로 이루어진 서로 다른 3자리 수 List<String> [0,0,0]
        // 1~9까지 수의 랜덤숫자 뽑기로 자리 하나씩 채우기
        // 숫자가 겹치지 않게 어떻게 뽑을지 고민?
        // 라이브러리
        // camp.nextstep.edu.missionutile 에서 제공하는 Randoms 및 Console API사용
        // Random값 추출 -> camp.nextstep.edu.missionutile.Randoms의 pickNumberInRange() 활용
        // 사용자 입력값은 camp.nextstep.edu.missionutile.Console의 readLine()을 활용

        // 숫자 3개 받을 리스트 변수

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
    // ------------------------------------------------------------------

    // <게임진행 메서드>
    private static void startBaseball() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        // computerThreeNum 호출
        // myThreeNum 호출
        // list A.containsAll(list B) 리스트 내용 비교
        // computerThreeNum 과 myThreeNum 비교 결과를 출력
        // computerThreeNum = [1,2,3]
        // myThreeNum = [1,3,4]
    }

    private static boolean equalList(List<Integer> computerThreeNum, List<Integer> myThreeNum) {
        // index, 내용 같으면 true ------> 3스트라이크!
        return true;
    }

    private static boolean endBaseball() {
        // TRUE-----------> 게임종료 or 재시작 여부
        return true;
    }

    private static int strike(List<Integer> computerThreeNum, List<Integer> myThreeNum) {
        // FALSE ------------>
        // 반복------>숫자 3개 맞을때까지!!!
        // strike count ++
        return 0;
    }

    private static int ball(List<Integer> computerThreeNum, List<Integer> myThreeNum) {
        // FALSE ------------>
        // 반복------>숫자 3개 맞을때까지!!!
        // ball count ++
        return 0;
    }
}

// 같은 인덱스번호 == 같은 내용 -----> 1스트라이크 카운트++
// 다른 인덱스번호, list내에 같은 내용 -------> 1볼 카운트 ++
// 전혀 다른 내용 --------> 낫싱
