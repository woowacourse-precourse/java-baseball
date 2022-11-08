# Mission base-ball

## 구현 메서드

- main()
  - while(true)로 무한 루프
  - 게임 새로 시작 1, 종료 2
    - 사용자 입력(Console.readLine() 필요)
  - 새로 시작 시 playBaseBall() 호출

- playBaseBall()
  - 야구 게임이 시작되는 메서드
  - getRandomNum() 호출하여 random 값 셋팅
  - startGame() 호출하여 본 게임으로 진입

- getRandomNum()
  - 컴퓨터에서 선택한 랜덤 숫자
  - Randoms.pickNumberInRange() 호출
    - 한 자리 수만 가져오므로 3번 호출
    - 중복되는 숫자가 나오지 않도록 조건문 추가

- startGame()
  - 게임이 시작되며, 계산 후 결과를 출력해주는 메서드
  - 3스트라이크가 되기 전까지 while(true)로 무한 루프 필요
  - Console.readLine() 호출하여 사용자의 입력값 가져옴
  - checkNum() 호출하여 입력값이 valid한 것인지 체크
  - getResult() 호출하여 랜덤값과 입력값을 비교하여 결과를 가져옴
  - 조건문을 추가하여 결과가 3스트라이크일 경우 break로 무한 루프 빠져나옴

- checkNum()
  - 입력한 숫자를 체크하는 메서드
  - 정규 표현식을 사용하여 1-9 숫자이며, 3자리에 해당하는 입력값이 들어오지 않은 경우 `IllegalArgumentException` 예외를 던짐
  - 입력한 숫자를 하나씩 가져와서 중복되는 숫자인지 체크하는 조건문 필요
    - 중복된 숫자일 경우 `IllegalArgumentException` 예외를 던짐

  - `IllegalArgumentException`은 합하지 않거나(illegal) 적절하지 못한(inappropriate) 인자를 메소드에 넘겨주었을 때 발생하는 RunTime 예외임

- getResult()
  - 찾아낸 결과를 사용자화로 변환 -> 사용자가 알아볼 수 있도록 변환
    - ex) 1, 1 = 1볼 1스트라이크
  - 볼과 스트라이크의 값을 넣을 int[] 선언
  - compareNum()을 호출하여 두 수 비교
  - int[] 배열의 0번째와 i번째 index의 값이 0일 경우 '낫싱' 결과를 반환
  - 0이 아닌 경우 0번째 index와 1번째 index의 값을 꺼내어 사용자화 하여 반환
    - 0번째가 ball, 1번째가 strike

- compareNum()
  - randomNum과 inputNum을 비교하여 결과를 찾아내는 메서드
  - randomNum을 기준으로 for문을 돌려 randomNum의 각 자리수가 inputNum에 포함되어 있는지 확인
  - 포함 되어 있다면 matchNum()을 호출하여 inputNum의 어느 자리에 randomNum이 매치되는지 확인
  - matchNum()에서 반환한 char이 'b'인지 's'인지 확인하여 int[]배열에 값을 더함

- matchNum()
  - ball인지 strike인지 구별하는 메서드
  - inputNum의 각 자리수와 randomNum의 수가 정확히 일치하면 boolean isStrike를 true로 변환
  - isStrike가 true인 경우 's'를 리턴, 아닌 경우 'b'를 리턴

- calResult()
  - 매치되는 ball과 strike를 계산하는 메서드
  - 매개변수가 'b'이면 int[]배열의 0번째 인덱스에 +1을, 's'이면 int[]배열의 1번째 인덱스에 +1을 하여 리턴

## 테스트 메서드

- 랜덤_값이_유효한지()
  - 컴퓨터에서 자동으로 생성되는 랜덤값이 유효한지 테스트하는 메서드
  - 컴퓨터에서 자동으로 생성되는 랜덤값이 반환되어, 이 값의 길이가 3이하인지 체크하는 메서드

- 입력_값이_유효하지_않을_경우()
  - 사용자가 입력하는 값이 유효하지 않을 경우 예외처리가 잘 실행되는지 테스트하는 메서드
  - 임의의 유효하지 않는 값을 집어넣어 IllegalArgumentException타입의 에러를 받아옴
  - 이 에러의 Message와 예상하는 에러 Message가 같은 경우 테스트 정상 작동

- 두_수_비교하는_메서드_확인()
  - 랜덤값과 입력값을 비교하여 정상적인 결과가 나오는지 테스트하는 메서드
  - 임의의 두 값을 집어넣어 예상하는 결과와 같은지 확인