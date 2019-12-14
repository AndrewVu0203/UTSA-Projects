import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MinutesPanel extends JFrame{
  private JPanel panel;
  private JLabel messageLabel;
  private JTextField minuteTextField; 
  private JRadioButton daytimeButton; 
  private JRadioButton eveningButton; 
  private JRadioButton OffPeakButton; 
  private ButtonGroup radioButtonGroup; 
  private final int WINDOW_WIDTH = 400; 
  private final int WINDOW_HEIGHT = 200;
  
  public MinutesPanel() {
    super("Minutes Panel");
    setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    buildPanel();
    add(panel);   
    setVisible(true); 
  }
  
  private void buildPanel() {
    messageLabel = new JLabel("Enter length of your call"); minuteTextField = new JTextField(10);
    daytimeButton = new JRadioButton("Daytime 6:00 am to 5:59 pm"); 
    eveningButton = new JRadioButton("Evening 6:00 pm to 11:59 pm"); 
    OffPeakButton = new JRadioButton("Off-peak 12:00 am to 5:50 am");
    radioButtonGroup = new ButtonGroup(); radioButtonGroup.add(daytimeButton); radioButtonGroup.add(eveningButton); radioButtonGroup.add(OffPeakButton);
    RatePanel ratePanel = new RatePanel();
    daytimeButton.addActionListener(ratePanel); 
    eveningButton.addActionListener(ratePanel); 
    OffPeakButton.addActionListener(ratePanel);
    panel = new JPanel();
    panel.add(messageLabel); panel.add(minuteTextField); panel.add(daytimeButton);
    panel.add(eveningButton);
    panel.add(OffPeakButton); 
  }
  
  public class RatePanel implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      String input; 
      String convertTo = ""; 
      double result = 0.0;
      input = minuteTextField.getText();
      
      if (e.getSource() == daytimeButton) {
        convertTo = "Daytime.";
        result = Double.parseDouble(input) * 0.07; }
      else if (e.getSource() == eveningButton) {
        convertTo = "Evening.";
        result = Double.parseDouble(input) * 0.12; }
      else if (e.getSource() == OffPeakButton) {
        convertTo = "Off-peak.";
        result = Double.parseDouble(input) * 0.05; }
      JOptionPane.showMessageDialog(null, input +" minutes of phone call will cost about " + result + " in " + convertTo);
    } 
  }
}

