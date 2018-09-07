package main;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class Controller {

    @FXML
    private Text resultText ;
    @FXML
    private TextArea mainText;
    @FXML
    private CheckBox checkBox1;
    @FXML
    private CheckBox checkBox2;
    
    Toolkit tk;

    public void initialize() {
    	tk = new Toolkit();
    	checkBox2.setSelected(true);
        resultText.setVisible(false);
    }

	@FXML public void resetWindowAction() {
		mainText.setText("");
        resultText.setVisible(false);
    }

    
    /**
     * checkBox1 is "Show progress of uploads."
     *      By selecting this, it adds: "Still uploading: " or "finished: "
     * checkBox2 is "Include video names."
     *      By selecting this, it includes the titles on a newline before the link.
     */
	@FXML public void convertTextAction() {
        resultText.setVisible(true);
        mainText.setText( tk.convertText( mainText.getText(), checkBox1.isSelected(), checkBox2.isSelected() ) );
    }
	
    
}
