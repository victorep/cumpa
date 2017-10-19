import spark.Request;
import spark.Response;
import spark.Route;

public class GroceriesApi {
    public static Route addItem() {
        System.out.printf("adding a new item");
        return new Route() {
            @Override
            public Object handle(Request request, Response response) throws Exception {
                return null;
            }
        };
    }
    public static Route removeItem() {
        System.out.printf("adding a new item");
        return new Route() {
            @Override
            public Object handle(Request request, Response response) throws Exception {
                return null;
            }
        };
    }
}
