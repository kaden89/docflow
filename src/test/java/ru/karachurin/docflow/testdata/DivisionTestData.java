package ru.karachurin.docflow.testdata;

import ru.karachurin.docflow.model.Division;

import java.util.Arrays;
import java.util.List;

import static ru.karachurin.docflow.model.BaseEntity.START_SEQ;
import static ru.karachurin.docflow.testdata.OrganizationTestData.ORGANIZATION1;
import static ru.karachurin.docflow.testdata.OrganizationTestData.ORGANIZATION2;

/**
 * Created by Денис on 03.12.2016.
 */
public class DivisionTestData {

    public static final int DIVISION1_ID = START_SEQ + 3;
    public static final Division DIVISION1 =
            new Division(DIVISION1_ID, "shop",null, "+ 77 77 77", ORGANIZATION1);
    public static final Division DIVISION2 =
            new Division(DIVISION1_ID+1, "accounting", null, "+ 88 88 88",ORGANIZATION1);
    public static final Division DIVISION3 =
            new Division(DIVISION1_ID+2, "developers", null, "+ 99 99 99",ORGANIZATION2);
    public static final Division DIVISION4 =
            new Division(DIVISION1_ID+3, "testers", null, "+ 55 55 55",ORGANIZATION2);

    public static final List<Division> DIVISIONS = Arrays.asList(DIVISION1, DIVISION2, DIVISION3, DIVISION4);

    public static Division getUpdated(){
        return new Division(DIVISION1_ID, "updated", null, "+ 22 22 22", ORGANIZATION1);
    }

    public static Division getCreated(){
        return new Division(null, "new division", null, "+ 44 44 44", ORGANIZATION2);
    }
}
