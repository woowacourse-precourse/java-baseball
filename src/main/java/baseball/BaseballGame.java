package baseball;

public class BaseballGame {

    public void play(){

        View.printStartGame();
        do{
            playGame();
        }while(isEndGame());

    }

    public void playGame(){

    }

    private boolean isEndGame(){
        return  true;
    }

    private String getUserInput(){
        return View.getUserInput();
    }

}
