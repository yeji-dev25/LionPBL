package week5.package1;

import week5.role.Role;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MemberService memberService = new MemberService();

        while (true) {
            printMenu();
            int menu = scanner.nextInt();

            switch (menu) {
                case 1:
                    registerMember(scanner, memberService);
                    break;
                case 2:
                    printAllMembers(memberService);
                    break;
                case 3:
                    searchByName(scanner, memberService);
                    break;
                case 4:
                    System.out.println("종료합니다.");
                    return;
                default:
                    System.out.println("올바른 메뉴 번호를 입력해주세요.");
            }
            System.out.println();
        }
    }

    private static void printMenu() {
        System.out.println("==== 멤버 관리 시스템 ====");
        System.out.println("1. 멤버 등록");
        System.out.println("2. 전체 멤버 조회");
        System.out.println("3. 이름으로 검색");
        System.out.println("4. 종료");
        System.out.print("선택: ");
    }

    private static void registerMember(Scanner scanner, MemberService memberService) {
        System.out.println("-- 멤버 등록 --");
        System.out.print("역할 선택 (1: 아기사자, 2: 운영진): ");
        int role = scanner.nextInt();

        System.out.print("이름: ");
        String name = scanner.next();
        System.out.print("전공: ");
        String major = scanner.next();
        System.out.print("기수: ");
        int generation = scanner.nextInt();
        System.out.print("파트: ");
        String part = scanner.next();

        boolean success;
        if (role == 1) {
            System.out.print("학번: ");
            String studentId = scanner.next();
            success = memberService.registerLion(name, major, generation, part, studentId);
        } else if (role == 2) {
            System.out.print("직책: ");
            String position = scanner.next();
            success = memberService.registerStaff(name, major, generation, part, position);
        } else {
            System.out.println("등록 실패: 역할 번호가 올바르지 않습니다.");
            return;
        }

        if (success) {
            System.out.println("등록 완료: " + name);
        } else {
            System.out.println("등록 실패: 이미 존재하는 이름입니다.");
        }
    }

    private static void printAllMembers(MemberService memberService) {
        List<Role> members = memberService.getAllMembers();
        System.out.println("-- 전체 멤버 목록 --");
        if (members.isEmpty()) {
            System.out.println("등록된 멤버가 없습니다.");
            return;
        }

        for (int i = 0; i < members.size(); i++) {
            Role member = members.get(i);
            System.out.println(
                    (i + 1) + ". [" + member.getRoleName() + "] "
                            + member.getName() + " - " + member.getGeneration() + "기"
            );
        }
        System.out.println("총 " + members.size() + "명");
    }

    private static void searchByName(Scanner scanner, MemberService memberService) {
        System.out.println("-- 이름으로 검색 --");
        System.out.print("검색할 이름: ");
        String targetName = scanner.next();

        Role member = memberService.findByName(targetName);
        if (member == null) {
            System.out.println("검색 결과가 없습니다.");
            return;
        }

        System.out.println("[검색 결과]");
        System.out.println("역할: " + member.getRoleName());
        System.out.println(
                "이름: " + member.getName()
                        + " | 전공: " + member.getMajor()
                        + " | 기수: " + member.getGeneration()
                        + " | 파트: " + member.getPart()
        );
        System.out.println(member.getDetailInfo());
        System.out.println("과제 제출 가능 여부: " + (member.canSubmit() ? "가능" : "불가능"));
    }
}

