package com.sun.gamevui.data.model

import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "channel", strict = false)
data class RssChannel(
    @field:ElementList(name = "item", inline = true)
    var item: List<RssItem>? = null
)
