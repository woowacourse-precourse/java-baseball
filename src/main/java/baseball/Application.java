package baseball;

import java.io.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static void computerRandomNumber(final List<String> answerNumber){
        for(int i=1; i<4; i++){
            String number= String.valueOf(pickNumberInRange(1,9));
            answerNumber.add(number);
        }
    }

    public void gameStartMessage (){
        Console console = System.console();
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.println("숫자를 입력 해 주세요.");
    }

    public void inputUserPickNumber(String userPickNumber){
        Console console = System.console();
        String userPicNumber = console.readLine();

    }
    public static void arrUserNumber(String userPickNumber, List<String >listUserNumber ){
        for(int i = 0; i<userPickNumber.length(); i++) {
            char splitNumber = userPickNumber.charAt(i);
           listUserNumber.add(String.valueOf(splitNumber));
        }
    }

    public static int howManyStrike (List<String>listUserNumber, List<String>computerNumber){
        int strikeCount = 0;
       for(int i = 0; i<listUserNumber.size(); i++){
           String userPickNUmber = listUserNumber.get(i);
           String answerNumber = computerNumber.get(i);
           if(Objects.equals(userPickNUmber, answerNumber)){
               strikeCount++;
           }
       }return strikeCount;
    }





}

