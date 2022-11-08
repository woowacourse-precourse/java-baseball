package baseball;

public class Application {

    public static String OK = "1";
    public static String NO = "2";
    public static void playBall (Computer computer, Player player){
        player.guessAnswer();
        computer.resetHintMap();
        computer.makeHintMap(player.Answer);
        computer.giveHint();
        askRestart(computer, player);
    }

    public static void askRestart(Computer computer, Player player){
        if(computer.is3Strike()){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            player.responseRestart();
            decideRestart(computer, player);
        }
        else{
            playBall(computer, player);
        }
    }

    public static void decideRestart(Computer computer, Player player){
        if(player.ResponseOfRestart.equals(OK)){
            resetGame(computer, player);
            computer.makeAnswer();
            playBall(computer, player);
        }
        else if(player.ResponseOfRestart.equals(NO)){
            System.out.println("게임 종료");
        }
    }

    public static void resetGame(Computer computer, Player player){
        computer.resetAll();
        player.resetAll();
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        Computer computer = new Computer();
        Player player = new Player();
        computer.makeAnswer();
        playBall(computer, player);
    }
}
