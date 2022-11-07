package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    static int numberLength = 3;

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        int gameStart = 1;
        do {
            playGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            gameStart = Integer.parseInt(readLine());
        } while (gameStart == 1);
    }

    private static void playGame() {
        List<Integer> computer = new ArrayList<>();
        List<Integer> user = new ArrayList<>();
        user = getUserInput();
        computer = makeComputerNumber();

        //사용자_입력_테스트 || 예외_테스트() 용 출력
        //System.out.println(computer);

        List<Integer> ballStrike;
        while(true) {
            ballStrike = compareList(user, computer);
            // 볼_스트라이크_개수_확인 테스트 출력
            System.out.println(ballStrike);
            if (ballStrike.get(0) == numberLength) {
                break;
            }
            user = getUserInput();
        }
    }

    private static List<Integer> getUserInput() {
        int input = Integer.parseInt(readLine());
        checkInput(Integer.toString(input));

        List<Integer> user = new ArrayList<>();
        while (user.size() < numberLength) {
            user.add(input % 10);
            input /= 10;
        }
        Collections.reverse(user);
        return user;
    }

    private static void checkInput(String input) {
        if (input.contains("0")) {
            throw new IllegalArgumentException("숫자 0은 포함될 수 없습니다.");
        }
        if (input.length() != numberLength) {
            throw new IllegalArgumentException("입력 숫자의 길이는" + numberLength + "이 되어야 합니다.");
        }
        if (deleteDuplicate(input).length() < 3) {
            throw new IllegalArgumentException("중복되는 숫자가 없어야 합니다.");
        }
    }

    private static String deleteDuplicate(String input) {
        String inputAfterDelete = "";
        for (int i = 0; i < input.length(); i++) {
            if(input.indexOf(input.charAt(i)) == i) {
                inputAfterDelete += input.charAt(i);
            }
        }
        return inputAfterDelete;
    }

    private static List<Integer> makeComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private static List<Integer> compareList(List<Integer> user, List<Integer> computer) {
        int ball = 0, strike = 0;
        int userIdx = 0, computerIdx = 0;
        do {
            if (user.get(userIdx).equals(computer.get(computerIdx)) && userIdx == computerIdx) {
                strike++;
            }
            if (user.get(userIdx).equals(computer.get(computerIdx)) && userIdx != computerIdx) {
                ball++;
            }
            computerIdx++;
            if (computerIdx == 3) {
                userIdx++;
                computerIdx = 0;
            }
        } while (userIdx != 3);
        List<Integer> ballStrike = new ArrayList<>();
        ballStrike.add(strike);
        ballStrike.add(ball);
        return ballStrike;
    }
}

