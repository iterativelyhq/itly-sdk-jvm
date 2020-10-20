package ly.iterative.itly

data class ValidationResponse @JvmOverloads constructor(
    val valid: Boolean,
    val message: String? = null,
    val pluginId: String? = null
)
