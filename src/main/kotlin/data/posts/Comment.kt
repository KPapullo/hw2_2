package data.posts

import data.AttachmentType

class Comment (
    val ownerId: Int,
    val postId: Int,
    val fromGroup: Int = 0,
    val message:String? = null,
    val replyToComment:Int? = null,
    var arrayAttachments: Array<AttachmentType>? = null,
    val stickerId:Int? = null,
    val guid:Int? = null
) {
}