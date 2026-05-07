package week5.package2;

import week5.role.Lion;
import week5.role.Role;
import week5.role.Staff;

import java.util.ArrayList;
import java.util.List;

public class MockMemberRepository implements MemberRepository {
    private final List<Role> dummyMembers = new ArrayList<>();

    public MockMemberRepository() {
        dummyMembers.add(new Lion("김사자", "컴퓨터공학과", 14, "백엔드", "2022020202"));
        dummyMembers.add(new Staff("홍사자", "경영학과", 13, "기획", "팀장"));
    }

    @Override
    public void save(Role member) {
        // Mock 저장소는 실제 저장 동작을 하지 않는다.
    }

    @Override
    public Role findByName(String name) {
        for (Role member : dummyMembers) {
            if (member.getName().equals(name)) {
                return member;
            }
        }
        return null;
    }

    @Override
    public List<Role> findAll() {
        return new ArrayList<>(dummyMembers);
    }

    @Override
    public boolean existsByName(String name) {
        return findByName(name) != null;
    }
}

