## 🚀 구현할 기능 목록

1. 게임 시작 문구 출력
2. camp.nextstep.edu.missionutils에서 제공하는 Randoms API를 사용하여 서로 다른 임의의 수 3개를 생성한다.
3. camp.nextstep.edu.missionutils에서 제공하는 Console API를 사용하여 서로 다른 임의의 수 3개를 입력받는다.
    1. 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션을 종료한다. 
    2. 사용자가 입력한 값이 숫자인지 검사하고, 숫자가 아닐경우 IllegalArgumentException을 발생시킨 후 애플리케이션을 종료한다.
    3. 사용자가 입력한 숫자가 서로 다른 3개의 숫자인지 검사하고, 서로 다르지않은 숫자가 있다면 IllegalArgumentException을 발생시킨 후 애플리케이션을 종료한다.
4. 두개의 임의의 수를 서로 비교하여 strike와 ball의 갯수를 계산한다.
    1. 스트라이크와 볼의 갯수를 저장할 ballAndStrike를 List<Integer>로 초기화한다.
    2. 사용자의 임의의 수 각 자리의 숫자가 상대의 수 3개중 포함되어 있는지 검사한다.
    3. 포함되어 있다면 각 숫자의 자리가 같은 자리인지 검사한다.
    4. 같은 자리라면 strike에, 다른 자리이면 ball에 +1한다.
5. 계산에 따른 결과를 화면에 표시한다.
   1. strike와 ball의 갯수가 둘 다 0이면 낫싱을 출력한다.
   2. strike의 갯수가 1 이상이고 ball의 갯수가 0이면 strike의 갯수만 출력한다. 
   3. ball의 갯수가 1 이상이고 strike의 갯수가 0이면 ball의 갯수만 출력한다.
   4. strike와 ball의 갯수가 둘 다 1 이상일때 strike와 ball의 갯수를 출력한다. 
   5. strike의 갯수가 3이라면 3개의 숫자를 모두 맞히셨습니다! 게임 종료 문구를 출력한다.
6. 게임이 종료될때까지 3-5번을 반복한다.
6. 게임이 종료된 경우 1과 2 중 하나의 수를 입력받아 게임을 재시작, 혹은 종료한다.
