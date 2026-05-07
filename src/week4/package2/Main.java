package week4.package2;

import week4.role.Base;
import week4.role.Lion;
import week4.role.Staff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Base> members = new ArrayList<>();
        Map<String, List<Base>> partMap = new HashMap<>();

        while (true) {
            printMenu();
            int menu = scanner.nextInt();

            switch (menu) {
                case 1:
                    registerMember(scanner, members, partMap);
                    break;
                case 2:
                    printAllMembers(members);
                    break;
                case 3:
                    searchByName(scanner, members);
                    break;
                case 4:
                    searchByPart(scanner, partMap);
                    break;
                case 5:
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
        System.out.println("4. 파트별 조회");
        System.out.println("5. 종료");
        System.out.print("선택: ");
    }

    private static void registerMember(Scanner scanner, List<Base> members, Map<String, List<Base>> partMap) {
        System.out.println("-- 멤버 등록 --");
        System.out.print("역할 선택 (1: 아기사자, 2: 운영진): ");
        int role = scanner.nextInt();

        System.out.print("이름: ");
        String name = scanner.next();

        if (isDuplicatedName(name, members)) {
            System.out.println("등록 실패: 이미 존재하는 이름입니다.");
            return;
        }

        System.out.print("전공: ");
        String major = scanner.next();
        System.out.print("기수: ");
        int generation = scanner.nextInt();
        System.out.print("파트 (백엔드/프론트엔드/기획/디자인): ");
        String part = scanner.next();

        Base newMember;

        if (role == 1) {
            System.out.print("학번: ");
            String studentId = scanner.next();
            newMember = new Lion(name, major, generation, part, studentId);
        } else if (role == 2) {
            System.out.print("직책: ");
            String position = scanner.next();
            newMember = new Staff(name, major, generation, part, position);
        } else {
            System.out.println("등록 실패: 역할 번호가 올바르지 않습니다.");
            return;
        }

        members.add(newMember);
        partMap.computeIfAbsent(part, key -> new ArrayList<>()).add(newMember);
        System.out.println("등록 완료: " + name);
    }

    private static boolean isDuplicatedName(String name, List<Base> members) {
        for (Base member : members) {
            if (member.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    private static void printAllMembers(List<Base> members) {
        System.out.println("-- 전체 멤버 목록 --");
        if (members.isEmpty()) {
            System.out.println("등록된 멤버가 없습니다.");
            return;
        }

        for (int i = 0; i < members.size(); i++) {
            Base member = members.get(i);
            String role = member instanceof Lion ? "아기사자" : "운영진";
            System.out.println((i + 1) + ". [" + role + "] " + member.getName() + " - " + member.getGeneration() + "기");
        }
        System.out.println("총 " + members.size() + "명");
    }

    private static void searchByName(Scanner scanner, List<Base> members) {
        System.out.println("-- 이름으로 검색 --");
        System.out.print("검색할 이름: ");
        String targetName = scanner.next();

        for (Base member : members) {
            if (member.getName().equals(targetName)) {
                String role = member instanceof Lion ? "아기사자" : "운영진";
                System.out.println("[검색 결과]");
                System.out.println("역할: " + role);
                System.out.println("이름: " + member.getName() + " | 전공: " + member.getMajor() + " | 기수: " + member.getGeneration() + " | 파트: " + member.getPart());
                if (member instanceof Lion) {
                    System.out.println("학번: " + ((Lion) member).getStudentID());
                } else {
                    System.out.println("직책: " + ((Staff) member).getPosition());
                }
                System.out.println("과제 제출 가능 여부: " + (member.canSubmit() ? "가능" : "불가능"));
                return;
            }
        }

        System.out.println("검색 결과가 없습니다.");
    }

    private static void searchByPart(Scanner scanner, Map<String, List<Base>> partMap) {
        System.out.println("-- 파트별 조회 --");
        if (partMap.isEmpty()) {
            System.out.println("등록된 파트가 없습니다.");
            return;
        }

        System.out.println("등록된 파트: " + partMap.keySet());
        System.out.print("조회할 파트: ");
        String targetPart = scanner.next();

        List<Base> partMembers = partMap.get(targetPart);
        if (partMembers == null || partMembers.isEmpty()) {
            System.out.println("해당 파트의 멤버가 없습니다.");
            return;
        }

        System.out.println("[" + targetPart + " 파트 멤버]");
        for (int i = 0; i < partMembers.size(); i++) {
            Base member = partMembers.get(i);
            String role = member instanceof Lion ? "아기사자" : "운영진";
            System.out.println((i + 1) + ". " + member.getName() + " (" + role + ") - " + member.getGeneration() + "기");
        }
    }
}
