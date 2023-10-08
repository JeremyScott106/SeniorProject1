package Project;

import java.util.ArrayList;

public class SystemManager {
	
	
	private boolean userSignedIn;	//User sign in status, true if any User is signed in
	private boolean adminSignedIn;	//Admin sign in status, true if an Admin is signed in
	private ArrayList<User> users;
	private ArrayList<Admin> admins;
	
	static ArrayList<category> categories;
	
	
	
	public SystemManager() {
		userSignedIn = false;
		adminSignedIn = false;
		users = new ArrayList<User>();
		admins = new ArrayList<Admin>();
		categories = new ArrayList<category>();
		
	}
	
	
	
	public boolean addUser(User u) {	//This should check to ensure that a new user doesn't have the same username as an existing user
		users.add(u);
		return true;
	}
	
	public boolean addAdmin(Admin a) {	//This should check to ensure that a new user doesn't have the same username as an existing user
		admins.add(a);
		return true;
	}
	
	public boolean addCategory(category c) {	//This should check to ensure that a new category doesn't already exist
		categories.add(c);
		return true;
	}
	
	public Boolean createCategory(String name) {
		if (Validator.validateCategoryNameExists(categories, name)) {	//If there exists a category with given name
			return false;	//return false
		}
		else {
			category c = new category(name);	//else, create new category
			categories.add(c);		//add category
			return true;			//return true
		}
	}
	
	//Assumes GUI will send over just category name, not category object
	public Boolean createGroup(String groupName, String categoryName) {
		category c = Validator.getCategoryFromName(categories, categoryName);	//Get category with given name if there exists one, null otherwise
		
		if (c == null) {	//If validator returned null
			return false;	//return false
		}
		else {		//If validator returned a category
			return c.createGroup(groupName);	//create group within category, retu9rns true/false depending on if group was created
		}
	}
	
	
	
	public boolean login(String username, String password) {
		
		User u = Validator.validUserName_Users(users, username);	//Checks under Users
		
		if (u == null) {	//If the username is not of a User
			
			u = Validator.validUserName_Admins(admins, username);	//Checks under Admins
			
			if (u == null) {	//If the username is not of a Admin
				return false;	//Will return false
			}
			else {	//If the username is of an Admin
				
				if (Validator.validPassword(u, password)) {	//If the password was correct
					userSignedIn = true;	//Set User sign in status to true
					adminSignedIn = true;	//Set Admin sign in status to true
					return true;	//Return true
				}
				else {	//If the password was incorrect
					return false;	//Return false 
				}
				
			}
		}
		else {	//If the username is of a User
			
			if (Validator.validPassword(u, password)) {	//If the password was correct
				userSignedIn = true;	//Set User sign in status to true
				return true;	//Return true
			}
			else {	//If the password was incorrect
				return false;	//Return false 
			}
				
		}
	}
	
	
	
	
	public ArrayList<category> getCategories_Alphabetically() {
		
		for (int i = 0; i < categories.size(); i++) {
			
			for (int j = 0; j < categories.size() - i - 1; j++) {
				
				String name1 = categories.get(j).getName();
				String name2 = categories.get(j+1).getName();
				
				if (name1.compareTo(name2) > 0) {
					category temp = categories.get(j);
					categories.set(j, categories.get(j+1));
					categories.set(j+1, temp);
					
				}
				
			}
			
		}
		
		return categories;
	}
	
	

}
