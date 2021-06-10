package com.sun.gamevui.data.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "rss", strict = false)
data class RssResponse(
    @field:Element(name = "channel")
    var channel: RssChannel? = null
)

