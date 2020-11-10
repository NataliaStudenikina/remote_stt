package ru.raiffeisen.allure.json.step;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@RequiredArgsConstructor
@Getter
public class AllureStep {

    @NonNull
    private String name;

    @NonNull
    private String status;

    @NonNull
    private String stage;

    @NonNull
    private Date start;

    @NonNull
    private Date stop;


}
