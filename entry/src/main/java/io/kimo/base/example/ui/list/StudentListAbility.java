package io.kimo.base.example.ui.list;

import io.kimo.base.BaseAbility;
import io.kimo.base.example.ResourceTable;
import io.kimo.base.example.data.Student;
import io.kimo.base.example.ui.Router;
import ohos.agp.components.*;
import ohos.app.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * StudentListAbility
 */
public class StudentListAbility extends BaseAbility<StudentListPresenter> implements StudentListContract.Component {

    private ListContainer mList;
    private ProgressBar mProgress;
    private StudentListAdapter mAdapter;

    @Override
    public void showLoading() {
        mProgress.setVisibility(Component.VISIBLE);
        mList.setVisibility(Component.HIDE);
    }

    @Override
    public void showList(List<Student> models) {
        mList.setVisibility(Component.VISIBLE);
        mProgress.setVisibility(Component.HIDE);
        mAdapter.setData(models);
    }

    @Override
    public int getLayoutResource() {
        return ResourceTable.Layout_ability_list;
    }

    @Override
    public void mapUI(Component component) {
        mList = (ListContainer) component.findComponentById(ResourceTable.Id_list_view);
        mProgress = (ProgressBar) component.findComponentById(ResourceTable.Id_progress_bar);
    }

    @Override
    public void configureUI() {
        mAdapter = new StudentListAdapter(this);
        mList.setItemProvider(mAdapter);
        mList.setItemClickedListener((parent, component, position, id) -> {
            Student student = mAdapter.getItem(position);
            Router.studentDetailScreen(StudentListAbility.this, student);
        });
    }

    @Override
    public StudentListPresenter injectDependencies() {
        return new StudentListPresenter(this, this);
    }

    /**
     * StudentListAdapter
     */
    public class StudentListAdapter extends BaseItemProvider {

        private List<Student> mData = new ArrayList<>();
        private LayoutScatter mLayoutInflater;

        public StudentListAdapter(Context context) {
            mLayoutInflater = LayoutScatter.getInstance(context);
            mData = StudentListPresenter.createData();
        }

        public void setData(List<Student> newData) {
            mData.clear();
            mData.addAll(newData);

            notifyDataChanged();
        }

        @Override
        public int getCount() {
            return mData == null? 0 : mData.size();
        }

        @Override
        public Student getItem(int position) {
            if (mData != null && position >= 0 && position < mData.size()){
                return mData.get(position);
            }
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public Component getComponent(int position, Component component, ComponentContainer componentContainer) {
            Component convertComponent = component;
            Student student = mData.get(position);
            if (convertComponent == null) {
                convertComponent = LayoutScatter.getInstance(getContext()).parse(ResourceTable.Layout_item_student, null, false);
            }
            Text text = (Text) convertComponent.findComponentById(ResourceTable.Id_item_index);
            text.setText(student.getName());
            return convertComponent;
        }
    }
}
