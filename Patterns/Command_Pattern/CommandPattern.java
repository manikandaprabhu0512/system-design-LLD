package Patterns.Command_Pattern;

interface Command {
    void execute();
    void undo();
}

class Light {
    public void on() {
        System.out.println("Light is on!");
    }

    public void off() {
        System.out.println("Light is off!");
    }
}

class Fan {
    public void on() {
        System.out.println("Fan is on!");
    }

    public void off() {
        System.out.println("Fan is off!");
    }
}

class LightCommand implements Command {
    private Light light;

    public LightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}

class FanCommand implements Command {
    private Fan fan;

    public FanCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.on();
    }

    @Override
    public void undo() {
        fan.off();
    }
}

class RemoteController {
    private final static int numButtons = 4;
    private Command[] buttons;
    private boolean[] buttonsPressed;

    public RemoteController() {
        buttons = new Command[numButtons];
        buttonsPressed = new boolean[numButtons];

        for(int i = 0; i < numButtons; i++) {
            buttons[i] = null;
            buttonsPressed[i] = false;
        }
    }

    public void setCommand(int idx, Command cmd) {
        if (idx >= 0 && idx < numButtons) {
            buttons[idx] = cmd;
            buttonsPressed[idx] = false;
        }
    }

    public void pressButton(int idx) {
        if (idx >= 0 && idx < numButtons && buttons[idx] != null) {
            if (!buttonsPressed[idx]) {
                buttons[idx].execute();
            } else {
                buttons[idx].undo();
            }
            buttonsPressed[idx] = !buttonsPressed[idx];
        } else {
            System.out.println("No command assigned at button " + idx);
        }
    }
}


public class CommandPattern {
    public static void main(String[] args) {
        Light light = new Light();
        Fan fan = new Fan();

        RemoteController controller = new RemoteController();
        controller.setCommand(0, new LightCommand(light));
        controller.setCommand(1, new FanCommand(fan));

        System.out.println("Toggling Light Button");
        controller.pressButton(0);
        controller.pressButton(0);

        System.out.println("Toggling Fan Button");
        controller.pressButton(1);
        controller.pressButton(1);
        
        System.out.println("Pressing wrong buttons");
        controller.pressButton(2);
    }
}
