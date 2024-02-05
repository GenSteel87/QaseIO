package models;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CaseAPI {
    String description;
    String preconditions;
    String postconditions;
    String title;
    int severity;
    int priority;
    int behavior;
    int type;
    int layer;
    @SerializedName("is_flaky")
    int isFlaky;
    @SerializedName("suite_id")
    int suiteId;
    int milestone;
    int automation;
    int status;
}
