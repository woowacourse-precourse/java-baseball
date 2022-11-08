package io;

import camp.nextstep.edu.missionutils.Console;

public class IOProcessor {
    /*
     * message : 사용자 입력을 받기 전에 출력하는 메시지 본문
     * postfix : 메시지 뒤에 붙일 단어 (":", "\n" 등)
     * 결과적으로 값을 입력받기 전 "message + postfix" 형태의 문자열이 출력됨
     */
    public static String getUserInput(String message, String postfix) {
        System.out.print(message + postfix);
        return Console.readLine();
    }
}