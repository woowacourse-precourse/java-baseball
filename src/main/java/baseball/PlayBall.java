package baseball;

public class PlayBall {
    private PlayBallUI playBallUI;
    private Computer computer;

    public void startInterface() {

        if (this.playBallUI == null){
            this.playBallUI = new PlayBallUI();
        }

        playBallUI.startInterface();
        setComputerNumber();
    }

    public void setComputerNumber(){
        computer = new Computer();
        computer.setComputerRandomNumber();
    }
}
