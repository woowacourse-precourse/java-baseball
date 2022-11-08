package controller;

import model.Computer;
import model.User;
import utill.ConstantVO;
import utill.UseFunc;

public class GameController {

    User user;
    Computer computer;

    public GameController() {
        this.user = User.getInstanceUser();
        this.computer = Computer.getInstanceUser();
    }

    public void startGame() {
        computer.initComputer();
        computer.initCntStrikeBall();
    }

    public void callInputNumOfUser() {
        this.user.inputNumOfUser();
    }

    public void callInputProceedNum() {
        user.inputProceedNum();
    }

    public void reStartGame() {
        computer.initComputer();
        computer.initCntStrikeBall();
    }

    public void initCntStrikeBallOfComputer() {
        computer.initCntStrikeBall();
    }

    public void isRightNumOfUser2Computer() {
        int numInputOfUser = user.getNumSelecUser();
        computer.checkThreeInputNumOfUser2Game(numInputOfUser);
    }

    public boolean isEndGame() {
        if (computer.isEndTheGame()) {
            return true;
        }
        return false;
    }

    public String getHintOfComputer() {
        int numInputOfUser = user.getNumSelecUser();
        return computer.giveHint2User(numInputOfUser);
    }

    public static GameController getInstanceGameController() {
        return (new GameController());
    }


    public boolean isWantStopGameStopGame() {
        int numInputOfUser = user.getNumProceedUser();
        if (isEndGameUserWant(numInputOfUser)) {
            return true;
        }
        isReGameUserWant(numInputOfUser);
        return false;
    }

    private boolean isEndGameUserWant(int numInputOfUser) {
        if (UseFunc.isEqualIntOfTwo(numInputOfUser, ConstantVO.NUM_END_GAME)) {
            System.out.println(ConstantVO.MSG_GAME_END);
            return true;
        }
        return false;
    }

    private boolean isReGameUserWant(int numInputOfUser) {
        if (UseFunc.isEqualIntOfTwo(numInputOfUser, ConstantVO.NUM_RESTART_GAME)) {
            reStartGame();
            return true;
        }
        return false;
    }

}
