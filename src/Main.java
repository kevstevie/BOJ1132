import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] numbers = new String[N];
        int[] countAlphabets = new int[10];
        boolean[] notZero = new boolean[10];
        List<Number> counting = new ArrayList<>();

        sc.nextLine();

        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextLine();
        }

        for (String str : numbers) {
            int len = str.length();
            for (int i = 0; i < len; i++) {
                if ( i == 0 ) {
                    notZero[str.charAt(i) - 'A'] = true;
                }
                countAlphabets[str.charAt(i) - 'A'] += times(len - i);
            }
        }


        for (int i = 0; i < countAlphabets.length; i++) {
            if( countAlphabets[i] == 0) continue;
            counting.add(new Number(countAlphabets[i], notZero[i]));
        }
        counting.sort(Comparator.naturalOrder());

        Deque<Integer> queue = new LinkedList<>();

        int minNum = 10 - counting.size();

        for (int i = minNum; i < 10; i++) {
            queue.addLast(i);
        }
        long result = 0;

        for (int i = 0; i < counting.size(); i++) {
            Number tmp = counting.get(i);
            if (queue.peek() == 0 && tmp.notZero){
                queue.removeFirst();
                result += tmp.num * queue.removeFirst();
                queue.addFirst(0);
                System.out.println(result);
            } else {
                result += tmp.num * queue.removeFirst();
                System.out.println(result);
            }
        }
        System.out.println(counting);

        System.out.println(result);





    }

    static long times(int num){
        long result = 1;
        for (int i = 0; i < num - 1; i++) {
            result *= 10;
        }
        return result;
    }
}

class Number implements Comparable<Number> {
    long num;
    boolean notZero;

    public Number(int num, boolean notZero) {
        this.num = num;
        this.notZero = notZero;
    }

    @Override
    public int compareTo(Number o) {
        return Long.compare(this.num, o.num);
    }

    @Override
    public String toString() {
        return "Number{" +
                "num=" + num +
                ", notZero=" + notZero +
                '}';
    }
}
