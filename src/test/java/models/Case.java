package models;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

import java.util.HashMap;

@Data
@Builder
public class Case {
    String description;
    String preconditions;
    @SerializedName("postconditions")
    String postConditions;
    String title;
    String suite;
    String severity;
    String priority;
    String behavior;
    String type;
    String layer;
    String isFlaky;
    String milestone;
    String automation;
    String status;
    public static class DropDowns {
        public static HashMap<String, String> mapWithValuesForTheCaseTest() {
            HashMap<String, String> labelAndOption = new HashMap<>();
            labelAndOption.put("Status", "Draft");
            labelAndOption.put("Severity", "Major");
            labelAndOption.put("Priority", "Medium");
            labelAndOption.put("Type", "Functional");
            labelAndOption.put("Layer", "API");
            labelAndOption.put("Is flaky", "Yes");
            labelAndOption.put("Behavior", "Negative");
            labelAndOption.put("Automation status", "Manual");
            return labelAndOption;
        }
    }

}


