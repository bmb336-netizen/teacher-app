package com.example.teacherapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.teacherapp.data.dao.*
import com.example.teacherapp.data.models.*

@Database(
    entities = [
        Teacher::class,
        Classes::class,
        Student::class,
        Attendance::class,
        Assessment::class,
        Lesson::class,
        Club::class,
        Competition::class,
        ClubMember::class,
        CompetitionParticipant::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun teacherDao(): TeacherDao
    abstract fun classesDao(): ClassesDao
    abstract fun studentDao(): StudentDao
    abstract fun attendanceDao(): AttendanceDao
    abstract fun assessmentDao(): AssessmentDao
    abstract fun lessonDao(): LessonDao
    abstract fun clubDao(): ClubDao
    abstract fun competitionDao(): CompetitionDao
    abstract fun clubMemberDao(): ClubMemberDao
    abstract fun competitionParticipantDao(): CompetitionParticipantDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "teacher_app_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
