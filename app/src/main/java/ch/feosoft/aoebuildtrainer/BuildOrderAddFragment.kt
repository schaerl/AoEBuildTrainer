package ch.feosoft.aoebuildtrainer

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import ch.feosoft.aoebuildtrainer.model.BuildOrder
import ch.feosoft.aoebuildtrainer.service.BuildOrderService
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputLayout


class BuildOrderAddFragment : Fragment() {
    private lateinit var nameView: TextInputLayout
    private lateinit var fab: FloatingActionButton

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_build_order_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nameView = view.findViewById(R.id.new_build_order_name)

        fab = view.findViewById(R.id.fab)
        fab.setOnClickListener { onSaveClicked() }
    }

    private fun onSaveClicked() {
        Log.d(LOG_TAG, "FAB clicked")
        Log.d(LOG_TAG, "given name is '${nameView.editText?.text.toString()}'")
        if (validate()) {
            Log.d(LOG_TAG, "Validation successful")
            BuildOrderService.addBuildOrder(BuildOrder(nameView.editText!!.text.toString()))
            BuildOrderAddFragmentDirections.actionAddFragmentToListFragment()

            findNavController().navigate(BuildOrderAddFragmentDirections.actionAddFragmentToListFragment())
            
            Toast.makeText(
                requireContext(),
                getString(R.string.build_order_saved_successfully),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun validate(): Boolean {
        return if (nameView.editText?.text.isNullOrBlank()) {
            setMissingNameError()
            false
        } else {
            true
        }
    }

    private fun setMissingNameError() {
        nameView.editText?.error = getString(R.string.error_name_required)
    }

    companion object {
        private const val LOG_TAG = "BuildOrderAddFragment"
    }
}