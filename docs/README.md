#  미션 - 숫자 야구

## 구현할 기능 목록
### 다음과 같은 순서로 기능을 구현합니다

1. 게임 시작 메시지 출력 
2. 중복없는 1~9 숫자 범위의 3자리 난수 생성 
3. 입력 메시지 출력 
4. 유저가 3자리 숫자를 입력 
5. ball과 strike 개수 확인 
6. Hint 출력 (볼,스트라이크,낫싱)
7. 사용자의 입력이 정답이 맞는지 확인 (정답이 아니라면 4번 기능으로 , 정답이라면 8번 기능으로)
8. 정답 메시지와 게임 재시작 메시지 출력
9. 게임 재시작 여부를 입력
10. 재시작 여부 확인 (재시작 한다면 2번 기능으로 , 아니라면 그대로 종료)

---
## 기존의 Class 
### Application
* 게임 시작


## 생성한 Class 
### PlayBaseBallGame
* 실질적인 게임 진행이 이루어 집니다
### InputNumber
* 모든 입력에 대한 기능을 포함
### PrintMessage
* 모든 출력에 대한 기능을 포함 
### BaseBallCount
* 입력한 수에 대한 결과를 볼, 스트라이크 
* 개수로 표시
### Exception
* 모든 예외처리 기능을 포함
---

## 실제 구현한 기능
### Application.class
- main
  - 게임을 시작합니다
### PlayBaseBallGame
- playGame
  - 게임의 실질적인 진행이 이루어 집니다
### InputNumber
- inputComputerBaseballNumber
  - 정답인 난수를 생성 
- inputUserBaseballNumber
  - 유저의 숫자 입력 
- inputReStartNumber
  - 재시작 여부를 입력
### PrintMessage
- printStartBaseballGame
  - 게임 시작 메시지 출력
- printInputBaseballNumber
  - 숫자 입력 메시지 출력 
- printHintBall
  - 사용자가 맞춘 볼 개수 힌트 출력
- printHintStrike
  - 사용자가 맞춘 스트라이크 개수 힌트 출력
- printHintNothing
  - 맞춘 숫자가 없는 경우 힌트 출력
- printHint
  - 사용자 입력에 대한 모든 힌트 출력 
  - printHintBall
  - printHintStrike
  - printHintNothing 
  - 위의 3가지를 순차적으로 실행
- printCorrectAnswer
  - 정답 메시지 출력
- printReGame
  - 게임 재시작 메시지 출력
### BaseBallCount
- countStrikeNumber
  - 사용자가 맞춘 스트라이크 개수 확인
- countBallNumber
  - 사용자가 맞춘 볼 개수 확인  
  - countBall
  - countBall 기능을 각 자리수 마다 실행 
- countBall
  - 사용자가 입력한 각 자리수의 볼 여부 확인  
### Exception
- checkLength
  - 사용자 입력의 길이 확인
- checkNumberRange
  - 사용자 입력의 숫자 범위 확인
- checkOverLap
  - 사용자 입력의 중복 확인
- checkInputException
  - 사용자 입력의 모든 예외 확인
  - checkLength
  - checkNumberRange
  - checkOverLap
  - 위 3가지 기능을 순차적으로 실행 
- checkReStartLength
  - 재시작 입력의 길이 확인  
- checkReStarNumberRange
  - 재시작 입력의 숫자 범위 확인
- checkReStarException
  - 재시작 입력의 모든 예외 확인
  - checkReStartLength
  - checkReStarNumberRange
  - 위의 2가지 기능을 순차적으로 실행
