package guru.springframework.bootstrap;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author zhaozh
 * @version 1.0
 * @date 2018-7-25 15:23
 **/
@Component
@Slf4j
public class CategoryBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        log.debug("context refresh event happenning!!");
    }
}
