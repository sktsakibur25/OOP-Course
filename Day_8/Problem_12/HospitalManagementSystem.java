package Day_8.Problem_12;

import java.time.LocalDate;

public class HospitalManagementSystem {
    public static void main(String[] args) {

        // Example usage of the Patient and Doctor classes
        Patient patient1 = new Patient("John Doe", LocalDate.of(1990, 1, 1), "123-456-7891");
        Patient patient2 = new Patient("Jane Smith", LocalDate.of(1985, 5, 15), "987-654-3210");
        Patient patient3 = new Patient("Alice Johnson", LocalDate.of(2000, 12, 31), "555-555-5554");
        Patient patient4 = new Patient("Bob Brown", LocalDate.of(1975, 3, 20), "444-444-4443");

        // Example doctors
        Doctor doctor_1 = new Doctor("Dr. Smith", "Cardiology", "123-456-7890");
        Doctor doctor_2 = new Doctor("Dr. Jones", "Neurology", "987-654-3210");

        try {
            // Adding patients to doctors
            doctor_1.assignPatient(patient1);
            doctor_2.assignPatient(patient3);
            doctor_2.assignPatient(patient4);

            Integer appointment_id_1 = doctor_1.scheduleAppointment(patient1, LocalDate.of(2023, 10, 1));
            Integer appointment_id_2 = doctor_2.scheduleAppointment(patient3, LocalDate.of(2023, 10, 2));

            System.out.println("Appointment ID for " + patient1.getName() + ": " + appointment_id_1);
            System.out.println("Appointment ID for " + patient3.getName() + ": " + appointment_id_2);

            doctor_1.prescribe(patient1, "Aspirin", appointment_id_1);
            doctor_2.prescribe(patient3, "Ibuprofen", appointment_id_2);

            patient1.getAppointmentList().forEach(appointment -> {
                System.out.println("Patient: " + patient1.getName() + ", Appointment ID: " + appointment.getId() + ", Prescribed Medicine: " + appointment.getPrescribedMedicine());
            });
            patient3.getAppointmentList().forEach(appointment -> {
                System.out.println("Patient: " + patient3.getName() + ", Appointment ID: " + appointment.getId() + ", Prescribed Medicine: " + appointment.getPrescribedMedicine());
            });


            System.out.println(patient1.printInfo());
            System.out.println(patient3.printInfo());
            System.out.println(patient2.printInfo());





        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
