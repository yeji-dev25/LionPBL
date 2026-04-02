package week1;

import java.util.Scanner;

public class PrintBabyLion {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = 0;
    while(true) {
      System.out.print("아기사자 수를 입력해주세요: ");
      N = sc.nextInt();
      if(N > 5) break;
      System.out.println("아기사자 수가 5미만입니다." +
          " 다시 입력해주세요.");
    }

    System.out.println("아기사자 이름을 입력해주세요.");
    String[] array = new String[N];
    for(int i = 0; i < N; i++){
      array[i] = sc.next();
    }

    System.out.println("등록하신 아기사자 명단입니다.");
    for(int i = 0; i < N; i++){
      System.out.println((i+1) + ". " + array[i]);
    }

  }

}