package Day_8.Problem_12;

import java.util.ArrayList;
import java.util.List;

public class Doctor {
    private String name;
    private String specialization;
    private String contactNumber;
    private List<Patient> patients;

    public Doctor(String name, String specialization, String contactNumber) {
        this.name = name;
        this.specialization = specialization;
        this.contactNumber = contactNumber;
        this.patients = new ArrayList<>();
    }

    
}
