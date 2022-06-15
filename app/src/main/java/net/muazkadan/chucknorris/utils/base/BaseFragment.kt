package net.muazkadan.chucknorris.utils.base

import android.app.Dialog
import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

/**
 * @author muaz
 * Created on 6/15/2022.
 */
/**
 * Base [Fragment] to standardize and simplify initialization of this component.
 *
 */
open class BaseFragment(@LayoutRes contentLayoutId: Int) : Fragment(contentLayoutId) {

    lateinit var progressBarDialog: Dialog

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        getProgressDialog()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun getProgressDialog() {
        progressBarDialog = LoadingDialog(requireContext())
    }

    fun showOrHideProgressBarDialog(shouldShow: Boolean) {
        if (shouldShow) {
            if (!progressBarDialog.isShowing) {
                progressBarDialog.show()
            }
        } else {
            progressBarDialog.dismiss()
        }
    }
}
