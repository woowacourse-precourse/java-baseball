# 기능 목록

## Service
### 입력 예외 처리
- AnswerValidator (게임 진행 중)
  - 입력이 숫자인가
  - 서로 다른 숫자인가
  - 3자리수가 맞는가
- AgainValidator (게임 끝난 후)
  - 1 또는 2 값인가
### 게임 시작
- Implement
  - computerNumberDecide() : 컴퓨터 정답 결정
### 낫싱, 볼, 스트라이크 체크
- 같은 숫자가 있는가
- 같은 숫자가 같은 자리에 있는가
- 3자리 모두 같은 숫자일 경우 뺄셈을 하면 0

## Domain
- Again
  - doTry : 재시작여부
- Computer
  - computerAnswer : 정답
- User
  - userAnswer : 사용자 대답
- Game
  - ball
  - strike
  - addBall
  - addStrike

## View
### 동작하는 문자열 출력
- PlayingGame
  - 낫싱
  - 볼
  - 스트라이크
  - 숫자를 입력해주세요 :
- StartGame
  - 숫자 야구 게임을 시작합니다.
- EndGame
  - 3개의 숫자를 모두 맞히셨습니다! 게임 종료
  - 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.


