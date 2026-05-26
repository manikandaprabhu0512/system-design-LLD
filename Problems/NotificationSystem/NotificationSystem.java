package Problems.NotificationSystem;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

interface INotification {
    String getContent();
}

class SimpleNotification implements INotification {
    private String text;

    public SimpleNotification(String text) {
        this.text = text;
    }

    @Override
    public String getContent() {
        return text;
    }

}

abstract class INotificationDecorator implements INotification  {

    protected INotification notification;

    public INotificationDecorator(INotification notification) {
        this.notification = notification;
    }

}

class TimpstampDecorator extends INotificationDecorator {

    public TimpstampDecorator(INotification notification) {
        super(notification);
    }

    @Override
    public String getContent() {
        return "[" + LocalTime.now() + notification.getContent();
    }

}

class SignatureDecorator extends INotificationDecorator {
    private String sig;

    public SignatureDecorator(INotification notification, String sig) {
        super(notification);
        this.sig = sig;
    }

    @Override
    public String getContent() {
        return notification.getContent() + sig;
    }
    
}

interface IObserver {
    void update();
}

interface IObservable {
    void addObserver(IObserver ob);
    void removeObserver(IObserver ob);
    void notifyObserver(); 
}

class NotificationObservable implements IObservable {
    private List<IObserver> observers = new ArrayList<>();
    private INotification notification;

    @Override
    public void addObserver(IObserver ob) {
        observers.add(ob);
    }

    @Override
    public void removeObserver(IObserver ob) {
        observers.remove(ob);
    }

    @Override
    public void notifyObserver() {
        for(IObserver ob : observers) {
            ob.update();
        }
    }

    public void setNotification(INotification notification) {
        this.notification = notification;
        notifyObserver();
    }

    public INotification getNotification() {
        return notification;
    }

    public String getContent() {
        return notification.getContent();
    }
    
}

class NotificationService {
    private NotificationObservable observable;
    private static NotificationService instance = null;
    private List<INotification> notifications = new ArrayList<>();

    private NotificationService() {
        observable = new NotificationObservable();
    }

    public static NotificationService getInstance() {
        if (instance == null) {
            instance = new NotificationService();
        }
        return instance;
    }

    public NotificationObservable getObservable() {
        return observable;
    }

    public void sendNotification(INotification notification) {
        notifications.add(notification);
        observable.setNotification(notification);
    }
}

class Logger implements IObserver {
    private NotificationObservable observable;

    public Logger() {
        this.observable = NotificationService.getInstance().getObservable();
        observable.addObserver(this);
    }

    public Logger(NotificationObservable observable) {
        observable.addObserver(this);
        this.observable = observable;
    }

    @Override
    public void update() {
        System.out.println("Logging New Notification : \n" + observable.getContent());
    }
}

interface INotificationStrategy {
    void sendNotification(String content);
}

class EmailStrategy implements INotificationStrategy {
    private String emailId;

    public EmailStrategy(String emailId) {
        this.emailId = emailId;
    }

    public void sendNotification(String content) {
        System.out.println("Sending email Notification to: " + emailId + "\n" + content);
    }
}

class SMSStrategy implements INotificationStrategy {
    private String mobileNumber;

    public SMSStrategy(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void sendNotification(String content) {
        System.out.println("Sending SMS Notification to: " + mobileNumber + "\n" + content);
    }
}

class PopUpStrategy implements INotificationStrategy {
    public void sendNotification(String content) {
        System.out.println("Sending Popup Notification: \n" + content);
    }
}

class NotificationEngine implements IObserver {
    private NotificationObservable notificationObservable;
    private List<INotificationStrategy> notificationStrategies = new ArrayList<>();

    public NotificationEngine() {
        this.notificationObservable = NotificationService.getInstance().getObservable();
        notificationObservable.addObserver(this);
    }

    public NotificationEngine(NotificationObservable observable) {
        this.notificationObservable = observable;
    }

    public void addNotificationStrategy(INotificationStrategy ns) {
        this.notificationStrategies.add(ns);
    }

    public void update() {
        String notificationContent = notificationObservable.getContent();
        for (INotificationStrategy strategy : notificationStrategies) {
            strategy.sendNotification(notificationContent);
        }
    }
}

public class NotificationSystem {
    public static void main(String[] args) {

        NotificationService notificationService = NotificationService.getInstance();

        Logger logger = new Logger();

        NotificationEngine notificationEngine = new NotificationEngine();

        notificationEngine.addNotificationStrategy(new EmailStrategy("random.person@gmail.com"));
        notificationEngine.addNotificationStrategy(new SMSStrategy("+91 9876543210"));
        notificationEngine.addNotificationStrategy(new PopUpStrategy());

        INotification notification = new SimpleNotification(" Your order has been shipped!");
        notification = new TimpstampDecorator(notification);
        notification = new SignatureDecorator(notification, " Customer Care");

        notificationService.sendNotification(notification);
    }
}
