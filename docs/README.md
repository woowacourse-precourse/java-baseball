### 기능 목록
- Package players 기능 목록
  - Player: Computer, User의 객체 지향적 코드 설계를 위한 인터페이스
  - Computer.class
    - generateNumbers(): 컴퓨터가 서로 다른 임의의 3개의 수 생성
  - User.class
    - generateNumbers(): 입력받은 사용자의 3개의 숫자를 저장하는 기능
      - void checkError(String userNumbers) throws IllegalArgumentException: 예외처리
        - 스페이스 처리
        - 숫자 3개 입력했는지?
        - 숫자 대신 문자가 들어가있는 것은 아닌지?
        - 중복된 숫자가 입력된 것은 아닌지?
        
- Package playing 기능 목록
  - Play.class
    - startGame(): 게임 시작 문구 출력및 게임 시작을 위한 컴퓨터의 숫자 생성
    - void playingGame(): 사용자가 정답을 맞힐 때까지 숫자 야구 게임을 진행하는 메서드
    - void endGame(): 게임종료시 출력되는 문자열 출력
    - boolean replayGame(String replaying): 입력 받은 숫자로 게임 재시작(true) 또는 프로그램 종료(false)를 반환하는 기능
        - void checkInputErr(int replayNumber): 1 또는 2의 숫자가 아닌 경우 예외처리
  - StrikeOrBall.class
    - String printStrikeOrBall(String computerNumber, String userNumber)
      : 입력 받은 사용자의 숫자와 컴퓨터의 숫자를 비교해 입력한 수에 대한 결과를 볼, 스트라이크 개수로 표시하는 기능
    - Map<String, Integer> checkStrikeOrBall(String computerNumber, String userNumber)
      :볼, 스트라이크의 개수를 판단하는 기능
      - int Ball(List<Integer> computerNumberList, List<Integer> userNumberList): 볼 판단
      - int Strike(List<Integer> computerNumberList, List<Integer> userNumberList): 스트라이크 판단
      
- GameController.class
  - PlayGame 클래스를 통해 게임 실행하고 replayGame가 false를 반환할 때까지 반복적으로 실행

### 예외처리 목록
- 사용자가 3개의 숫자를 입력받을 때 중복되거나 범위를 벗어난 수를 입력하면 IllegalArgumentException 발생시킨 후 프로그램 종료.
- 게임 종료시 게임을 새로 시작할지 프로그램을 종료할지 입력받을 때, 범위를 벗어난 수를 입력 받으면 IllegalArgumentException 발생시킨 후 프로그램 종료.

### 구현하면서 지켜야할 목표
- depth를 줄이기 위해 기능을 메소드와 객체로 최대한 쪼개고 DI를 지키면서 프로그래밍한다.
- 단위 테스트를 통해 tdd를 하고, 통합 테스트 또한 진행한다.
- 깃 커밋 메시지의 컨벤션을 준수한다.
- 자바의 컨벤션을 준수한다.
- Collection 을 최대한 이용하며, 배열은 최대한 지양한다.
- 코드 한 줄에 점(.)을 두개 이상 사용하는 것을 최대한 지양한다.
- 인스턴스 변수를 3개 이하로 사용한다.
- 이름을 통해 변수나 메소드의 역할을 잘들어낼 수 있도록 이름을 신중하게 선정한다 -> 축약하지 않는다, 길어도 상관없다.
- Java API를 적극 활용한다. 
  ex) List<String> members = Arrays.asList("pobi", "jason");
  String result = String.join(",", members); // "pobi,jason"
- 의미 없는 주석은 달지 않는다.

