装饰（Decorator）模式中的角色：
抽象构件（Component）角色 ：定义一个抽象接口以规范准备接收附加责任的对象。
具体构件（Concrete Component）角色 ：实现抽象构件，通过装饰角色为其添加一些职责。
抽象装饰（Decorator）角色 ： 继承或实现抽象构件，并包含具体构件的实例，可以通过其子
类扩展具体构件的功能。
具体装饰（ConcreteDecorator）角色 ：实现抽象装饰的相关方法，并给具体构件对象添加附 加的责任。