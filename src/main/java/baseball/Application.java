package baseball;

public class Application {
    public static void main(String[] args) {
        try{
            System.out.println("숫자야구 게임을 시작합니다.");
            Game game = new Game();
            game.play();
        } catch (IllegalArgumentException e){
            System.out.println( e.getMessage());
        }
    }
}
