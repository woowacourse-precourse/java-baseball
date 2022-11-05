package baseball;

public class Baseball {
    private Boolean Gaming;
    private int targetNumber;
    private int guessNumber;
    private BallCount ballCount;

    // 생성자
    public Baseball(){ }


    // 메소드
    // 게임 시작 method
    public void start(){
        this.Gaming = true;
        this.resetTargetNumber();
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    // 게임 재시작 method
    public void restart(){
        this.resetTargetNumber();
        this.guessNumber = 0;
        this.ballCount = new BallCount();
    }

    // 게임 종료 method
    public void end(){
        this.Gaming = false;
    }

    // GuessNumber Setter method
    public void setGuessNumber(int guessNumber){

    }

    // 볼 카운트 Getter method
    public void getBallCount(){

    }

    // 스트라이크 카운트 Getter method
    public void getStrikeCount(){

    }

    // 결과 ENUM 출력 method
    public void getGuessResult(){

    }

    // 1에서 9까지 서로 다른 임의의 수 3개를 선택 method
    private void resetTargetNumber(){

    }

    // 볼 카운트 계산 method
    private void ruleBallCount(){

    }

    // 스트라이크 카운트 계산 method
    private void ruleStrikeCount(){

    }

}
