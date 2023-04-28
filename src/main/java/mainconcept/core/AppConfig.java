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
    public MemoryMemberRepository memberRepository() {
        System.out.println("AppConfig.memberRepository called");
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

    @Bean
    public MemberService memberService() {
        System.out.println("AppConfig.memberService called");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        System.out.println("AppConfig.orderService called");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
}
