package io.kimo.base.example.ui.detail;

import io.kimo.base.Presenters;
import io.kimo.base.example.data.Student;

/**
 * StudentDetailPresenter
 */
public class StudentDetailPresenters extends Presenters<StudentDetailContract.Component> implements StudentDetailContract.Presenter {

    private Student mStudent;

    /**
     * StudentDetailPresenter
     *
     * @param component component
     * @param student   Student
     */
    public StudentDetailPresenters(StudentDetailContract.Component component, Student student) {
        super(component);
        mStudent = student;
    }

    @Override
    public void createComponent() {
        getComponent().updateImage(mStudent.getImageUrl());
        getComponent().updateName(mStudent.getName());
        getComponent().updateCourse(mStudent.getCourse());
        getComponent().updateDescription(mStudent.getDescription());
    }
}
