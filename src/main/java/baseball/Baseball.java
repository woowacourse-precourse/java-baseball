package baseball;

import java.util.Map;

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
        resetTargetNumber();
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    // 게임 재시작 method
    public void restart(){
        resetTargetNumber();
        this.guessNumber = 0;
        this.ballCount = new BallCount();
    }

    // 게임 종료 method
    public void end(){
        this.Gaming = false;
    }

    // GuessNumber Setter method
    public void setGuessNumber(int guessNumber){
        if(!isValidNum(guessNumber)){
            end();
            throw new IllegalArgumentException();
        }

        this.guessNumber = guessNumber;
        ruleBallCount();
    }

    public void getBallCount(){
        this.ballCount.getBallCount();
    }

    public void getStrikeCount(){
        this.ballCount.getStrikeCount();
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

    // 1~9로 이루어진 세자리 정수인지 Validation
    private boolean isValidNum(int number){
        if(!checkSize(number)){
            return false;
        }
        if(!checkDigit(Integer.toString(number).toCharArray())){
            return false;
        }

        return true;
    }

    private boolean checkDigit(char[] numberCharArray){
        for(char numberChar : numberCharArray){
            if(numberChar == '0'){
                return false;
            }
            if(!Character.isDigit(numberChar)){
                return false;
            }
        }

        return true;
    }

    private boolean checkSize(int number){
        int size = (int)(Math.log10(number)+1);

        if(size != 3){
            return false;
        }
        return true;
    }

}
