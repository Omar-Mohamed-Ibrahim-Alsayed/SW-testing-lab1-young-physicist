import java.util.*;

public class Main {



    public static void main(String[] args) {
    int n;
        Scanner S=new Scanner(System.in);
        n=S.nextInt();
        int[] f = new int[n*3];

        for (int i =0;i<f.length;i++)
            f[i] =S.nextInt();

        body b = new body();

        if(b.idle(f,n))
            System.out.println("YES");
        else
            System.out.println("NO");


    }

}
