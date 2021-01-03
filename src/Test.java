import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        System.out.println("Macar ti s-a frant inima cand ai teme");
        Application application = Application.getInstance();
        try {
            File myObj = new File("companies.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
                Company company = new Company(data);
                application.add(company);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try {
            File myObj = new File("departaments.txt");
            DepartmentsFactory factory = new DepartmentsFactory();
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
                for (Company company: application.getCompanies()) {
                    company.add(factory.createDepartament(data));
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


        System.out.println(application);

    }
}
