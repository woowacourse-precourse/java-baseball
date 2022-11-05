package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Baseball {
    private Boolean gaming;
    private List<Integer> targetNumber;
    private int guessNumber;
    private BallCount ballCount;

    // 생성자
    public Baseball(){ }


    // 메소드
    // 게임 시작 method
    public void start(){
        this.gaming = true;
        resetTargetNumber();
        this.ballCount = new BallCount();
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
        this.gaming = false;
    }

    // 현재 게임중인지 여부 method
    public boolean isGaming(){
        return gaming;
    }

    public void chooseContinue(){
        int isContinue = Integer.parseInt(Console.readLine());


        if(isContinue == 1){
            restart();
        } else if(isContinue == 2){
            end();
        }
    }

    // GuessNumber Setter method
    public void setGuessNumber(){
        System.out.print("숫자를 입력해주세요 : ");
        int guessNumber = Integer.parseInt(Console.readLine());

        if(!isValidNum(guessNumber)){
            end();
            throw new IllegalArgumentException();
        }

        this.guessNumber = guessNumber;
    }

    // GuessNumber에 대한 결과 출력 method
    public GuessResult getGuessResult(){
        ballCount = new BallCount();
        ballCount.ruleBallCount(this.targetNumber,this.guessNumber);
        ballCount.ruleStrikeCount(this.targetNumber,this.guessNumber);

        ballCount.printBallCount();

        return ballCount.getGuessResult();
    }

    // 1에서 9까지 서로 다른 임의의 수 3개를 선택 method
    private void resetTargetNumber(){
        int count = 0;
        targetNumber = new ArrayList<>();
        List<Integer> randomNumberList = new ArrayList<>();

        while (randomNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!randomNumberList.contains(randomNumber)) {
                randomNumberList.add(randomNumber);
                targetNumber.add(randomNumber);
                count++;
            }
        }
    }

    // 1~9로 이루어진 서로 다른 세자리 정수인지 Validation
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
