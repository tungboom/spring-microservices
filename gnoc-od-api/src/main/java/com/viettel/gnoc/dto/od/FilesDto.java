package com.viettel.gnoc.dto.od;

import java.sql.Timestamp;

import com.viettel.gnoc.dto.BaseDto;
import com.viettel.gnoc.model.od.FilesEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author TungBoom
 *
 */
@Getter
@Setter
@NoArgsConstructor
public class FilesDto extends BaseDto {
	
	private Long fileId;
    private String fileName;
    private String filePath;
    private Long fileSize;
    private String createdUser;
    private Timestamp createdTime;
	
	public FilesEntity toEntity() {
		return new FilesEntity(fileId, fileName, filePath, fileSize, createdUser, createdTime);
	}

	public FilesDto(Long fileId, String fileName, String filePath, Long fileSize, String createdUser,
			Timestamp createdTime) {
		this.fileId = fileId;
		this.fileName = fileName;
		this.filePath = filePath;
		this.fileSize = fileSize;
		this.createdUser = createdUser;
		this.createdTime = createdTime;
	}
}
