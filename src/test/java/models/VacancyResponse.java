package models;

import lombok.Data;

import java.util.ArrayList;
@Data
public class VacancyResponse {
    ArrayList<Vacancy> items;
    int found;
    int pages;
}
