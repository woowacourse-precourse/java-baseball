package baseball;

public class Result {

    private Integer strike;
    private Integer ball;

    public void setStrike(Integer strikeCnt) {
        this.strike = strikeCnt;
    }

    public void setBall(Integer ballCnt) {
        this.ball = ballCnt;
    }

    public void printResult() {
        if(ball>0) {
            System.out.print(ball + "볼 ");
        }
        if(strike>0) {
            System.out.println(strike + "스트라이크");

            if(strike==3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            }
        }
        if(ball==0 && strike==0) {
            System.out.println("낫싱");
        }
    }
}
