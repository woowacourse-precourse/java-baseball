package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Baseball {

    public static final int MAX_SIZE = 3;

    public static final int RESTART = 1;
    public static final int GAME_END = 2;

    int ballCount;
    int strikeCount;
    User user = new User();

    public void play(ArrayList<String> computerBall) {
        strikeCount = 0;
        ballCount = 0;

        System.out.print("숫자를 입력해주세요: ");
        String inputNumbers = Console.readLine();

        ArrayList<String> userBall = user.input(inputNumbers);
        compare(computerBall, userBall);
        resultReturn();

        if (strikeCount != 3) {
            play(computerBall);
        }
    }

    public void compare(ArrayList<String> computerBall, ArrayList<String> userBall) {
        for (int i = 0; i < userBall.size(); i++) {
            if (computerBall.get(i).equals(userBall.get(i))) {
                strikeCount++;
                continue;
            }
            if (computerBall.contains(userBall.get(i))) {
                ballCount++;
            }
        }
    }

    public void resultReturn() {
        if (strikeCount == MAX_SIZE) {
            System.out.println(MAX_SIZE + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
        if (strikeCount != 0 && ballCount == 0) {
            System.out.println(strikeCount + "스트라이크");
        }
        if (strikeCount != 0 && ballCount != 0) {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        }
        if (strikeCount == 0 && ballCount != 0) {
            System.out.println(ballCount + "볼");
        }
        if (strikeCount == 0 && ballCount == 0) {
            System.out.println("낫싱");
        }
    }

    public boolean restart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int selectContinue = Integer.parseInt(Console.readLine());

        if (selectContinue == RESTART) {
            return true;
        }
        if (selectContinue == GAME_END) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }
}

