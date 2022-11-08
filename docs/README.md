# 구현할 기능 목록

### 1. 랜덤 숫자 생성
    - List<Integer> makeRandomNumber() :
        camp.nextstep.edu.missionutils.Randoms 라이브러리의
            pickNumberInRange 함수로 1~9의 랜덤 숫자 3개 리턴
### 2. 숫자 입력
    - String getNumber() :
        camp.nextstep.edu.missionutils.Console 라이브러리의
            Readline 함수로 유저에게 세자리 숫자를 입력 받음,
        사용자가 잘못된 값을 입력할 경우 IllegalArgumentException 발
### 3. 숫자 비교
    - List<Integer> compareNumber(String input, List<Integer> computer) :
        사용자가 입력한 숫자와 makeRandomNumber()로 생성한 숫자를 비교하고
            볼과 스트라이크의 횟수를 List 안에 넣고 리턴
### 4. 비교한 결과 출력
    - void printResult(int ball, int strike) :
        볼과 스트라이크 횟수를 입력 받고 결과 출력
### 5. 유저가 숫자를 맞췄는지 못맞췄는지 확인
    - boolean quit(int strike) :
        strike 값을 입력받고 strike 값이 3이면 답을 맞춘 것으로
            true를 리턴하고 아니면 false를 리턴
### 6. 게임 시작 함수
    - void gameStart() :
        게임 시작 함수로 위의 기능 함수를 모두 담으며 메인 함수에서 실행되며
            quit 함수가 true를 반환하면 종료
### 7. 게임 재시작 또는 종료
    - 유저가 컴퓨터의 숫자를 맞추면 게임을 종료여부 묻는 기능 메인 함수에 구현
