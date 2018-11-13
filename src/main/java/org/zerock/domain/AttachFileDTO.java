package org.zerock.domain;

import lombok.Data;

// page 517
@Data
public class AttachFileDTO {
    private String fileName;
    private String uploadPath;
    private String uuid;
    private boolean image;
}
