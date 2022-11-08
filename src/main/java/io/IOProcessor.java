package io;

import camp.nextstep.edu.missionutils.Console;

public class IOProcessor {
    /*
    * 사용자로부터 받은 입력값을 문자열의 형태로 반환
    */
    public static String getUserInput(String message, String postfix) {
        // message : 사용자 입력을 받기 전에 출력하는 메시지 본문
        // postfix : 메시지 뒤에 붙일 단어 (":", "\n" 등)
        System.out.print(message + postfix);
        return Console.readLine();
    }
}