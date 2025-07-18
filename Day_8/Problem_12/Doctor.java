package Day_8.Problem_12;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Day_8.Problem_12.Exceptions.DoctorAlreadyAssignedException;
import Day_8.Problem_12.Exceptions.InvalidAppointmentException;
import Day_8.Problem_12.Exceptions.PatientIsNotAssignedException;

@SuppressWarnings("unused")
public class Doctor {
    private String name;
    private String specialization;
    private String contactNumber;
    private List<Patient> assignedPatients;
    private List<Appointment> appointments;

    public String getName() {
        return name;
    }

    public Doctor(String name, String specialization, String contactNumber) {
        this.name = name;
        this.specialization = specialization;
        this.contactNumber = contactNumber;
        this.assignedPatients = new ArrayList<>();
        this.assignedPatients = new ArrayList<>();
        this.appointments = new ArrayList<>();
    }

    public void assignPatient(Patient patient) throws DoctorAlreadyAssignedException {
        Integer patient_id = createPatientId(assignedPatients);
        patient.assignDoctor(this, patient_id);
        assignedPatients.add(patient);
    }

    public Integer scheduleAppointment(Patient patient, LocalDate apponintmentDate) throws PatientIsNotAssignedException {
        if (assignedPatients.contains(patient)) {
            Appointment appointment = new Appointment(createAppointmentId(), patient, apponintmentDate);
            this.appointments.add(appointment);
            return appointment.getId();
        } else {
            throw new PatientIsNotAssignedException(patient.getName() + " is not assigned to this doctor.");
        }
    }

    private Integer createAppointmentId() {
        return appointments.size() + 1; // Simple ID generation based on the size of the list
    }

    private Integer createPatientId(List<Patient> patients) {
        return patients.size() + 1; // Simple ID generation based on the size of the list
    }

    public void prescribe(Patient patient, String string, Integer appointment_id) throws PatientIsNotAssignedException, InvalidAppointmentException {
        if(assignedPatients.contains(patient)) {
            for (Appointment appointment : appointments) {
                if (appointment.getId().equals(appointment_id)) {
                    appointment.setPrescribedMedicine(string);
                    patient.setCurrentMedication(string);
                    return;
                }
            }
            throw new InvalidAppointmentException("Invalid appointment ID: " + appointment_id);
        } else {
            throw new PatientIsNotAssignedException("Patient " + patient.getName() + " is not assigned to this doctor.");
        }
    }

    public List<Appointment> getAppointmentsByPatientId(Integer id) {
        List<Appointment> patientAppointments = new ArrayList<>();
        for (Appointment appointment : appointments) {
            if (appointment.getPatientId().equals(id)) {
                patientAppointments.add(appointment);
            }
        }
        return patientAppointments;
    }

}
