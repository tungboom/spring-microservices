package com.viettel.gnoc.repository.od;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.viettel.gnoc.dto.ResultDto;
import com.viettel.gnoc.dto.od.FilesDto;
import com.viettel.gnoc.model.od.FilesEntity;
import com.viettel.gnoc.repository.BaseRepository;

/**
 * @author TungBoom
 *
 */
@SuppressWarnings("rawtypes")
@Repository
@Transactional
public class CommonRepositoryImpl extends BaseRepository implements CommonRepository {
	private static final Logger LOGGER = LoggerFactory.getLogger(CommonRepositoryImpl.class);
	
    @Override
    public ResultDto getDBSysDate() {
        ResultDto data = new ResultDto();
        try {
            String strQuery = "SELECT sysdate() systemDate FROM DUAL";

            List<ResultDto> list = getNamedParameterJdbcTemplate().query(strQuery, BeanPropertyRowMapper.newInstance(ResultDto.class));

            if (list != null && list.size() > 0){
                data = list.get(0);
            }
        } catch (Exception e){
        	LOGGER.error(e.getMessage(), e);
        }
        return data;
    }

    @Override
    public FilesDto getFileByFileId(Long fileId) {
        FilesDto data = new FilesDto();
        try {
            FilesEntity filesEntity = getEntityManager().find(FilesEntity.class, fileId);
            if(filesEntity != null) {
                data = filesEntity.toDto();
            }
        } catch (Exception e){
        	LOGGER.error(e.getMessage(), e);
        }
        return data;
    }
}
