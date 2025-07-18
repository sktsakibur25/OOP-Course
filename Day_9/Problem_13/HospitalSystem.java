package Day_9.Problem_13;

import Day_9.Problem_13.Exceptions.DuplicateEntryException;
import Day_9.Problem_13.Exceptions.MedicineContradictionException;

@SuppressWarnings("unused")
public class HospitalSystem {
    public static void main(String[] args) {
        try {
            Patient patient = new Patient("John Doe");
            
            Medicine anti_inflamatory = new Medicine("Anti-inflammatory", "10mg");
            Medicine muscle_relaxant = new Medicine("Muscle Relaxant", "5mg");
            Medicine antbiotic = new Medicine("Antibiotic", "250mg");
            Medicine cough_syrup = new Medicine("Cough Syrup", "15ml");
            Medicine insuline = new Medicine("Insulin", "20 units");
            Medicine anticoagulant = new Medicine("Anticoagulant", "75mg");
            Medicine cns_depressant = new Medicine("CNS Depressant", "50mg");
            Medicine statins = new Medicine("Statins", "20mg");

            MedicineContradictions.addContradiction(antbiotic, statins);
            MedicineContradictions.addContradiction(muscle_relaxant, cns_depressant);
            MedicineContradictions.addContradiction(anti_inflamatory, anticoagulant);

            patient.addMedication(anti_inflamatory);
            patient.addMedication(muscle_relaxant);
            patient.addMedication(antbiotic);
            patient.addMedication(cns_depressant); // This will throw a contradiction exception

            patient.getCurrentMedications().forEach(med -> 
                System.out.println("Current Medications: " + med.getName())
            );

        } catch (DuplicateEntryException e) {
            System.out.println(e.getMessage());
        } catch (MedicineContradictionException e) {
            System.out.println(e.toString());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
