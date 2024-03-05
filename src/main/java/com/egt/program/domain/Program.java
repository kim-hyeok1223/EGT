package com.egt.program.domain;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class Program {

	private int id;
	private int userId;
	private String subject;
	private String content;
	private String imagePath;
	private Date createdAt;
	private Date updatedAt;
}
