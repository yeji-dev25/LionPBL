package week1;

import java.util.Scanner;

public class PrintBabyLionBonus {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String msg;
    do {
      int N = 0;
      while (true) {
        try{
          System.out.print("아기사자 수를 입력해주세요: ");
          N = sc.nextInt();

        if (N >= 5) break;
        System.out.println("아기사자 수가 5미만입니다." +
            " 다시 입력해주세요.");
      }catch (Exception e) {
          sc.nextLine();
          System.out.println("잘못 입력하셨습니다. 수는 숫자만 가능합니다.");
        }
      }

      System.out.println("아기사자 이름을 입력해주세요.");
      String[] array = new String[N];
      int i = 0;
      sc.nextLine();
      while(i < N) {
        array[i] = sc.nextLine();
        if(array[i].trim().isEmpty()){
          System.out.println("빈문자열입니다. 다시 입력해주세요.");
          continue;
        }
        boolean bool = false;
        for(int j = 0; j < i; j++){
          if(array[j].equals(array[i])){
            bool = true;
            break;
          }
        }
        if(bool){
          System.out.println("중복된 이름입니다. 다시 입력해주세요.");
          continue;
        }
        i++;

      }

      System.out.println("등록하신 아기사자 명단입니다.");
      for (int a = 0; a < N; a++) {
        System.out.println((a + 1) + ". " + array[a]);
      }

      System.out.println("=================");
      System.out.println("프로그램을 다시 시작하려면 restart, 끝내려면 exit를 입력하세요.");
      msg = sc.next();
      while(!msg.equals("restart")&& !msg.equals("exit")) {
        System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
        msg = sc.next();
      }
    }while(msg.equals("restart"));
  }

}