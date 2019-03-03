package com.viettel.gnoc.service.od;

import com.viettel.gnoc.dto.ResultDto;
import com.viettel.gnoc.dto.od.FilesDto;

/**
 * @author TungBoom
 *
 */
public interface CommonService {
	ResultDto getDBSysDate();
	FilesDto getFileByFileId(Long fileId);
}
