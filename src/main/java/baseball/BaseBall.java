package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class BaseBall {

    public void start() {
        BallList computer = BallList.computerBallList();
        BallList user;
        Check check;
        do {
            System.out.print("숫자를 입력해주세요 : ");
            user = BallList.userBallList();
            check = Check.checkBallList(computer, user);
            System.out.println(check.resultMessage());
        } while (check.result() == 0);

        int restart = reStartOrExit();
        if (restart == 1) {
            start();
        } else if (restart == 0) {
            System.out.print("게임을 종료합니다.");
        }


    }

    public int reStartOrExit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = readLine();
        if (input.equals("1")) {
            return 1;
        } else if (input.equals("2")) {
            return 0;
        } else {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }




}
