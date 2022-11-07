package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {

    private Integer strike;
    private Integer ball;
    private List<Integer> comNum;
    private List<Integer> userNum;

    public Game() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        init();
    }
    //함수 호출하자마자 랜덤값 세자리 생성
    public void init() {
        comNum = new ArrayList<>();
        for (int i = 0; i < 3; ) {
            int num = Randoms.pickNumberInRange(1, 9);
            if (!comNum.contains(num)) {
                comNum.add(num);
                i++;
            }
        }
    }
    //사용자 세자리 입력받기
    public void playGame() {
        System.out.println("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();
        this.userNum = makeList(userInput);
        validateUserNum();
        compareNumbers();
        System.out.println(compareResultReturn());
    }

    //사용자 입력받은거 리스트로 바꾸기
    public List<Integer> makeList(String userInput) {
        String[] arrayInput = userInput.split("");
        List<Integer> userNumbers = new ArrayList<>();
        for (int i = 0; i < userInput.length(); i++) {
            userNumbers.add(Integer.parseInt(arrayInput[i]));
        }
        return userNumbers;
    }

    //사용자 입력 오류시 오류메시지 출력
    public void validateUserNum() {
        if (userNum.size() != 3) {
            throw new IllegalArgumentException("올바른 숫자가 아닙니다. 세자리 숫자를 입력해주세요.");
        }
        if (userNum.contains(0)) {
            throw new IllegalArgumentException("올바른 숫자가 아닙니다. 0을 제외한 숫자를 입력해주세요.");
        }
        for (int i = 0; i < userNum.size(); i++) {
            if (Collections.frequency(userNum, userNum.get(i)) != 1) {
                throw new IllegalArgumentException("올바른 숫자가 아닙니다. 서로 다른 숫자로 이루어져야 합니다.");
            }
        }
    }

    //스트라이크 , 볼개수 세기
    public void compareNumbers() {
        this.strike = 0;
        this.ball = 0;
        for (int i = 0; i < userNum.size(); i++) {
            if (comNum.indexOf(userNum.get(i)) == i) {
                strike++;
                continue;
            }
            if (comNum.contains(userNum.get(i))) {
                ball++;
            }
        }
    }

    //힌트메시지 출력
    public String compareResultReturn() {
        if (ball != 0 && strike != 0) {
            return (ball + "볼" + " " + strike + "스트라이크");
        }
        if (ball == 0 && strike != 0) {
            return (strike + "스트라이크");
        }
        if (ball != 0 && strike == 0) {
            return (ball + "볼");
        }
        return ("낫싱");
    }

    //게임 재개및 종료 입력 받기
    public boolean gameEnd() {
        if (strike != null && strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하시려면 1, 종료하려면 2를 입력하세요.");

            String response = Console.readLine();
            if (response.equals("1")) {
                init();
                return true;
            }
            if (response.equals("2")) {
                return false;
            }
            throw new IllegalArgumentException("올바른 숫자가 아닙니다. 1 또는 2를 입력하세요.");
        }
        return true;
    }

}