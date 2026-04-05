package week2.package2;

import week2.package1.Lion;

import java.util.Scanner;

public class step3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        String specialty = sc.nextLine();
        int corps = sc.nextInt();

        Lion lion = new Lion(name, specialty, corps);

        System.out.println("이름: " + lion.name);
        System.out.println("전공: " + lion.specialty);
        System.out.println("기수: " + lion.corps);
    }

}
