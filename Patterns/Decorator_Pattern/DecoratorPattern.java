package Patterns.Decorator_Pattern;

interface Character {
    String getAblities();
}

class Mario implements Character {
    @Override
    public String getAblities() {
        return "Mario";
    }
}

abstract class CharacterDecorator implements Character {
    protected Character character;

    public CharacterDecorator(Character c) {
        this.character = c;
    }
}

class HeightUp extends CharacterDecorator{

    public HeightUp(Character c) {
        super(c);
    }

    @Override
    public String getAblities() {
        return character.getAblities() + " with HeightUp";
    }
    
}

class GunPower extends CharacterDecorator {

    public GunPower(Character c) {
        super(c);
    }

    @Override
    public String getAblities() {
        return character.getAblities() + " with GunPower";
    }
    
}

class StarPower extends CharacterDecorator {

    public StarPower(Character c) {
        super(c);
    }

    @Override
    public String getAblities() {
        return character.getAblities() + " with StarPower";
    }
    
}

public class DecoratorPattern {
    public static void main(String[] args) {
        Character mario = new Mario();
        System.out.println("Basic Character: " + mario.getAblities());

        mario = new HeightUp(mario);
        System.out.println("After HeightUp" + mario.getAblities());

        mario = new GunPower(new StarPower(mario));
        System.out.println("After Gun + Star Powerup " + mario.getAblities());

    }
}
