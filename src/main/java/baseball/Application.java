package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Application {


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RandomNumber randomNumber = new RandomNumber();
        playerNumberChoice playerNumberChoice = new playerNumberChoice();
        RefereeCheck refereeCheck = new RefereeCheck();
        PlayAgain playAgain = new PlayAgain();
        boolean again = true;

        while (again) {
            List<Integer> computer = randomNumber.create();
            String result = "";
            while (!result.equals("3스트라이크")) {
                result = refereeCheck.referee(computer, playerNumberChoice.plyerNuber());
                System.out.println(result);
            }
            again = playAgain.again();
        }
    }
}

class RandomNumber {
    //컴퓨터 임의의 숫자 3개
    public List<Integer> create() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        System.out.println("컴퓨터 숫자= " + computer);
        return computer;
    }
}

// 플레이어 입력값
class playerNumberChoice {

    public List<Integer> plyerNuber() {
        System.out.println("숫자를 입력하세요");
        List<Integer> playerNum = new ArrayList<>();
        PlayAgain playAgain = new PlayAgain();
        boolean again = true;
        try {
            String userNum = Console.readLine();

            String[] s = userNum.split("");

            for (int i = 0; i < userNum.length(); i++) {
                playerNum.add(Integer.parseInt(s[i]));
            }

            System.out.println("내 숫자= " + playerNum);

        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 값을 입력하여 자동 종료됩니다.");
            System.exit(0);
        }

        return playerNum;
    }
}

class Compare {
    public int check(List<Integer> computer, List<Integer> plyerNuber) {
        int result = 0;
        for (int i = 0; i < plyerNuber.size(); i++) {
            if (computer.contains(plyerNuber.get(i))) {
                result += 1;
            }
        }
        return result;
    }

    public int strike(List<Integer> computer, List<Integer> plyerNuber) {
        int countStrike = 0;
        for (int i = 0; i < plyerNuber.size(); i++) {
            if (computer.get(i) == plyerNuber.get(i)) {
                countStrike += 1;
            }
        }
        return countStrike;
    }
}

class RefereeCheck {
    Compare compare = new Compare();

    public String referee(List<Integer> computer, List<Integer> plyerNuber) {
        int totalNumber = compare.check(computer, plyerNuber);
        int strikeNumber = compare.strike(computer, plyerNuber);
        int ballNumber = totalNumber - strikeNumber;

        if (totalNumber == 0) {
            return "낫싱";
        } else if (strikeNumber == 0) {
            return ballNumber + "볼";
        } else if (ballNumber == 0) {
            return strikeNumber + "스트라이크";
        }
        return ballNumber + "볼" + " " + strikeNumber + "스트라이크";
    }
}

class PlayAgain {
    public boolean again() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner kb = new Scanner(System.in);
        char answer = kb.next().charAt(0);
        if (answer == '1') {
            return true;
        }
        return false;
    }
}











