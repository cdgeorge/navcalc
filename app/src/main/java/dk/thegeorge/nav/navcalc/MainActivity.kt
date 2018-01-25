package dk.thegeorge.nav.navcalc

import android.content.Context
import android.graphics.PorterDuff
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import dk.thegeorge.nav.navcalc.FieldInfo.Field;
import dk.thegeorge.nav.navcalc.FieldInfo.FieldContentSource;

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_main.view.*
import android.view.Gravity



fun EditText.afterTextChanged(afterTextChanged: (Editable?) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }
        override fun afterTextChanged(editable: Editable?) {
            afterTextChanged.invoke(editable)
        }
    })
}
public fun Context.toast(message: CharSequence) =
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

class MainActivity : AppCompatActivity() {
    /**
     * The [android.support.v4.view.PagerAdapter] that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * [android.support.v4.app.FragmentStatePagerAdapter].
     */
    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)

        // Set up the ViewPager with the sections adapter.
        container.adapter = mSectionsPagerAdapter

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId

        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }


    /**
     * A [FragmentPagerAdapter] that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1)
        }

        override fun getCount(): Int {
            // Show 3 total pages.
            return 3
        }
    }




    /**
     * A placeholder fragment containing a simple view.
     */
    class PlaceholderFragment : Fragment() {
        fun initEditView(f: FieldInfo.Field, view:EditText?) {
            if(view!=null) {
                view.afterTextChanged { doSomethingWithText(it, f, view) }
            }
            getFieldInfo(f).mEditText=view;
        }

        public fun toast(message: CharSequence)  {
            val t=Toast.makeText(context , message, Toast.LENGTH_SHORT);
            t.setGravity(Gravity.TOP or Gravity.LEFT, 0, 0);
            t.show()
        }

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                  savedInstanceState: Bundle?): View? {
            val rootView = inflater.inflate(R.layout.fragment_main, container, false)
            rootView.section_label.text = getString(R.string.section_format, arguments.getInt(ARG_SECTION_NUMBER))
            initEditView(Field.st_k_dv,rootView.st_k_dv)
            initEditView(Field.dv,rootView.dv)
            initEditView(Field.dv_,rootView.dv_)
            initEditView(Field.st_k_mv,rootView.st_k_mv)
            initEditView(Field.mv,rootView.mv)
            initEditView(Field.mv_,rootView.mv_)
            initEditView(Field.st_k_rv,rootView.st_k_rv)
            initEditView(Field.afdrift,rootView.afdrift)
            initEditView(Field.afdrift_,rootView.afdrift_)
            initEditView(Field.sejl_k_rv,rootView.sejl_k_rv)
            initEditView(Field.stroem,rootView.stroem)
            initEditView(Field.stroem_,rootView.stroem_)
            initEditView(Field.beh_k_rv,rootView.beh_k_rv)
            return rootView
        }
        var mFieldInfo=HashMap<Field,FieldInfo>();
        var inEditMode=false;
        fun getFieldInfo(f: Field) : FieldInfo {
            var fieldInfo=mFieldInfo[f];
            if(fieldInfo==null) {
                mFieldInfo[f]=FieldInfo();
                fieldInfo=mFieldInfo[f];
            }
            return fieldInfo!!;
        }
        fun addConstrain(add1: Field, add2: Field, sum: Field) : Boolean {
            return addConstrain(getFieldInfo(add1), getFieldInfo(add2), getFieldInfo(sum));
        }
        fun doSomethingWithText(it: Editable?, f: Field, e: EditText) {
            val fieldInfo=getFieldInfo(f);
            fieldInfo.mEditText=e;
            if(inEditMode) {
                fieldInfo.mContentSource=FieldContentSource.CALC;
                fieldInfo.updateUi(context);
                return;
            }
            Log.d(TAG,"doSomethingWithText f:"+f)
            var bad=false;
            if(f==Field.st_k_mv) {
                Log.d(TAG,"doSomethingWithText getFieldInfo(Field.st_k_dv).user:"+getFieldInfo(Field.st_k_dv).user)
                Log.d(TAG,"doSomethingWithText getFieldInfo(Field.dv).user:"+getFieldInfo(Field.dv).user)
                Log.d(TAG,"doSomethingWithText getFieldInfo(Field.dv_).user:"+getFieldInfo(Field.dv_).user)
                if(getFieldInfo(Field.st_k_dv).user && (getFieldInfo(Field.dv).user || getFieldInfo(Field.dv_).user)) {
                    toast("Kan ikke rette st_k_dv: Slet st_k_dv eller mv først");
                    //return;
                    bad=true;
                }
            }
            inEditMode=true;
            if(f==Field.afdrift_) {
                toast("<afdrift i grader>[*:]? [gående|fra|mod|imod] <NSØV|grader>");
                if(getFieldInfo(Field.afdrift).user) {
                    toast("Kan ikke rette afdrift venstre side: Slet afdrift højre side først");
                    //return;
                    bad=true;
                } else {
                    val afdrift = calcAfdrift(getFieldInfo(Field.afdrift_).value, true, getFieldInfo(Field.st_k_rv).value.toDoubleOrNull())
                    getFieldInfo(Field.afdrift).setDeg(afdrift);
                }
            }
            if(f==Field.stroem_) {
                toast("<strøm i grader>[*:]? [gående|fra|mod|imod] <NSØV|grader>");
                if(getFieldInfo(Field.stroem).user) {
                    toast("Kan ikke rette strøm venstre side: Slet strøm højre side først");
                    //return;
                    bad=true;
                } else {
                    val afdrift = calcAfdrift(getFieldInfo(Field.stroem_).value, false, getFieldInfo(Field.sejl_k_rv).value.toDoubleOrNull())
                    getFieldInfo(Field.stroem).setDeg(afdrift);
                }
            }
            if(!bad) {
                fieldInfo.mContentSource = if (it.toString().isBlank()) FieldContentSource.INVALID else FieldContentSource.USER;
                fieldInfo.updateUi(context);
            }
            Log.d(TAG,"hej it"+it.toString())
            var calcCount=0;
            do {
                var calc=false;
                calcCount++;
                calc=calc||addConstrain(Field.st_k_dv, Field.dv, Field.st_k_mv);
                calc=calc||addConstrain(Field.st_k_mv, Field.mv, Field.st_k_rv);
                calc=calc||addConstrain(Field.st_k_rv, Field.afdrift, Field.sejl_k_rv);
                calc=calc||addConstrain(Field.sejl_k_rv, Field.stroem, Field.beh_k_rv);
            } while(calc&&calcCount<10)
            inEditMode=false;
        }
        companion object {
            /**
             * The fragment argument representing the section number for this
             * fragment.
             */
            private val ARG_SECTION_NUMBER = "section_number"
            val TAG="HEJ";


            /**
             * Returns a new instance of this fragment for the given section
             * number.
             */
            fun newInstance(sectionNumber: Int): PlaceholderFragment {
                val fragment = PlaceholderFragment()
                val args = Bundle()
                args.putInt(ARG_SECTION_NUMBER, sectionNumber)
                fragment.arguments = args
                return fragment
            }
        }
    }
}
