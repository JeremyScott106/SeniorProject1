package application;
import Project.Admin;
import Project.SystemManager;
import Project.category;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

@SuppressWarnings("serial")
public class Home extends JFrame {

	private JMenuBar topBar;
	private SystemManager manager;
	private JFrame currentFrame;
	private final int maxHeight = 10;
	
			// constructor not needed //
	public Home() {
	}
	
	
	@SuppressWarnings("exports")
	public Home(SystemManager sm,  JMenuBar jmb,  JFrame frame, Dimension dim) {
		this.topBar = jmb;
		this.manager = sm;
		this.currentFrame = frame;
		this.currentFrame.setSize(dim);
		displayGUI();
	}
	
			// This will clear the current frame, allows for rebuilding the frame //
	private void onViewChangeClick() {
		currentFrame.getContentPane().removeAll();
		currentFrame.repaint();
	}
	
			// This creates the top panel that displays the user login info and refresh button //
	private JPanel createTitlePane() {
		
		JPanel titlePanel = new JPanel();
		
		titlePanel.setPreferredSize(new Dimension(0,50));
		titlePanel.setLayout(null);
		
		if (manager.getCurrentUser() instanceof Admin) {
			JButton adminBtn = new JButton("Admin Tools");
			adminBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
			adminBtn.setBounds(274, 10, 152, 19);
			titlePanel.add(adminBtn);
			adminBtn.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
					onViewChangeClick();
					new AdminTools(manager, topBar, currentFrame, currentFrame.getSize());
				}
			});
		}
		
		if (manager.getCurrentUser() == null) {
			JButton btnLogin = new JButton("Login");
			btnLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnLogin.setBounds(129, 10, 131, 25);
			titlePanel.add(btnLogin);
			btnLogin.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
					new LoginPopUp(manager);
				}
			});
		}
		
		if (manager.getCurrentUser() == null) {
			titlePanel.setPreferredSize(new Dimension(0,80));
			JButton btnNewUser = new JButton("Register New Account");
			btnNewUser.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnNewUser.setBounds(10, 45, 250, 25);
			titlePanel.add(btnNewUser);
			btnNewUser.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
					new CreateUserPopUp(manager);
				}
			});
		}
		
		JButton btnRefreshPage = new JButton("Refresh Page");
		btnRefreshPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onViewChangeClick();
				new Home(manager, topBar, currentFrame, currentFrame.getSize());
			}
		});
		btnRefreshPage.setBounds(currentFrame.getBounds().width - 125, 10, 97, 25);
			// FIXME: BUG -> Refresh button disappears if frame shrinks.
		titlePanel.add(btnRefreshPage);
		
		JLabel lblCurrentUser = new JLabel("Current User: ");
		lblCurrentUser.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCurrentUser.setBounds(10, 10, 122, 25);
		titlePanel.add(lblCurrentUser);
		
		if (manager.getCurrentUser() != null) {
			JLabel lblUid = new JLabel(manager.getCurrentUser().getId());
			lblUid.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblUid.setBounds(129, 10, 150, 25);
			titlePanel.add(lblUid);
		}
		
		return titlePanel;
	}
	
		// This prints all categories as buttons on the home screen in horizontal fashion //
	private JPanel createCategoriesGridPane() {
		
		JPanel categoryGridPane = new JPanel();
		GridBagLayout gbl = new GridBagLayout();
		categoryGridPane.setLayout(gbl);
		
		ArrayList<category> alCategories = manager.getCategories_Alphabetically();
		
		for (int i = 0, j = 0; i < alCategories.size(); i++) {
			if (i % maxHeight == 0) {
				j++;
			}
			category c = alCategories.get(i);
			double weightY = 0.0;
			if (i == maxHeight - 1 || (i == alCategories.size() - 1 && i < maxHeight - 1))
				weightY = 1;
			JButton button = new JButton(alCategories.get(i).getName());
			GridBagConstraints gbc = new GridBagConstraints(
		            j, (i % maxHeight),                           //cell x , y
		            1, 1,                           //cell width , cell height
		            1, 								//weightx
		            weightY,			            //weighty
		            GridBagConstraints.PAGE_START,  //where to anchor the component in the cell
		            GridBagConstraints.HORIZONTAL,  //how to fill extra space
		            new Insets(0, 0, 0, 0),         //insets for the cell
		            0, 1);                          //additional padding x,y
			
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					onViewChangeClick();
					new CategoryView(manager, topBar, currentFrame, currentFrame.getSize(), c);
				}
			});
			categoryGridPane.add(button, gbc);
		}
		
		return categoryGridPane;
	}

			// Puts the frame together, called in particular order and location, panels in panels in a frame //
	private void displayGUI() {
		currentFrame.getContentPane().setLayout(new BorderLayout(0, 0));
		currentFrame.getContentPane().add(topBar, BorderLayout.NORTH);
		currentFrame.setTitle("This is the Home view");
		currentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel mainPanel = new JPanel();
		currentFrame.getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new BorderLayout(0,0));
		
		JPanel topInsidePanel = createTitlePane();
		mainPanel.add(topInsidePanel, BorderLayout.NORTH);
		
		JPanel centerInsidePanel = createCategoriesGridPane();
		mainPanel.add(centerInsidePanel, BorderLayout.CENTER);								

		currentFrame.setVisible(true);
	}
}
