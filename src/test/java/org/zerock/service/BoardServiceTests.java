package org.zerock.service;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.config.RootConfig;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j
public class BoardServiceTests {
    @Setter(onMethod_ = @Autowired)
    private BoardService service;

    public void testExist() {
        log.info(service);
        assertNotNull(service);
    }

    public void testRegister() {
        BoardVO board = new BoardVO();
        board.setTitle("New Title");
        board.setContent("New Content");
        board.setWriter("Newbie");
        service.register(board);
        log.info("생성된 게시물의 번호: " + board.getBno());
    }

    @Test
    public void testCRUD() {
        BoardVO board = new BoardVO();
        board.setTitle("TEST BOARD1");
        board.setContent("TEST CONTENT1");
        board.setWriter("TESTER");
        service.register(board);
        service.get(board.getBno());
//        service.getList();
        service.getList(new Criteria(1, 10))
            .forEach(criBoard -> log.info(criBoard));
        board.setTitle("TEST MODIFY BOARD1");
        service.modify(board);
        service.get(board.getBno());
        service.remove(board.getBno());
        service.get(board.getBno());
    }
}
