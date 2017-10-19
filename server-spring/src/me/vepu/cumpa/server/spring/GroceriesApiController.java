package me.vepu.cumpa.server.spring;

import me.vepu.cumpa.app.App;
import me.vepu.cumpa.app.datamodel.GroceryItem;
import me.vepu.cumpa.app.datamodel.GroceryListArrayListImpl;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
public class GroceriesApiController {

    private final String API_PATH = "/api/groceries";

    private App app = App.getInstance();

    @GetMapping(path = API_PATH)
    public GroceryListArrayListImpl<GroceryItem> getAll(){
        app.load();
        return app.getGroceryListArrayListImpl();
    }

    @PostMapping(path = API_PATH)
    public GroceryItem createOne(@RequestParam("name") String name, @RequestParam(value = "units",defaultValue = "1") String units, HttpServletRequest request, HttpServletResponse response) throws Exception{
        app.load();

        GroceryItem newItem = new GroceryItem(name,Integer.parseInt(units));
        if (app.getGroceryListArrayListImpl().add(newItem)) {
            app.save();
            return newItem;
        }
        else {
            response.sendError(408, "Unable to add item. Make sure it does not already exist!");
            return null;
        }
    }

    @GetMapping(path = API_PATH + "/{name}")
    public GroceryItem getOne(@PathVariable String name, HttpServletRequest request, HttpServletResponse response) throws Exception{
        app.load();
        GroceryItem foundItem = app.getGroceryListArrayListImpl().findOne(name);
        if (foundItem!=null){

            return foundItem;
        }else{
            response.sendError(404,"Item not found");

            return null;
        }
    }

    @DeleteMapping(path = API_PATH + "/{name}")
    public void deleteOne(@PathVariable String name, HttpServletRequest request, HttpServletResponse response) throws Exception{
        app.load();

        if (app.getGroceryListArrayListImpl().deleteOne(name)){
            app.save();
            response.sendError(200,"Item removed");


        }else{
            response.sendError(404,"Item nod found");
        }
    }

}
