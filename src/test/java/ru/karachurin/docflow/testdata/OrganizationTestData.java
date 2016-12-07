package ru.karachurin.docflow.testdata;

import ru.karachurin.docflow.model.Organization;

import java.util.Arrays;
import java.util.List;

import static ru.karachurin.docflow.model.BaseEntity.START_SEQ;

/**
 * Created by Денис on 03.12.2016.
 */
public class OrganizationTestData {
    public static final int ORGANIZATION1_ID = START_SEQ+1;
    public static final Organization ORGANIZATION1 =
            new Organization(ORGANIZATION1_ID, "OOO Romashka", "Ufa", "Ufa", null);
    public static final Organization ORGANIZATION2 =
            new Organization(ORGANIZATION1_ID+1, "OOO Alfa", "Moscow", "Moscow", null);
    public static final Organization ORGANIZATION3 =
            new Organization(100100, "OOO Beta", "Moscow", "Moscow", null);

    public static final List<Organization> ORGANIZATIONS = Arrays.asList(ORGANIZATION1, ORGANIZATION2, ORGANIZATION3);

    public static Organization getCreated(){
        return new Organization(null, "OOO Gamma", "Ufa", "Ufa", null);
    }

    public static Organization getUpdated(){
        return new Organization(ORGANIZATION1_ID, "OOO Updated", "Ufa", "Moscow", null);
    }
}
