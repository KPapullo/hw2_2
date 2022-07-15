package data.posts

import data.AttachmentType

data class Post(
    val id: Int = 0, //Идентификатор записи
    val ownerId: Int = 2, //Идентификатор владельца стены, на которой размещена запись
    var date: Int = 2022, //Время публикации записи в формате unixtime
    val text: String? = null, //Текст записи
   /* val createdBy: Int = 4, //Идентификатор администратора, который опубликовал запись
    val fromId: Int = 3, //Идентификатор автора записи (от чьего имени опубликована запись)
    val replyOwnerId: Int? = null, //Идентификатор владельца записи, в ответ на которую была оставлена текущая.
    val replyPostId: Int? = null, //Идентификатор записи, в ответ на которую была оставлена текущая
    val friendsOnly: Int? = null, //1, если запись была создана с опцией «Только для друзей»
    val comments: Comments? = null,//Информация о комментариях к записи, объект с полями:
    val copyright: Copyright? = null, //Источник материала, объект с полями:
    val likes: Likes? = null,//Информация о лайках к записи, объект с полями:
    val reposts: Reposts? = null,//Информация о репостах записи («Рассказать друзьям»), объект с полями:
    val views: Views? = null,//Информация о просмотрах записи. Объект с единственным полем:
    val postType: String, //Тип записи, может принимать следующие значения: post, copy, reply, postpone, suggest.
    val signerId: Int? = null, //Идентификатор автора, если запись была опубликована от имени сообщества и подписана пользователем

    val canPin: Boolean? = null, //Информация о том, может ли текущий пользователь закрепить запись
    val canDelete: Boolean? = null,//Информация о том, может ли текущий пользователь удалить запись
    val canEdit: Boolean? = null,//Информация о том, может ли текущий пользователь редактировать запись
    val isPinned: Int? = null,//Информация о том, что запись закреплена.
    val markedAsAds: Boolean? = null,//Информация о том, содержит ли запись отметку «реклама»
    val isFavorite: Boolean? = null,//true, если объект добавлен в закладки у текущего пользователя
    val donut: Donut? = null,//Информация о записи VK Donut:
    val postponedId: Int? = null,//Идентификатор отложенной записи. Это поле возвращается тогда, когда запись стояла на таймере.
    
    */
) {
    var attachment = emptyArray<AttachmentType>()

    object Wallservice {

        private var posts = emptyArray<Post>()
        private var comments = emptyArray<Comment>()

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
        fun createComment(comment: Comment): Boolean {
            for (post in posts) {
                if (post.id == comment.postId) {
                    comments += comment
                    return true
                }
            }
            throw PostNotFoundException("Пост с ID ${comment.postId} не найден")
        }
    }
}
