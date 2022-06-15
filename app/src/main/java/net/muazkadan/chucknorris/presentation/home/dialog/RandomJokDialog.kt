package net.muazkadan.chucknorris.presentation.home.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import net.muazkadan.chucknorris.databinding.DialogRandomJokeBinding
import net.muazkadan.chucknorris.utils.viewBinding

/**
 * @author muaz
 * Created on 6/15/2022.
 */
class RandomJokDialog(
    context: Context,
    private val joke: String,
    private val callback: (String) -> Unit
) : Dialog(context) {

    private val binding by viewBinding(DialogRandomJokeBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() = with(binding) {
        tvJoke.text = joke
        btnShare.setOnClickListener {
            callback.invoke(joke)
        }
        btnDismiss.setOnClickListener {
            dismiss()
        }
    }
}
