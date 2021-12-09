package io.kimo.base.example.ui.detail;

import io.kimo.base.Base;

/**
 * StudentDetailContract
 */
public interface StudentDetailContract {

    /**
     * Component
     */
    interface Component extends Base.Component<StudentDetailPresenters> {
        void updateImage(String someUrl);

        void updateName(String someName);

        void updateDescription(String someDescription);

        void updateCourse(String someCourse);
    }

    interface Presenter extends Base.Presenter {
    }
}
