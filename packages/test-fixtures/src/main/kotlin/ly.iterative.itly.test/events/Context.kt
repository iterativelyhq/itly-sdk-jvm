package ly.iterative.itly.test.events

import ly.iterative.itly.Event

class Context(
    requiredString: String,
    optionalEnum: Context.OptionalEnum? = null
) : Event(
    "context",
    mapOf(
        *(if (optionalEnum != null) arrayOf("optionalEnum" to optionalEnum.value) else arrayOf()),
        "requiredString" to requiredString
    )
) {
    companion object {
        const val ERROR_MESSAGE_REQUIRED_STRING_MISSING = "Error validating 'context'. \$.requiredString: is missing but it is required."

        @JvmField
        val VALID_ONLY_REQUIRED_PROPS = Context(
            requiredString = "Required context string"
        )

        @JvmField
        val VALID_ALL_PROPS = Context(
            requiredString = "Required context string",
            optionalEnum = OptionalEnum.VALUE_1
        )

        @JvmField
        val INVALID_WITH_INVALID_PROPS = Event(
            name = "context",
            properties = mapOf("invalidProp" to true)
        )

        @JvmField
        val INVALID_NO_PROPS = Event(
            name = "context",
            properties = mapOf()
        )
    }
    enum class OptionalEnum(val value: String) {
        VALUE_1("Value 1"),
        VALUE_2("Value 2")
    }
}
