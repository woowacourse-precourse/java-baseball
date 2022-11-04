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
            try{
                inputNumber();
            } catch(IllegalArgumentException e){
                throw e;
            }
        }
        public int inputNumber(){
            System.out.print("숫자를 입력해주세요 : ");
            String inputStr = Console.readLine();
            boolean isValidInput = isValidInput(inputStr);
//            HashSet duplRemoveList = new HashSet(Arrays.asList(inputNumber.split("")));
//            ArrayList<String> list = new ArrayList<>(duplRemoveList);
//            String inputValidNumber = String.join("", list);
//
//            System.out.println(inputValidNumber);
//
//
//            return Integer.parseInt(inputNumber);
            return 1;
        }

        public boolean isValidInput(String inputStr){
            if(!is3DigitNumber(inputStr) || !isDiffDigitNumber(inputStr)){
                throw new IllegalArgumentException("서로 다른 세자리 수를 입력해주세요.");
                // Error 처리 하기!
            }

            return true;
        }

        public boolean is3DigitNumber(String inputStr){
            String inputNumberRegex = "^[1-9]{3}$";
            if(!inputStr.matches(inputNumberRegex)){
                return false;
            }
            return true;
        }


        public boolean isDiffDigitNumber(String inputStr){
            if(inputStr.charAt(0) == inputStr.charAt(1)
                    || inputStr.charAt(1) == inputStr.charAt(2)
                    || inputStr.charAt(0) == inputStr.charAt(2)
            ) {
                return false;
            }
            return true;
        }
    }
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