
package edu.saintjoe.cs.brianc.examtwo;


import com.google.devtools.simple.runtime.components.Component;

import com.google.devtools.simple.runtime.components.HandlesEventDispatching;
import com.google.devtools.simple.runtime.components.android.Form;

import com.google.devtools.simple.runtime.components.android.Button;
import com.google.devtools.simple.runtime.components.android.Label;
import com.google.devtools.simple.runtime.components.android.HorizontalArrangement;
import com.google.devtools.simple.runtime.components.android.TextBox;
import com.google.devtools.simple.runtime.components.android.AccelerometerSensor;

import com.google.devtools.simple.runtime.events.EventDispatcher;
//imports all of the components that will or may be used in the applicaation
public class ExamActivity extends Form implements HandlesEventDispatching {

	private HorizontalArrangement line1, line2, line3, line4;
	//these will be the lines that contain our components
	private Button DoubleButton;
	private Label resultLabel;
	private Label promptLabel;
	private TextBox inputBox;
	int temp;
	

 void $define() {
	 //this is essentially the start of the actual code in the app, it takes the place of main
 	
     this.BackgroundColor(COLOR_WHITE);
     //changes the backgroung color of the app to white
     
     line1 = new HorizontalArrangement(this);
     line2 = new HorizontalArrangement(this);
     line3 = new HorizontalArrangement(this);
     line4 = new HorizontalArrangement(this);
     //creates the lines that contain the components

     
     promptLabel = new Label(line1, "Enter a number:");
     //makes a label and puts text in it saying enter a number
     inputBox = new TextBox(line1);
     inputBox.NumbersOnly(true);
     //creates a new textbox and makes sure that only numbers may be entered into it. 
   
     DoubleButton = new Button(line2,"Double It:"); 
     //makes a new button called doublebutton and sets the text of the button ton double it.
     
     resultLabel = new Label(line3,"");
     
 
     EventDispatcher.registerEventForDelegation(this, "ButtonClick", "Click");
    
 } 
 @Override
 public boolean dispatchEvent(Component component, String id, String eventName,
         Object[] args) {
 	
	    if (component.equals(DoubleButton) && eventName.equals("Click")){
	    	temp = Integer.parseInt(inputBox.Text());
	    	temp *= 2;
	    	resultLabel.Text(String.valueOf(temp));
	        return true;
	     } 
	    //essentially this means when the is clicked on, whatever number is in the InputBox is multiplied by two
	    
	    
    return true;
	} 
} 
