package hello.core1.web;

import hello.core1.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {

    private MyLogger myLogger;
    public void logic(String id) {
        myLogger.log("service id = "+id);
    }
}
