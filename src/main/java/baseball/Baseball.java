package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

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
    public void getGuessResult(){
        int guessBallCount = ballCount.getBallCount();
        int guessStrikeCount = ballCount.getStrikeCount();

        if((guessBallCount != 0) && (guessStrikeCount !=0)){
            System.out.println(guessBallCount+"볼 "+guessStrikeCount+"스트라이크");
            setGuessNumber();
        } else if((guessBallCount == 0) && (guessStrikeCount ==0)){
            System.out.println("낫싱");
            setGuessNumber();
        } else if(guessStrikeCount == 3){
            System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            chooseContinue();
        }
    }

    private void chooseContinue(){
        String isContinue = Console.readLine();

        if(isContinue == "1"){
            restart();
        } else if(isContinue == "2"){
            end();
        }
    }

    // 1에서 9까지 서로 다른 임의의 수 3개를 선택 method
    private void resetTargetNumber(){
        int targetNumber = 0;
        List<Integer> randomNumberList = new ArrayList<>();

        for(int i = 0; i < 3; i++){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!randomNumberList.contains(randomNumber)) {
                randomNumberList.add(randomNumber);
                targetNumber += randomNumber * Math.pow(10,i);
            }
        }

        this.targetNumber = targetNumber;
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
