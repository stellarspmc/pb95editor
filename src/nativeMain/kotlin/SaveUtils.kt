import kotlinx.io.buffered
import kotlinx.io.files.*
import kotlinx.io.readByteArray
import kotlinx.io.writeString

private const val str = "891001agij-178thta-hj-yqqiqq0-uqiqy12-s-jhgjgkf23-ush-1223-vaba"

class SaveUtils {
	fun encrypt(readPath: Path, writePath: Path) {
	}

	fun decrypt(readPath: Path, writePath: Path) {
		if (readPath.toString().contains(Regex("txt$"))) {
			if (SystemFileSystem.exists(readPath)) {
				var data = ""
				SystemFileSystem.source(readPath).buffered().use { it.readByteArray().forEachIndexed { i, c -> data += ((c.toInt() and 0xFF) - str[i % str.length].code) % 256 } }
				SystemFileSystem.sink(writePath).buffered().use { it.writeString(data) }
			} else println("The file does not exist!")

		} else println("This is not a correct save file!")
	}
}

class SaveEditor