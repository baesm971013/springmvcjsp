package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEac(){
        memberRepository.clearStore();
    }

    @Test
    void test1(){
        Member member = new Member("su", 30);

        Member savedMember = memberRepository.save(member);

        Member findMember = memberRepository.findById(member.getId());

        Assertions.assertThat(savedMember).isEqualTo(findMember);

    }
    @Test
    void deleteTest(){
        Member member = new Member("jhon", 30);
        Member member2 = new Member("json", 30);
        Member savedMember = memberRepository.save(member);
        Member savedMember2 = memberRepository.save(member2);
        List<Member> memberList = memberRepository.findAll();
        for (Member mem : memberList){
            System.out.println(mem.getUsername());
        }
        //delete
        memberRepository.deleteMember(savedMember.getId());
        List<Member> memberList2 = memberRepository.findAll();

        for (Member mem : memberList2){
            System.out.println(mem.getUsername());
        }

    }

    @Test
    void findAll(){

    }

}