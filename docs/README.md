# 1. 세 자리랜덤 숫자 구하기

## getRandomNumber()

### 기능
- 3자리 랜덤 숫자 생성 함수
### 요구사항
- 세 자리 수는 1~9까지의 서로 다른 수
- `camp.nextstep.edu.missionutils.Randoms`의 pickNumberInRange() 사용
- Return : String / Argument : void

## startGame(String randomNum)

### 기능
- 게임 시작

### 요구사항
- Return vold/ Argument : String


## printStartMsg()

### 기능
- 처음에 시작 메세지 출력

### 요구사항
'숫자 야구 게임을 시작합니다.'
- Return : void / Argument : void

## printInputMsg()

### 기능
- '숫자를 입력해주세요 : ' 출력하기
### 요구사항
- Return : void / Argument : void

## getInputNumber(String num)

### 기능
- 사용자 입력 값 받기

### 요구사항
- `camp.nextstep.edu.missionutils.Console`의 readLine() 사용하기
- Return : void / Argument : String


## printGameResult(int ballCount, int strikeCount)

### 기능
- 사용자 입력값에 대한 볼과 스트라이크 개수 출력

### 요구사항
- 입력한 수에 대한 결과를 볼, 스트라이크 개수로 표시 : 1볼 스트라이크
- 하나도 없는 경우 : 낫싱
- 3개의 숫자를 모두 맞힐 경우 : 3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료
- Return void / Argument : 볼, 스트라이크 수

## isThreeStrike(int strikeCount)

### 기능
- 스트라이크 개수가 3개이면 true 아니면 false

### 요구사항
- Return boolean / Argument : 스트라이크 수

## printEndMsg()

### 기능
- 사용자가 숫자를 맞혔을 때 종료 메시지 출력

###요구사항
- Return void/ Argument : void

### 요구사항
- '3개의 숫자를 모두 맞히셨습니다! 게임 종료'
- '게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.'

## getUserRestartEndNumber()

### 기능
- 재시작/종료를 구분하는 값 입력값 받기
- 1을 입력하면 재시작(true), 2를 입력하면 종료(false)

### 요구사항
- 프로그램 종료 시 System.exit()을 호출하지 않는다
- 사용자가 잘못된 값을 입력할 시 `IllegalArgumentException` 발생시킨 후 어플리케이션 종료
- Return boolean / Argument : Int


## isInvalidValue(String userInputNum)

### 기능
- 사용자가 올바른 값을 입력했는지 검사
- 1~999 까지의 서로 다른 세자리 숫자 입력 했는지 확인
- 숫자 이외의 다른 문자 입력 불가능

### 요구사항
- 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션 종료