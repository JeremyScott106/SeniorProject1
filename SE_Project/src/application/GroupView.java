package application;
import Project.Group;
import Project.SystemManager;
import Project.category;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

@SuppressWarnings("serial")
public class GroupView extends JFrame {

	private JMenuBar topBar;
	private SystemManager manager;
	private JFrame currentFrame;
	private category currentCategory;
	private Group currentGroup;
	
	// Window builder only seems to know how to use the blank constructor -- Use this to develop code then transfer to buildGUI//
	public GroupView() {
	}
	
	
	@SuppressWarnings("exports")
	public GroupView(SystemManager sm,  JMenuBar jmb,  JFrame frame, Dimension dim, category c, Group g) {
		this.topBar = jmb;
		this.manager = sm;
		this.currentFrame = frame;
		this.currentFrame.setSize(dim);
		this.currentCategory = c;
		this.currentGroup = g;
		displayGUI();
	}
	
	// This will clear the current frame, allows for rebuilding the frame //
	private void onViewChangeClick() {
		currentFrame.getContentPane().removeAll();
		currentFrame.repaint();
	}
	
	private JPanel createTitlePane() {
		
		JPanel titlePanel = new JPanel();

		int gridx = 20;
		int padding = 10;
		
		titlePanel.setPreferredSize(new Dimension(0,80));
		titlePanel.setLayout(null);
		
		JLabel lblHome = new JLabel("Home");
		lblHome.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblHome.setForeground(Color.BLUE.darker());
		lblHome.setBounds(gridx, 10, lblHome.getPreferredSize().width + padding, 25);
		gridx += lblHome.getWidth() + padding;
		lblHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblHome.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
            	onViewChangeClick();
            	new Home(manager, topBar, currentFrame, currentFrame.getSize());
            }
        });
		titlePanel.add(lblHome);
		
		JLabel lblSpacer1 = new JLabel("//");
		lblSpacer1.setBounds(gridx, 10, 10, 25);
		gridx += lblSpacer1.getWidth() + padding;
		titlePanel.add(lblSpacer1);
		
		JLabel lblCurrentCategory = new JLabel(currentCategory.getName());
		lblCurrentCategory.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCurrentCategory.setForeground(Color.BLUE.darker());
		lblCurrentCategory.setBounds(gridx, 10, lblCurrentCategory.getPreferredSize().width + padding, 25);
		gridx += lblCurrentCategory.getWidth() + padding;
		lblCurrentCategory.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCurrentCategory.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
            	onViewChangeClick();
            	new CategoryView(manager, topBar, currentFrame, currentFrame.getSize(), currentCategory);
            }
        });
		titlePanel.add(lblCurrentCategory);
		
		JLabel lblSpacer2 = new JLabel("//");
		lblSpacer2.setBounds(gridx, 10, 10, 25);
		gridx += lblSpacer2.getWidth() + padding;
		titlePanel.add(lblSpacer2);
		
		JLabel lblCurrentGroup = new JLabel(currentGroup.getGroupName());
		lblCurrentGroup.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCurrentGroup.setBounds(gridx, 10, lblCurrentGroup.getPreferredSize().width + padding, 25);
		titlePanel.add(lblCurrentGroup);
		
		//	SECOND ROW OF LABLES //
		gridx = 20;
		
		if (manager.getCurrentUser() == null){

			JButton btnLogin = new JButton("Login");
			btnLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnLogin.setBounds(gridx, 45, btnLogin.getPreferredSize().width + padding, 25);
			gridx += btnLogin.getWidth() + padding;
			titlePanel.add(btnLogin);
			btnLogin.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
					new LoginPopUp(manager);
				}
			});

		

			
			JButton btnNewUser = new JButton("Register New Account");
			btnNewUser.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnNewUser.setBounds(gridx, 45, btnNewUser.getPreferredSize().width + padding, 25);
			gridx += btnNewUser.getWidth() + padding;
			titlePanel.add(btnNewUser);
			btnNewUser.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
					new CreateUserPopUp(manager);
				}
			});

		}
		
		else if (!currentGroup.isMemberInGroup(manager.getCurrentUser().getId())) {
			
			JLabel memberStatus = new JLabel("Only Members Can Post In Group");
			memberStatus.setFont(new Font("Tahoma", Font.BOLD, 15));
			memberStatus.setBounds(gridx, 45, memberStatus.getPreferredSize().width + padding + padding, 25);
			gridx += memberStatus.getWidth() + padding;
			titlePanel.add(memberStatus);
			
			JLabel joinGroup = new JLabel("Join This Group");
			joinGroup.setFont(new Font("Tahoma", Font.BOLD, 15));
			joinGroup.setForeground(Color.BLUE.darker());
			joinGroup.setBounds(gridx, 45, joinGroup.getPreferredSize().width + padding, 25);
			gridx += joinGroup.getWidth() + padding;
			joinGroup.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			joinGroup.addMouseListener(new MouseAdapter() {
			    @Override
			    public void mouseClicked(MouseEvent e) {
			    	boolean result = manager.joinGroup(manager.getCurrentUser(), currentGroup);
			    	if (result) {
			    		JOptionPane.showMessageDialog(null, "Successfully Joined Group");
			    	}
			    	else {
			    		JOptionPane.showMessageDialog(null, "Something Went Wrong");
			    	}
	            }
	        });
			titlePanel.add(joinGroup);
		}
		
		else {
			String mbmSince = "Member Since: " + manager.getMembership(currentGroup, manager.getCurrentUser()).getDate().toString();

			JLabel memberStatus = new JLabel(mbmSince);
			memberStatus.setFont(new Font("Tahoma", Font.BOLD, 15));
			memberStatus.setBounds(gridx, 45, memberStatus.getPreferredSize().width + padding + padding, 25);
			gridx += memberStatus.getWidth() + padding;
			titlePanel.add(memberStatus);
		}
		
		JButton btnRefreshPage = new JButton("Refresh");
		btnRefreshPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onViewChangeClick();
				new GroupView(manager, topBar, currentFrame, currentFrame.getSize(), currentCategory, currentGroup);
			}
		});
		btnRefreshPage.setBounds(currentFrame.getBounds().width - 125, 10, 100, 25);
			// FIXME: BUG -> Refresh button disappears if frame shrinks.
		titlePanel.add(btnRefreshPage);
		
		return titlePanel;
		
	}
	
	private void displayGUI() {
		currentFrame.setLayout(new BorderLayout(0, 0));
		currentFrame.add(topBar, BorderLayout.NORTH);
		currentFrame.setTitle("This is the listing of posts in group " + currentGroup.getGroupName());
		currentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel mainPanel = new JPanel();
		currentFrame.getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new BorderLayout(0,0));
		
		JPanel topInsidePanel = createTitlePane();
		mainPanel.add(topInsidePanel, BorderLayout.NORTH);
		
		currentFrame.setVisible(true);
	}
}
