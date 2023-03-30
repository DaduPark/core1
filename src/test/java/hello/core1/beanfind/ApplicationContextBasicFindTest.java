package hello.core1.beanfind;

import hello.core1.AppConfig;
import hello.core1.member.MemberService;
import hello.core1.member.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.assertj.core.api.Assertions.assertThat;
public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);
    }

    @Test
    @DisplayName("빈 이름없이 타입으로만 조회")
    void findBeanByType() {
        MemberService memberService = ac.getBean( MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);
    }

    @Test
    @DisplayName("구체타입으로 조회")
    void findBeanByName2() {
        //MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberService.class);
    }
    
    @Test
    @DisplayName("빈 이름 조회 X")
    void findBeanNameX() {
       // MemberService xxxx = ac.getBean("xxxx", MemberService.class);
        Assertions.assertThrows(NoSuchBeanDefinitionException.class,
                ()-> ac.getBean("xxxx", MemberService.class));
    }    

}
