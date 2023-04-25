package mainconcept.core.order;

import mainconcept.core.discount.DiscountPolicy;
import mainconcept.core.discount.FixDiscountPolicy;
import mainconcept.core.discount.RateDiscountPolicy;
import mainconcept.core.member.Member;
import mainconcept.core.member.MemberRepository;
import mainconcept.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    /*
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
     private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
     */

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
