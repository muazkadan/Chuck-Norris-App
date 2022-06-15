package net.muazkadan.chucknorris.utils.base

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import android.widget.ProgressBar
import net.muazkadan.chucknorris.databinding.DialogLoadingBinding
import net.muazkadan.chucknorris.utils.viewBinding

/**
 * @author muaz
 * Created on 6/15/2022.
 */
/**
 * Shows [ProgressBar] inside [Dialog] to be shown on time consuming operations
 */
class LoadingDialog(context: Context) : Dialog(context) {

    private val binding by viewBinding(DialogLoadingBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setCanceledOnTouchOutside(false)
        setCancelable(false)
        setContentView(binding.root)
    }
}
