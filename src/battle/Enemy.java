
package battle;

/**
 *
 * @author Jeffrey Forhan
 */
public class Enemy extends Character{
    //How many enemies are alive
    public static int count;
    /**
     * Pre: None
     * Post: Sets the base stats and name for the enemy, and increments the count
     */
    Enemy(){
        count ++;
        setName("Smelly Troll");
        setHealth(5);
        setDamage(2);
    }
    /**
     * Pre: None
     * Post: Creates the enemy object
     * @param name The enemy's name
     * @param health The enemy's health
     * @param damage The enemy's damage
     */
    Enemy(String name, int health, int damage){
        count ++;
        setName(name);
        setHealth(health);
        setDamage(damage);
    }
    /**
     * Pre: enemy attacks player
     * Post: player is damaged
     * @param other The player that is being attacked
     */
    public void attack(Character other){
        other.setHealth(other.getHealth() - getDamage());
        System.out.println(getName() + " strikes fiercely at " + other.getName() + ", reducing his health to " + other.getHealth());
        if(other.getHealth() <= 0){
            other.die(this);
        }
    }
    /**
     * Pre: This object's health is reduced to 0
     * Post: The enemy count is decremented, and a message is displayed notifying the player of the death
     * @param other the player who has killed this enemy
     */
    public void die(Character other){
        count --;
        System.out.println(other.getName() + " has slain " + getName() + ". There are " + count + " enemies left.\n");
        if(count == 0){
            other.win();
        }
    }
    /**
     * Pre: The player's health has been reduced to 0
     * Post: A message displays that the enemy has won
     */
    public void win(){
        System.out.println(getName() + " has won! The hero has lost!\n"
                + "With his last dying breath, the hero utters his immortal words: \"I am slain\"");
    }
}
