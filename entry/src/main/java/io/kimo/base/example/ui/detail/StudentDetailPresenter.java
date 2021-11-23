package io.kimo.base.example.ui.detail;

import io.kimo.base.Presenter;
import io.kimo.base.example.data.Student;

public class StudentDetailPresenter extends Presenter<StudentDetailContract.Component> implements StudentDetailContract.Presenter {

    private Student mStudent;

    public StudentDetailPresenter(StudentDetailContract.Component component, Student student) {
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
