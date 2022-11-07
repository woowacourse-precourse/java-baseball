package baseball;

import java.util.ArrayList;

public class BaseballController {

    private final BaseballModel model = new BaseballModel();
    private final BaseballView view = new BaseballView();

    private int ballCount = 0;
    private int strikeCount = 0;

    public BaseballModel getModel() {
        return model;
    }

    public BaseballView getView() {
        return view;
    }

    private void resetBallCount() {
        strikeCount = 0;
        ballCount = 0;
    }

    private void increaseStrikeCount() {
        strikeCount++;
    }

    private void increaseBallCount() {
        ballCount++;
    }

    private int getStrikeCount() {
        return strikeCount;
    }

    public void compareNumbers() {
        compareRow();
    }

    private void compareRow() {

        for(int i = 0 ; i < 3 ; i++) {
            compareCol(i,view.getInputNumbers().get(i));
        }

    }

    private void compareCol(int index, int num){
        ArrayList<Integer> targetNumbers = model.getTargetNumbers();

        for(int i = 0; i < 3 ; i++) {
            int targetNumber = targetNumbers.get(i);
            if(num == targetNumber) {
                distinctionBall(index, i);
            }
        }
    }

    private void distinctionBall(int rowIndex, int colIndex){
        if(rowIndex == colIndex) {
            increaseStrikeCount();
            return;
        }
        increaseBallCount();
    }

    public void startBaseBall() {
        model.createTargetNumberList();
        while(true) {
            resetBallCount();
            view.inputPlayerNumber();
            compareNumbers();
            view.printBallcount(strikeCount,ballCount);
            if(getStrikeCount() == 3) {
                break;
            }
        }

    }

    public boolean checkEndGame() {
        return view.continueGame() == 2;
    }
}
