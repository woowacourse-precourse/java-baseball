# 1. 기능 목록 단위

## (1). getRandomNumber()

1. **기능**

- 3자리 랜덤 숫자 생성 함수

2. **제한 사항**

- 1부터 9까지의 **서로 다른 수**로 이루어진 3자리
- `camp.nextstep.edu.missionutils.Randoms` 의 `pickNumberInRange` 활용

3. **Argument and Return**

Argument: void

Return: 1부터 9까지 정수 원소를 3개 갖는 List

<br/>

## (2). printStartMessage()

1. **기능**

- 게임을 처음으로 시작할 때 시작 메시지 출력
- `숫자 야구 게임을 시작합니다.`

2. **제한 사항**

- 없음

3. **Argument and Return**

Argument: void

Return: void

<br/>

## (3). printEndMessage()

1. **기능**

- 사용자가 숫자를 맞혔을 때 종료 메시지 출력
- `3개의 숫자를 모두 맞히셨습니다! 게임 종료`
- `게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.`

2. **제한 사항**

- 없음

3. **Argument and Return**

Argument: void

Return: void 

<br/>

## (4). printGameResult(int ballCount, int strikeCount)

1. **기능**

- 사용자가 입력한 숫자에 대한 볼과 스트라이크 개수를 출력
- `ballCount + "볼" + " " + strikeCount + "스트라이크"`
- `ballCount == 0 && strikeCount == 0` -> `낫싱`

2. **제한 사항**

- 볼 또는 스트라이크가 0개 이면 그 개수는 출력하지 않는다.

3. **Argument and Return**

Argument: 볼과 스트라이크의 개수

Return: void

<br/>

## (5). getUserInputNumber()

1. **기능**

- 사용자가 숫자를 입력하고 그 숫자를 반환

2. **제한 사항**

- 사용자가 잘못된 값을 입력할 시 `IllegalArgumentException` 발생시킨 후 어플리케이션 종료

3. **Argument and Return**

Argument: void

Return: String(사용자가 입력한 수)

<br/>

## (6). getStrikeCount(int userNum)

1. **기능**

- 사용자가 입력한 숫자를 통해 스트라이크 개수를 반환

2. **제한 사항**

- 없음

3. **Argument and Return**

Argument: 사용자가 입력한 수

Return: 스트라이크의 개수

<br/>

## (7). getBallCount(int userNum)

1. **기능**

- 사용자가 입력한 숫자를 통해 볼 개수를 반환

2. **제한 사항**

- 없음

3. **Argument and Return**

Argument: 사용자가 입력한 수

Return: 볼의 개수

<br/>

## (8). isThreeStrike(int strikeCount)

1. **기능**

- 스트라이크 개수가 3이면 true반환 아니면 false반환

2. **제한 사항**

- 없음

3. **Argument and Return**

Argument: Strike 개수

Return boolean

<br/>

## (9). printRestartMessage()

1. **기능**

- 스트라이크 개수가 3개일 때, 게임 재시작을 묻는 메시지 출력
- `게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.`

2. **제한 사항**

- 없음

3. **Argument and Return**

Argument: void

return void

</br>

## (10). getRestartFlag()

1.  **기능**

- 사용자가 1을 입력하면 true, 2를 입력하면 false 반환

2. **제한 사항**

- 사용자가 잘못된 값을 입력할 시 `IllegalArgumentException` 발생시킨 후 어플리케이션 종료

3. **Argument and Return**

Argument: void

Return Boolean