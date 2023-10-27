//package bank;
//
//
//import java.util.List;
//
//public abstract class Shop {
//
//    protected Point point = buildPoint();
//
//    protected List<String> staff = Staff.hireEmployees();
//
//    protected final String pointId;
//    private final SmsServiceImpl smsService;
//
//    protected Client client = ClientUtils.currentClient();
//
//    private Order order;
//
//    public Shop(SmsServiceImpl smsService) {
//        this.pointId =  "poin-123";
//        this.smsService = smsService;
//    }
//
//    public void order(Order order, double amount, String currency) {
//        order.documents.passport.seriesAndNumber.validate();
//        client.balance += -amount;
//
//        if (order.type == "type1") {
//            // do something
//        } else if (order.type == "type2") {
//            // do another thing
//        } else if (order.type == "type3") {
//            // do other thingы
//        }
//        // добавить начисление бонуса сотруднику
//        // TODO найти сотрудника по order.getEmployeeId() и прибавить 500 руб
//        this.order = order;
//        // ...
//        this.notifyEmail(order.name);
//    }
//
//    //null - если еще не сделали заказ
//    public Order getOrder() {
//        return this.order;
//    }
//
//    public abstract Point buildPoint();
//
//    // invoked on every frame update on UI
//    public UIPointInfo render() {
//        UIPointInfo uiPointInfo = new UIPointInfo();
//        uiPointInfo.setPointInfo(generatePointInfo());
//        // ...
//
//        return uiPointInfo;
//    }
//
//    public PointInfo generatePointInfo() {
//        PointInfo pointInfo = new PointInfo();
//        // ...
//
//        return pointInfo;
//    }
//
//    protected void notifyEmail(String email) {
//        this.smsService.send("Заказ №" + this.order.id + " " + email);
//    }
//}
//
// class GadgetShop extends Shop {
//
//    public GadgetShop(SmsServiceImpl smsService) {
//        super(smsService);
//    }
//
//    @Override
//    public Point buildPoint() {
//        return PointDao.getInstance().findById(this.pointId);
//    }
//}
//
//class SmsServiceImpl {
//
//}
//class Point {
//    private String id;
//
//    public Point(String id) {
//        this.id = id;
//    }
//}
//
//class PointDao {
//    static Dao getInstance() {
//        return new Dao();
//    }
//}
//
//class Dao {
//    public Point findById(String id) {
//        return new Point(id);
//    }
//}
//
//class Staff {
//    static List<String> hireEmployees(){
//        return List.of("Коля", "Ваня");
//    }
//}