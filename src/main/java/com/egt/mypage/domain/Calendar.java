package com.egt.mypage.domain;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class Calendar {

	private int id;
	private int userId;
	private Date date;
	private int routineId;
	private String content;
	private Date createdAt;
	private Date updatedAt;
}
