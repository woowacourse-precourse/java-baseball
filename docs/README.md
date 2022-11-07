기능 목록
---
* 컴퓨터가 임의의 3자리 숫자를 선택하는 기능 (computerRandomThreeDigitNum)
* 사용자가 3자리의 숫자 문자열을 입력하는 기능 (userInputThreeDigitNum)
    * 문자열을 분리해 정수로 변환하는 기능 (splitStringAndParseInt)


* 두 숫자를 비교해 스트라이크, 볼 개수 세는 기능 (countStrikeAndBall, increaseStrikeCntAndBallCnt)
* 결과값(스트라이크 / 볼 / 낫싱) 출력하는 기능 (printBaseballResult)
* 3스트라이크인 경우 확인해 게임 종료하는 기능 (checkThreeStrike)
* 사용자가 1 입력 시 재시작, 2 입력 시 종료하는 기능 (userInputRestartOrFinish)

검증 & 예외처리 목록
---
* 숫자 예측 시 사용자 입력
    * 숫자로만 이루어졌는지 검증 (validateUserInputNumFormat)
      * ex) input = 1ab → 예외처리

    * 범위 검증(123 ~ 987) (validateUserInputNumRange)
      * ex) input = 1234 → 예외처리

    * 중복되는 수 없는지 검증 (validateUserNumListNoRepetition)
      * ex) input = 112 → 예외처리
 
    * 0 없는지 검증 (validateUserNumListNotContainZero)
      * ex) input = 450 → 예외처리


* 재시작 / 종료 선택 시 사용자 입력 검증(1 or 2) (validateUserInputCommand)
  * ex) input = 3 → 예외처리
  * ex2) input = a → 예외처리
