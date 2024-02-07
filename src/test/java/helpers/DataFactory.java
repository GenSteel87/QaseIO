package helpers;

import com.github.javafaker.Faker;
import models.Project;
import models.Suite;

public class DataFactory {
    public static Project getRandomProject() {
        Faker faker = new Faker();
        Project project = Project.builder()
                .title(faker.lorem().characters(5))
                .code(faker.lorem().characters(5))
                .description(faker.lorem().characters(5))
                .build();
        return project;
    }

    public static Suite getRandomSuite(String projectCode) {
        Faker faker = new Faker();
        Suite suite = Suite.builder()
                .projectCode(getRandomProject().getCode())
                .title(faker.lorem().characters(5))
                .description(faker.lorem().characters(5))
                .preconditions(faker.lorem().characters(5))
                .build();
        return suite;
    }
}
