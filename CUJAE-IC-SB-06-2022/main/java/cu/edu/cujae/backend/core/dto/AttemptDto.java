package cu.edu.cujae.backend.core.dto;

import java.util.ArrayList;

public class AttemptDto {
	private int pos;
	private ArrayList<PointDto> points;
	private String question;
	private String answer;
	
	public AttemptDto(int pos, ArrayList<PointDto> points) {
		this.pos = pos;
		this.points = points;
		this.question = null;
		this.answer = null;
	}	
	
	public AttemptDto(int pos, String question, String answer) {
		this.pos = pos;
		this.points = null;
		this.question = question;
		this.answer = answer;
	}
	
	public AttemptDto() {
		
	}
	
	public int getPos() {
		return pos;
	}
	public void setPos(int pos) {
		this.pos = pos;
	}
	public ArrayList<PointDto> getPoints() {
		return points;
	}
	public void setPoints(ArrayList<PointDto> points) {
		this.points = points;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getH() {		
		// TODO Auto-generated method stub
		return null;
	}
}
