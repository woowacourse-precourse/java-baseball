baseball 기능구현사항 정리

핵심 구현 idea : 각자리숫자를 1-9사이에서 선택 , 숫자를 char배열로 변환 , 들어오는 String입력값을 int로 변환해서 메인 처리 메서드로 반환, 예외처리(3자리보다 길거나 숫자가 아닌 문자가 섞여있을시) , 각 자릿수 비교

필수 구현 기능 목록 : Controller(게임의 각각의 기능들로 임무를 위임해주는 클래스), Service(실제 야구 게임을 시행하는 클래스)

GetInput(입력값을 int로 반환해주는 클래스), ChangeToChar (int값을 char배열로 반환해주는 클래스)

구현 메소드 명세

Controller 

- playGame : service로 기능을 위임해주는 메서드

- playNextGame :  다음 게임으로 진행할지 안할지 결정하는 메서드 다음 게임 진행시 playGame메서드 호출

Service 

- playGame : 실제 게임을 진행하는 메서드 사용자의 입력을 받아 야구게임을 진행한다
- baseBall : 숫자 두개가 들어오면 각자리를 비교한다
- check : Strike , Ball 처리
- printBaseBallCount : 스트라이크 , 볼 숫자에 따라 다른 결과를 출력해준다
- randNumGenerate : 랜덤한 숫자를 생성해준다
- errorCheck : 입력된 숫자의 예외처리를 해준다

ChangeToChar : Int숫자값을 char배열로 바꿔 반환해준다

구조 변경

Service 클래스 분할 및 객체 지향적으로 변경

Service

- playGame : 실제 게임을 진행하는 메서드 사용자의 입력을 받아 야구게임을 진행한다
- baseBall : 숫자 두개가 들어오면 각자리를 비교한다

Game : 게임 전반적인 데이터를 담고 있는 객체 실제 플레이어 데이터 객체와, 랜덤하게 맞춰야할 숫자 배열을 가지고 있다.

- Game : Game객체 생성시 player객체 생성 및 randNumGenerate 메서드가 호출되며 랜덤한 플레이어가 맞춰야할 숫자가 생긴다

Player : 실제 플레이어의 데이터를 담고 있는 객체

- inputGenerate : 입력을 받아와서 처리
- check : Strike , Ball 처리
- printBaseBallCount : 스트라이크 , 볼 숫자에 따라 다른 결과를 출력해준다
- randNumGenerate : 랜덤한 숫자를 생성해준다
- errorCheck : 입력된 숫자의 예외처리를 해준다





