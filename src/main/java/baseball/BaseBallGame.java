package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

class BaseBallGame {
    private static BaseBallGame gameProgram = new BaseBallGame();
    private BaseBallGame() {}

    public static BaseBallGame getGame() { return gameProgram; }

    public void gameStart () {
        System.out.println("숫자 야구 게임을 시작합니다.");
        try{
            int userNumber = inputNumber();
            int computerNumber = getRandomDiff3DigitNumber();
        } catch(IllegalArgumentException e){
            throw e;
        }
    }
    private int inputNumber(){
        System.out.print("숫자를 입력해주세요 : ");
        String inputStr = Console.readLine();
        inputValidation(inputStr);
        return Integer.parseInt(inputStr);
    }

    private void inputValidation(String inputStr){
        if(!is3DigitNumber(inputStr) || !isDiffDigitNumber(inputStr)){
            throw new IllegalArgumentException("서로 다른 세자리 수를 입력해주세요.");
        }
    }

    private boolean is3DigitNumber(String inputStr){
        String inputNumberRegex = "^[1-9]{3}$";
        if(!inputStr.matches(inputNumberRegex)){
            return false;
        }
        return true;
    }


    private boolean isDiffDigitNumber(String inputStr){
        if(inputStr.charAt(0) == inputStr.charAt(1)
                || inputStr.charAt(1) == inputStr.charAt(2)
                || inputStr.charAt(0) == inputStr.charAt(2)
        ) {
            return false;
        }
        return true;
    }

    private int getRandomDiff3DigitNumber(){
        String usedNumber = "";
        String randomDiff3DigitNumber = "";

        while(randomDiff3DigitNumber.length() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!usedNumber.contains(Integer.toString(randomNumber))){
                randomDiff3DigitNumber += Integer.toString(randomNumber);
            }
        }

        return Integer.parseInt(randomDiff3DigitNumber);
    }
}
