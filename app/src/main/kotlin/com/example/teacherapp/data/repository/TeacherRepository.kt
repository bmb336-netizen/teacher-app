package com.example.teacherapp.data.repository

import androidx.lifecycle.LiveData
import com.example.teacherapp.data.dao.*
import com.example.teacherapp.data.models.*

class TeacherRepository(
    private val teacherDao: TeacherDao,
    private val classesDao: ClassesDao,
    private val studentDao: StudentDao,
    private val attendanceDao: AttendanceDao,
    private val assessmentDao: AssessmentDao,
    private val lessonDao: LessonDao,
    private val clubDao: ClubDao,
    private val competitionDao: CompetitionDao,
    private val clubMemberDao: ClubMemberDao,
    private val competitionParticipantDao: CompetitionParticipantDao
) {

    // Teacher
    suspend fun registerTeacher(teacher: Teacher) = teacherDao.insertTeacher(teacher)
    suspend fun loginTeacher(email: String, password: String): Teacher? = teacherDao.getTeacherByEmailAndPassword(email, password)
    suspend fun checkEmailExists(email: String): Boolean = teacherDao.getTeacherByEmail(email) != null
    fun getTeacherById(id: Int): LiveData<Teacher> = teacherDao.getTeacherById(id)
    suspend fun updateTeacher(teacher: Teacher) = teacherDao.updateTeacher(teacher)

    // Classes
    suspend fun addClass(classes: Classes) = classesDao.insertClass(classes)
    fun getTeacherClasses(teacherId: Int): LiveData<List<Classes>> = classesDao.getClassesByTeacherId(teacherId)
    suspend fun updateClass(classes: Classes) = classesDao.updateClass(classes)
    suspend fun deleteClass(classes: Classes) = classesDao.deleteClass(classes)

    // Students
    suspend fun addStudent(student: Student) = studentDao.insertStudent(student)
    fun getClassStudents(classId: Int): LiveData<List<Student>> = studentDao.getStudentsByClassId(classId)
    suspend fun updateStudent(student: Student) = studentDao.updateStudent(student)
    suspend fun deleteStudent(student: Student) = studentDao.deleteStudent(student)
    fun getStudentCount(classId: Int): LiveData<Int> = studentDao.getStudentCountByClassId(classId)

    // Attendance
    suspend fun addAttendance(attendance: Attendance) = attendanceDao.insertAttendance(attendance)
    fun getClassAttendance(classId: Int): LiveData<List<Attendance>> = attendanceDao.getAttendanceByClassId(classId)
    fun getStudentAttendance(studentId: Int): LiveData<List<Attendance>> = attendanceDao.getAttendanceByStudentId(studentId)
    suspend fun updateAttendance(attendance: Attendance) = attendanceDao.updateAttendance(attendance)

    // Assessment
    suspend fun addAssessment(assessment: Assessment) = assessmentDao.insertAssessment(assessment)
    fun getClassAssessments(classId: Int): LiveData<List<Assessment>> = assessmentDao.getAssessmentsByClassId(classId)
    fun getStudentAssessments(studentId: Int): LiveData<List<Assessment>> = assessmentDao.getAssessmentsByStudentId(studentId)
    fun getStudentAverageScore(studentId: Int): LiveData<Double> = assessmentDao.getStudentAverageScore(studentId)
    suspend fun updateAssessment(assessment: Assessment) = assessmentDao.updateAssessment(assessment)

    // Lessons
    suspend fun addLesson(lesson: Lesson) = lessonDao.insertLesson(lesson)
    fun getClassLessons(classId: Int): LiveData<List<Lesson>> = lessonDao.getLessonsByClassId(classId)
    suspend fun updateLesson(lesson: Lesson) = lessonDao.updateLesson(lesson)
    suspend fun deleteLesson(lesson: Lesson) = lessonDao.deleteLesson(lesson)

    // Clubs
    suspend fun addClub(club: Club) = clubDao.insertClub(club)
    fun getTeacherClubs(teacherId: Int): LiveData<List<Club>> = clubDao.getClubsByTeacherId(teacherId)
    suspend fun updateClub(club: Club) = clubDao.updateClub(club)
    suspend fun deleteClub(club: Club) = clubDao.deleteClub(club)
    suspend fun addClubMember(clubMember: ClubMember) = clubMemberDao.insertClubMember(clubMember)
    fun getClubMembers(clubId: Int): LiveData<List<ClubMember>> = clubMemberDao.getClubMembers(clubId)

    // Competitions
    suspend fun addCompetition(competition: Competition) = competitionDao.insertCompetition(competition)
    fun getTeacherCompetitions(teacherId: Int): LiveData<List<Competition>> = competitionDao.getCompetitionsByTeacherId(teacherId)
    suspend fun updateCompetition(competition: Competition) = competitionDao.updateCompetition(competition)
    suspend fun deleteCompetition(competition: Competition) = competitionDao.deleteCompetition(competition)
    suspend fun addCompetitionParticipant(participant: CompetitionParticipant) = competitionParticipantDao.insertParticipant(participant)
    fun getCompetitionParticipants(competitionId: Int): LiveData<List<CompetitionParticipant>> = competitionParticipantDao.getCompetitionParticipants(competitionId)
}
