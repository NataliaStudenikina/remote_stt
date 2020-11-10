package ru.raiffeisen.allure.json;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ru.raiffeisen.allure.json.labels.Label;
import ru.raiffeisen.allure.json.step.StatusDetails;
import ru.raiffeisen.allure.json.step.AllureStep;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Getter
public class TestResult {

    @NonNull
    private String uuid;

    @NonNull
    private String historyId;

    @NonNull
    private String fullName;

    @NonNull
    private List<Label> labels;

    @NonNull
    private String name;

    @NonNull
    private String status;

    private StatusDetails statusDetails;

    @NonNull
    private String stage;

    @NonNull
    private String description;

    @NonNull
    private Date start;

    @NonNull
    private Date stop;

    @NonNull
    private List<AllureStep> allureSteps;
}
