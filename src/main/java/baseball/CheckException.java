package baseball;

import java.util.List;
import java.util.ArrayList;


public class CheckException {

    /*
    *   사용자가 입력한 str의 길이가 length와 같지 않다면 IllegalArgumentException예외발생
    *
    * @param str 사용자가 입력한 문자열
    * @param length 문자열 길이
    * 
    * @throws java.long.IllegalArgumentException 잘못된 입력
    * 
    * @exception java.long IllegalArgumentException 사용자의 잘못된 입력 발생시
    * */
    public static void checkLength(String str, int length) throws IllegalArgumentException {
        /*길이 검사*/
        if (str.length() != length) {
            throw new IllegalArgumentException("길이가 " + length + "이 아닙니다.");
        }
    }

    /*
     *  사용자가 입력한 str내의 글자를 하나씩 검사하여 start와 end사이의 문자가 아닐 시
     *  IllegalArgumentException예외 발생
     *
     * @param str 사용자가 입력한 문자열
     * @param length 문자열 길이
     *
     * @throws java.long.IllegalArgumentException 잘못된 입력
     *
     * @exception java.long IllegalArgumentException 사용자의 잘못된 입력 발생시
     * */
    public static void checkChar(String str, char start, char end) throws IllegalArgumentException{
        /*문자 검사*/
        for (int i = 0; i < str.length(); i++) {

            char tmp = str.charAt(i);

            if (tmp < start || tmp > end) {
                throw new IllegalArgumentException(start + "~" + end + "범위내의 숫자가 아닙니다");
            }
        }
    }

    /*
     *  사용자가 입력한 str내에 중복된 문자가 있다면 IllegalArgumentException예외 발생
     *
     * @param str 사용자가 입력한 문자열
     *
     * @throws java.long.IllegalArgumentException 잘못된 입력
     *
     * @exception java.long IllegalArgumentException 사용자의 잘못된 입력 발생시
     * */
    public static void checkDup(String str) throws IllegalArgumentException{
        /*중복검사*/
        List<Character> check_input = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {

            Character tmp_char = new Character(str.charAt(i));

            if (check_input.contains(tmp_char)) {
                throw new IllegalArgumentException("중복된 숫자가 있습니다.");
            }

            check_input.add(tmp_char);
        }
    }


}
