import data.Post
import org.junit.Assert.*
import org.junit.Test

class WallserviceTest {

    private val post1 = Post(3, 4, 2022, "first post")
    private val post2 = Post(2, 876607, 2022, "second post")
    private val post3 = Post(4, 607, 2022, "third post")


    @Test

    fun checkIdFor0() {
        val service = Post.Wallservice
        val expected = 1
        val result = service.add(post1).id


        assertEquals(expected, result)
    }
    @Test
    fun updateExisting() {
        // создаём целевой сервис
        val service = Post.Wallservice
        // заполняем несколькими постами
        service.add(post1)
        service.add(post2)
        service.add(post3)
        // создаём информацию об обновлении
        val postUpdate = Post(3, 4, 2023, "updated post")

        // выполняем целевое действие
        val result = service.update(postUpdate)

        // проверяем результат (используйте assertTrue или assertFalse)
        assertTrue(result)
    }


    @Test
    fun updateNotExisting() {
        // создаём целевой сервис
        val service = Post.Wallservice
        // заполняем несколькими постами
        service.add(post1)
        service.add(post2)
        service.add(post3)
        // создаём информацию об обновлении
        val postUpdate = Post(55, 4, 2022, "updated post")

        // выполняем целевое действие
        val result = service.update(postUpdate)

        // проверяем результат (используйте assertTrue или assertFalse)
        assertFalse(result)
    }


}