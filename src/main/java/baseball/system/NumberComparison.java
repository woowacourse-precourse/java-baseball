package baseball.system;

import java.util.*;

public class NumberComparison {

    private final int NUMBERS_SIZE = 3;
    private final int ANSWER_COUNT = 3;

    List<Integer> computerNumbers;
    List<Integer> userNumbers;

    public boolean startComparison(List<Integer> userNumbers) {

        setUserNumbers(userNumbers);

        int strikeCount = getStrikeCount();
        int ballCount = getBallCount(); //TODO : if문 다음으로 이동 시킬 것

        if (isAnswer(strikeCount)) {
            printAnswerText();
            return true;
        }

        if(isNothing(strikeCount,ballCount)){
            printNothingText();
            return false;
        }

        printStrikeBallCount(strikeCount,ballCount);
        return false;

    }

    private void printAnswerText() {
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private boolean isAnswer(int strikeCount) {
        return strikeCount == ANSWER_COUNT;
    }

    private int getBallCount() {

        int ballCount=0;

        for(int indexNumber = 0; indexNumber < NUMBERS_SIZE; indexNumber++){

            List<Integer> IndexNumbers = new ArrayList<>(Arrays.asList(0,1,2));
            IndexNumbers.remove(indexNumber);

            int userNumber = userNumbers.get(indexNumber);

            if(searchNumber(IndexNumbers,userNumber)){
                ballCount++;
            }

        }

        return ballCount;

    }

    private boolean searchNumber(List<Integer> indexNumbers, int userNumber) {

        for(int indexNumber = 0; indexNumber < NUMBERS_SIZE - 1; indexNumber++){
            int remainedIndexNumber = indexNumbers.get(indexNumber);
            if(userNumber == computerNumbers.get(remainedIndexNumber)){
                return true;
            }
        }
        
        return false;
        
    }

    private int getStrikeCount() {

        int strikeCount = 0;

        for(int indexNumber = 0; indexNumber < NUMBERS_SIZE; indexNumber++){
            if(userNumbers.get(indexNumber) == computerNumbers.get(indexNumber) ){
                strikeCount++;
            }
        }

        return strikeCount;
    }

    private void setUserNumbers(List<Integer> userNumbers) {
        this.userNumbers = userNumbers;
    }


}
