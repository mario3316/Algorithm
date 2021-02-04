# :chicken: Algorithm

---

### Study Flow

- **_Implementation_**
- Greedy
- BFS/DFS
- DP
- Hash

---

### :wave: 문제 풀이

- Programmers

  - Lv.1

- BOJ

  - ~~2564 경비원~~
  - ~~17478 재귀함수가뭔가요~~
  - ~~1244 스위치 켜고 끄기~~
  - ~~2563 색종이~~
  - ~~2567 색종이2~~
  - ~~15649 N과M(1)~~
  - ~~15650 N과M(2)~~
  - ~~15651 N과M(3)~~
  - ~~15652 N과M(4)~~
  - ~~15654 N과M(5)~~
  - ~~15655 N과M(6)~~

- SW Expert
  - ~~1859 백만장자 프로젝트~~
  - ~~1984 중간 평균값 구하기~~
  - ~~1289 원재의 메모리 복구하기~~
  - ~~1208 Flatten~~
  - ~~1210 Ladder1~~
  - ~~1954 달팽이 숫자~~
  - ~~1873 상호의 배틀필드~~
  - ~~2805 농작물 수확하기~~
  - ~~11315 오목 판정~~
  - ~~11387 몬스터 사냥~~
  - ~~2001 파리 퇴치~~
  - ~~1218 괄호 짝짓기~~
  - ~~1225 암호생성기~~

---

### :book: 새롭게 익힌 사실

- 2021/01/28

  - Array to ArrayList
    ```
    List<Integer> list = Arrays.asList(arr);
    ```
  - ArrayList to Array
    ```
    ArrayList<Integer> list = new ArrayList<>();
    int[] arr = list.toArray();
    ```
  - List 거꾸로 뒤집기

    - Collections.reverse(list);
    - PriorityQueue

    - 정렬을 하는 기준인 Comparable Interface를 구현해야 함

      - CompareTo( ) : 우선순위 비교 메소드

        ```
        public Class Corona implements Comparable<Corona>{
          @Override
          public int compareTo(Corona c) {

            return this.spreadSpeed - c.spreadSpeed;

          }
        }
        ```

      - Comparable Interface를 상속받은 다음에 compareTo 메소드를 오버라이딩 해야 함
      - offer() : 요소 추가
      - poll(): 맨 앞 요소를 뽑아서 반환 ( Queue에서는 제거 됨)
      - peek(): 맨 앞 요소를 반환 ( Queue에는 남아있음 )

  - Comparable<T>

    - Priority queue에 사용하는 비교 인터페이스
    - 클래스 내부에 compareTo() 함수를 구현한다

  - Comparator<T>

    - compare( ) 함수 구현

      ```
      public int compare(int p1, int p2) {
        if (p1 > p2) {
          return 1; // 1은 뒤집음 (즉, 큰게 뒤로 (오름차순))
        } else if (p1 < p2) {
          return -1; // -1이면 그대로
        } else
          return 0;
      }
      ```

    - ArrayList 정렬하기 (feat. Anonymous Class)

      ```
      Collections.sort( list, new Comparator<Integer>( ) {

        public int compare(int p1, int p2) {

        return p1 - p2; // 반대로 하면 내림차순

        }

      }
      ```

- 2021/01/29

  - String 객체 vs String 리터럴

    - String 객체
      - String str = new String("hello");
      - 객체로 생성하면 Heap 영역에 생성됨
    - String 리터럴
      - String str = "hello";
      - 리터럴로 생성하면 String Constance Pool 영역에 생성됨
      - String str2 = "hello";
        str == str3 : true
      - 문자열이 같은 String 리터럴은 서로 같다 ( 둘다 같은 pool을 참조함)

  - Collections

    - Set / List
      - add 로 추가
        - add(a) : 맨뒤에 추가
        - add(0,b) : 0번째에 추가후 나머지를 뒤로 밀음
        - set(0,c) : 0번째에 덮어쓰기
        - remove(인덱스), remove(객체) : 요소 제거
        - get(인덱스): i번째 요소 확인
    - Map
      - put(key,value) : 추가
      - get(key) : key에 해당하는 value 확인
      - remove(key) : key value 삭제

- 2021/01/31

  - char -> int
    - Character.getNumericValue('1');

- 2021/02/02

  - 완전탐색

    - nPr (Permutation, 순열)
    - nCr (Combination, 조합)
    - 부분 집합

  - 순열 Permutation
    - 반복문을 통한 구현
    - 재귀를 통한 구현

  ```
    int[] arr = { 1, 2, 3 }; // 3P3

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (arr[j] != arr[i]) {
          for (int k = 0; k < 3; k++) {
            if (arr[k] != arr[i] && arr[k] != arr[j])
              System.out.println(arr[i] + "-" + arr[j] + "-" + arr[k]);
          }
        }
      }
    }
  ```

  ```
  static boolean[] isSelected = new boolean[5];
  static int[] numbers = new int[5];

  public static void perm(int cnt) {
    if (cnt == 5) {
      System.out.println(Arrays.toString(numbers));
      return;
    } else {
      for (int i = 0; i < 5; i++) {
        if (!isSelected[i]) { // 뽑히지 않았으면 뽑음
          numbers[cnt] = i; // 저장
          isSelected[i] = true; // 뽑았다고 표시
          perm(cnt + 1);
          isSelected[i] = false; // 끝나면 뽑았던 표시 제거
        }
      }
    }
  }
  ```

  - 조합 Combination

  ```

  static int[] input = { 1, 2, 3, 4, 5 };
  static int[] numbers = new int[2]; // 5C2 이므로 2개만 저장

  public static void comb(int cnt, int start) {
    if (cnt == numbers.length) {
      System.out.println(Arrays.toString(numbers));
      return;
    } else {
      for (int i = start; i < 5; i++) {
        numbers[cnt] = input[i];
        comb(cnt + 1, i + 1);
      }
    }
  }
  ```

  - 중복 순열

  ```
  public static void RepPerm(int cnt) {
      if (cnt == R) {
        System.out.println(Arrays.toString(output));
        return;
      } else {
        for (int i = 1; i <= N; i++) {
          output[cnt] = i;
          RepPerm(cnt + 1); // 중복을 허용하므로 visited[] 사용 x
        }
      }
    }
  ```

  - 중복 조합

  ```
  public static void RepComb(int cnt, int start) {
      if (cnt == R) {
        System.out.println(Arrays.toString(output));
        return;
      } else {
        for (int i = start; i <= N; i++) {
          output[cnt] = i;
          RepComb(cnt + 1, i); // i+1 시작이 아니라 자기 자신부터 시작
        }
      }
    }
  ```

  - 부분 집합 (Subset, Powerset)

  ```
  public static void SubSet(int cnt) {
      if (cnt == N) {
        for (int i = 0; i < N; i++) {
          if (isSelected[i])
            System.out.print(input[i] + " ");
        }
        System.out.println();
        tot++;
        return;
      } else {
        isSelected[cnt] = true;
        SubSet(cnt + 1);

        isSelected[cnt] = false;
        SubSet(cnt + 1);
      }
    }
  ```

  - Next Permutation

  ```
  public static boolean next_permutation(int size) {
      int i = size;
      while (i > 0 && p[i - 1] >= p[i])
        i--;

      if (i == 0) { // 이미 내림차순으로 모두 정렬이 되어있는 경우
        return false;
      } else {
        int j = size;
        while (p[i - 1] >= p[j]) // 피크 다음값보다 작은 바로 직전 값을 찾음
          j--;

        int temp = p[i - 1]; // 이 값을 피크 다음 값과 스왑
        p[i - 1] = p[j];
        p[j] = temp;

        int k = size;
        while (i < k) { // 피크 뒷부분을 정렬
          temp = p[i];
          p[i] = p[k];
          p[k] = temp;
          i++;
          k--;
        }
        return true;
      }
    }
  ```

- 2021/02/04

  - StringBuilder에 관해서

    - BOJ15651를 풀다가 시간초과가 나길래 재귀 종료시마다 출력하지 않고 Strinbbuilder로 append 해두었다가 모두 완료될때 한번만 출력했더니 훨씬 빨랐음
    - StringBuilder sb = new StringBuilder() 를 Static으로 선언해놓고 최종 단계에서만 출력하기.

  - Stack

    - 선언 : Stack<Object> S = new Stack<>();
    - push(Object o) : 요소를 Top에 추가
    - pop() : Top을 삭제
    - peek() : Top을 조회
    - isEmpty() : 스택이 비었는지를 true, false 로 return
    - search(Object o) : 요소가 스택의 몇번째에 있는지를 return

  - Queue
    - 선언 : Queue<Object> Q = new LinkedList<>();
    - offer(Object o) : 요소를 enqueue
    - poll(): 요소를 삭제하고 그 요소를 return
    - peek(): 첫번째 요소를 조회
    - isEmpty(): 큐가 비었는지를 true, false 로 return
