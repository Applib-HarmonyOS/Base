package io.kimo.base.example;

import io.kimo.base.example.ui.list.StudentListAbility;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;

public class MainAbility extends Ability {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(StudentListAbility.class.getName());
    }
}
