package me.vepu.cumpa.app.datamodel;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class GroceryListPersistanceXMLImpl implements IGroceryListPersistance {

    private  String container;
    private final String EXTENTION = "xml";

    public GroceryListPersistanceXMLImpl(String container) {
        this.container = container;
    }



    @Override
    public void save(String filename, List<GroceryItem> list) throws Exception {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.newDocument();

        //root element
        Element rootElement = doc.createElement("GroceryListArrayListImpl");
        doc.appendChild(rootElement);

        Iterator<GroceryItem> iterator = list.iterator();
        while (iterator.hasNext()){
            GroceryItem item=iterator.next();
            Element xmlItem = doc.createElement("GroceryItem");
            rootElement.appendChild(xmlItem);

            Attr name = doc.createAttribute("name");
            name.setValue(item.getName());
            xmlItem.setAttributeNode(name);

            Attr units = doc.createAttribute("units");
            units.setValue(String.valueOf(item.getUnits()));
            xmlItem.setAttributeNode(units);
        }
        //write to disk
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(filename+".xml"));

        transformer.transform(source,result);
    }

    @Override
    public List<GroceryItem> load(String filename) throws Exception {
        List<GroceryItem> list = new ArrayList<>();
        File fXmlFile = new File(filename+"."+EXTENTION);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        try {
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("GroceryItem");

            for (int temp=0;temp<nList.getLength();temp++){
                Node nNode = nList.item(temp);
                if (nNode.getNodeType()==Node.ELEMENT_NODE){
                    Element eElement = (Element) nNode;
                    list.add(new GroceryItem(eElement.getAttribute("name"),Integer.parseInt(eElement.getAttribute("units"))));
                }
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }finally {
            return list;
        }


    }


}
