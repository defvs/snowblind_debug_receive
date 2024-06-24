package events

enum class EventType(val type: Int) {
    NOTE_ON(0),
    NOTE_OFF(1),
    TRANSPORT(9),
    PARAM_VALUE(5);

    companion object {
        private val map = entries.associateBy(EventType::type)
        fun fromInt(type: Int) = map[type]
    }
}
