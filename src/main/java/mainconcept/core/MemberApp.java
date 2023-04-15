package mainconcept.core;

import mainconcept.core.member.Grade;
import mainconcept.core.member.Member;
import mainconcept.core.member.MemberService;
import mainconcept.core.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();

        Member memberA = new Member(1L, "memberA", Grade.VIP);

        memberService.join(memberA);

        Member findMember = memberService.findMember(1L);
        System.out.println("findMember = " + findMember.getName());

    }
}
