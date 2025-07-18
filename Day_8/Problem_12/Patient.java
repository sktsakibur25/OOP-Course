package Day_8.Problem_12;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Day_8.Problem_12.Exceptions.DoctorAlreadyAssignedException;

@SuppressWarnings("unused")
public class Patient {
    private Integer id;
    private String name;
    private LocalDate dateOfBirth;
    private String contactNumber;
    private Doctor doctor;
    private String currentMedication;

    public Patient(String name, LocalDate dateOfBirth, String contactNumber) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.contactNumber = contactNumber;
        this.currentMedication = "N/A";
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public List<Appointment> getAppointmentList() {
        if(this.id == null || this.doctor == null) {
            return new ArrayList<>();
        }else{
            return doctor.getAppointmentsByPatientId(this.id);
        }
    }


public String printInfo() {
        return "Patient ID: " + id + ", Name: " + name + ", Date of Birth: " + dateOfBirth + ", Contact Number: " + contactNumber + ", Current Medication: " + currentMedication + ", Doctor: " + (doctor != null ? doctor.getName() : "No doctor assigned");
    }

    protected void assignDoctor(Doctor doctor, Integer patient_id) throws DoctorAlreadyAssignedException {
        if(this.doctor == null && this.id == null) {
            this.doctor = doctor;
            this.id = patient_id;
        } else {
            throw new DoctorAlreadyAssignedException("Doctor is already assigned to this patient.");
        }
    }

    protected void setCurrentMedication(String medication) {
        this.currentMedication = medication;
    }
}
