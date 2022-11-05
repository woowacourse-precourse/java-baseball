package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Baseball {

    public static final int MAX_SIZE = 3;
    int ballCount;
    int strikeCount;
    User user = new User();

    public void play() {
        strikeCount = 0;
        ballCount = 0;
        Computer computer = new Computer();
        ArrayList<String> computerBall = computer.createNumber();

        System.out.print("숫자를 입력해주세요: ");
        String inputNumbers = Console.readLine();

        ArrayList<String> userBall = user.input(inputNumbers);
        compare(computerBall,userBall);
    }

    public void compare(ArrayList<String> computerBall,ArrayList<String> userBall) {
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
}

