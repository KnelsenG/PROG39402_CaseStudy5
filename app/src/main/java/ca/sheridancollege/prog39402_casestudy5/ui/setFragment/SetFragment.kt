package ca.sheridancollege.prog39402_casestudy5.ui.setFragment

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import ca.sheridancollege.prog39402_casestudy5.base.BaseFragment
import ca.sheridancollege.prog39402_casestudy5.databinding.FragmentSetBinding
import ca.sheridancollege.prog39402_casestudy5.ext.QuickToast
import java.io.File
import ca.sheridancollege.prog39402_casestudy5.R


class SetFragment : BaseFragment() {

    private lateinit var binding: FragmentSetBinding
    private lateinit var viewModel: SetFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(SetFragmentViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        initViews()
        initObservables()
    }

    private fun init() {
        binding.vm = viewModel
    }

    private fun initViews() {

    }

    private fun initObservables() {
        viewModel.apply {
            cameraEventClick.observe(this@SetFragment, Observer {
                this@SetFragment.QuickToast("cameraEventClick")

                this@SetFragment.startActivityForResult(
                        Intent.createChooser(
                                Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE), "Take your photo"
                        ),
                        CAPTURE_IMAGE_REQ_CODE
                )
            })
            continueEventClick.observe(this@SetFragment, Observer {
                view?.findNavController()?.navigate(R.id.action_set_to_show)
            })
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode != CAPTURE_IMAGE_REQ_CODE)
            return

        when (resultCode) {
            Activity.RESULT_CANCELED -> {
                // do nothing as of right now
            }
            Activity.RESULT_OK -> {
                val pic = data?.extras?.get("data") as Bitmap

                viewModel.updateImage(
                        pic,
                        this@SetFragment.context?.openFileOutput("avatar.jpg", Context.MODE_PRIVATE),
                        Uri.fromFile(File(context!!.filesDir, "avatar.jpg")).toString()
                )
            }
        }
    }


    companion object {

        const val CAPTURE_IMAGE_REQ_CODE = 101
        @JvmStatic
        fun newInstance() = SetFragment()

    }
}
