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

## Domain
- Again
  - dotry : 재시작여부
- Computer
  - computerAnswer : 정답
- User
  - userAnswer : 사용자 대답

## View
### 동작하는 문자열 출력
- 낫싱
- 볼
- 스트라이크
- 숫자 야구 게임을 시작합니다.
- 숫자를 입력해주세요 : 
- 3개의 숫자를 모두 맞히셨습니다! 게임 종료
- 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.

### 낫싱, 볼, 스트라이크 체크
- 같은 숫자가 있는가
- 같은 숫자가 같은 자리에 있는가
- 3자리 모두 같은 숫자일 경우 뺄셈을 하면 0

### 게임 시작하는 함수

