package ru.raiffeisen.allure.json.step;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Getter
public class Scenario {
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
