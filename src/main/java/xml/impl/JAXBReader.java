package xml.impl;

import entities.Person;
import repositories.PRepository;
import xml.XMLReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JAXBReader implements XMLReader {
    /*
        JAXB - фраемворк для работы с XML.
        Использует аннотации @Xml.
        Marshaller (сериализация) - процесс перевода какой-либо структуры данных в последовательность битов.
        Unmarshaller (десериализация) - это процесс восстановления объекта из этих байт.
    */

    @Override
    public PRepository getRepo(String filePath) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Person.class, PRepository.class); //создаем контекст, передаем туда список классов
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();   //создаем объект десериализации
            return (PRepository) unmarshaller.unmarshal(new File(filePath));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
