package baseball;

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
    }

    private static void startGame() throws IOException {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("숫자를 입력해주세요 : ");
        String userInputNumber = bf.readLine();
        verifyUserNumber(userInputNumber);
    }

    private static String verifyUserNumber(String number) {
        Scanner s = new Scanner(System.in);
        if (number.length() != 3) {
            throw new IllegalArgumentException("잘못된 입력입니다. 3자리 숫자를 입력해주세요.");
        }
        if (number.contains("0")) {
            throw new IllegalArgumentException("숫자 0은 포함될 수 없습니다.");
        }
        if (!number.contains("0") && number.length() < 3) {
            return number;
        }
        return number;
    }
}
