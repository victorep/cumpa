package me.vepu.cumpa.app.datamodel;

import java.util.List;

public interface IGroceryListPersistance
{
    void save(String filename, List<GroceryItem> list) throws Exception;
    List<GroceryItem> load(String filename) throws Exception  ;
}
