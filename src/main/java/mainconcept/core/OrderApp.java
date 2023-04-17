package mainconcept.core;

import mainconcept.core.discount.DiscountPolicy;
import mainconcept.core.member.*;
import mainconcept.core.order.Order;
import mainconcept.core.order.OrderService;
import mainconcept.core.order.OrderServiceImpl;

public class OrderApp {


    public static void main(String[] args) {

        AppConfig appconfig = new AppConfig();

        MemberService memberService = appconfig.memberService();
        OrderService orderService = appconfig.orderService();

//        MemberService memberService = new MemberServiceImpl();
//        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "MemberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("order-cal = " + order.calculatePrice());

    }
}
