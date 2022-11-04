package baseball;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Application {
    public static class BaseBallGame{
        private static BaseBallGame gameProgram = new BaseBallGame();
        private BaseBallGame() {}

        public static BaseBallGame getGame() { return gameProgram; }

        public void gameStart () {
            System.out.println("숫자 야구 게임을 시작합니다.");
            inputNumber();
        }
        public int inputNumber(){
            System.out.print("숫자를 입력해주세요 : ");
            String inputNumber = Console.readLine();
            String inputNumberRegex = "^[1-9]{3}$";
            HashSet duplRemoveList = new HashSet(Arrays.asList(inputNumber.split("")));
            ArrayList<String> list = new ArrayList<>(duplRemoveList);
            String inputValidNumber = String.join("", list);

            System.out.println(inputValidNumber);

            if(!inputValidNumber.matches(inputNumberRegex)){
                System.out.println("Bad");
                // Error 처리 하기!
            }
            return Integer.parseInt(inputNumber);
        }

    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseBallGame baseballGame = BaseBallGame.getGame();

        while(true){
            baseballGame.gameStart();
        }

    }
}