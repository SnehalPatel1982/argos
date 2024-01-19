package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private Properties prop;

    public Properties init_reader() throws IOException {
        System.out.println("This is Config reader page");
        prop = new Properties();
        FileInputStream ip = new FileInputStream("C:\\Users\\Dipal\\IdeaProjects\\ArgosBDD_Hybride_Framework\\src\\test\\resources\\dataset\\config.properties");
        prop.load(ip);

        return prop;

    }
}
