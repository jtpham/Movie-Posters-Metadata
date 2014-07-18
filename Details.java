import java.awt.*;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.swing.*;

import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

@SuppressWarnings("serial")
public class Details extends JPanel {

	private JLabel Image;
	private JTextArea Details;
	
	public Details() throws JpegProcessingException, IOException {
		setPreferredSize(new Dimension (300, 600));
		setLayout(null);

		/* Area in which the metadata will be listed */
		Details = new JTextArea(); // initiate
		Details.setFont(new Font("Courier New", Font.PLAIN, 10)); // format font
		Details.setWrapStyleWord(true); // wrap whole words if there is not enough room at the end of the line
		Details.setLineWrap(true); // wrap lines
		
		/* Retrieve metadata from image URLs */
		InputStream is1 = new URL("http://pley.us/media/poster/finding_dory_2015.jpg").openStream();
		BufferedInputStream bis1 = new BufferedInputStream(is1);
		Metadata FDmeta = JpegMetadataReader.readMetadata(bis1);

		InputStream is2 = new URL("http://upload.wikimedia.org/wikipedia/en/e/e7/22_Jump_Street_Poster.jpg").openStream();
		BufferedInputStream bis2 = new BufferedInputStream(is2);
		Metadata JSmeta = JpegMetadataReader.readMetadata(bis2);

		InputStream is3 = new URL("http://upload.wikimedia.org/wikipedia/en/thumb/0/02/The_Giver_poster.jpg/640px-The_Giver_poster.jpg").openStream();
		BufferedInputStream bis3 = new BufferedInputStream(is3);
		Metadata TGmeta = JpegMetadataReader.readMetadata(bis3);

		InputStream is4 = new URL("http://upload.wikimedia.org/wikipedia/en/8/8f/GOTG-poster.jpg").openStream();
		BufferedInputStream bis4 = new BufferedInputStream(is4);
		Metadata GGmeta = JpegMetadataReader.readMetadata(bis4);

		/* Display the image according to the tracker and retrieve its metadata */
		if (UI.MovieSelected == 1) { // if "Finding Dory" was selected
			Image = new JLabel(new ImageIcon("findingdory.jpg")); // display image
			getMetadata(FDmeta); // call upon method to list out metadata
		} else if (UI.MovieSelected == 2) { // if "22 Jump Street" was selected
			Image = new JLabel(new ImageIcon("22jumpstreet.jpg")); // display image
			getMetadata(JSmeta); // call upon method to list out metadata
		} else if (UI.MovieSelected == 3) { // if "The Giver" was selected
			Image = new JLabel(new ImageIcon("thegiver.jpg")); // display image
			getMetadata(TGmeta); // call upon method to list out metadata
		} else if (UI.MovieSelected == 4) { // if "Guardians of the Galaxy" was selected
			Image = new JLabel(new ImageIcon("guardiansofthegalaxy.jpg")); // display image
			getMetadata(GGmeta); // call upon method to list out metadata
		}
		
		/* Add the displayed components (image/metadata) to the window */
		add(Image);
		add(Details);

		/* Positions of the images */
		Image.setBounds(0, 0, 300, 300);
		Details.setBounds(0, 300, 300, 300);
	    
	}

	/* Method called upon to list all available metadata of the image */
	public void getMetadata(Metadata metadata) {
		for (Directory directory : metadata.getDirectories()) { // for each directory of the image's metadata
			for (Tag tag : directory.getTags()) { // for each tag of each directory
				Details.append(tag.toString() + "\n"); // add each tag to the text area and add a new line for separation
			}
		}
	}
}
