package xml.impl;

import entities.Person;
import org.joda.time.LocalDate;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import repositories.PRepository;
import xml.XMLReader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class SAXReader implements XMLReader {
    private PRepository repository = new PRepository();

    @Override
    public PRepository getRepo(String filePath) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();  //создаем фабрику, для получения сакс-парсеров
            SAXParser parser = factory.newSAXParser();  //создаем парсер
            SAX sax = new SAX();
            parser.parse(new File(filePath), sax);  //парсим файл, используя DefaultHandler
            return repository;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //класс для обработчиков событий SAX
    private class SAX extends DefaultHandler {
        //уведомление о запуске элемента
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            //uri - URI пространства имен, localName - локальное имя, qName - полностью определенное имя, attributes - атрибуты, присоединенные к элементу.
            if (qName.equals("person")) {
                repository.addPerson(new Person(
                        Integer.valueOf(attributes.getValue("id")),
                        attributes.getValue("lastname"),
                        attributes.getValue("firstname"),
                        attributes.getValue("middlename"),
                        attributes.getValue("gender"),
                        new LocalDate(attributes.getValue("birthDay"))
                ));
            }
        }
    }
}
