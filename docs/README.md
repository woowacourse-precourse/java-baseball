
- 숫자야구는 크게  View, BaseballGame, BaseballService, ComputerBaseball 구조로 되어 있다.
### View 기능구현 목록
- view 는 사용자의 입력과 출력을 담당하는 객체이다. 
- `Console` 을 통해 사용자에게 3자리 정수를 입력받고 해당 정수를 문자열로 반환하는 메서드 구현
- 게임종료 메세지와 다음행동을 입력받은 값을 문자열로 반환하는 메서드 구현
  - 모든 입력에 대한 검증은 view 가 아닌 `baseballService` 가 담당한다.
- `baseballDto` 를 인자로 받고 볼, 스트라이크 개수로 출력하는 메서드 구현
- 
### BaseballGame 기능구현 목록
- baseballGame 는 게임진행, 입력값 검증, view 메시지전송, baseballService 메시지전송을 담당하는 객체이다.
- start() 메서드를 구현해서 애플리케이션이 시작됨 
  - 처음 애플리케이션 실행 시 `View` 에 정수 입력 메시지를 보내는 메서드 구현
  - 입력값 검증 후 볼, 스트라이크 갯수를 구하기 위해 `BaseballService` 에 메시지를 보냄
    - 검증목록은 정수확인,자릿수 확인, 중복된 정수 확인 
  - 반환 받은 `baseballDto` 를 `View` 의 에게 메시지를 보냄 
- 입력받은 문자열을 `List` 에 파싱해주는 메서드 구현
- 비교 후  볼,스트라이크 개수는 항상 Dto  통해 반환 되어야하며 스트라이크가 3개면 게임종료 메시지도 같이보낸다.
- 게임종료를 확인하는 메서드 구현
  - 게임종료는 스트라이크가 3개 이고 사용자의 입력값이 2일 때 종료 된다. 1이면 랜덤정수 초기화 후 재시작

### baseballService 기능구현 목록
- baseballService 는 볼, 스트라이크 계산 및 결과를 dto로 반환하는 역할을 담당하는 객체이다.
- baseballService `ComputerBaseball` 을 의존하고 생성시 같이 초기화된다.
- 입력받은 값과 `ComputerBaseball` 이 가지고 있는 컴퓨터 생성 정수와 비교하는 메서드 구현
- 비교에 대한 결과에 따라 `baseballDto` 을 통해 `BasebalLGame` 에 dto 를 반환하는 메서드 구현
- 게임 재시작시 `ComputerBaseball` 의 정수초기화 메시지를 보내는 메서드 구현
- 
### ComputerBaseball 기능구현 목록
- ComputerBaseball 은 컴퓨터의 baseball 숫자 생성, 초기화, 조회를 담당하는 객체이다
- 램덤으로 생성된 정수는 `List` 에 담겨서 관리된다

