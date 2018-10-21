package com.example.ubnt.fragviewapp


import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView


/**
 * A simple [Fragment] subclass.
 */
class DeleteFragment : DialogFragment() {

    internal var mNum: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //        mNum = getArguments().getInt("num");
        //
        //        // Pick a style based on the num.
        //        int style = DialogFragment.STYLE_NORMAL, theme = 0;
        //        switch ((mNum-1)%6) {
        //            case 1: style = DialogFragment.STYLE_NO_TITLE; break;
        //            case 2: style = DialogFragment.STYLE_NO_FRAME; break;
        //            case 3: style = DialogFragment.STYLE_NO_INPUT; break;
        //            case 4: style = DialogFragment.STYLE_NORMAL; break;
        //            case 5: style = DialogFragment.STYLE_NORMAL; break;
        //            case 6: style = DialogFragment.STYLE_NO_TITLE; break;
        //            case 7: style = DialogFragment.STYLE_NO_FRAME; break;
        //            case 8: style = DialogFragment.STYLE_NORMAL; break;
        //        }
        //        switch ((mNum-1)%6) {
        //            case 4: theme = android.R.style.Theme_Holo; break;
        //            case 5: theme = android.R.style.Theme_Holo_Light_Dialog; break;
        //            case 6: theme = android.R.style.Theme_Holo_Light; break;
        //            case 7: theme = android.R.style.Theme_Holo_Light_Panel; break;
        //            case 8: theme = android.R.style.Theme_Holo_Light; break;
        //        }
        //        setStyle(style, theme);

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_delete, container, false)
        val btn_yes = v.findViewById<Button>(R.id.btn_yes)
        val btn_no = v.findViewById<Button>(R.id.btn_no)
        btn_yes.setOnClickListener {
            val activity = activity as MainActivity?
            val country = arguments!!.getString("country")
            Log.v("country", country)
            //                LinearLayout parents =  ((LinearLayout)activity.findViewById(R.id.ll_list));
            //                View viewToBeRemoved =parents.findViewWithTag(country);
            //                parents.removeView(viewToBeRemoved);
            //                   // ((ViewGroup)view.getParent()).removeView(view);
            activity!!.updateListView(country)
            dismiss()
        }
        btn_no.setOnClickListener { dismiss() }
        return v
    }

    companion object {

        /**
         * Create a new instance of MyDialogFragment, providing "num"
         * as an argument.
         */
        internal fun newInstance(num: Int): DeleteFragment {

            // Supply num input as an argument.
            //        Bundle args = new Bundle();
            //        args.putInt("num", num);
            //        f.setArguments(args);

            return DeleteFragment()
        }
    }

}
