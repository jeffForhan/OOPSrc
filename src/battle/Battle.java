/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battle;

import java.util.Scanner;

/**
 *
 * @author Jeffrey Forhan
 */
public class Battle {

    private static Player playerChar;
    private static Enemy enemyChar;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner menuSc = new Scanner(System.in);
        
        boolean playerTurn = true;
        //Make the player and enemy objects
        playerChar = makePlayer(menuSc);
        enemyChar = makeEnemy(menuSc);
        
        //Continues the game as long as there is a player and an enemy
        while(playerChar.getAlive() && Enemy.count > 0){   
            if(playerTurn){
                makeMenu(menuSc);
                playerTurn = false;
            }else{
                enemyChar.attack(playerChar);
                playerTurn = true;
            }
        }
        menuSc.close();
    }
    /**
     * Pre: None
     * Post: The player performs the selected action
     * @param input The scanner used to get user input
     */
    public static void makeMenu(Scanner input){
        System.out.println("\n(1)Attack\\(2)Look at self\\(3)Look at enemy\\(4)Quit");
        
        int select = Integer.parseInt(input.nextLine());

        switch(select){
            case 1:
                playerChar.attack(enemyChar);
                break;
                
            case 2:
                playerChar.lookSelf();
                break;
            case 3:
                playerChar.lookOther(enemyChar);
                break;
            case 4:
                playerChar.die(enemyChar);
                break;
            default:
                System.out.println("Invalid number");
                break;
        }
    }
    /**
     * Pre: None
     * Post: Creates a player object based on user inputs
     * @param playerGen gets input from user to make the player
     * @return A Player object
     */
    public static Player makePlayer(Scanner playerGen){       
        System.out.println("Make custom player\nPress Y = yes\nPress Other = no");
        
        String result;
        result = playerGen.nextLine();
        if(result.equalsIgnoreCase("Y")){//Set instance variables based on Scanner input
            System.out.print("Enter name: ");
            String namePl = playerGen.nextLine();
            System.out.print("Enter health: ");
            int healthPl = Integer.parseInt(playerGen.nextLine());
            System.out.print("Enter damage: ");
            int dmgPl = Integer.parseInt(playerGen.nextLine());
            
            return(new Player(namePl, healthPl, dmgPl));
        }else{//Use base constructor for instance variables
            return(new Player());
        }    
    }
    /**
     * Pre: None
     * Post: Creates an enemy object based on user inputs
     * @param enemyGen Gets input from user to make the enemy
     * @return An Enemy object
     */
    public static Enemy makeEnemy(Scanner enemyGen){
        System.out.println("\nMake enemy " + (Enemy.count + 1));
        System.out.println("Make custom enemy\nPress Y = yes\nPress Other = no");
        
        String result;
        result = enemyGen.nextLine();
        if(result.equalsIgnoreCase("Y")){//Set instance variables based on Scanner input
            System.out.print("Enter name: ");
            String nameEn = enemyGen.nextLine();
            System.out.print("Enter health: ");
            int healthEn = Integer.parseInt(enemyGen.nextLine());
            System.out.print("Enter damage: ");
            int dmgEn = Integer.parseInt(enemyGen.nextLine());
            
            return(new Enemy(nameEn, healthEn, dmgEn));
        }else{//Use base constructor for instance variables
            return(new Enemy());
        }        
    }
}
