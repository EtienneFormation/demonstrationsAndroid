package eni.testskotlin

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import eni.testskotlin.room.bo.Personne
import eni.testskotlin.room.dao.AppDatabase
import eni.testskotlin.room.dao.PersonneDAO
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AppRoomTest {
    private lateinit var personneDao: PersonneDAO
    private lateinit var db: AppDatabase
    @Before
    @Throws(Exception::class)
    fun creerBdd()
    {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).allowMainThreadQueries().build()
        personneDao = db.personneDao()
    }
    @After
    fun deconnexionBdd()
    {
        db.close()
    }
    @Test
    fun insertions()
    {
        personneDao.insert(Personne(0, "Terieur", "Alex"))
        personneDao.insert(Personne(0, "Centrique", "Alex"))
        val personne = personneDao.get(1)
        Assert.assertEquals(personne.nom, "Terieur")
    }
}