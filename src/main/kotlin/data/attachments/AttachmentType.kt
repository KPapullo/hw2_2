package data

import data.attachments.*

abstract class AttachmentType {
    open val type: String = ""
}

class AudioAttachment(val audio: Audio) : AttachmentType() {
    override val type: String = "audio"

}

class DocAttachment(val doc: Doc) : AttachmentType() {
    override val type: String = "doc"
}

class LinkAttachment(val link: Link) : AttachmentType() {
    override val type: String = "link"
}

class PhotoAttachment(val photo: Photo) : AttachmentType() {
    override val type: String = "photo"
}

class VideoAttachment(val video: Video) : AttachmentType() {
    override val type: String = "video"
}