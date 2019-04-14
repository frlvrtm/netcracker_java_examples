package xml.impl;

import entities.Person;
import org.joda.time.LocalDate;
import org.w3c.dom.*;
import repositories.PRepository;
import xml.XMLReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class DOMReader implements XMLReader {
    //DOM - объектная модель документа

    @Override
    public PRepository getRepo(String filePath) {
        PRepository repository = new PRepository();
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();   //создаем фабрику, для получения билдера
            DocumentBuilder builder = builderFactory.newDocumentBuilder();  //создаем билдер, для получения структуры документа
            Document document = builder.parse(new File(filePath));  //создаем документ

            NodeList nodeList = document.getDocumentElement().getElementsByTagName("person");   //получаем список элементов документа

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);   //отдельный элемент
                NamedNodeMap map = node.getAttributes();    //атрибуты элемента
                repository.addPerson(new Person(
                        Integer.valueOf(map.getNamedItem("id").getNodeValue()),
                        map.getNamedItem("lastname").getNodeValue(),
                        map.getNamedItem("firstname").getNodeValue(),
                        map.getNamedItem("middlename").getNodeValue(),
                        map.getNamedItem("gender").getNodeValue(),
                        new LocalDate(map.getNamedItem("birthDay").getNodeValue())
                ));
            }
            return repository;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
