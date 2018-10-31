package org.zerock.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Data
public class TodoDTO {
    private String title;
//    FIXME 이상하게 이거 안됨.
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dueDate;
}
