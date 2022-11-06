package baseball;

public class BaseBall {
    public void helloMessage(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public void play(){
        GameCycle gameCycle = new GameCycle();
        AfterGame afterGame = new AfterGame();
        helloMessage();
        while(true){
            gameCycle.play();
            if(!afterGame.play())break;
        }
    }

}
