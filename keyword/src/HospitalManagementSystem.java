// File: HospitalManagementSystem.java


// Blueprint for a Patient.
class Patient {
    // static variables are shared across all Patient objects.
    private static String hospitalName;
    private static int totalPatients = 0;

    // final variable is unchangeable.
    private final String patientID;

    // Instance variables
    private String name;
    private int age;
    private String ailment;

    public Patient(String name, int age, String ailment, String patientID) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID;
        totalPatients++;
    }

    public static void setHospitalName(String name) {
        hospitalName = name;
    }

    public static int getTotalPatients() {
        return totalPatients;
    }

    public void displayPatientDetails() {
        if (this instanceof Patient) {
            System.out.println("Hospital Name: " + hospitalName);
            System.out.println("Patient ID: " + this.patientID);
            System.out.println("Name: " + this.name);
            System.out.println("Age: " + this.age);
            System.out.println("Ailment: " + this.ailment);
        }
    }
}

// Main class to run the program.
public class HospitalManagementSystem {
    public static void main(String[] args) {
        Patient.setHospitalName("City Hospital");

        Patient patient1 = new Patient("Lathika", 30, "Flu", "P001");
        Patient patient2 = new Patient("Lidiya", 45, "Fracture", "P002");

        System.out.println("Total Patients Admitted: " + Patient.getTotalPatients());

        System.out.println("\n--- Patient 1 Details ---");
        patient1.displayPatientDetails();
        System.out.println("\n--- Patient 2 Details ---");
        patient2.displayPatientDetails();
    }
}
