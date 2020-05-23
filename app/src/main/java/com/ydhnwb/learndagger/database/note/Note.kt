package com.ydhnwb.learndagger.database.note

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "notes")
data class Note(
    @PrimaryKey(autoGenerate = true)
    var id : Int? = null,
    var title : String?,
    var description : String?
) : Parcelable