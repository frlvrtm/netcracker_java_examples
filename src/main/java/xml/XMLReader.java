package xml;

import repositories.PRepository;

public interface XMLReader {
    PRepository getRepo(String filePath);
}
