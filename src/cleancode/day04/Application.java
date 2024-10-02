package cleancode.day04;

public class Application {

    public static void main(String[] args) {

        Application app = new Application();

//        Order order01 = new Order(null, new Customer());
//        app.validateOrder(order01);
//        app.validateOrder(order01);

//        List<Item> item02 = List.of(new Item(0), new Item(0), new Item(0));
//        Order order02 = new Order(item02, new Customer());
//        app.validateOrder(order02);

//        List<Item> item03 = List.of(new Item(10), new Item(20), new Item(30));
//        Order order03 = new Order(item03, null);
//        app.validateOrder(order03);

//        List<Item> item04 = List.of(new Item(10), new Item(20), new Item(30));
//        Order order04 = new Order(item04, new Customer());
//        app.validateOrder(order04);
    }

    public void validateOrder(Order order) {
        order.validate();
    }
}
