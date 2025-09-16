public class ObjInputTest {
    public static void main(String[] args) {
        SafeInputObj sio = new SafeInputObj();

        String name = sio.getNonZeroLenString("Enter your name");
        int age = sio.getRangedInt("Enter your age", 1, 120);
        double gpa = sio.getRangedDouble("Enter GPA", 0.0, 4.0);
        String zip = sio.getRegExString("Enter ZIP (5 digits)", "\\d{5}");
        boolean answer = sio.getYNConfirm("Submit?");

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("GPA: " + gpa);
        System.out.println("ZIP: " + zip);

    }
}