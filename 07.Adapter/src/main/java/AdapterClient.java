/**
 * 定义一个适配器类来实现当前系统的业务接口，同时又继承现有组件库中已经存在的组件。
 */
public class AdapterClient {
    public static void main(String[] args) {
        Computer computer = new Computer();
        ClassSDAdapterTF adapter = new ClassSDAdapterTF();
        System.out.println(computer.readSD(adapter));

        ObjectSDAdapterTF objectSDAdapterTF = new ObjectSDAdapterTF(new TFCardImpl());
        System.out.println( computer.readSD(objectSDAdapterTF));

    }
}

class ObjectSDAdapterTF implements SDCard{

    private TFCard tfCard;

    public ObjectSDAdapterTF(TFCard tfCard) {
        this.tfCard = tfCard;
    }

    @Override
    public String readSD() {
        System.out.println("adapter read tf card ");
        return tfCard.readTF();
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("adapter read tf card ");
        tfCard.writeTF(msg);
    }
}

/**
 * 类适配器
 */
class ClassSDAdapterTF extends TFCardImpl implements SDCard{

    @Override
    public String readSD() {
        System.out.println("adapter read tf card ");
        return readTF();
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("adapter read tf card ");
        writeTF(msg);
    }
}

class Computer {
    public String readSD(SDCard sdCard) {
        if (sdCard == null) {
            throw new NullPointerException("sd card null");
        }
        return sdCard.readSD();
    }
}


interface SDCard { //读取SD卡方法
    String readSD();

    //写入SD卡功能
    void writeSD(String msg);
}

// SD卡实现类
class SDCardImpl implements SDCard {
    public String readSD() {
        String msg = "sd card read a msg :hello word SD";
        return msg;
    }

    public void writeSD(String msg) {
        System.out.println("sd card write msg : " + msg);
    }
}


interface TFCard {
    //读取TF卡方法

    String readTF();

    //写入TF卡功能
    void writeTF(String msg);
}

class TFCardImpl implements TFCard {
    public String readTF() {
        String msg = "tf card read msg : hello word tf card";
        return msg;
    }

    public void writeTF(String msg) {
        System.out.println("tf card write a msg : " + msg);
    }
}


