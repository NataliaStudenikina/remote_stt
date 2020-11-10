package ru.raiffeisen.allure.json.step;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class StatusDetails {

    @NonNull
    private Boolean known;

    @NonNull
    private Boolean muted;

    @NonNull
    private Boolean flaky;

    @NonNull
    private String message;

    @NonNull
    private String trace;
}
