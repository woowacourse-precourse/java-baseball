package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {

    /*
     * 게임의 엔진 역할을 하는 메인루프
     * 게임 진행에 필요한 각 클래스를 호출하고 프로세스에 따라 게임 진행
     */

    private static String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static String INPUT_GUIDE_MESSAGE = "숫자를 입력해주세요 : ";
    private static String INPUT_ERR = "입력이 잘못되었습니다.";
    private static String GAMEOVER_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static String END_GAME = "게임종료.";
    private static Computer com = new Computer();
    private static Judge judge = new Judge();
    private static String outputStr = "";

    public Game() {
        com.createNumber();
        judge.resetScore();
    }

    public void run() {
        boolean gameStatus = true;

        System.out.println(START_MESSAGE); // 게임 시작
        //System.out.println(com.getAnswer());

        while (gameStatus) {

            System.out.println(INPUT_GUIDE_MESSAGE);
            String inputStr = Console.readLine();

            // 입력 값 검증
            InputValidator valid = new InputValidator(inputStr);
            if (!valid.checkInput()) {
                System.out.println(INPUT_ERR);
                continue;
            }

            // 스코어 계산
            judge.setAnswerToJudge(com.getAnswer(), inputStr);
            judge.getScore();
            outputStr = judge.makeResultString();
            System.out.println(outputStr);

            if (judge.isGameOver()) {
                gameStatus = endGame();
            }

        }

    }

    private boolean endGame() {
        System.out.println(GAMEOVER_MESSAGE);
        String restart = Console.readLine();
        if (restart.equals("1")) // 재경기
        {
            com.createNumber();
            judge.resetScore();
            return true;
        } else {
            System.out.println(END_GAME);
            return false;
        }
    }

}
