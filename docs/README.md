기능목록정의
===
Summary
--
    interface를 사용하여 기능을 정의하고 구현체를 만들어 기능을 구현한다.

사용자
--
    1. 입력 값이 3자리인지 확인하는 함수
        - method : inputLengthCheck
        - param : String input
        - return : boolean

    2. 입력 값이 숫자인지 확인하는 함수
        - method : inputCheckInt
        - param : String input
        - return : boolean

    3. 입력 값을 int 배열로 변환하는 함수
        - method : inputToIntArr 
        - param : String input
        - return : int[]

    4. 입력 값 자릿 값 별로 1~9인지 확인하는 함수
        - method : intArrValidation 
        - param : int[] intArr
        - return : boolean

    5. int 배열을 List<Integer>로 반환해주는 함수
        - method : intArrToCollectionList
        - param : int[] intArr
        - return : List<Integer> 

    6. List<Integer> 안에 중복 값이 있는지 확인하는 함수
        - method : collectionListValidation
        - param : List<Integer> list
        - return : boolean

    7. 입력 값을 위 [사용자 1~6번] 항목을 거쳐 List<Integer>를 반환하는 함수
        - method : createUserNumList
        - param : String input
        - return : List<Integer>

컴퓨터
--
    1. 랜덤한 값을 뽑는 함수
        - method : getRandomNumber
        - return : int

    2. List<Integer> 안에 매개변수로 준 value 값이 있는지 확인하는 함수
        - method : collectionListCheckValue
        - param : int value, List<Integer> list
        - return : boolean

    3. List에 randomNumber를 넣는 함수
        - method :  컴퓨터 기능 함수 구현
        - param : List<Integer> list, int randomNum 
        
    4. [컴퓨터 1~2번] 항목을 통해 유효성 검사를 하여 랜덤한 3개의 중복되지 않는 값을 가진 List<Integer> 반환하는 함수
        - method : createRandomList
        - return : List<Integer>
게임
--
    1. 사용자가 입력한 값과 컴퓨터의 랜덤 값을 비교하여 동일한 값이 몇 개 있는 반환한다. 이것을 ballScore로 사용한다.
        - method : userNumListAndComNumListCheckBallCount
        - param : List<Integer> userNumList, List<Integer> computerNumList
        - return : int
        
    2. 사용자가 입력한 값과 컴퓨터의 랜덤 값을 비교하여 동일한 값이 같은 위치에 몇 개 있는 반환한다. 이것을 strikeScore로 사용한다.
        - method : userNumListAndComNumListCheckStrikeCount
        - param : List<Integer> userNumList, List<Integer> computerNumList
        - return : int

    3. 게임을 계속 할건지 확인한다.
        - method : again
        - param : String input
        - return : boolean

    4. 매개변수로 strikeScore, ballScore 를 주면 콘솔에 Score를 print해주는 함수
        - method : printScoreMsg
        - int strikeScore, int ballScore

    5. 게임 시작 시 안내 메시지를 console에 print 해주는 함수
        - method : printGameStartMsg
 
    6. 유저의 입력을 요청하는 print 함수 
        - method : printInputRequestMsg

에러
--
    1. 사용자가 입력한 값이 문제가 있을 경우 IllegalArgumentException 발생시키는 클래스 구현
        - class : UserInputException