package hello.core1;

import hello.core1.discount.DiscountPolicy;
import hello.core1.discount.FixDiscountPolicy;
import hello.core1.discount.RateDiscountPolicy;
import hello.core1.member.MemberService;
import hello.core1.member.MemberServiceImpl;
import hello.core1.member.MemoryMemberRepository;
import hello.core1.order.OrderService;
import hello.core1.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
       return new OrderServiceImpl(memberRepository(), discountPolicy());
        //return  null;
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }

}
