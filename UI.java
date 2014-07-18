/* 
 * @author Jane Pham
 * 
 * This program creates a user interface that displays the preview images of four movie
 * posters (all obtained via Google Images). When hovered over an image, it displays the
 * movie's title and the image's URL. Each image acts as a button; when pressed,
 * a new window opens and displays the selected image as well as all of its available
 * metadata. When the secondary window (that of which contains the metadata) is closed,
 * the main window (the user interface) remains open, and the user may select any image
 * for as many times as desired until the user exits the main window. 
 * 
 * Written in Java SE 7 using Eclipse SDK
 * Library required: Metadata Extractor version 2.6.4
 * 		   Download: https://code.google.com/p/metadata-extractor/downloads/detail?name=metadata-extractor-2.6.4-src.jar
 * 		   		 	 https://code.google.com/p/metadata-extractor/downloads/detail?name=metadata-extractor-2.6.4.zip
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.drew.imaging.jpeg.JpegProcessingException;
import java.io.IOException;

@SuppressWarnings("serial")
public class UI extends JPanel {
	
	private JButton FD;
	private JButton JS;
	private JButton TG;
	private JButton GG;
	
	public static int MovieSelected = 0; // tracker that monitors which image has been selected

	/* User interface constructor */
	public UI() {
		setPreferredSize(new Dimension (600, 600));
		setLayout(null);
		
		FD = new JButton(new ImageIcon("findingdory.jpg"));
		JS = new JButton(new ImageIcon("22jumpstreet.jpg"));
		TG = new JButton(new ImageIcon("thegiver.jpg"));
		GG = new JButton(new ImageIcon("guardiansofthegalaxy.jpg"));

		/* Hover description */
		FD.setToolTipText("<html>Finding Dory<br>http://pley.us/media/poster/finding_dory_2015.jpg</html>");
		JS.setToolTipText("<html>22 Jump Street<br>http://upload.wikimedia.org/wikipedia/en/e/e7/22_Jump_Street_Poster.jpg</html>");
		TG.setToolTipText("<html>The Giver<br>http://upload.wikimedia.org/wikipedia/en/thumb/0/02/The_Giver_poster.jpg/640px-The_Giver_poster.jpg</html>");
		GG.setToolTipText("<html>Guardians of the Galaxy<br>http://upload.wikimedia.org/wikipedia/en/8/8f/GOTG-poster.jpg</html>");

		/* Response to button click */
		FD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				MovieSelected = 1; // indicate to tracker that "Finding Dory" has been selected
				JFrame NewWindow = new JFrame("Finding Dory"); // open new window
				try {
					NewWindow.getContentPane().add(new Details()); // initiate the Details constructor to add content to new window
				} catch (JpegProcessingException | IOException e) {
					e.printStackTrace();
				}
				NewWindow.pack(); // size the window
				NewWindow.setVisible(true); // show the window
			}
		});
		
		JS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				MovieSelected = 2; // indicate to tracker that "22 Jump Street" has been selected
				JFrame NewWindow = new JFrame("22 Jump Street"); // open new window
				try {
					NewWindow.getContentPane().add(new Details()); // initiate the Details constructor to add content to new window
				} catch (JpegProcessingException | IOException e) {
					e.printStackTrace();
				}
				NewWindow.pack(); // size the window
				NewWindow.setVisible(true); // show the window

			}
		});
		
		TG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				MovieSelected = 3; // indicate to tracker that "The Giver" has been selected
				JFrame NewWindow = new JFrame("The Giver"); // open new window
				try {
					NewWindow.getContentPane().add(new Details()); // initiate the Details constructor to add content to new window
				} catch (JpegProcessingException | IOException e) {
					e.printStackTrace();
				}
				NewWindow.pack(); // size the window
				NewWindow.setVisible(true); // show the window
			}
		});
		
		GG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				MovieSelected = 4; // indicate to tracker that "Guardians of the Galaxy" has been selected
				JFrame NewWindow = new JFrame("Guardians of the Galaxy"); // open new window
				try {
					NewWindow.getContentPane().add(new Details()); // initiate the Details constructor to add content to new window
				} catch (JpegProcessingException | IOException e) {
					e.printStackTrace();
				}
				NewWindow.pack(); // size the window
				NewWindow.setVisible(true); // show the window
			}
		});

		/* Add the displayed components (buttons/images) to the window */
		add(FD);
		add(JS);
		add(TG);
		add(GG);

		/* Positions of the buttons/images */
		FD.setBounds(0, 0, 300, 300);
		JS.setBounds(0, 300, 300, 300);
		TG.setBounds(300, 0, 300, 300);
		GG.setBounds(300, 300, 300, 300);
	}


	public static void main (String[] args) throws JpegProcessingException, IOException {
		JFrame NewUI = new JFrame ("Movie Posters"); // window title
		NewUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // stop program when window is closed
		NewUI.getContentPane().add(new UI()); // initiate UI constructor to add content to the window
		NewUI.pack(); // size the window
		NewUI.setVisible(true); // show the window
	}
}
