package week2.package1;

import java.util.Scanner;

public class step1 {

    public String name;
    String specialty;
    private int corps;

    public step1(String name, String specialty, int corps) {

        this.name = name;
        this.specialty = specialty;
        this.corps = corps;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        String specialty = sc.nextLine();
        int corps = sc.nextInt();

        if(name.trim().isEmpty()) {
            throw new IllegalArgumentException("이름이 비었습니다.");
        }
        else if(specialty.trim().isEmpty()) {
            throw new IllegalArgumentException("전공이 비어있습니다.");
        }
        else if(corps < 1) {
            throw new IllegalArgumentException("기수가 1 미만입니다.");
        }

        step1 lion = new step1(name, specialty, corps);

    }
}
