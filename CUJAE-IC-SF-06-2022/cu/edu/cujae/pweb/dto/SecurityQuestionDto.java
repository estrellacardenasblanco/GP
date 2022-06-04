package cu.edu.cujae.pweb.dto;

public class SecurityQuestionDto {
	private int id;
	private String question;
	private String answer;

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	public SecurityQuestionDto(int id) {
		this.id = id;
	}


	public SecurityQuestionDto(int id, String question, String answer) {
		super();
		this.id = id;
		this.question = question;
		this.answer = answer;
	}
	
	public SecurityQuestionDto( String question, String answer) {
		this.question = question;
		this.answer = answer;
	}
	public SecurityQuestionDto() {
		
	}
	
	
}
