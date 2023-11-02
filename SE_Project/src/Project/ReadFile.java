package Project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
	
	static boolean currentlyReadingData;	//True if data is currently being read, false if between sets of data
	
	
	public static void readFile(SystemManager manager, String fileName) throws FileNotFoundException, IncorrectFileFormatException {
		
		
		
		File dataFile = new File(fileName);
		
		try {
			Scanner reader = new Scanner(dataFile);
			
			currentlyReadingData = false;	//not Currently reading data
			
			
			while (reader.hasNextLine()) {	//While there are still lines to be read
				String line = reader.nextLine();	//Line currently being read
				
				if (line.equals("@START")) {								//If line is the start of a set of Data
					if (currentlyReadingData) {									//and data is currently being read
						throw new IncorrectFileFormatException();					//throw exception
					}
					else {														//or if data is not being read
						currentlyReadingData = true;								//set currentlyReadingData to true
						continue;													//and continue to next line
					}
				}
				else if (line.equals("@ADMIN") && currentlyReadingData) {	//If current line rules next data set to be a Admin
					readAdmin(manager, reader);									//go read the data in the Admin
				}
				else if (line.equals("@USER") && currentlyReadingData) {	//If current line rules next data set to be a User
					readUser(manager, reader);									//go read the data in the User
				}
				else if(line.equals("@CATEGORY") && currentlyReadingData) {	//If current line rules next data set to be a Category
					readCategory(manager, reader);								//go  read the data in the Category
				}
				else if(line.equals("@GROUP") && currentlyReadingData) {	//If current line rules next data set to be a Group
					readGroup(manager, reader);									//go read the data in the Group
				}
				else if (line.equals("")) {									//If the current line is empty
					continue;													//continue to next line
				}
				else if (line.equals("@ENDFILE")) {							//If the current line rules that this is the end of the file
					break;														//break the loop
				}
				else {														//If none of the above
					throw new IncorrectFileFormatException();					//throw incorrectFileFormatException
				}
			}
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new FileNotFoundException();
		} catch (IncorrectFileFormatException e) {
			// TODO Auto-generated catch block
			throw new IncorrectFileFormatException();
		}
		
	}
	
	
	private static void readAdmin(SystemManager manager, Scanner reader) throws IncorrectFileFormatException {
		String name = "";				//Name of the User
		boolean gotName = false;			//Set to true once name is read
		String birthdate = "";			//Birthday of the User
		boolean gotBday = false;			//Set to true once bday is read
		String city = "";				//City of the User
		boolean gotCity = false;			//Set to true once city is read
		String state = "";				//State of the User
		boolean gotState = false;			//Set to true once state is read
		String username = "";			//Username of the User
		boolean gotUsername = false;		//Set to true once username is read
		String password = "";			//password of the User
		boolean gotPassword = false;		//Set to true once password is read
		String regDate = "";			//RegisteredDate of the user
		boolean gotRegDate = false;			//Set to true once regDate is read
		
		
		
		while(currentlyReadingData) {		//While the current data set is being read
			
			String line = reader.nextLine();	//Line currently being read
			
			
			if (line.equals("@END")) {			//If the line rules the end of the data set
				break;								//break the loop
			}
			
			String sub = "";	//For the first part of the line to identify what data is being read
			
			try {
				sub = line.substring(0, 5);	//Set sub to first 5 characters of line
			}
			catch (StringIndexOutOfBoundsException e) {	//If that can't be read
				throw new IncorrectFileFormatException();	//throw incorrectFileFormatException
			}
			
			if (sub.equals("@NAME")) {					//If the substring rules that the line contains the Name
				if(gotName) {								//and if a Name has already been read
					throw new IncorrectFileFormatException();	//throw incorrectFileFormatException
				}
				else {										//or if a Name has not already been read
					name = line.substring(6);					//get the Name from the line
					gotName = true;								//set gotName to true
					continue;									//and continue to next line
				}
				
			}
			else if (sub.equals("@BIRT")) {				//If the substring rules that the line contains the Birthday
				if(gotBday) {								//and if a Bday has already been read
					throw new IncorrectFileFormatException();	//throw incorrectFileFormatException
				}
				else {										//or if a Bbay has not already been read
					birthdate = line.substring(11);				//get the Bday from the line
					gotBday = true;								//set gotBday to true
					continue;									//and continue to next line
				}
				
			}
			else if (sub.equals("@CITY")) {				//If the substring rules that the line contains the City
				if(gotCity) {								//and if the City has already been read
					throw new IncorrectFileFormatException();	//throw incorrectFileFormatException
				}
				else {										//or if the City has not already been read
					city = line.substring(6);					//get the City from the line
					gotCity = true;								//set gotCity to true
					continue;									//and continue to next line
				}
				
			}
			else if (sub.equals("@STAT")) {				//If the substring rules that the line contains the State
				if(gotState) {								//and if the State has already been read
					throw new IncorrectFileFormatException();	//throw incorrectFileFormatException
				}
				else {										//or if the State has not already been read
					state = line.substring(7);					//get the State from the line
					gotState = true;							//set gotState to true
					continue;									//and continue to the next line
				}
				
			}
			else if (sub.equals("@USER")) {				//If the substring rules that the line contains the Username
				if(gotUsername) {							//and if the Username has already been read
					throw new IncorrectFileFormatException();	//throw incorrectFileFormatException
				}
				else {										//or if the Username has not already been read
					username = line.substring(10);				//get Username from the line
					gotUsername = true;							//set gotUsername to true
					continue;									//and continue to the next line
				}
				
			}
			else if (sub.equals("@PASS")) {				//If the substring rules that the line contains the Password
				if(gotPassword) {							//and if the Password has already been read
					throw new IncorrectFileFormatException();	//throw incorrectFileFormatException
				}
				else {										//or if the Password has not already been read
					password = line.substring(10);				//get Password from the line
					gotPassword = true;							//set gotPassword to true
					continue;									//and continue to the next line 
				}
				
			}
			else if (sub.equals("@REGI")) {				//If the substring rules that the line contains the RegisteredDate
				if(gotRegDate) {							//and if the RegDate has already been read
					throw new IncorrectFileFormatException();	//throw incorrectFileFormatException
				}
				else {										//or if the RegDate has nor already been read
					regDate = line.substring(17);				//get RegDate from the line
					gotRegDate = true;							//set gorRegDate to true
					continue;									//and continue to the next line
				}
				
			}
			else {										//If what data is being read cannot be determined
				throw new IncorrectFileFormatException();	//throw incorrectFileFormatException
			}
			
		}
		
		//If all the bits of data were read from the file for the Admin
		if (gotName && gotBday && gotCity && gotState && gotUsername && gotPassword && gotRegDate) {
			Admin a = new Admin(name, username, password, birthdate, city, state, regDate);	//create new Admin
			manager.addAdmin(a);				//Add to manager
			currentlyReadingData = false;		//set currentlyReadingData to false
		}
		else {										//If any bit of data was not collected
			throw new IncorrectFileFormatException();	//throw incorrectFileFormatException
		}
		
	}
	
	
	private static void readUser(SystemManager manager, Scanner reader) throws IncorrectFileFormatException {
		String name = "";
		boolean gotName = false;
		String bday = "";
		boolean gotBday = false;
		String city = "";
		boolean gotCity = false;
		String state = "";
		boolean gotState = false;
		String username = "";
		boolean gotUsername = false;
		String password = "";
		boolean gotPassword = false;
		String regDate = "";
		boolean gotRegDate = false;
		
		while(currentlyReadingData) {
			
			String line = reader.nextLine();
			
			
			if (line.equals("@END")) {
				break;
			}
			
			String sub = "";
			
			try {
				sub = line.substring(0, 5);
			}
			catch (StringIndexOutOfBoundsException e) {
				throw new IncorrectFileFormatException();
			}
			
			if (sub.equals("@NAME")) {
				if(gotName) {
					throw new IncorrectFileFormatException();
				}
				else {
					name = line.substring(6);
					gotName = true;
					continue;
				}
				
			}
			else if (sub.equals("@BIRT")) {
				if(gotBday) {
					throw new IncorrectFileFormatException();
				}
				else {
					bday = line.substring(11);
					gotBday = true;
					continue;
				}
				
			}
			else if (sub.equals("@CITY")) {
				if(gotCity) {
					throw new IncorrectFileFormatException();
				}
				else {
					city = line.substring(6);
					gotCity = true;
					continue;
				}
				
			}
			else if (sub.equals("@STAT")) {
				if(gotState) {
					throw new IncorrectFileFormatException();
				}
				else {
					state = line.substring(7);
					gotState = true;
					continue;
				}
				
			}
			else if (sub.equals("@USER")) {
				if(gotUsername) {
					throw new IncorrectFileFormatException();
				}
				else {
					username = line.substring(10);
					gotUsername = true;
					continue;
				}
				
			}
			else if (sub.equals("@PASS")) {
				if(gotPassword) {
					throw new IncorrectFileFormatException();
				}
				else {
					password = line.substring(10);
					gotPassword = true;
					continue;
				}
				
			}
			else if (sub.equals("@REGI")) {
				if(gotRegDate) {
					throw new IncorrectFileFormatException();
				}
				else {
					regDate = line.substring(17);
					gotRegDate = true;
					continue;
				}
				
			}
			else {
				throw new IncorrectFileFormatException();
			}
		}
		
		
		if (gotName && gotBday && gotCity && gotState && gotUsername && gotPassword && gotRegDate) {
			User a = new User(name, username, password, bday, city, state, regDate);
			currentlyReadingData = false;
			manager.addUser(a);
		}
		else {
			throw new IncorrectFileFormatException();
		}
	}

	
	private static void readCategory(SystemManager manager, Scanner reader) throws IncorrectFileFormatException {
		
		String name = "";
		boolean gotName = false;
		
		while (currentlyReadingData) {
			
			String line = reader.nextLine();
			
			if (line.equals("@END")) {
				currentlyReadingData = false;
				break;
			}
			
			String sub = "";
			
			try {
				sub = line.substring(0, 5);
			}
			catch (StringIndexOutOfBoundsException e) {
				throw new IncorrectFileFormatException();
			}
			
			if (sub.equals("@NAME")) {
				if (gotName) {
					throw new IncorrectFileFormatException();
				}
				else {
					name = line.substring(6);
					gotName = true;
					continue;
				}
			}
			else {
				throw new IncorrectFileFormatException();
			}
			
		}
		
		if (gotName) {
			category c = new category(name);
			manager.addCategory(c);
		}
		
	}
	
	
	private static void readGroup(SystemManager manager, Scanner reader) throws IncorrectFileFormatException {
		
		String name = "";
		boolean gotName = false;
		String catName = "";
		boolean gotCatName = false;
		
		while (currentlyReadingData) {
			
			String line = reader.nextLine();
			
			if (line.equals("@END")) {
				currentlyReadingData = false;
				break;
			}
			
			String sub = "";
			
			try {
				sub = line.substring(0, 5);
			}
			catch (StringIndexOutOfBoundsException e) {
				throw new IncorrectFileFormatException();
			}
			
			if (sub.equals("@NAME")) {
				if (gotName) {
					throw new IncorrectFileFormatException();
				}
				else {
					name = line.substring(6);
					gotName = true;
					continue;
				}
			}
			else if (sub.equals("@CATE")) {
				if (gotCatName) {
					throw new IncorrectFileFormatException();
				}
				else {
					catName = line.substring(10);
					gotCatName = true;
					continue;
				}
			}
			else {
				throw new IncorrectFileFormatException();
			}
			
		}
		
		if (gotName && gotCatName) {
			
			category c = manager.getCategoryByName(catName);
			
			if (!(c==null)) {
				
				Group g = new Group(name);
				
				c.addGroup(g);
				
			}
			
		}
		
	}
	
	
}

