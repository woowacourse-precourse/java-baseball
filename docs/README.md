# 🚀 로직 흐름

1. controller : view, domain 흐름을 관리하는 부분
    1. 게임 로직 총괄 컨트롤러 -> GameCenterController
        1. 어플리케이션 시작 메서드안에 반복문을 만들어 안에 게임 시작하는 메서드 호출한다
        2. "게임 시작 메서드"에서 정답 값을 만들고, 정답이 맞을때까지 반복하는 반복문에 들어간다
            1. 입력값에 따라 userball 을 생성하고 userball 상태 정보 출력
            2. userball 상태 정보가 정답인지 판단하고 아니면 계속 반복문을 돌고 아니면 "startGame 메서드를 나간다"
    2. 게임 시작을 담당하는 컨트롤러 -> GameStartController
        - 정답 숫자 생성하는 로직
        - inputView에서 게임 시작 출력 메서드 호출
    3. 게임 종료 관련 로직 담당 컨트롤러 -> GameEndController
        - userball 상태 정보 출력
        - userball 상태 정보가 정답인지 판단
            - 정답이면, outview 에서 정답 출력문 호출 하며 true 반환
            - 정답이 아니면 false 반환


2. domain : 핵심 도메인 model 부분
    - 스트라이크 개수, 볼 개수 필드
    - 볼개수 업데이트 하는 메서드
    - 스트라이크 개수 업데이트하는 메서드
    - 도메인 상태 정보 업데이트 메서드
    - 3스트라이크인지 판단하는 메서드
    - userballstatusdto 를 반환하는 메서드


3. service : 순수 도메인만 관리하는 부분
    - 우선 유저 입력값에 따른 UserBall 생성


4. view : 사용자에게 화면을 보여주는 부분에 초점
    1. 입력을 받는 역할 (inputView)
        - 게임 시작 문구 출력하는 메서드
        - 정답 값을 맞추고 게임을 종료할 것인지 사용자한테 출력문 출력 메서드
    2. 출력을 받는 역할 (outputView) :"service 한테 받은" domain 정보에 따라 출력문 출력
        - 정답을 맞추면 출력하는 메서드


5. util : 유용한 패키지 (외부의 의존성 없이 인자값만 받아 처리하는 부분, 에러 상수값)
    - 예외를 처리하는 상수 -> errorConst
    - inputView, outputView에서 사용하는 상수 -> viewConst
    - 입력값을 이 valid 한지 판단하는 로직 -> inputvalidUtil


6. config :
    - 새로운 객체 매번 생성해주기 보다 생성자 주입 활용
    - 애플리케이션 초기 객체 설정

# 🛠 구체적인 기능(메서드)

1. controller : view, domain 흐름을 관리하는 부분
    1. 게임 로직 총괄 컨트롤러 -> GameCenterController
        1. 어플리케이션 시작 메서드
            - 반복문 안에 게임 시작하는 메서드 호출
            - 종료 조건에 어플리케이션 종료 판단 메서드 호출
        2. 게임이 시작하는 메서드 (여기 정답이 틀리면, 계속 돌아야 하는 반복문임 만약 정)
            - 정답 숫자를 생성 -> service 한테 로직을 맡김
            - 반복문
                - 올바른 입력값을 판단하는 메서드 -> util 한테 로직을 맡김
                - 입력값에 따른 userball 생성 컨트롤러
                - userball 상태 정보 출력 메서드
            - 반복문 종료 조건 판단 컨트롤러
        3. 어플리케이션 종료 판단 메서드
            1. 사용자가 게임을 다시 할것이라고 하면 게임시작 true를 반환
            2. 사용자가 게임을 종료 한다고 하면, 게임 종료 false 반환
    2. 게임 시작을 담당하는 컨트롤러 -> GameStartController
        - 정답 숫자 생성하는 로직
        - inputView에서 게임 시작 출력 메서드 호출
    3. 게임 종료 관련 로직 담당 컨트롤러 -> GameEndController
        - userball의 상태 정보에 따른 출력 메서드
        - userball 상태 정보에 따른 종료 조건 판단 메서드


2. domain : 핵심 도메인 model 부분
    - 스트라이크 개수, 볼 개수 필드
    - 볼개수 업데이트 하는 메서드
    - 스트라이크 개수 업데이트하는 메서드
    - 도메인 상태 정보 필드
    - 도메인 상태 정보 업데이트 메서드
    - 3스트라이크인지 판단하는 메서드
    - userballstatusdto 를 반환하는 메서드


3. service : 순수 도메인만 관리하는 부분
    - UserBall 객체를 생성 및 입력값에 따른 ball, strike 업데이트 메서드


4. view : 사용자에게 화면을 보여주는 부분에 초점
    1. 입력을 받는 역할 (inputView)
        - 게임 시작 문구 출력하는 메서드
        - 정답 값을 맞추고 게임을 종료할 것인지 사용자한테 출력문 출력 메서드
    2. 출력을 받는 역할 (outputView) :"service 한테 받은" domain 정보에 따라 출력문 출력
        - 정답을 맞추면 출력하는 메서드


5. util : 유용한 패키지 (외부의 의존성 없이 인자값만 받아 처리하는 부분, 에러 상수값)
    - 예외를 처리하는 상수 -> errorConst
    - inputView, outputView에서 사용하는 상수 -> viewConst
    - 입력값을 이 valid 한지 판단하는 로직 -> inputvalidUtil


6. config :
    - 사용할 객체 생성 및 생성자 주입





