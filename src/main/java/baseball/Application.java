package baseball;

public class Application {
    public static void main(String[] args) {
        boolean gameContinue = true;
        BaseballManager baseballManager = new BaseballManager();
        baseballStart();
        while(gameContinue){
            baseballManager.startGame();
            baseballManager.playGame();
            gameContinue = baseballManager.restartGame();
        }
        baseballEnd();
    }

    public static void baseballStart(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void baseballEnd(){
        System.out.println("숫자 야구 게임을 종료합니다");
    }
}
