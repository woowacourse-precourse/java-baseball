package baseball.Service.impl;


import baseball.Model.BallCountItem;
import baseball.Model.NumberItem;
import baseball.Service.interfaces.CompareService;
import baseball.View.PrintInformationView;

import static baseball.Model.StatusItem.THREE_STRIKE_CORRECT;
import static baseball.Model.StatusItem.RE_COMPARE;

import java.util.List;


public class CompareServiceImpl implements CompareService {

    private final PrintInformationView printInformationView = new PrintInformationView();

    @Override
    public int compare(NumberItem computerNumberItem, NumberItem userNumberItem) {
        BallCountItem ballCountItem = new BallCountItem();
        List<Integer> computerNumber = computerNumberItem.getNumber();
        List<Integer> userNumber = userNumberItem.getNumber();

        for( int index = 0; index < userNumber.size() ; index++){
            if(userNumber.get(index).equals(computerNumber.get(index))) {
                ballCountItem.setStrike(ballCountItem.getStrike() + 1);
                System.out.println("strike count = " + ballCountItem.getStrike());
                continue;
            }
            if(computerNumber.contains(userNumber.get(index))){
                ballCountItem.setBall(ballCountItem.getBall()+1);
                System.out.println("ball count = " + ballCountItem.getBall());
            }
        }

        printInformationView.printResultMessage(ballCountItem.getStrike(), ballCountItem.getBall());
        if(ballCountItem.getStrike() == 3){
            return THREE_STRIKE_CORRECT;
        }
        return RE_COMPARE;
    }
}
