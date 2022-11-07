# 기능 목록 2022.11.07
## Domain
### Game
- [X] 변수
  - 재시작/종료 코드
- [X] getter/setter

### Comparator
- [X] 변수
  - 비교 결과 성공시 true, 실패시 false
  - ball, strike
- [X] getter/setter

### ScoreBoard
- [X] 변수
  - 랜덤 숫자 리스트
  - ball, strike
  - ThreeStrike
- [X] getter/setter

### Player
- [X] 변수
  - 입력한 숫자 리스트
- [X] getter/setter

## Service
### Game  
- [ ] 게임 시작
- [ ] 재시작/종료 코드 입력

### ScoreBoard
- [X] 컴퓨터와 플레이어의 숫자 비교하여 결과 확인

### Computer 
- [X] 컴퓨터의 각각 다른 3개 숫자 설정

### Player
- [ ] 3개의 숫자 입력
- [X] 입력 받은 숫자를 리스트로 저장

## View
### 설명
- [ ] 게임 시작
- [ ] 숫자 입력 지시문
- [ ] 재시작/종료 입력 지시문

### 결과
- [ ] 볼
- [ ] 스트라이크
- [ ] 볼 스트라이크
- [ ] 낫싱
- [ ] 성공

## Exception
- [X] 입력한 문제에 중복 문자가 포함되는 경우 예외 처리
- [X] 입력한 문자에 숫자가 아닌 문자가 포함시 예외 처리
- [X] 게임 진행시 입력하는 문자의 크기가 3이 아닐시 예외 처리
- [X] 재시작/종료 코드 입력시 문자의 크기가 1이 아닐시 예외 처리
- [X] 재시작/종료 코드가 1이나 2가 아닐시 예외 처리

## Refactor
- [ ] PlayService 함수 한개당 하나의 역활을 하도록 수정