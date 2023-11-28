package Project;

public class Voted {
	
	private boolean hasUpvoted;
	private boolean hasDownvoted;
	private User user;
	private Post post;
	
	//test:1
	public Voted (User u, Post p){
		this.user = u;
		this.post = p;
		hasUpvoted = false;
		hasDownvoted = false;
	}
	
	//test:1
	public void up() {
		hasUpvoted = true;
		hasDownvoted = false;
	}
	
	//test:1
	public void down() {
		hasUpvoted = false;
		hasDownvoted = true;
	}
	
	//test:1
	public boolean getUp(){
		return hasUpvoted;
	}
	
	//test:1
	public boolean getDown(){
		return hasDownvoted;
	}
	
	//test:1
	public User getUser(){
		return user;
	}
	
	//test:1
	public Post getPost(){
		return post;
	}
	
	//test:3
	public boolean compareTo(Voted v) {
		if (v.getUser().compareId(user.getId())) {
			if(v.getPost().compareTo(post) == 1) {
				return true;
			}
		}
		else {
			return false;
		}
		return false;
	}
	
}