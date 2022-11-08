기능 명세서

Application CLASS
    - main func : BaseballController  객체를 하나 만들고, gameStart Function 을 실행한다.
Controller Package
    - BaseballController
        gameStart Func : 게임이 시작되면 처음 실행하는 함수. 메인에서 호출하는 함수이다.
                이후 다른 함수들을 호출해주는 기능을 한다.
        gamePrepare Func : 게임 시작 전에 시작메세지와 
                컴퓨터 랜덤숫자를 만드는 createComputerNumber를 호출한다. 
        gamePlay Func : 유저 인풋 숫자 입력받고, compare 를 호출하여 비교하는 함수
                이후 gameRestart 함수를 호출하고 리턴 받은 값으로 다시 유저에게 입력받을 지 정한다
        gameRestart Func : 게임이 완료된 후 재시작, 종료 여부를 결정한다.
Model
    - BallCountItem : 스트라이크, 볼 이 몇개씩 있는지 저장하는 Item
    - NumberItem : 컴퓨터와 유저의 숫자를 리스트로 저장하는 Item
    - StatusItem : 자주 사용하는 숫자들을 변수로 저장해놓고 사용하려는 용도
Service : interface 와 impl 로 구현하였다.
    - NumberService
        createComputerNumber : 컴퓨터 숫자 생성
        createUserNumber : 유저 숫자 생성
        check_3_Digits_Number : 3자리 숫자인지 체크하는 함수
        check_Each_Digit_Range : 각 자리의 숫자가 1~9 사이인지 체크하는 함수
        check_Identical_Digit : 각 자리의 숫자가 서로 다른지 체크하는 함수
    - CompareService
        compare : 컴퓨터 숫자와 유저 숫자를 받아 스트라이크, 볼 카운트를 해주는 함수
View
    - PrintInformationView : 게임 진행에 필요한 메세지들을 저장해놓은 class