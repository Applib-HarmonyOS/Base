package io.kimo.base.example.ui.detail;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;
import io.kimo.base.BaseAbility;
import io.kimo.base.example.ResourceTable;
import io.kimo.base.example.data.Student;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Component;
import ohos.agp.components.Image;
import ohos.agp.components.Text;

/**
 * StudentDetailAbility
 */
public class StudentDetailAbility extends BaseAbility<StudentDetailPresenters> implements StudentDetailContract.Component {

    public static final String TAG = StudentDetailAbility.class.getSimpleName();
    public static final String STUDENT = TAG + ".STUDENT";

    private Image mImage;
    private Intent mIntent;
    private Text mTitle, mSubtitle, mDescription;

    @Override
    public void updateImage(String someUrl) {
        Picasso.get()
                .load(someUrl)
                .placeholder(ResourceTable.Media_Jellyfish)
                .error(ResourceTable.Media_Jellyfish)
                .memoryPolicy(MemoryPolicy.NO_CACHE)
                .into(mImage);
    }

    @Override
    public void updateName(String someName) {
        mTitle.setText(someName);
    }

    @Override
    public void updateDescription(String someDescription) {
        mDescription.setText(someDescription);
    }

    @Override
    public void updateCourse(String someCourse) {
        mSubtitle.setText(someCourse);
    }

    @Override
    public int getLayoutResource() {
        return ResourceTable.Layout_ability_detail;
    }

    @Override
    public void mapUI(Component component) {
        mImage = (Image) component.findComponentById(ResourceTable.Id_image);
        mTitle = (Text) component.findComponentById(ResourceTable.Id_title);
        mSubtitle = (Text) component.findComponentById(ResourceTable.Id_subtitle);
        mDescription = (Text) component.findComponentById(ResourceTable.Id_description);
    }

    @Override
    public void configureUI() {
        // Do nothing because no configure details
    }

    @Override
    public StudentDetailPresenters injectDependencies() {
        Student student = mIntent.getSerializableParam(STUDENT);

        return new StudentDetailPresenters(this, student);
    }

    @Override
    protected void onStart(Intent savedInstanceState) {
        mIntent = savedInstanceState;
        super.onStart(savedInstanceState);
    }
}

