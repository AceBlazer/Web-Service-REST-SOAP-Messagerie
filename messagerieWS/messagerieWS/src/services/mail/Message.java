package services.mail;

public class Message {

	private String from;
	private String to;
	private String message;
	private String priorite;
	private Boolean isNew;
    private String sendTime;
	
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPriorite() {
		return priorite;
	}
	public void setPriorite(String priorite) {
		this.priorite = priorite;
	}
	public Boolean getIsNew() {
		return isNew;
	}
	public void setIsNew(Boolean isNew) {
		this.isNew = isNew;
	}
	
	
	
	
	public String getSendTime() {
		return sendTime;
	}
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	public Message(String from, String to, String message, String priorite,
			Boolean isNew, String sendTime) {
		super();
		this.from = from;
		this.to = to;
		this.message = message;
		this.priorite = priorite;
		this.isNew = isNew;
		this.sendTime=sendTime;
	}
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
