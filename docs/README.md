# 기능 구현 목록 - 최종
## GameManager class : 게임의 전체적인 진행 관리
### 정답 생성 : createAnswer
### 정답 맞춘 후 해당 게임 종료 확인 : isFinish
### 재시작여부 확인 : isAgain
## Input class : 게임중 유저의 인풋 입력
### 인풋 받기 : whileRunning
## Output class : 게임중 모든 출력 관리
### 매 결과 출력 : printResult
### 시작 문구 출력 : printStartingMent
### 종료 문구 출력 : printFinishingMent
## 스트라이크, 볼 판정 관리 : Referee
### 스트라이크, 볼 여부 저장하여 리턴 : judge
## ExceptionChecker : 게임 내 예외 상황 관리
### 게임중 인풋 예외 처리 : checkGuessingInput
### 3strike 후 재시작 여부 예외 처리 : checkAfterGameInput
## Database : 게임 내 모든 데이터 관리
### 정답 저장 : setAnswer
### 정답 추출 : getAnswer
### 유저 인풋 저장 : setUserInput
### 유저 인풋 추출 : getUserInput
### 스트라이크 저장 : setStrike
### 스트라이크 추출 : getStrike
### 볼 저장 : setBall
### 볼 추출 : getBall