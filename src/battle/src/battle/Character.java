
package battle;

/**
 *
 * @author Jeffrey Forhan
 */
abstract class Character {
    private int health;
    private int damage;
    private String name;
    
    abstract void attack(Character other);
    abstract void die(Character other);
    abstract void win();
    /**
     * pre: character selects name change option
     * post: name is changed to a new string
     * @param newName the new name input
     */
    public void setName(String newName){
        name = newName;
    }
    /**
     * pre: None
     * post: Returns the name of Character object
     * @return the name
     */
    public String getName(){
        return(name);
    }
    /**
     * pre: None
     * post: Sets the health to the input value
     * @param vit the input number of health that the character has
     */
    public void setHealth(int vit){
        health = vit;
    }
    /**
     * pre: None
     * post: Returns the Character's current health
     * @return the character's health
     */
    public int getHealth(){
        return(health);
    }
    /**
     * pre: None
     * post: Gives the character a damage output
     * @param str the damage it will deal
     */
    public void setDamage(int str){
        damage = str;
    }
    /**
     * pre: None
     * post: Returns the damage value
     * @return the damage dealt
     */
    public int getDamage(){
        return(damage);
    }
    
}
