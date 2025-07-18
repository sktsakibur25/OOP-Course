package Day_9.Problem_13;

import java.util.ArrayList;
import java.util.List;

import Day_9.Problem_13.Exceptions.DuplicateEntryException;
import Day_9.Problem_13.Exceptions.MedicineContradictionException;

@SuppressWarnings("unused")
public class Patient {
    private String name;
    private List<Medicine> currentMedications;

    public Patient(String name) {
        this.name = name;
        this.currentMedications = new ArrayList<>();
    }

    public void addMedication(Medicine newMedicine) throws DuplicateEntryException, MedicineContradictionException {
        checkMedication(newMedicine);
        for (Medicine existingMedicine : currentMedications) {
            MedicineContradictions.checkContradiction(newMedicine, existingMedicine);
        }
        currentMedications.add(newMedicine);
    }

    public List<Medicine> getCurrentMedications() {
        return new ArrayList<>(currentMedications);
    }

    private void checkMedication(Medicine medicine) throws DuplicateEntryException {
        if (medicine == null) {
            throw new IllegalArgumentException("Medication cannot be null");
        }
        if (currentMedications.contains(medicine)) {
            throw new DuplicateEntryException("Medication already exists for this patient");
        }
    }
}
