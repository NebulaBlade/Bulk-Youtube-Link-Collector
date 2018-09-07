package main;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * The application launches a simple conversion window, that allows you user to copy & paste
 * their YouTube upload results (from a finished youtube.com/upload page) into the window,
 * and convert it to easy-to-read text that they can copy & paste to bulk-share the 
 * YouTube video links and titles. 
 * 
 * @author AlexNavarro
 * @version 1.0.1
 * @since 2018-09-01
 */
public class Executive extends Application {
	
	public static void main(String args[]) { launch(args); }
	
	/**
	 * Standard JavaFX Application launch: Window layout is based off of a FXML and establishes the Application's root. 
	 */
	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("Main_Layout.fxml"));
        Scene scene = new Scene(root, 450, 300);
        
        Image app_icon = new Image(Executive.class.getResourceAsStream("leaf_icon.png"));
        
        attemptToSetAppleDockIcon(app_icon);
        
        stage.getIcons().add(app_icon);
        stage.setTitle("Alex's Youtube Link Converter");
        stage.setScene(scene);
        stage.show();
	}
	
	/**
	 * This bit of code is specifically for Apple. This is meant to try to set the dock icon, so it's not the default java icon.
	 * Has been experimental, and somewhat unsuccessful. Newer versions of Mac do not support this, but as this part of the code
	 * is not causing the program to crash I'm leaving it in. :)
	 * @param img
	 */
	@SuppressWarnings({"unchecked", "rawtypes"})
	private void attemptToSetAppleDockIcon(Image img) {
		try {
			Class util = Class.forName("com.apple.eawt.Application");
			Method getApplication = util.getMethod("getApplication", new Class[0]);
		    Object application = getApplication.invoke(util);
		    Class params[] = new Class[1];
		    params[0] = Image.class;
			Method setDockIconImage = util.getMethod("setDockIconImage", params);
		    setDockIconImage.invoke(application, img);
		} catch (ClassNotFoundException e) {
		    // log exception
		} catch (NoSuchMethodException e) {
		    // log exception
		} catch (InvocationTargetException e) {
		    // log exception
		} catch (IllegalAccessException e) {
		    // log exception
		}
	}

	
	
}
