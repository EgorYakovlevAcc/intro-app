package com.hexletlection.introapp;

import com.hexletlection.introapp.exception.CustomException;

public class IntroAppConstants {
    public static final CustomException USER_NOT_FOUND_EXCEPTION = new CustomException("IA-000", "User with such name does not exist.");

    private IntroAppConstants() {
    }
}
