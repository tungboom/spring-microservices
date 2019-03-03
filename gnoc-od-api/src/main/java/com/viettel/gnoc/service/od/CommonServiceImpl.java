package com.viettel.gnoc.service.od;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viettel.gnoc.dto.ResultDto;
import com.viettel.gnoc.dto.od.FilesDto;
import com.viettel.gnoc.repository.od.CommonRepository;

/**
 * @author TungBoom
 *
 */
@Service
public class CommonServiceImpl implements CommonService {
    private final Logger LOG = LoggerFactory.getLogger(CommonServiceImpl.class);

    @Autowired
    protected CommonRepository commonRepository;

    @Override
    public ResultDto getDBSysDate() {
    	LOG.debug("Request to getDBSysDate : {}");
        return commonRepository.getDBSysDate();
    }
    
    @Override
    public FilesDto getFileByFileId(Long fileId) {
    	LOG.debug("Request to getFileByFileId : " + fileId);
        return commonRepository.getFileByFileId(fileId);
    }
}
