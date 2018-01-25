package dk.thegeorge.nav.navcalc

import android.content.Context
import android.graphics.PorterDuff
import android.support.v4.content.ContextCompat
import android.widget.EditText

/**
 * Created by cdg on 24/01/2018.
 */
class FieldInfo {
    enum class FieldContentSource {
        INVALID,
        USER,
        CALC
    }
    enum class Field {
        st_k_dv,
        dv,
        dv_,
        st_k_mv,
        mv,
        mv_,
        st_k_rv,
        afdrift,
        afdrift_,
        sejl_k_rv,
        stroem,
        stroem_,
        beh_k_rv,
    }
    var mContentSource = FieldContentSource.INVALID;
    var mEditText: EditText? = null;
    val value: String
        get() {
            if (mEditText == null) {
                return "";
            }
            return mEditText!!.text.toString()
        }
    val user: Boolean
        get() = mContentSource == FieldContentSource.USER;
    val deg: Double?
        get() {
            if (mEditText != null) {
                return mEditText!!.text.toString().toDoubleOrNull();
            }
            return null
        }

    fun clear() {
        if (mEditText != null) {
            mEditText!!.text.clear(); }
    }

    fun setDeg(deg: Double?): Boolean {
        if (mEditText != null) {
            val oldText=mEditText!!.text.toString();
            if(deg==null) {
                mEditText!!.text.clear();
            } else {
                mEditText!!.setText(deg.toInt().toString());
            }
            return oldText!=mEditText!!.text.toString()
        } else {
            return false;
        }
    }
    fun updateUi(context: Context) {
        if(mEditText != null) {
            when(mContentSource) {
                FieldContentSource.INVALID-> mEditText!!.getBackground().setColorFilter(ContextCompat.getColor(context, R.color.background_invalid), PorterDuff.Mode.SRC_IN);
                FieldContentSource.USER -> mEditText!!.getBackground().setColorFilter(ContextCompat.getColor(context, R.color.background_user), PorterDuff.Mode.SRC_IN);
                FieldContentSource.CALC -> mEditText!!.getBackground().setColorFilter(ContextCompat.getColor(context, R.color.background_calc), PorterDuff.Mode.SRC_IN);
            }
        }
    }
}

fun addConstrain(orgSum: FieldInfo, add: FieldInfo, newSum: FieldInfo) : Boolean {
    val sumorg_deg = orgSum.deg;
    val add_deg = add.deg;
    if (sumorg_deg != null && add_deg != null && !newSum.user) {
        return newSum.setDeg(cleanDeg0_360(sumorg_deg + add_deg));
    } else {
        val sum_deg = newSum.deg;
        if(sum_deg!=null && sumorg_deg!=null && !add.user) {
            return add.setDeg(cleanDegPm180(sum_deg-sumorg_deg));
        } else if(sum_deg!=null && add_deg !=null && !orgSum.user) {
            return orgSum.setDeg(cleanDeg0_360(sum_deg- add_deg));
        }
    }
    return false;
}