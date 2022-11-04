package baseball;

public class BaseballGame {

    public void play(){

        View.printStartGame();
        do{
            playGame();
        }while(endGame());

    }

    public void playGame(){

    }

    private boolean endGame(){
        return true;
    }

    private String getUserInput(){
        return View.getUserInput();
    }

}
