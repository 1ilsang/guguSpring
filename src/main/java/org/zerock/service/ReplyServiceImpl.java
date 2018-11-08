package org.zerock.service;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyPageDTO;
import org.zerock.domain.ReplyVO;
import org.zerock.mapper.BoardMapper;
import org.zerock.mapper.ReplyMapper;

import java.util.List;

@Service
@Log4j
public class ReplyServiceImpl implements ReplyService{
    @Setter(onMethod_ = @Autowired)
    private ReplyMapper mapper;

    @Setter(onMethod_ = @Autowired)
    private BoardMapper boardMapper;

//    @Override
//    public int register(ReplyVO vo) {
//        log.info("register... " + vo);
//        return mapper.insert(vo);
//    }
    @Transactional
    @Override
    public int register(ReplyVO vo) {
        log.info("register... " + vo);
        boardMapper.updateReplyCnt(vo.getBno(), 1);
        return mapper.insert(vo);
    }

    @Override
    public ReplyVO get(Long rno) {
        log.info("get... " + rno);
        return mapper.read(rno);
    }

    @Override
    public int modify(ReplyVO vo) {
        log.info("modify... " + vo);
        return mapper.update(vo);
    }
//    기존의 처리
//    @Override
//    public int remove(Long rno) {
//        log.info("remove... " + rno);
//        return mapper.delete(rno);
//    }
//    댓글 count 트랜잭션 추가
    @Transactional
    @Override
    public int remove(Long rno){
        log.info("remove... " + rno);
        ReplyVO vo = mapper.read(rno);
        boardMapper.updateReplyCnt(vo.getBno(), -1);
        return mapper.delete(rno);
    }
    @Override
    public List<ReplyVO> getList(Criteria cri, Long bno) {
        log.info("get Reply List of a board " + bno);
        return mapper.getListWithPaging(cri, bno);
    }

    @Override
    public ReplyPageDTO getListPage(Criteria cri, Long bno) {
        log.info("getListPage... " + bno);
        return new ReplyPageDTO(
                mapper.getCountByBno(bno),
                mapper.getListWithPaging(cri, bno));
    }
}
