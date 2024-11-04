import java.util.Random;

public class Something {
    public static void main(String[] args) {
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 1000; i++) {
            sb.append(r.nextInt(1000));
        }

        System.out.println(sb);
        System.out.println(sb.length());
    }




}
