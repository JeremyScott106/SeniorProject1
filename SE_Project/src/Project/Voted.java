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
	
	//Makes it so a vote is upvoted
	//test:1
	public void up() {
		hasUpvoted = true;
		hasDownvoted = false;
	}
	
	//Makes it so a vote is downvoted
	//test:1
	public void down() {
		hasUpvoted = false;
		hasDownvoted = true;
	}
	
	//Gets to where a vote can be upvoted 
	//test:1
	public boolean getUp(){
		return hasUpvoted;
	}
	
	//Gets to where a vote can be downvoted
	//test:1
	public boolean getDown(){
		return hasDownvoted;
	}
	
	//Returns a list of users
	//test:1
	public User getUser(){
		return user;
	}
	
	//Returns a list of post
	//test:1
	public Post getPost(){
		return post;
	}
	
	//Checks to make sure a users can only upvote or downvote on a post once
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
