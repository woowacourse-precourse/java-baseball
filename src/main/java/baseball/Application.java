package baseball;
import java.util.List;
import Message.Gamestart;
import Message.Gamerestart;


public class Application {
    public static void main(String[] args) {
        Computer randomNum = new Computer();
        System.out.println("숫자 야구 게임을 시작합니다.");
        Gamestart gamestart = new Gamestart();
        Decide decide = new Decide();
        Gamerestart gamerestart = new Gamerestart();
        boolean again = true;

        while (again){
            List<Integer> computer = randomNum.cpuNumber();
            String result = "";
            while (!result.equals("3스트라이크")){
                result = decide.finalAnswer(computer, gamestart.playerNumber());
                System.out.println(result);
            }
            again = gamerestart.gamerestart();
        }
    }
}
