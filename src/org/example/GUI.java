package org.example;
import javax.swing.*;
import java.io.ByteArrayOutputStream;
import java.util.Scanner;



public class GUI {
    public static void main(String[] args) {


        // Creates the window
        JFrame frame = new JFrame("COSC 208 Project");

        // Creates clickable buttons
        JButton buttonA = new JButton("Scenario A");
        JButton buttonB = new JButton("Scenario B");

        // Panel holds the buttons
        JPanel panel = new JPanel();

        // Adds the buttons to the panel
        panel.add(buttonA);
        panel.add(buttonB);

        // Puts the panel in the window
        frame.add(panel);

        // Sets the size of the window
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ends program when window is closed

        // Makes the window visible
        frame.setVisible(true);

        // Adds a message after either button is clicked
        // Also opens up a new frame and panel for either scenario
        buttonA.addActionListener(e -> { // Code that responds to an action for button A
            JOptionPane.showMessageDialog(frame, "Scenario A selected");

            JFrame frameA = new JFrame("Scenario A"); // Creates new window for scenario
            JLabel titleA = new JLabel("Welcome to Scenario A"); // Creates title for the panel
            JPanel panelA = new JPanel(); // Creates panel for scenario

            panelA.add(titleA); // adds title to the panel

            // Labels for budget, schedule, transportation, etc
            JLabel budgetLabel = new JLabel("Budget:");
            JLabel departureLabel = new JLabel("Departure Time (HH:mm):");
            JLabel deadlineLabel = new JLabel("Arrival Deadline (HH:mm):");
            JLabel weatherLabel = new JLabel("Weather:");

            JLabel busFareLabel = new JLabel("Bus Fare:");
            JLabel busWalkLabel = new JLabel("Bus Walking Time (minutes):");
            JLabel busTimeLabel = new JLabel("Bus Travel Time (minutes):");
            JLabel busStatusLabel = new JLabel("Bus Operating:");

            JLabel trainFareLabel = new JLabel("Train Fare:");
            JLabel trainWalkLabel = new JLabel("Train Walking Time (minutes):");
            JLabel trainTimeLabel = new JLabel("Train Travel Time (minutes):");

            JLabel trainStatusLabel = new JLabel("Train Operating:");
            JLabel backupFareLabel = new JLabel("Backup Ride Fare:");
            JLabel backupWalkLabel = new JLabel("Backup Ride Walking Time:");
            JLabel backupTimeLabel = new JLabel("Backup Ride Travel Time:");
            JLabel backupStatusLabel = new JLabel("Backup Ride Available:");
            JLabel farePriorityLabel = new JLabel("Fare Priority:");
            JLabel walkPriorityLabel = new JLabel("Walking Priority:");
            JLabel travelPriorityLabel = new JLabel("Travel Priority:");
            JLabel weatherPriorityLabel = new JLabel("Weather Priority:");

            // Text fields/boxes where the user enters input, allows user to type
            JTextField budgetField = new JTextField(10);
            JTextField departureField = new JTextField(10);
            JTextField deadlineField = new JTextField(10);

            JTextField busFareField = new JTextField(10);
            JTextField busWalkField = new JTextField(10);
            JTextField busTimeField = new JTextField(10);

            JTextField trainFareField = new JTextField(10);
            JTextField trainWalkField = new JTextField(10);
            JTextField trainTimeField = new JTextField(10);

            JTextField backupFareField = new JTextField(10);
            JTextField backupWalkField = new JTextField(10);
            JTextField backupTimeField = new JTextField(10);

            // creates the choices for the dropdown boxes
            String[] weatherOptions = {"Sunny", "Intense Weather"};
            String[] busOptions = {"Yes", "No"};
            String[] priorityOptions = {"1", "2", "3", "4"};

            JComboBox<String> weatherBox = new JComboBox<>(weatherOptions);
            JComboBox<String> busStatusBox = new JComboBox<>(busOptions);
            JComboBox<String> trainStatusBox = new JComboBox<>(busOptions);
            JComboBox<String> backupStatusBox = new JComboBox<>(busOptions);
            JComboBox<String> farePriorityBox = new JComboBox<>(priorityOptions);
            JComboBox<String> walkPriorityBox = new JComboBox<>(priorityOptions);
            JComboBox<String> travelPriorityBox = new JComboBox<>(priorityOptions);
            JComboBox<String> weatherPriorityBox = new JComboBox<>(priorityOptions);


            // continue button
            JButton continueButtonA = new JButton("Continue");

            // adds components to panel
            panelA.add(budgetLabel);
            panelA.add(budgetField);

            panelA.add(departureLabel);
            panelA.add(departureField);

            panelA.add(deadlineLabel);
            panelA.add(deadlineField);

            panelA.add(weatherLabel);
            panelA.add(weatherBox);

            // Adds bus section
            panelA.add(busFareLabel);
            panelA.add(busFareField);
            panelA.add(busWalkLabel);
            panelA.add(busWalkField);
            panelA.add(busTimeLabel);
            panelA.add(busTimeField);
            panelA.add(busStatusLabel);
            panelA.add(busStatusBox);

            // Adds train section
            panelA.add(trainFareLabel);
            panelA.add(trainFareField);
            panelA.add(trainWalkLabel);
            panelA.add(trainWalkField);
            panelA.add(trainTimeLabel);
            panelA.add(trainTimeField);
            panelA.add(trainStatusLabel);
            panelA.add(trainStatusBox);

            // Adds backup ride section
            panelA.add(backupFareLabel);
            panelA.add(backupFareField);
            panelA.add(backupWalkLabel);
            panelA.add(backupWalkField);
            panelA.add(backupTimeLabel);
            panelA.add(backupTimeField);
            panelA.add(backupStatusLabel);
            panelA.add(backupStatusBox);

            // Adds the priority choices
            panelA.add(farePriorityLabel);
            panelA.add(farePriorityBox);
            panelA.add(walkPriorityLabel);
            panelA.add(walkPriorityBox);
            panelA.add(travelPriorityLabel);
            panelA.add(travelPriorityBox);
            panelA.add(weatherPriorityLabel);
            panelA.add(weatherPriorityBox);

            panelA.add(continueButtonA);

            frameA.add(panelA); // adds panel to the window

            JButton backButtonA = new JButton("Back"); // Creates a back button
            panelA.add(backButtonA);

            backButtonA.addActionListener(g -> { // when back button is pressed it closes the scenario window
                frameA.dispose();
            });

            // Runs scenario A after the continue button is clicked
            continueButtonA.addActionListener(g -> {

                // gets info from user inputs
                String budget = budgetField.getText();
                String departure = departureField.getText();
                String deadline = deadlineField.getText();
                String weather = (String) weatherBox.getSelectedItem();

                String busFare = busFareField.getText();
                String busWalk = busWalkField.getText();
                String busTime = busTimeField.getText();
                String busStatus = (String) busStatusBox.getSelectedItem();

                String trainFare = trainFareField.getText();
                String trainWalk = trainWalkField.getText();
                String trainTime = trainTimeField.getText();
                String trainStatus = (String) trainStatusBox.getSelectedItem();

                String backupFare = backupFareField.getText();
                String backupWalk = backupWalkField.getText();
                String backupTime = backupTimeField.getText();
                String backupStatus = (String) backupStatusBox.getSelectedItem();

                // Converts the priority dropdown choices into numbers
                int farePriority = Integer.parseInt(
                        (String) farePriorityBox.getSelectedItem());

                int walkPriority = Integer.parseInt(
                        (String) walkPriorityBox.getSelectedItem());

                int travelPriority = Integer.parseInt(
                        (String) travelPriorityBox.getSelectedItem());

                int weatherPriority = Integer.parseInt(
                        (String) weatherPriorityBox.getSelectedItem());

                // makes sure each priority number is used once
                if (farePriority == walkPriority ||
                        farePriority == travelPriority ||
                        farePriority == weatherPriority ||
                        walkPriority == travelPriority ||
                        walkPriority == weatherPriority ||
                        travelPriority == weatherPriority) {

                    JOptionPane.showMessageDialog(frameA,
                            "Please use each priority number only once.");

                    return;
                }

                // creates an input to store transportation info
                Bus_Train_Input input = new Bus_Train_Input();

                try {
                    // Converts the budget and times into values the logic classes can use
                    double budgetAmount = Double.parseDouble(budget);

                    java.time.LocalTime departureTime =
                            java.time.LocalTime.parse(departure);

                    java.time.LocalTime deadlineTime =
                            java.time.LocalTime.parse(deadline);

                    // sends travel information to input class
                    input.setGUIInputs(budgetAmount, departureTime,
                            deadlineTime, weather);

                    // creates a bus object and adds it to the bus list
                    double busFareAmount = Double.parseDouble(busFare);
                    double busWalkAmount = Double.parseDouble(busWalk);
                    double busTravelAmount = Double.parseDouble(busTime);

                    boolean busOperating = busStatus.equals("Yes");

                    Transportation bus = new Transportation(
                            "Bus 1",
                            busFareAmount,
                            busWalkAmount,
                            busTravelAmount,
                            weather,
                            busOperating,
                            deadlineTime
                    );

                    input.getBuses().add(bus);

                    // creates train object and adds it to train list
                    double trainFareAmount = Double.parseDouble(trainFare);
                    double trainWalkAmount = Double.parseDouble(trainWalk);
                    double trainTravelAmount = Double.parseDouble(trainTime);

                    boolean trainOperating = trainStatus.equals("Yes");

                    Transportation train = new Transportation(
                            "Train 1",
                            trainFareAmount,
                            trainWalkAmount,
                            trainTravelAmount,
                            weather,
                            trainOperating,
                            deadlineTime
                    );

                    input.getTrains().add(train);

                    // creates backup ride object and adds it to backup ride list
                    double backupFareAmount = Double.parseDouble(backupFare);
                    double backupWalkAmount = Double.parseDouble(backupWalk);
                    double backupTravelAmount = Double.parseDouble(backupTime);

                    boolean backupOperating = backupStatus.equals("Yes");

                    Transportation backupRide = new Transportation(
                            "Backup Ride 1",
                            backupFareAmount,
                            backupWalkAmount,
                            backupTravelAmount,
                            weather,
                            backupOperating,
                            deadlineTime
                    );

                    input.getBackupRides().add(backupRide);

                    // Checks which transportation options meet the eligibility rules
                    Bus_Train_Logic logic = new Bus_Train_Logic(input);

                    logic.evaluateLogic();

                    // Creates the recommendation algorithm after eligibility is checked
                    Recommendation_Algorithm recommendation =
                            new Recommendation_Algorithm(input, logic);

                    // collects the printed results so they can appear in the GUI
                    ByteArrayOutputStream output = new ByteArrayOutputStream();
                    java.io.PrintStream original = System.out;

                    try {
                        System.setOut(new java.io.PrintStream(output));

                        // prints why each transportation option is eligible or not
                        logic.explainEligibility();

                        // ranks the transportation options
                        recommendation.setGUIPriorities(
                                farePriority,
                                walkPriority,
                                travelPriority,
                                weatherPriority
                        );

                        recommendation.Determine_Priority();

                    } finally {
                        System.setOut(original);
                    }

                    // opens a window to show the transportation results
                    JFrame resultFrame = new JFrame("Transportation Results");

                    JTextArea resultArea = new JTextArea(output.toString()); // JTextArea displays multiple lines, shows longer results
                    resultArea.setEditable(false);

                    JButton decisionTreeButton = new JButton("Decision Tree");

                    JButton knowledgeGraphButton = new JButton("Knowledge Graph");

                    JButton truthTableButton = new JButton("Truth Table");

                    JButton expressionTreeButton = new JButton("Expression Tree");

                    // shows decision tree in another window
                    decisionTreeButton.addActionListener(e2 -> {

                        ByteArrayOutputStream treeOutput = new ByteArrayOutputStream();
                        java.io.PrintStream originalOutput = System.out;

                        try {
                            System.setOut(new java.io.PrintStream(treeOutput));

                            logic.printDecisionTree(
                                    recommendation.getBestVehicleOverall()
                            );

                        } finally {
                            System.setOut(originalOutput);
                        }

                        JFrame treeFrame = new JFrame("Transportation Decision Tree");

                        JTextArea treeArea = new JTextArea(treeOutput.toString());
                        treeArea.setEditable(false);

                        JScrollPane treeScroll = new JScrollPane(treeArea);

                        treeFrame.add(treeScroll);
                        treeFrame.setSize(650, 450);
                        treeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        treeFrame.setVisible(true);
                    });

                    // shows the knowledge graph in another window
                    knowledgeGraphButton.addActionListener(e2 -> {

                        ByteArrayOutputStream graphOutput = new ByteArrayOutputStream();
                        java.io.PrintStream originalOutput = System.out;

                        try {
                            System.setOut(new java.io.PrintStream(graphOutput));

                            logic.printKnowledgeGraph(
                                    recommendation.getBestVehicleOverall()
                            );

                        } finally {
                            System.setOut(originalOutput);
                        }

                        JFrame graphFrame = new JFrame("Transportation Knowledge Graph");

                        JTextArea graphArea = new JTextArea(graphOutput.toString());
                        graphArea.setEditable(false);
                        graphArea.setFont(new java.awt.Font("Monospaced", java.awt.Font.PLAIN, 12));

                        JScrollPane graphScroll = new JScrollPane(graphArea);

                        graphFrame.add(graphScroll);
                        graphFrame.setSize(650, 450);
                        graphFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        graphFrame.setVisible(true);
                    });

                    // shows the transportation truth tables in another window
                    truthTableButton.addActionListener(e2 -> {

                        ByteArrayOutputStream truthOutput = new ByteArrayOutputStream();
                        java.io.PrintStream truthOriginal = System.out;

                        try {
                            System.setOut(new java.io.PrintStream(truthOutput));

                            TruthTable.print("BusEligible", logic.getBusRule());
                            TruthTable.print("TrainEligible", logic.getTrainRule());
                            TruthTable.print("BackupEligible", logic.getBackupRule());

                        } finally {
                            System.setOut(truthOriginal);
                        }

                        JFrame truthFrame = new JFrame("Transportation Truth Tables");

                        JTextArea truthArea = new JTextArea(truthOutput.toString());
                        truthArea.setEditable(false);
                        truthArea.setFont(new java.awt.Font("Monospaced", java.awt.Font.PLAIN, 12));

                        JScrollPane scroll = new JScrollPane(truthArea);

                        truthFrame.add(scroll);
                        truthFrame.setSize(650, 450);
                        truthFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        truthFrame.setVisible(true);
                    });

                    // shows the expression trees and their traversals
                    expressionTreeButton.addActionListener(e2 -> {

                        LogicNode busRule = logic.getBusRule();
                        LogicNode trainRule = logic.getTrainRule();
                        LogicNode backupRule = logic.getBackupRule();

                        StringBuilder treeOutput = new StringBuilder();

                        treeOutput.append("BUS EXPRESSION TREE\n");
                        treeOutput.append(busRule + "\n");
                        treeOutput.append("Preorder: " + busRule.preorder() + "\n");
                        treeOutput.append("Inorder: " + busRule.inorder() + "\n");
                        treeOutput.append("Postorder: " + busRule.postorder() + "\n\n");

                        treeOutput.append("TRAIN EXPRESSION TREE\n");
                        treeOutput.append(trainRule + "\n");
                        treeOutput.append("Preorder: " + trainRule.preorder() + "\n");
                        treeOutput.append("Inorder: " + trainRule.inorder() + "\n");
                        treeOutput.append("Postorder: " + trainRule.postorder() + "\n\n");

                        treeOutput.append("BACKUP RIDE EXPRESSION TREE\n");
                        treeOutput.append(backupRule + "\n");
                        treeOutput.append("Preorder: " + backupRule.preorder() + "\n");
                        treeOutput.append("Inorder: " + backupRule.inorder() + "\n");
                        treeOutput.append("Postorder: " + backupRule.postorder());

                        JFrame treeFrame = new JFrame("Transportation Expression Trees");

                        JTextArea treeArea = new JTextArea(treeOutput.toString());
                        treeArea.setEditable(false);
                        treeArea.setFont(new java.awt.Font("Monospaced", java.awt.Font.PLAIN, 12));

                        JScrollPane scroll = new JScrollPane(treeArea);

                        treeFrame.add(scroll);
                        treeFrame.setSize(650, 450);
                        treeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        treeFrame.setVisible(true);
                    });

                    // Adds scrolling and places the result buttons below output
                    JScrollPane scroll = new JScrollPane(resultArea);

                    JPanel resultPanel = new JPanel(new java.awt.BorderLayout());

                    resultPanel.add(scroll, java.awt.BorderLayout.CENTER);
                    JPanel buttonPanel = new JPanel();

                    buttonPanel.add(decisionTreeButton);
                    buttonPanel.add(knowledgeGraphButton);
                    buttonPanel.add(truthTableButton);
                    buttonPanel.add(expressionTreeButton);

                    resultPanel.add(buttonPanel, java.awt.BorderLayout.SOUTH);
                    resultFrame.add(resultPanel);

                    resultFrame.setSize(650, 450);
                    resultFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    resultFrame.setVisible(true);



                    // shows message if user enters invalid numbers or times
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(frameA,
                            "Please enter valid numbers and times (HH:mm).");
                }

            });

            frameA.setSize(650, 600);
            frameA.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frameA.setVisible(true);
        });

        // opens scenario B for the course registration system
        buttonB.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Scenario B selected");

            JFrame frameB = new JFrame("Scenario B");
            JLabel titleB = new JLabel("Welcome to Scenario B");
            JPanel panelB = new JPanel();

            panelB.add(titleB);

            frameB.add(panelB);

            JButton backButtonB = new JButton("Back");
            panelB.add(backButtonB);

            backButtonB.addActionListener(g -> {
                frameB.dispose();
            });

            frameB.setSize(600, 400);
            frameB.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frameB.setVisible(true);

            // questions to check if a student can register
            String[] questions = {
                    "Prerequisite completed?",
                    "Seat available?",
                    "Active Registration hold?",
                    "Registration deadline still open?"
            };

            // stores the answers and tracks which question comes next
            boolean[] answers = new boolean[4];
            int[] question_No = {0};

            // creates the questions and buttons for the scenario
            JLabel question1 = new JLabel(questions[0]);
            JButton yesButton = new JButton("Yes");
            JButton noButton = new JButton("No");
            JLabel allowedLabel = new JLabel("");
            JButton truthButton = new JButton("Truth Table");
            JButton treeButton = new JButton("Expression Tree");
            JButton graphButton = new JButton("Knowledge Graph");
            JButton checklistButton = new JButton("Verification Checklist");
            JButton verifyButton = new JButton("Verify Truth Table");


            panelB.add(question1);
            panelB.add(yesButton);
            panelB.add(noButton);
            panelB.add(allowedLabel);
            panelB.add(truthButton);
            panelB.add(treeButton);
            panelB.add(graphButton);
            panelB.add(checklistButton);
            panelB.add(verifyButton);

            // opens a window for the truth table
            truthButton.addActionListener(e3 -> {
                java.io.ByteArrayOutputStream output = new ByteArrayOutputStream();
                java.io.PrintStream original = System.out;

                try {
                    System.setOut(new java.io.PrintStream(output));
                    showTruthTable(false);
                }
                finally {
                    System.setOut(original);
                }

                JFrame truthFrame = new JFrame("Truth Table");

                JTextArea truthArea = new JTextArea(output.toString());
                truthArea.setEditable(false);

                JScrollPane scroll = new JScrollPane(truthArea);

                truthFrame.add(scroll);
                truthFrame.setSize(600,400);
                truthFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                truthFrame.setVisible(true);
            });

            // opens a window showing expression tree
            treeButton.addActionListener(e3 -> {

                java.io.ByteArrayOutputStream output = new ByteArrayOutputStream();
                java.io.PrintStream original = System.out;

                try {
                    System.setOut(new java.io.PrintStream(output));
                    showExpressionTree();
                }
                finally {
                    System.setOut(original);
                }

                JFrame treeFrame = new JFrame("Expression Tree");

                JTextArea treeArea = new JTextArea(output.toString());
                treeArea.setEditable(false);
                treeArea.setFont(new java.awt.Font("Monospaced", java.awt.Font.PLAIN, 12));

                JScrollPane scroll = new JScrollPane(treeArea);

                treeFrame.add(scroll);
                treeFrame.setSize(600,400);
                treeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                treeFrame.setVisible(true);



            });

            // opens a window showing the registration knowledge graph
            graphButton.addActionListener(e3 -> {
                java.io.ByteArrayOutputStream output = new ByteArrayOutputStream();
                java.io.PrintStream original = System.out;

                try {
                    System.setOut(new java.io.PrintStream(output));
                    showKnowledgeGraph();
                }
                finally {
                    System.setOut(original);
                }

                JFrame graphFrame = new JFrame("Knowledge Graph");

                JTextArea graphArea = new JTextArea(output.toString());
                graphArea.setEditable(false);

                JScrollPane scroll = new JScrollPane(graphArea);

                graphFrame.add(scroll);
                graphFrame.setSize(600,400);
                graphFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                graphFrame.setVisible(true);
            });

            // opens checklist for verifying registration requirements
            checklistButton.addActionListener(e3 -> {
                java.io.ByteArrayOutputStream output = new ByteArrayOutputStream();
                java.io.PrintStream original = System.out;

                try {
                    System.setOut(new java.io.PrintStream(output));
                    showCheckList();
                }
                finally {
                    System.setOut(original);
                }


                JFrame checklistFrame = new JFrame("Verification Checklist");

                JTextArea checklistArea = new JTextArea(output.toString());
                checklistArea.setEditable(false);

                JScrollPane scroll = new JScrollPane(checklistArea);

                checklistFrame.add(scroll);
                checklistFrame.setSize(600,400);
                checklistFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                checklistFrame.setVisible(true);
            });

            // checks truth table matches registration rule
            verifyButton.addActionListener(e3 -> {
                java.io.ByteArrayOutputStream output = new ByteArrayOutputStream();
                java.io.PrintStream original = System.out;

                try {
                    System.setOut(new java.io.PrintStream(output));
                    verifyTruthTable();
                }
                finally {
                    System.setOut(original);
                }

                JFrame verifyFrame = new JFrame("Truth Table Verification");

                JTextArea verifyArea = new JTextArea(output.toString());
                verifyArea.setEditable(false);

                JScrollPane scroll = new JScrollPane(verifyArea);

                verifyFrame.add(scroll);
                verifyFrame.setSize(600,400);
                verifyFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                verifyFrame.setVisible(true);
            });

            // adds a yes button for questions
            yesButton.addActionListener(e2 -> {

                titleB.setVisible(false);
                answers[question_No[0]] = true;
                question_No[0]++;

                if (question_No[0] < questions.length) {
                    question1.setText(questions[question_No[0]]);
                } else {
                    boolean allowed = GUI.eligible(answers[0], answers[1], answers[2], answers[3]);

                    if (allowed == true) {
                        allowedLabel.setText("Eligible to register");
                    } else {
                        allowedLabel.setText("Registration blocked");
                    }

                    showRegistrationResults(answers);
                    yesButton.setEnabled(false);
                    noButton.setEnabled(false);

                }

            });
            // adds a no button for questions
            noButton.addActionListener(e2 -> {
                answers[question_No[0]] = false;
                question_No[0]++;

                if (question_No[0] < questions.length) {
                    question1.setText(questions[question_No[0]]);
                } else {
                    boolean allowed = GUI.eligible(answers[0], answers[1], answers[2], answers[3]);

                    if (allowed) {
                       allowedLabel.setText("Eligible to register");
                    } else {
                        allowedLabel.setText("Registration blocked");
                    }

                    showRegistrationResults(answers);
                    yesButton.setEnabled(false);
                    noButton.setEnabled(false);

                }

            });




        });


    }

    // Scenario B methods
    private static boolean eligible(boolean p, boolean s, boolean h, boolean d) {
        return ((p && s)) && !h && d;
    }
    private static boolean equivalent(boolean p, boolean s, boolean h, boolean d) {
        return !(!p || !s || h || !d);
    }
    private static char truth(boolean value) {
        return value ? 'T' : 'F';
    }
    private static final String[] QUESTIONS = {
            "Prerequisite completed?",
            "Seat available?",
            "Active registration hold?",
            "Registration deadline still open?"
    };

    private static final String[] CHECKS = {
            "Prerequisite completed",
            "Seat available",
            "No active hold",
            "Deadline open"
    };

    private static final String[] ACTIONS = {
            "Confirm prerequisite credit or ask your advisor about an override.",
            "Check for a waitlist or another section.",
            "Review the hold in your student portal and contact the office listed.",
            "Ask the registrar about late registration."
    };
    private static Boolean askYesNo(Scanner input, String question) {
        while (true) {
            System.out.print(question + " (yes/no): ");

            if (!input.hasNextLine()) return null;

            String answer = input.nextLine().trim();

            if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y"))
                return true;

            if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n"))
                return false;

            System.out.println("Please enter yes or no.");
        }
    }

    private static boolean checkRegistration(Scanner input) {

        boolean[] answers = new boolean[QUESTIONS.length];

        for (int i = 0; i < QUESTIONS.length; i++) {

            Boolean answer = askYesNo(input, QUESTIONS[i]);

            if (answer == null) {
                System.out.println("\nCheck ended before all answers were provided.");
                return false;
            }

            answers[i] = answer;
        }

        boolean allowed = eligible(answers[0], answers[1], answers[2], answers[3]);

        boolean[] passed = {answers[0], answers[1], !answers[2], answers[3]};

        System.out.println(allowed ? "\nResult: Eligible under the sample rule."
                : "\nResult: Registration blocked under the sample rule.");

        System.out.println("\nExplanation");

        for (int i = 0; i < CHECKS.length; i++) {
            System.out.println((passed[i] ? "PASS - " : "FAIL - ") + CHECKS[i]);
        }

        System.out.println("\nDecision path");

        String nextAction = "Verify your details and register in the student portal.";

        for (int i = 0; i < CHECKS.length; i++) {

            System.out.printf("%d. %s -> %s%n",
                    i + 1, CHECKS[i], passed[i] ? "Pass" : "Fail");

            if (!passed[i]) {
                nextAction = ACTIONS[i];
                break;
            }
        }

        System.out.println(allowed ? "Outcome -> Eligible" : "Outcome -> Blocked");

        System.out.println("Next step: " + nextAction);

        showCheckList();

        return true;
    }


    private static void showTruthTable(boolean testOnly) {
        if (!testOnly) {
            System.out.println("P = prerequisite completed, S = seat available");
            System.out.println("H = active registration hold, D = registration deadline open");
            System.out.println("Original: ((P AND S) AND NOT H) AND D");
            System.out.println("Equivalent: NOT (NOT P OR NOT S OR H OR NOT D)");
            System.out.println("De Morgan's law turns the AND of the four checks into a negated OR.");
            System.out.println("P S H D | Original | Equivalent");
        }

        for (int row = 0; row < 16; row++) {

            boolean p = (row & 8) != 0;
            boolean s = (row & 4) != 0;
            boolean h = (row & 2) != 0;
            boolean d = (row & 1) != 0;

            boolean original = eligible(p, s, h, d);
            boolean rewritten = equivalent(p, s, h, d);

            if (testOnly) {

                boolean expected = row == 13;

                if (original != expected || rewritten != expected) {
                    throw new AssertionError("Incorrect eligibility or equivalence at row " + row);
                }
                } else {

                System.out.printf("%c %c %c %c | %c | %c%n",
                        truth(p), truth(s), truth(h), truth(d),
                        truth(original), truth(rewritten));
            }
        }

    }
    private static void showExpressionTree() {

        System.out.println("\nExpression tree");

        System.out.println("AND");
        System.out.println("|-- AND");
        System.out.println("| |-- AND");
        System.out.println("| | |-- P");
        System.out.println("| | `-- S");
        System.out.println("| `-- NOT");
        System.out.println("| `-- H");
        System.out.println("`-- D");

        System.out.println("Preorder: AND AND AND P S NOT H D");
        System.out.println("Inorder: (((P AND S) AND (NOT H)) AND D)");
        System.out.println("Postorder: P S AND H NOT AND D AND");
    }
    private static void showKnowledgeGraph() {

        System.out.println("\nKnowledge graph (source -> relationship -> target)");
        System.out.println("Student -> requests enrollment in -> Course");
        System.out.println("Student -> is advised by -> Advisor");
        System.out.println("Student -> may have -> Registration Hold");
        System.out.println("Course -> requires -> Prerequisite");
        System.out.println("Course -> has -> Seat Availability");
        System.out.println("Course -> is subject to -> Registration Deadline");
        System.out.println("Registration Hold -> can block enrollment in -> Course");
        System.out.println("Advisor -> can clarify -> Prerequisite");
    }
    private static void showCheckList() {

        System.out.println("\nOfficial university verification checklist");

        System.out.println("[ ] Confirm prerequisite credit in your academic record.");

        System.out.println("[ ] Check the section's seat availability in the registration portal.");

        System.out.println("[ ] Review active holds in the portal and follow its instructions.");

        System.out.println("[ ] Confirm the deadline with the registrar's academic calendar.");

        System.out.println("[ ] Ask your advisor about any approvals or overrides.");

    }
    private static void verifyTruthTable() {
        showTruthTable(true);
        System.out.println("All 16 eligibility and equivalence cases passed.");
    }
    // shows registration results in another window
    private static void showRegistrationResults(boolean[] answers) {

        String inputText = "";

        for (int i = 0; i < answers.length; i++) {
            inputText += answers[i] ? "yes\n" : "no\n";
        }

        Scanner input = new Scanner(inputText);

        java.io.ByteArrayOutputStream output = new java.io.ByteArrayOutputStream();
        java.io.PrintStream original = System.out;

        try {
            System.setOut(new java.io.PrintStream(output));
            checkRegistration(input);
        } finally {
            System.setOut(original);
            input.close();
        }

        JFrame resultFrame = new JFrame("Registration Results");

        JTextArea resultArea = new JTextArea(output.toString());
        resultArea.setEditable(false);

        JScrollPane scroll = new JScrollPane(resultArea);

        resultFrame.add(scroll);
        resultFrame.setSize(650, 450);
        resultFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        resultFrame.setVisible(true);
    }

}

