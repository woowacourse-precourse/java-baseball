package baseball;

import java.io.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
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


}

