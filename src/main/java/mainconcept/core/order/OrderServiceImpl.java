package mainconcept.core.order;

import mainconcept.core.discount.DiscountPolicy;
import mainconcept.core.discount.FixDiscountPolicy;
import mainconcept.core.member.Member;
import mainconcept.core.member.MemberRepository;
import mainconcept.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
