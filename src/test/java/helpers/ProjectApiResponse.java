package helpers;

import lombok.Data;
import models.Project;

@Data
public class ProjectApiResponse extends ProjectAdapter{
    Project result;
}
