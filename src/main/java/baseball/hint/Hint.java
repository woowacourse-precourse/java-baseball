package baseball.hint;

import java.util.List;

public class Hint {
    private int ball = 0;
    private int strike = 0;
    private static final String NOTHING = "낫싱";
    private static final String BALL = "볼 "; //뒤에 스트라이크가 붙을때 공백을 추가하기 위해 볼뒤에 공백까지 붙여서 저장함
    private static final String STRIKE = "스트라이크";
    private static final int WIN_COUNT = 3;
    private static final String WIN_STRING = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public Hint(List<Integer> computerNum, List<Integer> userNum){
        ball = 0;
        strike = 0;
        checkStrikeBall(computerNum, userNum);
    }

    public void checkStrikeBall(List<Integer> computerNum, List<Integer> playerNum){
        for(int i = 0; i < playerNum.size(); i++){
            int playerNumDigit = playerNum.get(i);
            if(computerNum.indexOf(playerNumDigit) == i){
                strike += 1;
            } else if (computerNum.indexOf(playerNumDigit) != i & computerNum.contains(playerNumDigit)) {
                ball += 1;
            }
        }
    }

    public String getHint(){
        StringBuilder strConnect = new StringBuilder();

        if (ball == 0 && strike == 0){
            return NOTHING;
        }
        if (ball > 0){
            strConnect.append(ball).append(BALL);
        }
        if (strike > 0){
            strConnect.append(strike).append(STRIKE);
        }

        return strConnect.toString();
    }

    public void printResult(){
        System.out.println(getHint());
    }

    public boolean checkWin(){
        if (strike == WIN_COUNT){
            System.out.println(WIN_STRING);
            return true;
        }
        return false;
    }
}

