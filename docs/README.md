# 🚀 기능 목록
##  (void)baseballGameStart()
- [x] "숫자 야구 게임을 시작합니다."를 출력

## (List<Integer>)randomNumberCreate()
- [x] 세자리수의 난수 생성

## (void)userNumberMessagePrint()
- [x] "숫자를 입력하세요 : "를 출력

## (String word)userNumberInput()
- [x] readLine()함수를 통해 사용자에게 받은 입력값을 userNumber에 저장
- [x] userNumber을 리턴

## (boolean)availableUserNumberIsChecked(String word)
- [ ] 0~9까지의 서로 다른 숫자인지 확인하는 정규표현식을 regularExpression에 저장한다.
- [ ] 매개변수가 regularExpression으로 참인지 거짓인지 판별
- [ ] 거짓이면, "유효하지 않은 값입니다"를 출력
- [ ] 거짓이면, false를 리턴
- [ ] 참이면, true를 리턴

## (List)stringToListCreate(String word)
- [ ] stringToArray에 매개변수를 배열형태로 변환하여 선언
- [ ] arrayToList에 stringToArray을 List형태로 변화하여 선언
- [ ] arrayToList를 리턴

## (int)checkStrikeNumbers(List computerNumbers,List userNumbers)
- [ ] 같은 자리와 같은 수인 숫자들의 개수를 저장하는 checkedStrikeNumbers를 0으로 선언한다.
- [ ] 매개변수들의 길이 만큼 반복하여, Strike인지 확인
- [ ] 값이 같으면, checkedStrikeNumbers에 1을 더함
- [ ] checkedStrikeNumbers을 리턴

## (int)checkedBallNumbers(List computerNumbers,List userNumbers)
- [ ] 하나의 매개변수 안에 다른 매개변수의 요소가 포함되는 갯수를 checkedBallNumbers를 0으로 선언한다.
- [ ] 매개변수들의 길이 만큼 반복하여, Ball인지 확인.
- [ ] 값이 같으면, checkedBallNumbers에 1을 더함.
- [ ] checkedBallNumbers를 리턴

## (int)calculatedStrikeBallNumber(List computerNumbers,List userNumbers)
- [ ] skrike와 ball의 갯수를 저장할 map 타입의 checkedBaseballNumbers을 strike: 0, ball: 0으로 초기화
- [ ] strikeNumber이 0보다 큰고 3보다 작은지 확인
- [ ] true이면 checkBaseBallNumbers의 strike : strikeNumber, ball : ballNumber - strikeNumber로 초기화
- [ ] strikeNumber이 3인지 확인
- [ ] true이면 checkBaseBallNumbers의 strike : 3으로 초기화
- [ ] checkedBaseballNumbers을 리턴

## (boolean)printBaseballOfResult(int strikeSize, int ballSize)
- [ ] Map 매개변수의 요소들의 꺼내서 strikeNumber와 ballNumber에 저장
- [ ] strikeNumber이 3인지 비교
- [ ] true이면, "3스트라이크" 출력
- [ ] true을 리턴
- [ ] strikeNumber가 0이고, ballNumber가 0인지 비교
- [ ] true이면 "낫싱" 출력
- [ ] strikeNumber가 0이고, ballNumber가 0보다 큰지 비교
- [ ] true이면 "ballNumber + 볼" 출력
- [ ] ballNumber이 0이고, strikeNumber이 0보다 큰지 비교
- [ ] true이면, "strikeNumber + 스트라이크" 출력
- [ ] ballNumber이 0보다 크고, strikeNumber이 0보다 큰지 비교
- [ ] true이면 "ballNumber + 볼 strikeNumber + 스트라이크"을 출력
- [ ] false을 리턴

## (void)printToRestartingGameMessage()
- [ ] "3개의 숫자를 모두 맞히셨습니다! 게임 종료" 출력
- [ ] "게임을 새로 시작하려면 1, 종류하려면 2를 입력하세요." 출력

## (String)inputUserAnswer()
- [ ] userAnswer에 readLine함수를 이용하여 사용자의 응답을 입력
- [ ] userAnswer을 리턴

## (boolean)availableUserAnswerIsChecked(String word)
- [ ] userAnswer에 매개변수를 저장
- [ ] regularExpression에 한자리 숫자인 1 또는 2 인지 확인하는 정규표현식을 초기화.
- [ ] userAnswer이 regularExpression에 유효한지 비교값을 result에 저장
- [ ] result을 리턴

## (String)inputAvailableUserNumberService()
- [ ] 사용자가 입력하는 숫자를 저장하는 변수, userNumber을 0으로 초기화
- [ ] availableUserNumberIsChecking, 숫자가 유효한지에 대한 검사값을 넣는 변수를 false로 초기화.
- [ ] userNumberMessagePrint함수를 실행
- [ ] userNumberInput함수를 실행
- [ ] availableUserNumberIsChecked함수를 실행 후 출력값을 availableUserNumberIsChecking에 선언
- [ ] availableUserNumberIsChecking이 false이면 inputAvailableUserNumberService함수를 실행 후, 출력값을 userNumber에 저장
- [ ] userNumber를 리턴

## (void)inputUserNumberService()
- [ ] inputAvailableUserNumberService함수에서 출력값을 저장하는 stringBuildUserNumber을 ""으로 초기화
- [ ] 사용자가의 수가 컴퓨터의 수와 동일한지 비교후 결과값을 저장하는 checkedAnswer을 false로 초기화
- [ ] inputAvailableUserNumberService함수를 실행
- [ ] StringToList함수를 실행
- [ ] checkStrickNumbers함수를 실행
- [ ] checkedBallNumbers함수를 실행
- [ ] calculatedStrikeBallNumber함수를 실행
- [ ] printBaseballOfResult함수를 실행 후 결과값을 checkedAnswer에 저장
- [ ] checkedAnswer의 값이 false이면, inputUserNumberService함수를 실행

## (String)inputAvailableUserAnswerService()
- [ ] 사용자가 응답을 저장할 userAnswer에 ""으로 초기화
- [ ] 사용자가 응답을 옳바르게 했는지 체크하는 변수, checkedAvailableUserAnswer에 false로 초기화
- [ ] printToRestartingGameMessage함수를 실행
- [ ] inputUserAnswer함수를 실행
- [ ] availableUserAnswerIsChecked함수를 실행 후, 결과값을 checkedAvailableUserAnswer에 저장
- [ ] checkedAvailableUserAnswer이 false이면, inputAvailableUserAnswerService함수를 실행 후 출력값을 userAnswer에 저장
- [ ] userAnswer을 리턴

## (void)baseballGameServie()
- [ ] 사용자가 종료를 원하는지를 체크하는 번수, checkedBaseballGaemOfUserAnswer에 0로 초기화 
- [ ] randomNumberCreate함수를 실행
- [ ] inputUserNumberService함수를 실행
- [ ] inputUserAnswerService함수를 실행 후, 결과값을 checkedBaseballGaemOfUserAnswer에 저장
- [ ] checkedBaseballGaemOfUserAnswer이 1이면, baseballGameServie함수 실행
- [ ] checkedBaseballGaemOfUserAnswer이 2이면, return을 리턴