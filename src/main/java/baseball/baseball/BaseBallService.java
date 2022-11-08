package baseball.baseball;

import baseball.dto.BaseBallGameInput;
import baseball.dto.BaseBallGameOutput;

public class BaseBallService {

    boolean[] isExist = new boolean[10];

    public BaseBallGameOutput playBall(BaseBallGameInput baseBallGameInput){
        String randomNumber = baseBallGameInput.getRandomNumber();
        setUpList(randomNumber);

        String guessNumber = baseBallGameInput.getGuessNumber();
        int ballCount = 0;
        int strikeCount = 0;
        for(int i=0;i<3;i++){
            if(guessNumber.charAt(i) == randomNumber.charAt(i)){
                strikeCount++;
            }else if(isExist[guessNumber.charAt(i) - '0']){
                ballCount++;
            }
        }

        return new BaseBallGameOutput(ballCount,strikeCount);
    }

    private void setUpList(String randomNumber) {
        for(int i=0;i<3;i++){
            int idx = randomNumber.charAt(i) - '0';
            isExist[idx] = true;
        }
    }
}
