package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class MemberRepository {
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    //singleton 처리
    private static final MemberRepository instance = new MemberRepository();

    private MemberRepository(){

    }

    public static MemberRepository getInstance(){
        return instance;
    }

    public Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id){
        return store.get(id);
    }

    public List<Member> findAll(){
        return new ArrayList<>(store.values());
    }

    public void deleteMember(Long id){
        store.remove(id);
    }

    public void clearStore(){
        store.clear();
    }

}
