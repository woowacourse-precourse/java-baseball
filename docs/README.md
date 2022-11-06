## 📋 기능 목록
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
- [ ] 사용자 입력 값을 List 자료형으로 변환
```
userNumberToList()
```

### 게임 플레이 기능
- [ ] 두 수의 숫자 비교
```
compareNumber()
```
- [ ] 스트라이크 확인
```
checkStrike()
```
- [ ] 볼 확인
```
checkBall()
```
- [ ] 결과 출력
```
outputResult()
```
- [ ] 게임 종료 여부 확인
```
isGameExit()
```

## 🗂️ class 파일 구조
- **Application.class : 메인**
```
main()
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
compareNumber()
checkStrike()
checkBall()
outputResult()
isGameExit()
```