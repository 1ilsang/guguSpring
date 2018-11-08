package org.zerock.service;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.config.RootConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j
public class SampleServiceTests {
    @Setter(onMethod_ = @Autowired)
    private SampleService service;

    public void testClass() {
        log.info(service);
        log.info(service.getClass().getName());
    }
    @Test
    public void testAdd() throws Exception {
        log.info(service.doAdd("123", "456"));
    }
    public void testAddErr() throws Exception {
        log.info(service.doAdd("123", "ABC"));
    }
}
