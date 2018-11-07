package org.zerock.domain;

import lombok.Data;

import java.util.Date;

@Data
public class ReplyVO {
    private Long rno;
    private Long bno;

    private String reply;
    private String replyer;
    private Date replyDate;
    private Date updateDate;
}
