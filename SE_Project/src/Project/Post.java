package Project;  


public class Post {
	
	private User user;
	private Group group;
	private int id;
	private String postBody;
    private int score;
    java.util.Date dateTime;
    
    public Post (User user, Group group, int id, String postBody) {
    	this.user = user;
    	this.group = group;
    	this.id = id;
    	this.postBody = postBody;
    	this.dateTime = new java.util.Date(); //should save the current date and time.
    	this.score = 0;
    }
	
	public User getUser() {
		return user;
	}
	
	public Group getGroup() {
		return group;
	}
	
	public int getId() {
		return id;
	}
	
	public String getPostBody() {
		return postBody;
	}
	
	public int getScore() {
		return score;
	}
	
	//Returns date saved in dateTime
	public java.util.Date getTime() {
		return dateTime;
	}
	
	//Increases score
	public void addScore() {
		score++;
	}
	
	//Decreases score
	public void subScore() {
		score--;
	}
	
	
	
}