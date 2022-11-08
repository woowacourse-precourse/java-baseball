# 구상안

- 컴퓨터는 1~9 서로다른 임의의 수 3개를 선택해야한다. random 메소드를 사용하면 될거 같다.
- 3개의 숫자가 중복되지 않는점을 고려해야 한다.
- random을 사용하든가 set을 사용하면 될거같다.
- 예외처리도 구현을 해야한다.
- 게임이 종료될경우 재시작 또는 종료도 구현을 해야한다.

        List<Integer> number = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 3; i++){
            number.add(random.nextInt(10));
        }
        System.out.println(number);

컴퓨터의 입력값을 넣으려고 한다.

사람의 입력값을 넣으려고 하는데 scanner가 아닌 readLine()을 활용해서 입력값을 받아야한다.


# Scanner & BufferReader차이점
자바를 처음 배울 때 사용자(키보드) 입력받기 위해 보통 Scanner 클래스를 사용합니다. 

하지만 알고리즘을 풀기 시작하면서 백준에서 Scanner를 사용하여 입력을 받으면 시간초과가 발생하는 경험을 하게 됩니다. 

그래서 다른 방법을 찾다 보면 BufferedReader를 접하게 됩니다.

Scanner와 BufferedReader 클래스는 둘 다 사용자(키보드) 입력을 받을 수 있는 기능을 제공합니다. 

두 클래스가 가지고 있는 함수들에도 많은 차이가 있지만 가장 큰 차이는 속도입니다.

BufferedReader는 Exception이 처리를 따로 해줘야 하기 때문에 throws를 해주거나
try ~ catch로 예외처리를 해줘야합니다.

입력값을 정수로 하고 싶으면 String Line이므로 Integer.parseInt를 이용하여 형변환해야 한다.
"1 3 5 7" 식으로 공란 포함 String Line일시 StringTokenizer 이용 하면된다.

