a8main.java
	call MinutesPanel() constructor

MinutesPanel.java 
	extends JFrame
	MinutesPanel() to setup panel to frame
	buildPanel() to build radio buttons in ButtonGroup(, to addActionListener(), and to add all of it to JPanel().

RatePanel.java
	implements ActionListener(): to setup actionPerformed
	It's in the same file as MinutesPanel cause MinutesPanel already extends JFrame and could not extends another one. Can you give me your advice ? 