## 기능분석
1. 랜덤한 3개의 수를 생성한다. Random.pickNumberInRange() 활용한다.
```java
    List<Integer> createBaseballNumberList(){...};
```
2. 수를 입력한다 Console.readLine() 을 활용한다.
   - 1~9의 숫자만 가능
   - 중복 숫자는 x
   - 무조건 3자리 숫자이여야 함
   - 위의 조건이 아닐 시 IllegalArgumentException 예외처리한다.
```java
   void validateAnswer(String answer) {...};
   List<Integer> createInputNumberList(String input){...};
```
3. 입력한 숫자와 정답의 숫자가 위치가 동일한지 물어본다.
   - 수와 위치가 같다 -> 스트라이크 ++
   - 같은 숫자는 있으나 위치가 다르다 -> 볼 ++
   - 수가 모두 다르다 -> 낫싱
```java
    String refereeAnswer(Integer ballCount, Integer strikeCount){...};
    Map<String, Integer> createRefereeCount(List<Integer> baseballNumberList, List<Integer> inputNumberList){...};
```
4. 3스트라이크가 나오지 않을 시 2번으로 돌아간다.
```java
    void playingGame(List<Integer> baseballNumberList){...};
    boolean isClearGame(Integer strikeCount){...};
```
5. 3스트라이크가 나올 시 게임을 계속 할 것인지 그만 둘 것인지 물어본다.
    - 1 입력시 새로운 게임 시작 -> 1번으로 돌아간다.
    - 2 입력시 어플리케이션 종료
    - 1 or 2 를 제외한 모든 입력은 IllegalArgumentException 예외처리한다.
```java
    void BaseballGame(){...};
    boolean continueGame(){...};
    void validateFlag(String flag){...};
```