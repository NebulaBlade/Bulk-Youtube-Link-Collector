package main;

public class Toolkit {

	
	public static final String WILL_READY_AT = "Your video will be ready at ";
	public static final String NOW_READY_AT = "Your video is now ready at ";
	public static final String RETURN_EDITING = "Return to editing";
	public static final String PROCESSING = "PROCESSING";
	public static final String REMAINING = "remaining.";
	
	public Toolkit() {
		
	}
	
	/**
	* Returns a String that uses hardcoded patterns to "sift out" Youtube Links and Youtube Titles.
	*
	* @return A string of easy-to-read formatted text that the user can then access and share easily.
	*/
	public String convertText(String s, Boolean show_progress, Boolean show_names) {
		String[] lines = s.split("\n");
		String line = "";
		String deliver = "";
		for (int i=0; i<lines.length; i++) { line = lines[i];
			
			// ******************************************
			// For the videos still processing...
			// ******************************************
			if (show_names && line.contains(PROCESSING) && line.contains(REMAINING)){ // Returns the title
				deliver = deliver + line.substring(line.indexOf("remaining.")+10) + ":\n";
			} if (line.contains(WILL_READY_AT) ) { // Returns the link
	            if (show_progress) { deliver = deliver + "Will be ready at: "; }
	            deliver = deliver + line.substring( line.indexOf("ready at")+9, line.indexOf("once") ) + "\n\n";
			}
			

			// ******************************************
			// For the videos finished processing...
			// ******************************************
			if (show_names && line.contains(RETURN_EDITING)){ // Returns the title
	            //Redundancy check, to make sure we actually HAVE a title (not null)
	            if (line.length() != RETURN_EDITING.length()) { deliver = deliver + line.substring(17) + ":\n"; }
			}
			
			if (line.contains(NOW_READY_AT)) { // Returns the link
	            if (show_progress) { deliver = deliver + "Finished uploading to: "; }
	            deliver = deliver + line.substring(27) + "\n\n";
			}
			
		}
		return deliver;
	}
	
}
