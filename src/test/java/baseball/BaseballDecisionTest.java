package baseball;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class BaseballDecisionTest {

    @Test
    void makeDecision() {
        ByteArrayInputStream in = new ByteArrayInputStream("178".getBytes());
        System.setIn(in);

        NumberHandler numberHandler = new NumberHandler();
        numberHandler.setUserNumber();

        System.out.println("computerNumber = " + numberHandler.getComputerNumber());
        System.out.println("userNumber = " + numberHandler.getUserNumber());

        BaseballDecision referee = new BaseballDecision(numberHandler);

        referee.makeDecision();

        System.out.println("strike : " + referee.getStrikeCount());
        System.out.println("ball : " + referee.getBallCount());
        System.out.println("nothing : " + referee.getNothingFlag());

    }

    @Test
    void stringify() {
        NumberHandler numberHandler = new NumberHandler();
        BaseballDecision referee = new BaseballDecision(numberHandler);

        referee.setBallCount(1);
        referee.setStrikeCount(2);
        referee.setNothingFlag(false);
        System.out.println("referee = " + referee);
    }
}