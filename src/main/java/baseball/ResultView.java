package baseball;

public class ResultView {
    public void printResult(PlayResult playResult){
        int strike = playResult.getStrike();
        int ball = playResult.getBall();

        if(strike == 3){
            System.out.println("3스트라이크");
        } else if(strike == 0 && ball == 0){
            System.out.println("낫싱");
        } else if (strike != 0 && ball !=0) {
            System.out.println(ball+"볼 "+strike+"스트라이크");
        } else if (strike != 0) {
            System.out.println(strike+"스트라이크");
        } else {
            System.out.println(ball+"볼");
        }
    }

    public void printEndGame(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
