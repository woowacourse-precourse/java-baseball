package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        while (game.gameEnd()){
            game.playGame();
            }
        }// TODO: 프로그램 구현
}
class Game {
    private Integer strike;
    private Integer ball;
    private List<Integer> ComputerNum;
    private List<Integer> PlayerNum;
    public Game() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        init();
    }//게임을 시작하는 기능
    public void init() {
        ComputerNum = new ArrayList<>();
        for (int i = 0; i < 3; ) {
            int num = Randoms.pickNumberInRange(1, 9);
            if (!ComputerNum.contains(num)) {
                ComputerNum.add(num);
                i++;
            }
        }
    }
    public void playGame() {
        System.out.println("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();
        this.PlayerNum = MakeList(userInput);
        DateUserNum();
        compareNumbers();
        System.out.println(compareResultReturn());
    }//플레이어의 숫자를 입력받는 기능
    public List<Integer> MakeList(String userInput) {
        String[] arrayInput = userInput.split("");
        List<Integer> userNumbers = new ArrayList<>();
        for (int i = 0; i < userInput.length(); i++) {
            userNumbers.add(Integer.parseInt(arrayInput[i]));
        }
        return userNumbers;
    }//플레이어의 숫자를 입력받아 리스트로 변환하는 기능
    public void DateUserNum() {
        if (PlayerNum.size() != 3) {
            throw new IllegalArgumentException("올바른 숫자가 아닙니다. 세자리 숫자를 입력해주세요.");
        }
        if (PlayerNum.contains(0)) {
            throw new IllegalArgumentException("올바른 숫자가 아닙니다. 0을 제외한 숫자를 입력해주세요.");
        }
        for (int i = 0; i < PlayerNum.size(); i++) {
            if (Collections.frequency(PlayerNum, PlayerNum.get(i)) != 1) {
                throw new IllegalArgumentException("올바른 숫자가 아닙니다. 서로 다른 숫자로 이루어져야 합니다.");
            }
        }
    }//플레이어 입력 오류시 오류메시지 출력 기능
    public void compareNumbers() {
        this.strike = 0;
        this.ball = 0;
        for (int i = 0; i < PlayerNum.size(); i++) {
            if (ComputerNum.indexOf(PlayerNum.get(i)) == i) {
                strike++;
                continue;
            }
            if (ComputerNum.contains(PlayerNum.get(i))) {
                ball++;
            }
        }
    }//스트라이크와 볼의 총갯수 구하기
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
    }//스트라이크, 볼 갯수 구하는 기능
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
        }//게임 재개및 종료 입력 받기
        return true;
    }
}
