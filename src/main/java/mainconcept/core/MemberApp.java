package mainconcept.core;

import mainconcept.core.member.Grade;
import mainconcept.core.member.Member;
import mainconcept.core.member.MemberService;
import mainconcept.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        MemberService memberService = new MemberServiceImpl();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member memberA = new Member(1L, "memberA", Grade.VIP);

        memberService.join(memberA);

        Member findMember = memberService.findMember(1L);
        System.out.println("findMember = " + findMember.getName());
        System.out.println("new Member = " + memberA.getName());
    }
}
