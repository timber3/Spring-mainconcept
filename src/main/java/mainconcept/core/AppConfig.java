package mainconcept.core;

import mainconcept.core.discount.DiscountPolicy;
import mainconcept.core.discount.FixDiscountPolicy;
import mainconcept.core.discount.RateDiscountPolicy;
import mainconcept.core.member.MemberService;
import mainconcept.core.member.MemberServiceImpl;
import mainconcept.core.member.MemoryMemberRepository;
import mainconcept.core.order.OrderService;
import mainconcept.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public static MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public static DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(
                memberRepository(), discountPolicy()
        );
    }
}
