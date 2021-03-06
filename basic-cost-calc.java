/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classjavafiles;
import java.util.Scanner;

/**
 *
 * @author monikabhatt
 */
public class Assignment1b {
    
    public static void main(String args[]){
        Scanner scan=new Scanner(System.in);
        System.out.println("Welcome to the Annual Australian Book Festival\n");
        
        //Calling the promptUser method which returns the value of the total sales
        // in the session
        
        System.out.println("Total sales in this session: $" + promptUser(scan) + "\n");
        System.out.println("Goodbye!");
    }
    
//Declaring the promptUser function which calls the enterValues method until the user
//decides to quit, adds the value of each individual sale calculation and returns
// the value of the final totalSales of a user session
    
static int promptUser(Scanner scan){
        char repeat = 'y';
        int totalSales=0, individualSale=0;
        do{
            // Calling the enterValues method which returns the sum of sales for 
            //large hardback books, small print hardback books and softcover books
            //and saving the invidual sale value into the individualSale variable
            
            individualSale=enterValues(scan);
            
            // Incrementally adding the value to individualSale to totalSales to
            //calculate the totalSales until the user decides to quit entering
            //the program
            
            System.out.println("Your total bill is : $" + individualSale + "\n");
            totalSales=totalSales + individualSale;
            char rep='y';
            do{
                try{
                    System.out.println("Would you like to calculate another bill (y/n)? \n");
                    repeat=scan.next().trim().charAt(0);
                    if((repeat!='y') && (repeat!='n')){
                        System.out.println("Enter a valid input");
                    }
                    else if (repeat == 'n' || repeat == 'y'){
                        break;
                    }
                }
                catch(Exception e){
                    System.out.println("Enter a valid input");
                    scan.next();
                }
            }
            while(rep=='y');
        }
        while(repeat=='y');
        
        // return the value of totalSales to the main function
        return totalSales;        
}

//Declaring the enterValues method which allows user to enter the number of
//large hardback books, small print hardback books and softcover books purchased
//adds the 
    
static int enterValues(Scanner scan){
    
    char repeat='y';
    int largePrint = 0, smallPrint =0 , softCover = 0;
    
    System.out.println("Enter the number of large print hardbacks book purchased");
    do{
        try{
            largePrint = scan.nextInt();
            if(largePrint<0){
               System.out.println("Enter a positive value or 0");
            }
            else{
                repeat='n';
            }
        }
        catch(Exception e){
                System.out.println("Enter a valid, integer value");
                scan.next();
        }
    }
    while(repeat=='y');
    
    System.out.println("Enter the number of small print hardbacks book purchased");
    
    repeat='y';
    
    do{
        try{
            smallPrint = scan.nextInt();
            if(smallPrint<0){
               System.out.println("Enter a positive value or 0");
            }
            else{
                repeat='n';
            }
        }
        catch(Exception e){
                System.out.println("Enter a valid, integer value");
                scan.next();
        }
    }
    while(repeat=='y');
    
    System.out.println("Enter the number of softcover print hardbacks book purchased");
    
    repeat='y';
    
    do{
        try{
            softCover = scan.nextInt();
            if(softCover<0){
               System.out.println("Enter a positive value or 0");
            }
            else{
                repeat='n';
            }
        }
        catch(Exception e){
                System.out.println("Enter a valid, integer value");
                scan.next();
        }
    }
    while(repeat=='y');
    
    return (int) (largeCalc(largePrint) + smallCalc(smallPrint) + softCalc(softCover));
}

//Declaring the largeCalc method which returns the cost of the number of large
//print hardback books purchased

static int largeCalc(int largePrint){
    return (int) ((((int)(largePrint/3))*40) + ((largePrint%3)*20));
}

//Declaring the smallCalc method which returns the cost of the number of small
//print hardback books purchased

static int smallCalc(int smallPrint){
    return (int) ((((int)(smallPrint/2))*15) + ((smallPrint%2)*10));
}

//Declaring the softCalc method which returns the cost of the number of softcover
//books purchased

static int softCalc(int softCover){
    return (int) ((((int)(softCover/4))*10) + ((softCover%4)*5));
}
}
