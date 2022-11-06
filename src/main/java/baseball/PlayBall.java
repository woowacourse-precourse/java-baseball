package baseball;

public class PlayBall {
    private PlayBallUI playBallUI;

    public void startInterface() {

        if (this.playBallUI == null){
            this.playBallUI = new PlayBallUI();
        }

        playBallUI.startInterface();
    }

}
