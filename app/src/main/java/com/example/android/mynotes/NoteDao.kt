package com.example.android.mynotes

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: Note) // agar isse suspend likh diya toh --> yeh func sirf background
    // se hi call hoga ya dusra suspend function.This is coroutine

    @Delete
    suspend fun delete(note: Note)

    @Query("Select * from notes_table order by id ASC") //ASC --> ascending
    fun getAllNotes(): LiveData<List<Note>> // through live data we can observe the changes that will
    // happen in my list
}