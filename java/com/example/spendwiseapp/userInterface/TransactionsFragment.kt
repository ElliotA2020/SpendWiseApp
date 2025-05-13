package com.example.spendwiseapp.userInterface

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.spendwiseapp.data.PreferenceManager

class TransactionsFragment : Fragment() {

    private lateinit var binding: FragmentTransactionsBinding
    private val viewModel: TransactionsViewModel by viewModels {
        TransactionsViewModelFactory(PreferenceManager(requireContext()), requireContext())
    }
    private lateinit var adapter: TransactionsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTransactionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupClickListeners()
        observeViewModel()
    }

    private fun observeViewModel() {
        TODO("Not yet implemented")
    }

    private fun setupClickListeners() {
        TODO("Not yet implemented")
    }

    override fun onResume() {
        super.onResume()
        if (isAdded && !isDetached) {
            viewModel.loadTransactions()
        }
    }

    private fun setupRecyclerView() {
        adapter = TransactionsAdapter(
            onEditClick = { transaction ->
                val action = TransactionsFragmentDirections
                    .actionNavigationTransactionsToEditTransactionFragment(transaction)
                findNavController().navigate(action)
            },
            onDeleteClick = { transaction ->
                showDeleteConfirmationDialog(transaction)
            }
        )
        binding.recyclerViewTransactions.adapter = adapter
        binding.recyclerViewTransactions.layoutManager = LinearLayoutManager(requireContext())
    }