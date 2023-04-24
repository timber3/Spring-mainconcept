package mainconcept.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StateFulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StateFulService bean1 = ac.getBean(StateFulService.class);
        StateFulService bean2 = ac.getBean(StateFulService.class);

        // ThreadA : A사용자 10000원 주문
        int userA = bean1.order("userA", 10000);

        // ThreadA : B사용자 20000원 주문
        int userB = bean2.order("userB", 20000);

        // ThreadA : A사용자 주문 금액 조회
//        int price = bean1.getPrice();
        System.out.println("priceA = " + userA);
        System.out.println("priceB = " + userB);

//        Assertions.assertThat(bean1.getPrice()).isEqualTo(20000);
    }

    static class TestConfig {

        @Bean
        public StateFulService stateFulService() {
            return new StateFulService();
        }
    }

}