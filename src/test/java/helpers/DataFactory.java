package helpers;

import com.github.javafaker.Faker;
import models.Case;
import models.Project;
import models.Suite;

import java.util.HashMap;

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

    public static Case getRandomCase(String projectCode, String suiteTitle) {
        Faker faker = new Faker();
        Case testCase = Case.builder()
                .title(faker.lorem().characters(5))
                .description(faker.lorem().characters(5))
                .preconditions(faker.lorem().characters(5))
                .postConditions(faker.lorem().characters(5))
                .status("Draft")
                .suite(getRandomSuite(getRandomProject().getCode()).getTitle())
                .severity("Major")

                .build();
        return testCase;
    }
}
