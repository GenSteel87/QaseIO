package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Case {
    String description;
    String preconditions;
    String postconditions;
    String title;
    String severity;
    String priority;
    String behavior;
    String type;
    String layer;
    String isFlaky;
    String milestone;
    String automation;
    String status;
}


