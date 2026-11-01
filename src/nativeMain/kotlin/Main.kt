import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
private data class Message(
    val topic: String,
    val content: String,
)

private val PrettyPrintJson = Json {
    prettyPrint = true
}

fun main(args: Array<String>) {
	when (args.size) {
		0 -> { /* ui / start program */ }
		1 -> {
			// args --help -h / --silent -s
		}
		else -> {
			// -i -o
		}
	}
}
