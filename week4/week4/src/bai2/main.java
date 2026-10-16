package bai2;

class ActionCharacter{
    public void fight(){
        System.out.println("Dam boc...");
    }
}
class Hero extends ActionCharacter implements CanFight,CanSwim,CanFly{
    @Override
    public void swim(){
        System.out.println("Boi boi...");
    }
    @Override
    public void fly(){
        System.out.println("Bay bay...");
    }
}

public class main {
    public static void main(String[] args){
        Hero hero = new Hero();
        CanSwim canSwim = (CanSwim) hero;
        canSwim.swim();
        CanFight canFight = (CanFight) canSwim;
        canFight.fight();
    }
}
