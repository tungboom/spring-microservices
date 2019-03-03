package com.viettel.gnoc.repository.od;

import org.springframework.stereotype.Repository;

import com.viettel.gnoc.dto.ResultDto;
import com.viettel.gnoc.dto.od.FilesDto;

/**
 * @author TungBoom
 *
 */
@Repository
public interface CommonRepository {

    ResultDto getDBSysDate();
    FilesDto getFileByFileId(Long fileId);
}
