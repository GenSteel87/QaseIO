package models;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Suite {
    String title;
    String description;
    String preconditions;
    @SerializedName("parent_id")
    String parentId;
    String projectCode;
}
