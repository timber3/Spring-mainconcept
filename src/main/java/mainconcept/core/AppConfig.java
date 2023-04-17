package mainconcept.core;

import mainconcept.core.discount.FixDiscountPolicy;
import mainconcept.core.discount.RateDiscountPolicy;
import mainconcept.core.member.MemberService;
import mainconcept.core.member.MemberServiceImpl;
import mainconcept.core.member.MemoryMemberRepository;
import mainconcept.core.order.OrderService;
import mainconcept.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private static MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(
                memberRepository(), new FixDiscountPolicy()
        );
    }
}
