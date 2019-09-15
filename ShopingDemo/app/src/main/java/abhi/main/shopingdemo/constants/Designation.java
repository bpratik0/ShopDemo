package abhi.main.shopingdemo.constants;

/**
 * Created by makrand.bramhankar on 28-11-2016.
 */
public enum Designation {
    CLASS_TEACHER("class teacher"),
    ADMIN("Admin"),
    SUBJECT_TEACHER("subject teacher");

    String mName;

    Designation(String name) {
        this.mName = name;
    }

    public String getName() {
        return mName;
    }
}
