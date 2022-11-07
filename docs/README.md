## 📋 기능 목록
### 숫자 야구 게임 플레이
- [ ] 숫자 야구 게임 플레이
```
numberBaseballGame()
```
- [ ] 3스트라이크가 나올때까지 게임 반복
```
repeatGameUntilThreeStrike()
```
### 컴퓨터 랜덤 값
- [x] 3자리 숫자를 랜덤으로 세팅
```
setComputerNumber()
```
- [x] 각 자리수가 다른지 확인
```
isEachDigit()
```

### 사용자 입력 값
- [x] 사용자가 입력한 값 세팅
```
setUserNumber()
```
- [x] 입력받은 값이 숫자인지 확인
```
isNumber()
```
- [x] 입력받은 값이 3자리 수 인지 확인
```
isThreeDigitNumber()
```
- [x] 사용자 입력 값을 List 자료형으로 변환
```
userNumberToList()
```

### 게임 플레이 기능
- [x] 스트라이크와 볼 개수 확인
```
checkStrikeAndBall()
```
- [x] 각 자리수의 숫자를 비교
```
compareNumberForStrike()
```
- [x] 스트라이크 횟수 세기
```
countStrike()
```
- [x] 스트라이크 숫자 제거
```
exceptStirkeNumber()
```
- [x] 숫자를 비교
```
compareNumberForBall()
```
- [x] 볼 횟수 세기
```
countBall()
```
- [ ] 결과 출력
```
outputResult()
```
- [ ] 게임 종료 여부 입력
```
setGameOver()
```
- [ ] 게임 종료 여부 확인
```
isGameExit()
```

### 테스트용 기능
- [ ] 사용자 입력 값 체크 테스트
```
setUserNumberForTest()
```
- [ ] 볼, 스트라이크 세는 기능 테스트
```
checkStrikeAndBallForTest()
```
- [ ] 힌트 출력 기능 테스트
```
outputResultForTest()
```

## 🗂️ class 파일 구조
- **Application.class : 메인**
```
main()
numberBaseballGame()
repeatGameUntilThreeStrike()
```
- **PrepareGame.class : 게임 준비 단계**
```
setComputerNumber()
isEachDigit()
setUserNumber()
isNumber()
isThreeDigitNumber()
userNumberToString
```
- **PlayGame.class : 게임 실행 단계**
```
checkStrikeAndBall()
compareNumberForStrike()
countStrike()
exceptStrikeNumber()
compareNumberForBall()
countBall()
outputResult()
setGameOver()
isGameExit()
```

## 🧪 테스트 목록
- [x] 컴퓨터 숫자 세팅 테스트
- [x] 사용자 입력 값 세팅 테스트
- [x] 볼, 스트라이크 세는 기능 테스트
- [ ] 낫싱 혹은 볼, 스트라이크 출력 테스트
