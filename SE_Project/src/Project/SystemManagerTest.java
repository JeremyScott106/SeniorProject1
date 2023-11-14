package Project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;

class SystemManagerTest {

	/*
	 * NOTICE:
	 *
	 * Tests will have to be updated as classes are updated to where
	 * constructors take more arguments
	 *
	 */

	@Test
	void testLogin_Success_User() {

		SystemManager sm = new SystemManager();

		User u1 = new User("Jack", "jackster3", "HKb@wser!", "10/10/1997", "Valdosta", "Georgia");
		User u2 = new User("Dan", "theWiz", "WartH@g77", "10/10/1997", "Valdosta", "Georgia");
		User u3 = new User("Carol", "WestCarolina", "P!zzaH$t", "10/10/1997", "Valdosta", "Georgia");
		User u4 = new User("Dulaney", "LegalTrouble", "D@uble&Tr@uble", "10/10/1997", "Valdosta", "Georgia");
		User u5 = new User("Ethan", "IDK", "WHY#5", "10/10/1997", "Valdosta", "Georgia");

		sm.addUser(u1);
		sm.addUser(u2);
		sm.addUser(u3);
		sm.addUser(u4);
		sm.addUser(u5);

		boolean tf = sm.login("LegalTrouble", "D@uble&Tr@uble");

		assertEquals(true, tf);
	}

	@Test
	void testLogin_Failure_Username_User() {

		SystemManager sm = new SystemManager();

		User u1 = new User("Jack", "jackster3", "HKb@wser!", "10/10/1997", "Valdosta", "Georgia");
		User u2 = new User("Dan", "theWiz", "WartH@g77", "10/10/1997", "Valdosta", "Georgia");
		User u3 = new User("Carol", "WestCarolina", "P!zzaH$t", "10/10/1997", "Valdosta", "Georgia");
		User u4 = new User("Dulaney", "LegalTrouble", "D@uble&Tr@uble", "10/10/1997", "Valdosta", "Georgia");
		User u5 = new User("Ethan", "IDK", "WHY#5", "10/10/1997", "Valdosta", "Georgia");

		sm.addUser(u1);
		sm.addUser(u2);
		sm.addUser(u3);
		sm.addUser(u4);
		sm.addUser(u5);

		boolean tf = sm.login("Failure", "D@uble&Tr@uble");

		assertEquals(false, tf);
	}


	@Test
	void testLogin_Failure_Password_User() {

		SystemManager sm = new SystemManager();

		User u1 = new User("Jack", "jackster3", "HKb@wser!", "10/10/1997", "Valdosta", "Georgia");
		User u2 = new User("Dan", "theWiz", "WartH@g77", "10/10/1997", "Valdosta", "Georgia");
		User u3 = new User("Carol", "WestCarolina", "P!zzaH$t", "10/10/1997", "Valdosta", "Georgia");
		User u4 = new User("Dulaney", "LegalTrouble", "D@uble&Tr@uble", "10/10/1997", "Valdosta", "Georgia");
		User u5 = new User("Ethan", "IDK", "WHY#5", "10/10/1997", "Valdosta", "Georgia");

		sm.addUser(u1);
		sm.addUser(u2);
		sm.addUser(u3);
		sm.addUser(u4);
		sm.addUser(u5);

		boolean tf = sm.login("LegalTrouble", "Failure");

		assertEquals(false, tf);
	}

	@Test
	void testLogin_Success_Admin() {

		SystemManager sm = new SystemManager();

		Admin a1 = new Admin("Jack", "jackster3", "HKb@wser!", "10/10/1997", "Valdosta", "Georgia");
		Admin a2 = new Admin("Dan", "theWiz", "WartH@g77", "10/10/1997", "Valdosta", "Georgia");

		sm.addAdmin(a1);
		sm.addAdmin(a2);

		boolean tf = sm.login("jackster3", "HKb@wser!");

		assertEquals(true, tf);
	}

	@Test
	void testLogin_Failure_Username_Admin() {

		SystemManager sm = new SystemManager();

		Admin a1 = new Admin("Jack", "jackster3", "HKb@wser!", "10/10/1997", "Valdosta", "Georgia");
		Admin a2 = new Admin("Dan", "theWiz", "WartH@g77", "10/10/1997", "Valdosta", "Georgia");

		sm.addAdmin(a1);
		sm.addAdmin(a2);

		boolean tf = sm.login("jackster7", "HKb@wser!");

		assertEquals(false, tf);
	}

	@Test
	void testLogin_Falilure_Password_Admin() {

		SystemManager sm = new SystemManager();

		Admin a1 = new Admin("Jack", "jackster3", "HKb@wser!", "10/10/1997", "Valdosta", "Georgia");
		Admin a2 = new Admin("Dan", "theWiz", "WartH@g77", "10/10/1997", "Valdosta", "Georgia");

		sm.addAdmin(a1);
		sm.addAdmin(a2);

		boolean tf = sm.login("jackster3", "Failure");

		assertEquals(false, tf);
	}


	@Test
	void testGetGroupsSortedAlphabetically() {

		SystemManager sm = new SystemManager();
		
		category c1 = new category("fun");
		
		sm.addCategory(c1);

		Group g1 = new Group("Sports");
		Group g2 = new Group("Games");
		Group g3 = new Group("Video Games");
		Group g4 = new Group("Foods");
		Group g5 = new Group("Apples");
		
		c1.addGroup(g1);
		c1.addGroup(g2);
		c1.addGroup(g3);
		c1.addGroup(g4);
		c1.addGroup(g5);

		ArrayList<Group> actual = sm.getAllGroups_Alphabetically();

		ArrayList<Group> expected = new ArrayList<>();

		expected.add(g5);
		expected.add(g4);
		expected.add(g2);
		expected.add(g1);
		expected.add(g3);

		assertEquals(expected, actual);

	}
	
	@Test
	void testGetUsers_Alphabetically() {

		SystemManager sm = new SystemManager();
		
		User u1 = new User("Jack", "jackster3", "HKb@wser!", "10/10/1997", "Valdosta", "Georgia");
		User u2 = new User("Dan", "theWiz", "WartH@g77", "10/10/1997", "Valdosta", "Georgia");
		User u3 = new User("Carol", "WestCarolina", "P!zzaH$t", "10/10/1997", "Valdosta", "Georgia");
		User u4 = new User("Dulaney", "LegalTrouble", "D@uble&Tr@uble", "10/10/1997", "Valdosta", "Georgia");
		User u5 = new User("Ethan", "IDK", "WHY#5", "10/10/1997", "Valdosta", "Georgia");

		sm.addUser(u1);
		sm.addUser(u2);
		sm.addUser(u3);
		sm.addUser(u4);
		sm.addUser(u5);

		ArrayList<User> actual = sm.getUsers_Alphabetically();

		ArrayList<User> expected = new ArrayList<>();

		expected.add(u3);
		expected.add(u2);
		expected.add(u4);
		expected.add(u5);
		expected.add(u1);

		assertEquals(expected, actual);

	}

	@Test
	void testGetCategoiesSortedAlphabetically() {

		SystemManager sm = new SystemManager();

		category c1 = new category("Sports");
		category c2 = new category("Games");
		category c3 = new category("Video Games");
		category c4 = new category("Foods");
		category c5 = new category("Apples");

		sm.addCategory(c1);
		sm.addCategory(c2);
		sm.addCategory(c3);
		sm.addCategory(c4);
		sm.addCategory(c5);

		ArrayList<category> actual = sm.getCategories_Alphabetically();

		ArrayList<category> expected = new ArrayList<>();

		expected.add(c5);
		expected.add(c4);
		expected.add(c2);
		expected.add(c1);
		expected.add(c3);

		assertEquals(expected, actual);
	}
	
	@Test
	void testGetMembership() {

		SystemManager sm = new SystemManager();
		
		Group g = new Group("gfun");
		
		User u1 = new User("Jack", "jackster3", "HKb@wser!", "10/10/1997", "Valdosta", "Georgia");
		
		membership m1 = new membership(u1, g);
		g.addMember(m1);
		
		membership actual = sm.getMembership(g, u1);



		assertEquals(m1, actual);
	}
	
	@Test
	void testCreateCategory_Success() {
		SystemManager sm = new SystemManager();

		category c1 = new category("Sports");
		category c2 = new category("Games");
		category c3 = new category("Video Games");
		category c4 = new category("Foods");
		category c5 = new category("Apples");

		sm.addCategory(c1);
		sm.addCategory(c2);
		sm.addCategory(c3);
		sm.addCategory(c4);
		sm.addCategory(c5);

		boolean actual = sm.createCategory("hey");

		assertEquals(true, actual);
	}


	@Test
	void testCreateCategory_Failure() {
		SystemManager sm = new SystemManager();

		category c1 = new category("Sports");
		category c2 = new category("Games");
		category c3 = new category("Video Games");
		category c4 = new category("Foods");
		category c5 = new category("Apples");

		sm.addCategory(c1);
		sm.addCategory(c2);
		sm.addCategory(c3);
		sm.addCategory(c4);
		sm.addCategory(c5);

		boolean actual = sm.createCategory("Foods");

		assertEquals(false, actual);
	}


	@Test
	void testCreateGroup_Success() {
		SystemManager sm = new SystemManager();

		category c = new category("Sports");

		Group g1 = new Group("Football");
		Group g2 = new Group("Soccer");

		c.addGroup(g1);
		c.addGroup(g2);

		sm.addCategory(c);

		boolean actual = sm.createGroup("Tennis", "Sports");

		assertEquals(true, actual);
	}


	@Test
	void testCreateGroup_Failure_InvalidCategory() {
		SystemManager sm = new SystemManager();

		category c = new category("Sports");

		Group g1 = new Group("Football");
		Group g2 = new Group("Soccer");

		c.addGroup(g1);
		c.addGroup(g2);

		sm.addCategory(c);

		boolean actual = sm.createGroup("Tennis", "Foods");

		assertEquals(false, actual);
	}


	@Test
	void testCreateGroup_Failure_DuplicateGroup() {
		SystemManager sm = new SystemManager();

		category c = new category("Sports");

		Group g1 = new Group("Football");
		Group g2 = new Group("Soccer");

		c.addGroup(g1);
		c.addGroup(g2);

		sm.addCategory(c);

		boolean actual = sm.createGroup("Soccer", "Sports");

		assertEquals(false, actual);
	}


	@Test
	void testRegisterUser_Success() {
		SystemManager sm = new SystemManager();

		User u1 = new User("Jack", "jackster3", "HKb@wser!", "10/10/1997", "Valdosta", "Georgia");
		User u2 = new User("Dan", "theWiz", "WartH@g77", "10/10/1997", "Valdosta", "Georgia");
		User u3 = new User("Carol", "WestCarolina", "P!zzaH$t", "10/10/1997", "Valdosta", "Georgia");
		User u4 = new User("Dulaney", "LegalTrouble", "D@uble&Tr@uble", "10/10/1997", "Valdosta", "Georgia");
		User u5 = new User("Ethan", "IDK", "WHY#5", "10/10/1997", "Valdosta", "Georgia");

		sm.addUser(u1);
		sm.addUser(u2);
		sm.addUser(u3);
		sm.addUser(u4);
		sm.addUser(u5);

		boolean actual = sm.registerUser("Jack", "11/3/99", "Valdosta", "GA", "JackTheWack", "W@ck0#5");

		assertEquals(true, actual);
	}

	@Test
	void testRegisterUser_Failure() {
		SystemManager sm = new SystemManager();

		User u1 = new User("Jack", "jackster3", "HKb@wser!", "10/10/1997", "Valdosta", "Georgia");
		User u2 = new User("Dan", "theWiz", "WartH@g77", "10/10/1997", "Valdosta", "Georgia");
		User u3 = new User("Carol", "WestCarolina", "P!zzaH$t", "10/10/1997", "Valdosta", "Georgia");
		User u4 = new User("Dulaney", "LegalTrouble", "D@uble&Tr@uble", "10/10/1997", "Valdosta", "Georgia");
		User u5 = new User("Ethan", "IDK", "WHY#5", "10/10/1997", "Valdosta", "Georgia");

		sm.addUser(u1);
		sm.addUser(u2);
		sm.addUser(u3);
		sm.addUser(u4);
		sm.addUser(u5);

		boolean actual = sm.registerUser("Jack", "11/3/99", "Valdosta", "GA", "jackster3", "W@ck0#5");

		assertEquals(false, actual);

	}
	
	@Test
	void testJoinGroup_Success() {
		SystemManager sm = new SystemManager();
		
		Group g1 = new Group("fun");

		User u1 = new User("Jack", "jackster3", "HKb@wser!", "10/10/1997", "Valdosta", "Georgia");
		User u2 = new User("Dan", "theWiz", "WartH@g77", "10/10/1997", "Valdosta", "Georgia");
		User u3 = new User("Carol", "WestCarolina", "P!zzaH$t", "10/10/1997", "Valdosta", "Georgia");
		User u4 = new User("Dulaney", "LegalTrouble", "D@uble&Tr@uble", "10/10/1997", "Valdosta", "Georgia");
		User u5 = new User("Ethan", "IDK", "WHY#5", "10/10/1997", "Valdosta", "Georgia");
		
		membership m = new membership(u5, g1);
		User expected = m.getUser();
		
		sm.joinGroup(u1, g1);
		sm.joinGroup(u2, g1);
		sm.joinGroup(u3, g1);
		sm.joinGroup(u4, g1);
		sm.joinGroup(u5, g1);
		
		User actual = sm.getMembership(g1, u5).getUser();

		assertEquals(expected, actual);
	}
	
	@Test
	void testCreateNewPost_Success() {
		SystemManager sm = new SystemManager();
		
		category c1 = new category("djsh"); 
		
		Group g1 = new Group("fun");

		User u5 = new User("Ethan", "IDK", "WHY#5", "10/10/1997", "Valdosta", "Georgia");
				
		membership m = new membership(u5, g1);
		
		Post p1 = new Post(m, "dsudgu", "dusdg");
		Post p2 = new Post(m, "dsudgu", "dusdg");

		
		sm.addCategory(c1);
		sm.addUser(u5);
		c1.addGroup(g1);
		g1.addMember(m);
		g1.addPost(p1);
		g1.addPost(p2);
		
		ArrayList<Post> actual = g1.getPost();
		
		ArrayList<Post> expected = g1.getPost();

		assertEquals(expected, actual);
	}
	
	@Test
	void testDeleteNewPost_Success() {
		SystemManager sm = new SystemManager();
		
		category c1 = new category("djsh"); 
		
		Group g1 = new Group("fun");

		User u5 = new User("Ethan", "IDK", "WHY#5", "10/10/1997", "Valdosta", "Georgia");
				
		membership m = new membership(u5, g1);
		
		Post p1 = new Post(m, "dsudgu", "dusdg");
		Post p2 = new Post(m, "dsudgu", "dusdg");

		
		sm.addCategory(c1);
		sm.addUser(u5);
		c1.addGroup(g1);
		g1.addMember(m);
		g1.addPost(p1);
		g1.addPost(p2);
		sm.deleteNewPost(p1);

				
		ArrayList<Post> actual = g1.getPost();
		
		ArrayList<Post> expected = g1.getPost();

		assertEquals(expected, actual);
	}
	
	@Test
	void testRemoveResponseToPost_Success() {
		SystemManager sm = new SystemManager();
		
		category c1 = new category("djsh"); 
		
		Group g1 = new Group("fun");

		User u5 = new User("Ethan", "IDK", "WHY#5", "10/10/1997", "Valdosta", "Georgia");
				
		membership m = new membership(u5, g1);
		
		Post p1 = new Post(m, "dsudgu", "dusdg");
		Post p2 = new Post(m, "dsudgu", "dusdg");
		Response r1 = new Response(m, "fdihsfi");
		Response r2 = new Response(m, "fdihsgfgfi");


		p1.addResponse(r1);
		p1.addResponse(r2);
		sm.addCategory(c1);
		c1.addGroup(g1);
		g1.addMember(m);
		g1.addPost(p1);
		g1.addPost(p2);
		sm.removeResponseToPost(p1, r1);

				
		ArrayList<Response> actual = p1.getResponse();
		
		ArrayList<Response> expected = new ArrayList<>();
		expected.add(r2);

		assertEquals(expected, actual);
	}
	
	@Test
	void testCreateNewGroup_Success() {
		SystemManager sm = new SystemManager();
		
		category c1 = new category("djsh"); 
		
		Group g1 = new Group("fun");

		User u5 = new User("Ethan", "IDK", "WHY#5", "10/10/1997", "Valdosta", "Georgia");
				
		membership m = new membership(u5, g1);
		
		sm.addCategory(c1);
		c1.addGroup(g1);
		g1.addMember(m);
		
		sm.createNewGroup(c1, "dsd");
		
		ArrayList<Group> actual = c1.getGroups();
		
		ArrayList<Group> expected = c1.getGroups();

		assertEquals(expected, actual);
	}
	
	@Test
	void testGetAdmins_Alphabetically() {
		SystemManager manager = new SystemManager();
		
		Admin a1 = new Admin("Jack", "jackster3", "HKb@wser!", "10/10/1997", "Valdosta", "Georgia");
		Admin a2 = new Admin("Dan", "theWiz", "WartH@g77", "10/10/1997", "Valdosta", "Georgia");
		Admin a3 = new Admin("Carol", "WestCarolina", "P!zzaH$t", "10/10/1997", "Valdosta", "Georgia");
		Admin a4 = new Admin("Dulaney", "LegalTrouble", "D@uble&Tr@uble", "10/10/1997", "Valdosta", "Georgia");
		Admin a5 = new Admin("Ethan", "IDK", "WHY#5", "10/10/1997", "Valdosta", "Georgia");
		
		manager.addAdmin(a1);
		manager.addAdmin(a2);
		manager.addAdmin(a3);
		manager.addAdmin(a4);
		manager.addAdmin(a5);
		
		ArrayList<Admin> actual = manager.getAdmins_Alphabetically();
		
		ArrayList<Admin> expected = new ArrayList<Admin>();
		
		expected.add(a3);
		expected.add(a2);
		expected.add(a4);
		expected.add(a5);
		expected.add(a1);
		
		assertEquals(expected, actual);
  }
	
	@Test
	void testIsUserOfGroup() {
		SystemManager sm = new SystemManager();
		Group g1 = new Group("Funny");
		category c1 = new category("happy");
		
		c1.addGroup(g1);
		
		sm.addCategory(c1);

		User u1 = new User("Jack", "jackster3", "HKb@wser!", "10/05/12", "10/5/12", "10/5/12");
		User u2 = new User("Dan", "theWiz", "WartH@g77", "10/05/12", "10/5/12", "5/5/5");
		
		membership m1 = new membership(u1, g1);
		membership m2 = new membership(u2, g1);

		g1.addMember(m1);
		g1.addMember(m2);
		
		c1.addGroup(g1);

		sm.addUser(u1);
		sm.addUser(u2);

		Boolean actual = sm.isUserOfGroup(u2, g1);
		Boolean expected = true;

		assertEquals(expected, actual);
	}
	
		

	@Test
	void testgetGroupsByUser_success() {
		SystemManager sm = new SystemManager();
		Group g1 = new Group("Funny");
		Group g2 = new Group("Happy");
		category c1 = new category("happy");
		
		c1.addGroup(g1);
		c1.addGroup(g2);
		
		sm.addCategory(c1);

		User u1 = new User("Jack", "jackster3", "HKb@wser!", "10/05/12", "10/5/12", "10/5/12");
		User u2 = new User("Dan", "theWiz", "WartH@g77", "10/05/12", "10/5/12", "5/5/5");
		
		membership m1 = new membership(u1, g1);
		membership m2 = new membership(u2, g1);
		membership m3 = new membership(u1, g2);

		g1.addMember(m1);
		g1.addMember(m2);
		g2.addMember(m3);
		
		c1.addGroup(g1);
		c1.addGroup(g2);

		sm.addUser(u1);
		sm.addUser(u2);

		ArrayList<Group> actual = new ArrayList<>();
		actual.addAll(sm.getGroupsByUser(u1));
		
		ArrayList<Group> expected = new ArrayList<>();
		expected.add(g1);
		expected.add(g2);

		assertEquals(expected, actual);
	}
	
	@Test
	void testgetUsersInGroup_Success() {
		SystemManager sm = new SystemManager();
		Group g = new Group("Funny");
		
		category c1 = new category("Sports");

		User u1 = new User("Jack", "jackster3", "HKb@wser!", "10/05/12", "10/5/12", "10/5/12");
		User u2 = new User("Dan", "theWiz", "WartH@g77", "10/05/12", "10/5/12", "5/5/5");
		
		membership m1 = new membership(u1, g);
		membership m2 = new membership(u2, g);

		g.addMember(m1);
		g.addMember(m2);
		
		c1.addGroup(g);

		sm.addUser(u1);
		sm.addUser(u2);

		ArrayList<User> actual = new ArrayList<>();
		actual.addAll(sm.getUsersInGroup(g));
		
		ArrayList<User> expected = new ArrayList<>();
		expected.add(u1);
		expected.add(u2);

		assertEquals(expected, actual);
	}
	
	@Test
	void testGetGroupsInCategory_Alphabetically() {
		SystemManager sm = new SystemManager();
		
		category c1 = new category("test");
		
		sm.addCategory(c1);

		Group g1 = new Group("Hockey");
		Group g2 = new Group("Soccer");
		Group g3 = new Group("Football");
		Group g4 = new Group("Basketball");
		Group g5 = new Group("Tennis");
		
		c1.addGroup(g1);
		c1.addGroup(g2);
		c1.addGroup(g3);
		c1.addGroup(g4);
		c1.addGroup(g5);


		ArrayList<Group> expected = new ArrayList<>();
		expected.add(g4);
		expected.add(g3);
		expected.add(g1);
		expected.add(g2);
		expected.add(g5);
		
		 
		ArrayList<Group> actual = new ArrayList<>();
		actual.addAll(sm.getGroupsInCategory_Alphabetically(c1));
		assertEquals(expected, actual);

	}
	
	@Test
	void testViewUsersPostsResponses() {
		SystemManager sm = new SystemManager();
		category c = new category("fun");
		Group testGroup = new Group("Standard Name");
		User testUser = new User("Bob", "ID", "pw", "11/11/2001", "Valdosta", "GA");
		membership m = new membership(testUser, testGroup);
		Post testPost1 = new Post (m, "I", "This is the message");
		Response r1 = new Response(m, "n");
		Response r2 = new Response(m, "n000");

		ArrayList<Object> expected = new ArrayList<>();
		expected.add(testPost1);
		expected.add(r1);
		expected.add(r2);
		
		sm.addCategory(c);
		c.addGroup(testGroup);
		testGroup.addMember(m);
		testGroup.addPost(testPost1);
		sm.addUser(testUser);
		
		testPost1.addResponse(r1);
		testPost1.addResponse(r2);
		
		assertEquals(expected, sm.viewUsersPostsResponses(testUser));
	}
	
	@Test
	void testViewUsersPostsResponsesInGroup() {
		SystemManager sm = new SystemManager();
		category c = new category("fun");
		Group testGroup = new Group("Standard Name");
		User testUser = new User("Bob", "ID", "pw", "11/11/2001", "Valdosta", "GA");
		membership m = new membership(testUser, testGroup);
		Post testPost1 = new Post (m, "I", "This is the message");
		Response r1 = new Response(m, "n");
		Response r2 = new Response(m, "n000");

		ArrayList<Object> expected = new ArrayList<>();
		expected.add(testPost1);
		expected.add(r1);
		expected.add(r2);
		
		sm.addCategory(c);
		c.addGroup(testGroup);
		testGroup.addMember(m);
		testGroup.addPost(testPost1);
		sm.addUser(testUser);
		
		testPost1.addResponse(r1);
		testPost1.addResponse(r2);
		
		assertEquals(expected, sm.viewUsersPostsResponsesInGroup(testUser, testGroup));
	}
	
	@Test
	void testViewPostsResponsesInGroup() {
		SystemManager sm = new SystemManager();
		category c = new category("fun");
		Group testGroup = new Group("Standard Name");
		User testUser = new User("Bob", "ID", "pw", "11/11/2001", "Valdosta", "GA");
		membership m = new membership(testUser, testGroup);
		Post testPost1 = new Post (m, "I", "This is the message");
		Response r1 = new Response(m, "n");
		Response r2 = new Response(m, "n000");

		ArrayList<Object> expected = new ArrayList<>();
		expected.add(testPost1);
		expected.add(r1);
		expected.add(r2);
		
		sm.addCategory(c);
		c.addGroup(testGroup);
		testGroup.addMember(m);
		testGroup.addPost(testPost1);
		sm.addUser(testUser);	
		
		testPost1.addResponse(r1);
		testPost1.addResponse(r2);
		
		assertEquals(expected, sm.viewPostsResponsesInGroup(testGroup));
	}
	
	@Test
	void testViewPostsInGroup() {
		SystemManager sm = new SystemManager();
		category c = new category("fun");
		Group testGroup = new Group("Standard Name");
		User testUser = new User("Bob", "ID", "pw", "11/11/2001", "Valdosta", "GA");
		membership m = new membership(testUser, testGroup);
		Post testPost1 = new Post (m, "I", "This is the message");
		Response r1 = new Response(m, "n");
		Response r2 = new Response(m, "n000");

		ArrayList<Object> expected = new ArrayList<>();
		expected.add(testPost1);
		
		sm.addCategory(c);
		c.addGroup(testGroup);
		testGroup.addMember(m);
		testGroup.addPost(testPost1);
		sm.addUser(testUser);	
		
		testPost1.addResponse(r1);
		testPost1.addResponse(r2);
		
		assertEquals(expected, sm.viewPostsInGroup(testGroup));
	}
	
	@Test
	void testViewMyResponses() {
		SystemManager sm = new SystemManager();
		category c = new category("fun");
		Group testGroup = new Group("Standard Name");
		User testUser = new User("Bob", "ID", "pw", "11/11/2001", "Valdosta", "GA");
		membership m = new membership(testUser, testGroup);
		Post testPost1 = new Post (m, "I", "This is the message");
		Response r1 = new Response(m, "n");
		Response r2 = new Response(m, "n000");

		ArrayList<Object> expected = new ArrayList<>();
		expected.add(r1);
		expected.add(r2);
		
		sm.addCategory(c);
		c.addGroup(testGroup);
		testGroup.addMember(m);
		testGroup.addPost(testPost1);
		sm.addUser(testUser);
		
		testPost1.addResponse(r1);
		testPost1.addResponse(r2);
		
		assertEquals(expected, sm.viewMyResponses(testUser, testPost1));
	}
	
	@Test
	void testAddAdmin_Success() {
		SystemManager manager = new SystemManager();
		
		Admin a1 = new Admin("Jack", "jackster3", "HKb@wser!", "10/10/1997", "Valdosta", "Georgia");
		Admin a2 = new Admin("Dan", "theWiz", "WartH@g77", "10/10/1997", "Valdosta", "Georgia");
		Admin a3 = new Admin("Carol", "WestCarolina", "P!zzaH$t", "10/10/1997", "Valdosta", "Georgia");
		Admin a4 = new Admin("Dulaney", "LegalTrouble", "D@uble&Tr@uble", "10/10/1997", "Valdosta", "Georgia");
		Admin a5 = new Admin("Ethan", "IDK", "WHY#5", "10/10/1997", "Valdosta", "Georgia");
		
		manager.addAdmin(a1);
		manager.addAdmin(a2);
		manager.addAdmin(a3);
		manager.addAdmin(a4);
		
		
		boolean actual = manager.addAdmin(a5);
		
		assertEquals(true, actual);
	}
	
	@Test
	void testAddAdmin_Failure() {
		SystemManager manager = new SystemManager();
		
		Admin a1 = new Admin("Jack", "jackster3", "HKb@wser!", "10/10/1997", "Valdosta", "Georgia");
		Admin a2 = new Admin("Dan", "theWiz", "WartH@g77", "10/10/1997", "Valdosta", "Georgia");
		Admin a3 = new Admin("Carol", "WestCarolina", "P!zzaH$t", "10/10/1997", "Valdosta", "Georgia");
		Admin a4 = new Admin("Dulaney", "LegalTrouble", "D@uble&Tr@uble", "10/10/1997", "Valdosta", "Georgia");
		Admin a5 = new Admin("Ethan", "IDK", "WHY#5", "10/10/1997", "Valdosta", "Georgia");
		
		manager.addAdmin(a1);
		manager.addAdmin(a2);
		manager.addAdmin(a3);
		manager.addAdmin(a4);
		manager.addAdmin(a5);
		
		
		boolean actual = manager.addAdmin(a5);
		
		assertEquals(false, actual);
	}
	
	
	@Test
	void testAddCategory_Success() {
		SystemManager manager = new SystemManager();
		
		category c1 = new category("Sports");
		category c2 = new category("Games");
		category c3 = new category("Video Games");
		category c4 = new category("Foods");
		
		manager.addCategory(c1);
		manager.addCategory(c2);
		manager.addCategory(c3);
		manager.addCategory(c4);
		
		category c5 = new category("Apples");
		
		boolean actual = manager.addCategory(c5);
		
		assertEquals(true, actual);
		
	}
	
	@Test
	void testAddCategory_Failure() {
		SystemManager manager = new SystemManager();
		
		category c1 = new category("Sports");
		category c2 = new category("Games");
		category c3 = new category("Video Games");
		category c4 = new category("Foods");
		category c5 = new category("Apples");
		
		manager.addCategory(c1);
		manager.addCategory(c2);
		manager.addCategory(c3);
		manager.addCategory(c4);
		manager.addCategory(c5);
		
		boolean actual = manager.addCategory(c5);
		
		assertEquals(false, actual);
		
	}	
	
	@Test
	void testAddUser_Success() {
		SystemManager manager = new SystemManager();
		
		User u1 = new User("Jack", "jackster3", "HKb@wser!", "10/10/1997", "Valdosta", "Georgia");
		User u2 = new User("Dan", "theWiz", "WartH@g77", "10/10/1997", "Valdosta", "Georgia");
		User u3 = new User("Carol", "WestCarolina", "P!zzaH$t", "10/10/1997", "Valdosta", "Georgia");
		User u4 = new User("Dulaney", "LegalTrouble", "D@uble&Tr@uble", "10/10/1997", "Valdosta", "Georgia");
		
		manager.addUser(u1);
		manager.addUser(u2);
		manager.addUser(u3);
		manager.addUser(u4);
		
		User u5 = new User("Ethan", "IDK", "WHY#5", "10/10/1997", "Valdosta", "Georgia");
		
		boolean actual = manager.addUser(u5);
		
		assertEquals(true, actual);
		
	}
	
	@Test
	void testAddUser_Failure() {
		SystemManager manager = new SystemManager();
		
		User u1 = new User("Jack", "jackster3", "HKb@wser!", "10/10/1997", "Valdosta", "Georgia");
		User u2 = new User("Dan", "theWiz", "WartH@g77", "10/10/1997", "Valdosta", "Georgia");
		User u3 = new User("Carol", "WestCarolina", "P!zzaH$t", "10/10/1997", "Valdosta", "Georgia");
		User u4 = new User("Dulaney", "LegalTrouble", "D@uble&Tr@uble", "10/10/1997", "Valdosta", "Georgia");
		
		manager.addUser(u1);
		manager.addUser(u2);
		manager.addUser(u3);
		manager.addUser(u4);
		
		boolean actual = manager.addUser(u3);
		
		assertEquals(false, actual);
		
	}
	
	
	@Test
	void testSystemManager_ReadFileConstructor_Admins() {
		
		String fileName = ".\\SE_Project\\src\\Project\\TextFiles\\ReadFile_Test\\ReadFile_Test_Admin.txt";
		
		SystemManager manager = new SystemManager(fileName);
		
		ArrayList<Admin> actual = manager.getAdmins_Alphabetically();
		
		String[] expected = {"Grayson", "Himanshu", "Jeremy", "John", "Ryan"};
		
		boolean namesMatch = true;
		
		for (int i = 0; i < actual.size(); i++) {
			
			if (!actual.get(i).getName().equals(expected[i])) {
				namesMatch = false;
				break;
			}
		}
		
		assertEquals(true, namesMatch);
		
	}
	
	
	@Test
	void testWriteManager_Admins() {
		SystemManager manager = new SystemManager();
		
		Admin a1 = new Admin("Jack", "jackster3", "HKb@wser!", "10/10/1997", "Valdosta", "Georgia");
		Admin a2 = new Admin("Dan", "theWiz", "WartH@g77", "10/10/1997", "Valdosta", "Georgia");
		Admin a3 = new Admin("Carol", "WestCarolina", "P!zzaH$t", "10/10/1997", "Valdosta", "Georgia");
		Admin a4 = new Admin("Dulaney", "LegalTrouble", "D@uble&Tr@uble", "10/10/1997", "Valdosta", "Georgia");
		Admin a5 = new Admin("Ethan", "IDK", "WHY#5", "10/10/1997", "Valdosta", "Georgia");
		
		manager.addAdmin(a1);
		manager.addAdmin(a2);
		manager.addAdmin(a3);
		manager.addAdmin(a4);
		manager.addAdmin(a5);
		
		String fileName = ".\\SE_Project\\src\\Project\\TextFiles\\WriteFile_Test\\WriteManager_Test_Admins";
		
		boolean actual = manager.writeManager(fileName);
		
		assertEquals(true, actual);
		
	}
	
	
	@Test
	void testGetUsers_Alphabetically_ByUsernames() {
		
		SystemManager manager = new SystemManager();
		
		User u1 = new User("Jack", "jackster3", "HKb@wser!", "10/10/1997", "Valdosta", "Georgia");
		User u2 = new User("Dan", "theWiz", "WartH@g77", "10/10/1997", "Valdosta", "Georgia");
		User u3 = new User("Carol", "WestCarolina", "P!zzaH$t", "10/10/1997", "Valdosta", "Georgia");
		User u4 = new User("Dulaney", "LegalTrouble", "D@uble&Tr@uble", "10/10/1997", "Valdosta", "Georgia");
		User u5 = new User("Ethan", "IDK", "WHY#5", "10/10/1997", "Valdosta", "Georgia");
		
		manager.addUser(u1);
		manager.addUser(u2);
		manager.addUser(u3);
		manager.addUser(u4);
		manager.addUser(u5);
		
		ArrayList<User> actual = manager.getUsers_Alphabetically_ByUsername();
		
		String expected[] = {"IDK", "jackster3", "LegalTrouble", "theWiz", "WestCarolina"};
		
		boolean namesMatch = true;
		
		for (int i = 0; i < actual.size(); i++) {
			
			if (!actual.get(i).getId().equals(expected[i])) {
				namesMatch = false;
				break;
			}
		}
		
		assertEquals(true, namesMatch);
	}
	
	@Test
	void testGetAdmins_Alphabetically_ByUsername() {
		
		SystemManager manager = new SystemManager();
		
		Admin a1 = new Admin("Jack", "jackster3", "HKb@wser!", "10/10/1997", "Valdosta", "Georgia");
		Admin a2 = new Admin("Dan", "theWiz", "WartH@g77", "10/10/1997", "Valdosta", "Georgia");
		Admin a3 = new Admin("Carol", "WestCarolina", "P!zzaH$t", "10/10/1997", "Valdosta", "Georgia");
		Admin a4 = new Admin("Dulaney", "LegalTrouble", "D@uble&Tr@uble", "10/10/1997", "Valdosta", "Georgia");
		Admin a5 = new Admin("Ethan", "IDK", "WHY#5", "10/10/1997", "Valdosta", "Georgia");
		
		manager.addAdmin(a1);
		manager.addAdmin(a2);
		manager.addAdmin(a3);
		manager.addAdmin(a4);
		manager.addAdmin(a5);
		
		ArrayList<Admin> actual = manager.getAdmins_Alphabetically_ByUsername();
		
		String expected[] = {"IDK", "jackster3", "LegalTrouble", "theWiz", "WestCarolina"};
		
		boolean namesMatch = true;
		
		for (int i = 0; i < actual.size(); i++) {
			
			if (!actual.get(i).getId().equals(expected[i])) {
				namesMatch = false;
				break;
			}
		}
		
		assertEquals(true, namesMatch);
	}
	
	
	@Test
	void testGetGroupByName_Success() {
		
		SystemManager sm = new SystemManager();
		
		category c1 = new category("fun");

		Group g1 = new Group("Sports");
		Group g2 = new Group("Games");
		Group g3 = new Group("Video Games");
		Group g4 = new Group("Foods");
		Group g5 = new Group("Apples");
		
		c1.addGroup(g1);
		c1.addGroup(g2);
		c1.addGroup(g3);
		c1.addGroup(g4);
		c1.addGroup(g5);
		
		sm.addCategory(c1);
		
		Group actual = sm.getGroupByName("Foods");
		
		assertEquals(g4, actual);
	}
	
	@Test
	void testGetGroupByName_Failure() {
		
		SystemManager sm = new SystemManager();
		
		category c1 = new category("fun");

		Group g1 = new Group("Sports");
		Group g2 = new Group("Games");
		Group g3 = new Group("Video Games");
		Group g4 = new Group("Foods");
		Group g5 = new Group("Apples");
		
		c1.addGroup(g1);
		c1.addGroup(g2);
		c1.addGroup(g3);
		c1.addGroup(g4);
		c1.addGroup(g5);
		
		sm.addCategory(c1);
		
		Group actual = sm.getGroupByName("testing");
		
		assertEquals(null, actual);
	}
	
	
	@Test
	void testGetUserByUsername_Success() {
		
		SystemManager manager = new SystemManager();
		
		User u1 = new User("Jack", "jackster3", "HKb@wser!", "10/10/1997", "Valdosta", "Georgia");
		User u2 = new User("Dan", "theWiz", "WartH@g77", "10/10/1997", "Valdosta", "Georgia");
		User u3 = new User("Carol", "WestCarolina", "P!zzaH$t", "10/10/1997", "Valdosta", "Georgia");
		User u4 = new User("Dulaney", "LegalTrouble", "D@uble&Tr@uble", "10/10/1997", "Valdosta", "Georgia");
		User u5 = new User("Ethan", "IDK", "WHY#5", "10/10/1997", "Valdosta", "Georgia");
		
		manager.addUser(u1);
		manager.addUser(u2);
		manager.addUser(u3);
		manager.addUser(u4);
		manager.addUser(u5);
		
		User actual = manager.getUserByUsername("theWiz");
		
		assertEquals(u2, actual);
	}
	
	@Test
	void testGetUserByUsername_Failure() {
		
		SystemManager manager = new SystemManager();
		
		User u1 = new User("Jack", "jackster3", "HKb@wser!", "10/10/1997", "Valdosta", "Georgia");
		User u2 = new User("Dan", "theWiz", "WartH@g77", "10/10/1997", "Valdosta", "Georgia");
		User u3 = new User("Carol", "WestCarolina", "P!zzaH$t", "10/10/1997", "Valdosta", "Georgia");
		User u4 = new User("Dulaney", "LegalTrouble", "D@uble&Tr@uble", "10/10/1997", "Valdosta", "Georgia");
		User u5 = new User("Ethan", "IDK", "WHY#5", "10/10/1997", "Valdosta", "Georgia");
		
		manager.addUser(u1);
		manager.addUser(u2);
		manager.addUser(u3);
		manager.addUser(u4);
		manager.addUser(u5);
		
		User actual = manager.getUserByUsername("testing");
		
		assertEquals(null, actual);
	}
	
	@Test
	void testIsLoggedIn() {
		
		SystemManager sm = new SystemManager();
		
		User u1 = new User("Dulaney", "LegalTrouble", "D@uble&Tr@uble", "10/10/1997", "Valdosta", "Georgia");
		
		sm.addUser(u1);

		sm.login("LegalTrouble", "D@uble&Tr@uble");

		boolean expected = true;
		boolean actual = sm.isLoggedIn();

		assertEquals(expected, actual);
	}
	
	@Test
	void testIsAdmin() {

	SystemManager sm = new SystemManager();

	Admin a1 = new Admin("Jack", "jackster3", "HKb@wser!", "10/10/1997", "Valdosta", "Georgia");
	Admin a2 = new Admin("Dan", "theWiz", "WartH@g77", "10/10/1997", "Valdosta", "Georgia");

	sm.addAdmin(a1);
	sm.addAdmin(a2);
	
	sm.login("jackster3", "HKb@wser!");

	boolean expected = true;
	boolean actual = sm.isAdmin();

	assertEquals(expected, actual);
	}
	
	@Test
	void testGetCurrentUser() {

		SystemManager sm = new SystemManager();
		
		User u1 = new User("Dulaney", "LegalTrouble", "D@uble&Tr@uble", "10/10/1997", "Valdosta", "Georgia");
		
		sm.addUser(u1);

		sm.login("LegalTrouble", "D@uble&Tr@uble");
		
		ArrayList<User> actual = new ArrayList<>();
		actual.add(sm.getCurrentUser());
		
		ArrayList<User> expected = new ArrayList<>();
		expected.add(u1);

		assertEquals(expected, actual);
	}
	
	@Test
	void testGetCurrentCategoryAndSetCurrentCategory() {

		SystemManager sm = new SystemManager();
		
		category c1 = new category("fun");

		sm.setCurrentCategory(c1);	

		assertEquals(c1, sm.getCurrentCategory());
	}
	
	@Test
	void testGetCurrentGroupAndSetCurrentGroup() {

		SystemManager sm = new SystemManager();
		
		Group g1 = new Group("fun");

		sm.setCurrentGroup(g1);	

		assertEquals(g1, sm.getCurrentGroup());
	}
	
	@Test
	void testGetCurrentPostAndSetCurrentPost() {

		SystemManager sm = new SystemManager();
		User u1 = new User("Dulaney", "LegalTrouble", "D@uble&Tr@uble", "10/10/1997", "Valdosta", "Georgia");
	
		Group g1 = new Group("fun");

		
		membership m = new membership(u1, g1);

		
		Post p1 = new Post(m, "fun", "dsuagd");

		sm.setCurrentPost(p1);	

		assertEquals(p1, sm.getCurrentPost());
	}
	
	@Test
	void testLogout() {

		SystemManager sm = new SystemManager();

		User u1 = new User("Jack", "jackster3", "HKb@wser!", "10/10/1997", "Valdosta", "Georgia");
		User u2 = new User("Dan", "theWiz", "WartH@g77", "10/10/1997", "Valdosta", "Georgia");
		User u3 = new User("Carol", "WestCarolina", "P!zzaH$t", "10/10/1997", "Valdosta", "Georgia");
		User u4 = new User("Dulaney", "LegalTrouble", "D@uble&Tr@uble", "10/10/1997", "Valdosta", "Georgia");
		User u5 = new User("Ethan", "IDK", "WHY#5", "10/10/1997", "Valdosta", "Georgia");

		sm.addUser(u1);
		sm.addUser(u2);
		sm.addUser(u3);
		sm.addUser(u4);
		sm.addUser(u5);

		sm.login("LegalTrouble", "D@uble&Tr@uble");
		
		sm.logout();
	
		assertEquals(null, sm.getCurrentUser());
	}
	
	@Test
	void testRemoveUserSuspended() {

		SystemManager sm = new SystemManager();
		
		Group testGroup1 = new Group("MembersTest");

		User u1 = new User("Jack", "jackster3", "HKb@wser!", "10/10/1997", "Valdosta", "Georgia");
		User u2 = new User("Dan", "theWiz", "WartH@g77", "10/10/1997", "Valdosta", "Georgia");
		User u3 = new User("Carol", "WestCarolina", "P!zzaH$t", "10/10/1997", "Valdosta", "Georgia");
		User u4 = new User("Dulaney", "LegalTrouble", "D@uble&Tr@uble", "10/10/1997", "Valdosta", "Georgia");
		User u5 = new User("Ethan", "IDK", "WHY#5", "10/10/1997", "Valdosta", "Georgia");
		
		membership m1 = new membership(u1, testGroup1);
		membership m2 = new membership(u2, testGroup1);
		membership m3 = new membership(u3, testGroup1);
		membership m4 = new membership(u4, testGroup1);
		membership m5 = new membership(u5, testGroup1);

		testGroup1.addMember(m1);
		testGroup1.addMember(m2);
		testGroup1.addMember(m3);
		testGroup1.addMember(m4);
		testGroup1.addMember(m5);
		
		ArrayList<membership> expected = new ArrayList<>();
		
		expected.add(m1);
		expected.add(m2);
		expected.add(m3);
		expected.add(m4);

		sm.addUser(u1);
		sm.addUser(u2);
		sm.addUser(u3);
		sm.addUser(u4);
		sm.addUser(u5);
		
		sm.removeUserSuspended(m5);
		ArrayList<membership> actual = testGroup1.getMembers();

		assertEquals(expected, actual);
	}
	
	@Test
	void testGetAllSuspensions() {

		SystemManager sm = new SystemManager();
		
		category c = new category("ds");	
		Group testGroup1 = new Group("MembersTest");
		sm.addCategory(c);
		c.addGroup(testGroup1);

		User u1 = new User("Jack", "jackster3", "HKb@wser!", "10/10/1997", "Valdosta", "Georgia");
		User u2 = new User("Dan", "theWiz", "WartH@g77", "10/10/1997", "Valdosta", "Georgia");
		User u3 = new User("Carol", "WestCarolina", "P!zzaH$t", "10/10/1997", "Valdosta", "Georgia");
		User u4 = new User("Dulaney", "LegalTrouble", "D@uble&Tr@uble", "10/10/1997", "Valdosta", "Georgia");
		User u5 = new User("Ethan", "IDK", "WHY#5", "10/10/1997", "Valdosta", "Georgia");
		
		Suspended s1 = new Suspended(u1, testGroup1);
		Suspended s2 = new Suspended(u2, testGroup1);
		Suspended s3 = new Suspended(u3, testGroup1);
		Suspended s4 = new Suspended(u4, testGroup1);
		Suspended s5 = new Suspended(u5, testGroup1);

		testGroup1.addSuspended(s1);
		testGroup1.addSuspended(s2);
		testGroup1.addSuspended(s3);
		testGroup1.addSuspended(s4);
		testGroup1.addSuspended(s5);
		
		ArrayList<Suspended> expected = new ArrayList<>();
		
		expected.add(s1);
		expected.add(s2);
		expected.add(s3);
		expected.add(s4);
		expected.add(s5);

		ArrayList<Suspended> actual = sm.getAllSuspensions();

		assertEquals(expected, actual);
	}
	
	@Test
	void testGetAllSuspensions_ByUsername() {

		SystemManager sm = new SystemManager();
		
		category c = new category("ds");	
		Group testGroup1 = new Group("MembersTest");
		sm.addCategory(c);
		c.addGroup(testGroup1);

		User u1 = new User("Jack", "jackster3", "HKb@wser!", "10/10/1997", "Valdosta", "Georgia");
		User u2 = new User("Dan", "theWiz", "WartH@g77", "10/10/1997", "Valdosta", "Georgia");
		User u3 = new User("Carol", "WestCarolina", "P!zzaH$t", "10/10/1997", "Valdosta", "Georgia");
		User u4 = new User("Dulaney", "LegalTrouble", "D@uble&Tr@uble", "10/10/1997", "Valdosta", "Georgia");
		User u5 = new User("Ethan", "IDK", "WHY#5", "10/10/1997", "Valdosta", "Georgia");
		
		Suspended s1 = new Suspended(u1, testGroup1);
		Suspended s2 = new Suspended(u2, testGroup1);
		Suspended s3 = new Suspended(u3, testGroup1);
		Suspended s4 = new Suspended(u4, testGroup1);
		Suspended s5 = new Suspended(u5, testGroup1);

		testGroup1.addSuspended(s3);
		testGroup1.addSuspended(s2);
		testGroup1.addSuspended(s4);
		testGroup1.addSuspended(s5);
		testGroup1.addSuspended(s1);
		
		ArrayList<Suspended> expected = new ArrayList<>();
		
		expected.add(s3);
		expected.add(s2);
		expected.add(s4);
		expected.add(s5);
		expected.add(s1);

		ArrayList<Suspended> actual = sm.getAllSuspensions_ByUsername();

		assertEquals(expected, actual);
	}
	
	@Test
	void testReinstateUserSuspended() {

		SystemManager sm = new SystemManager();
		
		Group testGroup1 = new Group("MembersTest");

		User u1 = new User("Jack", "jackster3", "HKb@wser!", "10/10/1997", "Valdosta", "Georgia");
		User u2 = new User("Dan", "theWiz", "WartH@g77", "10/10/1997", "Valdosta", "Georgia");
		User u3 = new User("Carol", "WestCarolina", "P!zzaH$t", "10/10/1997", "Valdosta", "Georgia");
		User u4 = new User("Dulaney", "LegalTrouble", "D@uble&Tr@uble", "10/10/1997", "Valdosta", "Georgia");
		User u5 = new User("Ethan", "IDK", "WHY#5", "10/10/1997", "Valdosta", "Georgia");
		
		membership m1 = new membership(u1, testGroup1);
		membership m2 = new membership(u2, testGroup1);
		membership m3 = new membership(u3, testGroup1);
		membership m4 = new membership(u4, testGroup1);
		membership m5 = new membership(u5, testGroup1);

		testGroup1.addMember(m1);
		testGroup1.addMember(m2);
		testGroup1.addMember(m3);
		testGroup1.addMember(m4);
		testGroup1.addMember(m5);
		
		ArrayList<membership> expected = new ArrayList<>();
		
		expected.add(m1);
		expected.add(m2);
		expected.add(m3);
		expected.add(m4);
		expected.add(m5);

		sm.addUser(u1);
		sm.addUser(u2);
		sm.addUser(u3);
		sm.addUser(u4);
		sm.addUser(u5);
		
		sm.removeUserSuspended(m5);
		sm.reinstateUserSuspended(m5);
		ArrayList<membership> actual = testGroup1.getMembers();

		assertEquals(expected, actual);
	}
	
	@Test
	void testRemoveUserBanned() {

		SystemManager sm = new SystemManager();
		
		Group testGroup1 = new Group("MembersTest");

		User u1 = new User("Jack", "jackster3", "HKb@wser!", "10/10/1997", "Valdosta", "Georgia");
		User u2 = new User("Dan", "theWiz", "WartH@g77", "10/10/1997", "Valdosta", "Georgia");
		User u3 = new User("Carol", "WestCarolina", "P!zzaH$t", "10/10/1997", "Valdosta", "Georgia");
		User u4 = new User("Dulaney", "LegalTrouble", "D@uble&Tr@uble", "10/10/1997", "Valdosta", "Georgia");
		User u5 = new User("Ethan", "IDK", "WHY#5", "10/10/1997", "Valdosta", "Georgia");
		
		membership m1 = new membership(u1, testGroup1);
		membership m2 = new membership(u2, testGroup1);
		membership m3 = new membership(u3, testGroup1);
		membership m4 = new membership(u4, testGroup1);
		membership m5 = new membership(u5, testGroup1);

		testGroup1.addMember(m1);
		testGroup1.addMember(m2);
		testGroup1.addMember(m3);
		testGroup1.addMember(m4);
		testGroup1.addMember(m5);
		
		ArrayList<membership> expected = new ArrayList<>();
		
		expected.add(m1);
		expected.add(m2);
		expected.add(m3);
		expected.add(m4);

		sm.addUser(u1);
		sm.addUser(u2);
		sm.addUser(u3);
		sm.addUser(u4);
		sm.addUser(u5);
		
		sm.removeUserBanned(m5);
		ArrayList<membership> actual = testGroup1.getMembers();

		assertEquals(expected, actual);
	}
	
	@Test
	void testGetAllBans() {

		SystemManager sm = new SystemManager();
		
		category c = new category("ds");	
		Group testGroup1 = new Group("MembersTest");
		sm.addCategory(c);
		c.addGroup(testGroup1);

		User u1 = new User("Jack", "jackster3", "HKb@wser!", "10/10/1997", "Valdosta", "Georgia");
		User u2 = new User("Dan", "theWiz", "WartH@g77", "10/10/1997", "Valdosta", "Georgia");
		User u3 = new User("Carol", "WestCarolina", "P!zzaH$t", "10/10/1997", "Valdosta", "Georgia");
		User u4 = new User("Dulaney", "LegalTrouble", "D@uble&Tr@uble", "10/10/1997", "Valdosta", "Georgia");
		User u5 = new User("Ethan", "IDK", "WHY#5", "10/10/1997", "Valdosta", "Georgia");
		
		Banned s1 = new Banned(u1, testGroup1);
		Banned s2 = new Banned(u2, testGroup1);
		Banned s3 = new Banned(u3, testGroup1);
		Banned s4 = new Banned(u4, testGroup1);
		Banned s5 = new Banned(u5, testGroup1);

		testGroup1.addBanned(s1);
		testGroup1.addBanned(s2);
		testGroup1.addBanned(s3);
		testGroup1.addBanned(s4);
		testGroup1.addBanned(s5);
		
		ArrayList<Banned> expected = new ArrayList<>();
		
		expected.add(s1);
		expected.add(s2);
		expected.add(s3);
		expected.add(s4);
		expected.add(s5);

		ArrayList<Banned> actual = sm.getAllBans();

		assertEquals(expected, actual);
	}
	
	@Test
	void testGetAllBans_ByUsername() {

		SystemManager sm = new SystemManager();
		
		category c = new category("ds");	
		Group testGroup1 = new Group("MembersTest");
		sm.addCategory(c);
		c.addGroup(testGroup1);

		User u1 = new User("Jack", "jackster3", "HKb@wser!", "10/10/1997", "Valdosta", "Georgia");
		User u2 = new User("Dan", "theWiz", "WartH@g77", "10/10/1997", "Valdosta", "Georgia");
		User u3 = new User("Carol", "WestCarolina", "P!zzaH$t", "10/10/1997", "Valdosta", "Georgia");
		User u4 = new User("Dulaney", "LegalTrouble", "D@uble&Tr@uble", "10/10/1997", "Valdosta", "Georgia");
		User u5 = new User("Ethan", "IDK", "WHY#5", "10/10/1997", "Valdosta", "Georgia");
		
		Banned s1 = new Banned(u1, testGroup1);
		Banned s2 = new Banned(u2, testGroup1);
		Banned s3 = new Banned(u3, testGroup1);
		Banned s4 = new Banned(u4, testGroup1);
		Banned s5 = new Banned(u5, testGroup1);

		testGroup1.addBanned(s1);
		testGroup1.addBanned(s2);
		testGroup1.addBanned(s3);
		testGroup1.addBanned(s4);
		testGroup1.addBanned(s5);
		
		ArrayList<Banned> expected = new ArrayList<>();
		
		expected.add(s3);
		expected.add(s2);
		expected.add(s4);
		expected.add(s5);
		expected.add(s1);

		ArrayList<Banned> actual = sm.getAllBans_ByUsername();

		assertEquals(expected, actual);
	}
	
	@Test
	void testflagPost() {
		
		SystemManager sm = new SystemManager();

		Group testGroup = new Group("Standard Name");
		User testUser = new User("Bob", "ID", "pw", "11/11/2001", "Valdosta", "GA");
		membership m = new membership(testUser, testGroup);

		Post testPost1 = new Post (m, "I'm posting.", "This is the message");
		
		sm.flagPost(testPost1);
		Boolean actual = testPost1.getFlag();
		assertEquals(true, actual);
	}
	
	@Test
	void testflagResponse() {
		
		SystemManager sm = new SystemManager();

		Group testGroup = new Group("Standard Name");
		User testUser = new User("Bob", "ID", "pw", "11/11/2001", "Valdosta", "GA");
		membership m = new membership(testUser, testGroup);

		Response testResponse1 = new Response(m, "I disagree.");

		sm.flagResponse(testResponse1);
		Boolean actual = testResponse1.getFlag();
		assertEquals(true, actual);
	}
	
	@Test
	void testGetAllFlaggedPostAndResponses() {

		SystemManager sm = new SystemManager();

		Group testGroup = new Group("Standard Name");
		User testUser = new User("Bob", "ID", "pw", "11/11/2001", "Valdosta", "GA");
		membership m = new membership(testUser, testGroup);

		Response testResponse1 = new Response(m, "I disagree.");		
		Post testPost1 = new Post (m, "I'm posting.", "This is the message");
		
		category c = new category("ds");	
		sm.addCategory(c);
		c.addGroup(testGroup);
		testGroup.addPost(testPost1);
		testPost1.addResponse(testResponse1);
		
		sm.flagResponse(testResponse1);
		sm.flagPost(testPost1);
		
		ArrayList<Object> expected = new ArrayList<>();
		
		expected.add(testPost1);
		expected.add(testResponse1);

		ArrayList<Object> actual = sm.getAllFlaggedPostAndResponses();

		assertEquals(expected, actual);
	}
	
	@Test
	void testGetAllFlaggedPost() {

		SystemManager sm = new SystemManager();

		Group testGroup = new Group("Standard Name");
		User testUser = new User("Bob", "ID", "pw", "11/11/2001", "Valdosta", "GA");
		membership m = new membership(testUser, testGroup);
		
		Post testPost1 = new Post (m, "I'm posting.", "This is the message");
		
		category c = new category("ds");	
		sm.addCategory(c);
		c.addGroup(testGroup);
		testGroup.addPost(testPost1);
		
		sm.flagPost(testPost1);
		
		ArrayList<Post> expected = new ArrayList<>();
		
		expected.add(testPost1);

		ArrayList<Post> actual = sm.getAllFlaggedPost();

		assertEquals(expected, actual);
	}
	
	@Test
	void testGetAllFlaggedResponses() {

		SystemManager sm = new SystemManager();

		Group testGroup = new Group("Standard Name");
		User testUser = new User("Bob", "ID", "pw", "11/11/2001", "Valdosta", "GA");
		membership m = new membership(testUser, testGroup);

		Response testResponse1 = new Response(m, "I disagree.");		
		Post testPost1 = new Post (m, "I'm posting.", "This is the message");
		
		category c = new category("ds");	
		sm.addCategory(c);
		c.addGroup(testGroup);
		testGroup.addPost(testPost1);
		testPost1.addResponse(testResponse1);
		
		sm.flagResponse(testResponse1);
		
		ArrayList<Post> expected = new ArrayList<>();
		
		expected.add(testResponse1);

		ArrayList<Post> actual = sm.getAllFlaggedResponses();

		assertEquals(expected, actual);
	}

	@Test
	void testRemoveFlagOnPost() {

		SystemManager sm = new SystemManager();

		Group testGroup = new Group("Standard Name");
		User testUser = new User("Bob", "ID", "pw", "11/11/2001", "Valdosta", "GA");
		membership m = new membership(testUser, testGroup);

		Post testPost1 = new Post (m, "I'm posting.", "This is the message");
		Post testPost2 = new Post (m, "I'm posting.", "This is the message");

		
		category c = new category("ds");	
		sm.addCategory(c);
		c.addGroup(testGroup);
		testGroup.addPost(testPost1);
		testGroup.addPost(testPost2);
		
		sm.flagPost(testPost1);
		sm.flagPost(testPost2);
		sm.removeFlagOnPost(testPost2);
		
		ArrayList<Post> expected = new ArrayList<>();
		
		expected.add(testPost1);

		ArrayList<Post> actual = sm.getAllFlaggedPost();

		assertEquals(expected, actual);
	}
	
	@Test
	void testRemoveFlagOnResponse() {

		SystemManager sm = new SystemManager();

		Group testGroup = new Group("Standard Name");
		User testUser = new User("Bob", "ID", "pw", "11/11/2001", "Valdosta", "GA");
		membership m = new membership(testUser, testGroup);

		Response testResponse1 = new Response(m, "I disagree.");		
		Response testResponse2 = new Response(m, "I disagree.");		

		Post testPost1 = new Post (m, "I'm posting.", "This is the message");
		
		category c = new category("ds");	
		sm.addCategory(c);
		c.addGroup(testGroup);
		testGroup.addPost(testPost1);
		testPost1.addResponse(testResponse1);
		testPost1.addResponse(testResponse2);

		
		sm.flagResponse(testResponse1);
		sm.flagResponse(testResponse2);
		sm.removeFlagOnResponse(testResponse2);

		
		ArrayList<Post> expected = new ArrayList<>();
		
		expected.add(testResponse1);

		ArrayList<Post> actual = sm.getAllFlaggedResponses();

		assertEquals(expected, actual);
	}
	
	@Test
	void testUpVotePost() {

		SystemManager sm = new SystemManager();

		Group testGroup = new Group("Standard Name");
		User testUser = new User("Bob", "ID", "pw", "11/11/2001", "Valdosta", "GA");
		membership m = new membership(testUser, testGroup);

		Response testResponse1 = new Response(m, "I disagree.");		
		Post testPost1 = new Post (m, "I'm posting.", "This is the message");
		
		category c = new category("ds");	
		sm.addCategory(c);
		c.addGroup(testGroup);
		testGroup.addPost(testPost1);
		testPost1.addResponse(testResponse1);
		
		sm.upVotePost(testPost1);

		assertEquals(1, testPost1.getScore());
	}
	
	@Test
	void testUpVoteResponse() {

		SystemManager sm = new SystemManager();

		Group testGroup = new Group("Standard Name");
		User testUser = new User("Bob", "ID", "pw", "11/11/2001", "Valdosta", "GA");
		membership m = new membership(testUser, testGroup);

		Response testResponse1 = new Response(m, "I disagree.");		
		Post testPost1 = new Post (m, "I'm posting.", "This is the message");
		
		category c = new category("ds");	
		sm.addCategory(c);
		c.addGroup(testGroup);
		testGroup.addPost(testPost1);
		testPost1.addResponse(testResponse1);
		
		sm.upVotePost(testResponse1);

		assertEquals(1, testResponse1.getScore());
	}
	
	@Test
	void testDownVotePost() {

		SystemManager sm = new SystemManager();

		Group testGroup = new Group("Standard Name");
		User testUser = new User("Bob", "ID", "pw", "11/11/2001", "Valdosta", "GA");
		membership m = new membership(testUser, testGroup);

		Response testResponse1 = new Response(m, "I disagree.");		
		Post testPost1 = new Post (m, "I'm posting.", "This is the message");
		
		category c = new category("ds");	
		sm.addCategory(c);
		c.addGroup(testGroup);
		testGroup.addPost(testPost1);
		testPost1.addResponse(testResponse1);
		
		sm.downVotePost(testPost1);

		assertEquals(-1, testPost1.getScore());
	}
	
	@Test
	void testdownVoteResponse() {

		SystemManager sm = new SystemManager();

		Group testGroup = new Group("Standard Name");
		User testUser = new User("Bob", "ID", "pw", "11/11/2001", "Valdosta", "GA");
		membership m = new membership(testUser, testGroup);

		Response testResponse1 = new Response(m, "I disagree.");		
		Post testPost1 = new Post (m, "I'm posting.", "This is the message");
		
		category c = new category("ds");	
		sm.addCategory(c);
		c.addGroup(testGroup);
		testGroup.addPost(testPost1);
		testPost1.addResponse(testResponse1);
		
		sm.downVoteResponse(testResponse1);

		assertEquals(-1, testResponse1.getScore());
	}
	
	@Test
	void testGetPosts_ByScore() {

		SystemManager sm = new SystemManager();

		Group testGroup = new Group("Standard Name");
		User testUser = new User("Bob", "ID", "pw", "11/11/2001", "Valdosta", "GA");
		membership m = new membership(testUser, testGroup);

		Response testResponse1 = new Response(m, "I disagree.");		
		Post testPost1 = new Post (m, "I'm posting.", "This is the message");
		Post testPost2 = new Post (m, "I'm posting.", "This is the message");
		Post testPost3 = new Post (m, "I'm posting.", "This is the message");

		
		category c = new category("ds");	
		sm.addCategory(c);
		c.addGroup(testGroup);
		testGroup.addPost(testPost1);
		testGroup.addPost(testPost2);
		testGroup.addPost(testPost3);

		testPost1.addResponse(testResponse1);
		
		sm.upVotePost(testPost3);
		sm.upVotePost(testPost3);
		sm.upVotePost(testPost3);
		sm.upVotePost(testPost2);
		sm.upVotePost(testPost2);
		sm.upVotePost(testPost1);

		ArrayList<Post> expected = new ArrayList<>();
		expected.add(testPost3);
		expected.add(testPost2);
		expected.add(testPost1);

		ArrayList<Post> actual = sm.getPosts_ByScore();
	
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetLargestUpVotes() {

		SystemManager sm = new SystemManager();

		Group testGroup = new Group("Standard Name");
		User testUser = new User("Bob", "ID", "pw", "11/11/2001", "Valdosta", "GA");
		membership m = new membership(testUser, testGroup);

		Response testResponse1 = new Response(m, "I disagree.");		
		Post testPost1 = new Post (m, "I'm posting.", "This is the message");
		Post testPost2 = new Post (m, "I'm posting.", "This is the message");
		Post testPost3 = new Post (m, "I'm posting.", "This is the message");

		
		category c = new category("ds");	
		sm.addCategory(c);
		c.addGroup(testGroup);
		testGroup.addPost(testPost1);
		testGroup.addPost(testPost2);
		testGroup.addPost(testPost3);

		testPost2.addResponse(testResponse1);
		
		sm.upVotePost(testPost3);
		sm.upVotePost(testPost3);
		sm.upVotePost(testPost3);
		sm.upVotePost(testPost2);
		sm.upVotePost(testPost2);
		sm.upVotePost(testPost2);
		sm.upVotePost(testPost1);
		sm.upVoteResponse(testResponse1);

		ArrayList<Post> expected = new ArrayList<>();
		expected.add(testPost2);
		expected.add(testPost3);
		expected.add(testPost1);

		ArrayList<Post> actual = sm.getLargestUpVotes();
	
		assertEquals(expected, actual);
	}
	
	@Test
	void testViewMostUpVotedUsers() {

		SystemManager sm = new SystemManager();

		Group testGroup = new Group("Standard Name");
		User testUser1 = new User("Bob", "ID", "pw", "11/11/2001", "Valdosta", "GA");
		User testUser2 = new User("Bob", "ID", "pw", "11/11/2001", "Valdosta", "GA");
		User testUser3 = new User("Bob", "ID", "pw", "11/11/2001", "Valdosta", "GA");

		membership m1 = new membership(testUser1, testGroup);
		membership m2 = new membership(testUser2, testGroup);
		membership m3 = new membership(testUser3, testGroup);


		Response testResponse1 = new Response(m1, "I disagree.");		
		Post testPost1 = new Post (m1, "I'm posting.", "This is the message");
		Post testPost2 = new Post (m2, "I'm posting.", "This is the message");
		Post testPost3 = new Post (m3, "I'm posting.", "This is the message");

		
		category c = new category("ds");	
		sm.addCategory(c);
		c.addGroup(testGroup);
		testGroup.addPost(testPost1);
		testGroup.addPost(testPost2);
		testGroup.addPost(testPost3);

		testPost2.addResponse(testResponse1);
		
		sm.upVotePost(testPost3);
		sm.upVotePost(testPost3);
		sm.upVotePost(testPost3);
		sm.upVotePost(testPost2);
		sm.upVotePost(testPost2);
		sm.upVotePost(testPost2);
		sm.upVotePost(testPost1);
		sm.upVoteResponse(testResponse1);

		ArrayList<User> expected = new ArrayList<>();
		expected.add(testUser2);
		expected.add(testUser3);
		expected.add(testUser1);

		ArrayList<User> actual = sm.viewMostUpVotedUsers();
	
		assertEquals(expected, actual);
	}
	
	
	
	

}
