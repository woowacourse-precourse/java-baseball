package baseball.service;

import baseball.model.HintReq;

import java.util.List;

import static baseball.controller.BaseballController.NUM_LENGTH;

public class HintProviderService {

    public static HintReq Hint(List<Integer> computerNum, List<Integer> userNum){
        return new HintReq(ballCount(computerNum,userNum),strikeCount(computerNum,userNum));
    }


    public static int ballCount(List<Integer> computerNum, List<Integer> userNum) {
        int count = 0;

        for(int i=0; i<NUM_LENGTH; i++){
            if (computerNum.get(i) != userNum.get(i) && computerNum.contains(userNum.get(i)))
                count++;
        }

        return count;
    }


    public static int strikeCount(List<Integer> computerNum, List<Integer> userNum) {
        int count = 0;

        for(int i=0; i< NUM_LENGTH; i++){
            if (computerNum.get(i) == userNum.get(i))
                count++;
        }

        return count;
    }
}
