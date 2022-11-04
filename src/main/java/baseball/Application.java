package baseball;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseBallGame baseballGame = BaseBallGame.getGame();

        while(true){
            try{
                baseballGame.gameStart();
            } catch(IllegalArgumentException e){
                System.out.println(e);
                break;
            }
        }

    }
}