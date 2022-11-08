package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Game {
    int[] number = new int[3];

    Game() {
        int currentRandomNumber;
        int currentNumberIndex = 0;

        while (currentNumberIndex < 3) {
            currentRandomNumber = this.getRandomNumber();
            for (int num : number) {
                if (num == currentRandomNumber) {
                    number[currentNumberIndex] = currentRandomNumber;
                }
            }
        }
    }

    Game(String str) {
        for (int i = 0; i < 3; i++) {
            number[i] = Integer.parseInt(str.charAt(i) + "");
        }
    }

    private int getRandomNumber() {
        return pickNumberInRange(1, 9);
    }

    public static void init(Game computerAnswer) {
        Game answer = Game.getAnswer();
    }

    private static Game getAnswer() {
        System.out.println("숫자를 입력해주세요 : ");
        String userInput = readLine();
        Game.checkInputValue(userInput);

        return new Game(userInput);
    }

    private static void checkInputValue(String userInput) {
        if (!Game.checkInputLength(userInput)) {
            throw new IllegalArgumentException();
        }
        if (!Game.checkInputNumber(userInput)) {
            throw new IllegalArgumentException();
        }
        if (!Game.checkEqualNumber(userInput)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean checkInputLength(String str){
        return str.length() == 3;
    }

    private static boolean checkInputNumber(String str){
        try{
            int numberValue = Integer.parseInt(str);
        } catch(NumberFormatException e){
            return false;
        }
        char[] numberArray = new char[str.length()];
        for(int i=0; i<str.length(); i++){
            numberArray[i] = str.charAt(i);
        }
        for(int num : numberArray){
            if(num == '0'){
                return true;
            }
        }
        return false;
    }

    private static boolean checkEqualNumber(String str){
        char[] checkEqual = new char[str.length()];
        char[] word = new char[str.length()];
        for(int i=0; i<str.length(); i++){
            word[i] = str.charAt(i);
        }
        for(int i=0; i<str.length(); i++){
            for(int value : checkEqual){
                if(value == word[i]){
                    return false;
                }
                checkEqual[i] = word[i];
            }
        }
        return true;
    }
}