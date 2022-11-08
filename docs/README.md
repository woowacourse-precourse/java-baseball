# 🚀 예외 사항

## IllegalArgumentException

### 3자리의 수

- [x] 세 자릿 수가 아닌지 확인
- [x] 각 자리의 숫자 중에 중복이 있는지 확인
- [x] 입력에 0이 있는지 확인
- [x] 입력이 숫자인지 확인

### 새 게임 한 자릿 수

- [x] 1, 2가 아닌 수가 입력될 경우

# 🚀 기능 목록

## 🚀 구현 클래스 목록

- Input 클래스
  - [x] 입력받는 기능
  - [x] String을 List로 바꾸는 기능
- InputValidity 클래스
  - [x] Input 클래스에 들어오는 input의 유효성 검사
- Computer 클래스
  - [x] random 값을 생성하는 기능
  - [x] int 값을 character로 만드는 기능
- Referee 클래스
  - [x] 두 리스트 비교
- Output 클래스
  - [x] 받은 리스트로 출력하는 기능
- EndOrRe 클래스
  - [x] 입력받는 기능
- Game 클래스
  - [x] 모든 클래스의 객체 생성하여 게임 실행하는 기능
- OutputMessage Enum
  - [x] Game 클래스에서 사용되는 게임 안내 문자열 출력 기능