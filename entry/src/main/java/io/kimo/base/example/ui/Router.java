package io.kimo.base.example.ui;

import io.kimo.base.example.data.Student;
import io.kimo.base.example.ui.detail.StudentDetailAbility;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;

public class Router {
    public static void studentDetailScreen(AbilitySlice context, Student student) {
        Intent intent = new Intent();
        intent.setParam(StudentDetailAbility.STUDENT, student);
        context.presentForResult(new StudentDetailAbility(), intent, 1);
    }
}
