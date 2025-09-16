import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import static java.nio.file.StandardOpenOption.CREATE;

public class PersonGenerator {
    public static void main(String[] args) {

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath().toString(), "src", "PersonTestData.txt");


        String ID = "";
        String firstName = "";
        String lastName = "";
        String title = "";
        int yearOfBirth = 0;
        String csvRec = " ";
        boolean done = false;

        Scanner in = new Scanner(System.in);
        SafeInputObj sio = new SafeInputObj(in);

        ArrayList<Person> perps = new ArrayList<>();
        Person perp;



        do{
            ID = sio.getNonZeroLenString("enter ID");
            firstName = sio.getNonZeroLenString("enter first name");
            lastName = sio.getNonZeroLenString("enter last name");
            title = sio.getNonZeroLenString("enter title");
            yearOfBirth = sio.getRangedInt("Enter your year of birth: ", 1940, 2010);

            perp = new Person (ID, firstName, lastName, title, yearOfBirth );



            perps.add(perp);

            done = sio.getYNConfirm("Are you done? (y/n): ");

        }while(!done);


        try
        {

            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            for(Person p : perps)
            {
                csvRec = p.toCSVDataString();
                writer.write(csvRec, 0, csvRec.length());
                writer.newLine();

            }
            writer.close();
            System.out.println("Data file written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}