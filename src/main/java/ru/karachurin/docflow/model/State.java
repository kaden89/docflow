package ru.karachurin.docflow.model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Created by Денис on 06.12.2016.
 */
public enum State {
    PREPARE,
    EXECUTION,
    CONTROL,
    REWORK,
    RECEPTION,
    END
}
