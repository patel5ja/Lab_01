import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;




public class ProductWriter {
    public static void main(String[] args) {

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath().toString(), "src", "ProductTestData.txt");

        String ID = "";
        String name = "";
        String description = "";
        double cost = 0;
        String csvRec = "";


        Scanner in = new Scanner(System.in);
        SafeInputObj sio = new SafeInputObj();

        ArrayList<Product> recs = new ArrayList<>();
        Product product;


        boolean done = false;

        do {
            ID = sio.getNonZeroLenString("enter ID");
            name = sio.getNonZeroLenString("enter name");
            description = sio.getNonZeroLenString("enter description");
            cost = sio.getRangedDouble("Enter the cost: ", 0, 9999);

            product = new Product(name, description, ID, cost);

            recs.add(product);

            done = sio.getYNConfirm("Are you done? (y/n): ");

        } while (!done);



        try {

            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            for (Product p : recs) {

                csvRec = p.toCSVDataString();
                writer.write(csvRec, 0, csvRec.length());
                writer.newLine();

            }
            writer.close();
            System.out.println("Data file written!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


