package ru.raiffeisen.allure.json.labels;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Label {

    @NonNull
    private String name;

    @NonNull
    private String value;


}
