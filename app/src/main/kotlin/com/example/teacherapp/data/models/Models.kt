package com.example.teacherapp.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "teachers")
data class Teacher(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val email: String,
    val phone: String,
    val subject: String,
    val school: String,
    val password: String,
    val createdDate: Long = System.currentTimeMillis(),
    val isLoggedIn: Boolean = false
) : Serializable

@Entity(tableName = "classes")
data class Classes(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val teacherId: Int,
    val className: String,
    val level: String,
    val studentCount: Int = 0,
    val createdDate: Long = System.currentTimeMillis()
)

@Entity(tableName = "students")
data class Student(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val classId: Int,
    val name: String,
    val registrationNumber: String,
    val gender: String,
    val parentPhone: String,
    val createdDate: Long = System.currentTimeMillis()
) : Serializable

@Entity(tableName = "attendance")
data class Attendance(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val studentId: Int,
    val classId: Int,
    val date: Long,
    val status: String,
    val notes: String = "",
    val createdDate: Long = System.currentTimeMillis()
)

@Entity(tableName = "assessments")
data class Assessment(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val studentId: Int,
    val classId: Int,
    val subject: String,
    val score: Double,
    val maxScore: Double = 100.0,
    val date: Long,
    val notes: String = "",
    val createdDate: Long = System.currentTimeMillis()
)

@Entity(tableName = "lessons")
data class Lesson(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val classId: Int,
    val title: String,
    val description: String,
    val content: String,
    val attachmentUrl: String = "",
    val date: Long,
    val duration: Int = 0,
    val createdDate: Long = System.currentTimeMillis()
) : Serializable

@Entity(tableName = "clubs")
data class Club(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val teacherId: Int,
    val name: String,
    val description: String,
    val createdDate: Long = System.currentTimeMillis(),
    val status: String = "active"
)

@Entity(tableName = "competitions")
data class Competition(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val teacherId: Int,
    val title: String,
    val description: String,
    val startDate: Long,
    val endDate: Long,
    val createdDate: Long = System.currentTimeMillis(),
    val status: String = "upcoming"
)

@Entity(tableName = "club_members")
data class ClubMember(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val clubId: Int,
    val studentId: Int,
    val joinedDate: Long = System.currentTimeMillis()
)

@Entity(tableName = "competition_participants")
data class CompetitionParticipant(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val competitionId: Int,
    val studentId: Int,
    val position: Int = 0,
    val score: Double = 0.0,
    val joinedDate: Long = System.currentTimeMillis()
)
