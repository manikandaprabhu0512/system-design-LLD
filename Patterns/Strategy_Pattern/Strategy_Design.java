interface WalkableRobot{
    void walk();
}

class NormalWalk implements WalkableRobot {
    @Override
    public void walk() {
        System.out.println("Normal Walking...");
    }
}

class NoWalk implements WalkableRobot {
    @Override
    public void walk() {
        System.out.println("No Walking...");
    }
}

interface TalkableRobot{
    void talk();
}

class NormalTalk implements TalkableRobot {
    @Override
    public void talk() {
        System.out.println("Normal Talking...");
    }
}

class NoTalk implements TalkableRobot {
    @Override
    public void talk() {
        System.out.println("No Talking...");
    }
}

interface FlyableRobot{
    void fly();
}

class NormalFly implements FlyableRobot {
    @Override
    public void fly() {
        System.out.println("Normal Flying...");
    }
}

class NoFly implements FlyableRobot {
    @Override
    public void fly() {
        System.out.println("No Flying...");
    }
}

abstract class Robot{
    WalkableRobot walk;
    TalkableRobot talk;
    FlyableRobot fly;

    Robot(WalkableRobot walk, TalkableRobot talk, FlyableRobot fly) {
        this.walk = walk;
        this.talk = talk;
        this.fly = fly;
    }

    void walk() {
        walk.walk();
    }

    void talk() {
        talk.talk();
    }

    void fly() {
        fly.fly();
    }

    public abstract void projection();
}

class CompainionRobot extends Robot {
    public CompainionRobot(WalkableRobot w, TalkableRobot t, FlyableRobot f){
        super(w, t, f);
    }

    public void projection() {
        System.out.println("Displaying friendly companion features...");
    }
}

class WorkerRobot extends Robot {
    public WorkerRobot(WalkableRobot w, TalkableRobot t, FlyableRobot f){
        super(w, t, f);
    }

    public void projection() {
        System.out.println("Displaying worker efficiency stats...");
    }
}

public class Strategy_Design {
    public static void main(String[] args) {
        Robot robo1 = new CompainionRobot(new NormalWalk(), new NoTalk(), new NormalFly());
        robo1.walk();
        robo1.fly();
        robo1.talk();
        robo1.projection();

        Robot robo2 = new WorkerRobot(new NoWalk(), new NormalTalk(), new NormalFly());
        robo2.walk();
        robo2.fly();
        robo2.talk();
        robo2.projection();
    }
}
