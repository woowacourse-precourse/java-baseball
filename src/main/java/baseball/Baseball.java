package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Baseball {
    private boolean gaming;
    private int guessNumber;
    private List<Integer> targetNumber;
    private BallCount ballCount;

    public Baseball() {}


    // 메소드
    // 게임 시작 method
    public void start() {
        this.gaming = true;
        resetTargetNumber();
        this.ballCount = new BallCount();
        System.out.println(Constant.START_GAME);
    }

    // 게임 재시작 method
    public void restart() {
        resetTargetNumber();
        this.guessNumber = 0;
        this.ballCount = new BallCount();
    }

    // 게임 종료 method
    public void end() {
        this.gaming = false;
    }

    // 현재 게임중인지 여부 method
    public boolean isGaming() {
        return gaming;
    }

    public void chooseContinue() {
        int isContinue = Integer.parseInt(Console.readLine());

        if(isContinue == Constant.RESTART_INPUT_NUM) {
            restart();
        } else if(isContinue == Constant.END_INPUT_NUM) {
            end();
        }
    }

    public BallCount getBallCount() {
        return ballCount;
    }

    // GuessNumber Setter method
    public void setGuessNumber(int guessNumber) throws IllegalArgumentException {
        if(!isValidNum(guessNumber)) {
            end();
            throw new IllegalArgumentException();
        }

        this.guessNumber = guessNumber;
    }

    // GuessNumber에 대한 결과 출력 method
    public GuessResult getGuessResult() {
        ballCount = new BallCount();
        ballCount.ruleBallCount(this.targetNumber,this.guessNumber);
        ballCount.ruleStrikeCount(this.targetNumber,this.guessNumber);
        
        return ballCount.getGuessResult();
    }

    // 1에서 9까지 서로 다른 임의의 수 3개를 선택 method
    public void resetTargetNumber() {
        targetNumber = new ArrayList<>();
        List<Integer> randomNumberList = new ArrayList<>();

        while (randomNumberList.size() < Constant.GUESS_NUM_SIZE) {
            int number = Randoms.pickNumberInRange(Constant.GUESS_NUM_START_RANGE,Constant.GUESS_NUM_END_RANGE);
            if(!randomNumberList.contains(number)) {
                randomNumberList.add(number);
                targetNumber.add(number);
            }
        }
    }

    // 1~9로 이루어진 서로 다른 세자리 정수인지 Validation
    public boolean isValidNum(int number) {
        if(!checkSize(number) || !checkOverlapDigit(number)|| !checkDigit(Integer.toString(number).toCharArray())) {
            return false;
        }

        return true;
    }

    public boolean checkDigit(char[] numberCharArray) {
        for(char numberChar : numberCharArray) {
            if(numberChar == '0') {
                return false;
            }
            if(!Character.isDigit(numberChar)) {
                return false;
            }
        }

        return true;
    }

    public boolean checkOverlapDigit(int number){
        Set<String> numberDigitSet = Arrays.stream(String.valueOf(number).split(""))
                .collect(Collectors.toSet());

        return numberDigitSet.size() == Constant.GUESS_NUM_SIZE;
    }

    public boolean checkSize(int number) {
        int size = (int)(Math.log10(number)+1);

        if(size != Constant.GUESS_NUM_SIZE) {
            return false;
        }
        return true;
    }

}
