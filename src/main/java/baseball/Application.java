package baseball;

public class Application {
    public static void main(String[] args){
        //TODO: 숫자 야구 게임 구현
        GameStarter gameStarter = new GameStarter();
        while(gameStarter.endCheck()){
                gameStarter.playGame();
        }
    }
}

