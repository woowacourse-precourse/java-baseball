package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class MyBalls {
    public MyBalls() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public List<Integer> inputBalls() {
        Scanner scanner = new Scanner(readLine());
        String myInputBalls = scanner.next();
        System.out.println("숫자를 입력해주세요 : " + myInputBalls);

        List<Integer> myBallNumbers = new ArrayList<>();
        for (int ballIndex = 0; ballIndex < 3; ballIndex++) {
            myBallNumbers.add(myInputBalls.charAt(ballIndex) - '0');
        }
        return myBallNumbers;
    }
}
