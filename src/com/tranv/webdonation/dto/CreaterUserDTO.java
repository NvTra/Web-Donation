package com.tranv.webdonation.dto;

import com.tranv.webdonation.entity.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class CreaterUserDTO extends User {
	private int roleId;
}
