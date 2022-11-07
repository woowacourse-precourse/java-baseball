# 🚀 기능 목록
##  (void)baseballGameStart()
- [x] "숫자 야구 게임을 시작합니다."를 출력

## (List<Integer>)randomNumberCreate()
- [x] 세자리수의 난수 생성

## (void)userNumberMessagePrint()
- [ ] printMessage에 "숫자를 입력하세요 : "를 저장
- [x] printMessage를 출력

## (String word)userNumberInput()
- [x] readLine()함수를 통해 사용자에게 받은 입력값을 userNumber에 저장
- [x] userNumber을 리턴

## (void)availableUserNumberIsChecked(String word)
- [x] 0~9까지의 서로 다른 숫자인지 확인하는 정규표현식을 regularExpression에 저장한다.
- [x] 매개변수가 regularExpression으로 참인지 거짓인지 판별
- [x] 거짓이면, "유효하지 않은 값입니다"를 출력
- [x] 거짓이면, inputAvailableUserNumberService함수를 실행

## (List)stringToListCreate(String word)
- [x] stringToArray에 매개변수를 배열형태로 변환하여 선언
- [x] arrayToList에 stringToArray을 List형태로 변화하여 선언
- [x] 이때 arrayTo/list에 요소가 중복이면 에외 처리 실행
- [x] arrayToList를 리턴

## (int)checkStrikeNumbers(List computerNumbers,List userNumbers)
- [x] 같은 자리와 같은 수인 숫자들의 개수를 저장하는 checkedStrikeNumbers를 0으로 선언한다.
- [x] 매개변수들의 길이 만큼 반복하여, Strike인지 확인
- [x] 값이 같으면, checkedStrikeNumbers에 1을 더함
- [x] checkedStrikeNumbers을 리턴

## (int)checkedBallNumbers(List computerNumbers,List userNumbers)
- [x] 하나의 매개변수 안에 다른 매개변수의 요소가 포함되는 갯수를 checkedBallNumbers를 0으로 선언한다.
- [x] 매개변수들의 길이 만큼 반복하여, Ball인지 확인.
- [x] userNumbers의 요소가 computerNumbers에 포함되면, checkedBallNumbers에 1을 더함.
- [x] checkedBallNumbers를 리턴

## (Map)calculatedStrikeBallNumber(int strikeNumber, int ballNumber)
- [x] skrike와 ball의 갯수를 저장할 map 타입의 checkedBaseballNumbers을 strike: 0, ball: 0으로 초기화
- [x] strikeNumber이 0보다 크거나 같고 3보다 작거나 같은지 확인
- [x] true이면 checkBaseBallNumbers의 strike : strikeNumber, ball : ballNumber - strikeNumber로 초기화
- [x] checkedBaseballNumbers을 리턴

## (boolean)printBaseballOfResult(Map<String,Integer> result)
- [x] 매개변수들을 strikeNumber와 ballNumber에 저장
- [x] strikeNumber이 3인지 비교
- [x] true이면, "3스트라이크" 출력
- [x] true을 리턴
- [x] strikeNumber가 0이고, ballNumber가 0인지 비교
- [x] true이면 "낫싱" 출력
- [x] strikeNumber가 0이고, ballNumber가 0보다 큰지 비교
- [x] true이면 "ballNumber + 볼" 출력
- [x] ballNumber이 0이고, strikeNumber이 0보다 큰지 비교
- [x] true이면, "strikeNumber + 스트라이크" 출력
- [x] ballNumber이 0보다 크고, strikeNumber이 0보다 큰지 비교
- [x] true이면 "ballNumber + 볼 strikeNumber + 스트라이크"을 출력
- [x] false을 리턴

## (void)printToRestartingGameMessage()
- [x] "3개의 숫자를 모두 맞히셨습니다! 게임 종료" 출력
- [x] "게임을 새로 시작하려면 1, 종류하려면 2를 입력하세요." 출력

## (String)inputUserAnswer()
- [x] userAnswer에 readLine함수를 이용하여 사용자의 응답을 입력
- [x] userAnswer을 리턴

## (void)availableUserAnswerIsChecked(String word)
- [x] userAnswer에 매개변수를 저장
- [x] regularExpression에 한자리 숫자인 1 또는 2 인지 확인하는 정규표현식을 초기화.
- [x] userAnswer이 regularExpression에 유효한지 비교값을 result에 저장
- [x] result가 false이면 예외 상황 발생

## (String)inputAvailableUserNumberService()
- [x] 사용자가 입력하는 숫자를 저장하는 변수, userNumber을 0으로 초기화
- [x] userNumberMessagePrint함수를 실행
- [x] userNumberInput함수를 실행
- [x] availableUserNumberIsChecked함수를 실행
- [x] userNumber를 리턴

## (void)inputUserNumberService(List computerNumbersList)
- [x] inputAvailableUserNumberService함수에서 출력값을 저장하는 stringBuildUserNumber을 ""으로 초기화
- [x] 사용자가의 수가 컴퓨터의 수와 동일한지 비교후 결과값을 저장하는 checkedAnswer을 false로 초기화
- [x] computerNumbersList에 randomNumberCreate함수를 실행한 결과를 저장.
- [x] inputAvailableUserNumberService함수를 실행
- [x] StringToList함수를 실행
- [x] checkStrickNumbers함수를 실행
- [x] checkedBallNumbers함수를 실행
- [x] calculatedStrikeBallNumber함수를 실행
- [x] printBaseballOfResult함수를 실행 후 결과값을 checkedAnswer에 저장
- [x] checkedAnswer의 값이 false이면, inputUserNumberService함수를 실행

## (String)inputAvailableUserAnswerService()
- [x] 사용자가 응답을 저장할 userAnswer에 ""으로 초기화
- [x] printToRestartingGameMessage함수를 실행
- [x] inputUserAnswer함수를 실행 후, 결과값을 userAnswer에 저장
- [x] availableUserAnswerIsChecked함수를 실행
- [x] userAnswer을 리턴

## (void)baseballGameServie()
- [x] 사용자가 종료를 원하는지를 체크하는 번수, checkedBaseballGaemOfUserAnswer에 ""로 초기화
- [x] randomNumberCreate함수를 실행 후, 출력값을 computerNumbersList에 저장
- [x] inputUserNumberService함수를 실행
- [x] inputUserAnswerService함수를 실행 후, 결과값을 checkedBaseballGaemOfUserAnswer에 저장
- [x] checkedBaseballGaemOfUserAnswer이 1이면, baseballGameServie함수 실행
- [x] return를 리턴