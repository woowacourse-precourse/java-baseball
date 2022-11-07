# 기능목록
## 4개 클래스로 구성(GameController, User, InputValidator, Computer)
* ### GameController
  * `ready`
    * User, Computer의 3자리 수 입력 및 생성
  * `isStrike`
    * 해당 인덱스의 수가 일치하는지 검사
  * `isBall`
     * 해당 숫자가 컴퓨터의 수에 있고, 해당 인덱스의 수가 다른지 검사
  * `generateOutput`
    * strike와 ball을 파라미터로 받아 출력할 String 생성하고 return
  * `judge`
    * 3개의 숫자에 대해 각각 `isStrike`, `isBall` 메소드를 활용 하여 스트라이크, 볼 개수 판단
    * `generateOutput`으로 받은 결과문을 출력
    * 결과가 3스트라이크일 경우 true return
  * `play`
    * 게임 시작 문구 출력
    * 게임 과정
      1. `judge`을 통해 결과(true, false) 받음
      2. 결과가 true라면 게임 종료
      3. 결과가 false라면 `getUsersNumber`를 이용해 사용자의 다음 수를 입력 받음
    * 게임 종료 후, 다시 시작/종료 여부 입력 받기

* ### User
  * 서로 다른 3개 숫자를 갖는 `List<Integer> numbers`와 `getter`, `setter`
  * 사용자 입력이 올바른 값인지 검증하는 `InputValidator inputvalidator`
  * `generateNumber`
    * 사용자의 3자리 수 입력 받기
    * `inputValidator`의 `validate`을 사용해 잘못된 값인지 검사
    * `setNumbers`를 사용해 `numbers`에 3자리 수 저장

* ### InputValidator
  * `isZeroAtFirst`
    * 입력 String 첫 자리가 0인지 검사
  * `checkLength`
    * 입력 String 길이가 3인지 검사
  * `countNumber`
    * 입력 String에 target의 등장 횟수를 return
  * `anyDuplicated`
    * [1, 9] 범위를 countNumber로 검사하여 두 번 이상 등장하는 수가 있으면 true return
  * `validate`
    * `isBlank`, `isZeroAtFirst`, `checkLength`, `anyDuplicated`를 사용해 잘못된 값인지 검사
    * Integer로 캐스팅이 불가능한 경우 또는 잘못된 값일 경우 `IllegalArgumentException` 발생 후 종료

* ### Computer
  * 서로 다른 3개 숫자를 갖는 `List<Integer> numbers`와 `getter`, `setter`
  * `generateNumber`
    * 상대방(컴퓨터)의 3자리 수 생성