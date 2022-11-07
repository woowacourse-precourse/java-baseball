package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseBallGame {
    public static boolean playBaseBallGame() {
        // 랜덤으로 숫자 세개 생성
        AnswerNumber answerNumber = new AnswerNumber();
        int[] answer = new int[3];
        answer = answerNumber.getNumberArr();

        System.out.println("숫자 야구 게임을 시작합니다.");
        int strikeOut = 0;
        while (strikeOut != 3) {

            // 사용자 입력 받기, 입력 값 조건 충족 확인
            System.out.print("숫자를 입력해주세요 : ");
            String inputValue = Console.readLine();

            CheckInput.isInput(inputValue);

            strikeOut = BallCount.printBallCount(answer, inputValue);
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return newGameOrStopGame();

    }

    public static boolean newGameOrStopGame() {
        String str = Console.readLine();
        int value = Integer.parseInt(str);
        if(value == 1) {
            return true;
        }
        else if(value == 2){
            return false;
        }
        else if(str.isEmpty()) {
            throw new IllegalArgumentException();
        }
        else {
            throw new IllegalArgumentException();
        }

    }
}
