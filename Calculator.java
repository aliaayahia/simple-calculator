/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studycase;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author (Aliaa Yahia )
 */
public class Calculator extends JPanel implements ActionListener{
    private  JPanel p1;
    private JButton [] numbers;
    private JButton []  opp;
    private JTextField t1;
    private GridBagLayout grid;
    private GridBagConstraints constraints;
    private double num1,num2,result;
    private int operation=0;
    private int[][] numConst=new int[][]{
        {0,5,2,1},
        {0,4,1,1},
        {1,4,1,1},
        {2,4,1,1},    
        {0,3,1,1},
        {1,3,1,1},
        {2,3,1,1},
        {0,2,1,1},
        {1,2,1,1},
        {2,2,1,1}
};
    private int[][] oppConst=new int[][]{
        {2,5,1,1},
        {3,4,1,2},
        {3,3,1,1},
        {3,2,1,1},    
        {0,1,1,1},
        {3,1,1,1},
        {2,1,1,1},
        {1,1,1,1}
};
    public Calculator() {
        grid=new GridBagLayout();
        p1=new JPanel();
        p1.setLayout(grid);
        //intializing butons
        numbers=new JButton[10];
        constraints=new GridBagConstraints();
        for(int i=0;i<numbers.length;i++){
            numbers[i]=new JButton(""+i);
            numbers[i].addActionListener(this);
            constraints.gridx=numConst[i][0];
            constraints.gridy=numConst[i][1];
            constraints.gridwidth=numConst[i][2];
            constraints.gridheight=numConst[i][3];
            constraints.fill=constraints.BOTH;
            constraints.insets=new Insets(2, 2, 2, 2);
            p1.add(numbers[i],constraints);
        }
        
        opp=new JButton[8];
        opp[0]=new JButton(".");
        opp[0].addActionListener(this);
        opp[1]=new JButton("=");
        opp[1].addActionListener(this);
        opp[2]=new JButton("+");
        opp[2].addActionListener(this);
        opp[3]=new JButton("-");
        opp[3].addActionListener(this);
        opp[4]=new JButton("%");
        opp[4].addActionListener(this);
        opp[5]=new JButton("*");
        opp[5].addActionListener(this);
        opp[6]=new JButton("c");
        opp[6].addActionListener(this);
        opp[7]=new JButton("+/-");
        opp[7].addActionListener(this); 
        
        for (int i=0;i<oppConst.length;i++){
            constraints.gridx=oppConst[i][0];
            constraints.gridy=oppConst[i][1];
            constraints.gridwidth=oppConst[i][2];
            constraints.gridheight=oppConst[i][3];
            constraints.fill=constraints.BOTH;
            constraints.insets=new Insets(2, 2, 2, 2);
            p1.add(opp[i],constraints);
        }
        //text 
        t1=new JTextField();
        t1.setEditable(false);
        constraints.gridx=0;
        constraints.gridy=0;
        constraints.gridwidth=4;
        constraints.gridheight=1;
        constraints.fill=constraints.BOTH;
        t1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        t1.setFont(new Font("Arial", Font.PLAIN, 24));
        p1.add(t1, constraints);
        
        JFrame frame=new JFrame("Calculator");
        frame.setContentPane(p1);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<numbers.length;i++){
            if(e.getSource()==numbers[i]){
                t1.setText(t1.getText()+i);
                
            }
            
        }
        if(e.getSource()==opp[0]&& !(t1.getText().contains("."))){
            t1.setText(t1.getText()+".");
        }
        if(e.getSource()==opp[7]){
            t1.setText(""+-1*Double.parseDouble(t1.getText()));
        }
        if(e.getSource()==opp[6]){
            t1.setText("");
        }
        //+
        if(e.getSource()==opp[2]){
            num1=Double.parseDouble(t1.getText());
            operation=1;
            t1.setText("");
        }
        //-
        else if(e.getSource()==opp[3]){
            num1=Double.parseDouble(t1.getText());
            operation=2;
            t1.setText("");
        }
        //%
        else if(e.getSource()==opp[4]){
            num1=Double.parseDouble(t1.getText());
            operation=3;
            t1.setText("");
        }
        //*
        else if(e.getSource()==opp[5]){
            num1=Double.parseDouble(t1.getText());
            operation=4;
            t1.setText("");
        }
        
        //=
        if(e.getSource()==opp[1]){
            num2=Double.parseDouble(t1.getText());
            switch(operation){
                
                case 1 :
                    result= num1+num2;
                    t1.setText(""+result);
                    operation=0;
                    break;
                case 2 : 
                    result= num1-num2;
                    t1.setText(""+result);
                    operation=0;
                    break;
                case 3 :
                    result= num1/num2;
                    t1.setText(""+result);
                    operation=0;
                    break;
                case 4 : 
                    result= num1*num2;
                    t1.setText(""+result);
                    operation=0;
                    break;
            }
            
        }
    }
    
    
}
