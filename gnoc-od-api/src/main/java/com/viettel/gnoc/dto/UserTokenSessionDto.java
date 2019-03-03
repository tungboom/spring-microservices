package com.viettel.gnoc.dto;

import com.viettel.gnoc.model.UserTokenSessionEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserTokenSessionDto extends UserTokenSessionEntity {
	private ObjectUsersDto objectUsersDto;
}
