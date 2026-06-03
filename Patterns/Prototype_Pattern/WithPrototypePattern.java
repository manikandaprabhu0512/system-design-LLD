package Patterns.Prototype_Pattern;

interface Cloneable {
   Cloneable clone();
}

class INPC implements Cloneable {
   public String name;
   public int health;
   public int attack;
   public int defense;
   
   public INPC(String name, int health, int attack, int defense) {
       // call database
       // complex calc
       this.name = name; 
       this.health = health; 
       this.attack = attack; 
       this.defense = defense;
       System.out.println("Setting up template NPC '" + name + "'");
   }
   
   // copy-constructor used by clone()
   public INPC(INPC other) {
       name = other.name;
       health = other.health;
       attack = other.attack;
       defense = other.defense;
       System.out.println("Cloning NPC '" + name + "'");
   }
   
   public Cloneable clone() {
       return new INPC(this);
   }
   
   public void describe() {
       System.out.println("NPC " + name + " [HP=" + health + " ATK=" + attack 
            + " DEF=" + defense + "]");
   }
   
   public void setName(String n) { 
       name = n;
   }
   public void setHealth(int h) { 
       health = h;
   }
   public void setAttack(int a) {
        attack = a; 
   }
   public void setDefense(int d){ 
       defense = d;
   }
}

public class WithPrototypePattern {
    public static void main(String[] args) {
       INPC alien = new INPC("Alien", 30, 5, 2);
       
       INPC alienCopied1 = (INPC)alien.clone();
       alienCopied1.describe();
       
       INPC alienCopied2 = (INPC)alien.clone();
       alienCopied2.setName("Powerful Alien");
       alienCopied2.setHealth(50);
       alienCopied2.describe();
    }
}