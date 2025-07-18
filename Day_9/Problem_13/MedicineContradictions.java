package Day_9.Problem_13;

import java.util.ArrayList;
import java.util.List;

import Day_9.Problem_13.Exceptions.DuplicateEntryException;
import Day_9.Problem_13.Exceptions.MedicineContradictionException;

@SuppressWarnings("unused")
public class MedicineContradictions {
    private static final String CONTRADICTION_MESSAGE = "These two medicines cannot be taken together due to potential contradictions: ";
    private static final List<MedicineContradictions> contradictionsList = new ArrayList<>();
    private Medicine medicine1;
    private Medicine medicine2;

    private MedicineContradictions(Medicine medicine1, Medicine medicine2) {
        this.medicine1 = medicine1;
        this.medicine2 = medicine2;
    }

    public static void addContradiction(Medicine medicine1, Medicine medicine2) throws DuplicateEntryException {
        if(contradictionsList.stream().anyMatch(c -> 
            (c.medicine1.equals(medicine1) && c.medicine2.equals(medicine2)) || 
            (c.medicine1.equals(medicine2) && c.medicine2.equals(medicine1)))) {
            throw new DuplicateEntryException("This contradiction already exists: " + medicine1 + " and " + medicine2);
        }
        contradictionsList.add(new MedicineContradictions(medicine1, medicine2));
    }

    public static void checkContradiction(Medicine medicine1, Medicine medicine2) throws MedicineContradictionException {
         Boolean contradiction = contradictionsList.stream().anyMatch(c -> 
            (c.medicine1.equals(medicine1) && c.medicine2.equals(medicine2)) || 
            (c.medicine1.equals(medicine2) && c.medicine2.equals(medicine1)));

        if (contradiction) {
            throw new MedicineContradictionException(CONTRADICTION_MESSAGE + " " + medicine1.getName() + " and " + medicine2.getName());
        }

    }
}
