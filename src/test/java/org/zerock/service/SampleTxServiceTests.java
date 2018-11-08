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
public class SampleTxServiceTests {
    @Setter(onMethod_ = @Autowired)
    private SampleTxService service;

    @Test
    public void testLong() {
        String str = "Strarray\r\n" +
                "Starry night\r\n" +
                "Paint your palette blue and grey\r\n" +
                "Look out on a summer's day";
        log.info(str.getBytes().length);
        service.addData(str);
    }
}
