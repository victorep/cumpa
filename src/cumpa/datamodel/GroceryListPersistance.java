package cumpa.datamodel;

import java.util.List;

public interface GroceryListPersistance
{
    void save(String filename, List<GroceryItem> list) throws Exception;
    List<GroceryItem> load(String filename) throws Exception  ;
}
