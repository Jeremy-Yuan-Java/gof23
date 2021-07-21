public class BuilderClient {
    public static void main(String[] args) {
        Director director = new Director(new MobikeBuilder());
        System.out.println(director.construct().equals(director.construct()));
        System.out.println(director.construct());

    }
}

class Bike {
    private String frame;
    private String seat;

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "frame='" + frame + '\'' +
                ", seat='" + seat + '\'' +
                '}';
    }
}

abstract class Builder {
    protected Bike bike = new Bike();

    public abstract void builderFrame();

    public abstract void builderSeat();

    public abstract Bike createBike();
}

class MobikeBuilder extends Builder {

    @Override
    public void builderFrame() {
        bike.setFrame("铝合金车架");
    }

    @Override
    public void builderSeat() {
        bike.setSeat("真皮车座");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}

class OfoBuilder extends Builder{

    @Override
    public void builderFrame() {
        bike.setFrame("碳钎维车架");
    }

    @Override
    public void builderSeat() {
        bike.setSeat("橡胶车架");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}

/**
 * 指挥者类
 */
class Director{
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public Bike construct(){
        builder.builderFrame();
        builder.builderSeat();
        return builder.createBike();
    }
}