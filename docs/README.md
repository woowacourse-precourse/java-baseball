### 기능 목록
- 세 자리에 들어갈 숫자 3개를 Randoms를 통해 추출한다.
    - 이 때, 3개의 숫자는 서로 달라야 한다.
    - 3개의 숫자는 String 형태로 변환되어 List 'gameNumberList'에 저장된다.

- 게임 승리 조건이 만족될 때 까지 다음 과정을 반복한다.
    1. 사용자는 세 자리 숫자를 입력한다.
    2. 처음 생성된 숫자와 같은 과정을 거쳐 List 'userNumberList'에 저장된다.
    3. gameNumberList와 userNumberList를 비교해 '스트라이크'에 해당하는 숫자가 있는지 확인한다. 이 때, 해당하는 숫자가 있으면 int자료형 변수 'strike'가 1 증가하고, 해당하는 숫자는 List 'strikeNumberList'에 저장된다.
    4. gameNumberList가 userNumberList의 값을 포함하고 있는지 확인한다. 이 때, strikeNumberList에 저장된 숫자는 비교에서 제외하며, 해당하는 숫자가 있으면 int자료형 변수 'ball'이 1 증가한다.
    5. strike의 값이 3이 되면, 게임 승리 조건을 만족하며 반복이 종료된다.
- 게임 종료 후 사용자는 1 또는 2의 값을 입력한다.
    - 1을 입력하면, 게임이 다시 시작된다.
    - 2를 입력하면, 프로그램이 종료된다.