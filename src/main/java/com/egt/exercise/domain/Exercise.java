package com.egt.exercise.domain;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class Exercise {
	
	private int id;
	private String exerciseNm;
	private Date createdAt;
	private Date updatedAt;
	private String imagePath;

}
