//Roneil Harris
//9/12/2018
//Assignment #1

import java.util.Stack;
import java.io.*;
import java.lang.String;


public class Assignment1
{
    static double evaluatePostfix(String exp)
    
    {
        Stack<Double> stack = new Stack<>();
                
        for(int i = 0; i< exp.length(); i++)
        {
            char c = exp.charAt(i);
 
            if(Character.isDigit(c))
            {            	
            	String tok = " ";	//use a string for to push tokens to stack
            	tok = tok + (c - '0'); 
            	
            	while(Character.isDigit(c = exp.charAt(i+1)) || ('.' == c))
            	{       

            		   	if(c == '.')			//can't subtract 0 from a decimal point
            		   		tok = tok + '.';
            		   	
            		   	else
            		   		tok = tok + (c - '0');
            		   	i++;
	            }
            	//System.out.println(tok);
            	stack.push((Double.parseDouble(tok)));	//if next character is not a digit, push token
            	
            }
            
            
            else
            {
                double val1;
                double val2;
                 
                switch(c)
                {
                    case '+':
                    val1 = stack.pop();
                    val2 = stack.pop();    
                    stack.push(val2+val1);
                    break;
                     
                    case '-':
                    val2 = stack.pop();
                    val1 = stack.pop();        
                    stack.push(val1- val2);
                    break;
                     
                    case '/':
                    val2 = stack.pop();
                    val1 = stack.pop();        
                    stack.push(val1/val2);
                    break;
                     
                    case '*':
                    val1 = stack.pop();
                    val2 = stack.pop();        
                    stack.push(val2*val1);
                    break;
                    
                    case '^':
                    int j = 0;       
                    double hold = 1;
                    
                    val2 = stack.pop();
                    val1 = stack.pop();
                                      
                    while(j < val2)
                    {
                        hold = hold * val1;  
                        j++;
                    }
                    stack.push(hold);
                    break;
                    
                    case '#':
                    val1 = stack.pop();
                    stack.push(Math.sqrt(val1));
                    break;
                    
                    case '_':
                    val1 = stack.pop();    
                    stack.push(val1 * (-1));
                    break;                           
              }
            }
        }
        return stack.pop(); 
        
    }
     
    public static void main(String[] args)
    {
        System.out.println("Hello! This is a postfix expression calculator.");
         try {
             BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\roneh\\Desktop\\New Paltz\\Fall 18\\Computer Science 3\\src\\in.dat"));
             String exp;
             
             while ((exp = in.readLine()) != null) {
                 System.out.println("The value of: " + exp + " is:");
                 System.out.println(evaluatePostfix(exp));
             }
             in.close();
             
          } catch (IOException e) {
          }
        
    }
}
