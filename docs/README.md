# 기능목록
## 3개 클래스로 구성(GameController, User, Computer)
* ### GameController
  * `ready`
    * User, Computer의 3자리 수 입력 및 생성
  * `isStrike`
    * 해당 인덱스의 수가 일치하는지 검사
  * `isBall`
     * 해당 숫자가 컴퓨터의 수에 있고, 해당 인덱스의 수가 다른지 검사
  * `judge`
    * 3개의 숫자에 대해 각각 `isStrike`, `isBall` 메소드를 활용 하여 스트라이크, 볼 개수 판단
    * 결과가 0스트라이크, 0볼이면 '낫싱' 출력 후 false return
    * '낫싱' 조건과 종료 조건이 아니라면 결과 출력 후 false return
    * 결과가 3스트라이크일 경우 종료 문구 출력하고 true return
  * `play`
    * 게임 시작 문구 출력
    * 게임 과정
      1. `judge`을 통해 결과(true, false) 받음
      2. 결과가 true라면 게임 종료
      3. 결과가 false라면 `getUsersNumber`를 이용해 사용자의 다음 수를 입력 받음
    * 게임 종료 후, 다시 시작/종료 여부 입력 받기

* ### User
  * 서로 다른 3개 숫자를 갖는 `List<Integer> numbers`와 `getter`, `setter`
  * `generateNumber`
    * 사용자의 3자리 수 입력 받기
  * `isLegalNumber`
    * 사용자의 입력이 요구 사항에 부합하는지 검사(서로 다른 3자리 수)
    * 잘못된 값일 경우 `IllegalArgumentException` 발생 후 종료
    * 잘못된 값의 경우
      * Integer로 캐스팅이 불가능한 경우
      * 길이가 3이 아니거나, 첫자리에 0이 있는 경우
      * 같은 숫자가 2번 이상 등장하는 경우
  * `countNumber`
    * 특정 숫자를 검사하여 사용자 입력에서 해당 숫자의 등장 횟수를 구한다

* ### Computer
  * 서로 다른 3개 숫자를 갖는 `List<Integer> numbers`와 `getter`, `setter`
  * `generateNumber`
    * 상대방(컴퓨터)의 3자리 수 생성