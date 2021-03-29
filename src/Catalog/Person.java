package Catalog;

import java.util.Date;

public class Person implements Comparable{
    protected String mFistName;
    protected String mLastName;
    protected Data mBirthDate;

    public Person (String iFirstName, String iLastName, Data iBirthDate){
        mFistName = iFirstName;
        mLastName = iLastName;
        mBirthDate = iBirthDate;
    }

    public String getmFistName() {
        return mFistName;
    }

    public void setmFistName(String mFistName) {
        this.mFistName = mFistName;
    }

    public String getmLastName() {
        return mLastName;
    }

    public void setmLastName(String mLastName) {
        this.mLastName = mLastName;
    }

    public Data getmBirthDate() {
        return mBirthDate;
    }

    public void setmBirthDate(Data mBirthDate) {
        this.mBirthDate = mBirthDate;
    }

    @Override
    public int compareTo(Object o) {
        Person tmp = ((Person) o);

        if ( mLastName.equals(tmp.mLastName))
            return mFistName.compareTo(tmp.mFistName);

        return mLastName.compareTo(tmp.mLastName);
    }

    @Override
    public String toString() {
        return mFistName + " " + mLastName + " ";
    }
}
