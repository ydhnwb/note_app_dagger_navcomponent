package com.ydhnwb.learndagger.ui.fragments.note

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ydhnwb.learndagger.R
import com.ydhnwb.learndagger.adapters.NoteAdapter
import com.ydhnwb.learndagger.database.note.Note
import com.ydhnwb.learndagger.utils.ViewModelProviderFactory
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_all_note.view.*
import javax.inject.Inject

class AllNoteFragment : DaggerFragment(R.layout.fragment_all_note){
    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory
    @Inject
    lateinit var noteViewModel: NoteViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println("Created...")
        noteViewModel = ViewModelProvider(this, viewModelProviderFactory).get(NoteViewModel::class.java)
        setupUI()
        noteViewModel.fetchAll().observe(viewLifecycleOwner, Observer { handleNotes(it) })
    }

    private fun setupUI(){
        requireView().let {
            it.rv_note.apply {
                layoutManager = LinearLayoutManager(activity)
                adapter = NoteAdapter(mutableListOf(), requireActivity())
            }
        }
    }

    private fun handleNotes(notes : List<Note>) = requireView().rv_note.adapter?.let {
            x -> (x as NoteAdapter).updateList(notes)
    }
}