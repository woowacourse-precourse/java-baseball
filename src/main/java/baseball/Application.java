package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Application {
    public static void main(String[] args) throws IOException {
        System.out.println("숫자 야구 게임을 시작합니다. 룰은 다음과 같습니다.");
        System.out.println("숫자 야구 게임은 컴퓨터가 생성한 임의의 1-9사이의 3자리 수를 맞추는 게임입니다.");
        System.out.println("숫자가 포함되어 있으나 자리가 틀렸을 경우에는 볼, 숫자와 자리가 일치할 경우에는 스트라이크로 표기됩니다.");
        startGame();
    }

    public static void startGame() throws IOException {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        System.out.print("숫자를 입력해주세요 : ");
        String userInputNumber = Console.readLine();
        verifyUserNumber(userInputNumber);

        List<String> userNumberList = List.of(userInputNumber.split(""));

        int continueNum = CntBallAndStrike(computer, userNumberList);
        while (continueNum == 1) {
            System.out.print("숫자를 입력해주세요 : ");
            userInputNumber = Console.readLine();
            verifyUserNumber(userInputNumber);
            userNumberList = List.of(userInputNumber.split(""));

            continueNum = CntBallAndStrike(computer, userNumberList);
        }

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String options = Console.readLine();
        gameRestartOrOver(options);
    }

    public static void gameRestartOrOver(String options) throws IOException {
        if (options.equals("1")) {
            startGame();
        }
        if (options.equals("2")) {
            System.out.println("게임이 종료되었습니다.");
        }
        if (!options.equals("1") && !options.equals("2")) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    public static int CntBallAndStrike(List<Integer> computer, List<String> userNumberList) throws IOException {
        int ballCnt = 0;
        int strikeCnt = 0;
        
        for (int i = 0; i < computer.size(); i++) {
            if (computer.contains(Integer.parseInt(userNumberList.get(i))) && !computer.get(i).equals(Integer.parseInt(userNumberList.get(i)))) {
                ballCnt++;
            }
            if (computer.get(i).equals(Integer.parseInt(userNumberList.get(i)))) {
                strikeCnt++;
            }
        }

        String ballCntStr = ballCnt + "볼";
        String strikeCntStr = strikeCnt + "스트라이크";

        if (strikeCnt == 3) {
            System.out.println(strikeCntStr + "\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return 0;
        }
        if (ballCnt == 0 && strikeCnt == 0) {
            System.out.println("낫싱");
            return 1;
        }
        if (ballCnt > 0 || strikeCnt > 0) {
            if (strikeCnt == 0) {
                System.out.println(ballCntStr);
                return 1;
            }
            if (ballCnt == 0) {
                System.out.println(strikeCntStr);
                return 1;
            }
            if (ballCnt > 0 && strikeCnt > 0) {
                System.out.println(ballCntStr + " " + strikeCntStr);
                return 1;
            }
        }
        return 1;
    }

    public static String verifyUserNumber(String number) {
        Scanner s = new Scanner(System.in);
        if (number.length() != 3) {
            throw new IllegalArgumentException("잘못된 입력입니다. 3자리 숫자를 입력해주세요.");
        }
        if (number.contains("0")) {
            throw new IllegalArgumentException("숫자 0은 포함될 수 없습니다.");
        }
        return number;
    }
}