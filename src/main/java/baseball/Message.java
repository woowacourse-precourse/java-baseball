package baseball;

public class Message {
    static final int SIZE = 3;
    static final String GAME_START_MSG = "숫자 야구 게임을 시작합니다.";
    static final String NUMBER_INPUT_MSG = "숫자를 입력해주세요 : ";
    static final String BALL_MSG = "볼";
    static final String STRIKE_MSG = "스트라이크";
    static final String NOTHING_MSG = "낫싱";
    static final String VICTORY_MSG = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    static final String RESTART_MSG = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void gameStartMsg(){
        System.out.println(GAME_START_MSG);
    }

    public void numberInputMsg(){
        System.out.print(NUMBER_INPUT_MSG);
    }

    public void countBallAndStrikeMsg(int ball, int strike){
        if(strike == SIZE) {
            System.out.println(VICTORY_MSG);
        }

        else if (ball == 0 && strike == 0){
            System.out.println(NOTHING_MSG);
        }

        else if (ball != 0 && strike != 0){
            System.out.println(ball + BALL_MSG + " " + strike + STRIKE_MSG);
        }

        else if (ball == 0){
            System.out.println(ball + BALL_MSG);
        }

        System.out.println(strike + STRIKE_MSG);
    }

    public void restartMsg(){
        System.out.println(RESTART_MSG);
    }
}
