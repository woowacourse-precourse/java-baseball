요구사항 단계
1. 기본 틀 만들기 - 입출력, 종료 여부, 랜덤 숫자 생성
   - 전체 흐름
     1. while 문을 통해 게임을 계속 진행. 조건 문으로 조건이 1일 경우 진행. 2가 되면 종료
     2. 랜덤 수 생성.
        1. while 문을 통해 사용자가 맞출 때 까지 추리 숫자를 입력 받음.
           - 사용자가 입력을 잘못한 경우 IllegalArgumentException 을 발생 시킨 후 종료.
        2. 숫자 야구 규칙에 맞게 메시지 출력
     3. 종료 문구 출력 후, 다음 게임 진행 여부 확인
   - 사용자로 부터 총 두 가지 입력이 존재. 
     - 추리 숫자: guessNumber
     - 게임 종료 후 다음 라운드 진행 여부: doNextGame
   - Randoms 및 Console API를 사용하여 랜덤 수 생성(randomNumber) 및 guessNumber 입력 받기.
2. 숫자 야구 게임 규칙
   - 위치가 다르면 볼
   - 위치가 같으면 strike
   - 겹치는 것이 없다면 낫띵

구현 방식
- BaseBallController 와 BaseBallService 로 구성
- 사용자의 입출력, 예외처리, 게임 진행 여부를 BaseBallController 에서 처리
- 볼, 스트라이크 판단을 BaseBallService 에서 처리
- BaseBallController 과 BaseBallService 는 BaseBallGameInput 과 BaseBallGameOutput 을 통해 정보를 주고받음 
  - BaseBallGameInput: randomNumber 와 guessNumber 를 담고 있음
  - BaseBallGameOutput: ball의 수와 strike 수 정보를 가지고 있음.
- 출력 메시지는 Enum 클래스인 ScreenOutString.class 에 정리해서 사용