package com.ydhnwb.learndagger.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.ydhnwb.learndagger.R
import com.ydhnwb.learndagger.database.note.Note
import com.ydhnwb.learndagger.ui.fragments.note.AllNoteFragment
import com.ydhnwb.learndagger.ui.fragments.note.AllNoteFragmentDirections
import kotlinx.android.synthetic.main.list_item_note.view.*

class NoteAdapter(private val notes : MutableList<Note>, private val context: Context) : RecyclerView.Adapter<NoteAdapter.ViewHolder>(){
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun bind(note: Note, context: Context){
            with(itemView){
                note_title.text = note.title
                note_desc.text = note.description
                setOnClickListener {
                    val action = AllNoteFragmentDirections.actionAllNoteFragmentToEditNoteFragment(note)
                    findNavController().navigate(action)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_note, parent, false))

    override fun getItemCount() = notes.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(notes[position], context)

    fun updateList(it: List<Note>){
        notes.clear()
        notes.addAll(it)
        notifyDataSetChanged()
    }
}