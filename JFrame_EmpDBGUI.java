/**
 * **********
 * NAME: Shoaib Khan, Talha Sultan
 *
 * ICS4U0-A, Sep-Jan 2016
 *
 * THIS FILE IS PART OF THE PROGRAM: Employee Database Assignment
 * (The"JFrame_EmpDBGUI" class) *********
 */
package employeedatabase;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JFrame_EmpDBGUI extends javax.swing.JFrame {

    public JFrame_EmpDBGUI() {
        initComponents();
        this.setResizable(false); //Prevents user from changing the window size
        nameDB.setVisible(true);
        mainMenu.setVisible(false);
        displayFrame.setExtendedState(displayFrame.MAXIMIZED_BOTH);
    }
    private OpenHashTable theOHT; //Name of the hash table.
    private String companyName = null; //Stores the company name given from the user.
    private String employeeType = null; //Stores whether the PartTime or FullTime JRadioButton is pressed.
    private DefaultTableModel model; //Variable name given to the display JTable.
    private int searchEmpInput; //Stores input from user when finding and displaying an individual employee.
    private int numEmployees = 0; //Keeps track of the number of employees in the hash table.
    private int a = 0; //Position of employee in the respective bucket. 
    private int i = 0; //Bucket number.
    private DecimalFormat twoDecimalPlaces = new DecimalFormat("00.00"); //Used for output formatting

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        displayFrame = new javax.swing.JFrame();
        displayTable = new javax.swing.JScrollPane();
        table_DisplayAll = new javax.swing.JTable();
        addEmp = new javax.swing.JFrame();
        addEmp_LastName = new javax.swing.JTextField();
        addEmp_JLabel_FirstName = new javax.swing.JLabel();
        addEmp_JLabel_LastName = new javax.swing.JLabel();
        addEmp_JLabel_Gender = new javax.swing.JLabel();
        addEmp_JLabel_EmployeeNumber = new javax.swing.JLabel();
        addEmp_JLabel_WorkLocation = new javax.swing.JLabel();
        addEmp_JLabel_DeductionsRate = new javax.swing.JLabel();
        addEmp_JLabel_AnnualSalary = new javax.swing.JLabel();
        addEmp_JRadioButton_PartTime = new javax.swing.JRadioButton();
        addEmp_JRadioButton_FullTime = new javax.swing.JRadioButton();
        addEmp_JLabel_TypeOfEmployee = new javax.swing.JLabel();
        addEmp_JComboBox_Gender = new javax.swing.JComboBox<>();
        addEmp_JComboBox_WorkLocation = new javax.swing.JComboBox<>();
        addEmp_FirstName = new javax.swing.JTextField();
        addEmp_JButton_Save = new javax.swing.JButton();
        addEmp_JButton_Cancel = new javax.swing.JButton();
        addEmp_JLabel_AnnualDollarSign = new javax.swing.JLabel();
        addEmp_JLabel_HourlyDollarSign = new javax.swing.JLabel();
        addEmp_JLabel_HourlyWage = new javax.swing.JLabel();
        addEmp_JLabel_HoursPerWeek = new javax.swing.JLabel();
        addEmp_JLabel_WeeksPerYear = new javax.swing.JLabel();
        addEmp_EmployeeNumber = new javax.swing.JTextField();
        addEmp_DeductionsRate = new javax.swing.JTextField();
        addEmp_AnnualSalary = new javax.swing.JTextField();
        addEmp_HourlyWage = new javax.swing.JTextField();
        addEmp_HoursPerWeek = new javax.swing.JTextField();
        addEmp_WeeksPerYear = new javax.swing.JTextField();
        addEmp_JLabel_EmployeeInformation1 = new javax.swing.JLabel();
        addEmp_JLabel_DeductionsRatePercent = new javax.swing.JLabel();
        addEmp_JButton_Edit = new javax.swing.JButton();
        addEmp_JButton_Reset = new javax.swing.JButton();
        removeEmp = new javax.swing.JFrame();
        removeEmp_JLabel_EmpNumDel = new javax.swing.JLabel();
        removeEmp_EmpNum = new javax.swing.JTextField();
        removeEmp_Delete = new javax.swing.JButton();
        removeEmp_Cancel = new javax.swing.JButton();
        removeEmp_JLabel_DelEmp = new javax.swing.JLabel();
        searchEmp = new javax.swing.JFrame();
        searchEmp_JLabel_EmpNumSearch = new javax.swing.JLabel();
        searchEmp_EmpNumSearch = new javax.swing.JTextField();
        searchEmp_Cancel = new javax.swing.JButton();
        searchEmp_Search = new javax.swing.JButton();
        searchEmp_JLabel_SearchEmp = new javax.swing.JLabel();
        editEmpSearch = new javax.swing.JFrame();
        editEmpSearch_JLabel_EmpNumSearch1 = new javax.swing.JLabel();
        editEmpSearch_EmpNumSearch = new javax.swing.JTextField();
        editEmpSearch_Cancel = new javax.swing.JButton();
        editEmpSearch_Search = new javax.swing.JButton();
        editEmpSearch_JLabel_SearchEmp = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        nameDB = new javax.swing.JPanel();
        nameDB_DBName = new javax.swing.JTextField();
        nameDB_Next = new javax.swing.JButton();
        nameDB_BG = new javax.swing.JLabel();
        mainMenu = new javax.swing.JPanel();
        mainMenu_AddEmp = new javax.swing.JButton();
        mainMenu_Back = new javax.swing.JButton();
        mainMenu_DisplayEmp = new javax.swing.JButton();
        mainMenu_RemoveEmp = new javax.swing.JButton();
        mainMenu_RemoveAll = new javax.swing.JButton();
        mainMenu_EditEmp = new javax.swing.JButton();
        mainMenu_DisplayAll = new javax.swing.JButton();
        mainMenu_Save = new javax.swing.JButton();
        mainMenu_MessageBox = new javax.swing.JLabel();
        mainMenu_BG = new javax.swing.JLabel();

        displayFrame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        displayFrame.setTitle("Display Window");
        displayFrame.setAlwaysOnTop(true);
        displayFrame.setType(java.awt.Window.Type.POPUP);

        table_DisplayAll.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee Number", "Firstname", "Lastname", "Gender", "Work Location", "Deductions Rate", "Hourly Wage", "Hours Per Week", "Weeks Per Year", "Annual Salary", "Gross Annual Income"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_DisplayAll.setCellSelectionEnabled(true);
        table_DisplayAll.getTableHeader().setReorderingAllowed(false);
        table_DisplayAll.getTableHeader().setResizingAllowed(false);
        displayTable.setViewportView(table_DisplayAll);
        if (table_DisplayAll.getColumnModel().getColumnCount() > 0) {
            table_DisplayAll.getColumnModel().getColumn(0).setResizable(false);
            table_DisplayAll.getColumnModel().getColumn(1).setResizable(false);
            table_DisplayAll.getColumnModel().getColumn(2).setResizable(false);
            table_DisplayAll.getColumnModel().getColumn(3).setResizable(false);
            table_DisplayAll.getColumnModel().getColumn(4).setResizable(false);
            table_DisplayAll.getColumnModel().getColumn(5).setResizable(false);
            table_DisplayAll.getColumnModel().getColumn(6).setResizable(false);
            table_DisplayAll.getColumnModel().getColumn(7).setResizable(false);
            table_DisplayAll.getColumnModel().getColumn(8).setResizable(false);
            table_DisplayAll.getColumnModel().getColumn(9).setResizable(false);
            table_DisplayAll.getColumnModel().getColumn(10).setResizable(false);
        }

        javax.swing.GroupLayout displayFrameLayout = new javax.swing.GroupLayout(displayFrame.getContentPane());
        displayFrame.getContentPane().setLayout(displayFrameLayout);
        displayFrameLayout.setHorizontalGroup(
            displayFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(displayTable)
        );
        displayFrameLayout.setVerticalGroup(
            displayFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(displayTable, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        addEmp.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addEmp.setResizable(false);

        addEmp_JLabel_FirstName.setText("Firstname:");

        addEmp_JLabel_LastName.setText("Lastname:");

        addEmp_JLabel_Gender.setText("Gender:");

        addEmp_JLabel_EmployeeNumber.setText("Employee Number:");

        addEmp_JLabel_WorkLocation.setText("Work Location:");

        addEmp_JLabel_DeductionsRate.setText("Deductions Rate:");

        addEmp_JLabel_AnnualSalary.setText("Annual Salary:");

        addEmp_JRadioButton_PartTime.setText("PartTime");
        addEmp_JRadioButton_PartTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEmp_JRadioButton_PartTimeActionPerformed(evt);
            }
        });

        addEmp_JRadioButton_FullTime.setText("FullTime");
        addEmp_JRadioButton_FullTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEmp_JRadioButton_FullTimeActionPerformed(evt);
            }
        });

        addEmp_JLabel_TypeOfEmployee.setText("Type of Employee:");

        addEmp_JComboBox_Gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Other" }));
        addEmp_JComboBox_Gender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEmp_JComboBox_GenderActionPerformed(evt);
            }
        });

        addEmp_JComboBox_WorkLocation.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mississauga", "Oakville", "Toronto", "London", "Brampton" }));
        addEmp_JComboBox_WorkLocation.setSelectedItem(0);
        addEmp_JComboBox_WorkLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEmp_JComboBox_WorkLocationActionPerformed(evt);
            }
        });

        addEmp_FirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEmp_FirstNameActionPerformed(evt);
            }
        });

        addEmp_JButton_Save.setText("Save");
        addEmp_JButton_Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEmp_JButton_SaveActionPerformed(evt);
            }
        });

        addEmp_JButton_Cancel.setText("Cancel");
        addEmp_JButton_Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEmp_JButton_CancelActionPerformed(evt);
            }
        });

        addEmp_JLabel_AnnualDollarSign.setText("$");

        addEmp_JLabel_HourlyDollarSign.setText("$");

        addEmp_JLabel_HourlyWage.setText("Hourly Wage:");

        addEmp_JLabel_HoursPerWeek.setText("Hours Per Week:");

        addEmp_JLabel_WeeksPerYear.setText("Weeks Per Year:");

        addEmp_EmployeeNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                addEmp_EmployeeNumberKeyTyped(evt);
            }
        });

        addEmp_DeductionsRate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                addEmp_DeductionsRateKeyTyped(evt);
            }
        });

        addEmp_JLabel_EmployeeInformation1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        addEmp_JLabel_EmployeeInformation1.setText("EMPLOYEE INFORMATION");

        addEmp_JLabel_DeductionsRatePercent.setText("%");

        addEmp_JButton_Edit.setText("Edit");
        addEmp_JButton_Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEmp_JButton_EditActionPerformed(evt);
            }
        });

        addEmp_JButton_Reset.setText("Reset");
        addEmp_JButton_Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEmp_JButton_ResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addEmpLayout = new javax.swing.GroupLayout(addEmp.getContentPane());
        addEmp.getContentPane().setLayout(addEmpLayout);
        addEmpLayout.setHorizontalGroup(
            addEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addEmpLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(addEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(addEmpLayout.createSequentialGroup()
                        .addGroup(addEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addEmpLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(addEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(addEmp_JLabel_FirstName)
                                    .addComponent(addEmp_JLabel_LastName)
                                    .addComponent(addEmp_JLabel_WorkLocation)
                                    .addComponent(addEmp_JLabel_TypeOfEmployee)
                                    .addComponent(addEmp_JLabel_HourlyWage)
                                    .addComponent(addEmp_JLabel_WeeksPerYear)
                                    .addComponent(addEmp_JLabel_HoursPerWeek)
                                    .addComponent(addEmp_JLabel_AnnualSalary)))
                            .addComponent(addEmp_JLabel_Gender)
                            .addComponent(addEmp_JLabel_EmployeeNumber)
                            .addComponent(addEmp_JLabel_DeductionsRate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(addEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addEmp_JLabel_AnnualDollarSign, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(addEmp_JLabel_HourlyDollarSign, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(addEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addEmp_JComboBox_Gender, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addEmp_WeeksPerYear)
                            .addComponent(addEmp_HoursPerWeek)
                            .addComponent(addEmp_HourlyWage)
                            .addComponent(addEmp_AnnualSalary)
                            .addComponent(addEmp_DeductionsRate)
                            .addComponent(addEmp_EmployeeNumber)
                            .addGroup(addEmpLayout.createSequentialGroup()
                                .addComponent(addEmp_JRadioButton_PartTime)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(addEmp_JRadioButton_FullTime))
                            .addComponent(addEmp_JComboBox_WorkLocation, 0, 149, Short.MAX_VALUE)
                            .addComponent(addEmp_FirstName)
                            .addComponent(addEmp_LastName)))
                    .addGroup(addEmpLayout.createSequentialGroup()
                        .addComponent(addEmp_JButton_Reset, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addEmp_JButton_Save, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addEmp_JButton_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addEmp_JButton_Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addEmp_JLabel_DeductionsRatePercent)
                .addGap(45, 45, 45))
            .addGroup(addEmpLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(addEmp_JLabel_EmployeeInformation1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        addEmpLayout.setVerticalGroup(
            addEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addEmpLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addEmp_JLabel_EmployeeInformation1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(addEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addEmp_JRadioButton_PartTime)
                    .addComponent(addEmp_JLabel_TypeOfEmployee)
                    .addComponent(addEmp_JRadioButton_FullTime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addEmp_JLabel_FirstName)
                    .addComponent(addEmp_FirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addEmp_LastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addEmp_JLabel_LastName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addEmp_JComboBox_Gender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addEmp_JLabel_Gender))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addEmp_JLabel_EmployeeNumber)
                    .addComponent(addEmp_EmployeeNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addEmp_JComboBox_WorkLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addEmp_JLabel_WorkLocation))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addEmp_DeductionsRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addEmp_JLabel_DeductionsRate)
                    .addComponent(addEmp_JLabel_DeductionsRatePercent))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addEmp_JLabel_AnnualSalary)
                    .addComponent(addEmp_JLabel_AnnualDollarSign)
                    .addComponent(addEmp_AnnualSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addEmp_JLabel_HourlyWage)
                    .addComponent(addEmp_JLabel_HourlyDollarSign)
                    .addComponent(addEmp_HourlyWage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addEmp_JLabel_HoursPerWeek)
                    .addComponent(addEmp_HoursPerWeek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addEmp_JLabel_WeeksPerYear)
                    .addComponent(addEmp_WeeksPerYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addEmp_JButton_Edit)
                    .addComponent(addEmp_JButton_Cancel)
                    .addComponent(addEmp_JButton_Save)
                    .addComponent(addEmp_JButton_Reset))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        removeEmp.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        removeEmp_JLabel_EmpNumDel.setText("Employee Number:");

        removeEmp_EmpNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeEmp_EmpNumActionPerformed(evt);
            }
        });
        removeEmp_EmpNum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                removeEmp_EmpNumKeyTyped(evt);
            }
        });

        removeEmp_Delete.setText("Delete");
        removeEmp_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeEmp_DeleteActionPerformed(evt);
            }
        });

        removeEmp_Cancel.setText("Cancel");
        removeEmp_Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeEmp_CancelActionPerformed(evt);
            }
        });

        removeEmp_JLabel_DelEmp.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        removeEmp_JLabel_DelEmp.setText("DELETE EMPLOYEE");

        javax.swing.GroupLayout removeEmpLayout = new javax.swing.GroupLayout(removeEmp.getContentPane());
        removeEmp.getContentPane().setLayout(removeEmpLayout);
        removeEmpLayout.setHorizontalGroup(
            removeEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(removeEmpLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(removeEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(removeEmpLayout.createSequentialGroup()
                        .addGroup(removeEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(removeEmp_Delete)
                            .addComponent(removeEmp_JLabel_EmpNumDel))
                        .addGap(18, 18, 18)
                        .addGroup(removeEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(removeEmp_Cancel)
                            .addComponent(removeEmp_EmpNum, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(removeEmp_JLabel_DelEmp))
                .addGap(18, 18, 18))
        );
        removeEmpLayout.setVerticalGroup(
            removeEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, removeEmpLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(removeEmp_JLabel_DelEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(removeEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(removeEmp_EmpNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeEmp_JLabel_EmpNumDel))
                .addGap(18, 18, 18)
                .addGroup(removeEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(removeEmp_Cancel)
                    .addComponent(removeEmp_Delete))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        searchEmp.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        searchEmp_JLabel_EmpNumSearch.setText("Employee Number:");

        searchEmp_EmpNumSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchEmp_EmpNumSearchActionPerformed(evt);
            }
        });
        searchEmp_EmpNumSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchEmp_EmpNumSearchKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchEmp_EmpNumSearchKeyPressed(evt);
            }
        });

        searchEmp_Cancel.setText("Cancel");
        searchEmp_Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchEmp_CancelActionPerformed(evt);
            }
        });

        searchEmp_Search.setText("Search");
        searchEmp_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchEmp_SearchActionPerformed(evt);
            }
        });

        searchEmp_JLabel_SearchEmp.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        searchEmp_JLabel_SearchEmp.setText("SEARCH EMPLOYEE");

        javax.swing.GroupLayout searchEmpLayout = new javax.swing.GroupLayout(searchEmp.getContentPane());
        searchEmp.getContentPane().setLayout(searchEmpLayout);
        searchEmpLayout.setHorizontalGroup(
            searchEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchEmpLayout.createSequentialGroup()
                .addGroup(searchEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchEmpLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(searchEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(searchEmp_Search)
                            .addComponent(searchEmp_JLabel_EmpNumSearch))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(searchEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(searchEmp_EmpNumSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(searchEmpLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(searchEmp_Cancel))))
                    .addGroup(searchEmpLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(searchEmp_JLabel_SearchEmp)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        searchEmpLayout.setVerticalGroup(
            searchEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchEmpLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchEmp_JLabel_SearchEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(searchEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchEmp_JLabel_EmpNumSearch)
                    .addComponent(searchEmp_EmpNumSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(searchEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchEmp_Search)
                    .addComponent(searchEmp_Cancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        editEmpSearch.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        editEmpSearch_JLabel_EmpNumSearch1.setText("Employee Number:");

        editEmpSearch_EmpNumSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editEmpSearch_EmpNumSearchActionPerformed(evt);
            }
        });
        editEmpSearch_EmpNumSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                editEmpSearch_EmpNumSearchKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                editEmpSearch_EmpNumSearchKeyPressed(evt);
            }
        });

        editEmpSearch_Cancel.setText("Cancel");
        editEmpSearch_Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editEmpSearch_CancelActionPerformed(evt);
            }
        });

        editEmpSearch_Search.setText("Search");
        editEmpSearch_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editEmpSearch_SearchActionPerformed(evt);
            }
        });

        editEmpSearch_JLabel_SearchEmp.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        editEmpSearch_JLabel_SearchEmp.setText("EDIT EMPLOYEE");

        javax.swing.GroupLayout editEmpSearchLayout = new javax.swing.GroupLayout(editEmpSearch.getContentPane());
        editEmpSearch.getContentPane().setLayout(editEmpSearchLayout);
        editEmpSearchLayout.setHorizontalGroup(
            editEmpSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editEmpSearchLayout.createSequentialGroup()
                .addGroup(editEmpSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(editEmpSearchLayout.createSequentialGroup()
                        .addComponent(editEmpSearch_Search)
                        .addGap(18, 18, 18)
                        .addComponent(editEmpSearch_Cancel))
                    .addGroup(editEmpSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(editEmpSearchLayout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addComponent(editEmpSearch_JLabel_EmpNumSearch1)
                            .addGap(18, 18, 18)
                            .addComponent(editEmpSearch_EmpNumSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(editEmpSearchLayout.createSequentialGroup()
                            .addGap(44, 44, 44)
                            .addComponent(editEmpSearch_JLabel_SearchEmp))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        editEmpSearchLayout.setVerticalGroup(
            editEmpSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editEmpSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(editEmpSearch_JLabel_SearchEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(editEmpSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editEmpSearch_JLabel_EmpNumSearch1)
                    .addComponent(editEmpSearch_EmpNumSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(editEmpSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editEmpSearch_Cancel)
                    .addComponent(editEmpSearch_Search))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jToolBar1.setRollover(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Employee Database Main Menu");
        setName("mainFrame"); // NOI18N

        nameDB.setLayout(null);

        nameDB_DBName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        nameDB_DBName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameDB_DBNameActionPerformed(evt);
            }
        });
        nameDB.add(nameDB_DBName);
        nameDB_DBName.setBounds(300, 360, 320, 60);

        nameDB_Next.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        nameDB_Next.setText("Next");
        nameDB_Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameDB_NextActionPerformed(evt);
            }
        });
        nameDB.add(nameDB_Next);
        nameDB_Next.setBounds(370, 430, 180, 60);

        nameDB_BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/employeedatabase/JFrame_LoadDB.PNG"))); // NOI18N
        nameDB.add(nameDB_BG);
        nameDB_BG.setBounds(0, 0, 920, 510);

        mainMenu.setLayout(null);

        mainMenu_AddEmp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mainMenu_AddEmp.setText("Add Employee");
        mainMenu_AddEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainMenu_AddEmpActionPerformed(evt);
            }
        });
        mainMenu.add(mainMenu_AddEmp);
        mainMenu_AddEmp.setBounds(130, 110, 160, 60);

        mainMenu_Back.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mainMenu_Back.setText("Back");
        mainMenu_Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainMenu_BackActionPerformed(evt);
            }
        });
        mainMenu.add(mainMenu_Back);
        mainMenu_Back.setBounds(10, 0, 80, 50);

        mainMenu_DisplayEmp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mainMenu_DisplayEmp.setText("Display Employee");
        mainMenu_DisplayEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainMenu_DisplayEmpActionPerformed(evt);
            }
        });
        mainMenu.add(mainMenu_DisplayEmp);
        mainMenu_DisplayEmp.setBounds(360, 230, 160, 60);

        mainMenu_RemoveEmp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mainMenu_RemoveEmp.setText("Remove Employee");
        mainMenu_RemoveEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainMenu_RemoveEmpActionPerformed(evt);
            }
        });
        mainMenu.add(mainMenu_RemoveEmp);
        mainMenu_RemoveEmp.setBounds(590, 110, 170, 60);

        mainMenu_RemoveAll.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mainMenu_RemoveAll.setText("Clear Database");
        mainMenu_RemoveAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainMenu_RemoveAllActionPerformed(evt);
            }
        });
        mainMenu.add(mainMenu_RemoveAll);
        mainMenu_RemoveAll.setBounds(130, 230, 170, 60);

        mainMenu_EditEmp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mainMenu_EditEmp.setText("Edit Employee");
        mainMenu_EditEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainMenu_EditEmpActionPerformed(evt);
            }
        });
        mainMenu.add(mainMenu_EditEmp);
        mainMenu_EditEmp.setBounds(360, 110, 160, 60);

        mainMenu_DisplayAll.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mainMenu_DisplayAll.setText("Display All");
        mainMenu_DisplayAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainMenu_DisplayAllActionPerformed(evt);
            }
        });
        mainMenu.add(mainMenu_DisplayAll);
        mainMenu_DisplayAll.setBounds(590, 230, 170, 60);

        mainMenu_Save.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mainMenu_Save.setText("Save");
        mainMenu_Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainMenu_SaveActionPerformed(evt);
            }
        });
        mainMenu.add(mainMenu_Save);
        mainMenu_Save.setBounds(360, 350, 160, 50);

        mainMenu_MessageBox.setBackground(new java.awt.Color(204, 204, 204));
        mainMenu_MessageBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mainMenu_MessageBox.setForeground(new java.awt.Color(0, 255, 0));
        mainMenu.add(mainMenu_MessageBox);
        mainMenu_MessageBox.setBounds(590, 350, 240, 50);

        mainMenu_BG.setBackground(new java.awt.Color(0, 0, 0));
        mainMenu_BG.setForeground(new java.awt.Color(255, 255, 255));
        mainMenu_BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/employeedatabase/JFrame_NewDB.png"))); // NOI18N
        mainMenu.add(mainMenu_BG);
        mainMenu_BG.setBounds(0, 0, 880, 490);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 940, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addComponent(mainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 880, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(46, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nameDB, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 525, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addComponent(mainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(21, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(5, 5, 5)
                    .addComponent(nameDB, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mainMenu_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainMenu_BackActionPerformed
        //If statement creates a pop up window and preforms an action depending on the button clicked.
        if (JOptionPane.showConfirmDialog(mainMenu, "Would you like to save any changes made?", "Save Changes?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            try {
                theOHT.saveDatabase(companyName);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(JFrame_EmpDBGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        numEmployees = 0;
        companyName = null;
        mainMenu.setVisible(false);
        nameDB.setVisible(true);
        nameDB_DBName.setText("");
    }//GEN-LAST:event_mainMenu_BackActionPerformed

    private void mainMenu_DisplayEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainMenu_DisplayEmpActionPerformed
        if (numEmployees == 0) {
            mainMenu_MessageBox.setForeground(Color.RED);
            mainMenu_MessageBox.setText("No Employees To Display!");
        } else {
            searchEmp.pack();
            searchEmp.setVisible(true);
            searchEmp_EmpNumSearch.setText("");
        }
    }//GEN-LAST:event_mainMenu_DisplayEmpActionPerformed

    private void mainMenu_AddEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainMenu_AddEmpActionPerformed
        addEmp.pack();
        addEmp.setVisible(true);
        addEmp_JButton_Edit.setVisible(false);
        addEmp_JButton_Save.setVisible(true);
        addEmp_JRadioButton_PartTime.setSelected(false);
        addEmp_JRadioButton_FullTime.setSelected(false);
        addEmp_FirstName.setEditable(false);
        addEmp_LastName.setEditable(false);
        addEmp_JComboBox_Gender.setEnabled(false);
        addEmp_JComboBox_WorkLocation.setEnabled(false);
        addEmp_DeductionsRate.setEditable(false);
        addEmp_HourlyWage.setEditable(false);
        addEmp_HoursPerWeek.setEditable(false);
        addEmp_WeeksPerYear.setEditable(false);
        addEmp_AnnualSalary.setEditable(false);
        addEmp_EmployeeNumber.setEditable(false);
        addEmp_FirstName.setText("");
        addEmp_LastName.setText("");
        addEmp_JComboBox_Gender.setSelectedItem("");
        addEmp_JComboBox_WorkLocation.setSelectedItem("");
        addEmp_DeductionsRate.setText("");
        addEmp_HourlyWage.setText("");
        addEmp_HoursPerWeek.setText("");
        addEmp_WeeksPerYear.setText("");
        addEmp_AnnualSalary.setText("");
        addEmp_EmployeeNumber.setText("");
    }//GEN-LAST:event_mainMenu_AddEmpActionPerformed

    private void mainMenu_RemoveEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainMenu_RemoveEmpActionPerformed
        if (numEmployees == 0) {
            mainMenu_MessageBox.setForeground(Color.RED);
            mainMenu_MessageBox.setText("No Employees To Remove!");
        } else {
            removeEmp.pack();
            removeEmp.setVisible(true);
            removeEmp_EmpNum.setText("");
        }
    }//GEN-LAST:event_mainMenu_RemoveEmpActionPerformed

    private void mainMenu_RemoveAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainMenu_RemoveAllActionPerformed
        if (numEmployees == 0) {
            mainMenu_MessageBox.setForeground(Color.RED);
            mainMenu_MessageBox.setText("Database is Empty.");
        } else {
            //If statement creates a pop up window and preforms an action depending on the button clicked.
            if (JOptionPane.showConfirmDialog(mainMenu, "Are you sure you want to remove ALL employees?", "Remove All Employees?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                theOHT = new OpenHashTable(2);
                numEmployees = 0;
                mainMenu_MessageBox.setForeground(Color.GREEN);
                mainMenu_MessageBox.setText("Success! Unsaved Changes.");
            } else {
                mainMenu_MessageBox.setForeground(Color.GREEN);
                mainMenu_MessageBox.setText("No Changes Made.");
            }
        }
    }//GEN-LAST:event_mainMenu_RemoveAllActionPerformed

    private void mainMenu_EditEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainMenu_EditEmpActionPerformed
        if (numEmployees == 0) {
            mainMenu_MessageBox.setForeground(Color.RED);
            mainMenu_MessageBox.setText("No Employees To Edit!");
        } else {
            editEmpSearch.pack();
            editEmpSearch.setVisible(true);
            editEmpSearch_EmpNumSearch.setText("");
        }
    }//GEN-LAST:event_mainMenu_EditEmpActionPerformed

    private void removeEmp_EmpNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeEmp_EmpNumActionPerformed
    }//GEN-LAST:event_removeEmp_EmpNumActionPerformed

    private void removeEmp_EmpNumKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_removeEmp_EmpNumKeyTyped
    }//GEN-LAST:event_removeEmp_EmpNumKeyTyped

    private void removeEmp_CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeEmp_CancelActionPerformed
        removeEmp.dispose();
        mainMenu_MessageBox.setForeground(Color.GREEN);
        mainMenu_MessageBox.setText("No Changes Were Made.");
    }//GEN-LAST:event_removeEmp_CancelActionPerformed

    private void searchEmp_EmpNumSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchEmp_EmpNumSearchActionPerformed
    }//GEN-LAST:event_searchEmp_EmpNumSearchActionPerformed

    private void searchEmp_EmpNumSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchEmp_EmpNumSearchKeyPressed
    }//GEN-LAST:event_searchEmp_EmpNumSearchKeyPressed

    private void searchEmp_EmpNumSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchEmp_EmpNumSearchKeyTyped
    }//GEN-LAST:event_searchEmp_EmpNumSearchKeyTyped

    private void searchEmp_CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchEmp_CancelActionPerformed
        searchEmp.dispose();
        mainMenu_MessageBox.setForeground(Color.GREEN);
        mainMenu_MessageBox.setText("No Changes Were Made.");
    }//GEN-LAST:event_searchEmp_CancelActionPerformed

    private void nameDB_DBNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameDB_DBNameActionPerformed
    }//GEN-LAST:event_nameDB_DBNameActionPerformed

    private void nameDB_NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameDB_NextActionPerformed
        companyName = nameDB_DBName.getText().toLowerCase().replace(" ", "");
        File file = new File(companyName + ".txt");
        boolean exists = file.exists();
        if (nameDB_DBName.getText().replace(" ", "").length() != 0) {
            if (exists == true) {
                theOHT = new OpenHashTable(2);
                mainMenu_MessageBox.setForeground(Color.GREEN);
                mainMenu_MessageBox.setText("The Database Has Been Retrieved.");
                try {
                    theOHT.loadDatabase(companyName);
                    for (int i = 0; i < theOHT.buckets.length; i++) {
                        numEmployees += theOHT.buckets[i].size();
                    }
                } catch (IOException ex) {
                    Logger.getLogger(JFrame_EmpDBGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                theOHT = new OpenHashTable(2);
                mainMenu_MessageBox.setForeground(Color.GREEN);
                mainMenu_MessageBox.setText("A New Database Was Created");
            }
            nameDB.setVisible(false);
            mainMenu.setVisible(true);
            //Creates a pop up window and preforms an action depending on the button clicked when the 'x' button on the jframe is clicked.
            this.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                    if (companyName != null) {
                        if (JOptionPane.showConfirmDialog(mainMenu, "Would you like to save before exiting?", "Save Changes?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                            try {
                                theOHT.saveDatabase(companyName);
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(JFrame_EmpDBGUI.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        System.exit(0);
                    }
                }
            });
        }
    }//GEN-LAST:event_nameDB_NextActionPerformed

    private void mainMenu_SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainMenu_SaveActionPerformed
        try {
            theOHT.saveDatabase(companyName);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JFrame_EmpDBGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        mainMenu_MessageBox.setForeground(Color.GREEN);
        mainMenu_MessageBox.setText("Database Saved!");
    }//GEN-LAST:event_mainMenu_SaveActionPerformed

    private void searchEmp_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchEmp_SearchActionPerformed
        if (theOHT.isInteger(searchEmp_EmpNumSearch.getText()) == false || Integer.parseInt(searchEmp_EmpNumSearch.getText()) < 0 || theOHT.searchEmployee(Integer.parseInt(searchEmp_EmpNumSearch.getText())) == -1) {
            mainMenu_MessageBox.setForeground(Color.RED);
            mainMenu_MessageBox.setText("Employee Does Not Exist!");
        } else {
            searchEmp.dispose();
            displayFrame.setVisible(true);
            model = (DefaultTableModel) table_DisplayAll.getModel();
            model.setRowCount(0);
            int i = theOHT.calcBucket(Integer.parseInt(searchEmp_EmpNumSearch.getText().replace(" ", "")));
            int a = theOHT.searchEmployee(Integer.parseInt(searchEmp_EmpNumSearch.getText().replace(" ", "")));
            if (theOHT.buckets[i].get(a) instanceof PartTimeEmployee) {
                model.addRow(new Object[]{theOHT.buckets[i].get(a).getEmpNum(), theOHT.buckets[i].get(a).getFirstName(), theOHT.buckets[i].get(a).getLastName(), theOHT.buckets[i].get(a).getSex(), theOHT.buckets[i].get(a).getWorkLocation(), twoDecimalPlaces.format((theOHT.buckets[i].get(a).getDeductionRate() * 100)) + "%", "$" + twoDecimalPlaces.format(((PartTimeEmployee) theOHT.buckets[i].get(a)).getHourlyWage()), ((PartTimeEmployee) theOHT.buckets[i].get(a)).getHoursPerWeek(), ((PartTimeEmployee) theOHT.buckets[i].get(a)).getWeeksPerYear(), "", "$" + twoDecimalPlaces.format(((PartTimeEmployee) theOHT.buckets[i].get(a)).calcAnnualGrossSalary(((PartTimeEmployee) theOHT.buckets[i].get(a)).getHourlyWage(), ((PartTimeEmployee) theOHT.buckets[i].get(a)).getHoursPerWeek(), ((PartTimeEmployee) theOHT.buckets[i].get(a)).getWeeksPerYear(), ((PartTimeEmployee) theOHT.buckets[i].get(a)).getDeductionRate()))});
            } else {
                model.addRow(new Object[]{theOHT.buckets[i].get(a).getEmpNum(), theOHT.buckets[i].get(a).getFirstName(), theOHT.buckets[i].get(a).getLastName(), theOHT.buckets[i].get(a).getSex(), theOHT.buckets[i].get(a).getWorkLocation(), twoDecimalPlaces.format((theOHT.buckets[i].get(a).getDeductionRate() * 100)) + "%", "", "", "", "$" + twoDecimalPlaces.format(((FullTimeEmployee) theOHT.buckets[i].get(a)).getAnnualSalary()), "$" + twoDecimalPlaces.format(((FullTimeEmployee) theOHT.buckets[i].get(a)).calcAnnualGrossSalary(((FullTimeEmployee) theOHT.buckets[i].get(a)).getAnnualSalary(), ((FullTimeEmployee) theOHT.buckets[i].get(a)).getDeductionRate()))});
            }
        }
    }//GEN-LAST:event_searchEmp_SearchActionPerformed

    private void editEmpSearch_EmpNumSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editEmpSearch_EmpNumSearchActionPerformed
    }//GEN-LAST:event_editEmpSearch_EmpNumSearchActionPerformed

    private void editEmpSearch_EmpNumSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editEmpSearch_EmpNumSearchKeyPressed
    }//GEN-LAST:event_editEmpSearch_EmpNumSearchKeyPressed

    private void editEmpSearch_EmpNumSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editEmpSearch_EmpNumSearchKeyTyped
    }//GEN-LAST:event_editEmpSearch_EmpNumSearchKeyTyped

    private void editEmpSearch_CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editEmpSearch_CancelActionPerformed
        editEmpSearch.dispose();
        mainMenu_MessageBox.setForeground(Color.GREEN);
        mainMenu_MessageBox.setText("No Changes Were Made.");
    }//GEN-LAST:event_editEmpSearch_CancelActionPerformed

    private void editEmpSearch_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editEmpSearch_SearchActionPerformed
        if (theOHT.isInteger(editEmpSearch_EmpNumSearch.getText()) == false || Integer.parseInt(editEmpSearch_EmpNumSearch.getText()) < 0 || theOHT.searchEmployee(Integer.parseInt(editEmpSearch_EmpNumSearch.getText())) == -1) {
            mainMenu_MessageBox.setForeground(Color.RED);
            mainMenu_MessageBox.setText("Employee Does Not Exist!");
        } else {
            searchEmpInput = Integer.parseInt(editEmpSearch_EmpNumSearch.getText());
            editEmpSearch.dispose();
            addEmp.pack();
            addEmp.setVisible(true);
            addEmp_JButton_Save.setVisible(false);
            addEmp_JButton_Edit.setVisible(true);

            a = theOHT.searchEmployee(searchEmpInput);
            i = theOHT.calcBucket(searchEmpInput);

            if (theOHT.buckets[i].get(a) instanceof PartTimeEmployee) {
                addEmp_JRadioButton_PartTime.setSelected(false);
                addEmp_JRadioButton_FullTime.setSelected(false);
                addEmp_HourlyWage.setText(String.valueOf(((PartTimeEmployee) theOHT.buckets[i].get(a)).getHourlyWage()));
                addEmp_HoursPerWeek.setText(String.valueOf(((PartTimeEmployee) theOHT.buckets[i].get(a)).getHoursPerWeek()));
                addEmp_WeeksPerYear.setText(String.valueOf(((PartTimeEmployee) theOHT.buckets[i].get(a)).getWeeksPerYear()));
                addEmp_JLabel_AnnualSalary.setVisible(false);
                addEmp_AnnualSalary.setVisible(false);
                addEmp_JLabel_AnnualDollarSign.setVisible(false);
                addEmp_AnnualSalary.setEditable(false);
            } else {
                addEmp_JRadioButton_FullTime.setSelected(false);
                addEmp_JRadioButton_PartTime.setSelected(false);
                addEmp_AnnualSalary.setText(String.valueOf(((FullTimeEmployee) theOHT.buckets[i].get(a)).getAnnualSalary()));
                addEmp_JLabel_HourlyWage.setVisible(false);
                addEmp_HourlyWage.setVisible(false);
                addEmp_JLabel_HourlyDollarSign.setVisible(false);
                addEmp_JLabel_HoursPerWeek.setVisible(false);
                addEmp_HoursPerWeek.setVisible(false);
                addEmp_JLabel_WeeksPerYear.setVisible(false);
                addEmp_WeeksPerYear.setVisible(false);
            }
            addEmp_EmployeeNumber.setText(String.valueOf(theOHT.buckets[i].get(a).getEmpNum()));
            addEmp_FirstName.setText(theOHT.buckets[i].get(a).getFirstName());
            addEmp_LastName.setText(theOHT.buckets[i].get(a).getLastName());
            addEmp_JComboBox_Gender.setSelectedItem(theOHT.buckets[i].get(a).getSex());
            addEmp_JComboBox_WorkLocation.setSelectedItem(theOHT.buckets[i].get(a).getWorkLocation());
            addEmp_DeductionsRate.setText(String.valueOf(theOHT.buckets[i].get(a).getDeductionRate() * 100));
        }
    }//GEN-LAST:event_editEmpSearch_SearchActionPerformed

    private void mainMenu_DisplayAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainMenu_DisplayAllActionPerformed
        if (numEmployees == 0) {
            mainMenu_MessageBox.setForeground(Color.RED);
            mainMenu_MessageBox.setText("The Database Is Empty!");
        } else {
            displayFrame.setVisible(true);
            model = (DefaultTableModel) table_DisplayAll.getModel();
            model.setRowCount(0);
            for (int i = 0; i < theOHT.buckets.length; i++) {
                for (int a = 0; a < (theOHT.buckets[theOHT.calcBucket(i)].size()); a++) {
                    if (theOHT.buckets[i].get(a) instanceof PartTimeEmployee) {
                        model.addRow(new Object[]{theOHT.buckets[i].get(a).getEmpNum(), theOHT.buckets[i].get(a).getFirstName(), theOHT.buckets[i].get(a).getLastName(), theOHT.buckets[i].get(a).getSex(), theOHT.buckets[i].get(a).getWorkLocation(), twoDecimalPlaces.format((theOHT.buckets[i].get(a).getDeductionRate() * 100)) + "%", "$" + twoDecimalPlaces.format(((PartTimeEmployee) theOHT.buckets[i].get(a)).getHourlyWage()), ((PartTimeEmployee) theOHT.buckets[i].get(a)).getHoursPerWeek(), ((PartTimeEmployee) theOHT.buckets[i].get(a)).getWeeksPerYear(), "", "$" + twoDecimalPlaces.format(((PartTimeEmployee) theOHT.buckets[i].get(a)).calcAnnualGrossSalary(((PartTimeEmployee) theOHT.buckets[i].get(a)).getHourlyWage(), ((PartTimeEmployee) theOHT.buckets[i].get(a)).getHoursPerWeek(), ((PartTimeEmployee) theOHT.buckets[i].get(a)).getWeeksPerYear(), ((PartTimeEmployee) theOHT.buckets[i].get(a)).getDeductionRate()))});
                    } else {
                        model.addRow(new Object[]{theOHT.buckets[i].get(a).getEmpNum(), theOHT.buckets[i].get(a).getFirstName(), theOHT.buckets[i].get(a).getLastName(), theOHT.buckets[i].get(a).getSex(), theOHT.buckets[i].get(a).getWorkLocation(), twoDecimalPlaces.format((theOHT.buckets[i].get(a).getDeductionRate() * 100)) + "%", "", "", "", "$" + twoDecimalPlaces.format(((FullTimeEmployee) theOHT.buckets[i].get(a)).getAnnualSalary()), "$" + twoDecimalPlaces.format(((FullTimeEmployee) theOHT.buckets[i].get(a)).calcAnnualGrossSalary(((FullTimeEmployee) theOHT.buckets[i].get(a)).getAnnualSalary(), ((FullTimeEmployee) theOHT.buckets[i].get(a)).getDeductionRate()))});
                    }
                }
            }
        }
    }//GEN-LAST:event_mainMenu_DisplayAllActionPerformed

    private void removeEmp_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeEmp_DeleteActionPerformed
        if (theOHT.isInteger(removeEmp_EmpNum.getText()) == false || Integer.parseInt(removeEmp_EmpNum.getText()) < 0 || theOHT.searchEmployee(Integer.parseInt(removeEmp_EmpNum.getText())) == -1) {
            mainMenu_MessageBox.setForeground(Color.RED);
            mainMenu_MessageBox.setText("Employee Does Not Exist!");
        } else {
            theOHT.removeEmployee(Integer.parseInt(removeEmp_EmpNum.getText().replace(" ", "")));
            numEmployees--;
            removeEmp.dispose();
            displayFrame.setVisible(true);
            model = (DefaultTableModel) table_DisplayAll.getModel();
            model.setRowCount(0);
            for (int i = 0; i < theOHT.buckets.length; i++) {
                for (int a = 0; a < (theOHT.buckets[theOHT.calcBucket(i)].size()); a++) {
                    if (theOHT.buckets[i].get(a) instanceof PartTimeEmployee) {
                        model.addRow(new Object[]{theOHT.buckets[i].get(a).getEmpNum(), theOHT.buckets[i].get(a).getFirstName(), theOHT.buckets[i].get(a).getLastName(), theOHT.buckets[i].get(a).getSex(), theOHT.buckets[i].get(a).getWorkLocation(), twoDecimalPlaces.format((theOHT.buckets[i].get(a).getDeductionRate() * 100)) + "%", "$" + twoDecimalPlaces.format(((PartTimeEmployee) theOHT.buckets[i].get(a)).getHourlyWage()), ((PartTimeEmployee) theOHT.buckets[i].get(a)).getHoursPerWeek(), ((PartTimeEmployee) theOHT.buckets[i].get(a)).getWeeksPerYear(), "", "$" + twoDecimalPlaces.format(((PartTimeEmployee) theOHT.buckets[i].get(a)).calcAnnualGrossSalary(((PartTimeEmployee) theOHT.buckets[i].get(a)).getHourlyWage(), ((PartTimeEmployee) theOHT.buckets[i].get(a)).getHoursPerWeek(), ((PartTimeEmployee) theOHT.buckets[i].get(a)).getWeeksPerYear(), ((PartTimeEmployee) theOHT.buckets[i].get(a)).getDeductionRate()))});
                    } else {
                        model.addRow(new Object[]{theOHT.buckets[i].get(a).getEmpNum(), theOHT.buckets[i].get(a).getFirstName(), theOHT.buckets[i].get(a).getLastName(), theOHT.buckets[i].get(a).getSex(), theOHT.buckets[i].get(a).getWorkLocation(), twoDecimalPlaces.format((theOHT.buckets[i].get(a).getDeductionRate() * 100)) + "%", "", "", "", "$" + twoDecimalPlaces.format(((FullTimeEmployee) theOHT.buckets[i].get(a)).getAnnualSalary()), "$" + twoDecimalPlaces.format(((FullTimeEmployee) theOHT.buckets[i].get(a)).calcAnnualGrossSalary(((FullTimeEmployee) theOHT.buckets[i].get(a)).getAnnualSalary(), ((FullTimeEmployee) theOHT.buckets[i].get(a)).getDeductionRate()))});
                    }
                }
            }
            mainMenu_MessageBox.setForeground(Color.GREEN);
            mainMenu_MessageBox.setText("Employee Has Been Deleted!");
        }
    }//GEN-LAST:event_removeEmp_DeleteActionPerformed

    private void addEmp_DeductionsRateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addEmp_DeductionsRateKeyTyped
    }//GEN-LAST:event_addEmp_DeductionsRateKeyTyped

    private void addEmp_EmployeeNumberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addEmp_EmployeeNumberKeyTyped
    }//GEN-LAST:event_addEmp_EmployeeNumberKeyTyped

    private void addEmp_JButton_CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEmp_JButton_CancelActionPerformed
        addEmp.dispose();
        mainMenu_MessageBox.setForeground(Color.GREEN);
        mainMenu_MessageBox.setText("No Changes Made.");
    }//GEN-LAST:event_addEmp_JButton_CancelActionPerformed

    private void addEmp_JButton_SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEmp_JButton_SaveActionPerformed
        EmployeeInfo newEmp;
        int empNum;
        String firstName;
        String lastName;
        String sex;
        String workLocation;
        double deductionRate;
        double hourlyWage;
        int hoursPerWeek;
        int weeksPerYear;
        double annualSalary;

        if (theOHT.isInteger(addEmp_EmployeeNumber.getText().replace(" ", "")) == true && theOHT.searchEmployee(Integer.parseInt(addEmp_EmployeeNumber.getText().replace(" ", ""))) == -1 && Integer.parseInt(addEmp_EmployeeNumber.getText()) > 0) {
            if (employeeType.equals("PartTime")) {
                if (theOHT.isDouble(addEmp_DeductionsRate.getText().replace(" ", "")) == true && theOHT.isDouble(addEmp_HourlyWage.getText().replace(" ", "")) == true && theOHT.isInteger(addEmp_HoursPerWeek.getText().replace(" ", "")) == true && theOHT.isInteger(addEmp_WeeksPerYear.getText().replace(" ", "")) == true) {
                    if (addEmp_FirstName.getText().matches("[a-zA-Z]+") && addEmp_LastName.getText().matches("[a-zA-Z]+") && (Double.parseDouble(addEmp_DeductionsRate.getText().replace(" ", "")) < 99.999999 && Double.parseDouble(addEmp_DeductionsRate.getText().replace(" ", "")) >= 0) && (Integer.parseInt(addEmp_HoursPerWeek.getText().replace(" ", "")) < 40 && Integer.parseInt(addEmp_HoursPerWeek.getText().replace(" ", "")) > 0) && (Integer.parseInt(addEmp_WeeksPerYear.getText().replace(" ", "")) < 54 && Integer.parseInt(addEmp_WeeksPerYear.getText().replace(" ", "")) > 0)) {
                        empNum = Integer.parseInt(addEmp_EmployeeNumber.getText().replace(" ", ""));
                        firstName = addEmp_FirstName.getText().replace(" ", "");
                        lastName = addEmp_LastName.getText().replace(" ", "");
                        sex = (String) addEmp_JComboBox_Gender.getSelectedItem();
                        workLocation = (String) addEmp_JComboBox_WorkLocation.getSelectedItem();
                        deductionRate = Double.parseDouble(addEmp_DeductionsRate.getText().replace(" ", ""));
                        hourlyWage = Double.parseDouble(addEmp_HourlyWage.getText().replace(" ", ""));
                        hoursPerWeek = Integer.parseInt(addEmp_HoursPerWeek.getText().replace(" ", ""));
                        weeksPerYear = Integer.parseInt(addEmp_WeeksPerYear.getText().replace(" ", ""));
                        newEmp = new PartTimeEmployee(empNum, firstName, lastName, sex, workLocation, deductionRate, hourlyWage, hoursPerWeek, weeksPerYear);
                        theOHT.addToTable(newEmp);
                        numEmployees++;
                        addEmp.dispose();
                        mainMenu_MessageBox.setForeground(Color.GREEN);
                        mainMenu_MessageBox.setText("Success! Unsaved Changes!");
                    } else {
                        mainMenu_MessageBox.setForeground(Color.RED);
                        mainMenu_MessageBox.setText("Logical Error(s)!");
                    }
                } else {
                    mainMenu_MessageBox.setForeground(Color.RED);
                    mainMenu_MessageBox.setText("Invalid Input(s)!");
                }
            } else {
                if (theOHT.searchEmployee(Integer.parseInt(addEmp_EmployeeNumber.getText().replace(" ", ""))) == -1 && theOHT.isInteger(addEmp_EmployeeNumber.getText().replace(" ", "")) == true && theOHT.isDouble(addEmp_DeductionsRate.getText().replace(" ", "")) == true && theOHT.isDouble(addEmp_AnnualSalary.getText().replace(" ", "")) == true) {
                    if (addEmp_FirstName.getText().matches("[a-zA-Z]+") && addEmp_LastName.getText().matches("[a-zA-Z]+") && (Double.parseDouble(addEmp_DeductionsRate.getText().replace(" ", "")) < 99.999999 && Double.parseDouble(addEmp_DeductionsRate.getText().replace(" ", "")) >= 0) && Double.parseDouble(addEmp_AnnualSalary.getText().replace(" ", "")) > 0) {
                        empNum = Integer.parseInt(addEmp_EmployeeNumber.getText().replace(" ", ""));
                        firstName = addEmp_FirstName.getText().replace(" ", "");
                        lastName = addEmp_LastName.getText().replace(" ", "");
                        sex = (String) addEmp_JComboBox_Gender.getSelectedItem();
                        workLocation = (String) addEmp_JComboBox_WorkLocation.getSelectedItem();
                        deductionRate = Double.parseDouble(addEmp_DeductionsRate.getText().replace(" ", ""));
                        annualSalary = Double.parseDouble(addEmp_AnnualSalary.getText().replace(" ", ""));
                        newEmp = new FullTimeEmployee(empNum, firstName, lastName, sex, workLocation, deductionRate, annualSalary);
                        theOHT.addToTable(newEmp);
                        numEmployees++;
                        addEmp.dispose();
                        mainMenu_MessageBox.setForeground(Color.GREEN);
                        mainMenu_MessageBox.setText("Success! Unsaved Changes!");
                    } else {
                        mainMenu_MessageBox.setForeground(Color.RED);
                        mainMenu_MessageBox.setText("Logical Error(s)!");
                    }
                } else {
                    mainMenu_MessageBox.setForeground(Color.RED);
                    mainMenu_MessageBox.setText("Invalid Input(s)!");
                }
            }
        } else {
            mainMenu_MessageBox.setForeground(Color.RED);
            mainMenu_MessageBox.setText("Employee Number Exists/Invalid!");
        }
    }//GEN-LAST:event_addEmp_JButton_SaveActionPerformed

    private void addEmp_JComboBox_WorkLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEmp_JComboBox_WorkLocationActionPerformed
    }//GEN-LAST:event_addEmp_JComboBox_WorkLocationActionPerformed

    private void addEmp_JComboBox_GenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEmp_JComboBox_GenderActionPerformed
    }//GEN-LAST:event_addEmp_JComboBox_GenderActionPerformed

    private void addEmp_JRadioButton_FullTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEmp_JRadioButton_FullTimeActionPerformed
        employeeType = "FullTime";
        addEmp_JRadioButton_FullTime.setSelected(true);
        addEmp_JRadioButton_PartTime.setSelected(false);

        addEmp_JLabel_AnnualSalary.setVisible(true);
        addEmp_AnnualSalary.setVisible(true);
        addEmp_JLabel_AnnualDollarSign.setVisible(true);
        addEmp_JLabel_HourlyWage.setVisible(false);
        addEmp_HourlyWage.setVisible(false);
        addEmp_JLabel_HourlyDollarSign.setVisible(false);
        addEmp_JLabel_HoursPerWeek.setVisible(false);
        addEmp_HoursPerWeek.setVisible(false);
        addEmp_JLabel_WeeksPerYear.setVisible(false);
        addEmp_WeeksPerYear.setVisible(false);
        addEmp_FirstName.setEditable(true);
        addEmp_LastName.setEditable(true);
        addEmp_JComboBox_Gender.setEnabled(true);
        addEmp_JComboBox_WorkLocation.setEnabled(true);
        addEmp_DeductionsRate.setEditable(true);
        addEmp_AnnualSalary.setEditable(true);
        addEmp_EmployeeNumber.setEditable(true);
    }//GEN-LAST:event_addEmp_JRadioButton_FullTimeActionPerformed

    private void addEmp_JRadioButton_PartTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEmp_JRadioButton_PartTimeActionPerformed
        employeeType = "PartTime";
        addEmp_JRadioButton_PartTime.setSelected(true);
        addEmp_JRadioButton_FullTime.setSelected(false);

        addEmp_JLabel_AnnualSalary.setVisible(false);
        addEmp_AnnualSalary.setVisible(false);
        addEmp_JLabel_AnnualDollarSign.setVisible(false);
        addEmp_AnnualSalary.setEditable(false);
        addEmp_JLabel_HourlyWage.setVisible(true);
        addEmp_HourlyWage.setVisible(true);
        addEmp_JLabel_HourlyDollarSign.setVisible(true);
        addEmp_JLabel_HoursPerWeek.setVisible(true);
        addEmp_HoursPerWeek.setVisible(true);
        addEmp_JLabel_WeeksPerYear.setVisible(true);
        addEmp_WeeksPerYear.setVisible(true);
        addEmp_FirstName.setEditable(true);
        addEmp_LastName.setEditable(true);
        addEmp_JComboBox_Gender.setEnabled(true);
        addEmp_JComboBox_WorkLocation.setEnabled(true);
        addEmp_DeductionsRate.setEditable(true);
        addEmp_HourlyWage.setEditable(true);
        addEmp_HoursPerWeek.setEditable(true);
        addEmp_WeeksPerYear.setEditable(true);
        addEmp_EmployeeNumber.setEditable(true);
    }//GEN-LAST:event_addEmp_JRadioButton_PartTimeActionPerformed

    private void addEmp_JButton_EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEmp_JButton_EditActionPerformed
        EmployeeInfo newEmp;
        int empNum;
        String firstName;
        String lastName;
        String sex;
        String workLocation;
        double deductionRate;
        double hourlyWage;
        int hoursPerWeek;
        int weeksPerYear;
        double annualSalary;

        if (theOHT.isInteger(addEmp_EmployeeNumber.getText().replace(" ", "")) == true && (theOHT.searchEmployee(Integer.parseInt(addEmp_EmployeeNumber.getText().replace(" ", ""))) == -1 || Integer.parseInt(addEmp_EmployeeNumber.getText().replace(" ", "")) == searchEmpInput) && Integer.parseInt(addEmp_EmployeeNumber.getText()) > 0) {
            if (employeeType.equals("PartTime")) {
                if (theOHT.isDouble(addEmp_DeductionsRate.getText().replace(" ", "")) == true && theOHT.isDouble(addEmp_HourlyWage.getText().replace(" ", "")) == true && theOHT.isInteger(addEmp_HoursPerWeek.getText().replace(" ", "")) == true && theOHT.isInteger(addEmp_WeeksPerYear.getText().replace(" ", "")) == true) {
                    if (addEmp_FirstName.getText().matches("[a-zA-Z]+") && addEmp_LastName.getText().matches("[a-zA-Z]+") && (Double.parseDouble(addEmp_DeductionsRate.getText().replace(" ", "")) < 99.999999 && Double.parseDouble(addEmp_DeductionsRate.getText().replace(" ", "")) >= 0) && (Integer.parseInt(addEmp_HoursPerWeek.getText().replace(" ", "")) < 40 && Integer.parseInt(addEmp_HoursPerWeek.getText().replace(" ", "")) > 0) && (Integer.parseInt(addEmp_WeeksPerYear.getText().replace(" ", "")) < 54 && Integer.parseInt(addEmp_WeeksPerYear.getText().replace(" ", "")) > 0)) {
                        empNum = Integer.parseInt(addEmp_EmployeeNumber.getText().replace(" ", ""));
                        firstName = addEmp_FirstName.getText().replace(" ", "");
                        lastName = addEmp_LastName.getText().replace(" ", "");
                        sex = (String) addEmp_JComboBox_Gender.getSelectedItem();
                        workLocation = (String) addEmp_JComboBox_WorkLocation.getSelectedItem();
                        deductionRate = Double.parseDouble(addEmp_DeductionsRate.getText().replace(" ", ""));
                        hourlyWage = Double.parseDouble(addEmp_HourlyWage.getText().replace(" ", ""));
                        hoursPerWeek = Integer.parseInt(addEmp_HoursPerWeek.getText().replace(" ", ""));
                        weeksPerYear = Integer.parseInt(addEmp_WeeksPerYear.getText().replace(" ", ""));
                        newEmp = new PartTimeEmployee(empNum, firstName, lastName, sex, workLocation, deductionRate, hourlyWage, hoursPerWeek, weeksPerYear);
                        theOHT.removeEmployee(searchEmpInput);
                        theOHT.addToTable(newEmp);
                        addEmp.dispose();
                        mainMenu_MessageBox.setForeground(Color.GREEN);
                        mainMenu_MessageBox.setText("Success! Unsaved Changes!");
                    } else {
                        mainMenu_MessageBox.setForeground(Color.RED);
                        mainMenu_MessageBox.setText("Logical Error(s)!");
                    }
                } else {
                    mainMenu_MessageBox.setForeground(Color.RED);
                    mainMenu_MessageBox.setText("Invalid Input(s)!");
                }
            } else {
                if (theOHT.isInteger(addEmp_EmployeeNumber.getText().replace(" ", "")) == true && theOHT.isDouble(addEmp_DeductionsRate.getText().replace(" ", "")) == true && theOHT.isDouble(addEmp_AnnualSalary.getText().replace(" ", "")) == true) {
                    if (addEmp_FirstName.getText().matches("[a-zA-Z]+") && addEmp_LastName.getText().matches("[a-zA-Z]+") && (Double.parseDouble(addEmp_DeductionsRate.getText().replace(" ", "")) < 99.999999 && Double.parseDouble(addEmp_DeductionsRate.getText().replace(" ", "")) >= 0) && Double.parseDouble(addEmp_AnnualSalary.getText().replace(" ", "")) > 0) {
                        empNum = Integer.parseInt(addEmp_EmployeeNumber.getText().replace(" ", ""));
                        firstName = addEmp_FirstName.getText().replace(" ", "");
                        lastName = addEmp_LastName.getText().replace(" ", "");
                        sex = (String) addEmp_JComboBox_Gender.getSelectedItem();
                        workLocation = (String) addEmp_JComboBox_WorkLocation.getSelectedItem();
                        deductionRate = Double.parseDouble(addEmp_DeductionsRate.getText().replace(" ", ""));
                        annualSalary = Double.parseDouble(addEmp_AnnualSalary.getText().replace(" ", ""));
                        newEmp = new FullTimeEmployee(empNum, firstName, lastName, sex, workLocation, deductionRate, annualSalary);
                        theOHT.removeEmployee(searchEmpInput);
                        theOHT.addToTable(newEmp);
                        addEmp.dispose();
                        mainMenu_MessageBox.setForeground(Color.GREEN);
                        mainMenu_MessageBox.setText("Success! Unsaved Changes!");
                    } else {
                        mainMenu_MessageBox.setForeground(Color.RED);
                        mainMenu_MessageBox.setText("Logical Error(s)!");
                    }
                } else {
                    mainMenu_MessageBox.setForeground(Color.RED);
                    mainMenu_MessageBox.setText("Invalid Input(s)!");
                }
            }
        } else {
            mainMenu_MessageBox.setForeground(Color.RED);
            mainMenu_MessageBox.setText("Employee Number Exists!");
        }
    }//GEN-LAST:event_addEmp_JButton_EditActionPerformed

    private void addEmp_JButton_ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEmp_JButton_ResetActionPerformed
        addEmp_JRadioButton_PartTime.setSelected(false);
        addEmp_JRadioButton_FullTime.setSelected(false);
        addEmp_FirstName.setEditable(false);
        addEmp_LastName.setEditable(false);
        addEmp_JComboBox_Gender.setEnabled(false);
        addEmp_JComboBox_WorkLocation.setEnabled(false);
        addEmp_DeductionsRate.setEditable(false);
        addEmp_HourlyWage.setEditable(false);
        addEmp_HoursPerWeek.setEditable(false);
        addEmp_WeeksPerYear.setEditable(false);
        addEmp_AnnualSalary.setEditable(false);
        addEmp_EmployeeNumber.setEditable(false);
        addEmp_FirstName.setText("");
        addEmp_LastName.setText("");
        addEmp_JComboBox_Gender.setSelectedItem("");
        addEmp_JComboBox_WorkLocation.setSelectedItem("");
        addEmp_DeductionsRate.setText("");
        addEmp_HourlyWage.setText("");
        addEmp_HoursPerWeek.setText("");
        addEmp_WeeksPerYear.setText("");
        addEmp_AnnualSalary.setText("");
        addEmp_EmployeeNumber.setText("");
    }//GEN-LAST:event_addEmp_JButton_ResetActionPerformed

    private void addEmp_FirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEmp_FirstNameActionPerformed
    }//GEN-LAST:event_addEmp_FirstNameActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrame_EmpDBGUI().setVisible(true);
            }
        });

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame addEmp;
    private javax.swing.JTextField addEmp_AnnualSalary;
    private javax.swing.JTextField addEmp_DeductionsRate;
    private javax.swing.JTextField addEmp_EmployeeNumber;
    private javax.swing.JTextField addEmp_FirstName;
    private javax.swing.JTextField addEmp_HourlyWage;
    private javax.swing.JTextField addEmp_HoursPerWeek;
    private javax.swing.JButton addEmp_JButton_Cancel;
    private javax.swing.JButton addEmp_JButton_Edit;
    private javax.swing.JButton addEmp_JButton_Reset;
    private javax.swing.JButton addEmp_JButton_Save;
    private javax.swing.JComboBox<String> addEmp_JComboBox_Gender;
    private javax.swing.JComboBox<String> addEmp_JComboBox_WorkLocation;
    private javax.swing.JLabel addEmp_JLabel_AnnualDollarSign;
    private javax.swing.JLabel addEmp_JLabel_AnnualSalary;
    private javax.swing.JLabel addEmp_JLabel_DeductionsRate;
    private javax.swing.JLabel addEmp_JLabel_DeductionsRatePercent;
    private javax.swing.JLabel addEmp_JLabel_EmployeeInformation1;
    private javax.swing.JLabel addEmp_JLabel_EmployeeNumber;
    private javax.swing.JLabel addEmp_JLabel_FirstName;
    private javax.swing.JLabel addEmp_JLabel_Gender;
    private javax.swing.JLabel addEmp_JLabel_HourlyDollarSign;
    private javax.swing.JLabel addEmp_JLabel_HourlyWage;
    private javax.swing.JLabel addEmp_JLabel_HoursPerWeek;
    private javax.swing.JLabel addEmp_JLabel_LastName;
    private javax.swing.JLabel addEmp_JLabel_TypeOfEmployee;
    private javax.swing.JLabel addEmp_JLabel_WeeksPerYear;
    private javax.swing.JLabel addEmp_JLabel_WorkLocation;
    private javax.swing.JRadioButton addEmp_JRadioButton_FullTime;
    private javax.swing.JRadioButton addEmp_JRadioButton_PartTime;
    private javax.swing.JTextField addEmp_LastName;
    private javax.swing.JTextField addEmp_WeeksPerYear;
    private javax.swing.JFrame displayFrame;
    private javax.swing.JScrollPane displayTable;
    private javax.swing.JFrame editEmpSearch;
    private javax.swing.JButton editEmpSearch_Cancel;
    private javax.swing.JTextField editEmpSearch_EmpNumSearch;
    private javax.swing.JLabel editEmpSearch_JLabel_EmpNumSearch1;
    private javax.swing.JLabel editEmpSearch_JLabel_SearchEmp;
    private javax.swing.JButton editEmpSearch_Search;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPanel mainMenu;
    private javax.swing.JButton mainMenu_AddEmp;
    private javax.swing.JLabel mainMenu_BG;
    private javax.swing.JButton mainMenu_Back;
    private javax.swing.JButton mainMenu_DisplayAll;
    private javax.swing.JButton mainMenu_DisplayEmp;
    private javax.swing.JButton mainMenu_EditEmp;
    private javax.swing.JLabel mainMenu_MessageBox;
    private javax.swing.JButton mainMenu_RemoveAll;
    private javax.swing.JButton mainMenu_RemoveEmp;
    private javax.swing.JButton mainMenu_Save;
    private javax.swing.JPanel nameDB;
    private javax.swing.JLabel nameDB_BG;
    private javax.swing.JTextField nameDB_DBName;
    private javax.swing.JButton nameDB_Next;
    private javax.swing.JFrame removeEmp;
    private javax.swing.JButton removeEmp_Cancel;
    private javax.swing.JButton removeEmp_Delete;
    private javax.swing.JTextField removeEmp_EmpNum;
    private javax.swing.JLabel removeEmp_JLabel_DelEmp;
    private javax.swing.JLabel removeEmp_JLabel_EmpNumDel;
    private javax.swing.JFrame searchEmp;
    private javax.swing.JButton searchEmp_Cancel;
    private javax.swing.JTextField searchEmp_EmpNumSearch;
    private javax.swing.JLabel searchEmp_JLabel_EmpNumSearch;
    private javax.swing.JLabel searchEmp_JLabel_SearchEmp;
    private javax.swing.JButton searchEmp_Search;
    private javax.swing.JTable table_DisplayAll;
    // End of variables declaration//GEN-END:variables
}