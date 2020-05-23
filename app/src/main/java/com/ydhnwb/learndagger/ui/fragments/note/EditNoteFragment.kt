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
import kotlinx.android.synthetic.main.fragment_edit_note.view.*
import javax.inject.Inject

class EditNoteFragment : DaggerFragment(R.layout.fragment_edit_note){
    @Inject
    lateinit var viewModelProviderFactory : ViewModelProviderFactory
    @Inject
    lateinit var noteViewModel: NoteViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fill()
        noteViewModel = ViewModelProvider(this, viewModelProviderFactory).get(NoteViewModel::class.java)
        view.btn_save.setOnClickListener {
            val t = view.et_title.text.toString().trim()
            val d = view.et_desc.text.toString().trim()
            if(t.isNotEmpty() && d.isNotEmpty()){
                val note = getNote()!!.copy()
                note.title = t
                note.description = d
                doUpdate(note)
            }else{
                showAlert("Fill all forms first")
            }
        }
        view.btn_delete.setOnClickListener { doDelete(getNote()!!) }
    }

    private fun fill(){
        requireView().let {
            getNote()?.let { note ->
                it.et_title.setText(note.title)
                it.et_desc.setText(note.description)
            }
        }
    }

    private fun doUpdate(note: Note){
        noteViewModel.update(note)
        Navigation.findNavController(requireActivity(), R.id.container).popBackStack()
    }

    private fun doDelete(note: Note){
        noteViewModel.delete(note)
        Navigation.findNavController(requireActivity(), R.id.container).navigateUp()
    }

    private fun showAlert(message : String){
        AlertDialog.Builder(requireActivity()).apply {
            setMessage(message)
            setPositiveButton(resources.getString(R.string.understand)){ dialog, _ -> dialog.dismiss()}
        }.show()
    }

    private fun getNote() : Note? = arguments?.let { EditNoteFragmentArgs.fromBundle(it).note }
}