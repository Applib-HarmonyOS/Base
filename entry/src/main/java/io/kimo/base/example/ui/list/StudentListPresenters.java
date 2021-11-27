package io.kimo.base.example.ui.list;

import io.kimo.base.Presenters;
import io.kimo.base.example.data.Student;
import ohos.app.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * StudentListPresenter
 */
public class StudentListPresenters extends Presenters<StudentListContract.Component> implements StudentListContract.Presenter {

    private Context mContext;
    private List<Student> mStudents = new ArrayList<>();

    /**
     * StudentListPresenter
     *
     * @param component Component
     * @param context   Context
     */
    public StudentListPresenters(StudentListContract.Component component, Context context) {
        super(component);
        mContext = context;
    }

    @Override
    public void createComponent() {
        getComponent().showLoading();
        fetchDataFromSomewhere();
    }

    @Override
    public void destroyComponent() {
        // Do nothing because destroy the component
    }

    @Override
    public void fetchDataFromSomewhere() {
        mStudents.clear();
        mStudents = createData();
        populateListWithData();
    }

    /**
     * createData
     *
     * @return List
     */
    public static List<Student> createData() {
        List<Student> temp = new ArrayList<>();

        temp.add(new Student("aaa", "Student1", "xxx", "CS"));
        temp.add(new Student("bbb", "Student2", "xxx", "CS"));
        temp.add(new Student("ccc", "Student3", "xxx", "CS"));
        temp.add(new Student("ddd", "Student4", "xxx", "CS"));
        temp.add(new Student("eee", "Student5", "xxx", "CS"));
        temp.add(new Student("fff", "Student6", "xxx", "CS"));
        temp.add(new Student("ggg", "Student7", "xxx", "CS"));
        temp.add(new Student("hhh", "Student8", "xxx", "CS"));
        temp.add(new Student("iii", "Student9", "xxx", "CS"));
        temp.add(new Student("jjj", "Student10", "xxx", "CS"));
        return temp;
    }

    @Override
    public void populateListWithData() {
        getComponent().showList(mStudents);
    }
}
