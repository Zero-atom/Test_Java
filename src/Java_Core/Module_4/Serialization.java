package Java_Core.Module_4;
import java.io.*;
import java.util.Arrays;

public class Serialization {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //создаем наш объект
        String[] territoryInfo = {"У Испании 6 провинций", "У России 10 провинций", "У Франции 8 провинций"};
        String[] resourcesInfo = {"У Испании 100 золота", "У России 80 золота", "У Франции 90 золота"};
        String[] diplomacyInfo = {"Франция воюет с Россией, Испания заняла позицию нейтралитета"};

        SavedGame savedGame = new SavedGame(territoryInfo, resourcesInfo, diplomacyInfo);

        //создаем 2 потока для сериализации объекта и сохранения его в файл
        FileOutputStream outputStream = new FileOutputStream("C://Users//Denis.Iskhakov//IdeaProjects//Test//src//Java_Core//Module_4//save.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        // сохраняем игру в файл
        objectOutputStream.writeObject(savedGame);

        //закрываем поток и освобождаем ресурсы
        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("C://Users//Denis.Iskhakov//IdeaProjects//Test//src//Java_Core//Module_4//save.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        SavedGame savedGame1 = (SavedGame) objectInputStream.readObject();

        System.out.println(savedGame1);
    }
}



class SavedGame implements Serializable {

    private static final long serialVersionUID = 1L;

    private String[] territoriesInfo;
    private String[] resourcesInfo;
    private String[] diplomacyInfo;

    public SavedGame(String[] territoriesInfo, String[] resourcesInfo, String[] diplomacyInfo){
        this.territoriesInfo = territoriesInfo;
        this.resourcesInfo = resourcesInfo;
        this.diplomacyInfo = diplomacyInfo;
    }

    public String[] getTerritoriesInfo() {
        return territoriesInfo;
    }

    public void setTerritoriesInfo(String[] territoriesInfo) {
        this.territoriesInfo = territoriesInfo;
    }

    public String[] getResourcesInfo() {
        return resourcesInfo;
    }

    public void setResourcesInfo(String[] resourcesInfo) {
        this.resourcesInfo = resourcesInfo;
    }

    public String[] getDiplomacyInfo() {
        return diplomacyInfo;
    }

    public void setDiplomacyInfo(String[] diplomacyInfo) {
        this.diplomacyInfo = diplomacyInfo;
    }

    @Override
    public String toString() {
        return "SavedGame{" +
                "territoriesInfo=" + Arrays.toString(territoriesInfo) +
                ", resourcesInfo=" + Arrays.toString(resourcesInfo) +
                ", diplomacyInfo=" + Arrays.toString(diplomacyInfo) +
                '}';
    }
}

//еще пример
class Developer implements Serializable {
    public String name;
    public String address;
    public transient int secretNumber; // Поле не будет сериализовано
    public String favouriteCat;
}

class SerializationDemo {
    public static void main(String[] args) {
        // Сериализация
        Developer developer = new Developer();
        developer.name = "Alexander Great";
        developer.address = "Russia";
        developer.secretNumber = 42;
        developer.favouriteCat = "Nyancat";

        try (FileOutputStream fileOut = new FileOutputStream("developer")) {
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(developer);
            out.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        // Десериализация
        Developer restoredDeveloper;
        try (FileInputStream fileIn = new FileInputStream("developer")) {
            ObjectInputStream in = new ObjectInputStream(fileIn);
            restoredDeveloper = (Developer) in.readObject();
            in.close();
        } catch (IOException | ClassNotFoundException exception) {
            exception.printStackTrace();
            return;
        }

        System.out.println("Deserialized Developer...");
        System.out.println("Name: " + restoredDeveloper.name);
        System.out.println("Address: " + restoredDeveloper.address);
        System.out.println("Favourite cat: " + restoredDeveloper.favouriteCat);
        System.out.println("Secret number: " + restoredDeveloper.secretNumber);
    }
}
