
package battle;

import java.util.Scanner;

/**
 *
 * @author Jeffrey Forhan
 */
public class Player extends Character{
    
    private boolean alive = true;
    /**
     * Pre: None
     * Post Base stats and name are set for the player
     */
    public Player(){
        setName("Leeeeeroy Jenkins");
        setHealth(10);
        setDamage(6);
    }
    /**
     * Pre: None
     * Post: Stats and name of the player is set
     * @param name The player's name
     * @param health The player's health
     * @param damage The player's damage
     */
    public Player(String name, int health, int damage){
        setName(name);
        setHealth(health);
        setDamage(damage);
    }
    /**
     * Pre: The player's turn is starting
     * Post: Stops the program from continuing
     * @return If the player's health is greater than 0
     */
    public boolean getAlive(){
        return(alive);
    }

    /**
     * Pre: The player chooses to attack
     * Post: The enemy being attacked is damaged
     * @param other the enemy being attacked
     */
    public void attack(Character other){
        other.setHealth(other.getHealth() - getDamage());
        System.out.println(getName() + " swings his sword mightily. " + other.getName() + " now has " + other.getHealth() + " health.\n");
        if(other.getHealth() < 0){
            System.out.println("Yes, " + other.getName() + " was hit so incredibly hard that his health is negative.\n");
            other.die(this);
        }else if (other.getHealth() == 0){
            other.die(this);
        }
    }
    /**
     * Pre: Player selects to look at self from the menu
     * Post: player receives a description of himself
     */
    public void lookSelf(){
        System.out.println("You are the brave " + getName() + ". You boast a strength of " + getDamage() + ", and a vigor of " 
                + getHealth() + ": truly a force to be reckoned with.\n");
    }
    /**
     * Pre: Player selects to view the enemy
     * Post: Player receives the enemy's description
     * @param other The character being observed
     */
    public void lookOther(Character other){
        System.out.println("The opponent faces you. He looks menacing. Using your battle expertise, you estimate that he has a health of " 
                + other.getHealth() + ", and a strength of " + other.getDamage() + ".\nYou notice that he also wears a name tag that says: Hi, my name is " 
                + other.getName() + " and I have a strength of " + other.getDamage() + ", and a health of " + other.getHealth() + ". Nice to meet you!\n");
    }
    /**
     * Pre: the player's health is 0
     * Post: The player loses
     * @param other the character that has killed this player
     */
    public void die(Character other){
        System.out.println("The hero has been vanquished by " + other.getName());
        alive = false;
        other.win();
    }
    /**
     * Pre: all enemies are dead
     * Post: The player wins
     */
    public void win(){
        System.out.println("Hurrah! The hero has vanquished the monster!");
    }
}
