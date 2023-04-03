package hello.core1.singleton;

import hello.core1.AppConfig;
import hello.core1.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import  hello.core1.singleton.SingletoneService;
import static org.junit.jupiter.api.Assertions.*;

public class SingletonTest {

    @Test
    @DisplayName("스프링이 없는 순수한 DI 컨테이너")
    void pureContatiner() {
        AppConfig appConfig = new AppConfig();
        //1. 조회 : 호출할 때 마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();

        //2. 조회 : 호출할 때 마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();

        //참조값이 다른 것을 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        //memberservice1 != memberservice2
        assertThat(memberService1).isNotSameAs(memberService2);


    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletoneServiceTest() {
        SingletoneService instance1 = SingletoneService.getInstance();
        SingletoneService instance2 = SingletoneService.getInstance();

        System.out.println("instance1 = " + instance1);
        System.out.println("instance2 = " + instance2);

        assertThat(instance1).isSameAs(instance2);
    }
}
