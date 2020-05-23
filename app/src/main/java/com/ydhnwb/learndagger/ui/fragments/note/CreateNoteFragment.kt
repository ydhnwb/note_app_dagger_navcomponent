package com.ydhnwb.learndagger.ui.fragments.note

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.ydhnwb.learndagger.R
import com.ydhnwb.learndagger.database.note.Note
import com.ydhnwb.learndagger.utils.ViewModelProviderFactory
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_create_note.view.*
import javax.inject.Inject

class CreateNoteFragment : DaggerFragment(R.layout.fragment_create_note){
    @Inject
    lateinit var noteViewModel: NoteViewModel
    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModel()
        view.btn_save.setOnClickListener {
            val title = view.et_title.text.toString().trim()
            val desc = view.et_desc.text.toString().trim()
            if(title.isNotEmpty() && desc.isNotEmpty()){
                doSave(Note(title = title, description = desc))
                Navigation.findNavController(requireActivity(), R.id.container).navigateUp()
            }else{
                showAlert("Please fill all forms first")
            }

        }
    }

    private fun setupViewModel(){
        noteViewModel = ViewModelProvider(this, viewModelProviderFactory).get(NoteViewModel::class.java)
    }

    private fun doSave(note: Note) = noteViewModel.insert(note)

    private fun showAlert(message : String){
        AlertDialog.Builder(requireActivity()).apply {
            setMessage(message)
            setPositiveButton(resources.getString(R.string.understand)){ dialog, _ -> dialog.dismiss()}
        }.show()
    }

}