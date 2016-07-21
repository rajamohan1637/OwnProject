package com.examportal.dto;

public class QtonDTO {

	private int num;
	private String qton;
	private String opt1;
	private String opt2;
	private String opt3;
	private String opt4;
	private int priority;
	private String answer;
	
	private QtonDTO qtonDto;
	

	public QtonDTO getQtonDto() {
		return qtonDto;
	}

	public void setQtonDto(QtonDTO qtonDto) {
		this.qtonDto = qtonDto;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getQton() {
		return qton;
	}

	public void setQton(String qton) {
		this.qton = qton;
	}

	public String getOpt1() {
		return opt1;
	}

	public void setOpt1(String opt1) {
		this.opt1 = opt1;
	}

	public String getOpt2() {
		return opt2;
	}

	public void setOpt2(String opt2) {
		this.opt2 = opt2;
	}

	public String getOpt3() {
		return opt3;
	}

	public void setOpt3(String opt3) {
		this.opt3 = opt3;
	}

	public String getOpt4() {
		return opt4;
	}

	public void setOpt4(String opt4) {
		this.opt4 = opt4;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
