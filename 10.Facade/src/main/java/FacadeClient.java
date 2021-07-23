public class FacadeClient {
    public static void main(String[] args) {
        SmartAppliancesFacade smartAppliancesFacade = new SmartAppliancesFacade();
        smartAppliancesFacade.say("打开");

    }
}

class Light {
    public void on() {
        System.out.println("开灯");
    }
    public void off() {
        System.out.println("关灯");
    }
}

class TV {
    public void on() {
        System.out.println("开电视");
    }
    public void off() {
        System.out.println("关电视");
    }
}


class AirCondition {
    public void on() {
        System.out.println("开空调");
    }
    public void off() {
        System.out.println("关空调");
    }
}

class SmartAppliancesFacade {
    private Light light;
    private TV tv;
    private AirCondition airCondition;

    public SmartAppliancesFacade() {
        light = new Light();
        tv = new TV();
        airCondition = new AirCondition();
    }

    public void say(String message) {
        if (message.contains("打开")) {
            on();
        }else if (message.contains("关闭")) {
            on();
        } else {
            System.out.println("听不懂");
        }
    }

    private void on() {
        System.out.println("起床了");
        light.on();
        tv.on();
        airCondition.on();
    }

    private void off() {
        System.out.println("睡觉了");
        light.off();
        tv.off();
        airCondition.off();
    }
}