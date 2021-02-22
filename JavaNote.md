### :book: �ڹ� ��Ʈ

- 2021/01/19 JAVA

  - ArrayList<Integer> my_list = new ArrayList<Integer>();
    (Wrapper Ŭ������ ����)

    - my_list.add(8) : ����
    - my_list.remove(7) : ����
    - my_list.clear() : ��ü ����
    - my_list.size() : ũ�� ���ϱ�
    - �ݺ��� for(Integer : my_list) �� �ݺ�
    - Iterator iter = my_list.iterator();
      while(iter.hasNext()) �� �ݺ�

  - ���ڿ��� ���ڷ� ��ȯ

    - Integer.parseInt(myString)

  - � 迭 Sort
    - Arrays.sort(arr) : �������� ����
    - Arrays.sort(arr, Collections.reverseOrder()) : �������� ����

- 2021/01/20

  - System.currentTimeMills()

    - 1970.1.1���� ����� �ð��� �и��ʷ� ��ȯ

  - � 迭 API

    - Arrays.toString(arr) : � 迭 �� ��Ʈ�����·� �ٲ���
    - ���� ����
      - int[] new_arr = arr.clone();
      - System.arraycopy(src, srcPos, dst, dstPos, length);

  - 4��, 8�� Ž��

    - 4�� // �� ���� �ð� ����
      - int[] dr = {-1, 0, 1, 0}
      - int[] dc = { 0, 1, 0, -1}
    - 8�� // �� ���� �ð� ����
      - int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 }
      - int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 }

  - �ڹ� �ڵ��׽�Ʈ �Է¹��� ��

    1. Scanner

       - Scanner sc = new Scanner(System.in);
       - T = sc.nextInt();
       - for�� �ȿ��� String line = sc.next(); String[] bc = line.split(" ");

    2. BufferedReader

    - BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    - StringTokenizer st = null;
    - T = Integer.parseInt(br.readLine());
    - for�� �ȿ��� st = new StringTokenizer(br.readLine());
    - �� ��� 忡 ���� ���� �Է¹�����
      - num[i] = Integer.parseInt(st.nextToken());
      - ���� ���� �𸦶�
        - for(int i=0; st.hasMoreTokens(); i++)

- 2021/01/21

  - String�� ���ؼ�

    - String ���� ���Ҷ��� == �� �ƴ� equals �� ���Ұ� ( Reference Type )
      - String s1 = "hello";
      - String s2 = "hello";
      - String s3 = new String("hello");
      - s1 == s2 : true // s1�� s2�� ���� "hello" �ּҸ� ������
      - s2 == s3 : false // new�� ������ hello�� ������ ���� Allocation
      - s2.equals(s3) : true // String�� ���븸�� ���Ϸ��� equals ���
    - String + �ٸ�Ÿ���� ��� String�� ��
    - String�� char�� �ٲٴ� �޼ҵ� : charAt( )
    - String�� char [] �� �ٲٴ� �޼ҵ� toCharArray( )
    - String Concat
      - - �̿�
      - String Builder �̿�
        - StringBuilder sb = new StringBuilder("");
        - String[] strArray = {"hello", ", " , "world"};
        - sb.setLength(0);
        - for( String s: strArray)
          - sb.append(s);

  - Encapsulation

    - private ( private < default < public )
    - package
    - Interface
      - ���Ǹ� �س��� ������
      - Implements�� ������

  - Inheritance

    - �ڽ��� �����ɶ� �θ� ������(heap)
      - super()�� �̿��ؼ� �θ��� �����ڵ� ȣ���
    - �ڽ��� ��� 赵 �� �ö󰡷��� �θ� ���� �ö󰡾� ��
    - ������ �ּҴ� �θ��� �ּ� (heap)
    - ��� 赵 �� ������ �޼ҵ 常 ����� �� �ִ�

  - Object 4�� �޼ҵ� ( Object class�� �ڵ����� ��� )

    - hashCode( ) : �� ��ü�� ���� ��ü���� Ȯ�� ( hashCode�� �� )
    - toString( ): ��ü�� ������ ���ڿ��� ����� return
    - equals( ) : ������ ���Ƶ� hash code�� �޶� ��� reference type�� false�� � ⺻ �ε� String�� ����
    - getClass( ) : ��ü�� �����ϰ� �ִ� class�� return
    - �� 4�� Method�� Overriding�� �� ����

  - Getter�� Setter�� ����ؾ��ϴ� ����

    - ó�� ������ ����Ǵ� ��� �׿� ���� ������ �� �ִ�

  - Java ���ڿ� ����

    - String�� String[] strArr = str.split("") ���� �߶� � 迭 �� ����
    - Arrays.sort(strArr) �� ����
    - String.join("", strArr)�� ��ġ��

  - Java � 迭 �������� ����
    - Arrays.sort(array, Collections.reverseOrder());

- 2021/01/22

  - Polymorphism

    - ��Ÿ�ڻ� : �θ� Ÿ������ �ڽ��� ����
    - ��Ÿ���� : �θ� Ÿ������ �ڽ��� ����
    - �θ���ȣ: �θ� �޼ҵ�� �ڽ��� ȣ�� (Overriding)
    - A�� �θ��̰� B�� �ڽ��϶�
      - A a = new B();
        - �ڽ��� �θ��� Ÿ������ ������ �� ����
        - �̶� ���� �޼ҵ 尡 �ڽĿ��Ե� �ִٸ� �� �޼ҵ 带 ȣ���ҽ� �ڽ��� �޼ҵ 尡 ȣ�� ��

  - 2021/01/24

    - char Array to String

      - String str = new String(charArray);
      - StringBuilder sb = new StringBuilder();
        for(char ch: charArray)
        sb.append(ch);
        String str = sb.toString();

    - char �빮�� / �ҹ���
      - Character.toUpperCase('a');
      - Character.toLowerCase('A');
      - Ȥ�� �ƽ�Ű�ڵ� 97 - 65 ���̸� �̿��� ��ȯ

  - 2021/01/25

    - default vs protected

      - default
        - ���� ��Ű������ ���� ����
        - �ڽ� Ŭ�������� ���� �Ұ���
      - protected
        - ���� ��Ű������ ���� ����
        - �ڽ� Ŭ�������� ���� ���� ( ��� o )
      - ���� Ŭ�������� ���� �����Ϸ��� protected�� public���� �����ؾ� ��

    - this / super

      - �ڽ� Ŭ�������� this�� ��µ� �ش� ������ ������ �θ� Ŭ������ ������� ã�´�
      - ������ �θ� ����� �ùٸ��� �����ϴ� ���� super Ű����

    - ��� Class ���� � ⺻ ������ java.lang.Object�� ��ӹ޴´� (extends Object ����)
    - this() �� �̹� �ִ� �����ڸ� �ǹ�

    - Singletone

      - �����ڸ� private���� ����
      - �ڱ� ��ü�� private static���� ������ �� public static getInstance �޼ҵ�� �� ��ü�� ��ȯ

      ```
      private static BookManager manager = new BookManager();

      private BookManager() {
        super();
        books = new Book[MAX_SIZE];
      }

      public static BookManager getInstance() {
        return manager;
      }
      ```

    - Char ��/�ҹ��� Ȯ��

      - Character.isUpperCase(c);
      - Character.isLowerCase(c);
      - return type : boolean

    - Char�� null�� �ʱ�ȭ �Ϸ��� Char c = 0;
      - Char c = null / Char c = '' �Ұ���

  - 2021/01/26

    - ������ Polymorphism

      - Type�� Method�� ũ�� ����� ������ �� ����
      - Method�� Overloading �� Overriding���� ����

        - Overloading : name�� ���Ƶ� parameter�� �ٸ�
        - Overriding : �θ� Class �� �޼ҵ 带 �ڽ� Class���� ��������

      - �θ��� Type���� �ڽ� Type�� ��ü�� Reference �� �� �ִ�.
      - Phone p = new Samsung( );

        - p.toString(); // �θ� Ÿ������ �ڽ��� �����ϸ� �ڽĿ��� Overriding�� �޼ҵ 常 ȣ�� ����
        - p.showInfo( ); // �ڽĿ��� �ִ� ��� ������ �޼ҵ�� ���� �Ұ���

          �� ������ (Overriding) �� �ڽĿ� ���ؼ��� �θ� Ÿ������ ������ �����ϰ� �ڽ��� �����ǵ� �޼ҵ 带 ȣ���� �� �ִ�.

          Object x = new Corona();

          �� Object �� ȣ�� ����

          �� Corona�� ȣ�� ���

          �� ��, Object�� �����ִ� �Ϳ� ���ؼ��� Corona���� ȣ��

      - Overloading �� �޼ҵ�� ���� �ٸ� �޼ҵ 尡 ��

        - C�� a�� A�� a�� ���� �ٸ� �޼ҵ�
        - C�� b�� B�� b�� ���� �ٸ� �޼ҵ�

        �� Overloading �Ȱ��� �ƿ� �ٸ� �޼ҵ�� ����

      - Overriding ����

        - D�� b �� B�� b �� Overriding
        - E�� b �� D �� b�� Overriding

        �� Overriding�� ���� ������? � ⺻ ������ ��ӹ޾� ������ �ִ� �޼ҵ�

      - @Overriding Annotation

        - Ư�� Method�� ������ �ϰڴٰ� �����Ϸ����� �����ϴ� ��
        - ���� �θ� Ŭ������ �ش� Method�� ������ Compile ����

    - Interface

      - Method�� �߻�ȭ
      - � Class�� ������� ��Ҹ� �߰��ϰ� ������ ���
      - ����θ� ����ϰ� �����δ� ����
      - default method : �������� �ʾƵ� �ٷ� ����Ҽ� �ִ� �޼�
      - Method�� access modifier �� �����ϸ� � ⺻ ������ public�� �ȴ�
      - Interface���� ������ �����ϸ� public static final �� ����� �����ѰͰ� ����.

    - �߻� Class

      - abstract keyword
      - �߻� method�� �ϳ��� ������ �߻� Class
      - �߻� Ŭ�������� �ݵ�� �߻� Method�� �ִ°��� �ƴ� ( ���� ���� �ִµ� �� �� abstract class �� �뵵�� ��� ���� )
      - ��� Method�� abstract�̸� Interface�� ����

    - �߻� Method

      - Body�� ���� Method
      - public void say(){ } �� public abstract void say( )

    - Adapter

      - �������̽��� ���Ƽ� ���� ��� �����ϴ� �δ��� �������� �߻� Class�� �߰� �ܰ 踦 ����
      - Adapter������ Interface���� �����ϰ��� �ϴ� �޼ҵ 带 �����ϰ� ���� ���ϴ� �޼ҵ�� abstract�� ���ܵ�
      - ���� Interface�� Implement �ؾ��ϴ� Ŭ�������� �� Adapter�� ��ӹ޾� ���

    - instanceof

      - �����ɼ� �ִ� Type���� Ȯ���ϰ� ����� boolean���� return ��

    - Inner Class

      - Ŭ���� ���ο� ������ Ŭ����
      - ��� ������ �ϳ� ó�� Ŭ������ ������ �� �ִ�
      - Ŭ���� ���ο��� new�� �����ϰ� ���

    - Anonymous Class

      - �̸��� ���� ��������� inner Class
      - �̸��� �����Ƿ� ������� �ʰ� �ѹ��� ����

      af.setFolder(new Folder() {

      @Override
      public void fold() {
      System.out.println("Anonymous-fold");
      }

      @Override
      public void open() {
      System.out.println("Anonymous-open");
      }

      });

    - final class

      - �ڽ��� ���̻� �������� ����

    - static Block

      - ó�� Instance�� ���������(Heap�� �ö� ��) �� �ѹ��� ����Ǵ� �ڵ�

    - contains( )
      - Ư�� ���ڿ��� �����ϴ��� �Ǻ�
      - book.contains(title)
      - return type : boolean

  - 2021/01/27

    - Collection

      - �ڷḦ ���������� ������ Interface
      - Set, List, Map
        - Set : ���� (�ߺ� �Ұ���), ������ ���� �ߺ��� ���� �ڷᱸ��
          - HashSet, TreeSet
          - Tree Set�� �������� ���ĵ�
      - List: ������ �ִ� �ڷ� ����
        - Array List
        - Linked List ( Queue )

    - Final
      - Final Class : ��� �Ұ���
      - Final Method : Overriding �Ұ���

  - 2021/01/28

    - Generic < >

      - Type�� Dynamic�ϰ� ������ �� �ִ� ����� ����
      - ��� Ÿ�Ե��� ���� �ڵ 带 ����� ����(.java ���� ����) �� �� �޾Ƶ��ϼ� �ִ� �Ϲ�ȭ�� Ÿ��

      ```
      public class GenericContainer<T> {
      private T obj;

      public GenericContainer(){}

      public T getObj() { return obj; }

      public void setObj(T t) { obj = t; }

      }
      ```

    - Collections API

      - List (���� o �ߺ� o)
        - LinkedList
        - Stack
        - ArrayList
      - Set (���� x �ߺ�x)
        - HashSet
        - TreeSet
      - Queue (���� o �ߺ� o)
        - LinkedList
        - PriorityQueue
      - Map (Key-Value ��, ���� x, Key�ߺ�x, Value�ߺ� o)
        - HashTable
        - HashMap
        - TreeMap

    - iterator

      - Collection�� ��ȸ�ϱ� ���� interface
      - hasNext() : ������ ������ true, ������ false
      - next(): ���� ��Ҹ� return

        Iterator<Patient> itr = patientList.iterator();
        while(itr.hasNext()){
        Patient p = itr.next();
        System.out.println(p);
        }

    - PriorityQueue

      - ������ �ϴ� ������ Comparable Interface�� �����ؾ� ��

        - CompareTo( ) : �켱���� �� �޼ҵ�
        - public Class Corona implements Comparable<Corona>
        - @Override

          public int compareTo(Corona c) {

          return this.spreadSpeed - c.spreadSpeed;

          }

        - Comparable Interface�� ��ӹ��� ������ compareTo �޼ҵ 带 �������̵� �ؾ� ��
        - offer() : ��� �߰�
        - poll(): �� �� ��Ҹ� �̾Ƽ� ��ȯ ( Queue������ ���� ��)
        - peek(): �� �� ��Ҹ� ��ȯ ( Queue���� �������� )

    - Comparable<T>

      - Priority queue�� ����ϴ� �� �������̽�
      - Ŭ���� ���ο� compareTo() �Լ��� �����Ѵ�

    - Comparator<T>

      - compare( ) �Լ� ����

        ```
        public int compare(int p1, int p2) {
          if (p1 > p2) {
            return 1; // 1�� ������ (��, ū�� �ڷ� (��������))
          } else if (p1 < p2) {
            return -1; // -1�̸� �״��
          } else
            return 0;
        }
        ```

      - ArrayList �����ϱ� (feat. Anonymous Class)

        - Collections.sort( list, new Comparator<Integer>( ) {

          public int compare(int p1, int p2) {

          return p1 - p2; // �ݴ�� �ϸ� ��������

          }

          }

    - Error vs Exception

      - Error : System Level , StackOverflowError

        �ڵ 峪 ȯ������ ����

      - Exception : App level, IOException

    - Exception

      - RuntimeException : ����� �߻��ǹǷ� �����Ҽ� ����
        - ex ) NullPointer, ArrayIndexOutOfBounds
      - Other Exceptions : ���� �����ϹǷ� �ڵ� �ۼ��� ó��
        - ex) IOException, SQLException

    - Exception ó��

      - try-catch-finally
        - try : Exception�� �߻��Ҽ� �ִ� �ڵ�
        - catch(A e) : Exception �߻��� �����ϴ� �ڵ�
        - finally : Exception�� �߻��ϵ� ���ϵ� �ݵ�� ����Ǵ� �ڵ�
      - throws
        - ���� ȣ���� �޼ҵ 忡 �� ó���ϵ��� å���� ����
      - try-catch-throw
        - ���� ó���ϰ� ȣ���� �������� ó���ϰ�

    - Thread 구현

      - Runnable interface 구현

      ```java
      public class CoronaRunnable implements Runnable {
        int num;

        public CoronaRunnable(int num) {
          this.num = num;
        }

        @Override
        public void run() {

          System.out.println("#" + num + " is Started");
          for( int i=0; i<10000; i++ ) {
            int j = i*100;
          }
          System.out.println(num);
        }
      }
      ```

      ```java
      public class CoronaThreadTest {

        public static void main(String[] args) {
          for( int t=0; t<1000; t++ ) {

            CoronaRunnable cr = new CoronaRunnable(t);
            Thread thread = new Thread(cr); // Runnable을 구현한 클래스로 Thread 생성
            thread.start(); // Thread 시작

          }
        }
      }
      ```

      - Thread 상속

      ```java
      public class CoronaThread extends Thread {
        int num;

        public CoronaThread(int num) {
          this.num = num;
        }

        @Override
        public void run() {

          System.out.println("#" + num + " is Started");
          for( int i=0; i< 10000; i++ ) {
            int j = i*100;
          }
          System.out.println(num);
        }
      }
      ```

      ```java
      public class CoronaThreadTest {

        public static void main(String[] args) {
          for( int t=0; t<1000; t++ ) {

            CoronaThread thread = new CoronaThread(t);
            thread.start(); // Thread 생성 필요없이 바로 시작

          }
        }
      }
      ```

      - myThread.setPriority(10);
        - 우선순위를 임의로 지정할수 있다
        - 순서가 뒤죽박죽 나오지않고 정해진 우선순위대로 실행이 된다.
      - Thread.sleep(1000);
        - 쓰레드를 1초 ( 1000ms) 동안 중지했다가 다시 실행된다.
        - InterruptException 을 catch해야한다.
      - myThread.join()
        - myThread가 종료될때까지 대기한다.
        - InterruptException 을 catch해야한다.

    - interrupt()
      - 대기풀에 있던 Thread를 깨워서 다시 Runnable 상태로 만든다.
    - yield()

      - Running 중인 쓰레드가 스스로 Runnable 상태로 가서 다른 Thread들에게 자원을 양보한다.

    - Thread 동기화 (Synchronized)

      - 지금 Thread가 공유 자원을 사용할 때 다른 Thread가 이 공유자원에 접근하지 못하게 제한해야함.
      - 동기화 방법 2가지

        - Job을 수행하는 Method 자체를 synchronized 로 만든다
          - Method 수행 전체가 방해받지 않느 단위로 만들어지기 때문에 수행하는 동안 Lock을 얻고 끝나면 Lock을 반납한다.
        - 특정 Block을 synchonized로 만든다.

          ```java
          @Override
            public void run() {

              synchronized(cell) {
                if( cell.power < 500 ) {
                  try {
                    Thread.sleep(500);
                  }catch(InterruptedException e) {
                    e.printStackTrace();
                  }
                  cell.power = cell.power + 100;
                }

                System.out.println(cell.power);
              }
            }
          ```

        - DeadLock

          - 여러 Thread가 서로 공유 자원에대한 Lock을 반납할때 까지 기다려서 움직이지 않는 상태

        - wait() - notify() - notifyAll()
          - wait()
            - 수행중에 잠시 Job을 수행할 수 없으면 wait() 으로 **Lock을 반납후** 대기 풀로 돌아갈 수 있다.
          - notify(), notifyAll()
            - 다른 Thread가 공유 자원에 대한 작업을 완료하면 다른 Thread에게 이 자원이 준비되었음을 알림
            - 대기 풀에 있던 Thread는 notify()되면 다시 Runnable 상태로 감
            - notify() 는 한개의 Thread, notifyAll() 은 모든 Thread에게 알림
