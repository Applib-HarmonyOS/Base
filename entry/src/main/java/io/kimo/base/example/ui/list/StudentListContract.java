package io.kimo.base.example.ui.list;

import io.kimo.base.Base;
import io.kimo.base.example.data.Student;

import java.util.List;

/**
 * StudentListContract
 */
public interface StudentListContract {

    interface Component extends Base.Component<StudentListPresenters> {
        void showLoading();
        void showList(List<Student> models);
    }

    interface Presenter {
        void fetchDataFromSomewhere();
        void populateListWithData();
    }
}
