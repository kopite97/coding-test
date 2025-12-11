package array;

/**
 * https://www.acmicpc.net/problem/2577
 */

import java.io.*;

public class number {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine().trim());
        int b = Integer.parseInt(br.readLine().trim());
        int c = Integer.parseInt(br.readLine().trim());

        long num = (long) a*b*c;
        int[] arr = new int[10];

        String str = String.valueOf(num);
        for(int i=0;i<str.length();i++){
            int n = Integer.parseInt(str.substring(i,i+1));
            arr[n] +=1;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<10;i++){
            sb.append(arr[i]).append("\n");
        }

        System.out.println(sb);

    }

    public static void main2(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine().trim());
        int b = Integer.parseInt(br.readLine().trim());
        int c = Integer.parseInt(br.readLine().trim());

        long num = (long) a*b*c;

        int[] arr = new int[10];

        while(num >0){
            int digit = (int) num%10;
            arr[digit]++;
            num /= 10;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<10;i++){
            sb.append(arr[i]).append("\n");
        }

        System.out.println(sb);

    }
}
