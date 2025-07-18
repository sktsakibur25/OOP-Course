package Day_8.Problem_12;

import java.time.LocalDate;

@SuppressWarnings("unused")
public class Appointment {
    private Integer id;
    private Patient patient;
    private LocalDate appointmentDate;
    private String prescribedMedicine;

    public Appointment(Integer id, Patient patient, LocalDate appointmentDate) {
        this.id = id;
        this.patient = patient;
        this.appointmentDate = appointmentDate;
    }

    public Integer getId() {
        return id;
    }

    protected Integer getPatientId() {
        return patient.getId();
    }

    protected void setPrescribedMedicine(String prescribedMedicine) {
        this.prescribedMedicine = prescribedMedicine;
    }

    public String getPrescribedMedicine() {
        return prescribedMedicine;
    }

}
