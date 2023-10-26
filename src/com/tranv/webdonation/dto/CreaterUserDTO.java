package com.tranv.webdonation.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreaterUserDTO {
	@NotNull(message = "Vui lòng nhập tên")
	private String fullName;

	@NotNull(message = "Vui lòng nhập email")
	@Pattern(regexp = "^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$")
	private String Email;

	@NotNull(message = "Vui lòng nhập số điện thoại")
	private String phoneNumber;

	@NotNull(message = "Vui lòng nhập địa chỉ")
	private String address;

	@NotNull(message = "Vui lòng nhập tài khoản")
	private String userName;

	@NotNull(message = "Vui lòng nhập mật khẩu")
	private String password;

	private int roleId;
}
