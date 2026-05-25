package Patterns.Observer_Pattern;

import java.util.ArrayList;
import java.util.List;

interface ISubscriber {
    void update();
}

interface IChannel {
    void addSubscriber(ISubscriber subscriber);
    void removeSubscriber(ISubscriber subscriber);
    void notifySubscribers();
}

class Channel implements IChannel {
    private List<ISubscriber> subscribers;
    private String name;
    private String lastVideo;

    public Channel(String name) {
        this.name = name;
        this.subscribers = new ArrayList<>();
    }

    @Override
    public void addSubscriber(ISubscriber subscriber) {
        if(!subscribers.contains(subscriber)) subscribers.add(subscriber);
    }

    @Override
    public void removeSubscriber(ISubscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers() {
        for(ISubscriber subscriber : subscribers) {
            subscriber.update();
        }
    }

    public void uploadVideo(String lastVideo) {
        this.lastVideo = lastVideo;
        notifySubscribers();
    }

    public String getVideoData() {
        return "Checkout out latest video: " + lastVideo + "\n";
    }
}

class Subscriber implements ISubscriber {
    private String name;
    private Channel channel;

    public Subscriber(String name, Channel channel) {
        this.name = name;
        this.channel = channel;
    }

    @Override
    public void update() {
        System.out.println("Hey " + name + ", " + channel.getVideoData());
    }
}

public class ObserverDesignPattern {
    public static void main(String[] args) {
        Channel ch1 = new Channel("Manikanda's Channel");

        Subscriber s1 = new Subscriber("Elan", ch1);
        Subscriber s2 = new Subscriber("Nivi", ch1);

        ch1.addSubscriber(s1);
        ch1.addSubscriber(s2);

        ch1.uploadVideo("Wheels on the bus go round and round!!");
        
        ch1.removeSubscriber(s2);

        ch1.uploadVideo("Old M'cdonals E-I-E-I-O");
    }
}