난수 3개를 List로 리턴하는 함수

사용자의 입력을 검사하는 함수 2~3개

스트라이크의 갯수를 카운팅하는 함수

볼의 갯수를 카운팅하는 함수

스트라이크와 볼의 갯수를 세어 ?볼 ?스트라이크 리턴하기

낫싱은 함수로할지 말지 생각해보기

//////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////

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
public static void checkLength(String str, int length) throws IllegalArgumentException


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
public static void checkChar(String str, char start, char end) throws IllegalArgumentException

  
/*
*  사용자가 입력한 str내에 중복된 문자가 있다면 IllegalArgumentException예외 발생
*
* @param str 사용자가 입력한 문자열
*
* @throws java.long.IllegalArgumentException 잘못된 입력
*
* @exception java.long IllegalArgumentException 사용자의 잘못된 입력 발생시
* */
public static void checkDup(String str) throws IllegalArgumentException


/*
*   computerInput과 playerInput을 비교하여 같은 인덱스에 같은 값이 있다면 해당 값을
*   computerInput과 playerInput내에서 삭제하고 스트라이크 카운트를 1증가 시킨다.
*
* @param computerInput 중복없는 3개의 난수
*   1~9사이의 중복없는 3개의 난수가 들어있다.
* @param playerInput
*   사용자가 입력한 1~9사이의 숫자 3개가 들어있다.
*
* @return 스트라이크의 갯수
* */
public static int getStrikeCount(List<Integer>computerInput, List<Integer>playerInput)


/*
* computerInput내에 playerInput의 인자가 있다면 삭제하고 볼카운트를 1 증가시킨다.
*
* @param computerInput 중복없는 3개 이하의 난수
*   1~9사이의 중복없는 3개이하의 난수가 들어있다.
* @param playerInput
*   사용자가 입력한 1~9사이의 숫자 3개이하가 들어있다.
*
* @return 볼의 갯수
* */
public static int getBallCount(List<Integer> computerInput, List<Integer> playerInput)


/*
*  ballCount와 strikeCount의 갯수에 따라 볼과 스트라이크 여부를 리턴한다.
*
* @param ballCount 볼의 갯수
* @param strikeCount 스트라이크 갯수
*
* @return 결과값을 리턴한다
* (예 : 1볼 1스트라이크)
* */
public static String getResult(int ballCount, int strikeCount)


/*
*   computerInput을 기준으로 게임을 시작한다.
*   (어떻게 설명해야할지를 모르겠습니다. 하나하나 적자니 너무 난잡하고 너무 간단하게 적자니 모호한거같습니다.)
*
* @param computerInput 중복없는 3개의 난수
*   1~9사이의 중복없는 3개의 난수가 들어있다.
*
* @throws IllegalArgumentException 사용자의 잘못된 입력
*
* @return 결과값을 리턴함
*   (예 : 1볼 1스트라이크, 낫싱)
* */
private String startGame(List<Integer> computerInput) throws IllegalArgumentException


/*
*   1~9사이의 난수 3개를 리스트에 넣는다.
*
* @return 난수 리스트
*   중복없는 3개의 난수가 있는 리스트
* */
public static List<Integer> getComputerInput()


/*
*   게임을 끝났을때 1을 입력하면 게임을 다시시작하고 2를 입력하면 종료한다.
*
* @throws java.long.IllegalArgumentException 사용자의 잘못된 입력
*
* @exception java.long.IllegalArgumentException 사용자의 잘못된 입력
*   중복, 글자 수 초과, 설정한 아스키코드 내의 문자 아닐 시 발생
* */
public void play() throws IllegalArgumentException