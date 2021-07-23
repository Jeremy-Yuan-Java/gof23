
import java.util.HashMap;

public class FlyWeightClient {
    public static void main(String[] args) {
        AbstractBox l = BoxFactory.getInstance().getBox("L");
        l.display("绿");
    }
}


class BoxFactory {
    private static HashMap<String, AbstractBox> map;


    private BoxFactory() {
        map = new HashMap<String, AbstractBox>();
        AbstractBox iBox = new IBox();
        AbstractBox lBox = new LBox();
        AbstractBox oBox = new OBox();
        map.put("I", iBox);
        map.put("L", lBox);
        map.put("O", oBox);
    }

    public static final BoxFactory getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final BoxFactory INSTANCE = new BoxFactory();
    }

    public AbstractBox getBox(String key) {
        return map.get(key);
    }
}

abstract class AbstractBox {
    public abstract String getShape();

    public void display(String color) {
        System.out.println("方块形状：" + this.getShape() + " 颜色：" + color);
    }
}


class IBox extends AbstractBox {
    @Override
    public String getShape() {
        return "I";
    }
}

class LBox extends AbstractBox {
    @Override
    public String getShape() {
        return "L";
    }
}

class OBox extends AbstractBox {
    @Override
    public String getShape() {
        return "O";
    }
}


