Class Application : Main Method이며 게임을 시작
    
Class BallCount


    - int strike : 스트라이크 개수
    - int ball : 볼 개수
    - BallCount() : 생성자
    - initCount() : 볼 카운트를 0-0 으로 초기화
    - strikeUp() : 스트라이크 1 증가
    - ballUp() : 볼 1 증가
    - getStrike() : 스트라이크 개수 리턴
    - getBall() : 볼 개수 리턴

Class Game


    - List<Integer> answer : 랜덤 생성된 3자리 정답
    - BallCount ballcount : 스트라이크, 볼을 저장할 BallCount
    - Game() : 생성자
    - initGame() : 게임 초기화 역할, 정답을 정하고 볼카운트 초기화
    - setAnswer() : 1 ~ 9의 숫자로 이루어진 랜덤한 3자리 숫자를 정답으로 설정
    - setAnswer(List<Integer> answer) : Test를 위한 랜덤이 아닌 원하는 숫자로 정답을 설정
    - checkAnswer(List<Integer> answer) : 사용자가 입력한 예상값과 실제 정답을 비교
    - printCount() : 현재 볼카운트를 출력
    - isOver() : 게임이 종료되었는지 확인
    - checkInputFormat(String input) : 사용자의 입력 크기가 3을 넘지않는지 확인, 아니라면 exception
    - convertString(String input) : 사용자의 입력의 type을 String에서 List<Integer>로 변환
    - askRestart() : 게임이 종료된 사용자에게 다시 시작할 것인지 묻고 재시작 여부를 리턴
    - run() : 게임을 시작