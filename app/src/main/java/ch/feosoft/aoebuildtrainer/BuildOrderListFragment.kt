package ch.feosoft.aoebuildtrainer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ch.feosoft.aoebuildtrainer.adapter.BuildOrderAdapter
import ch.feosoft.aoebuildtrainer.data.DataSource

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class BuildOrderListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        /* Inflate the layout for this fragment*/
        return inflater.inflate(R.layout.fragment_build_order_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recycler = view.findViewById<RecyclerView>(R.id.build_order_recycler_view)
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = BuildOrderAdapter(DataSource.getData())
    }
}