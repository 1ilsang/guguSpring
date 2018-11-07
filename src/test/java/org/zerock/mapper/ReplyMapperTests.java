package org.zerock.mapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.config.RootConfig;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

import java.util.List;
import java.util.stream.IntStream;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j
public class ReplyMapperTests {

    private Long[] bnoArr = {15735575L, 15735574L, 15735573L, 15735572L,15735571L,15735570L,15735569L,15735568L,15735567L};

    @Setter(onMethod_ = @Autowired)
    private ReplyMapper mapper;

    public void testMapper() {
        log.info(mapper);
    }

    public void testCreate() {
        IntStream.rangeClosed(1, 10).forEach(i -> {

            ReplyVO vo = new ReplyVO();

//            vo.setBno(bnoArr[i % 5]);
            vo.setBno(15735575L);
            vo.setReply("댓글 테스트 " + i);
            vo.setReplyer("replyer " + i);

            mapper.insert(vo);
        });
    }

    public void testRead() {
        // DB 존재하는지 확인 필요
        Long targetRno = 5L;
        ReplyVO vo = mapper.read(targetRno);
        log.info(vo);
    }
    public void testDelete() {
        Long targetRno = 5L;
        mapper.delete(targetRno);
    }
    public void testUpdate() {
        Long targetRno = 6L;
        ReplyVO vo = mapper.read(targetRno);
        vo.setReply("수정된 댓글 ");
        int count = mapper.update(vo);
        log.info("UPDATE COUNT: " + count);
    }
    public void testList() {
        Criteria cri = new Criteria();
        List<ReplyVO> replies = mapper.getListWithPaging(cri, bnoArr[0]);
        replies.forEach(reply -> log.info(reply));
    }
    public void testList2() {
        Criteria cri = new Criteria(2, 10);
        List<ReplyVO> replies = mapper.getListWithPaging(cri, 15735575L);
        replies.forEach(reply -> log.info(reply));
    }
}
