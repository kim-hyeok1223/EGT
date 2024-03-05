package com.egt.mypage.domain;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class Routine {

	private int id;
	private int userId;
	private int routineId;
	private String subject;
	private int exerciseId;
	private int weight;
	private int set;
	private Date createdAt;
	private Date updatedAt;
}
