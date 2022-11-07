package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static List<Integer> randomNumber;


    public static class BaseBall{
        public int ball;
        public int strike;
        public String result;

        public BaseBall(List<Integer> userNumber){
            CountStrike(userNumber);
            this.ball = CountSameNum(userNumber) - strike;
            GetOutputResult();
        }

        private void GetOutputResult(){
            result = "";
            if(this.ball != 0)
                result += ball + "볼 ";
            if(this.strike != 0)
                result += strike + "스트라이크";
            if(result.isEmpty())
                result = "낫싱";
        }

        private void CountStrike(List<Integer> userNumber){
            this.strike = 0;
            for(int i =0; i < userNumber.size(); i++){
                if(userNumber.get(i) == randomNumber.get(i))
                    strike++;
            }
        }

        private int CountSameNum(List<Integer> userNumber){
            int count = 0;
            for(int i = 0; i < userNumber.size(); i++){
                if(randomNumber.contains(userNumber.get(i)))
                    count++;
            }
            return count;
        }
    }

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        StartGame();
    }

    public static void StartGame(){
        GetRandomNumber();
        boolean continueGame = true;
        while(continueGame){
            List<Integer> userNumber = GetInputNumber();
            if(userNumber == null) return;
            BaseBall baseBall = new BaseBall(userNumber);
            OutputString(baseBall.result,true);
            continueGame = !CheckGameEnd(baseBall);
        }
        CheckGameRestart();
    }

    private static void CheckGameRestart() {
        String userInput = GetUserInput("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.", true);
        if(userInput.equals("1"))
            StartGame();
    }

    private static boolean CheckGameEnd(BaseBall baseBall) {
        if(baseBall.strike == 3){
            OutputString("3개의 숫자를 모두 맞히셨습니다! 게임 종료",true);
            return true;
        }

        return false;
    }

    public static void OutputString(String str, boolean isLineBreak){
        if(isLineBreak)
            System.out.println(str);
        else
            System.out.printf(str);
    }

    public static List<Integer> GetInputNumber(){
        //잘못입력된 경우 추가 체크
        String userInput = GetUserInput("숫자를 입력해주세요 : ", false);

        if(!CheckMandatory(userInput))
            throw new IllegalArgumentException("입력을 잘못하여 게임이 종료됩니다.");

        return ParseStringToIntList(userInput);
    }

    public static List<Integer> ParseStringToIntList(String numStr){
        List<Integer> result = new ArrayList<>();
        for(String str : numStr.split("")){
            result.add(Integer.parseInt(str));
        }
        return result;
    }

    public static String GetUserInput(String str, boolean lineBreak){
        OutputString(str, lineBreak);
        String userInput = camp.nextstep.edu.missionutils.Console.readLine();
        return userInput;
    }

    /*
    입력이 잘못되었다고 판단 되는 경우
    1.글자가 3개가 아닌 경우
    2.글자에 숫자아닌 글자가 포함된 경우
    3.같은 숫자가 2개이상 포함된 경우
     */
    public static boolean CheckMandatory(String userInput){
        if(userInput.length() != 3) return false;

        boolean[] checkSameNumArray = new boolean[10];
        for(int i =0 ; i < 3; i++){
            char userInputWord = userInput.charAt(i);

            if(userInputWord < '0' || userInputWord >'9')
                return false;

            if(checkSameNumArray[userInputWord - '0'])
                return false;

            checkSameNumArray[userInputWord - '0'] = true;
        }

        return true;
    }


    public static void GetRandomNumber(){
        randomNumber = new ArrayList<>();
        while (randomNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!Application.randomNumber.contains(randomNumber)) {
                Application.randomNumber.add(randomNumber);
            }
        }
    }
}
