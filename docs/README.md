## 📋 기능 목록
### 게임 기능 순서
1. 컴퓨터 수 세팅
2. 사용자 수 세팅
3. 컴퓨터와 사용자 수를 비교하여 스트라이크 횟수를 세고 해당 값을 사용자 수에서 제거
4. 컴퓨터와 위의 값이 제거된 사용자 수를 비교하여 볼 횟수 세기
5. 볼과 스트라이크의 값을 통해 힌트 출력
6. 3스트라이크 나올 때 까지 게임 2-5번 반복
7. 3스트라이크가 나오면 사용자 입력 값에 따라 게임 재시작, 종료 판단

### 숫자 야구 게임 기능
- 숫자 야구 게임 플레이
- 3스트라이크 나올 때 까지 게임 반복

### 게임 준비
**컴퓨터 수 세팅**
- 무작위 3자리 숫자로 컴퓨터 수 세팅
- 각 자릿수가 다른지 확인

**사용자 수 세팅**
- 입력한 값을 사용자 수로 세팅
- 입력한 값이 숫자인지 확인
- 입력한 값이 3자리 수 인지 확인
- 입력한 값을 List 자료형으로 변환

### 게임 실행
- 볼과 스트라이크 확인
- 각 자릿수의 수를 비교
- 스트라이크 횟수 세기
- 스트라이크 숫자 제거
- 각각의 수를 비교
- 볼 횟수 세기
- 결과 출력
- 게임 종료 여부 확인

## 🧪 테스트 목록
**컴퓨터 수 세팅 테스트**
- 난수를 통한 값 세팅 테스트
- 각 자릿수가 다른 경우 테스트

**사용자 수 세팅 테스트**
- 숫자가 아닌 경우 테스트
- 3자리 수가 아닌 경우 테스트
- 올바른 경우 테스트

**숫자 야구 게임 테스트**
- 볼과 스트라이크 세는 테스트
- 볼과 스트라이크 출력 테스트
- 볼과 스트라이크가 0인 경우 테스트
- 게임을 다시 시작할 경우 테스트
- 게임을 종료할 경우 테스트

## 💻 구현 메소드 목록
- `numberBaseballGame()` : 숫자 야구 플레이
- `repeatGameUntilThreeStrike()` : 3 스트라이크가 나올 때 까지 게임 반복
- `setComputerNumber()` : 무작위 3자리 숫자로 컴퓨터 수 세팅
- `isEachDigit()` : 각 자릿수가 다른지 확인
- `setUserNumber()` : 입력한 값을 사용자 수로 세팅
- `isNumber()` : 입력한 값이 숫자인지 확인
- `isThreeDigitNumber()` : 입력한 값이 3자리 수 인지 확인
- `userNumberToList()` : 입력한 값을 List 자료형으로 변환
- `checkStrikeAndBall()` : 볼과 스트라이크 확인
- `compareNumberForStrike()` : 각 자릿수의 수를 비교
- `countStrike()` : 스트라이크 횟수 세기
- `exceptStirkeNumber()` : 스트라이크 숫자 제거
- `compareNumberForBall()` : 각각의 수를 비교
- `countBall()` : 볼 횟수 세기
- `outputResult()` : 결과 출력
- `isGameExit()` : 게임 종료 여부 확인
- `setUserNumberForTest()` : 사용자 입력 값 체크 테스트
- `checkStrikeAndBallForTest()` : 볼과 스트라이크 세는 기능 테스트
- `outputResultForTest()` : 결과 출력 테스트
- `isGameExitForTest()` : 게임 종료 여부 확인 테스트

## 🗂️ class 파일 구조
**Application.class : 숫자 야구 게임**
```
main()
numberBaseballGame()
repeatGameUntilThreeStrike()
```
**PrepareGame.class : 게임 준비**
```
setComputerNumber()
isEachDigit()
setUserNumber()
setUserNumberForTest()
isNumber()
isThreeDigitNumber()
userNumberToString()
isGameExit()
isGameExitForTest()
```
**PlayGame.class : 게임 실행**
```
checkStrikeAndBall()
checkStrikeAndBallForTest()
compareNumberForStrike()
countStrike()
exceptStrikeNumber()
compareNumberForBall()
countBall()
outputResult()
outputResultForTest()
```
