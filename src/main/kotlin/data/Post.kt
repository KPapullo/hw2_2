package data

data class Post(
    val id: Int = 0, //Идентификатор записи
    val ownerId: Int = 2, //Идентификатор владельца стены, на которой размещена запись
    var date: Int = 2022, //Время публикации записи в формате unixtime
    val text: String? = null, //Текст записи
) {
    object Wallservice {

        private var posts = emptyArray<Post>()

        private var postId = 1

        fun add(post: Post): Post {

            posts += post.copy(id = posts.size + 1)
            return posts.last()
        }
        fun update(post: Post): Boolean {
            for (cell in posts) {
                if (cell.id == post.id) {
                    posts[cell.id - 1] = post.copy(id = cell.id, ownerId = cell.ownerId, date = cell.date)
                    return true
                }
            }
            return false
        }
       /* fun update(postToUpdate: Post): Boolean {
            for ((index, post) in posts.withIndex()) {
                if (post.id == postToUpdate.id) {
                    posts[index] = postToUpdate.copy()
                }
                return true
            }
            return false
        }
*/
    }
}
