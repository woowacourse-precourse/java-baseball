#   기능목록

## 구조
-   Application
- Controller
- GameService
- domain
    - Game
    - User
- utils
    - Parser
    - RandomUtils
- view
    - RequestInput
    - SystemMessage

##  Computer

    * 1-9까지 중복 없는 난수 3개 발생

##  User
    * 숫자 3자리 입력
    * 3자리가 아니거나 숫자가 아닌 문자 입력시 예외 발생
    * 잘못된 값 입력시 `IllegalArgumentException` 발생 후 앱 종료

##  Game
    * 스트라이크, 볼 0개 : "낫싱"
    * 자리수와 숫자를 맞췄을 경우 : "스트라이크"
    * 숫자만 맞췄을 경우 : "볼"

## EndGame
    * 게임 종료 후 재시작(1) 또는 종료(2) 선택
    * 스트라이크 3개 : "3스트라이크" -> 게임종료
