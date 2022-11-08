# Class 구성 및 기능 목록
## 1. domain
### 1-1. Computer
- 야구 게임 결과 List 생성(중복 없이)

### 1-2. Player
- Input number 범위 검증 기능
- Input number 크기 검증 기능
- Input number 중복 검증 기능

### 1-3. Score
- strike, ball 저장
- strike 개수 증가 기능
- ball 개수 증가 기능

## 2. utils
### 2-1. Parser
- 입력 받은 String type 변수를 List type으로 변경하는 기능
- 입력 받은 String type 변수를 Integer type으로 변경하는 기능
    - 숫자가 맞는지 검증하는 기능
    - 1또는 2가 맞는지 검증하는 기능
  
## 3. service
### 3-1. BaseballGameService
- Computer 객체 생성
- Player 객체 생성
- Restart 판단 기능
- Score 계산 기능
- Game play 기능
- Game 성공 판단 기능

## 4. controller
### 4-1. BaseballGameController
- 프로그램 실행
- 프로그램 반복 실행 여부 판단 기능