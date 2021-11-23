package io.kimo.base.example.ui.detail;

import io.kimo.base.Base;

public interface StudentDetailContract {

    interface Component extends Base.Component<StudentDetailPresenter> {
        void updateImage(String someUrl);
        void updateName(String someName);
        void updateDescription(String someDescription);
        void updateCourse(String someCourse);
    }

    interface Presenter extends Base.Presenter{}
}
