package baseball.game;
import camp.nextstep.edu.missionutils.Console;
public class GameRestart {
   private CheckRestartNumberException checkRestartNumberException = new CheckRestartNumberException();

   public void gameRestart(){
      System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

      String restart = Console.readLine();

      if(restart.equals("1")){
         GameStart gameStart = new GameStart();
      }
      else if(restart.equals("2")){
         System.out.println("게임 종료");
      }
      else {
         checkRestartNumberException.checkException(restart);
      }
   }
}
