# 구현기능
<hr>


##`<Class> Computer`
  
  - `private List<Integer> answerNumber`
    - 컴퓨터의 숫자를 저장하는 변수 (정답을 저장하는 변수)


  - `private Integer strike`
  - `private Integer ball`
      - 유저의 입력값이 들어왔을때 해당 값의 strike와 ball을 저장할 변수


  - `public void makeAnswerNumber()`
      - 임의의 다른 숫자 3개를 만드는 메소드
      - 게임 관점에서는 정답 숫자를 의미함.


  - `public Integer checkStrike(int userNumber, int idx)`
      - input으로 들어오는 숫자로 strike인지 검사하는 메소드


  - `public Integer checkBall(int userNumber, int idx)`
      - input으로 들어오는 숫자로 ball인지 검사하는 메소드


  - `public void checkNumberCount(List<Integer> userNumber)`
      - checkStrike, checkBall 메소드를 활용하여 유저 입력이 몇개의 스트라이크와 볼을 가지는지 체크함.


  - `public void clearNumberCount()`
      - ball 과 strike 를 초기화 함 ( 0으로 )


  - `public String countResultString()`
      - ball 과 strike 개수에 따라 출력할 메세지를 return 해주는 메소드 ( 볼 or 스트라이크 or 낫싱 .. )


  - `public Integer getStrike()`
      - strike의 개수 return


##`<Class> Application`

- `public void checkExceptionFromUserInputData(String userNumber)`
  - 유저에게 게임을 더 진행할 지 입력받은 수가 valid 한지 검사한다. ( 1 or 2 )
  - 잘못된 값이 들어오면 IllegalArgumentException 반환 
  

- `public static void main(String[] args)`
    - 게임을 시작하는 메소드, 일종의 게임의 메인화면이라고 생각할 수 있으며 게임을 시작하고, 끝나면 더할지 물어본다.

## `<Class> Game`

  - `public List<Integer> makeUserNumberToList(String userNumber)`
    - 유저가 입력한 값이 들어오면 Integer형 List로 바꾸어줌


  - `public void checkExceptionFromUserInputData(String userNumber)`
      - 유저가 정답을 맞추기 위해 입력한 값이 잘못되어있는지 검사하는 메소드
      - 3글자가 아니거나, 숫자가 아니거나, 중복되는 숫자가 있으면 IllegalArgumentException 반환


  - `public void gameStart()`
      - game 을 시작하는 메소드
      - 정답을 설정하고, 값을 입력받으며 정답이 맞는지 검사하는 일련의 게임과정을 담당하는 메소드