import com.google.gson.Gson;
import me.vepu.cumpa.app.App;
import me.vepu.cumpa.app.datamodel.GroceryItem;


import static spark.Spark.*;

public class MainSpark {

    public static void main(String[] args){
        App app = App.getInstance();

        get("/api/groceries", (request, response) -> {
            app.load();
            response.type("application/json");
            return new Gson().toJson(app.getGroceryListArrayListImpl());
        });

        get("/api/groceries/:id", (request, response) -> {
            app.load();
            response.type("application/json");
            GroceryItem foundItem = app.getGroceryListArrayListImpl().findOne(request.params(":id"));
            if (foundItem!=null){

                return new Gson().toJson(foundItem);
            }else{
                response.status(404);

                return new Gson().toJson(new ApiMessage("Item not found",404));
            }

        });

        post("/api/groceries", (request, response) -> {
            app.load();
            response.type("application/json");
            GroceryItem newItem = new GroceryItem();
            newItem.setName(request.queryParams("name"));
            newItem.setUnits(Integer.parseInt(request.queryParams("units")));
            if (app.getGroceryListArrayListImpl().add(newItem)){
                app.save();
                return new Gson().toJson(newItem);
            }else{
                response.status(409);
                return new Gson().toJson(new ApiMessage("Item already exists",409));
            }

        });

        delete("/api/groceries/:id", (request, response) -> {
            app.load();
            response.type("application/json");

            if (app.getGroceryListArrayListImpl().deleteOne(request.params(":id"))){
                app.save();
                return new Gson().toJson(new ApiMessage("Item removed"));

            }else{
                response.status(404);

                return new Gson().toJson(new ApiMessage("Item not found",404));
            }

        });

    }
}
