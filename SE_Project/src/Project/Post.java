package Project;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;


public class Post implements Comparable<Post> {

	protected User user;
	protected Group group;
	protected String postTitle;
	protected String postBody;
	private ArrayList<Response> responses;
	protected Date dateTime;
    private int score;
    private boolean flag;
    private int id;
    
    public Post (membership memberships, String postTitle, String postBody, int Id) {
    	this.user = memberships.getUser();
    	this.group = memberships.getGroup();
    	this.postBody = postBody;
    	this.postTitle = postTitle;
    	this.responses = new ArrayList<>();
    	this.dateTime = new Date();
    	this.score = 0;
    	this.flag = false;
    	this.id = Id;
    }
	
    
	public Post (User u, Group g, String dateTime, String postTitle, String postBody, int id) {
    	this.user = u;
    	this.group = g;
    	this.postTitle = postTitle;
    	this.postBody = postBody;
    	this.responses = new ArrayList<>();
    	try {
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm a");
			this.dateTime = df.parse(dateTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	this.score = 0;
    	this.flag = false;
    	this.id = id;
    }
    
	//test:1
	public User getUser() {
		return user;
	}
	
	//test:1
	public Group getGroup() {
		return group;
	}
	
	//test:1
	public String getPostTitle() {
		return postTitle;
	}

	//test:1
	public String getPostBody() {
		return postBody;
	}
	
	//test:1
	public int getId() {
		return id;
	}
	
	public ArrayList<Response> getResponse() {
		return responses;
	}
	
	//test:1
    //Adds responses into responses
    public boolean addResponse(Response r) {
        return(responses.add(r));
    }
    
    //test:1
    //removes responses into responses
    public void removeResponse(Response r) {
        responses.remove(r);
    }
	
	//test:1
	public int getScore() {
		return score;
	}
	
	//test:1
	public boolean getFlag() {
		return flag;
	}
	
	//test:1
	public void setFlagTrue() {
		flag = true;
	}
	
	//test:1
	public void setFlagFalse() {
		flag = false;
	}
	
	//test:1
	//Returns date saved in dateTime
	public Date getTime() {
		return dateTime;
	}
	
	//test:1
	//Increases score
	public void addScore() {
		score++;
	}
	
	//test:1
	//Decreases score
	public void subScore() {
		score--;
	}
	
	//test:1
	public String getPostWriteData() {
		
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm a");
		String date = df.format(dateTime);
    	
    	String userData = "@START\n" + 
    						"@POST\n" + 
    						"@USERNAME=" + getUser().getId() + "\n" + 
    						"@GNAME=" + getGroup().getGroupName() + "\n" + 
    						"@DATETIME=" + date + "\n" + 
    						"@TITLE=" + postTitle + "n" +
    						"@BODY=" + postBody + "\n" + 
    						"@PSTID=" + id + "\n" + 
    						"@END\n\n";
    	
    	return userData;
    }
	
    public int getTotalScore() {
        int totalScore = this.score;
        for (Response response : responses) {
            totalScore += response.getScore();
        }
        return totalScore;
    }

	//FIXME: add tests
	@Override
	public int compareTo(Post p) {
		
		if (user.compareTo(p.getUser()) == 1 && group.compareTo(p.getGroup()) == 1 &&
				id == p.getId()) {
			
			return 1;
			
		}

		return 0;
	}

}
