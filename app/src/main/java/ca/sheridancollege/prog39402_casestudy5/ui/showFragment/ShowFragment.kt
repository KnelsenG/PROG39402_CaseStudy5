package ca.sheridancollege.prog39402_casestudy5.ui.showFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import ca.sheridancollege.prog39402_casestudy5.base.BaseFragment
import ca.sheridancollege.prog39402_casestudy5.databinding.FragmentShowBinding


class ShowFragment : BaseFragment() {

    private lateinit var binding: FragmentShowBinding
    private lateinit var viewModel: ShowFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ShowFragmentViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentShowBinding.inflate(inflater, container, false)
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
            // nothing to do
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = ShowFragment()

    }
}
