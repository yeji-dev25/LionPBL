package week3;

import week3.role.Base;
import week3.role.Lion;
import week3.role.Staff;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("아기사자 정보 입력하세요.");
        System.out.print("이름: ");
        String name = sc.next();
        System.out.print("전공: ");
        String major = sc.next();
        System.out.print("기수: ");
        int generation = sc.nextInt();
        System.out.print("파트: ");
        String part = sc.next();
        System.out.print("학번: ");
        String studentID = sc.next();

        Base lion = new Lion(name, major, generation, part, studentID);

        System.out.println(lion.getInfo());
        System.out.println("과제 제출 여부: " + lion.canSubmit());

        System.out.println("운영자 정보 입력하세요.");
        System.out.print("이름: ");
        name = sc.next();
        System.out.print("전공: ");
        major = sc.next();
        System.out.print("기수: ");
        generation = sc.nextInt();
        System.out.print("파트: ");
        part = sc.next();
        System.out.print("직책: ");
        String position = sc.next();
        Base staff = new Staff(name, major, generation, part, position);

        System.out.println(staff.getInfo());
        System.out.println("과제 제출 여부: " + staff.canSubmit());

    }

}
