package baseball.Service.impl;


import baseball.Model.BallCountItem;

import baseball.Model.NumberItem;

import baseball.Service.interfaces.CompareService;

import static baseball.View.PrintInformationView.printResultMessage;

import static baseball.Model.StatusItem.THREE_STRIKE_CORRECT;
import static baseball.Model.StatusItem.RE_COMPARE;

import java.util.List;


public class CompareServiceImpl implements CompareService {

    static BallCountItem ballCountItem = new BallCountItem();
    static List<Integer> computerNumber;
    static List<Integer> userNumber;
    @Override
    public int compare(NumberItem computerNumberItem, NumberItem userNumberItem) {
        ballCountItem.initialization();
        computerNumber = computerNumberItem.getNumber();
        userNumber = userNumberItem.getNumber();

        for( int index = 0; index < userNumber.size() ; index++){
            if(userNumber.get(index).equals(computerNumber.get(index))) {
                ballCountItem.setStrike(ballCountItem.getStrike() + 1);
                continue;
            }
            if(computerNumber.contains(userNumber.get(index))){
                ballCountItem.setBall(ballCountItem.getBall()+1);
            }
        }

        printResultMessage(ballCountItem.getStrike(), ballCountItem.getBall());
        if(ballCountItem.getStrike() == 3){
            return THREE_STRIKE_CORRECT;
        }
        return RE_COMPARE;
    }
}
