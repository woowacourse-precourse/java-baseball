# 기능 목록

## 구현 기능

GameSystem class :
- runGame method :
    - printRunGameText Method : “숫자 야구 게임을 시작합니다.” 문구 출력.
    - startGame method : 한 번의 게임을 실행.
        - Computer class :
            - generateRandomThreeNumbers method : user가 맞춰야할 Integer형 난수 3개를 생성.
            - 난수를 생성할 때 마다 사용 가능한(전에 사용한) 숫자인지 확인해주는 method.(중복1)
            - 정상적으로 생성된 난수 3개를 arrayList<Integer.>에 저장.
        - User class :
            - 입력된 값을 저장해 주는 생성자.
            - 길이가 3인 것을 확인해주는 method.
            - 입력이 1~9의 숫자로 들어온 것을 확인해주는 method.
            - 똑같은 숫자가 있는지 확인해주는 method (중복1).
            - IllegalArgumentException : 조건에 안 맞는 잘못된 입력에 대한 예외처리.
            - 검증된 입력 값을 arrayList<Integer.>에 저장.
        - GamePlay class :
            - playGame method :
                - printInputText method : “숫자를 입력해주세요 : ” 문구 출력.
                - inputUserNumber method
                - NumberComparison class
                    - getBallCount method
                    - getStrikeCount method
                    - isAnswer method : 3 strike일 시 selectMenu, 아닐 시 printBallStrikeCount 실행 후 playGame method 실행.
                    - printBallStrikeCount : 낫싱, 볼 ,스트라이크 상황 출력
    - selectMenu method :
        -  MenuSelection class :
            - printAnswerText  : “3개의 숫자를 모두 맞히셨습니다! 게임 종료” 출력.
            - printMenuSelection : "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요." 출력.
                - inputMenu : 1(재시작),2(종료)중 하나를 입력
                    - 입력이 1,2중 하나로 들어 왔는지 확인하는 method.
                    - IllegalArgumentException
            - playGame method : 재시작, startGame() method 실행.
            - quit method : 게임 종료.