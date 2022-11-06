package baseball;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class BaseBall {

    public void start() {
        BallList computer;
        computer = BallList.computerBallList();
        BallList user;
        Check check;
        String input = "";

        do {
            System.out.print("숫자를 입력해주세요 : ");
            user = userBallList();
            check = Check.checkBallList(computer, user);
            System.out.println(check.resultMessage());
        }while (check.result()==0);

        int restart = reStartOrExit();
        if (restart==1) {
            start();
        } else if (restart==0) {
            System.out.print("게임을 종료합니다.");
        }


    }

    private int reStartOrExit() {
        String input = new String();
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        input = readLine();
        if (input == "1") {
            return 1;
        } else if (input == "2") {
            return 0;
        } else {
            System.out.println("잘못된 입력입니다.");
            reStartOrExit();
            return -1;
        }
    }

    public static BallList userBallList() {
        List<Ball> ballList = new ArrayList<>();

        while (ballList.size()==0) {
            String userBall = readLine();
            BallList.checkUserLength(userBall);
            for (int i=0;i<3;i++) {
                Ball ball = new Ball(Character.getNumericValue(userBall.charAt(i)));
                ballList.add(ball);
            }
        }

        return new BallList(ballList);
    }

}
